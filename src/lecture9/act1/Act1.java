package src.lecture9.act1;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Act1{
    public static void main(String[] args){
        try{
            FileWriter fw = new FileWriter(new File("src/lecture9/act1/hello.txt"));
            fw.write("Hello World");
            fw.close();

            File fr = new File("src/lecture9/act1/hello.txt");
            Scanner sc = new Scanner(fr);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            sc.close();
            System.out.println("File path: " + fr.getAbsolutePath());
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}