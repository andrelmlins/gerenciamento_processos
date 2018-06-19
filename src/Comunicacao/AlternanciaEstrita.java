package Comunicacao;

import java.util.Random;

import Auxiliar.Utils;

public class AlternanciaEstrita {
	
	private int turn;
	private int qtdProcessos;
	private List list;
	private Random r = new Random();
	
	public AlternanciaEstrita(){
		turn = 1;
		qtdProcessos = 5;
		list = new List();
	}
	
	public void run() {
		System.out.println("Iniciando simulação de alternancia estrita");
		for(int i=0; i<qtdProcessos; i++) {
			if(i>0) Utils.sleep();
			process(i);
		}		
	}
	
	public void process(final int flag) {
	    new Thread(new Runnable() {
	        @Override
	        public void run() {	        	
	        	while(true) {
	        		//System.out.println("flag "+flag);
	        		while(turn != flag+1){}
	        		try {
	        			System.out.println("Entrou! "+flag);
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
	        			System.out.println("hue");
	        			turn = 1;
	        		}
	        		else {
	        			//System.out.println("++");
	        			turn++;	        			
	        		}
	        		System.out.println("Turn: "+turn);
	        	}
	        }
	    }, "Processador "+flag).start();	    
	    
    }

}
