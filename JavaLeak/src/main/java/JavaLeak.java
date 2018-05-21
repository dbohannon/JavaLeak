import java.util.Arrays;
import java.util.Scanner;

public class JavaLeak {

	//print char array instead of casting to string
    public static void printCharArray(char[] array) {
    	for(int i=0; i<array.length; i++) {
    		System.out.print(array[i]);
    	}
    	System.out.println();
    }
    
	public static void setSensitiveCharArray() {
		//sensitive data saved in char array
		char [] password = {'S', '3', 'c', 'r', '3', 't', 'P', '@', 's', 's', 'w', '0', 'r', 'd'};
		System.out.println("Saving password as char []...");
		System.out.print("Password is ");
		printCharArray(password);
	
		//zero-out char array
		System.out.println("Zeroing char []...");
		Arrays.fill(password, 'x');
		System.out.print("Password is ");
		printCharArray(password);
	}
	
	public static void setSensitiveString() {
		//sensitive data saved in string
		char [] init = {'S', '3', 'c', 'r', '3', 't', 'P', '@', 's', 's', 'w', '0', 'r', 'd'};
		System.out.println("Saving password as String...");
		String password = new String(init);
		System.out.println("Password is " + password);
	
		//setting value to null in attempt to clear sensitive data
		System.out.println("Setting password to null...");
		password = null;
		System.out.println("Password is " + password);
	}
	
	public static void main(String[] args) {
		//print menu
		System.out.println("Select 1 to save password in String");
		System.out.println("Select 2 to save password in char array");
		System.out.println("Select 3 to call the garbage collector");
		System.out.println("Select 4 to write bulk data to heap");
		System.out.println("Select 0 to exit");
		//loop over user input
		while(true) {
			//get input from user
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
			
			//call demo functions based on user choice
			switch(choice) {
				case 0:
					//exit
					System.out.println("Goodbye...");
					in.close();
					System.exit(0);
				case 1:
					//save password in String
					setSensitiveString();
					break;
				case 2:
					//save password in char []
					setSensitiveCharArray();
					break;
				case 3:
					//manually call Java garbage collector
					System.gc();
					System.out.println("Garbage collector called...");
					break;
				case 4:
					//fill heap with garbage
					for(int i=0; i<500000; i++) {
						long time = System.currentTimeMillis();
					}
					System.out.println("Filling heap with bulk data...");
					break;
				default:
					System.out.println("Invalid choice...");
			}//switch
		}//while

	}//main
}
