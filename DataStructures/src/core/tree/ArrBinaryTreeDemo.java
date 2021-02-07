package core.tree;

/**
 * @author ：SevenYear
 * @description：TODO
 * @date ：2021/1/24 10:42
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.postOrder(0);
    }

}

//顺序存储二叉树
class ArrBinaryTree {
    private int[] arr;  //存储数据节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }
    /**
     * 前序遍历
     *
     * @param index 数组下标
     */
    public void preOrder(int index) {
        //如果数组为空，或者arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前这个元素
        System.out.print(arr[index]+",");
        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归遍历
        if (index * 2 + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    public void infxOrder(int index) {
        //如果数组为空，或者arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            infxOrder(2 * index + 1);
        }
        //输出当前这个元素
        System.out.print(arr[index]+",");

        //向右递归遍历
        if (index * 2 + 2 < arr.length) {
            infxOrder(2 * index + 2);
        }
    }

    public void postOrder(int index) {
        //如果数组为空，或者arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            postOrder(2 * index + 1);
        }

        //向右递归遍历
        if (index * 2 + 2 < arr.length) {
            postOrder(2 * index + 2);
        }

        //输出当前这个元素
        System.out.print(arr[index]+",");
    }
}
