import java.io.File;
import java.util.Scanner;

public class Act5 {
    public static void main(String[] args){
        try{
            File f = new File("data/act5.txt");
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String s = sc.nextLine();
                if(s.isEmpty()){
                    System.out.println("0");
                }else{
                    int sum = 0;
                    String[] strs = s.split(" ");
                    //s = "8 38 92 -83 8 -2 28"
                    // strs= ["8", "38", "92", "-83", "8", "-2", "28"]
                    for(String tp: strs){
                        sum += Integer.parseInt(tp);
                    }
                    System.out.println(sum);
                }
            }
            sc.close();
        }catch(Exception e){
            System.out.println("Some exception occured!");
        }
    }
}
