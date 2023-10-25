/**
 * Given an array of integers, return a new array such that each element at 
 * index i of the new array is the product of all the numbers in the original array except the one at i.
 * 
 * For example, if our input was [1, 2, 3, 4, 5], 
 * the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * 
 * Follow-up: what if you can't use division?
*/
import java.util.*;
import java.util.stream.*;

public class Main
{
    // TC: 2*O(n) ~ O(n)
    // SC : O(n)
    private static int[] dcp_2(int[] input){
        //Edge case.
        if(input==null) return new int[]{};
	// SC : O(n)
        int[] result=new int[input.length];
        Arrays.fill(result,1);
        //Calculating left Product of self.
        int temp=1;
	// TC: O(n)
        for(int i=1;i<input.length;i++){
            temp*=input[i-1];
            result[i]=temp;
        }
        temp=1;
	// TC: O(n)
        //Calculating right Product of self.
        for(int i=input.length-2;i>=0;i--){
            temp*=input[i+1];
            result[i]*=temp;
        }
        return result;
    }
    
    private static void dcp_2_test(int[] input,int[] expectedOutput,int testCase){
        if(Arrays.equals(dcp_2(input),expectedOutput)) System.out.printf("Test case %s passed :)%n", testCase);
        else System.out.printf("Test case %s failed :(%n", testCase);
    }
    
    public static void main(String[] args) {
	//Test case 1 
	dcp_2_test(new int[]{1,2,3,4,5},new int[]{120,60,40,30,24},1);
	//Test case 2
	dcp_2_test(new int[]{},new int[]{},2);
	//Test case 3
	dcp_2_test(null,new int[]{},3);
    }
}

