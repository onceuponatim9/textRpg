package textRpg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class UserManager {
	private final static Map<User, Vector<Player>> map = new HashMap<User, Vector<Player>>();
	
	public UserManager() {
		
	}
	
	private static UserManager instance = new UserManager();
	public static UserManager getInstance() {
		return instance;
	}
	
	public Map<User, Vector<Player>> cloneMap() {
		return map;
	}
	
	public User createUser(String name, String id, String password) {
		User user = new User(name, id, password);
		System.out.println("new User 완료");
//		Player player = new Player();
//		player.init();
//		UnitManager.instance.init();
		Guild guild = new Guild();
		guild.setGuild();
		Vector<Player> guildList = Guild.getGuildList();
		
		map.put(user, guildList);
		sortByName();
		for(int i = 0; i < guildList.size(); i++) {
			System.out.println(guildList.get(i).name);
		}
		return user.clone();
	}
	
//	public void setGuildList(Vector<Player> guildList, Vector<Player> list) {
//		//guildList = getGuildListByUser(user);
//		guildList = list;
//	}
	
	public void sortByName() {
		List keySet = new ArrayList(map.keySet());
		Collections.sort(keySet, Comparator.comparing(User::getId));
	}
	
	public void removeUser(User user) {
		map.remove(user);
	}
	
	public String findUserId(String id) {
		for (User user : map.keySet()) {
			if (user.getId().equals(id))
				return user.getId();
		}
		return null;
	}
	
	public User findUserById(String id) {
		for (User user : map.keySet()) {
			if(user.getId().equals(id))
				return user;
		}
		return null;
	}
	
	public User getUserByLog(int log) {
		ArrayList<User> users = new ArrayList<User>();
		for (User user : map.keySet()) {
			users.add(user);
		}
		
		for(int i = 0; i < getUserCount(); i++) {
			User user = users.get(i);
			if(users.get(log).getId().equals(user.getId()))
				return user;
		}
		return null;
	}
	
	public int getUserLogByIdAndPassword(String id, String password) {
		int log = -1;
		int n = 0;
		for (User user : map.keySet()) {
			if(user.getId().equals(id) && user.getPassword().equals(password))
				log = n;
			n++;
		}
		return log;
	}
	
	public static Vector<Player> getGuildListByUser(User user) {
		Vector<Player> guildList = map.get(user);
		return guildList;
	}
	
	public static int getUserCount() {
		return map.size();
	}
	
}
