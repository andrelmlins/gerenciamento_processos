
public class Peterson {
	public boolean[] flags = new boolean[5];
	public int turn = 0;
	
	
	public void run() {
		
		for(int i=0; i<flags.length; i++) {
    		try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			process(i);
		}
	}
	
	public void process(final int flag) {
	    new Thread(new Runnable() {
	        @Override
	        public void run() {
	        	while(true) {
	        		flags[flag] = true;
	        		turn = flag;
	        		
	        		while(free(flag)) {
	        			
	        		}

	        		System.out.println("Processamento "+(flag+1));
	        		flags[flag] = false;
	        		
	        		try {
	    				Thread.sleep(5000);
	    			} catch (InterruptedException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	        	}
	        }
	    }, "Processador "+flag).start();
    }
	
	public boolean free(int flag) {
		for(int i=0; i<this.flags.length; i++) {
			if(flag!=i && this.flags[i] && this.turn==i) return true;
		}
		return false;
	}
}
