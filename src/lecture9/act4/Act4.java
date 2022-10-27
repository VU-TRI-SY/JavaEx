package src.lecture9.act4;

import java.io.File;
import java.util.Scanner;

public class Act4 {
    public static void main(String[] args){
        try{
            double sum1 = 0, sum2 = 0;
            int ct = 0;
            File fr = new File("src/lecture9/act4/data.txt");
            Scanner sc = new Scanner(fr);
            while(sc.hasNextLine()){
                sum1 += sc.nextDouble();
                sum2 += sc.nextDouble();
                ct++;
            }
            sc.close();
            System.out.printf("Average of first column: %.3f\n", sum1/ct);
            System.out.printf("Average of second column: %.3f\n", sum2/ct);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
