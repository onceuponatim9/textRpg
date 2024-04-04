package textRpg;

public class StageSetting extends Stage {
	UnitManager um = null;
	Shop shop;

	@Override
	public boolean update() {
		while(true) {
			System.out.println("=============== [메인메뉴] ================");
			System.out.println("[1.길드관리]\t\t[2.상점]\t\t[3.인벤토리]");
			System.out.println("[4.저장]\t\t[5.로드]\t\t[0.종료]");
			int sel = GameManager.scan.nextInt();
			
			if(sel == 1) {
				
			} else if(sel == 2) {
				
			} else if(sel == 3) {
				
			} else if(sel == 4) {
				
			} else if(sel == 5) {
				
			} else if(sel == 0) {
				GameManager.nextStage = "";
				break;
				
			} else {
				continue;
			}
		}
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
