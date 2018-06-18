import Comunicacao.Monitor;
import Escalonamento.RRLoteria;
import Escalonamento.RoundRobin;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//(new Peterson()).run();
		//(new Monitor()).run();
		//(new RoundRobin()).run();		
		//(new RRLoteria()).run();
		RRLoteria r = new RRLoteria();
		r.teste();
		r.run();
		
	}

}
