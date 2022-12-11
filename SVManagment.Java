import java.util.Scanner;
public class SVManagment{
    public static void main(String[] args){
        StudentStorage ss = new StudentStorage();
        int choice;
        Scanner sc = new Scanner(System.in);
        String name;
        int age;
        double gpa;
        while(true){
            System.out.println("1.Add new student");
            System.out.println("2.Display all students");
            System.out.println("3.Update student infor by Student'ID");
            System.out.println("4.Delete a student by Student'ID");
            Sysetm.out.println("5.Search student by Name");
            System.out.println("6.Sort students by GPA");
            System.out.println("7.Store student'infor to file");
            System.out.println("0.Exit program");
            System.out.println("Enter your choice:");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Student infor:");
                    sc.next();
                    System.out.print("Name: "); 
                    name = sc.nextLine();
                    System.out.println("Age: ");
                    age = sc.nextInt();
                    System.out.println("Gpa: ");
                    gpa = sc.nextDouble();
                    ss.addStudent(new Student(name, age, gpa));
                    break;
                case 2:
                    ss.displayStudents();
                    break;
                case 3:
                    break;
                case 4:

                    break;
                case 5: 
                    break;

                case 6: 
                    break;
                case 7:
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    Ssuytem.out.println("Invalid choice!");
                    break;
            }
        }



    }
}




