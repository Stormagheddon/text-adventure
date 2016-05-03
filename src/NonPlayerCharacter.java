import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class NonPlayerCharacter {

	String name;
	boolean isHostile;
	ArrayList NPCInventory;
	ArrayList Dialogue;
	
	public NonPlayerCharacter(String name, boolean isHostile){
		this.name = name;
		this.isHostile = isHostile;
		this.NPCInventory = new ArrayList();
		this.Dialogue = new ArrayList();
	}
	
	public String speak(){
		if(this.Dialogue.size() > 0){
			int index = ThreadLocalRandom.current().nextInt(0, this.Dialogue.size());
			return (String) this.Dialogue.get(index);
		}
		else{
			return "This character has nothing to say to you.";
		}
	}
}
