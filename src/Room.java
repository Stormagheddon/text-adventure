
public class Room {
	Wall NorthWall;
	Wall SouthWall;
	Wall EastWall;
	Wall WestWall;
	
	public Room (){
		this.NorthWall = new Wall();
		this.SouthWall = new Wall();
		this.EastWall = new Wall();
		this.WestWall = new Wall();
	}
}