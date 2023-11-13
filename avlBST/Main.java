package java8.avlBST;
public class Main{
    public static void main(String[] args) {
        AVL avl = new AVL();
        
        for (int i = 0; i < 1000; i++) {
            avl.insert(i);           
        }

        System.out.println(avl.height());

        // SelfBT avl = new SelfBT();
        // for (int i = 0; i < 1000; i++) {
        //     avl.insert(i);           
        // }

        // System.out.println(avl.height());

    }
}