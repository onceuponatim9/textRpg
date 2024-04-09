package textRpg;

import java.util.Vector;

public class StageBattle extends Stage {
	UnitManager um = null;
	Vector<Monster> monsterList = null;
	
	int monsterDead = 0;
	int playerDead = 0;
	
	boolean isBattle = false;
	boolean isTurn = true;
	
	//Player player = new Player();
	
	public StageBattle() {
		um = UnitManager.instance;
	}
	
	@Override
	public void init() {
		um.monsterList.clear();
		um.makeMonsters();
		//um.player = null;
		//um.player = new Player();
		Guild.guildList = UserManager.getGuildListByUser(GameManager.curUser);
		monsterList = null;
		monsterList = um.monsterList;
	}
	
	public void printAll() {
		System.out.println("======[BATTLE]======");
		System.out.println("[name] [curhp/maxhp] [power]");
		
		System.out.println("======[PLAYER]======");
		for(int i = 0; i < Player.getGuildSize(); i++) {
			if(Player.getGuildUnit(i).curHp > 0)
				Player.getGuildUnit(i).printData();
		}
		System.out.println("======[MONSTER]======");
		for(int i = 0; i < monsterList.size(); i++) {
			if(monsterList.get(i).curHp > 0)
				monsterList.get(i).printData();
		}
		System.out.println("=====================");
	}
	
	public int attackByPlayer(int index) {
		Player p = Player.getGuildUnit(index);
		if(p.curHp <= 0)
			return 0;
		
		int sel = 0;
		
		while(true) {
			System.out.println("[" + p.name + "] [1.어택] [2.스킬] [3.도망가기]");
			System.out.print("메뉴 선택 >> ");
			sel = GameManager.inputNumber();
			
			if(sel < 1 || sel > 3)
				continue;
			else
				break;
		}
		
		// player가 moster 공격
		if(sel == 1) {
			int idx = GameManager.ran.nextInt(monsterList.size());
			if(monsterList.get(idx).curHp > 0) {
				p.attack(monsterList.get(idx));
			}
			
		} else if(sel == 2) {
			useSkill(p);
			//p.skill();
			
		} else if(sel == 3) {
			System.out.println("적들로부터 도망쳤습니다.");
			isBattle = false;
		}
		
		return sel;
		
	}
	
	public void attackByMonster(int index) {
		Monster m = monsterList.get(index);
		if(m.curHp <= 0)
			return;
		
		int mNum = GameManager.ran.nextInt(5);
		if(mNum == 0) {
			m.skill();
			return;
		}
		
		// monster가 player 공격
		int idx = GameManager.ran.nextInt(Player.getGuildSize());
		
		if(Player.getGuildUnit(idx).curHp > 0) {
			m.attack(Player.getGuildUnit(idx));
		}
		
		
	}
	
	public void checkAlive() {
		playerDead = 0;
		monsterDead = 0;
		for(int i = 0; i < Player.getGuildSize(); i++) {
			Player p = Player.getGuildUnit(i);
			if(p.curHp <= 0)
				playerDead++;
		}
		for(int i = 0; i < monsterList.size(); i++) {
			Monster m = monsterList.get(i);
			if(m.curHp <= 0)
				monsterDead++;
		}
	}
	
	public void useSkill(Player player) {
		System.out.println(player.name + "는 방패 스킬을 썼다!!!");
	}

	@Override
	public boolean update() {
		int idx1 = 0;
		int idx2 = 0;
		isBattle = true;
		isTurn = true;
		
		while(isBattle) {
			if(isTurn) {
				printAll();
				if(idx1 < Player.getGuildSize()) {
					int n = attackByPlayer(idx1++);
					if(n == 2)
						continue;
					else
						isTurn = false;
					
				} else {
					idx1 = 0;
					isTurn = false;
				}
				
			} else {
				// 한 마리씩 차례대로 공격
				if(idx2 < monsterList.size()) {
					attackByMonster(idx2++);
				} else {
					idx2 = 0;
					
				}
				isTurn = true;
			}
			// player와 monster 생존자 점검
			checkAlive();
			// player와 monster 중에 하나라도 전멸하면
			if(playerDead == Player.getGuildSize() || monsterDead == monsterList.size()) {
				printWinner();
				//GameManager.isRun = false;
				break;
			}
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}
	
	private void printWinner() {
		if(playerDead == Player.getGuildSize())
			System.err.println("monster들에게 졌습니다.");
		else
			System.err.println("monster를 모두 처치했다!!!");
	}

}