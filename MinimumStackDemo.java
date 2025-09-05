import java.util.Stack;

// MinStack implementation
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    // Constructor
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    // Pop element
    public void pop() {
        if (stack.isEmpty()) return;
        int removed = stack.pop();
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    // Top element
    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }

    // Get minimum element
    public int getMin() {
        if (minStack.isEmpty()) return -1;
        return minStack.peek();
    }
}

// Main class to test
public class MinimumStackDemo {
    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.push(2);

        System.out.println("Top: " + ms.top());         // 2
        System.out.println("Min: " + ms.getMin());      // 2

        ms.pop();
        System.out.println("Top after pop: " + ms.top());   // 7
        System.out.println("Min after pop: " + ms.getMin()); // 3
    }
}
