package lecture11;

import java.util.HashMap;
import java.util.Scanner;

public class ScoreChecker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Double> map = new HashMap<>();
		map.put("Lorris Marandola", 9.5);
		map.put("Baptiste Rousselet", 7.0);
		map.put("Arthur Gauchez", 8.5);
		map.put("Luna Nguyen", 10.0);
		map.put("Max Habazettl", 8.25);
		map.put("Korbinian Hutter", 7.75);
		System.out.print("Enter student'name: ");
		String input = sc.nextLine();
		if(map.containsKey(input)) {
			System.out.println("The score of student " + input + " is: " + map.get(input));
		}else {
			System.out.println("Score not found");
		}
	}
}
