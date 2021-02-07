package core.tree;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 堆排序
 * 升序 => 大顶堆
 * 降序 => 小顶堆
 *
 * @author ：SevenYear
 * @description：TODO
 * @date ：2021/1/25 10:14
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
    }

    /*    *//**
     * 堆排序
     *
     * @param arr
     *//*
    public static void heapSort(int[] arr) {
        int temp = 0;
        System.out.println("堆排序！");
        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        *//*
        将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
        重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换
         步骤，直到整个序列有序。
         *//*
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);

        }
        System.out.println("数组=" + Arrays.toString(arr));

    }



    */

    /**
     * 将一个数组(二叉树)，调整成大顶堆
     * 功能： 完成将以i 对应的非叶子结点的树调整成大顶堆
     * 举例int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到{4, 9, 8, 5, 6}
     * 如果我们再次调用adjustHeap 传入的是i = 0 => 得到{4, 9, 8, 5, 6} => {9,6,8,5, 4}
     *
     * @param arr    待调整的数组
     * @param i      非叶子节点在数组中的索引
     * @param length 表示堆多少个元素进行调整，length是在逐渐减少
     *//*
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {//左子节点<右子节点
                j++;  //j指向右子节点
            }
            if (arr[j] > temp) { //如果子节点大于父节点
                arr[i] = arr[j]; //把较大的值赋给当前节点
                i = j;  //i指向j，继续循环比较
            } else {
                break;
            }
        }
        //当for循环结束后，我们已经将以i为父节点的树的最大值，放在了最顶(局部)
        arr[i] = temp;  //将temp值放入到调整后的位置
    }*/
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    public static void heapSort(int[] arr) {
        int temp = 0;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);

        }
        System.out.println("数组=" + Arrays.toString(arr));
    }

}
