package textRpg;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("[시작]을 입력하세요");
		String start = GameManager.scan.next();
		
		if(start.equals("시작")) {
			GameManager.nextStage = "LOBBY";
			return true;
		}
		
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
