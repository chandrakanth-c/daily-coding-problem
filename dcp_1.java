import java.lang.*;
import java.util.*;
import java.util.stream.*;

public class Main
{
    static class Input{
        List<Integer> input;
        int k;
        
        Input(List<Integer> input,int k){
            this.input = input;
            this.k = k;
        }
    }

	// TC : 2O(n) ~ O(n).
	// SC : O(n) because assitional set is used.
    private static boolean dcp_1(List<Integer> input,int k){
        //Edge case.
        if(input==null) return false;
        //Because Set.contains is O(1).
		//TC : O(n).
        Set<Integer> inputSet=input.stream().map(i->i).collect(Collectors.toSet());
		//TC : O(n).
        for(Integer i:input){
            //Return true if complement exist in the input.
            if(inputSet.contains(Math.abs(i-k))) return true;
        }
        return false;
    }
    
    private static void dcp_1_test(Input input,boolean expectedOutput,int testCase){
        if(dcp_1(input.input,input.k)==expectedOutput) 
            System.out.printf("Test case %s passed :)%n",testCase);
        else System.out.printf("Test case %s failed :(%n",testCase);
    }
    
    public static void main(String[] args) {
	    //Test case 1 = success.
	    Input input1 = new Input(Arrays.asList(10,15,3,7),7);
	    dcp_1_test(input1,true,1);
	    //Test case 2 = failure.
	    Input input2 = new Input(Arrays.asList(10,15,3,7),100);
	    dcp_1_test(input2,false,2);
	    //Test case 3 = empty list.
	    Input input3 = new Input(Arrays.asList(),0);
	    dcp_1_test(input3,false,3);
	    //Test case 4 = null input.
	    Input input4 = new Input(null,0);
	    dcp_1_test(input3,false,4);
    }
}

