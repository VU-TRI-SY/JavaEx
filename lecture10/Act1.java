package lecture10;

import java.util.Scanner;

public class Act1 {
    public static void main(String[] args){
        int choice;
        Scanner sc = new Scanner(System.in);
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLUE = "\u001B[36m"; // Cyan color
        final String ANSI_ORANGE = "\u001B[33m"; // Yello color
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RED = "\u001B[31m";
        while(true){
            System.out.println(ANSI_BLUE + "[1] Add item");
            System.out.println("[2] Item list");
            System.out.println("[3] Edit an item");
            System.out.println("[4] Remove an item");
            System.out.println("[5] Quit");
            System.out.print("Choose an option: " + ANSI_ORANGE);
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println(ANSI_GREEN + "\nAdding a new item...\n"  + ANSI_RESET);
                    break;
                case 2:
                    System.out.println(ANSI_GREEN + "\nListing all items...\n" + ANSI_RESET);
                    break;
                case 3:
                    System.out.println(ANSI_GREEN + "\nEditing an item...\n" + ANSI_RESET);
                    break;
                case 4:
                    System.out.println(ANSI_GREEN + "\nRemoving an item...\n" + ANSI_RESET);
                    break;
                case 5:
                    System.out.println(ANSI_GREEN + "\nGoodbye!\n" + ANSI_RESET);
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println(ANSI_RED + "\nInvalid choice!\n" + ANSI_RESET);
            }
        }
    }
}
