package lesson01;

/**
 * Created by IEvgen Boldyr on 31.05.17.
 */
public class TreeMap<K extends Comparable, V> implements Map<K, V> {

    private class Node<K, V> {

        private K key;
        private V value;

        private Node<K, V> parent;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V> head;

    @Override
    public boolean add(K key, V value) {
        Node<K, V> nd = new Node<>(key, value);
        if (head == null) {
            head = nd;
            return true;
        }
        return add(nd, head);
    }

    @Override
    public boolean find(K key) {
        return find(key, head);
    }

    @Override
    public V set(K key, V value) {
        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    private boolean add(Node<K, V> nd, Node<K, V> current) {
        if (nd.key.compareTo(current.key) > 0 & current.right != null) {
            add(nd, current.right);
        } else if (nd.key.compareTo(current.key) < 0 & current.left != null) {
            add(nd, current.left);
        } else if ((nd.key.compareTo(current.key) > 0 & current.right == null)) {
            nd.parent = current;
            current.right = nd;
            return true;
        } else if ((nd.key.compareTo(current.key) < 0 & current.left == null)) {
            nd.parent = current;
            current.left = nd;
            return true;
        }
        return false;
    }

    private boolean find(K key, Node<K, V> current) {
        if (current == null) {
            return false;
        } else if (current.key.compareTo(key) == 0) {
            return  true;
        } else if (key.compareTo(current.key) > 0 & current.right != null) {
            return find(key, current.right);
        } else if (key.compareTo(current.key) < 0 & current.left != null) {
            return find(key, current.left);
        }
        return false;
    }
}
