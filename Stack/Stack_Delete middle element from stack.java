/*
INPUT : ARR [ ] = [ 1 , 2 , 3 , 4 , 5 ] , N = 4
OUTPUT: ARR [ ] = [ 1 , 2 , 4,  5 ]

The above example contains an odd number of elements,
 hence the middle element is clearly the (N+1) / 2th element,
 which is removed from the stack in the output.

INPUT : ARR [ ] = [ 5, 6, 7, 8 ] , N = 3
OUTPUT: ARR [ ] = [ 5, 7, 8 ]

The above example contains an even number of elements,
 so out of the two middle elements, we consider the one which occurs first.
 Hence, the middle element would be ((N+1) / 2 - 1) element,
 which is 6 and is removed from the stack in the output.
*/


import java.util.*;
public class Solution {
    
    public static void recursiveSoln(Stack<Integer> inputStack, int N){
        //Once we have middle element on top of Stack, we just pop
        //and then return, We don't push it again.
        if(inputStack.size()==N/2+1){
            inputStack.pop();
            return;
        }
        int x = inputStack.pop();
        recursiveSoln(inputStack,N);
        inputStack.push(x);
    }
    
    public static void iterativeSoln(Stack<Integer> inputStack, int N) {
        int mid = (N+1)%2==0?(N+1)/2-1:(N+1)/2;
        Stack<Integer> q = new Stack<>();
        while(inputStack.size()!=mid){
            q.push(inputStack.pop());
        }
        q.pop();
        while(q.isEmpty()==false){
            inputStack.push(q.pop());
        }       
    }
    
	public static void deleteMiddle(Stack<Integer> inputStack, int N) {
		// WRITE YOUR CODE HERE
        recursiveSoln(inputStack,N);
        iterativeSoln(inputStack,N);
        }
}