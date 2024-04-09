package textRpg;

import java.util.ArrayList;
import java.util.Vector;

public class Inventory {
	ArrayList<Item> myItems = new ArrayList<>();
	ArrayList<Item> itemList;
	
//	public Inventory() {
//		Shop shop = new Shop();
//		itemList = shop.getItemList();
//		myItems = Player.getItemList();
//	}
	
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
		ShopManager shopManager = new ShopManager();
		shopManager.shopMenu();
	}
	
	public void equipItem() {
		// 장비를 착용할 길드원 선택
		Player.guild.printGuildList();
		System.out.println("아이템을 착용할 길드원 선택 [0.뒤로가기]");
		System.out.print(">> ");
		int unitNum = GameManager.scan.nextInt() - 1;
		
		Vector<Player> guildList = Player.guild.getGuildList();
		
		if(unitNum < 0 || unitNum >= guildList.size()) {
			System.out.println("유효하지 않은 길드원 번호입니다.");
			return;
		}
		
		if(unitNum == -1)
			return;
		
		// 착용할 아이템 선택
		printMyItems();
		
		System.out.println("착용할 아이템 번호 입력 [0.뒤로가기]");
		System.out.print(">> ");
		int sel = GameManager.scan.nextInt() - 1;
		
		if(sel < -1 || sel > myItems.size()) {
			System.out.println("유효하지 않은 아이템 번호입니다.");
			return;
		}
		
		if(sel == -1)
			return;
		
		if(itemList.get(sel).kind == Item.WEAPON) {
			if(Player.getGuildUnit(unitNum).weapon != null)
				itemList.add(Player.getGuildUnit(unitNum).weapon);
			Player.getGuildUnit(unitNum).weapon = itemList.get(sel);
		}
		else if(itemList.get(sel).kind == Item.ARMOUR) {
			if(Player.getGuildUnit(unitNum).armour != null)
				itemList.add(Player.getGuildUnit(unitNum).armour);
			Player.getGuildUnit(unitNum).armour = itemList.get(sel);
		}
		else if(itemList.get(sel).kind == Item.CLOTHES) {
			if(Player.getGuildUnit(unitNum).clothes != null)
				itemList.add(Player.getGuildUnit(unitNum).clothes);
			Player.getGuildUnit(unitNum).clothes = itemList.get(sel);
		}
		else if(itemList.get(sel).kind == Item.SHOES) {
			if(Player.getGuildUnit(unitNum).shoes != null)
				itemList.add(Player.getGuildUnit(unitNum).shoes);
			Player.getGuildUnit(unitNum).shoes = itemList.get(sel);
		}
		else if(itemList.get(sel).kind == Item.ACCESSORY) {
			if(Player.getGuildUnit(unitNum).accessory != null)
				itemList.add(Player.getGuildUnit(unitNum).accessory);
			Player.getGuildUnit(unitNum).accessory = itemList.get(sel);
		}
		
		// 착용한 아이템을 아이템리스트에서 삭제
		itemList.remove(sel);
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

	public void addItem(Item item) {
		myItems.add(item);
	}

}
