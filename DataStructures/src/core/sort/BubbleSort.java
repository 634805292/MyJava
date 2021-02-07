package core.sort;

import com.sun.jndi.ldap.Ber;

import java.security.cert.TrustAnchor;
import java.util.Arrays;
import java.util.concurrent.ThreadFactory;

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, 20};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /*public static void bubbleSort(int[] arr){

        int temp = 0;
        boolean flag = false;  //标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            System.out.println("第"+(i+1)+"趟排序后的数组");
            System.out.println(Arrays.toString(arr));

            if(!flag){  //在一趟排序中，一次交换都没有发生过
                break;
            }else {
                flag = false;  //重置flag，进行下次判断
            }
        }

    }*/

    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] =  arr[j+1];
                    arr[j+1] = temp;
                }
            }

            if(!flag){
                break;
            }else{
                flag = false;
            }
        }
    }


}
