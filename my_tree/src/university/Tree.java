package university;

public class Tree {

    private static class Node {
        int key;
        Object inf;
        Node left;
        Node right;
        boolean isRed;
        Node parent;

        /*  public Node(int key)
          {
              this.key=key;
          }
          */
        public Node(int key, Object inf) {
            this.key = key;
            this.inf = inf;
            this.isRed = true;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", inf=" + inf +
                    ", left=" + left +
                    ", right=" + right +
                    ", color=" + isRed +
                    '}';
        }
    }

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void add(int key, Object inf) {
        Node n;
        if (root == null) {
            root = new Node(key, inf);
            n=root;
        } else {
            Node parent = findNode(root, key);
            n = new Node(key, inf);
            if (key < parent.key) {
                parent.left = n;
                // parent.left.parent=parent;
            } else {
                parent.right = n;
                // parent.right.parent=parent;
            }
            n.parent = parent;
        }
        case1(n);

    }

    private Node getGrandfather(Node n) {
        if (n.parent != null) {
            return n.parent.parent;
        } else
            return null;
    }

    private Node getUncle(Node n) {
        Node g = n.parent.parent;
        if (g.left == n.parent) {
            return g.right;
        } else
            return g.left;

    }

    private void case1(Node n) {
        if (n == root) {
            n.isRed = false;
        } else {
            case2(n);
        }
    }

    private void case2(Node n) {
        if (n.parent.isRed) {
            case3(n);
        }
    }

    private void case3(Node n) {
        Node u = getUncle(n);
        if (u != null && u.isRed) {
            u.parent.isRed = true;
            n.parent.isRed = false;
            u.isRed = false;
            case1(u.parent);
        } else {
            case4(n);
        }
    }

    private void  case4(Node n)
    {

    }

    public Node findNode(Node current, int key) {
        if (key < current.key) {
            if (current.left == null) {
                return current;
            } else {
                return findNode(current.left, key);
            }
        } else {
            if (current.right == null) {
                return current;
            } else {
                return findNode(current.right, key);
            }
        }
    }

    public Node find(Node current, int key) {
        if (current != null && key < current.key) {

            return find(current.left, key);
        } else {
            if (current != null && key > current.key) {
                return find(current.right, key);
            } else {
                return current;
            }
        }

    }

    public boolean checkKey(int key) {
        Node tmp = find(root, key);
        return tmp != null;
    }
}
