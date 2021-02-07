package core.stack;



public class Calculator {
    public static void main(String[] args) {

        String expression = "7*2*2-5+1-5+3-4";

        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        //定义相关变量
        int index = 0; //用于扫描
        int num1 = 0,num2 = 0,oper = 0;
        int res = 0;
        char ch = ' '; //将每次扫描得到的char保存到ch
        String keepNum = ""; //用于拼接多位数
        //开始while循环的扫描expression
        while (true){
            ch = expression.substring(index,index+1).charAt(0);
            if(operStack.isOper(ch)){
                if(!operStack.isEmpty()){
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res  = numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }else {
                    operStack.push(ch);
                }
            }else{
                keepNum += ch;
                if(index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }

            index++;
            if(index >= expression.length()){
                break;
            }
        }

        while (true){
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }

        int res2 = numStack.pop();
        System.out.printf("表达式 %s = %d",expression,res2);

    }
}


class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }


    public boolean isFull(){
        return top == maxSize -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("栈满。。。");
        }
        stack[++top] = value;
    }


    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空，没有数据。。。");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public int peek(){
        return stack[top];
    }

    public void list(){
        if(isEmpty()){
            System.out.println("栈空，没有数据...");
            return;
        }

        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d=%d\n",i,stack[i]);

        }
    }

    //返回运算符优先级，数字越大，优先级越高
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }else if(oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }


    //计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;  //用于保存计算结果
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }

        return res;
    }
}
