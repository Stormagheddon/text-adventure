import java.util.ArrayList;

public class NonPlayerCharacter {

	String name;
	boolean isHostile;
	ArrayList NPCInventory;
	
	public NonPlayerCharacter(String name, boolean isHostile){
		this.name = name;
		this.isHostile = isHostile;
	}
}
