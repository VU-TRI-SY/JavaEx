package lecture11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Act3 {
	public static void main(String[] args) throws FileNotFoundException {
		HashSet<String> set = new HashSet<String> (); 
		File f = new File("C:\\Users\\vutri\\OneDrive\\Desktop\\fileEx\\src\\lecture11\\data.txt");
		Scanner sc = new Scanner(f);
		while(sc.hasNextLine()) {
			String str = sc.nextLine();
			String[] s = str.split(" ");
			for(String tp: s) {
				char c = tp.charAt(tp.length()-1);
				if(c == '.' || c == ';' || c == ',') {
					StringBuilder sb = new StringBuilder(tp);
					sb.deleteCharAt(sb.length() - 1);
					set.add(sb.toString().toLowerCase());
				}else {
					set.add(tp.toLowerCase());
				}
			}
		}
		
		System.out.println(set);
		sc.close();
	}
}
