package textRpg;

import java.util.Vector;

public class Guild {
	private final int PARTY_SIZE = 3;
	Vector<Player> guildList = new Vector<>();
	Unit[] partyList;
	
	public void setGuild() {
		// name, level, hp, power, def, exp
		guildList.add(new Player("name1", 9, 900, 50, 30, 0));
		guildList.add(new Player("name2", 8, 800, 60, 30, 0));
		guildList.add(new Player("name3", 7, 700, 70, 30, 0));
		guildList.add(new Player("name4", 6, 600, 80, 30, 0));
		guildList.add(new Player("name5", 5, 500, 90, 30, 0));
		
		partyList = new Unit[PARTY_SIZE];
		
		for(int i = 0; i < PARTY_SIZE; i++) {
			int rIdx = UnitManager.ran.nextInt(PARTY_SIZE);
			for(int j = 0; j < i; j++) {
				if(guildList.get(j).party)
					i--;
			}
			guildList.get(rIdx).party = true;
			partyList[i] = guildList.get(i);
		}
	}
	
	public Player getGuildUnit(int num) {
		return guildList.get(num);
	}
	
	public void guildMenu() {
		while(true) {
			System.out.println("=============== [길드관리] ================");
			System.out.println("[1.길드 목록]\t\t[2.길드원 추가]\t\t[3.길드원 삭제]");
			System.out.println("[4.파티원 교체]\t\t[5.정렬]\t\t\t[0.뒤로가기]");
			int sel = GameManager.scan.nextInt();
			
			if(sel == 1) {
				printGuildList();
				
			} else if(sel == 2) {
				addUnit();
				
			} else if(sel == 3) {
				removeUnit();
				
			} else if(sel == 4) {
				changeParty();
				
			} else if(sel == 5) {
				sortUnit();
				
			} else if(sel == 0) {
				break;
				
			} else {
				continue;
			}
		}
	}
	
	private void printGuildStatus(int index) {
		// TODO Auto-generated method stub
		guildList.get(index).printStatus();
	}
	
	private void printGuildList() {
		System.out.println("============= [길드원] =================");
		for(int i = 0; i < guildList.size(); i++) {
			System.out.println("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + guildList.get(i).name + "]");
			System.out.print(" [레벨 : " + guildList.get(i).level + "]");
			System.out.print(" [체력 : " + guildList.get(i).curHp);
			System.out.println(" / " + guildList.get(i).maxHp + "]");
			System.out.print("[공격력 : " + guildList.get(i).power + "]");
			System.out.print(" [방어력 : " + guildList.get(i).def + "]");
			System.out.println(" [파티중 : " + guildList.get(i).party + "]");
		}
		System.out.println("======================================");
	}
	
	private void addUnit() {
		// TODO Auto-generated method stub
		
	}
	
	private void removeUnit() {
		// TODO Auto-generated method stub
		
	}
	
	private void changeParty() {
		// TODO Auto-generated method stub
		
	}
	private void sortUnit() {
		// TODO Auto-generated method stub
		
	}
	
}
