/*
* Given the root to a binary tree, implement serialize(root), 
* which serializes the tree into a string, and deserialize(s), 
* which deserializes the string back into the tree.
*
* Solution source : https://www.geeksforgeeks.org/serialize-deserialize-binary-tree/
*/
import java.util.*;
import java.lang.*;

public class Main
{
    static class Node{
        int val;
        Node left;
        Node right;
        
        Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
        
        Node(int val,Node left,Node right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    
    private static String dcp_3_serialize(Node root){
        if(root==null) return null;
        Stack<Node> processStack = new Stack<>();
        List<String> result=new ArrayList<>();
        processStack.push(root);
        while(!processStack.isEmpty()){
            Node currentNode=processStack.pop();
            if(currentNode==null) {
                result.add("#");
            }else{
                result.add(String.valueOf(currentNode.val));
                processStack.push(currentNode.right);
                processStack.push(currentNode.left);   
            }
        }
        return String.join(",",result);
    }
    
    private static Node dcp_3_deserialize(String serializedTree){
        if(serializedTree==null) return null;
        String[] serializedTreeArr=serializedTree.split(",");
        return constructTree(serializedTreeArr);
    }
    
    static int index=0;
    
    private static Node constructTree(String[] nodeString){
        if(nodeString==null) return null;
        if(nodeString[index].equals("#")) return null;
        Node node=new Node(Integer.parseInt(nodeString[index]));
        index++;
        node.left=constructTree(nodeString);
        index++;
        node.right=constructTree(nodeString);
        return node;
    }
    
    private static boolean areTreesEqual(Node node1,Node node2){
        if(node1==null && node2==null) return true;
        if(node1==null || node2==null) return false;
        if(node1.val!=node2.val) return false;
        else {
            areTreesEqual(node1.left,node2.left);
            areTreesEqual(node1.right,node2.right);
        }
        return true;
    }
    
    private static void 
      dcp_3_serialize_test(Node input,String expectedoutput,int testCase){
      if(dcp_3_serialize(input).equals(expectedoutput)) 
        System.out.printf("Test case %s for serialize passsed%n", testCase);
      else
        System.out.printf("Test case %s for serialize failed%n", testCase);
    }
    
    private static void dcp_3_deserialize_test(String input,Node expectedoutput,int testCase){
        if(areTreesEqual(dcp_3_deserialize(input),expectedoutput))
            System.out.printf("Test case %s for deserialize passsed%n", testCase);
        else
            System.out.printf("Test case %s for deserialize failed%n", testCase);
    }
    
    public static void main(String[] args) {
	Node root=new Node(1,new Node(2),null);
        //Test Case 1 : Serialize
	dcp_3_serialize_test(root,"1,2,#,#,#",1);
        //Test Case 1 : Deserialize
	dcp_3_deserialize_test("1,2,#,#,#",root,1);
    }
}
