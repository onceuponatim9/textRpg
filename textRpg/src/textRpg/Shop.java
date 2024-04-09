package textRpg;

import java.util.ArrayList;

public class Shop {
	ArrayList<Item> itemList = new ArrayList<>();
	
	public Shop() {
		// Weapon
		Item item = new Item();
		item.kind = Item.WEAPON;
		item.name = "Bomb";
		item.power = 10;
		item.price = 5000;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.WEAPON;
		item.name = "Diamond Sword";
		item.power = 9;
		item.price = 4500;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.WEAPON;
		item.name = "Tungsten Sword";
		item.power = 8;
		item.price = 4000;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.WEAPON;
		item.name = "Steel Sword";
		item.power = 7;
		item.price = 3000;
		itemList.add(item);
		
		// Armour
		item = new Item();
		item.kind = Item.ARMOUR;
		item.name = "Diamond Armour";
		item.power = 9;
		item.price = 4000;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.ARMOUR;
		item.name = "Tungsten Armour";
		item.power = 8;
		item.price = 3500;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.ARMOUR;
		item.name = "Steel Armour";
		item.power = 7;
		item.price = 3000;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.ARMOUR;
		item.name = "Titanum Armour";
		item.power = 6;
		item.price = 2700;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.ARMOUR;
		item.name = "Leather Armour";
		item.power = 5;
		item.price = 2450;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.ARMOUR;
		item.name = "Plastic Armour";
		item.power = 4;
		item.price = 2000;
		itemList.add(item);
		
		// Clothes
		item = new Item();
		item.kind = Item.CLOTHES;
		item.name = "Red T-shirts";
		item.power = 1;
		item.price = 500;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.CLOTHES;
		item.name = "Blue T-shirts";
		item.power = 1;
		item.price = 500;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.CLOTHES;
		item.name = "Green T-shirts";
		item.power = 1;
		item.price = 500;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.CLOTHES;
		item.name = "Black T-shirts";
		item.power = 1;
		item.price = 500;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.CLOTHES;
		item.name = "White T-shirts";
		item.power = 1;
		item.price = 500;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.CLOTHES;
		item.name = "Pink Suit";
		item.power = 2;
		item.price = 1150;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.CLOTHES;
		item.name = "Orange Suit";
		item.power = 2;
		item.price = 1150;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.CLOTHES;
		item.name = "Khaki Suit";
		item.power = 2;
		item.price = 1150;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.CLOTHES;
		item.name = "Black Pants";
		item.power = 1;
		item.price = 500;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.CLOTHES;
		item.name = "White Pants";
		item.power = 1;
		item.price = 500;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.CLOTHES;
		item.name = "Brown Pants";
		item.power = 1;
		item.price = 500;
		itemList.add(item);
		
		// Shoes
		item = new Item();
		item.kind = Item.SHOES;
		item.name = "Boots";
		item.power = 3;
		item.price = 2000;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.SHOES;
		item.name = "Running Shoes";
		item.power = 3;
		item.price = 1700;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.SHOES;
		item.name = "Leather Shoes";
		item.power = 2;
		item.price = 1500;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.SHOES;
		item.name = "Sneakers";
		item.power = 2;
		item.price = 1350;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.SHOES;
		item.name = "Rubber Shoes";
		item.power = 1;
		item.price = 1000;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.SHOES;
		item.name = "Sandals";
		item.power = 1;
		item.price = 750;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.SHOES;
		item.name = "Slippers";
		item.power = 1;
		item.price = 500;
		itemList.add(item);
		
		// Accessory
		item = new Item();
		item.kind = Item.ACCESSORY;
		item.name = "Gold Ring";
		item.power = 1;
		item.price = 2000;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.ACCESSORY;
		item.name = "Silver Ring";
		item.power = 1;
		item.price = 1000;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.ACCESSORY;
		item.name = "Pearl Necklace";
		item.power = 1;
		item.price = 1000;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.ACCESSORY;
		item.name = "Ruby Necklace";
		item.power = 1;
		item.price = 3000;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.ACCESSORY;
		item.name = "Emerald Necklace";
		item.power = 1;
		item.price = 4000;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.ACCESSORY;
		item.name = "Sapphire Necklace";
		item.power = 1;
		item.price = 3500;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.ACCESSORY;
		item.name = "Black Gloves";
		item.power = 1;
		item.price = 1000;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.ACCESSORY;
		item.name = "White Gloves";
		item.power = 1;
		item.price = 1000;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.ACCESSORY;
		item.name = "Red Gloves";
		item.power = 1;
		item.price = 1000;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.ACCESSORY;
		item.name = "Blue Gloves";
		item.power = 1;
		item.price = 1000;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.ACCESSORY;
		item.name = "Pink Gloves";
		item.power = 1;
		item.price = 1000;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.ACCESSORY;
		item.name = "Glitter Gloves";
		item.power = 1;
		item.price = 2000;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.ACCESSORY;
		item.name = "Black Belt";
		item.power = 1;
		item.price = 1000;
		itemList.add(item);
		
		item = new Item();
		item.kind = Item.ACCESSORY;
		item.name = "Brown Belt";
		item.power = 1;
		item.price = 1000;
		itemList.add(item);
		
	}
	
	public ArrayList<Item> getItemList() {
		return this.itemList;
	}

}
