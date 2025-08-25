import java.util.Stack;

class evaluatereversepolishnotation {

    
    public static void main(String[] args) {
     
     String[] tokens = {"2", "1", "+", "3", "*"};

        System.out.println(evalRPN(tokens)); 
    }


    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int divisor = stack.pop();
                    int dividend = stack.pop();
                    stack.push(dividend / divisor); 
                    break;
                default:
                    stack.push(Integer.parseInt(token)); 
            }
        }

        return stack.pop();
    }
}
