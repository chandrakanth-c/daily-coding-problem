/******************************************************************************

Binary Tree Travesals:
Preorder traversal -- (i)
Inorder traversal -- (ii)
Post traversal -- (iii)

*******************************************************************************/
import java.util.*;

public class BinaryTreeTraversal
{
    static class Tree{
        Tree left;
        Tree right;
        int val;
        
        Tree(int val){
            this.val=val;
        }
        
        Tree(int val, Tree left, Tree right){
            this.left=left;
            this.right=right;
            this.val=val;
        }
    }
    
    static List<Integer> preorderOrInOrderTraversal(Tree root, String flag){
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        if(flag.equals("preorder")){
            preorderHelper(root, res);
        }else if(flag.equals("inorder")) {
            inorderHelper(root, res);
        }else {
            postorderHelper(root, res);
        }
        return res;
    }
    
    // Preorder traversal -- (i)
    static void preorderHelper(Tree root, List<Integer> res){
        if(root == null) return;
        
        res.add(root.val);
        if(root.left != null) preorderHelper(root.left, res);
        if(root.right != null) preorderHelper(root.right, res);
    }
    
    // Inorder traversal -- (ii)
    static void inorderHelper(Tree root, List<Integer> res){
        if(root == null) return;
        
        if(root.left != null) preorderHelper(root.left, res);
        res.add(root.val);
        if(root.right != null) preorderHelper(root.right, res);
    }
    
    // Post traversal -- (iii)
    static void postorderHelper(Tree root, List<Integer> res){
        if(root == null) return;
        
        if(root.left != null) preorderHelper(root.left, res);
        if(root.right != null) preorderHelper(root.right, res);
        res.add(root.val);
    }
    
	public static void main(String[] args) {
		Tree root=new Tree(1);
		root.left=new Tree(2,new Tree(4),new Tree(5));
		root.right=new Tree(3);
		root.right.right=new Tree(5);
		
		//Preorder traversal -- (i)
		System.out.println(preorderOrInOrderTraversal(root,"preorder"));
		//Inorder traversal -- (ii)
		System.out.println(preorderOrInOrderTraversal(root,"inorder"));
		//Postorder traversal -- (iii)
		System.out.println(preorderOrInOrderTraversal(root,"postorder"));
	}
}
