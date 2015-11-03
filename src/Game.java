import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Game {
	public static void main (String args[]){
		Room room1 = new Room();
		Room room2 = new Room();
		Room room3 = new Room();
		Room room4 = new Room();
		Room room5 = new Room();
		Room room6 = new Room();
		Room room7 = new Room();
		Room room8 = new Room();
		Room room9 = new Room();
		Room room10 = new Room();
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
		
		String command = null;
		while (!Objects.equals(command, "quit")) {
			command = readLine("Enter Command: ");
			if (Objects.equals(command, "quit")) {
				printf("Goodbye!");
			} else {
				printf(command);
			}
		}
	}
	
	private static void printf(String format, Object...args) {
        Console c = System.console();
        if (c != null) {
             c.printf(format + "\n", args);
        } else {
    		System.out.printf(format + "\n", args);
        }
	}
	
	private static String readLine(String prompt) {
        String line = null;
        Console c = System.console();
        if (c != null) {
             line = c.readLine(prompt);
        } else {
            System.out.print(prompt);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                 line = bufferedReader.readLine();
            } catch (IOException e) { 
                //Ignore    
            }
        }
        return line;
    }
}