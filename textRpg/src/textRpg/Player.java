package textRpg;

import java.util.ArrayList;
import java.util.Vector;

public class Player extends Unit {
	static Guild guild = new Guild();
	static Inventory inven = new Inventory();
	
	static int money;
	
	public Player() {
		
	}

	public Player(String name, int level, int hp, int power, int def, int exp) {
		super(name, level, hp, power, def, exp);
	}
	
	public void init() {
		guild.setGuild();
		money = 100000; // 플레이어의 초기 잔고 설정
	}

	@Override
	public void skill() {
		
	}
	
	public void inventoryMenu() {
		inven.inventoryMenu();
	}

	public void printStatus() {
		
	}
	
	public Vector<Player> getGuildList() {
		//return guild.guildList;
		return Guild.getGuildList();
	}
	
	public static ArrayList<Item> getItemList() {
		return inven.myItems;
	}
	
	public static Player getGuildUnit(int num) {
		return guild.getGuildUnit(num);
	}
	
	public int getItemSize() {
		return inven.myItems.size();
	}

	public static int getGuildSize() {
		//return Guild.guildList.size();
		return guild.getGuildSize();
	}

	public void guildMenu() {
		guild.guildMenu();
	}

}
