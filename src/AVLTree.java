public class AVLTree {
    private static final int TOLERANCE = 1;
    private int height (AVLNode t){
        return t == null ? -1 : t.height;
    }

    /** method for balancing the tree*/
    private AVLNode balance (AVLNode t){
        if (t == null){
            return null;
        }
        if (height(t.left) - height(t.right) > TOLERANCE){
            if (height(t.left.left) >= height(t.left.right))
                t = rotateLeft(t);
            else
                t = doubleLeft(t);
        } else {
            if (height(t.right) - height(t.left) > TOLERANCE){
                if (height(t.right.right) >= height(t.right.left))
                    t = rotateRight(t);
                else
                    t = doubleRight(t);
            }
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    /** method for performing a single left rotation */
    private AVLNode rotateLeft(AVLNode m){
        AVLNode m1 = m.left;
        m.left = m1.right;
        m1.right = m;
        m.height = Math.max(height(m.left), height(m.right)) + 1;
        m1.height = Math.max(height(m1.left), m.height) + 1;
        return m1;
    }

    /** method for performing a double left rotation */
    private AVLNode doubleLeft(AVLNode m){
        m.left = rotateRight(m.left);
        return rotateLeft(m);
    }

    /** method for performing a single right rotation */
    private AVLNode rotateRight(AVLNode m){
        AVLNode m1 = m.right;
        m.right = m1.left;
        m1.left = m;
        m.height = Math.max(height(m.right), height(m.left)) + 1;
        m1.height = Math.max(height(m1.right), m.height) + 1;
        return m1;
    }

    /** method for performing a double right rotation */
    private AVLNode doubleRight(AVLNode m){
        m.right = rotateLeft(m.right);
        return rotateRight(m);
    }
}

