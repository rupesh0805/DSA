package Graph;

/*
Given an array of n distinct elements.
Find the minimum number of swaps required to sort the array in strictly increasing order.
Input:
nums = {10, 19, 6, 3, 5}
Output:
2
Explanation:
swap 10 with 3 and swap 19 with 5.

Soln:
Create an array , sort it and  correct seq in Map
From index 1->n
    if not same
    Place index i into its correct position


Complexity
Time Complexity: O(N * Log N) where N is the length of the input array ,
Constructing the HashMap takes O(N) time, Sorting the array take O(NLogN) time and The two loops each iterate through the array of length N,
which takes O(N) time so overall time will be O(N*LogN).

Auxiliary Space: O(N) , temporary array temp takes O(N) space.
The HashMap h stores at most N key-value pairs, which also takes O(N) space.
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapsToSort
{

    public void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Placing nums[i] to correct position [Best]
    public int GraphSol2(int[] nums){

        int n = nums.length;

        int[] arr = Arrays.copyOf(nums,n);
        Arrays.sort(arr);

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }

        int swapCount = 0;

        for(int i=0;i<n;i++){

            int idx = i;
            while(arr[idx]!=nums[idx]){
                int correctIdx = map.get(nums[idx]);
                swap(idx,correctIdx,nums);
                swapCount++;
            }

        }

        return swapCount;

    }


    //Placing correct element at ith position
    public int GraphSol(int[] nums){

        int n = nums.length;

        int[] arr = Arrays.copyOf(nums,n);
        Arrays.sort(arr);

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }

        int swapCount = 0;

        for(int i=0;i<n;i++){

            int idx = i;
            while(arr[idx]!=nums[idx]){
                int prevIdx = map.get(arr[idx]);
                swap(idx,prevIdx,nums);
                map.put(nums[idx],idx);
                map.put(nums[prevIdx],prevIdx);
                idx = prevIdx;
                swapCount++;
            }

        }

        return swapCount;

    }


    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        // return GraphSol(nums);
        return GraphSol2(nums);

    }
}
