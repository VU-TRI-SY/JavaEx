package src.lecture9.act2;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Act2 {
    public static void main(String[] args){
        try{
            File fr = new File("src/lecture9/act2/data.txt");
            Scanner sc = new Scanner(fr);
            ArrayList<String> lines = new ArrayList<String>();
            while(sc.hasNextLine()){
                String oneline = sc.nextLine();
                String[] strs = oneline.split(" ");
                for(String str : strs){
                    lines.add(str);
                }
                lines.add("\n");
            }
            sc.close();
            FileWriter fw = new FileWriter(fr);
            for(String line : lines){
                fw.write(line);
            }
            fw.close();
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }       
    }
}
