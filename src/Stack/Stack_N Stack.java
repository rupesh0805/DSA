/*
Design a data structure to implement ‘N’ stacks using a single array of size ‘S’. It should support the following operations:
push(X, M): Pushes an element X into the Mth stack. Returns true if the element is pushed into the stack, otherwise false.

pop(M): Pops the top element from Mth Stack. Returns -1 if the stack is empty, otherwise, returns the popped element.


*/


public class NStack {
    // Initialize your data structure.
    
    //Main array
    int[] arr;
    //Array to store top of M stacks
    int[] top;
    //Shows next free spot if empty
    //else stores the index of below elements of stack
    int[] next;
    //GIves the index which is free
    int freeSpot=0;
    public NStack(int N, int S) {
        // Write your code here.
        arr= new int[S];
        top = new int[N];
        next = new int[S];
        //Initialise top elements with -1
        for(int i=0;i<N;i++){
            top[i]= -1;
        }     
        //Initilaise next element with next available free space
        for(int i=0;i<S-1;i++){
            next[i]=i+1;
        }
        next[S-1]= -1;
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x, int m) {
        // Write your code here.
        if(freeSpot== -1){
            return false;
        }
        int index = freeSpot;
        arr[index] = x;
        freeSpot = next[index];
        next[index] = top[m-1];
        top[m-1] = index;
        return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        // Write your code here.
        if(top[m-1]==-1){
            return -1;
        }
        int topIndex = top[m-1];
        int topElement = arr[topIndex];
        top[m-1] = next[topIndex];
        next[topIndex]=freeSpot;
        freeSpot = topIndex;
        return topElement;
        
    }
}