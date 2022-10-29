import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Act2 {
    public static void main(String[] args){
        try{
            File f = new File("data/act2.txt");
            Scanner sc = new Scanner(f);
            ArrayList<String> lines = new ArrayList<String>();
            while(sc.hasNextLine()){
                String s = sc.nextLine();
                String[] strs = s.split(" ");
                for(String tp: strs){
                    lines.add(tp); 
                }
                lines.add("\n");
            }
            sc.close();

            PrintWriter p = new PrintWriter(f);
            for(String tp: lines){
                p.print(tp);
            }
            p.close();

        }catch(Exception e){
            System.out.println("Some exception occured!");
        }
    }
}
