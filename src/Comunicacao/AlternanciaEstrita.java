package Comunicacao;

import java.util.Random;

import Auxiliar.Utils;

public class AlternanciaEstrita {
	
	private int turn;
	private int qtdProcessos;
	private List list;
	private Random r = new Random();
	
	public AlternanciaEstrita(){
		turn = 0;
		qtdProcessos = 5;
		list = new List();
	}
	
	public void run() {
		System.out.println("Iniciando simulação de alternancia estrita");
		for(int i=0; i<qtdProcessos; i++) {
			if(i>0) Utils.sleep();
			process(i);
		}
		System.out.println("Fim");
	}
	
	public void process(final int flag) {
	    new Thread(new Runnable() {
	        @Override
	        public void run() {	        	
	        	while(true) {
	        		while(turn != flag);
	        		try {
						list.addList("Processamento "+(flag+1));
					} catch (Exception e1) {
						try {
							list.removeList(r.nextInt(10),flag);
							list.addList("Processamento "+(flag+1));
						} catch (Exception e) {
							break;
						}
					}
	        		Utils.sleep();
	        		if(turn == qtdProcessos){	        			
	        			turn = 0;
	        		}
	        		else {
	        			turn++;	        			
	        		}
	        	}
	        }
	    }, "Processador "+flag).start();	    
	    
    }

}
