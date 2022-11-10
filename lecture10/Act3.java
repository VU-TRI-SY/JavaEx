package lecture10;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Act3 {
    public static void main(String[] args) throws Exception {
        FileInputStream fos = new FileInputStream("./lecture10/data.bin");
        ObjectInputStream oos = new ObjectInputStream(fos);
        ArrayList<String> list2 =  (ArrayList<String>) oos.readObject();
        for(String s : list2){
            System.out.println(s);
        }
        oos.close();
    }
}
