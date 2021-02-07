package core.search;

/**
 * @author ：SevenYear
 * @description：TODO
 * @date ：2021/1/4 10:28
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int index = insertValueSearch(arr, 0, arr.length - 1, 1);
        System.out.println("index = " + index);
    }


    /**
     *     下面 的东西 大家一定要注意说一下 插值算法的 优劣性
     *          对于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找, 速度较快.
     *          关键字分布不均匀的情况下，该方法不一定比折半查找要好
     * @param arr     数组
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 查找值
     * @return 如果找到，就返回对应的下标，如果没有找到，返回-1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        System.out.println("插值查找被调用~");
        //注意：findVal < arr[0] 和findVal > arr[arr.length - 1] 必须需要,否则我们得到的mid 可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        //求出mid，自适应
        int mid = left + (findVal - arr[left]) / (arr[right] - arr[left]) * (right - left);
        int midVal = arr[mid];
        if (findVal > midVal) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
