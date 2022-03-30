import java.util.Stack;     
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class RPNStack{
    //private static final Exception IOException = null;

    public static void main(String[] args) throws java.io.IOException {
        Stack<Integer> stack = new Stack<>();
        String path = "caminho para o arquivo txt";

        String value = "";
        Scanner in = new Scanner(new FileReader(path)); //lendo o arquivo de texto
        System.out.println(value);
        int op1, op2;
    
        while(in.hasNext()){
           value = in.next();
           
            switch(value){
                case "+":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op1+op2);
                    break;
                case "-":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1-op2);
                    break;
                case "/":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1/op2);
                    break;
                case "*":
                op1 = stack.pop();
                op2 = stack.pop();
                stack.push(op1*op2);
                break;
                default:
                    stack.push(Integer.valueOf(value));
            }
        }
        System.out.println("O resultado da sua operação é: " + stack.pop());

    }
}