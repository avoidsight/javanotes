import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort{
    public static void sort(int arr[],int l,int r){
        if(!(l<r)) return;
        int left = l;
        int right = r;
        int index = arr[left];
        while(left < right){
            
            for(;left<right;right--){
                if(arr[right] < index){
                    break;
                }
            }
            for(;left<right;left++){
                if(arr[left] > index){
                    break;
                }
            }
            swap(arr,right,left);
        }
        swap(arr,l,left);
        sort(arr,l,left-1);
        sort(arr,left+1,r);
    }
    public static void swap(int arr[],int l,int r){
        int c = arr[l];
        arr[l] = arr[r];
        arr[r] = c;
    }
    public static void main(String[] args) {
        int arr[] = {3,1,4,1,5,9,2,6,5,7,5,4,2,0};
        sort(arr,0,13);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }
}