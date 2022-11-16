package lecture11;

import java.util.HashMap;
import java.util.Scanner;

public class EngVieDictionary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> map = new HashMap<>();
		map.put("be", "thì, là, bị, ở");
		map.put("beat", "đánh, đập");
		map.put("begin", "bắt đầu");
		map.put("become", "trở nên");
		map.put("blow", "thổi");
		map.put("dream", "mơ");
		map.put("drink", "uống");
		map.put("drive", "lái xe");
		int choice = 0;
		do {
			System.out.print("Enter a word: ");
			String input = sc.next();
			if(map.containsKey(input.toLowerCase())) {
				System.out.println(input + ": " + map.get(input.toLowerCase()));
				choice = 0; //stop
			}else {
				System.out.println("Meaning not found");
				System.out.print("Do you want to look up another word 1(yes) or 2(no): ");
				choice = sc.nextInt();
			}
		}while(choice == 1);
		sc.close();
	}
}	
