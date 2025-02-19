/******************************************************************************
Question:
Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.

*******************************************************************************/
import java.util.*;

public class Main
{
    private static int decode(String input){
        int n = input.length();
        int[] cache=new int[n];
        Arrays.fill(cache,-1);
        return decodeHelper(input,0,cache);
    }
    
    private static int decodeHelper(String input,int idx,int[] cache){
        int n=input.length();
        if(idx>=n) return 1;
        
        if(cache[idx]!=-1) return cache[idx];
        
        int ways=0;
        
        //single digit case
        if(input.charAt(idx)!='0') ways = decodeHelper(input,idx+1,cache);
        //double digit case
        if((idx+1<n) && 
            ((input.charAt(idx)=='1' && input.charAt(idx+1)<='9') || 
            (input.charAt(idx)=='2' && input.charAt(idx+1)<='6'))){
                ways += decodeHelper(input,idx+2,cache);
        }   
        
        cache[idx]=ways;
        
        return ways;
    }
    
	public static void main(String[] args) {
	    // input : '111' output :  3
		System.out.println(decode("111"));
		// input : '1234' output :  3
		System.out.println(decode("1234"));
		// input : '12345' output :  3
		System.out.println(decode("12345"));
		// input : '12345' output :  34
		System.out.println(decode("11111111"));
	}
}
