/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    private static int dcp_4(int[] input){
        //Push all negative elements to the left
        int rightMostNegative = 0;
        for(int i=0;i<input.length;i++){
            if(input[i]<=0 || input[i]>input.length+1){
                swap(i,rightMostNegative,input);
                rightMostNegative++;
            }
        }
        
        //Mark the indices which are present in the array.
        for(int i=rightMostNegative;i<input.length;i++){
            int j=input[i];
            if(input[j]>0) input[j]*=-1;
        }
        
        //Find smallest unmarked index.
        for(int i=0;i<input.length;i++){
            if(input[i]>0) return i;    
        }
        
        //If all the elements of the input are negative return N or N+1.
        return containsZero(input) ? input.length : input.length+1;
    }
    
    private static boolean containsZero(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) return true;
        }
        
        return false;
    }
    
    private static void swap(int i,int j,int[] arr){
        if(i==j) return;
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }
    
    private static void dcp_4_test(int[] input,int expectedOutput,int testCase){
        if(dcp_4(input)==expectedOutput) System.out.printf("Test case %s passed%n",testCase);
        else System.out.printf("Test case %s failed%n",testCase);
    }
    
	public static void main(String[] args) {
	    // TestCase 1
		dcp_4_test(new int[]{0, 10, 2, -10, -20},1,1);
		// TestCase 2
		dcp_4_test(new int[]{0, 1, 2, -100, -120},3,2);
		// TestCase 3
		dcp_4_test(new int[]{0, 1, 2, 3},4,3);
	}
}
