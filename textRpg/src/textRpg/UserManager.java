package textRpg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
	private static final Map<User, Player> map = new HashMap<User, Player>();
	
	public UserManager() {
		
	}
	
	private static UserManager instance = new UserManager();
	public static UserManager getInstance() {
		return instance;
	}
	
	public Map cloneMap() {
		return map;
	}
	
	public User createUser(String name, String id, String password) {
		User user = new User(name, id, password);
		Player player = new Player();
		map.put(user, player);
		return user.clone();
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
	
	public int getUserCount() {
		return this.map.size();
	}
	
}
