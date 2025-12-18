import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Prontuario {

	private String nomePaciente;
	private Internacao internacao;
	private Set<Procedimento> procedimentos = new HashSet<>();

	public Prontuario(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getNomePaciente() {
		return this.nomePaciente;
	}

	public void setInternacao(Internacao internacao) {
		this.internacao = internacao;
	}

	public Internacao getInternacao() {
		return this.internacao;
	}

	public void addProcedimento(Procedimento procedimento) {
		this.procedimentos.add(procedimento);
	}

	public Set<Procedimento> getProcedimentos() {
		return this.procedimentos;
	}

	// Delega para CalculadoraConta
	public String imprimaConta() {
		CalculadoraConta calculadora = new CalculadoraConta();
		return calculadora.imprimaConta(this);
	}

	// Delega para ProntuarioRepository
	public Prontuario carregueProntuario(String arquivoCsv) throws IOException {
		ProntuarioRepository repository = new ProntuarioRepository();
		return repository.carregueProntuario(arquivoCsv);
	}

	// Delega para ProntuarioWriter
	public String salveProntuario() throws IOException {
		ProntuarioWriter writer = new ProntuarioWriter();
		return writer.salveProntuario(this);
	}
}