package core.recursion;


public class Queue8 {


    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array，保存皇后放置位置的结果
    int[]  array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        //测试一把，8皇后是否正确
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d种解法",count);
    }


    //编写一个方法，放置第n个皇后
    private void check(int n ){
        if(n == max){    // n=8,其实8个皇后就已然放好了
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n，放到该行的第1列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if(judge(n)){  //不冲突
                //接着放n+1个皇后，即开始递归
                check(n+1);
            }
            //如果冲突，就继续执行arrayp[[n] = i; 即将第n个皇后，放置在本行的后移一个位置
        }
    }

    //查看当我们放置第n个皇后，去检测该皇后是否和前面已经摆放的皇后冲突

    /**
     *
     * @param n 放置的第n个皇后
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //1. array[i] == array[n] 表示判断第n个皇后是否和前面n-1个皇后在同一列
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i] 表示判断第n个皇后是否和第i个皇后在同一斜线上
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }

        return true;
    }

    //写一个方法，将皇后摆放的位置输出
    private void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
