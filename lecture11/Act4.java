package lecture11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Act4 {
	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		ArrayList<String> tp;
		Scanner sc = new Scanner(System.in);
		int choice;
		String className;
		String name;
		while(true) {
			System.out.println("1.Add a student to a class");
			System.out.println("2.Display all students in a class");
			System.out.println("3.Exit");
			System.out.print("Enter your choice: ");
			choice = Integer.parseInt(sc.nextLine());
			switch(choice){
				case 1: 
					System.out.print("Enter class' name: ");
					className = sc.nextLine();
					System.out.print("Enter student' name: ");
					name = sc.nextLine();
					if(map.containsKey(className)) {
						map.get(className).add(name);
					}else {
						tp = new ArrayList<>();
						tp.add(name);
						map.put(className, tp);
					}
					break;
				case 2:
					System.out.print("Enter class' name: ");
					className = sc.nextLine();
					if(map.containsKey(className)) {
						for(String s: map.get(className)) {
							System.out.println(s);
						}
					}else {
						System.out.println("Class not found");
					}
					break;
				case 3:
					System.out.println("Good bye!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice!");
					break;
			}
		}
	
	}
}
