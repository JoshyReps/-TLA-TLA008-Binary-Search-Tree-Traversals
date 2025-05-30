package wow.reponoyatreedsa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class ReponoyaTreeDSA {

    public static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) {
          
       BinaryTree tree = new BinaryTree();
       
       
        System.out.println("Type `0` -> Exit");
        
       while(true) {
           
           int newBalon = -1;
           
           System.out.print("Enter Balon : ");
           
           try{
               newBalon = s.nextInt(); s.nextLine();
           }
           catch(Exception e) {
               System.out.println("Invalid Input"); s.nextLine();
           }
          
           
           if(newBalon == 0) break;
           else if(newBalon != -1) {
               tree.insert(newBalon);
           }
       }
       
        System.out.println("---------- Mga Balons ----------");
        
        System.out.println("\nIn Order Traversal");
        tree.inorder();
        System.out.println("\nPre Order Traversal: ");
        tree.preOrder(); 
        System.out.println("\nPost Order Traversal");
        tree.postOrder();
        System.out.println("\n--------------------------------");
    }
    
    public static void inorderRecRev (Node root) {
        if(root != null) {
            inorderRecRev(root.right);
            System.out.print(root.value + " ");
            inorderRecRev(root.left);
        }
    }
}



class Node {
        
    int value;
    Node left;
    Node right;

    public Node (int value) {
        this.value = value;
    }
}

class BinaryTree {
    
    Node root;
    
    public void insert (int value) {
        root = insertRec(root, value);
    }
    
    public Node insertRec(Node root, int value) {
        
        if(root == null) {
            return new Node(value);
        }
        if(value < root.value) {
            root.left = insertRec(root.left, value);
        }
        else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }
    
    
    // -------------- In Order Method ---------------
    public void inorder () {
        inorderRec(root);
    }
    
    public void inorderRec (Node root) {
        if(root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }
    // ---------------------------------------------
    
    
    // -------------- In Order Method ---------------
    public void preOrder () {
        
        class Traversed {
            
            public Traversed (Node node) {
                System.out.print(node.value + " ");
                if(node.left != null) {
                    new Traversed(node.left);
                }
                if(node.right != null) {
                    new Traversed(node.right);
                }
            }
        }
        
        new Traversed(root);
    }
    // ---------------------------------------------
    
    // -------------- In Order Method ---------------
    public void postOrder () {
        
        class Traversed {
            
            public Traversed (Node node) {
                
                if(node.left != null) {
                    new Traversed(node.left);
                }
                if(node.right != null) {
                    new Traversed(node.right);
                }
                System.out.print(node.value + " ");
            }
        }
        
        new Traversed(root);
    }
    // ---------------------------------------------
}