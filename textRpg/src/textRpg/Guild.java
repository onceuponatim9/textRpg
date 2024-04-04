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
	
	Player getGuildUnit(int num) {
		return guildList.get(num);
	}

}
