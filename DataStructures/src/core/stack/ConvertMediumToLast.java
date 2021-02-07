package core.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//将中缀表达式变成后缀表达式
public class ConvertMediumToLast {

    //1. 1+((2+3)×4)-5 => 转成1 2 3 + 4 × + 5 –
    //2. 因为直接对str 进行操作，不方便，因此先将"1+((2+3)×4)-5" =》中缀的表达式对应的List
    // 即"1+((2+3)×4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
    //3. 将得到的中缀表达式对应的List => 后缀表达式对应的List
// 即ArrayList [1,+,(,(,2,+,3,),*,4,),-,5] =》ArrayList [1,2,3,+,4,*,+,5,–]
    public static void main(String[] args) {

        String expression = "1+((2+3)*4)-5";
        List<String> list = toInfixExpression(expression);
        System.out.println(list);

        List<String> parseSuffixExpressionList = parseSuffixExpressionList(list);
        System.out.println("后缀表达式对应的List"+parseSuffixExpressionList);
    }


    //将中缀表达式转为对应的List
    public static List<String> toInfixExpression(String s){

        List<String> ls = new ArrayList<>();
        int i = 0; //遍历中缀表达式字符串
        String str; //做对多位数的拼接
        char c; //每遍历到一个字符就放入c
        do {
            //如果c是一个非数字,就需要加入到ls
            if((c=s.charAt(i)) < 48 || (c=s.charAt(i)) > 57){
                ls.add(""+c);
                i++;
            }else {
                //如果是一个数，需要考虑多位数的问题
                str = "";
                while (i < s.length() && (c=s.charAt(i))>= 48 && (c=s.charAt(i)) <= 57){
                    str += c;
                    i++;
                }
                ls.add(str);


            }

        }while (i < s.length());

        return ls;
    }

    public static List<String> parseSuffixExpressionList(List<String> ls){
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();

        //遍历ls
        for (String item : ls) {
            //如果是一个数
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop(); // 将（弹出s1栈，消除小括号
            }else {
                //当item的优先级 <= 栈顶运算符，将s1栈顶的运算符弹出并加入到s2
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //需要将item压入栈
                s1.push(item);
            }
        }

        //将是s1中剩余的运算符压入s2
        while (s1.size() != 0){
            s2.add(s1.pop());
        }

        return s2;

    }

}

class Operation{

    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符。。。。");
                break;

        }

        return result;

    }

}
