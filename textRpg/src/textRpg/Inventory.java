package textRpg;

public class Inventory {
	public void inventoryMenu() {
		while(true) {
			System.out.println("============ [인벤토리 메뉴] =============");
			System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
			int sel = GameManager.scan.nextInt();
			
			if(sel == 1) {
				
			} else if(sel == 2) {
				
			} else if(sel == 3) {
				break;
			}
		}
	}

}
