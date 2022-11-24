package lecture12;

public class BinarySearchDemo {
    public static int binarySearch(int[] a, int k, int low, int high){
        if(low > high){
            return -1;
        }else{
            int mid = (low + high)/2;
            if(a[mid] == k){
                return mid;
            }else{
                if(a[mid]  > k){
                    return binarySearch(a, k, low, mid-1);
                }else{
                    return binarySearch(a, k, mid+1, high);
                }
            }
        }
    }
    public static void main(String[] args){
        int a[] = {0,1,2,3,4,5,6,7,8,9};
        int k = 5;
        int res = binarySearch(a, k, 0, a.length-1);
        if(res == -1){
            System.out.println("Cannot find the element " + k + " in the array a");
        }else{
            System.out.println("The position of element " + k + " in the array a is : " + res);
        }
    }
}
