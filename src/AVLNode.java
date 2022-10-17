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
    String word;

    /** attribute 2, a List */
    List occurrence;

    /** attribute 3, an int */
    int height;

    /** attribute 4, an AVL node */
    AVLNode left;

    /** attribute 5, an AVL node */
    AVLNode right;

    /** getter method for word attribute */
    public String getWord() {
        return word;
    }
    /** setter method for word attribute */
    public void setWord(String word) {
        this.word = word;
    }

    /** getter method for occurrence attribute */
    public List getOccurrence() {
        return occurrence;
    }
    /** setter method for occurrence attribute */
    public void setOccurrence(List occurrence) {
        this.occurrence = occurrence;
    }
}
