public class FileHandling{
    public static void main(String[] args){
        String text = "Java is a fun programming language";
        String[] a = text.split(" ");
        for(String tp: a){
            System.out.print(tp);
        }
    }
}