package core.binarysorttree;

import javafx.scene.shape.VLineTo;

/**
 * @author ：SevenYear
 * @description：TODO
 * @date ：2021/1/27 10:06
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历二叉排序树");
        binarySortTree.infixOrder();

        System.out.println("删除节点");
        binarySortTree.delNode(1);
        binarySortTree.infixOrder();
    }
}

class BinarySortTree {
    private Node root;

    /**
     * 查找要删除的节点
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 查找要删除节点的父节点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 功能：1、返回以node为根节点的二叉排序树的最小节点的值
     * 2、删除node为根节点的二叉排序树的最小节点
     *
     * @param node 传入的节点(当作二叉排序树的根节点)
     * @return 返回以node为根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左节点，就会找到最小值
        while (target.left != null) {
            target = target.left;
        }
        //此时target指向了最小节点,删除最小节点
        delNode(target.value);
        return target.value;
    }

    /**
     * 删除节点
     *
     * @param value
     */
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //如果当前这颗二叉排序树只有一个节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //1、先找到要删除的节点，targetNode
            Node targetNode = search(value);
            //如果没右找到要删除的节点
            if (targetNode == null) {
                return;
            }
            //去找到targetNode的父节点
            Node parent = searchParent(value);
            if (targetNode.left == null && targetNode.right == null) {
                //如果要删除的节点是叶子节点
                //判断targetNode是父节点的左子节点or右子节点
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                //删除有两棵子树的节点
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            } else {
                //删除只有一棵子树的节点
                //如果要删除的节点，有左子节点
                if (targetNode.left != null) {
                    if (parent != null){
                        //如果targetNode是parent的左子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            //targetNode是parent的右子节点
                            parent.right = targetNode.left;
                        }
                    }else {
                        root = targetNode.left;
                    }
                } else {
                    //如果要删除的节点有右子节点
                    if (parent!=null){
                        if (parent.left.value == value) {
                            //如果targetNode是parent的左子节点
                            parent.left = targetNode.right;
                        } else {
                            //targetNode是parent的右子节点
                            parent.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * 递归的形式添加节点，需要满足二叉排序树的要求
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断传入的节点的值和当前树的根节点的值的关系
        if (node.value < this.value) {
            //如果当前节点的左子节点为null
            if (this.left == null) {
                this.left = node;
            } else {
                //递归的向左子树添加
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                //递归向右子树添加
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 查找要删除的节点
     *
     * @param value 希望删除的节点的值
     * @return 如果找到则返回该节点，否则返回null
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            //如果查找的值小于当前节点，向左子树递归查找,如果左子节点为空，返回null
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }

            return this.right.search(value);

        }
    }

    /**
     * 查找要删除节点的父节点
     *
     * @param value 要删除的节点的值
     * @return 要删除的节点的父节点，如果没有返回null
     */
    public Node searchParent(int value) {
        //如果当前节点就是要删除节点的父节点，就返回
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果查找的值小于当前节点的值，并且当前节点的左子节点不为空，向左递归
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                //没有找到父节点(例：root节点)
                return null;
            }
        }
    }
}
