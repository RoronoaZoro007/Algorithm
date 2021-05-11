package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class IsCompleteTree {

    public boolean isCompleteTree(TreeNode root) {
        if(root==null)
            return true;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.push(root);
        while(!deque.isEmpty()&&deque.peekFirst()!=null){
            TreeNode temp=deque.pollFirst();
            deque.offerLast(temp.left);
            deque.offerLast(temp.right);
        }
        while(!deque.isEmpty()){
            if(deque.pollFirst()!=null)
                return false;
        }
        return true;
    }
}
