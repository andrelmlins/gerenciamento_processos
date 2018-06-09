import java.util.Random;

public class Peterson {
	public boolean[] flags = new boolean[5];
	public int turn = 0;
	public List list;
	
	public Peterson() {
		list = new List();
	}
	
	public void run() {
		for(int i=0; i<flags.length; i++) {
    		if(i>0) Utils.sleep();
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
	        		
	        		while(free(flag));

	        		try {
						list.addList("Processamento "+(flag+1));
					} catch (Exception e1) {
						Random r = new Random();
						try {
							list.removeList(r.nextInt(10));
							list.addList("Processamento "+(flag+1));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
	        		
	        		flags[flag] = false;
	        		Utils.sleep();
	        		
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
