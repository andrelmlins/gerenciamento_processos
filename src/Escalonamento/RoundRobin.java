package Escalonamento;

import java.util.ArrayList;
import java.util.Random;

import Auxiliar.Utils;

public class RoundRobin {
	private int quantum = 2;
    private ArrayList<Processo> processos;
    private int quantProcessos;
    
	public RoundRobin() {
		this.processos = new ArrayList<Processo>();
		this.quantProcessos = 10;
		
		Random r = new Random();
		for(int i=0; i<this.quantProcessos; i++) {
			int random = r.nextInt(12)+1;
			this.processos.add(new Processo(i+1,random,random));
		}
	}
	
	public void run() {
		while(processos.size()>0) {
			for(int i=0;i<processos.size();i++) {
				System.out.println("Processo em execução: "+processos.get(i));
				
				int quantumaux = 0;
				
				if(processos.get(i).getDuracaorestante()==0) {
					System.out.println("Processo encerrado: "+processos.get(i));
					processos.remove(processos.get(i));
					break;
				}
				
				for(int j=0; j<processos.get(i).getDuracaorestante(); j++) {
					quantumaux++;
					
					if(quantumaux<=quantum) {
						Utils.sleep();
						processos.get(i).setDuracaorestante(processos.get(i).getDuracaorestante()-1);
					} else break;
					
					if(processos.get(i).getDuracaorestante()==0) {
						System.out.println("Processo encerrado: "+processos.get(i));
						processos.remove(processos.get(i));
						break;
					}
				}
			}
		}
	}
}
