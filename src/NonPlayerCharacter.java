import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class NonPlayerCharacter {

	String name;
	boolean isHostile;
	ArrayList NPCInventory;
	ArrayList Dialogue;
	int health = 20;
	
	public NonPlayerCharacter(String name, boolean isHostile){
		this.name = name;
		this.isHostile = isHostile;
		this.NPCInventory = new ArrayList();
		this.Dialogue = new ArrayList();
	}
	
	public boolean isAlive(){
		return health > 0;
	}
	
	public int attack(Character character){
		System.out.println("Attacks.");
		
		while(character.health > 0 && this.health > 0){
			//Ask the character what they want to do: Attack or flee
			while (true){
				String action = Input.getInput("What do you do?");
				if(action.equals("attack") || action.equals("a")){
					break; //Break out of while loop. 
				}
				else if(action.equals("flee") || action.equals("f")){
					//If they flee, return 1.
					return 1;
				}
				else{
					//If character doesn't do either, repeats question.
					System.out.println("Not a valid action.");
				}
			}
			
			//if they attack, roll d20. if 11-20 they hit. 1-10 they miss.
			int hit = Random.getInteger(1, 20);
			if(hit >= 11){
				//If they hit, roll d6 damage. 
				System.out.println("You hit the enemy.");
				int damage = Random.getInteger(1, 6);
				this.health = this.health - damage;
				System.out.println("You dealt " + damage + " damage.");
				System.out.println("Enemy health: " + this.health);
			}
			else{
				System.out.println("You missed.");
			}
			
			//NPC attacks, roll d20. 11-20 for hit, 1-10 for miss.
			int npcHit = Random.getInteger(1, 20);
			if(npcHit >= 11){
				//Roll d4 damage on hit. 
				System.out.println("The enemy hits you.");
				int npcDamage = Random.getInteger(10, 20);
				character.health = character.health - npcDamage;
				System.out.println("You were dealt " + npcDamage + " damage.");
				System.out.println("Current health: " + character.health);
			}
			else{
				System.out.println("The enemy missed.");
			}
		
			//Check health points. If character health is 0, they die. Same with NPC. 	
		}
		
		//Outcomes:
		//0 = lost. 
		//1 = flee.
		//2 = win.
		if(character.health > 0){
			System.out.println("You defeated the enemy.");
			return 2;
		}
		else{
			System.out.println("You died.");
			return 0;
		}
	}
	
	public String speak(){
		if(this.Dialogue.size() > 0){
			int index = Random.getInteger(0, this.Dialogue.size());
			return (String) this.Dialogue.get(index);
		}
		else{
			return "This character has nothing to say to you.";
		}
	}
}
