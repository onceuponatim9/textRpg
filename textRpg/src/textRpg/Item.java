package textRpg;

public class Item {
	int kind;
	String name;
	int power;
	int price;
	
	public void setItem(int k, String n, int p, int pr) {
		this.kind = k;
		this.name = n;
		this.power = p;
		this.price = pr;
	}

}
