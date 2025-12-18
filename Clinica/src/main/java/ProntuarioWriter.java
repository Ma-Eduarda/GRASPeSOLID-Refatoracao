import java.io.IOException;
import java.nio.file.Files;
import java.nio.file. Path;
import java.nio. file.Paths;
import java.util.ArrayList;
import java.util. Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ProntuarioWriter {

	public String salveProntuario(Prontuario prontuario) throws IOException {
		List<String> linhas = new ArrayList<>();

		linhas.add("nome_paciente,tipo_leito,qtde_dias_internacao,tipo_procedimento,qtde_procedimentos");

		String nomePaciente = prontuario. getNomePaciente();
		String linhaPaciente = nomePaciente + ",";

		Internacao internacao = prontuario.getInternacao();
		if (internacao != null) {
			linhaPaciente += internacao.getTipoLeito() + "," + internacao. getQtdeDias() + ",,";
			linhas. add(linhaPaciente);
		}

		Set<Procedimento> procedimentos = prontuario.getProcedimentos();
		if (procedimentos.size() > 0) {
			Map<TipoProcedimento, Long> procedimentosAgrupados = procedimentos.stream().collect(
					Collectors. groupingBy(Procedimento:: getTipoProcedimento, Collectors.counting()));

			List<TipoProcedimento> procedimentosOrdenados = new ArrayList<>(procedimentosAgrupados.keySet());
			Collections.sort(procedimentosOrdenados);

			for (TipoProcedimento chave : procedimentosOrdenados) {
				String linhaProcedimento = nomePaciente + ",,," + chave + "," + procedimentosAgrupados.get(chave);
				linhas.add(linhaProcedimento);
			}
		}

		if (linhas.size() == 1) {
			linhaPaciente += ",,,";
			linhas.add(linhaPaciente);
		}

		Path path = Paths. get(nomePaciente. replaceAll(" ", "_")
				.concat(String.valueOf(System.currentTimeMillis()))
				.concat(".csv"));

		Files.write(path, linhas);

		return path.toString();
	}
}