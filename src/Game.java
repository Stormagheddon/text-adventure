
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
	}
}