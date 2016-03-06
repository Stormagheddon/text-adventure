import java.io.Serializable;

public class Item implements Serializable {
	
	String Type;
	String name;
	
	public Item (String Type, String name){
		this.Type = Type;
		this.name = name;
	}
}