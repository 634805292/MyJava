package core.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//给出逆波兰表达式，计算结果
public class PolandNotation {
    public static void main(String[] args) {

        String suffixExpression = "30 4 + 5 * 6 -";
        List<String> list = getListString(suffixExpression);
        int res = calcuate(list);
        System.out.println("计算结果是=" + res);
    }

    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }

        return list;
    }


    public static int calcuate(List<String> ls){

        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            if(item.matches("\\d+")){
                stack.push(item);
            }else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")){
                    res = num1 + num2;
                }else if(item.equals("-")){
                    res = num1 - num2;
                }else if(item.equals("*")){
                    res = num1 * num2;
                }else if(item.equals("/")){
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }

                stack.push(""+res);
            }
        }

        return Integer.parseInt(stack.pop());
    }

}
