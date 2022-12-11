package QLSV;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentStorage {
    ArrayList<Student> StudentList = new ArrayList<>();

    public void addStudent(Student student){
        StudentList.add(student);
    }

    public void displayStudents(){
        System.out.println("All students in list:");
        System.out.printf("%-8s\t%-20s\t%-8s\t%-8s\n", "ID", "Name", "Age", "GPA");
        for(int i = 0; i < StudentList.size(); i++) {
            System.out.printf("%-8d\t%-20s\t%-8d\t%-8.2f\n",  StudentList.get(i).getId(),  StudentList.get(i).getName()
            ,  StudentList.get(i).getAge(),  StudentList.get(i).getGpa());
        }
    }
    
    public boolean updateStudentInfor(int id, String name, int age, double gpa) {
    	for(int i = 0; i < StudentList.size(); i++) {
    		if(StudentList.get(i).getId() == id) {
    			StudentList.get(i).setName(name);
    			StudentList.get(i).setAge(age);
    			StudentList.get(i).setGpa(gpa);
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean deleteStudent(String name) {
    	boolean res = false;
    	for(int i = 0; i < StudentList.size(); i++) {
    		if(StudentList.get(i).getName().equals(name)) { //compares two strings
    			StudentList.remove(i); 
    			i--;
    			res = true;
    		}
    	}
    	return res;
    }
    
    public boolean searchStudent(String name) {
    	boolean found = false;
    	for(int i = 0; i < StudentList.size(); i++) {
    		if(StudentList.get(i).getName().equals(name)) {
    			if(found == false) {
    				found = true;
    				System.out.println("All students that macth the search key in list:");
    		        System.out.printf("%-8s\t%-20s\t%-8s\t%-8s\n", "ID", "Name", "Age", "GPA");
    			}
    			System.out.printf("%-8d\t%-20s\t%-8d\t%-8.2f\n",  StudentList.get(i).getId(),  StudentList.get(i).getName()
    		            ,  StudentList.get(i).getAge(),  StudentList.get(i).getGpa());
    		}
    	}
    	return found;
    	
    }
    
    public void sort(boolean order) {
    	if(order) { //ascending order
    		boolean check = true; //ton tai 1 cap elements ma pha vo quy tac cua mang
    		while(check) {
    			check = false; //gia su khong ton tai cap elements nao pha vo quy tac cua mang trong lan sap xep nay
    			for(int i = 0; i <= StudentList.size() - 2; i++) {
    				if(StudentList.get(i).getGpa() > StudentList.get(i+1).getGpa()) {
    					check = true;
    					Collections.swap(StudentList, i, i+1); //use built-in method of Collections class to swap Student(i) and Student(i+1)
    				}

    			}
    		}
    		
    	}else { //descending order
    		boolean check = true; //ton tai 1 cap elements ma pha vo quy tac cua mang
    		while(check) {
    			check = false; //gia su khong ton tai cap elements nao pha vo quy tac cua mang trong lan sap xep nay
    			for(int i = 0; i <= StudentList.size() - 2; i++) {
    				if(StudentList.get(i).getGpa() < StudentList.get(i+1).getGpa()) {
    					check = true;
    					Collections.swap(StudentList, i, i+1); //use built-in method of Collections class to swap Student(i) and Student(i+1)
    				}

    			}
    		}
    	}
    }
    
    public boolean saveStudents(String fileName, boolean text) {
        if (text) {
            //save as text file
            try{
                File f = new File(fileName);
                FileWriter fw = new FileWriter(f); 
                for(int i = 0; i < StudentList.size(); i++){
                    fw.write(StudentList.get(i).getName() + ";" + StudentList.get(i).getAge() + ";" +StudentList.get(i).getGpa() + "\n");
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
                for(int i = 0; i < StudentList.size(); i++){
                    temp.add(StudentList.get(i).getName() + ";" + StudentList.get(i).getAge() + ";" + StudentList.get(i).getGpa());
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
    
    public boolean loadStudent(String fileName, boolean text) { //feature 8: load products from file -> save to cart
        if (text) {
            //load from text file
            try{
                File f = new File(fileName);
                Scanner sc = new Scanner(f);
                while(sc.hasNextLine()){
                    String str =  sc.nextLine();
                    String[] line = str.split(";");
                    Student st = new Student(line[0], Integer.parseInt(line[1]), Double.parseDouble(line[2]));
                    StudentList.add(st);
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
                    StudentList.add(new Student(line[0], Integer.parseInt(line[1]), Double.parseDouble(line[2])));
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

