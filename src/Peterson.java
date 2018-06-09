import java.util.Random;

public class Peterson {
	private boolean[] flags = new boolean[5];
	private int turn = 0;
	private List list;
	private Random r = new Random();
	
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
						try {
							list.removeList(r.nextInt(10),flag);
							list.addList("Processamento "+(flag+1));
						} catch (Exception e) {
							break;
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
