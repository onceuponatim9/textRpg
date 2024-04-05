package textRpg;

import java.util.ArrayList;

public class Inventory {
	ArrayList<Item> myItems = new ArrayList<>();
	ArrayList<Item> itemList;
	
	public Inventory() {
		Shop shop = new Shop();
		itemList = shop.getItemList();
	}
	
	public void inventoryMenu() {
		while(true) {
			System.out.println("============ [인벤토리 메뉴] =============");
			System.out.println("[1.구매] [2.착용] [3.판매] [0.뒤로가기]");
			System.out.print(">> ");
			int sel = GameManager.scan.nextInt();
			
			if(sel == 1) {
				buyItem();
			} else if(sel == 2) {
				equipItem();
				
			} else if(sel == 3) {
				sellItem();
				
			} else if(sel == 0) {
				break;
			}
		}
	}
	
	public void buyItem() {
		
	}
	
	public void equipItem() {
		
	}
	
	public void sellItem() {
		printMyItems();
		
		System.out.println("[골드 : " + Player.money + "]");
		System.out.println("판매할 아이템 번호 입력 [0.뒤로가기]");
		System.out.print(">> ");
		int sel = GameManager.scan.nextInt() - 1;
		
		if(sel < -1 || sel > myItems.size()) {
			System.out.println("유효하지 않은 아이템 번호입니다.");
			return;
		}
		
		if(sel == -1)
			return;
		
		Player.money += myItems.get(sel).price;
		myItems.remove(sel);
	}
	
	private void printMyItems() {
		for(int i = 0; i < myItems.size(); i++) {
			System.out.println("[" + (i + 1) + "번] ");
			System.out.println("[이름 : " + myItems.get(i).name + "] ");
			System.out.println("[능력 : " + myItems.get(i).power + "] ");
			System.out.println("[가격 : " + myItems.get(i).price + "] ");
			System.out.println();
		}
	}

}
