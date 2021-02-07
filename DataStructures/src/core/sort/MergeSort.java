package core.sort;

import java.util.Arrays;

/**
 * @author ：SevenYear
 * @description：TODO
 * @date ：2020/12/30 14:38
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int[] arr, int low, int mid, int high, int[] temp) {
        //初始化i，左边有序序列的初始索引
        int i = low;
        //初始化j，右边有序序列的初始索引
        int j = mid + 1;
        //指向temp数组的当前索引
        int t = 0;
        //先把左右两边(有序)的数据按照规则填充到temp 数组,直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //把有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        //把有剩余数据的一边的数据依次全部填充到temp
        while (j <= high) {
            temp[t++] = arr[j++];
        }

        //排好序后复制到原来数组的对应位置
        for (int k = 0; k < t; k++) {
            arr[low + k] = temp[k];
        }
    }

    public static void mergeSort(int[] arr, int low, int high, int[] temp) {
        if (low < high){
            int mid = (low+high)/2;
            //对左边序列进行归并排序
            mergeSort(arr,low,mid,temp);
            //对右边序列进行归并排序
            mergeSort(arr,mid+1,high,temp);
            //合并两个有序序列
            merge(arr,low,mid,high,temp);
        }
    }
}
