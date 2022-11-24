package lecture12;
public class SelectionSortDemo{
    public static int[] selectionSort(int[] a){
        int n = a.length;
        int[] b = new int[n];

        for(int i = 0; i < n; i++){
            int p = i;
            for(int j = i+1; j < n; j++){
                if(a[j] < a[p]){
                    p = j;
                }
            }
            b[i] = a[p];
            a[p] = a[i];
        }
        return b;
    }
    public static void main(String[] args){
        int[] a = {5,4,3,2,1};
        int[] b = selectionSort(a);
        for(int x:b){
            System.out.println(x + " ");
        }
    }
}