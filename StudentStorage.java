import java.util.ArrayList;

public class StudentStorage {
    ArrayList<Student> StudentList = new ArrayList<>();

    public void addStudent(Student student){
        StudentList.add(student);
    }

    public void displayStudents(){
        System.out.println("All students in list:");
        System.out.printf("%-8s\t%-30s\t%-8s\t%-8s\n", "ID", "Name", "Age", "GPA");
        for(int i = 0; i < StudentList.size(); i++) {
            System.out.printf("%-8d\t%-30s\t%-8d\t%-8f\n",  StudentList.get(i).getId(),  StudentList.get(i).getName()
            ,  StudentList.get(i).getAge(),  StudentList.get(i).getGpa());
        }
    }
}
