package java8.avlBST;
// Self Balancing Binary Search Adelson-Velsky and Landis Tree
public class AVL {
    
    public AVL (){

    }

    public class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }

    }

    private Node root;

    public int height(){
        return height(root);
    }

    private int height(Node node){
        if(node == null) return -1;
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    // inserting node
    public void insert(int value){
        root = insert(value, root);
    }

    private Node insert(int value, Node node){
        // base cond
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value < node.value){
            node.left = insert(value, node.left);
        }

        if(value > node.value){
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left) , height(node.right)) + 1;

        return rotate(node);
    }

    // Rotation
    private Node rotate(Node node){
        // check it is left heavy or right heavy
        if(height(node.left) - height(node.right) > 1){
            // left heavy
            if(height(node.left.left) - height(node.left.right) > 0){
                // left left case
                return rotateRight(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0){
                // left right case
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        if(height(node.left) - height(node.right) < -1){
            // right heavy
            if(height(node.right.left) - height(node.right.right) < 0){
                // right right case
                return rotateLeft(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0){
                // right left case
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }

        return node;
    }
    // Rotating Left
    private Node rotateLeft(Node c){
        Node p = c.right;
        Node t = p.right;

        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left) , height(p.right) + 1);
        c.height = Math.max(height(c.left) , height(c.right) + 1);

        return p;
        
    }
    // Rotating Right
    private Node rotateRight(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left) , height(p.right) + 1);
        c.height = Math.max(height(c.left) , height(c.right) + 1);

        return c;
        
    }

    // populating tree
    public void populate(int [] nums){
        for(int i=0; i<nums.length; i++){
            this.insert(nums[i]);
        }
    }

    // populating with sorted array
    public void populateSorted(int [] nums){
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int [] nums, int start, int end){
        // base cond
        if(start >= end){
            return;
        }

        int mid = (start + end) / 2;
        this.insert(nums[mid]);

        populateSorted(nums, start, mid);
        populateSorted(nums, mid+1, end);
    }

    // check for balance
    public boolean balance(){
        return balance(root);
    }

    private boolean balance(Node node){
        // base cond
        if(node == null) return true;

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balance(node.left) && balance(node.right); 
    }

    // display
    public void display(){
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details){
        // base cond
        if(node == null){
            return ;
        }

        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }
}
