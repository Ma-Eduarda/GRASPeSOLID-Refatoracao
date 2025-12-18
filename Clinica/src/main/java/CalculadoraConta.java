import java.text.NumberFormat;
import java.util.Set;

public class CalculadoraConta {

	public String imprimaConta(Prontuario prontuario) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();

		String conta = "----------------------------------------------------------------------------------------------";

		float valorDiarias = calcularValorDiarias(prontuario. getInternacao());
		
		ResultadoProcedimentos resultadoProc = calcularValorProcedimentos(prontuario.getProcedimentos());
		float valorTotalProcedimentos = resultadoProc.valorTotal;
		int qtdeProcedimentosBasicos = resultadoProc. qtdeBasicos;
		int qtdeProcedimentosComuns = resultadoProc.qtdeComuns;
		int qtdeProcedimentosAvancados = resultadoProc.qtdeAvancados;

		conta += "\nA conta do(a) paciente " + prontuario.getNomePaciente() + " tem valor total de __ " 
				+ formatter.format(valorDiarias + valorTotalProcedimentos) + " __";
		conta += "\n\nConforme os detalhes abaixo: ";

		Internacao internacao = prontuario.getInternacao();
		if (internacao != null) {
			conta += "\n\nValor Total Diárias:\t\t\t" + formatter.format(valorDiarias);
			conta += "\n\t\t\t\t\t" + internacao.getQtdeDias() + " diária" + (internacao.getQtdeDias() > 1 ? "s" : "")
					+ " em " + (internacao.getTipoLeito() == TipoLeito.APARTAMENTO ? "apartamento" : "enfermaria");
		}

		Set<Procedimento> procedimentos = prontuario.getProcedimentos();
		if (procedimentos. size() > 0) {
			conta += "\n\nValor Total Procedimentos:\t\t" + formatter.format(valorTotalProcedimentos);

			if (qtdeProcedimentosBasicos > 0) {
				conta += "\n\t\t\t\t\t" + qtdeProcedimentosBasicos + " procedimento" + (qtdeProcedimentosBasicos > 1 ? "s" : "")
						+ " básico" + (qtdeProcedimentosBasicos > 1 ? "s" : "");
			}

			if (qtdeProcedimentosComuns > 0) {
				conta += "\n\t\t\t\t\t" + qtdeProcedimentosComuns + " procedimento" + (qtdeProcedimentosComuns > 1 ? "s" : "")
						+ " comu" + (qtdeProcedimentosComuns > 1 ? "ns" : "m");
			}

			if (qtdeProcedimentosAvancados > 0) {
				conta += "\n\t\t\t\t\t" + qtdeProcedimentosAvancados + " procedimento" + (qtdeProcedimentosAvancados > 1 ? "s" : "")
						+ " avançado" + (qtdeProcedimentosAvancados > 1 ?  "s" : "");
			}
		}

		conta += "\n\nVolte sempre, a casa é sua! ";
		conta += "\n----------------------------------------------------------------------------------------------";

		return conta;
	}

	private float calcularValorDiarias(Internacao internacao) {
		float valorDiarias = 0.0f;

		if (internacao != null) {
			switch (internacao. getTipoLeito()) {
				case ENFERMARIA:
					if (internacao.getQtdeDias() <= 3) {
						valorDiarias += 40.00 * internacao.getQtdeDias();
					} else if (internacao.getQtdeDias() <= 8) {
						valorDiarias += 35.00 * internacao.getQtdeDias();
					} else {
						valorDiarias += 30.00 * internacao.getQtdeDias();
					}
					break;
				case APARTAMENTO:
					if (internacao.getQtdeDias() <= 3) {
						valorDiarias += 100.00 * internacao.getQtdeDias();
					} else if (internacao.getQtdeDias() <= 8) {
						valorDiarias += 90.00 * internacao.getQtdeDias();
					} else {
						valorDiarias += 80.00 * internacao.getQtdeDias();
					}
					break;
			}
		}

		return valorDiarias;
	}

	private ResultadoProcedimentos calcularValorProcedimentos(Set<Procedimento> procedimentos) {
		ResultadoProcedimentos resultado = new ResultadoProcedimentos();

		for (Procedimento procedimento : procedimentos) {
			switch (procedimento.getTipoProcedimento()) {
				case BASICO:
					resultado.qtdeBasicos++;
					resultado.valorTotal += 50.00;
					break;

				case COMUM:
					resultado.qtdeComuns++;
					resultado.valorTotal += 150.00;
					break;

				case AVANCADO: 
					resultado.qtdeAvancados++;
					resultado.valorTotal += 500.00;
					break;
			}
		}

		return resultado;
	}

	private static class ResultadoProcedimentos {
		float valorTotal = 0.0f;
		int qtdeBasicos = 0;
		int qtdeComuns = 0;
		int qtdeAvancados = 0;
	}
}