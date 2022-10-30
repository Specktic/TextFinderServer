import java.util.LinkedList;

public class BinarySearchTree {

    /** Class constructor */
    public BinarySearchTree(){
        this.root = null;
    }

    /** Attribute 1, a binary node */
    private BinaryNode root;

    /** Attribute 2, an int */
    private int comparisons = 0;

    /** Attribute 3, a String */
    private String nodeWord;

    /** Attribute 3, a String */
    private String nodeLocation;

    /** Returns the stored word */
    public String getNodeWord() {
        return nodeWord;
    }

    /** Returns the stored location */
    public String getNodeLocation() {
        return nodeLocation;
    }

    /** Returns number of comparisons made */
    public int getComparisons() {
        return comparisons;
    }

    /** Checks if a tree is empty */
    public boolean empty(){
        return this.root == null;
    }

    /** Calls the contain method */
    public boolean contain(String word){
        return this.contain(word, this.root);
    }

    /** Recursively verifies if a node with a given element exists within the tree */
    private boolean contain (String word, BinaryNode node) {
        if (node == null){
            return false;
        } else {
            int compare = word.compareTo(node.getWord());

            if (compare < 0){
                return contain(word, node.getLeft());
            } else if (compare > 0) {
                return contain(word, node.getRight());
            } else {
                nodeWord = word;
                nodeLocation = node.getOccurrence().toString();
                return true;
            }
        }
    }

    /** Calls the treeMin() method */
    public BinaryNode treeMin () {
        if (this.empty()) {
            return null;
        } else {
            return this.treeMin(this.root);
        }
    }

    /** Recursively finds the node with the lesser element */
    private BinaryNode treeMin (BinaryNode node) {
        if (this.empty()) {
            return null;
        } else {
            while (node.getLeft() != null) {
                node = node.getLeft();
            }
        } return node;
    }

    /** Calls the treeMax() method */
    public BinaryNode treeMax () {
        if (this.empty()) {
            return null;
        } else {
            return this.treeMax(this.root);
        }
    }

    /** Recursively finds the node with the greater element */
    private BinaryNode treeMax (BinaryNode node) {
        if (node != null) {
            while (node.getRight() != null){
                node = node.getRight();
            }
        } return node;
    }

    /** Calls the insert() method */
    public void insert (String word, String location) {
        this.root = this.insert(word, location, this.root);
    }

    /** Recursively inserts a node to the tree in its corresponding location */
    private BinaryNode insert (String word, String location, BinaryNode node) {
        if (node == null){
            return new BinaryNode(word, location,null, null);
        }

        int compare = word.compareTo(node.getWord());

        if (compare < 0){
            node.setLeft(this.insert(word, location, node.getLeft()));
        } else if (compare > 0){
            node.setRight(this.insert(word, location, node.getRight()));
        } else {
            node.occurrence.add(location);
        }
        return node;
    }

    /** Calls the delete method */
    public void delete (String word) {
        this.root = this.delete(word, this.root);
    }

    /** Recursively deletes a node with a given element */
    private BinaryNode delete (String word, BinaryNode node) {

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
        return node;
    }

    /** Binary node class for binary search tree */
    private static class BinaryNode {

        /** Class constructor 1 */
        public BinaryNode (String word, String occurrence){
            this(word, occurrence, null, null);
        }

        /** Class constructor 2 */
        public BinaryNode (String word, String location, BinaryNode left, BinaryNode right){

            this.word = word;

            if (this.occurrence == null) {
                this.occurrence = new LinkedList();
                occurrence.add(location);
            } else {
                this.occurrence.add(location);
            }

            this.left = left;
            this.right = right;
        }

        /** Attribute 1, a string */
        private String word;

        /** Attribute 2, a Linked List */
        private LinkedList occurrence;

        /** Attribute 3, a binary node */
        private BinaryNode left;

        /** Attribute 4, a binary node */
        private BinaryNode right;

        /** Returns the stored word of a node */
        public String getWord () {
            return word;
        }

        /** Modifies the stored word a node */
        public void setWord (String word) {
            this.word = word;
        }

        /** Returns the occurrence list */
        public LinkedList getOccurrence () {
            return occurrence;
        }

        /** Modifies the occurrence list of a node */
        public void setOccurrence (LinkedList occurrence) {
            this.occurrence = occurrence;
        }

        /** Returns the left child of a node */
        public BinaryNode getLeft() {
            return this.left;
        }

        /** Modifies the left child of a node */
        public void setLeft(BinaryNode node) {
            this.left = node;
        }

        /** Returns right child of a node */
        public BinaryNode getRight() {
            return this.right;
        }

        /** Modifies the right child of a node */
        public void setRight(BinaryNode right) {
            this.right = right;
        }
    }
}
