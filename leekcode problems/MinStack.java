import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        System.out.println(minStack.top());     // 2
        System.out.println(minStack.getMin());  // 1
        minStack.pop();
        System.out.println(minStack.top());     // 1
        System.out.println(minStack.getMin());  // 1
    }

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        // maintain minimum stack
        if (minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
    }

    public void pop() {
        int poppedValue = stack.pop();

        // if popped value is the current min, remove it from minStack too
        if (poppedValue == minStack.peek())
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
