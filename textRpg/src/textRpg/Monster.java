package textRpg;

public abstract class Monster {
	String name;
	int curHp;
	int maxHp;
	int power;
	
	Monster() {
		
	}
	
	Monster(String name, int max, int power) {
	    this.name = name;
	    this.curHp = max;
	    this.maxHp = max;
	    this.power = power;
	}
	
	void init(int max, int power) {
		this.curHp = max;
	    this.maxHp = max;
	    this.power = power;
	}
	
	void init(String name, int max, int power) {
		this.name = name;
	    this.curHp = max;
	    this.maxHp = max;
	    this.power = power;
	}
	
	public abstract void skill();
	
	public void attack(Player unit) {
		unit.curHp -= power;
		System.out.println("[" + name + "]이 " + "[" + unit.name + "]에게 " + power + "의 데미지를 입힙니다.");
		
		if(unit.curHp <= 0) {
			unit.curHp = 0;
			System.out.println("[" + unit.name + "]을 처치했습니다.");
		}
	}
	
	public void printData() {
		System.out.println("[" + name + "] [" + curHp + "/" + maxHp + "] [" + power + "]");
	}
	
}
