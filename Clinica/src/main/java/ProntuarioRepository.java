import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java. util. stream.Stream;

public class ProntuarioRepository {

	public Prontuario carregueProntuario(String arquivoCsv) throws IOException {
		Path path = Paths.get(arquivoCsv);

		boolean primeiraLinha = true;
		Prontuario prontuario = null;
		String nomePacienteAtual = null;

		try (Stream<String> linhas = Files.lines(path)) {
			for (String str : (Iterable<String>) linhas::iterator) {
				if (primeiraLinha) {
					primeiraLinha = false;
					continue;
				}

				System.out.println(str);

				String[] dados = str.split(",");

				if (dados.length < 1) {
					continue;
				}

				String nomePaciente = dados[0]. trim();

				if (prontuario == null) {
					prontuario = new Prontuario(nomePaciente);
					nomePacienteAtual = nomePaciente;
				}

				if (! nomePaciente.equals(nomePacienteAtual)) {
					continue;
				}

				// Processa internação
				if (dados.length >= 3 && dados[1] != null && !dados[1].trim().isEmpty()) {
					try {
						TipoLeito tipoLeito = TipoLeito.valueOf(dados[1].trim());
						int qtdeDiasInternacao = Integer.parseInt(dados[2].trim());
						
						if (prontuario.getInternacao() == null) {
							prontuario.setInternacao(new Internacao(tipoLeito, qtdeDiasInternacao));
						}
					} catch (IllegalArgumentException e) {
						System.err.println("Erro ao processar internação:  " + e.getMessage());
					}
				}

				// Processa procedimentos 
				if (dados.length >= 5 && dados[3] != null && !dados[3].trim().isEmpty()) {
					try {
						TipoProcedimento tipoProcedimento = TipoProcedimento.valueOf(dados[3].trim());
						int qtdeProcedimentos = Integer.parseInt(dados[4].trim());
						
						for (int i = 0; i < qtdeProcedimentos; i++) {
							prontuario.addProcedimento(new Procedimento(tipoProcedimento));
						}
					} catch (IllegalArgumentException e) {
						System.err.println("Erro ao processar procedimentos:  " + e.getMessage());
					}
				}
			}
		}

		if (prontuario == null) {
			throw new IOException("Arquivo CSV vazio ou inválido");
		}

		return prontuario;
	}
}