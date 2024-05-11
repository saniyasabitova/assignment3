

import java.util.Iterator;
import java.util.Stack;
import java.util.WeakHashMap;

public class BST<K extends Comparable<K>,V>{




public void inOrder() {
    Node n = root;
    if (n == null) {
        return;
    }
    Stack<Node> stack = new Stack();
    while (!stack.empty() || n!=null) {
        if (n != null) {
            stack.push(n);
            n = n.left;
        } else {
            if (stack.empty()) break;
            n = stack.pop();
            System.out.println("key "+n.key +"  " + "value "+ n.value);
            n = n.right;
        }
    }
}



    private class Node{
        private K key;
        private V value;
        private Node left;
        private Node right;
        public Node(K key, V val){
            this.key = key;
            this.value = val;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    private Node root;
    int size;
    public void put(K key, V val) {
        root = put(root, key, val);
    }
//    private Node put (Node n, K key, V val){
//        if ( n == null){
//            size++;
//            n = new Node(key,val);
//            return n;
//        }
//        else{
//           Node node = new Node(key,val);
//           int c = key.compareTo(n.key);
//           if(c>0){
//               n = put(n.right, key,val);
//           } else if (c<0) {
//             n = put(n.left, key,val);
//           }
//          else {
//    n.value = val;
//    return n;
//}
//
//        }
//        return n;
//    }

    private Node put(Node n, K key, V val) {
    if (n == null) {
        size++;
        return new Node(key, val);
    }

    int cmp = key.compareTo(n.key);
    if (cmp > 0) {
        n.right = put(n.right, key, val);
    } else if (cmp < 0) {
        n.left = put(n.left, key, val);
    } else {
        // Update value if key already exists
        n.value = val;
        return n; // Return the updated node
    }

    return n;
}


   public V get(K key) {
    return get(root, key);
}

private V get(Node node, K key) {
    if (node == null) {
        return null; // Key not found
    }

    int cmp = key.compareTo(node.key);
    if (cmp < 0) {
        return get(node.left, key); // Search in the left subtree
    } else if (cmp > 0) {
        return get(node.right, key); // Search in the right subtree
    } else {
        return node.value; // Key found, return the corresponding value
    }
}
   public void delete(K key) {
    root = delete(root, key);
}

private Node delete(Node node, K key) {
    if (node == null) {
        return null; // Key not found, nothing to delete
    }

    int cmp = key.compareTo(node.key);
    if (cmp < 0) {
        node.left = delete(node.left, key); // Search in the left subtree
    } else if (cmp > 0) {
        node.right = delete(node.right, key); // Search in the right subtree
    } else {
        // Node with the key to be deleted found
        if (node.left == null) {
            // Case 1: Node has no left child or is a leaf node
            return node.right; // Replace node with its right child (or null)
        } else if (node.right == null) {
            // Case 2: Node has no right child
            return node.left; // Replace node with its left child
        } else {
            // Case 3: Node has both left and right children
            // Find the minimum node in the right subtree (successor)
            Node successor = findMin(node.right);
            // Copy the key and value of the successor to the current node
            node.key = successor.key;
            node.value = successor.value;
            // Delete the successor from the right subtree
            node.right = delete(node.right, successor.key);
        }
    }
    return node;
}

private Node findMin(Node node) {
    while (node.left != null) {
        node = node.left;
    }
    return node;
}

//   public Iterable<K> iterator(){
//
//   }
}