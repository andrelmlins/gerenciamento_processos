import java.util.ArrayList;

public class List {
	public int sizeList = 10;
	public ArrayList<String> list;
	
	public List() {
		this.list = new ArrayList<>();
	}
	
	public void addList(String item) throws Exception {
		if(this.list.size()<this.sizeList) list.add(item);
		else throw new Exception("Lista cheia!");
		print();
	}
	
	public void removeList(int index, int flag) throws Exception {
		if(index==flag) throw new Exception("O índice "+index+" já existe!");
		
		if(this.list.size()>0 && index<=this.list.size()) list.remove(index);
		else if(index>this.list.size()) throw new Exception("Item "+index+" não existe!");
		else throw new Exception("Lista vazia!");
		print();
	}
	
	public void print() {
		System.out.println("Count: "+this.list.size()+" - List: "+this.list);
	}
}
