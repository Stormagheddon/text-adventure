import java.util.ArrayList;

public class Game {
	public static void main (String args[]){
		Item key1 = new Item("Key", "Iron Key");
		Item key2 = new Item("Key", "Rusty Key");
		Room room1 = new Room("The Courtyard");
		Room room2 = new Room("The south end of the Main Hall");
		Room room3 = new Room("The Library");
		Room room4 = new Room("Hidden Room");
		Room room5 = new Room("The Basement");
		Room room6 = new Room("The north end of the Main Hall");
		Room room7 = new Room("Room 7");
		Room room8 = new Room("Room 8");
		Room room9 = new Room("Room 9");
		Room room10 = new Room("Room 10");
		Room room11 = new Room("Room 11");
		Room room12 = new Room("Room 12");
		Door door1 = new Door(room1.NorthWall, room2.SouthWall, key1);
		Door door2 = new Door(room2.EastWall, room9.WestWall, key2);
		Door door3 = new Door(room2.WestWall, room3.EastWall);
		Door door4 = new Door(room4.EastWall, room3.WestWall);
		Door door5 = new Door(room4.NorthWall, room5.SouthWall);
		Door door6 = new Door(room2.NorthWall, room6.SouthWall);
		Door door7 = new Door(room6.EastWall, room8.WestWall);
		Door door8 = new Door(room9.EastWall, room10.WestWall);
		Door door9 = new Door(room6.WestWall, room7.EastWall);
		Door door10 = new Door(room10.SouthWall, room11.NorthWall);
		Door door11 = new Door(room11.EastWall, room12.WestWall);
		
		room1.Ground.add(key1);
		room1.Ground.add(new Item("Sword", "Sword"));
		room1.Ground.add(new Item("Lantern", "Lantern"));
		room1.Ground.add(new Item("Scroll", "Scroll"));
		room2.Ground.add(key2);
		
		Character character = new Character();
		character.Location = room1;
		
		System.out.println("Welcome to the game!");
		System.out.println("Type 'help' to see the commands.");
		System.out.println("You are in the Courtyard.");
		
		while (true){
			String input = Input.getInput();
			System.out.println(input);
			
			if(input.equals("quit")){
				break;
			}
			
			else if(input.equals("help")){
				System.out.println("The command for moving is 'Go (direction)'");
				System.out.println("The command to look is 'Look (item)'");
			}
			
			else if(input.equals("inventory")){
				if(character.Inventory.size() > 0){
					System.out.println("Your current inventory: ");
					for(int counter = 0; counter < character.Inventory.size(); counter++){
						Item item = (Item)character.Inventory.get(counter);
						System.out.println(item.Type + " - " + item.name);
					}
				}
				else{
					System.out.println("You don't have any items");
				}
			}
			
			else{
				//String[] parts = input.indexOf(' ');
			
				//TODO handle case when a noun is not provided.
				//String verb = parts[0];
				//String noun = parts[1];
			
				//Finding the first space
				int firstSpace = input.indexOf(' ');
				String verb = input.substring(0, firstSpace);
				String noun = input.substring(firstSpace + 1, input.length());
				
				if(verb.equals("go")){
					Room currentLocation = character.Location;
				
					if(noun.equals("north")){
						handleGo(currentLocation, character, currentLocation.NorthWall);
					}
					else if(noun.equals("south")){
						handleGo(currentLocation, character, currentLocation.SouthWall);	
					}
					else if(noun.equals("west")){
						handleGo(currentLocation, character, currentLocation.WestWall);
					}
					else if(noun.equals("east")){
						handleGo(currentLocation, character, currentLocation.EastWall);
					}
					else{
						System.out.println("You can't go that way.");
					}
					
				}
			
				else if(verb.equals("look")){
				
					if(noun.equals("room")){
						System.out.println("This is a room.");
					}
				}
				
				else if(verb.equals("get")){
					handleGet(character, noun);
				}
							
				else if(verb.equals("drop")){
					handleDrop(character, noun);
				}
				
				else{
					System.out.println("Not a valid command.");
				}
			}
		}
		
		System.out.println("Goodbye");
	}
	
	private static void handleGo(Room currentLocation, Character character, Wall wall){
		if(wall.Door != null){
			boolean allowMove = true;
					
			if(wall.Door.Key != null && wall.Door.isLocked){
				Item item = null;
				for(int counter = 0; counter < character.Inventory.size(); counter++){
					item = (Item)character.Inventory.get(counter);
					if(item.Type.toLowerCase().equals("key") && item == wall.Door.Key){
						break;
					}
					else{
						item = null;
					}
				}
				
				if(item != null){
					wall.Door.isLocked = false;
					System.out.println("You unlocked the door.");
				}
				else{
					allowMove = false;
					System.out.println("The door is locked.");
				}
			}
			
			if(allowMove){
				Room newLocation = wall.Door.Wall1.Room != currentLocation ? 
						wall.Door.Wall1.Room : 
						wall.Door.Wall2.Room;
				character.Location = newLocation;
				System.out.println("You're in " + newLocation.Description + ".");
			}
		}
		else{
			System.out.println("You can't go that way.");
		}
	}
	
	private static void handleDrop(Character character, String itemName){
		// This will drop an item from the characters inventory
		// Will first find the item in the inventory
		// Then will move the item from the inventory to the ground.
	
		Item item = null;
		
		for(int counter = 0; counter < character.Inventory.size(); counter++){
			item = (Item)character.Inventory.get(counter);
			if(item.name.toLowerCase().equals(itemName)){
				break;
			}
			else{
				item = null;
			}
		}
		if(item != null){
			character.Inventory.remove(item);
			character.Location.Ground.add(item);
			System.out.println("You dropped: " + item.name);
		}
		else{
			System.out.println("You don't have that item.");
		}
	}
	
	private static void handleGet(Character character, String itemName){
		Item item = null;
		
		for(int counter = 0; counter < character.Location.Ground.size(); counter++){
			item = (Item)character.Location.Ground.get(counter);
			if(item.name.toLowerCase().equals(itemName)){
				break;
			}
			else{
				item = null;
			}
		}
		if(item != null){
			character.Location.Ground.remove(item);	
			character.Inventory.add(item);
			System.out.println("You picked up: " + item.name);
		}
		else{
			System.out.println("You didn't find: " + itemName);
		}
	}
}