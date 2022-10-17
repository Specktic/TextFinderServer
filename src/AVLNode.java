import java.util.List;

public class AVLNode{
    String word;
    List occurrence;
    AVLNode left;
    AVLNode right;
    int height;

    public AVLNode(String word, List occurrence){
        this(word, occurrence, null, null);
    }

    public AVLNode(String word, List occurrence, AVLNode left, AVLNode right){
        this.word = word;
        this.occurrence = occurrence;
        this.left = left;
        this.right = right;
        this.height = 0;
    }
}
