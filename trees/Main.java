package java8.trees;

// import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // BinaryTree binaryTree = new BinaryTree();
        // Scanner scanner = new Scanner(System.in);
        // binaryTree.populate(scanner);
        // binaryTree.displayPretty();

        BST bst = new BST();
        // bst.populateSorted(new int[]{5,6,7,8,9,10,11,12});
        // bst.display();

        for (int i = 0; i < 1000; i++) {
            bst.insert(i);           
        }

        System.out.println(bst.height());
    }
}
