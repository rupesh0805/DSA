/*
You are not allowed to use any extra space other than the internal stack space used due to recursion.
You are not allowed to use the loop constructs of any sort available as handy. For example: for, for-each, while, etc. 
The only inbuilt stack methods allowed are:
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.

*/



import java.util.Stack;

public class Solution {
    
    //Before inserting remove all the ekements that stack has, then insert
    public static void helper(Stack<Integer> stack,int x) {
        if(stack.isEmpty()){
            stack.push(x);
            return;
        }
        int z = stack.pop();
        helper(stack,x);
        stack.push(z);    
    }
    
	public static void reverseStack(Stack<Integer> stack) {
		// write your code here
        if(stack.isEmpty()){
            return;
        }
        int x = stack.pop();
        reverseStack(stack);
        helper(stack,x);		
	}
}

