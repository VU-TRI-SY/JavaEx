import java.io.File;
import java.util.Scanner;

public class Act4 {
    public static void main(String[] args){
        try{
            File f = new File("data/act4.txt");
            Scanner sc = new Scanner(f);
            int count = 0;
            double sum1 = 0, sum2 = 0;
            while(sc.hasNextLine()){
                sum1 += sc.nextDouble();
                sum2 += sc.nextDouble();
                count++;
            }
            System.out.format("Average of first column: %.3f\n", sum1/count);   
            System.out.format("Average of second column: %.3f\n", sum2/count);
            sc.close();
        }catch(Exception e){
            System.out.println("Some exception occured");
        }
    }
}
