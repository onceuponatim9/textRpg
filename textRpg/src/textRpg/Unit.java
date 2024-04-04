package textRpg;

public abstract class Unit {
	String name; // 이름
	int level; // 레벨
	int curHp; // 현재 HP
	int maxHp; // 최대 HP
	int power; // 공격
	int def; // 방어
	int exp; // 경험치
	boolean party; // 파티 가입 여부
	Item weapon; // 무기
	Item armor; // 갑옷
	Item ring; // 장신구
	int money;
	
	public Unit() {
		
	}
	
	public Unit(String name, int level, int hp, int power, int def, int exp) {
		this.name = name;
		this.level = level;
		this.maxHp = hp;
		this.curHp = maxHp;
		this.power = power;
		this.def = def;
		this.exp = exp;
		party = false;
		weapon = null;
		armor = null;
		ring = null;
	}
	
	public void init(String name, int hp, int power) {
		// TODO Auto-generated method stub
		
	}
	
	public void attack(Monster unit) {
		unit.curhp -= power;
		System.out.println("[" + name + "]이 " + "[" + unit.name + "]에게 " + power + "의 데미지를 입힙니다.");
		
		if(unit.curhp <= 0) {
			unit.curhp = 0;
			System.out.println("[" + unit.name + "]을 처치했습니다.");
		}
	}
	
	public abstract void skill();
	
	public void printData() {
		System.out.println("[" + name + "] [" + curHp + "/" + maxHp + "] [" + power + "]");
	}

}
