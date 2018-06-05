package nowcoder.jianzhioffer.a.a5_栈和队列_用两个栈实现队列;

import java.util.Stack;

/*
* 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
* */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    // 向队列尾中添加一个元素
    public void push(int node) {
        stack1.push(node);
    }

    // 取出最先入队列（队列顶）的元素
    public int pop() {
        // 把stack1中的元素全部放到stack2中
        // 实现倒置操作，此时最先入队的元素在栈顶，可以取出
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // 如果此时队列不为空，把剩余元素再原样放回stack1
        int first = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return first;
    }
}
