/******************************************************************************

>>>> Below paragraphs are sourced from the email from dailycodingproblem.com.

This problem was asked by Microsoft.

Given an array of numbers, find the length of the longest increasing subsequence (LIS) in the array. 
The subsequence does not necessarily have to be contiguous.

For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15], 
the longest increasing subsequence has length 6: it is 0, 2, 6, 9, 11, 15.

*******************************************************************************/

/******************************************************************************

>>>> Personal Notes of explaination:

Solution source : https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/

This is a DP problem, so please refer to https://github.com/chandrakanth-c/patterns-in-algorithms/blob/main/dynamic-programming.md
before coming here as this is a `HARD` level problem.

>>>> LIS flow example

For idx=1
    prev=0
    mx=2
    res=2 => L(1)=2 where i=1
For idx=2
    prev=0
    prev=1
    res=2 => L(2)=2 where i=2
For idx=3
    prev=0
    mx=2
        prev=1
        prev=0
        mx=2
        mx=3
            prev=2
            prev=0
            prev=1
            mx=3
            res=3 =>  L(3)=2 where i=3

Return max(L(i))=3 i.e size of [3,10,11] array in [3,10,2,11] input arr.

*******************************************************************************/
