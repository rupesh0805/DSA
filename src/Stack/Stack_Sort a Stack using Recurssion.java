/*
https://www.codingninjas.com/codestudio/problems/sort-a-stack_985275?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0

You’re given a stack consisting of 'N' integers. Your task is to sort this stack in descending order using recursion.
We can only use the following functions on this stack S.
is_empty(S) : Tests whether stack is empty or not.
push(S) : Adds a new element to the stack.
pop(S) : Removes top element from the stack.
top(S) : Returns value of the top element. Note that this function does not remove elements from the stack.

Sample Input 1:
1
5
5 -2 9 -7 3
Sample Output 1:
9 5 3 -2 -7
Explanation Of Sample Input 1:
9 Is the largest element, hence it’s present at the top. Similarly 5>3, 3>-2 and -7 being the smallest element is present at the last.

*/

import java.util.*;
public class Solution {
public static void sortLogic(Stack<Integer> stack,int x) {
    if(stack.isEmpty() || x>=stack.peek()){
        stack.push(x);
        return;
    }
    int z = stack.pop();
    sortLogic(stack,x);
    stack.push(z);
}

public static void sortStack(Stack<Integer> stack) {
    if(stack.isEmpty()){
        return;
    }       
    int x = stack.pop();
    sortStack(stack);
    sortLogic(stack,x);      
}
}


//Alternate Solution with help of ArrayList

static ArrayList<Integer> list;
    
    public static void recSort(Stack<Integer> stack,int x){
        if(stack.isEmpty()==true){
            list.sort((s1,s2)-> - s2.compareTo(s1));
            return;
        }
        int element = stack.pop();
        list.add(element);
        recSort(stack,x-1);
        stack.push(list.get(x));
        
    }

	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
        list=new ArrayList<>();
        recSort(stack,stack.size()-1);
	}