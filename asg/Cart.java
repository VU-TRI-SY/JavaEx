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

    public void addProduct(Product product) { //feature 1: add product
        cart.add(product);
    }

    public void displayCart() { //feature 2: display product
        System.out.println("\n---------------------------------------------------------------------------\n");
        System.out.printf("|%-8s\t|%-20s\t|%-14s\t|%-8s", "ID", "Name", "Price", "Quantity");
        System.out.println(); // ~ \n
        for (int i = 0; i < cart.size(); i++) {
            System.out.printf("|%-8d\t|%-20s\t|%-12.2f\t|%-8d", cart.get(i).getId(), cart.get(i).getName(), cart.get(i).getPrice(), cart.get(i).getQuantity());
            System.out.println(); // ~ \n
        }
        System.out.println("\n---------------------------------------------------------------------------\n");
    }
    // \n: new line
    // \0: null character: ending character of a string
    public boolean removeProduct(int id) { //feature 3: remove product
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getId() == id) {
                cart.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updateProduct(int id, String name, double price, int quantity) { //feature 4: update product
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getId() == id) {
                cart.get(i).setName(name);
                cart.get(i).setPrice(price);
                cart.get(i).setQuantity(quantity);
                return true;
            }
        }
        return false;
    }



    public boolean searchProduct(String key) { //feature 5: search product by key
        int found = 0; 
        int firstTime = 1;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getName().contains(key)) {
                if(firstTime == 1){
                    System.out.println("\n---------------------------------------------------------------------------\n");
                    System.out.printf("|%-8s\t|%-20s\t|%-14s\t|%-8s\n", "ID", "Name", "Price", "Quantity");
                    firstTime = 0;
                }
                System.out.printf("|%-8d\t|%-20s\t|%-12.2f\t|%-8d\n", cart.get(i).getId(), cart.get(i).getName(), cart.get(i).getPrice(), cart.get(i).getQuantity());
                found = 1;
            }
        }
        if(found == 1){
            System.out.println("\n---------------------------------------------------------------------------\n");
            return true;
        }
        return false;
    }

    public void sortCart(){ //feature 6: sort cart
        //sort cart by price
        //bubble sort
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

    public boolean saveCart(String fileName, boolean text) { //feature 7: save products to file
        if (text) {
            //save as text file
            try{
                File f = new File(fileName);
                FileWriter fw = new FileWriter(f); //ghi vao file f
                for(int i = 0; i < cart.size(); i++){
                    fw.write(cart.get(i).getName() + ";" + cart.get(i).getPrice() + ";" + cart.get(i).getQuantity() + "\n");
                }
                fw.close();
                return true; //save successfully
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
                    temp.add(cart.get(i).getName() + ";" + cart.get(i).getPrice() + ";" + cart.get(i).getQuantity());
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

    public boolean loadCart(String fileName, boolean text) { //feature 8: load products from file -> save to cart
        if (text) {
            //load from text file
            try{
                File f = new File(fileName);
                Scanner sc = new Scanner(f);
                while(sc.hasNextLine()){
                    String str =  sc.nextLine();
                    //str = "Dell Latitude;1299.9;2"
                    String[] line = str.split(";");
                    //line = {"Dell Latitude", "1299.9", "2"}
                    Product p = new Product(line[0], Double.parseDouble(line[1]), Integer.parseInt(line[2]));
                    cart.add(p);
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
                ArrayList<String> temp = (ArrayList<String>) ois.readObject(); //read object(ararylist) from file -> temp
                for(int i = 0; i < temp.size(); i++){
                    String[] line = temp.get(i).split(";");
                    cart.add(new Product(line[0], Double.parseDouble(line[1]), Integer.parseInt(line[2])));
                }
                ois.close();
                return true;
            }catch(Exception e){
                System.out.println(e);
                return false;
            }
        }
    }



}
