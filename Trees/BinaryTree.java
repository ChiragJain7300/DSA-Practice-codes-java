// Follow the steps below to use this file

  // 1. In the main file, create an instance of this class:
  // NewClass1 instance1 = new NewClass1();

  // 2. Call the method to get the greeting message:
  // System.out.println(instance1.sayHelloFromNewClass());

public class BinaryTree{
    private Node root;
    private class Node{
        private int val;
        private int height;
        private Node left;
        private Node right;
        
        Node(int val){
            this.val = val;
        }
    }
    
    private int height(Node node){
            if(node == null)
                return -1;
            return node.height;
    }
        // insertion
    public void insert(int val){
            this.root = insert(val, root);
    }
    private Node insert(int val, Node node){
            if(node == null)
            {
                node = new Node(val);
                return node;
            }
            if(val > node.val)
                node.right = insert(val, node.right);
            else 
                node.left = insert(val, node.left);
            
            node.height = Math.max(height(node.left), height(node.right)) + 1;
            
            return node;
        }
      // display
        
    public void displayTree(){
            displayTree(this.root, 0);
    }
        
    private void displayTree(Node node, int level){
            if(node == null)
            {
              System.out.println("");
              return;
            }
                
            
            displayTree(node.right, level+1);
            System.out.print("      ".repeat(level) + node.val);
            displayTree(node.left, level+1);
            
        }
}
