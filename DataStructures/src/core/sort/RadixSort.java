package core.sort;

import java.util.Arrays;

/**
 * @author ：SevenYear
 * @description：TODO
 * @date ：2020/12/30 15:43
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 基数排序
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {

        //1.得到数组中最大的数的位数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();
        /*
        定义一个二维数组，表示10个桶，每个桶j就是一个一维数组
        说明：1.二维数组包含10个一维数组
              2.为了防止放入数的时候，数据溢出，每一个一维数组大小定位 arr.length
              3.基数排序是使用空间换时间的经典算法
         */
        int[][] bucket = new int[10][arr.length];
        /*
        为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        比如：bucketElementCounts[0] , 记录的就是bucket[0] 桶的放入数据个数
         */
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //针对每个元素对应的位进行排序处理，第一次是个位，第二次是十位......
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的对应位的值
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序(一维数组下表依次取出数据，放入原来数组)
            int index = 0;
            //遍历每一个桶，并将桶中数据放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，才将其放入原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                //第i+1轮处理后，需要将买每个 bucketElementCounts[k] = 0 ！！！
                bucketElementCounts[k] = 0;
            }

            System.out.println("第" + (i + 1) + "轮，排序处理后 arr = " + Arrays.toString(arr));
        }

    }

    public static void sort(int[] arr) {

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        int maxLength = (max + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;
            }
        }


    }
}
