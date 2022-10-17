import java.util.List;

/** AVL node for AVL tree */
public class AVLNode{

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
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }

    /** getter and setter methods for occurrence attribute */
    public List getOccurrence() {
        return occurrence;
    }
    public void setOccurrence(List occurrence) {
        this.occurrence = occurrence;
    }

    /** getter and setter methods for height attribute */
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    /** getter and setter methods for left attribute */
    public AVLNode getLeft() {
        return left;
    }
    public void setLeft(AVLNode left) {
        this.left = left;
    }

    /** getter and setter methods for right attribute */
    public AVLNode getRight() {
        return right;
    }
    public void setRight(AVLNode right) {
        this.right = right;
    }
}
