package Comunicacao;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import Auxiliar.Utils;

public class Semaforo {
	
	public AtomicInteger valor;
	public List fila;
	
	public Semaforo(){
		valor = new AtomicInteger(1);
		fila = new List();
	}
	
	public void p(String item) throws Exception{
		if(! valor.compareAndSet(1, 0)) block(item);
	}
	
	public void v(int index, int flag) throws Exception{
		if(! fila.list.isEmpty()) unblock(index, flag);
		else valor.set(1);
	}
	
	public void block(String item) throws Exception{		
		fila.addList(item);
	}
	
	public void unblock(int index, int flag) throws Exception{
		fila.removeList(index, flag);
	}
	
	public void run(){
		for(int i=0; i<5; i++) {
			if(i>0) Utils.sleep();
			process(i);
		}
	}
	
	public void process(int flag) {
		new Thread(new Runnable() {
	        @Override
	        public void run() {
	        	while(true) {
	        		try {
						p("Processamento "+ (flag+1));
						Thread.sleep(5000);
					} catch (Exception e) {
						Random r = new Random();
						try {
							v(r.nextInt(10),flag);
							p("Processamento "+ (flag+1));
						} catch (Exception e1) {
							break;
						}
					}
	        		Utils.sleep();
	        	}
	        }
	    }, "Processador "+flag).start();
	}

}
