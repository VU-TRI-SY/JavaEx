package src.lecture9.act6;

import java.io.File;
import java.util.Scanner;

public class Act6 {
    public static void main(String[] args){
        try{
            File fr = new File("src/lecture9/act6/student.txt");
            Scanner sc = new Scanner(fr);
            int n = sc.nextInt();
            String[] firstName = new String[n];
            String[] lastName = new String[n];
            String[] email = new String[n];
            int[] number = new int[n];
            for(int i = 0; i < n; i++){
                firstName[i] = sc.next();
                lastName[i] = sc.next();
                email[i] = sc.next();
                number[i] = sc.nextInt();
            }

            for(int i = 0; i < n; i++){
                if(number[i] == 5 || number[i] == 5){
                    System.out.println("First Name: " + firstName[i]);
                    System.out.println("Last Name: " + lastName[i]);
                    System.out.println("Email: " + email[i] + "@hanu.vn");
                    System.out.println("Number: " + number[i]);
                    System.out.println("------------------------");
                }
            }
            sc.close();
        }catch(Exception e){
            System.out.println("File not found");
        }

    }
}
