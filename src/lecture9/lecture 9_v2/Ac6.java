import java.io.File;
import java.util.Scanner;

public class Ac6 {
    public static void main(String[] args){
        try{
            File f = new File("data/act6.txt");
            Scanner sc = new Scanner(f);
            int n = sc.nextInt();
            String[] firstName = new String[n];
            String[] lastName = new  String[n];
            String[] mail = new String[n];
            int[] number = new int[n];
            for(int i = 0; i < n; i++){
                firstName[i] = sc.next();
                lastName[i] = sc.next();
                mail[i] = sc.next();
                number[i] = sc.nextInt();
            }
            sc.close();

            for(int i = 0; i < n; i++){
                if(number[i] == 4 || number[i] == 5){
                    System.out.println(firstName[i] + " " + lastName[i] + " " + mail[i] + "@hanu.vn " + number[i]);
                }
            }

        }catch(Exception e){
            System.out.println("Some exception occured!");
        }

    }
}
