import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Game {
	public static void main (String args[]){
		Room room1 = new Room("Room 1");
		Room room2 = new Room("Room 2");
		Room room3 = new Room("Room 3");
		Room room4 = new Room("Room 4");
		Room room5 = new Room("Room 5");
		Room room6 = new Room("Room 6");
		Room room7 = new Room("Room 7");
		Room room8 = new Room("Room 8");
		Room room9 = new Room("Room 9");
		Room room10 = new Room("Room 10");
		Door door1 = new Door(room1.NorthWall, room2.SouthWall);
		Door door2 = new Door(room1.SouthWall, room3.NorthWall);
		Door door3 = new Door(room1.EastWall, room4.WestWall);
		Door door4 = new Door(room4.SouthWall, room5.NorthWall);
		Door door5 = new Door(room2.EastWall, room8.WestWall);
		Door door6 = new Door(room8.EastWall, room9.WestWall);
		Door door7 = new Door(room9.EastWall, room10.WestWall);
		Door door8 = new Door(room3.SouthWall, room6.NorthWall);
		Door door9 = new Door(room6.WestWall, room7.EastWall);
		
		Character character = new Character();
		character.Location = room1;
		
		while (true){
			String input = Input.getInput();
			System.out.println(input);
			
			if(input.equals("quit")){
				break;
			}
			
			String[] parts = input.split(" ");
			
			//TODO handle case when a noun is not provided.
			String verb = parts[0];
			String noun = parts[1];
			
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
			
			else{
				System.out.println("Not a valid command.");
			}
		}
		
		System.out.println("Goodbye");
	}
	
	private static void handleGo(Room currentLocation, Character character, Wall wall){
		if(wall.Door != null){
			Room newLocation = wall.Door.Wall1.Room != currentLocation ? 
					wall.Door.Wall1.Room : 
					wall.Door.Wall2.Room;
			character.Location = newLocation;
			System.out.println("You're in " + newLocation.Description);
		}
		else{
			System.out.println("You can't go that way.");
		}
	}
}