
public class Door {

	Wall Wall1;
	Wall Wall2;
	Item Key;
	boolean isLocked;
		
	public Door (Wall wall1, Wall wall2){
		this.Wall1 = wall1;
		this.Wall2 = wall2;			
		wall1.Door = this;
		wall2.Door = this;
		this.isLocked = false;
	}

	public Door (Wall wall1, Wall wall2, Item key){
		this(wall1, wall2);
		this.Key = key;
		this.isLocked = true;
	}
}