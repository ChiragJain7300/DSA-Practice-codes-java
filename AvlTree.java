// Follow the steps below to use this file

  // 1. In the main file, create an instance of this class:
  // NewClass1 instance1 = new NewClass1();

  // 2. Call the method to get the greeting message:
  // System.out.println(instance1.sayHelloFromNewClass());

public class AvlTree{
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
            
            return balance(node, val);
        }
          // balance the tree
          
    private Node balance(Node node, int val){
            if(height(node.left) - height(node.right) > 1){
              // left-    cases
              if(val < node.left.val)
                node = rightRotate(node);
              else
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
            else if(height(node.left) - height(node.right) < -1){
              // right- cases
              if(val > node.right.val)
                node = leftRotate(node);
              else
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
            return node;
    }
    
    private Node leftRotate(Node node){
      Node c = node.right;
      Node t3 = c.left;
      
      c.left = node;
      node.right = t3;
      
      node.height = Math.max(height(node.left), height(node.right)) + 1;
      c.height = Math.max(height(c.left), height(c.right)) + 1;
      
      return c;
    }
    private Node rightRotate(Node node){
      Node c = node.left;
      Node t3 = c.right;
      
      c.right = node;
      node.left = t3;
      
      node.height = Math.max(height(node.left), height(node.right)) + 1;
      c.height = Math.max(height(c.left), height(c.right)) + 1;
      
      return c;
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
