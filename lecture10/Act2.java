package lecture10;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Act2 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Hello World 1");
        list.add("Hello World 2");
        list.add("Hello World 3");
        FileOutputStream fis = new FileOutputStream("./lecture10/data.bin");
        ObjectOutputStream ois = new ObjectOutputStream(fis);
        ois.writeObject(list);
        ois.close();
        fis.close();
        
    }
}
