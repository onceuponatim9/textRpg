package textRpg;

import java.util.Vector;

public class Guild {
	private final int PARTY_SIZE = 3;
	private UserManager um = UserManager.getInstance();
	//Vector<Player> guildList = new Vector<>();
	static Vector<Player> guildList = null;
	Unit[] partyList;
	
	public Guild() {
		guildList = UserManager.getGuildListByUser(GameManager.curUser);
	}
	
	public void setGuild() {
		// name, level, hp, power, def, exp
//		if(guildList.size() > 0)
//			return;
		
		if(guildList == null)
			guildList = new Vector<Player>();
		else if(guildList.size() >= PARTY_SIZE)
			return;
		
		for(int i = 0; i < PARTY_SIZE; i++) {
			int level = UnitManager.ran.nextInt(5) + 5;
			int hp = 100 * level + 50;
			int power = hp / 10 - 15;
			int def = 30;
			guildList.add(new Player(getName(), level, hp, power, def, 0));
			guildList.get(i).party = true;
			
//			if(guildList.size() == 3)
//			break;
		}
		
		partyList = new Unit[PARTY_SIZE];
		
		int idx = 0;
		for(int i = 0; i < guildList.size(); i++) {
			if(guildList.get(i).party)
				partyList[idx++] = guildList.get(i);
		}
	}
	
	public Player getGuildUnit(int num) {
		return guildList.get(num);
	}
	
	public static Vector<Player> getGuildList() {
		return guildList;
	}
	
	public int getGuildSize() {
		return guildList.size();
	}
	
