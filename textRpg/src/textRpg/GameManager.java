package textRpg;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	static Scanner scan = new Scanner(System.in);
	static Random ran = new Random();
	
	static GameManager instance = new GameManager();
	
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	
	static String nextStage = "";
	String curStage = "";
	
	static boolean isRun = true;
	
	GameManager() {
		
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

}
