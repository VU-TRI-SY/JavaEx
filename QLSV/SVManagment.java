package QLSV;

import java.util.Scanner;
public class SVManagment{
    public static void main(String[] args){
        StudentStorage ss = new StudentStorage();
        int choice;
        Scanner sc = new Scanner(System.in);
        String name;
        int fileType;
        String filePath;
        int age;
        int id;
        double gpa;
        int order;
        while(true){
            System.out.println("1.Add new student");
            System.out.println("2.Display all students");
            System.out.println("3.Update student infor by Student'ID");
            System.out.println("4.Delete a student by Student'ID");
            System.out.println("5.Search student by Name");
            System.out.println("6.Sort students by GPA");
            System.out.println("7.Store student'infor to file");
            System.out.println("8.Load students from file");
            System.out.println("0.Exit program");
            System.out.println("Enter your choice: ");

//            choice = Integer.parseInt(sc.nextLine());
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                	sc.nextLine();
                    System.out.println("Enter Student infor:");
                    System.out.print("Name: "); 
                    name = sc.nextLine();
                    System.out.println("Age: ");
//                    age = Integer.parseInt(sc.nextLine());
                    age = sc.nextInt();
                    System.out.println("Gpa: ");
//                    gpa = Double.parseDouble(sc.nextLine());
                    gpa = sc.nextDouble();
                    ss.addStudent(new Student(name, age, gpa));
                    break;
                case 2:
                    ss.displayStudents();
                    break;
                case 3:
                	
                    System.out.println("Enter Student infor:");
                    System.out.print("ID: ");
                    id = sc.nextInt();
                    sc.nextLine(); //clear buffer
                    System.out.print("Name: "); 
                    name = sc.nextLine();
                    System.out.println("Age: ");
//                    age = Integer.parseInt(sc.nextLine());
                    age = sc.nextInt();
                    System.out.println("Gpa: ");
//                    gpa = Double.parseDouble(sc.nextLine());
                    gpa = sc.nextDouble();
                    if(ss.updateStudentInfor(id, name, age, gpa)) {
                    	System.out.println("Student with id " + id + " is updated infor");
                    }else {
                    	System.out.println("Stuent not found!");
                    }
                    break;
                    
                case 4:
                	System.out.print("Enter the name of student to remove: ");
                	sc.nextLine(); //clear buffer
                	name = sc.nextLine();
                	if(ss.deleteStudent(name)) {
                		System.out.println("All student with name " + name + " are removed");
                	}else {
                		System.out.println("Student not found!");
                	}

                    break;
                case 5: 
                	sc.nextLine();
                	System.out.print("Enter the name of student to search: "); name = sc.nextLine();
                	if(!ss.searchStudent(name)) {
                		System.out.println("Student not found!");
                	}
                    break;

                case 6: 
                	do {
                		System.out.print("Sort student following order? (1 for increasing, 0 for decreasing): ");
                		order = sc.nextInt();
                		System.out.println("Order " + order);
                	}while(order != 1 && order != 0);
                	
                	ss.sort(order == 1);
                    break;
                case 7:
                	System.out.println("Save student infor to text/binary file");
                	do {
                		
                		System.out.print("Which file do you want to save to? (1 for text file, 0 for binary file): ");
                		fileType = sc.nextInt();
                	}while(fileType != 1 && fileType != 0);
                	sc.nextLine();
                	System.out.print("Enter file path: ");
                	filePath = sc.nextLine();
                	if(ss.saveStudents(filePath, fileType == 1)) {
                		System.out.println("All student have been saved to file " + filePath);
                	}else {
                		System.out.println("Cannot save students to " + filePath);
                	}
                    break;
                case 8:
                	System.out.println("Load student infor to text/binary file");
                	do {
                		
                		System.out.print("Which file do you want to load from? (1 for text file, 0 for binary file): ");
                		fileType = sc.nextInt();
                	}while(fileType != 1 && fileType != 0);
                	sc.nextLine();
                	System.out.print("Enter file path: ");
                	filePath = sc.nextLine();
                	if(ss.loadStudent(filePath, fileType == 1)) {
                		System.out.println("All student have been loaded from" + filePath);
                	}else {
                		System.out.println("Cannot load students to " + filePath);
                	}
                	break;
                case 0:
                    System.exit(0);
//                    sc.close();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
//            sc.close();
        }



    }
}




