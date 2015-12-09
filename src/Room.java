import java.util.ArrayList;

public class Room {
	Wall NorthWall;
	Wall SouthWall;
	Wall EastWall;
	Wall WestWall;
	ArrayList Ground;
	String Description;
	
	public Room (String description){
		this.NorthWall = new Wall();
		this.SouthWall = new Wall();
		this.EastWall = new Wall();
		this.WestWall = new Wall();
		this.NorthWall.Room = this;
		this.SouthWall.Room = this;
		this.EastWall.Room = this;
		this.WestWall.Room = this;
		this.Description = description;
		this.Ground = new ArrayList();
	}
}