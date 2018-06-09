package Comunicacao;
import java.util.Random;

import Auxiliar.Utils;

public class Monitor {
	public List list;
	
	public Monitor() {
		list = new List();
	}
	
	public void add(String item) throws Exception {
		synchronized(this) {
			list.addList(item);
		}
	}
	
	public void remove(int index, int flag) throws Exception {
		synchronized(this) {
			list.removeList(index, flag);
		}
	}
	
	public void run() {
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
						add("Processamento "+ (flag+1));
						Thread.sleep(5000);
					} catch (Exception e) {
						Random r = new Random();
						try {
							remove(r.nextInt(10),flag);
							add("Processamento "+ (flag+1));
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
