package asg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    ArrayList<Product> cart;

    public Cart() {
        cart = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        cart.add(product);
    }

    public boolean removeProduct(int id) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).id == id) {
                cart.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updateProduct(int id, String name, double price, int quantity) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).id == id) {
                cart.get(i).setName(name);
                cart.get(i).setPrice(price);
                cart.get(i).setQuantity(quantity);
                return true;
            }
        }
        return false;
    }

    public void displayCart() { //Display a table-like list of all products to the console
        System.out.println("\n---------------------------------------------------------------------------\n");
        System.out.printf("|%-8s\t|%-20s\t|%-10s\t|%-8s\n", "ID", "Name", "Price", "Quantity");
        for (int i = 0; i < cart.size(); i++) {
            System.out.printf("|%-8d\t|%-20s\t|%-8.2f\t|%-8d\n", cart.get(i).id, cart.get(i).name, cart.get(i).price, cart.get(i).quantity);
        }
        System.out.println("\n---------------------------------------------------------------------------\n");

    }

    public boolean searchProduct(String key) {
        int found = 0; 
        int firstTime = 1;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).name.contains(key)) {
                if(firstTime == 1){
                    System.out.println("\n---------------------------------------------------------------------------\n");
                    System.out.printf("|%-8s\t|%-20s\t|%-10s\t|%-8s\n", "ID", "Name", "Price", "Quantity");
                    firstTime = 0;
                }
                
                System.out.printf("|%-8d\t|%-20s\t|%-8.2f\t|%-8d\n", cart.get(i).id, cart.get(i).name, cart.get(i).price, cart.get(i).quantity);
                found = 1;
            }
        }
        if(found == 1){
            System.out.println("\n---------------------------------------------------------------------------\n");
            return true;
        }
        return false;
    }

    public boolean saveCart(String fileName, boolean text) {
        if (text) {
            //save as text file
            try{
                File f = new File(fileName);
                FileWriter fw = new FileWriter(f);
                for(int i = 0; i < cart.size(); i++){
                    fw.write(cart.get(i).name + " ; " + cart.get(i).price + " ; " + cart.get(i).quantity + "\n");
                }
                fw.close();
                return true;
            }catch(Exception e){
                System.out.println(e);
                return false;
            }

        } else {
            //save as binary file
            try{
                FileOutputStream fis = new FileOutputStream(fileName);
                ObjectOutputStream ois = new ObjectOutputStream(fis);
                ArrayList<String> temp = new ArrayList<String>();
                for(int i = 0; i < cart.size(); i++){
                    temp.add(cart.get(i).name + " ; " + cart.get(i).price + " ; " + cart.get(i).quantity);
                }
                ois.writeObject(temp);
                ois.close();
                fis.close();
                return true;
            }catch(Exception e){
                System.out.println(e);
                return false;
            }
        }
    }

    public boolean loadCart(String fileName, boolean text) {
        if (text) {
            //load from text file
            try{
                File f = new File(fileName);
                Scanner sc = new Scanner(f);
                while(sc.hasNextLine()){
                    String str =  sc.nextLine();
                    String[] line = str.split(" ; ", 5);
                    
                    cart.add(new Product(line[0], Double.parseDouble(line[1]), Integer.parseInt(line[2])));
                }
                sc.close();
                return true;
            }catch(Exception e){
                System.out.println(e);
                return false;
            }

        } else {
            //load from binary file
            try{
                FileInputStream is = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(is);
                // while(ois.read() != -1){
                //     System.out.println("here");
                //     String[] line = ois.readUTF().split(" ; ");
                //     cart.add(new Product(line[0], Double.parseDouble(line[1]), Integer.parseInt(line[2])));
                // }
                ArrayList<String> temp = (ArrayList<String>) ois.readObject();
                for(int i = 0; i < temp.size(); i++){
                    String[] line = temp.get(i).split(" ; ");
                    cart.add(new Product(line[0], Double.parseDouble(line[1]), Integer.parseInt(line[2])));
                }
                // temp = (ArrayList<Product>) ois.readObject();
                // for(int i = 0; i < temp.size(); i++){
                //     cart.add(temp.get(i));
                // }
                ois.close();
                return true;
            }catch(Exception e){
                System.out.println(e);
                return false;
            }
        }
    }

    public void sortCart(){
        //sort cart by price
        for(int i = 0; i < cart.size(); i++){
            for(int j = i + 1; j < cart.size(); j++){
                if(cart.get(i).price > cart.get(j).price){
                    Product temp = cart.get(i);
                    cart.set(i, cart.get(j));
                    cart.set(j, temp);
                }
            }
        }
    }

}
