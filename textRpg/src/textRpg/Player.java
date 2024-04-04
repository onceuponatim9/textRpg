package textRpg;

public class Player extends Unit {
	static Guild guild = new Guild();
	static Inventory inven = new Inventory();
	
	static int money;
	
	public Player() {
		
	}

	public Player(String name, int level, int hp, int power, int def, int exp) {
		super(name, level, hp, power, def, exp);
		// TODO Auto-generated constructor stub
	}
	
	public void init() {
		guild.setGuild();
		money = 100000; // 플레이어의 초기 잔고 설정
	}

	@Override
	public void skill() {
		// TODO Auto-generated method stub
		
	}
	
	public void inventoryMenu() {
		inven.inventoryMenu();
	}

	public void printStatus() {
		// TODO Auto-generated method stub
		
	}

}
