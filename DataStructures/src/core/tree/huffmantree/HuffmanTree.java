package core.tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.LongFunction;

/**
 * @author ：SevenYear
 * @description：TODO
 * @date ：2021/1/26 10:35
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        preOrder(root);
    }


    public static Node createHuffmanTree(int[] arr) {
        //为了操作方便，将Node加入到ArrayList
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            Collections.sort(nodes);
           // System.out.println("nodes");
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }


    public static void preOrder(Node root) {
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("是空树，不能遍历。。。");
        }
    }
}


/**
 * 节点类
 * 为了让NOde对象支持排序Collections集合排序
 * 让NOde实现Comparable接口
 */
class Node implements Comparable<Node> {
    int value;  //权值
    Node left;  //左子节点
    Node right; //右子节点

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.value - o.value;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
