package textRpg;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	static Random ran = new Random();
	
	private final int MONSTER_SIZE = 3;
	
	Vector<Player> playerList = new Vector<>();
	Vector<Unit> monsterList = new Vector<>();
	
	String path = "textRpg.";
	String[] allMonsters = {"MonsterWolf", "MonsterGhost", "MonsterBear", "MonsterLion", "MonsterDragon"};
	String[] monsters;
	
	Player player = new Player();
	
	public UnitManager() {
		
	}
	
	public void init() {
		player.init();
	}
	
	public Vector<Player> getPlayerList() {
		return this.playerList;
	}
	
	public Vector<Unit> getMonsterList() {
		return this.monsterList;
	}
	
	public void setMonsters() {
		monsters = new String[MONSTER_SIZE];
		
		for(int i = 0; i < monsters.length; i++) {
			int rNum = ran.nextInt(allMonsters.length);
			String name = allMonsters[rNum];
			
			for(int j = 0; j < i; j++) {
				if(monsters[j].equals(name))
					break;
			}
			monsters[i] = name;
		}
	}
	
	public void makeMonsters() {
		setMonsters();
		
		for(int i = 0; i < monsters.length; i++) {
			try {
				Class<?> clazz = Class.forName(path + monsters[i]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				
				int hp = ran.nextInt(150) + 100;
				int power = ran.nextInt(20) + 10;
				
				// 새로운 몬스터 생성
				Unit temp = (Unit) obj;
				String name = temp.name;
				temp.init(name, hp, power);
				monsterList.add(temp);
				
			} catch (Exception e) {
				System.out.println("몬스터 생성 실패");
			}
			// 잘 만들어졌는지 검사
			//monsterList.get(i).printData();
		}
	}

}
