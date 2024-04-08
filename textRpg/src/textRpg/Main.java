package textRpg;

public class Main {
	public static void main(String[] args) {
		//GameManager gm = new GameManager();
		//StageBattle battle = new StageBattle();
		StageTitle game = new StageTitle();
		GameManager.instance.init();
		
		// 게임 시작
		while(true) {
			boolean isStart = game.update();
			if(isStart) {
				break;
			}
		}
		
		// 게임 진행
		while(true) {
			boolean isRun = GameManager.instance.changeStage();
			if(!isRun)
				break;
		}
		
		System.out.println("game over-");
	}

}
