package ui;

import java.util.Scanner;

public abstract class AbstractUi {

	abstract public void show()  throws Exception;
	
	protected String getInputedString(){
		
		Scanner input = new Scanner(System.in);
		
		return input.nextLine();
	}
}
