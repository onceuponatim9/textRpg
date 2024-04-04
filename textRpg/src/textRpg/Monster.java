package textRpg;

public abstract class Monster {
	String name;
	int curhp;
	int maxhp;
	int power;
	
	Monster() {
		
	}
	
	Monster(String name, int max, int power) {
	    this.name = name;
	    this.curhp = max;
	    this.maxhp = max;
	    this.power = power;
	}
	
	void init(int max, int power) {
		this.curhp = max;
	    this.maxhp = max;
	    this.power = power;
	}
	
	void init(String name, int max, int power) {
		this.name = name;
	    this.curhp = max;
	    this.maxhp = max;
	    this.power = power;
	}
	
	public abstract void skill();

}