	public void guildMenu() {
		while(true) {
			System.out.println("=============== [길드 관리] ================");
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
	
	public void printGuildList() {
		if(guildList == null) {
			System.out.println("길드원이 존재하지 않습니다.");
			return;
		}
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
			System.out.println("[골드 : " + guildList.get(i).money + "]");
		}
		System.out.println("======================================");
	}
	
	private void printParty() {
		if(partyList == null) {
			System.out.println("파티원이 존재하지 않습니다.");
			return;
		}
		System.out.println("============= [파티원] =================");
		for(int i = 0; i < partyList.length; i++) {
			System.out.println("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + partyList[i].name + "]");
			System.out.print(" [레벨 : " + partyList[i].level + "]");
			System.out.print(" [체력 : " + partyList[i].curHp);
			System.out.println(" / " + partyList[i].maxHp + "]");
			System.out.print("[공격력 : " + partyList[i].power + "]");
			System.out.print(" [방어력 : " + partyList[i].def + "]");
			System.out.println(" [파티중 : " + partyList[i].party + "]");
		}
		System.out.println("======================================");
	}
	
	private String[] getNameList() {
		// nameList 만들기
		String[] nameList = {"Aaron", "Chris", "Grace", "Emma",
				"Uli", "Barbara", "John", "Victor",
				"Amber", "Willie", "Aspen", "Linda",
				"Mckenzie", "Quincy", "Rylie", "Sasha",
				"Paige", "Madison", "Liam", "Hans",
				"Irina", "Anastasha", "Chev", "Marko",
				"Valarie", "Sinbad", "Kharl", "Taran", // 28
				"Addison", "Hanson", "Billie", "Blade",
				"Brighton", "Devon", "Klaus", "Nichole",
				"Sylvia", "Lauren", "Diana", "Kennice", // 40
				"Graham", "Albert", "Giselle", "Kyler",
				"Millie", "Tim", "Taylor", "Richard",
				"Joseph", "Robinson", "Whitney", "Joyce",
				"Peter", "Ellie", "Paul", "Stephanie",
				"Benjamin", "Jimmy", "Jessie", "James",
				"Charles", "Daniel", "Marie", "Sandra",
				"Ashley", "Emily", "Angela", "Brenda",
				"Amy", "Sharon", "Laura", "Noah",
				"Mason", "Natalie", "Steven", "Emily",
				"Mark", "Marcus", "Romeo", "Juliet", // 80
				"Julia", "Tracy", "Ryott", "Scarlet",
				"Lydia", "Dahlia", "Chloe", "Britney",
				"Brooke", "James", "Boris", "Ivanka",
				"Aurora", "Alina", "Justin", "Alisa",
				"Lucin", "Jack", "Henry", "Anders" // 100
		};
		
		return nameList;
	}
	
	private String getName() {
		String[] nameList = getNameList();
		String name = "";
		int size = nameList.length;
		int rIdx = -1;
		
		while(true) {
			rIdx = UnitManager.ran.nextInt(size);
			boolean isDupl = false;
			for(int i = 0; i < UserManager.getUserCount(); i++) {
				User temp = um.getUserByLog(i);
				Vector<Player> list = UserManager.getGuildListByUser(temp);
				for(int j = 0; j < list.size(); j++) {
					if(nameList[rIdx].equals(list.get(j).name))
						isDupl = true;
				}
			}
//			for(int i = 0; i < guildList.size(); i++) {
//				if(nameList[rIdx].equals(guildList.get(i).name))
//					isDupl = true;
//			}
			
			if(!isDupl) {
				name = nameList[rIdx];
				break;
			}
		}
		
		return name;
	}
	
	private void addUnit() {
		if(Player.money < 8000) {
			System.out.println("골드가 부족합니다.");
			return;
		}
		
		// 길드원 추가하기
		String name = getName();
		int level = 1;
		int rNum = UnitManager.ran.nextInt(8) + 1;
		int hp = 50 * rNum + 50;
		int power = hp / 10;
		int def = hp / 20;
		
		Player temp = new Player(name, level, hp, power, def, 0);
		
		System.out.println("=====================================");
	    System.out.print("[이름 : " + name + "]");
	    System.out.print(" [레벨 : " + level + "]");
	    System.out.print(" [체력 : " + hp);
	    System.out.println(" / " + hp + "]");
	    System.out.print("[공격력 : " + power + "]");
	    System.out.println(" [방어력 : " + def + "]");
	    System.out.println("길드원을 추가합니다.");
	    System.out.println("=====================================");
	    
	    try {
	    	Thread.sleep(500);
	    } catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    
	    guildList.add(temp);
	    Player.money -= 8000;
	}
	
	private void removeUnit() {
		if(guildList == null) {
			System.out.println("길드원이 존재하지 않습니다.");
			return;
		}
		
		printGuildList();
		System.out.print("Player number to remove >> ");
	    int sel = GameManager.scan.nextInt() - 1;
	    
	    if(sel < 0 || sel >= guildList.size()) {
	    	System.out.println("유효하지 않은 길드원 번호입니다.");
	    	return;
	    }
	    
	    if(guildList.get(sel).party) {
	    	System.out.println("파티 중인 길드원은 삭제할 수 없습니다.");
	    	return;
	    }
	    
	    String name = guildList.get(sel).name;
	    System.out.println("선택한 길드원 [" + name + "]를 삭제합니다.");
	    
	    try {
	    	Thread.sleep(500);
	    } catch(InterruptedException e) {
	    	e.printStackTrace();
	    }
	    
	    guildList.remove(sel);
	}
	
	private void changeParty() {
		if(guildList == null) {
			System.out.println("길드원이 존재하지 않습니다.");
			return;
		}
		
		printParty();
		System.out.print("Player number to change >> ");
		int num = GameManager.scan.nextInt() - 1;
		
		if(num < 0 || num >= guildList.size()) {
			System.out.println("유효하지 않은 파티원 번호입니다.");
			return;
		}
		
		printGuildList();
		System.out.print("Player number to attend the party >> ");
		int newNum = GameManager.scan.nextInt() - 1;
		
		if(newNum < 0 || newNum >= guildList.size()) {
			System.out.println("유효하지 않은 길드원 번호입니다.");
			return;
		}
		
		partyList[num].party = false;
		guildList.get(newNum).party = true;
		
		int idx = 0;
		for(int i = 0; i < guildList.size(); i++) {
			if(guildList.get(i).party)
				partyList[idx++] = guildList.get(i);
		}
		
		try {
			Thread.sleep(500);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("====================================");
		System.out.print("길드원 [" + partyList[num].name + "]");
		System.out.print("를 [" + guildList.get(newNum).name + "]");
		System.out.println("으로 교체 합니다.");
		System.out.println("====================================");
	}
	
	private void sortUnit() {
		if(guildList == null) {
			System.out.println("길드원이 존재하지 않습니다.");
			return;
		}
		
		for(int i = 0; i < guildList.size(); i++) {
			Player temp = guildList.get(i);
			int idx = i;
			
			for(int j = i; j < guildList.size(); j++) {
				if(temp.level < guildList.get(j).level) {
					temp = guildList.get(j);
					idx = j;
				}
			}
			
			Player temp2 = guildList.get(idx);
			guildList.set(idx, guildList.get(i));
			guildList.set(i, temp2);
		}
		
		System.out.println("길드원 정렬이 완료되었습니다.");
	}
	
}
