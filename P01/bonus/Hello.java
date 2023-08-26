import java.util.Scanner;
public class Hello{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String name;
		System.out.print("Enter your name: ");
		name = in.nextLine();
		System.out.println("hello, " + name);
		
	}
}
