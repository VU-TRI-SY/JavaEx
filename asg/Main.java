package asg;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
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
        while(true){
            System.out.println("1. Add products");
            System.out.println("2. Display products");
            System.out.println("3. Delete a product");
            System.out.println("4. Edit a product");
            System.out.println("5. Search for products by name");
            System.out.println("6. Sort products by price");
            System.out.println("7. Save products to text/binary file");
            System.out.println("8. Load products from the saved file");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    sc.nextLine(); //clear buffer
                    System.out.println("Enter information of the product:");
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    System.out.print("Price: ");
                    price = sc.nextDouble();
                    System.out.print("Quantity: ");
                    quantity = sc.nextInt();
                    Product product = new Product(name, price, quantity);
                    cart.addProduct(product);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("All products in the cart:");
                    cart.displayCart();
                    System.out.println();

                    break;
                case 3:
                    System.out.print("Enter the ID of the product to delete: ");
                    id = sc.nextInt();
                    if(cart.removeProduct(id)){
                        System.out.println("Product with ID " + id + " has been deleted");
                    }
                    else{
                        System.out.println("Product not found");
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Enter the ID and information of the product to edit");
                    System.out.print("ID: ");
                    id = sc.nextInt();
                    sc.nextLine(); //clear buffer
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    System.out.print("Price: ");
                    price = sc.nextDouble();
                    System.out.print("Quantity: ");
                    quantity = sc.nextInt();
                    if(cart.updateProduct(id, name, price, quantity)){
                        System.out.println("Product with ID " + id + " has been updated");
                    }
                    else{
                        System.out.println("Product not found");
                    }
                    System.out.println();
                    break;
                case 5:
                    sc.nextLine(); //clear buffer
                    System.out.print("Enter the keyword to search products: ");
                    key = sc.nextLine();
                    if(!cart.searchProduct(key)){
                        System.out.println("Cannot find any product with the keyword " + key);
                    }
                    System.out.println();
                    break;
                case 6:
                    cart.sortCart();
                    System.out.println("Products have been sorted by price");
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Save products to text/binary file");
                    do{
                        System.out.print("Which file type do you want to save? (1 for text file, 0 for binary file): ");
                        fileType = sc.nextInt();
                        sc.nextLine(); //clear buffer
                    }while(fileType != 0 && fileType != 1);
                    System.out.print("Enter the file path: ");
                    filePath = sc.nextLine();
                    if(cart.saveCart(filePath, fileType == 1)){
                        System.out.println("Products have been saved to " + filePath);
                    }
                    else{
                        System.out.println("Cannot save products to " + filePath);
                    }
                    System.out.println();
                    break;
                case 8:
                System.out.println("Load products to text/binary file");
                do{
                    System.out.print("Which file type do you want to load from? (1 for text file, 0 for binary file): ");
                    fileType = sc.nextInt();
                    sc.nextLine(); //clear buffer
                }while(fileType != 0 && fileType != 1);
                System.out.print("Enter the file path: ");
                filePath = sc.nextLine();
                if(cart.loadCart(filePath, fileType == 1)){
                    System.out.println("Products have been loaded from " + filePath);
                }
                else{
                    System.out.println("Cannot load products from " + filePath);
                }
                System.out.println();
                break;
                case 9:
                    System.out.print("Are you sure you want to exit? (Y/N) ");
                    if(sc.nextLine().equals("Y") || sc.nextLine().equals("y")){
                        System.out.println("Goodbye!");
                        System.exit(0);
                        break;
                    }else{
                        System.out.println();
                        break;
                    }
                default:
                    System.out.println("Invalid choice!");
                    System.out.println();
                    break;
            }
        }
    }
}
