package core.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insertSort3(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort(int[] arr) {
        int inserVal = 0;
        int insertIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            inserVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && inserVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = inserVal;
            }
        }
    }

    public static void insertSort2(int[] arr) {
        int insertVal = 0;
        int insetIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insetIndex = i;
            while (insetIndex - 1 >= 0 && insertVal < arr[insetIndex-1]) {
                arr[insetIndex] = arr[insetIndex-1];
                insetIndex--;
            }
            if (insetIndex!= i){
                arr[insetIndex] = insertVal;
            }
        }
    }

    public static void insertSort3(int[] arr){
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i;
            while (insertIndex-1>=0&& insertVal<arr[insertIndex-1]){
                arr[insertIndex] = arr[insertIndex-1];
                insertIndex--;
            }
            if(insertIndex != i){
                arr[insertIndex] = insertVal;
            }
        }
    }
}
