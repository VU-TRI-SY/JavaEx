import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Act1 {
    public static void main(String[] args){
        try{
            PrintWriter p = new PrintWriter("data/hello.txt");
            p.println("Hello World!");
            p.close();

            File f = new File("data/hello.txt");
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String s = sc.nextLine();
                System.out.println(s);
            }
            sc.close();
        }catch(Exception e){
            System.out.println("Some exception occured!");
        }
    }
}
