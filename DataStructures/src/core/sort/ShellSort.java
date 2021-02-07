package core.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] arr1 = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
        shellSort3(arr1);
        System.out.println(Arrays.toString(arr));

    }


    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("希尔排序第" + (++count) + "轮=" + Arrays.toString(arr));
        }
    }

    //对交换式的希尔排序进行优化->移位法
    // int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }

            }
        }
    }

    public static void shellSort3(int[] arr) {
        int count = 0;
        int insertVal=0,insertIndex=0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2){
            for (int i= gap;i<arr.length;i++){
                insertIndex = i;
                insertVal = arr[i];
                while (insertIndex-gap>=0&&insertVal<arr[insertIndex-gap]){
                    arr[insertIndex] = arr[insertIndex-gap];
                    insertIndex -= gap;
                }

                arr[insertIndex] = insertVal;
            }
            System.out.println("希尔排序第" + (++count) + "轮=" + Arrays.toString(arr));

        }
    }


}
