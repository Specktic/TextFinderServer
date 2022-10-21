import java.util.LinkedList;
import java.util.List;

public class AVLTree {

    /** constructor */
    public AVLTree(){
        this.root = null;
    }

    /** attribute 1, an AVL node */
    private AVLNode root;

    /** static final attribute that defines imbalance tolerance */
    private static final int TOLERANCE = 1;

    /** getter for root */
    public AVLNode getRoot() {
        return root;
    }

    /** method for checking if tree is empty */
    public boolean empty(){
        return this.root == null;
    }

    /** method for getting height of a node */
    private int height (AVLNode t){
        return t == null ? -1 : t.getHeight();
    }

    /** public method for calling contain() method */
    public boolean contain(String word){
        return this.contain(word, this.root);
    }

    /** method for checking if tree contains a node with a given element */
    private boolean contain(String word, AVLNode node){
        if (node == null){
            return false;
        } else {
            int compare = word.compareTo(node.getWord());

            if (compare < 0){
                return contain(word, node.getLeft());
            } else if (compare > 0) {
                return contain(word, node.getRight());
            } else {
                return true;
            }
        }
    }

    /** public method for calling treeMin() method */
    public AVLNode treeMin() {
        if (this.empty()) {
            return null;
        } else {
            return this.treeMin(this.root);
        }
    }

    /** method for finding node with the minimum element */
    private AVLNode treeMin(AVLNode node) {
        if (this.empty()) {
            return null;
        } else {
            while (node.getLeft() != null) {
                node = node.getLeft();
            }
        } return node;
    }

    /** public method for calling treeMax() method */
    public AVLNode treeMax() {
        if (this.empty()) {
            return null;
        } else {
            return this.treeMax(this.root);
        }
    }

    /** method for finding node with the maximum element */
    private AVLNode treeMax(AVLNode node) {
        if (node != null) {
            while (node.getRight() != null){
                node = node.getRight();
            }
        } return node;
    }

    /** public method for calling insert() method */
    public void insert (String word){
        List Occurrence = new LinkedList();
        Occurrence.add(1);
        this.root = this.insert(word, Occurrence, this.root);
    }

    /** method for inserting a node with a given element */
    public AVLNode insert (String word, List occurrence ,AVLNode node) {
        if ( node == null) {
            List Occurrence = new LinkedList();
            Occurrence.add(1);
            return new AVLNode(word, Occurrence, null, null);
        }

        int compare = word.compareTo(node.getWord());

        if (compare < 0){
            List Occurrence = new LinkedList();
            Occurrence.add(1);
            node.setLeft(this.insert(word, Occurrence, node.getLeft()));
        } else if (compare > 0){
            List Occurrence = new LinkedList();
            Occurrence.add(1);
            node.setRight(this.insert(word, Occurrence, node.getRight()));
        } else {
            node.getOccurrence().add(1);
        }
        return balance(node);
    }

    /** public method for calling delete() method */
    public void delete(String word) {
        this.root = this.delete(word, this.root);
    }

    /** method for deleting a node with a given element */
    private AVLNode delete(String word, AVLNode node) {
        if (node == null){
            return node;}

        int compare = word.compareTo(node.getWord());

        if (compare < 0) {
            node.setLeft(delete(word, node.getLeft()));
        } else if (compare > 0) {
            node.setRight(delete(word, node.getRight()));
        } else if (node.getLeft() != null && node.getRight() != null) {
            node.setWord(treeMin(node.getRight()).getWord());
            node.setRight(delete(node.getWord(), node.getRight()));
        } else {
            node = node.getLeft() != null ? node.getLeft() : node.getRight();
        }
        return balance(node);
    }

    /** method for balancing the tree */
    private AVLNode balance (AVLNode t){
        if (t == null){
            return null;
        }
        if (height(t.getLeft()) - height(t.getRight()) > TOLERANCE){
            if (height(t.getLeft().getLeft()) >= height(t.getLeft().getRight()))
                t = rotateLeft(t);
            else
                t = doubleLeft(t);
        } else {
            if (height(t.getRight()) - height(t.getLeft()) > TOLERANCE){
                if (height(t.getRight().getRight()) >= height(t.getRight().getLeft()))
                    t = rotateRight(t);
                else
                    t = doubleRight(t);
            }
        }
        t.setHeight(Math.max(height(t.getLeft()), height(t.getRight())) + 1);
        return t;
    }

    /** method for performing a single left rotation */
    private AVLNode rotateLeft (AVLNode m){
        AVLNode m1 = m.getLeft();
        m.setLeft(m1.getRight());
        m1.setRight(m);
        m.setHeight(Math.max(height(m.getLeft()), height(m.getRight())) + 1);
        m1.setHeight(Math.max(height(m1.getLeft()), m.getHeight()) + 1);
        return m1;
    }

    /** method for performing a double left rotation */
    private AVLNode doubleLeft (AVLNode m){
        m.setLeft(rotateRight(m.getLeft()));
        return rotateLeft(m);
    }

    /** method for performing a single right rotation */
    private AVLNode rotateRight (AVLNode m){
        AVLNode m1 = m.getRight();
        m.setRight(m1.getLeft());
        m1.setLeft(m);
        m.setHeight(Math.max(height(m.getRight()), height(m.getLeft())) + 1);
        m1.setHeight(Math.max(height(m1.getRight()), m.getHeight()) + 1);
        return m1;
    }

    /** method for performing a double right rotation */
    private AVLNode doubleRight (AVLNode m){
        m.setRight(rotateLeft(m.getRight()));
        return rotateLeft(m);
    }

    /** AVL node for AVL tree */
    public static class AVLNode{

        /** constructor 1 */
        public AVLNode(String word, List occurrence){
            this(word, occurrence, null, null);
        }

        /** constructor 2 */
        public AVLNode(String word, List occurrence, AVLNode left, AVLNode right){
            this.word = word;
            this.occurrence = occurrence;
            this.left = left;
            this.right = right;
            this.height = 0;
        }

        /** attribute 1, a string */
        private String word;

        /** attribute 2, a List */
        private List occurrence;

        /** attribute 3, an int */
        private int height;

        /** attribute 4, an AVL node */
        private AVLNode left;

        /** attribute 5, an AVL node */
        private AVLNode right;

        /** getter and setter methods for word attribute */
        public String getWord () {
            return word;
        }
        public void setWord (String word) {
            this.word = word;
        }

        /** getter and setter methods for occurrence attribute */
        public List getOccurrence () {
            return occurrence;
        }
        public void setOccurrence (List occurrence) {
            this.occurrence = occurrence;
        }

        /** getter and setter methods for height attribute */
        public int getHeight () {
            return height;
        }
        public void setHeight (int height) {
            this.height = height;
        }

        /** getter and setter methods for left attribute */
        public AVLNode getLeft () {
            return left;
        }
        public void setLeft (AVLNode left) {
            this.left = left;
        }

        /** getter and setter methods for right attribute */
        public AVLNode getRight () {
            return right;
        }
        public void setRight (AVLNode right) {
            this.right = right;
        }


    }
}

