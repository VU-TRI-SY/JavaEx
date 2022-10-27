package src.lecture9.act5;

import java.io.File;
import java.util.Scanner;

public class Act5 {
    public static void main(String[] args){
        try{
            File fr = new File("src/lecture9/act5/data.txt");
            Scanner sc = new Scanner(fr);
            double sum = 0;
            while (sc.hasNextLine()){
                sum = 0;
                String oneline = sc.nextLine();
                if(oneline.isEmpty()){
                    System.out.println("0");
                }else{
                    String[] nums = oneline.split(" ");
                    for(String num : nums){
                        sum += Integer.parseInt(num);
                    }
                    System.out.format("%.3f\n", sum / nums.length);
                }
            }
            sc.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
