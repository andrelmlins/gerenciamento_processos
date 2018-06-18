package Escalonamento;

import java.util.ArrayList;

public class Processo {
	private int id;
	private int duracao;
	private int duracaorestante;
	private ArrayList<Integer> bilhetes;
	
	public Processo(int id, int duracao, int duracaorestante) {
		super();
		this.id = id;
		this.duracao = duracao;
		this.duracaorestante = duracaorestante;
		this.bilhetes = new ArrayList<Integer>();
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
	
	public void addBilhete(int numeroBilhete){
		this.bilhetes.add(numeroBilhete);
	}
	
	public boolean temBilhete(int numeroBilhete){
		for(int i:this.bilhetes){
			if(i == numeroBilhete){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Processo [id=" + id + ", duracao=" + duracao + ", duracaorestante=" + duracaorestante + "]";
	}
	
	public String tooString(){
		return "Processo [id=" + id + "] Bilhetes: "+bilhetes.toString();
	}
}
