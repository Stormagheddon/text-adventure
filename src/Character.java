import java.io.Serializable;
import java.util.ArrayList;

public class Character implements Serializable {
	Room Location;
	ArrayList Inventory;
	int health = 20;
	
	public Character(){
		this.Inventory = new ArrayList();
	}
}
