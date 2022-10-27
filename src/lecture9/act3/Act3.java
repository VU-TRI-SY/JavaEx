package src.lecture9.act3;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Act3 {
    public static void main(String[] args){
        try{
            File fr = new File("src/lecture9/act3/input.txt");
            FileWriter fw = new FileWriter("src/lecture9/act3/output.txt");
            Scanner sc = new Scanner(fr);
            int ct = 1;
            while(sc.hasNextLine()){
                String oneline = sc.nextLine();
                fw.write(ct + ". " + oneline + "\n");
                ct++;
            }
            sc.close();
            fw.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
