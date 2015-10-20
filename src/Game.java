
public class Game {
	public static void main (String args[]){
		Room room1 = new Room();
		Room room2 = new Room();
		Door door1 = new Door(room1.NorthWall, room2.SouthWall);
		
	}
}
