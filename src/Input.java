import java.util.Scanner;

public class Input {
	
    public static String getInput(String prompt) {
    	
        System.out.print(prompt + " ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        input.toLowerCase();
        return input;
    }
}
