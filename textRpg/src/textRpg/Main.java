package textRpg;

public class Main {
	public static void main(String[] args) {
		GameManager gm = new GameManager();
		//StageBattle battle = new StageBattle();
		StageTitle game = new StageTitle();
		GameManager.instance.init();
		//AccountManager am = new AccountManager();
		UserManager um = new UserManager();
		
		while(true) {
			System.out.println("회원 " + um.getUserCount() + "명");
			System.out.println("log = " + gm.log);
			gm.printMenu();
			int select = gm.inputNumber("menu");
			
			if(select == 1 && gm.log == -1)
				gm.join();
			else if(select == 1 && gm.log != -1)
				gm.leave();
			else if(select == 2 && gm.log == -1)
				gm.login();
			else if(select == 2 && gm.log != -1)
				gm.logout();
			else if(select == 3 && gm.log == -1)
				gm.notLoginMessage();
			
			else if(select == 3 && gm.log != -1) {
				while(true) {
					boolean isStart = game.update();
					if(isStart) {
						break;
					}
				}
				
				while(true) {
					boolean isRun = GameManager.instance.changeStage();
					if(!isRun)
						break;
				}
				
				System.out.println("game over-");
			}
		}
		
	}

}
