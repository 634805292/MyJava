package core.sort;

import java.util.Arrays;

/**
 * @author ：SevenYear
 * @description：TODO
 * @date ：2020/12/29 15:10
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] arr = {-9, 78, 0, 23, -567, 70};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));

    }


    public static void quickSort(int[] arr, int low, int high) {
        if(low <high){
            int index = getIndex(arr,low,high);
            quickSort(arr,low,index-1);
            quickSort(arr,index+1,high);
        }
    }

    public static int getIndex(int[] arr,int low,int high){
        //基准数据
        int temp = arr[low];
        while (low<high){
            while (low<high&&arr[high] >= temp){
                high--;
            }
            arr[low] = arr[high];

            while (low<high&&arr[low]<=temp){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }


}
