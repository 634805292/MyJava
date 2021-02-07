package core.search;

import java.util.Arrays;

/**
 * @author ：SevenYear
 * @description：TODO
 * @date ：2021/1/4 10:46
 */
public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println("index = " + fibonacciSearch(arr, 1000));

    }

    /**
     * 因为后面我们mid=low+F(k-1)-1，需要使用到斐波那契数列，因此我们需要先获取到一个斐波那契数列
     * 非递归方法得到一个斐波那契数列
     *
     * @return
     */
    public static int[] Fibonacci() {
        int[] F = new int[maxSize];
        F[0] = 1;
        F[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }
        return F;
    }

    /**
     * 使用非递归的方式
     *
     * @param arr 数组
     * @param key 需要查找的关键码(值)
     * @return 返回对应的下表，如果没有返回-1
     */
    public static int fibonacciSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0; //表示斐波那契分割数值的下标
        int mid = 0; //存放mid值
        int f[] = Fibonacci();
        //获取到斐波那契分割数值的下表
        while (arr.length > f[k] - 1) {
            k++;
        }
        //因为f[k]的值可能大于数组长度，因此需要使用Arrays类，构造一个新的数组，并指向arr
        //不足的部分会使用0填充
        //temp = {1,8, 10, 89, 1000, 1234, 0, 0} => {1,8, 10, 89, 1000, 1234, 1234, 1234,}
        int[] temp = Arrays.copyOf(arr, f[k] - 1);
        //实际生需要使用arr数组的最后的数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        //使用while循环来处理，找到我们的数key
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            //我们应该继续向数组的前面查找(左边)
            if (key < temp[mid]) {
                high = mid - 1;
                /*
                说明：
                    1. 全部元素= 前面的元素+ 后边元素
                    2. f[k] = f[k-1] + f[k-2]
                    因为前面有f[k-1]个元素,所以可以继续拆分f[k-1] = f[k-2] + f[k-3]
                    即在f[k-1] 的前面继续查找k--
                    即下次循环mid = f[k-1-1]-1
                 */
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                /*
                说明：
                    1.全部元素= 前面的元素+ 后边元素
                    2.f[k] = f[k-1] + f[k-2]
                    3.因为后面我们有f[k-2] 所以可以继续拆分f[k-1] = f[k-3] + f[k-4]
                    4.即在f[k-2] 的前面进行查找k -=2
                    5.即下次循环mid = f[k - 1 - 2] - 1
                 */
                k -= 2;
            } else {
                //需要确定是返回的哪个下标
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }

}
