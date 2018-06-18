package Escalonamento;

import java.util.ArrayList;
import java.util.Random;

import Auxiliar.Utils;

public class RRLoteria {		
	private ArrayList<Processo> processos;
	private int qtdProcessos;
	private int maiorPrioridade;
	private int menorPrioridade;
	private int mediaPrioridade;
	
	public RRLoteria(){
		this.processos = new ArrayList<Processo>();
		this.qtdProcessos = 10;
		this.maiorPrioridade = 3;
		this.mediaPrioridade = 2;
		this.menorPrioridade = 1;
		
		Random r = new Random();
		Processo p;
		int aux = 0;
		for(int i=0; i<this.qtdProcessos; i++) {
			
			int random = r.nextInt(25)+5;
			p = new Processo(i,random,random);
			if(i>=0 && i<3){//define processos com maior prioridade
				int j;
				for(j=aux;j<aux+maiorPrioridade;j++){
					p.addBilhete(j);
				}
				aux = j;
			}else if(i>=3 && i<6){//define processos com menor prioridade
				int j;
				for(j=aux;j<aux+menorPrioridade;j++){
					p.addBilhete(j);
				}
				aux = j;				
			}else if(i>=6 && i<qtdProcessos){
				int j;
				for(j=aux;j<aux+mediaPrioridade;j++){
					p.addBilhete(j);					
				}
				aux = j;
			}
			processos.add(p);			
		}
	}
	
	public void teste(){
		for(int i=0;i<processos.size();i++){
			System.out.println(processos.get(i).tooString());
		}
	}
	
	public void run(){
		System.out.println("Execução RR com Loteria");
		while(processos.size()>0) {
			Random r = new Random();
			int bilhete = r.nextInt(20);
			System.out.println("Bilhete sorteado: "+bilhete);
			
			for(int i=0;i<processos.size();i++){
				
				if(processos.get(i).temBilhete(bilhete)){
					
					if(processos.get(i).getDuracaorestante()==0) {
						System.out.println("Processo encerrado: "+processos.get(i));
						processos.remove(processos.get(i));
						break;
					}else{
						System.out.println("Processo em execução: "+processos.get(i));
						Utils.sleep();
						processos.get(i).setDuracaorestante(processos.get(i).getDuracaorestante()-5);
						if(processos.get(i).getDuracaorestante() <= 0){
							System.out.println("Processo encerrado: "+processos.get(i));
							processos.remove(processos.get(i));
						}
					}					
				}				
			}	
		}	
		System.out.println("Todos os processos foram encerrados");
	}
}
