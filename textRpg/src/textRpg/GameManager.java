package textRpg;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	static Scanner scan = new Scanner(System.in);
	static Random ran = new Random();
	
	static GameManager instance = new GameManager();
	StageTitle game = new StageTitle();
	
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	
	private Map<User, Player> map;
	private UserManager um = null;
	
	int log = -1;
	
	static String nextStage = "";
	String curStage = "";
	
	static boolean isRun = true;
	
	GameManager() {
		um = UserManager.getInstance();
		map = um.cloneMap();
	}
	
	public void init() {
		stageList.put("StageStart", new StageTitle());
		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("SETTING", new StageSetting());
		nextStage = "StageStart";
	}
	
	public boolean changeStage() {
		System.out.println("curStage : " + curStage);
		System.out.println("nextStage : " + nextStage);
		
//		if (curStage.equals(nextStage))
//			return true;
		
		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init(); // 초기화
		
		while(isRun) {
			boolean isUpdate = stage.update();
			if (!isUpdate)
				break;
		}
		
		if(!isRun)
			return false;
		
		if (nextStage.equals(""))
			return false;
		else
			return true;
	}
	
	public static int inputNumber() {
		int number = -1;
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch(Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		return number;
	}
	
	public void join() {
		String name = inputString("name : ");
		String id = inputString("id : ");
		String pw = inputString("pw : ");
		
		String userId = um.findUserId(id);
		
		if(userId != null) {
			System.out.println("이미 존재하는 아이디입니다.");
			return;
		}
		
		um.createUser(name, id, pw);
		
		System.out.println("회원가입 완료");
	}
	
	public void leave() {
		User user = um.getUserByLog(log);
		String pw = inputString("pw : ");
		
		if(!user.getPassword().equals(pw)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		
		um.removeUser(user);
		
		log = -1;
		System.out.println("회원탈퇴 완료");
	}
	
	public void login() {
		String id = inputString("id : ");
		String pw = inputString("pw : ");
		
		log = um.getUserLogByIdAndPassword(id, pw);
		
		if(log == -1) {
			System.out.println("로그인 정보가 일치하지 않습니다.");
			return;
		}
		
		System.out.println("로그인 성공");
	}
	
	public void logout() {
		log = -1;
		System.out.println("로그아웃 완료");
	}
	
	public void notLoginMessage() {
		System.out.println("로그인 후 게임 이용이 가능합니다.");
	}
	
	public boolean isStart() {
		while(true) {
			boolean isStart = game.update();
			if(isStart)
				break;
		}
		return true;
	}
	
	public int inputNumber(String message) {
		int number = -1;
		try {
			System.out.print(message + " : ");
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch(Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		
		return number;
	}
	
	public String inputString(String message) {
		System.out.print(message);
		return scan.next();
	}
	
	public void printMenu() {
		System.out.printf("[1] %s\n", log == -1 ? "회원가입" : "탈퇴");
		System.out.printf("[2] %s\n", log == -1 ? "로그인" : "로그아웃");
		if(log != -1)
			System.out.println("[3] 게임 시작");
	}
	
}
