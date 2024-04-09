package textRpg;

import java.util.ArrayList;

public class ShopManager {
	Shop shop;
	ArrayList<Item> itemList;
	
	public ShopManager() {
		shop = new Shop();
		itemList = shop.getItemList();
	}
	
	public void shopMenu() {
		while(true) {
			System.out.println("=============== [상점] ===============");
			System.out.println("[1.무기] [2.갑옷] [3.옷] [4.신발] [5.악세서리] [0.뒤로가기]");
			int kind = GameManager.scan.nextInt();
			
			if(kind == 0)
				return;
			
			while(true) {
				if(kind == Item.WEAPON) {
					System.out.println("=========== [무기] ============");
					
				} else if(kind == Item.ARMOUR) {
					System.out.println("=========== [갑옷] ============");
					
				} else if(kind == Item.CLOTHES) {
					System.out.println("============ [옷] ============");
					
				} else if(kind == Item.SHOES) {
					System.out.println("=========== [신발] ============");
					
				} else if(kind == Item.ACCESSORY) {
					System.out.println("========== [악세서리] ==========");
					
				} else if(kind == 0) {
					break;
					
				} else {
					continue;
				}
				
				printItems(kind);
				System.out.println("------------------------------------");
				System.out.println("[골드 : " + Player.money + "]");
				System.out.println("구입할 아이템 번호를 입력하세요 [0.뒤로가기]");
				int num = GameManager.scan.nextInt();
				
				if(num == 0)
					break;
				
				int count = 0;
				for(int i = 0; i < itemList.size(); i++) {
					if(itemList.get(i).kind == kind) {
						count++;
						
						if(count == num) {
							Player.inven.addItem(itemList.get(i));
							Player.money -= itemList.get(i).price;
							System.out.println("[" + itemList.get(i).name + "]을 구입했습니다.");
							try {
								Thread.sleep(500);
							} catch(InterruptedException e) {
								e.printStackTrace();
							}
							break;
						}
					}
				}
				
			}
		}
	}
	
	public void printItems(int kind) {
		int count = 0;
		
		for(int i = 0; i < shop.itemList.size(); i++) {
			if(itemList.get(i).kind != kind)
				continue;
			System.out.println("[" + (count + 1) + "번] ");
			System.out.println("[이름 : " + itemList.get(i).name + "] ");
			System.out.println("[능력 : " + itemList.get(i).power + "] ");
			System.out.println("[가격 : " + itemList.get(i).price + "] ");
			System.out.println();
			count++;
		}
	}

}
