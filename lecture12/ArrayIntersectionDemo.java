package lecture12;
import java.util.HashSet;
public class ArrayIntersectionDemo{
    public static HashSet<Integer> intersect(HashSet<Integer> A, HashSet<Integer> B){
        HashSet<Integer> C = new HashSet<>();
        for(int x : A){
            if(B.contains(x)){
                C.add(x);
            }
        }
        return C;
    }
    public static void main(String[] args){
        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();
        HashSet<Integer> C;
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        A.add(6);
        A.add(7);
        A.add(8);
        A.add(9);

        B.add(-1);
        B.add(1);
        B.add(3);
        B.add(5);
        B.add(10);

        C = intersect(A, B);
        System.out.println(C);
    }
}