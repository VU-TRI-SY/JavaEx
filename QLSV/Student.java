package QLSV;

public class Student{
    private static int count = 0;
    private int id;
    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa){
        count++;
        this.id = count;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    //setter
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setGpa(double gpa){
        this.gpa = gpa;
    }

    //getter
    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public double getGpa(){
        return this.gpa;
    }
}

