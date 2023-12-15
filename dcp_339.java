/******************************************************************************

Given an array of numbers and a number k, determine if there are three entries 
in the array which add up to the specified number k. 
For example, given [20, 303, 3, 4, 25] and k = 49, 
return true as 20 + 4 + 25 = 49.

*******************************************************************************/

import java.util.*;

public class Main
{
    //Total time complexity : O(nlog(n)) + O(n^2) ~ O(n^2)
    private static boolean dcp_339(int[] arr,int k){
        //Edge case
        if(arr.length < 3) return false;
        // If the length is going to be three, then we can solve this by O(1)
        if(arr.length==3){
            int sum=0;
            for(int i:arr) sum+=i;
            if(sum==k) return true;
            else return false;
        }
        
        //O(nlog(n))
        Arrays.sort(arr);
        //O(n)
        for(int i=0;i<arr.length;i++){
            int twoSum=k-arr[i];
            int j=i+1;
            int l=arr.length-1;
            //O(n)
            while(j<l){
                int sum=arr[j]+arr[l];
                if(sum==twoSum) return true;
                else if(sum<twoSum) j++;
                else l--;
            }
        }
        
        return false;
    }
    
	public static void main(String[] args) {
		System.out.println(dcp_339(new int[]{4,25,303,3,20},49));
		System.out.println(dcp_339(new int[]{4,20,303,3,20},44));
		System.out.println(dcp_339(new int[]{4,20,20},44));
		System.out.println(dcp_339(new int[]{4,20},44));
		System.out.println(dcp_339(new int[]{4,20,20},12));
	}
}
