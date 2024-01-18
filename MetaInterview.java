import java.util.*;

public class MetaInterview {
    public static class Node {
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args){
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node6 = new Node(6);
        Node node8 = new Node(8);
        Node node7 = new Node(7);
        Node node9 = new Node(9);
        node6.left = node4;
        node6.right = node8;
        node4.left = node3;
        node4.right = node5;
        node8.left = node7;
        node8.right = node9;
        node3.left = node2;
        int[] bounds1 = {2,5};
        int[] bounds2 = {8,9};
        int[] bounds3 = {4,6};
        System.out.println(solution(node6, bounds1));
        System.out.println(solution(node6, bounds2));
        System.out.println(solution(node6, bounds3));

        System.out.println(solution(node6));
    }   


    /*
        //              6
        //            /   \
        //           4     8
        //          / \   / \
        //         3   5 7   9
        //        /
        //       2

        // Input: [2, 5] => 14
        // Input: [8, 9] => 17
        // Input: [4, 6] => 15
    */
    public static int solution(Node root, int[] range){
        return dfs(root, range);
    }
    public static int dfs(Node root, int[] range){
        if(root == null){
          return 0;
        }
    
        if(root.val < range[0]){
          return dfs(root.right, range);
        }else if(root.val > range[1]){
          return dfs(root.left, range);
        }else{
          return root.val + dfs(root.left, range) + dfs(root.right, range);
        }
    }

    /*
        //              6
        //            /   \
        //           4     8
        //          / \   / \
        //         3   5 7   9
        //        /
        //       2

        // Output: 6,4,3,2,8,9,2?
    */

    /**
     * @param root
     * @return
     */
    public static List<Integer> solution(Node root){
        Queue<Node> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int currentLevel = 0;//not needed just making it clear for my head
        q.offer(root);
        while(!q.isEmpty()){
          int levelSize = q.size();
          for(int i = 0 ; i < levelSize; i++){
            Node curr = q.poll();
            if(i == 0 ){
              res.add(curr.val);
            }else if(i == levelSize - 1){
              res.add(curr.val);
            }
            if(curr.left != null){
              q.offer(curr.left);
            }
            if(curr.right != null){
              q.offer(curr.right);
            }
          }
          currentLevel += 1;
        }
        return res;
      }

    
}
