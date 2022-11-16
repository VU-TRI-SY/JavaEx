package asg;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLUE = "\u001B[36m"; // Cyan color
        final String ANSI_ORANGE = "\u001B[33m"; // Yello color
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_PURPLE = "\u001B[35m";
        Cart cart = new Cart();
        int choice;
        String key;
        String filePath;
        int fileType;
        int id;
        String name;
        double price;
        int quantity;
        Scanner sc = new Scanner(System.in);
        System.out.println();
        while(true){
            System.out.println(ANSI_BLUE + "1. Add products");
            System.out.println("2. Display products");
            System.out.println("3. Delete a product");
            System.out.println("4. Edit a product");
            System.out.println("5. Search for products by name");
            System.out.println("6. Sort products by price");
            System.out.println("7. Save products to text/binary file");
            System.out.println("8. Load products from the saved file");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: " + ANSI_ORANGE);
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    sc.nextLine(); //clear buffer
                    System.out.println(ANSI_PURPLE + "\nEnter information of the product:" );
                    System.out.print(ANSI_PURPLE + "Name: " + ANSI_ORANGE);
                    name = sc.nextLine();
                    System.out.print(ANSI_PURPLE + "Price: " + ANSI_ORANGE);
                    price = sc.nextDouble();
                    System.out.print(ANSI_PURPLE + "Quantity: " + ANSI_ORANGE);
                    quantity = sc.nextInt();
                    Product product = new Product(name, price, quantity);
                    cart.addProduct(product);
                    System.out.println(ANSI_GREEN + "\nProduct added successfully!\n" + ANSI_RESET);
                    break;
                case 2:
                    System.out.println(ANSI_PURPLE + "\nAll products in the cart:" + ANSI_RESET);
                    cart.displayCart();
                    System.out.println();

                    break;
                case 3:
                    System.out.print(ANSI_PURPLE + "\nEnter the ID of the product to delete: " + ANSI_ORANGE);
                    id = sc.nextInt();
                    if(cart.removeProduct(id)){
                        System.out.println(ANSI_GREEN + "\nProduct with ID " + id + " has been deleted" + ANSI_RESET);
                    }
                    else{
                        System.out.println(ANSI_RED + "\nNothing will be deleted!" + ANSI_RESET);
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println(ANSI_PURPLE + "\nEnter the ID and information of the product to edit" + ANSI_RESET);
                    System.out.print(ANSI_PURPLE + "ID: " + ANSI_ORANGE); 
                    id = sc.nextInt();
                    sc.nextLine(); //clear buffer
                    System.out.print(ANSI_PURPLE + "Name: " + ANSI_ORANGE);
                    name = sc.nextLine();
                    System.out.print(ANSI_PURPLE + "Price: " + ANSI_ORANGE);
                    price = sc.nextDouble();
                    System.out.print(ANSI_PURPLE + "Quantity: " + ANSI_ORANGE);
                    quantity = sc.nextInt();
                    if(cart.updateProduct(id, name, price, quantity)){
                        System.out.println(ANSI_GREEN + "\nProduct with ID " + id + " has been updated" + ANSI_RESET);
                    }
                    else{
                        System.out.println(ANSI_RED + "\nNothing will be updated!" + ANSI_RESET);
                    }
                    System.out.println();
                    break;
                case 5:
                    sc.nextLine(); //clear buffer
                    System.out.print(ANSI_PURPLE + "\nEnter the keyword to search products: " + ANSI_ORANGE);
                    key = sc.nextLine();
                    if(!cart.searchProduct(key)){
                        System.out.println(ANSI_RED + "\nCannot find any product with the keyword " + key + ANSI_RESET);
                    }
                    System.out.println();
                    break;
                case 6:
                    cart.sortCart();
                    System.out.println(ANSI_GREEN + "\nProducts have been sorted by price" + ANSI_RESET);
                    System.out.println();
                    break;
                case 7:
                    System.out.println(ANSI_PURPLE + "\nSave products to text/binary file" + ANSI_RESET);
                    do{
                        System.out.print(ANSI_PURPLE + "Which file type do you want to save? (1 for text file, 0 for binary file): " + ANSI_ORANGE);
                        fileType = sc.nextInt();
                        sc.nextLine(); //clear buffer
                    }while(fileType != 0 && fileType != 1);
                    System.out.print(ANSI_PURPLE + "Enter the file path: " + ANSI_ORANGE);
                    filePath = sc.nextLine();
                    if(cart.saveCart(filePath, fileType == 1)){
                        System.out.println(ANSI_GREEN + "\nProducts have been saved to " + filePath + ANSI_RESET);
                    }
                    else{
                        System.out.println(ANSI_RED + "\nCannot save products to " + filePath + ANSI_RESET);
                    }
                    System.out.println();
                    break;
                case 8:
                System.out.println(ANSI_PURPLE + "\nLoad products to text/binary file" + ANSI_RESET);
                do{
                    System.out.print(ANSI_PURPLE + "Which file type do you want to load from? (1 for text file, 0 for binary file): " + ANSI_ORANGE); 
                    fileType = sc.nextInt();
                    sc.nextLine(); //clear buffer
                }while(fileType != 0 && fileType != 1);
                System.out.print(ANSI_PURPLE + "Enter the file path: " + ANSI_ORANGE);
                filePath = sc.nextLine();
                if(cart.loadCart(filePath, fileType == 1)){
                    System.out.println(ANSI_GREEN + "\nProducts have been loaded from " + filePath + ANSI_RESET);
                }
                else{
                    System.out.println(ANSI_RED + "\nCannot load products from " + filePath + ANSI_RESET);
                }
                System.out.println();
                break;
                case 9:
                    System.out.print(ANSI_PURPLE + "\nAre you sure you want to exit? (Y/N) " + ANSI_ORANGE);
                    if(sc.nextLine().equals("Y") || sc.nextLine().equals("y")){
                        System.out.println(ANSI_GREEN + "\nGoodbye!\n" + ANSI_RESET);
                        System.exit(0);
                        break;
                    }else{
                        System.out.println();
                        break;
                    }
                default:
                    System.out.println(ANSI_RED + "\nInvalid choice!" + ANSI_RESET);
                    System.out.println();
                    break;
            }
        }
    }
}
