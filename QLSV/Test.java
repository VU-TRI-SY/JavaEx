package QLSV;

class Base{
    public void show(){
        System.out.println("Show in Base class");
    }

    public void print(){
        System.out.println("print in Base class");
    }
}

class Derived extends Base{
    public void show(){
        System.out.println("Show in Derived class");
    }

    public void print(){
        System.out.println("print in Derived class");
    }
}
public class Test{
    public static void main(String[] args){
        Base b = new Derived();
        Derived d = (Derived) b;
        d.print();
        d.show();
    }
}