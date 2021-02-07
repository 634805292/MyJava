package core.queue;

import com.sun.glass.ui.Size;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(3);
        char key = ' '; //接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0); //接受一个字符
            switch (key){
                case 's':
                    circleArray.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int value = scanner.nextInt();
                    circleArray.addQueue(value);
                    break;
                case 'g':

                    try {
                        int res = circleArray.getQueue();
                        System.out.printf("去除的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':

                    try {
                        int res = circleArray.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

            }

        }
    }
}


class CircleArray{
    private int maxSize; //数组的最大容量
    private int front;  //队列头
    private int rear;  //队列尾
    private int[] arr;  //用于存放数据，模拟队列


    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        return rear == front;
    }

    public boolean isEmpty(){
        return (rear+1) % maxSize == front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列满了");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new  RuntimeException("队列空，不能取数据");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空的，没有数据~");
            return;
        }
        for (int i = 0; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }

    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空的，没有数据");
        }
        return arr[front];
    }
}
