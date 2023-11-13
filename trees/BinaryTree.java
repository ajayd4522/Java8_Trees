package java8.trees;

import java.util.Scanner;

public class BinaryTree {

    public BinaryTree (){

    }

    private class Node {

        private int value;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
        }
    }
    private Node root;

    // inserting the value in node of tree
    public void populate (Scanner scanner){
        System.out.println("Enter the root node : ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate (root, scanner);
    }

    private void populate(Node node, Scanner scanner) {
        // base cond
        if(node == null){
            return;
        }
        System.out.println("Do you want left node of " + node.value);
        boolean choice = scanner.nextBoolean();
 
        // left part
        if(choice){
            System.out.println("Enter the left node value of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(node.left, scanner);
        }

        System.out.println("Do you want right node of " + node.value);
        choice = scanner.nextBoolean();

        // right part
        if(choice){
            System.out.println("Enter the right node value of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(node.right, scanner);
        }
    }

    // display method of tree
    public void display (){
        display(this.root, "");
    }

    private void display(Node node, String indent){
        //base cond
        if(node == null) return;

        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    // display more clearly
    public void displayPretty (){
        displayPretty(this.root, 0);
    } 

    private void displayPretty(Node node, int level){
        // base cond
        if(node == null) return;

        displayPretty(node.right, level + 1);

        if(level != 0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t");                
            }
            System.out.println("|------->" + node.value);
        }
        else {
            System.out.println(node.value);
        }

        displayPretty(node.left, level + 1);
    }

    // Traversal method
    // 1. Preorder
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        //base cond
        if(node == null) return ;

        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // 2. Postorder
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        //base cond
        if(node == null) return ;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + " ");
    }

    // 3. In-order
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        //base cond
        if(node == null) return ;

        inOrder(node.left);
        System.out.println(node.value + " ");
        inOrder(node.right);
    }
}
