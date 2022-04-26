import java.util.Stack;     
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


public class RPNStack{
    //private static final Exception IOException = null;

    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        String path = "caminho para o arquivo txt";

        String value = "";
        Scanner in = new Scanner(new FileReader(path)); //lendo o arquivo de texto
        System.out.println(value);
        int op1, op2;
        
        while(in.hasNext()){
           value = in.next();
           
           if(value.matches("[+-]?\\d*(\\.\\d+)?")) {
            stack.push(Integer.valueOf(value));
            queue.add(new Token(TokenType.NUM, value).toString());
            continue;

           }
            switch(value){
                case "+":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op1+op2);
                    queue.add(new Token(TokenType.PLUS, value).toString());
                    break;
                case "-":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1-op2);
                    queue.add(new Token(TokenType.MINUS, value).toString());
                    break;
                case "/":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1/op2);
                    queue.add(new Token(TokenType.SLASH, value).toString());
                    break;
                case "*":
                op1 = stack.pop();
                op2 = stack.pop();
                stack.push(op1*op2);
                queue.add(new Token(TokenType.STAR, value).toString());
                break;
                default:
                    throw new Exception("Unexpected value: " + value);
            }
        }
        System.out.println(queue);
        System.out.println("Saída: " + stack.pop());
    }
}
