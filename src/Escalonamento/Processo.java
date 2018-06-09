package Escalonamento;

public class Processo {
	private int id;
	private int duracao;
	private int duracaorestante;
	
	public Processo(int id, int duracao, int duracaorestante) {
		super();
		this.id = id;
		this.duracao = duracao;
		this.duracaorestante = duracaorestante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getDuracaorestante() {
		return duracaorestante;
	}

	public void setDuracaorestante(int duracaorestante) {
		this.duracaorestante = duracaorestante;
	}

	@Override
	public String toString() {
		return "Processo [id=" + id + ", duracao=" + duracao + ", duracaorestante=" + duracaorestante + "]";
	}
}
