import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Act3{
    public static void main(String[] args){
        try{
            int i = 1;
            File f = new File("data/input_act3.txt");
            Scanner sc = new Scanner(f);
            File f2 = new File("data/output_act3.txt");
            PrintWriter p = new PrintWriter(f2);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                p.println(i + ". " + line);
                i++;
            }
            sc.close();
            p.close();



        }catch(Exception e){
            System.out.println("Some exception occured");
        }

    }
}