package textRpg;

public class Item {
	final static int WEAPON = 1;
	final static int ACCESSORY = 2;
	final static int CLOTHES = 3;
	final static int ARMOUR = 4;
	final static int SHOES = 5;
	
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
