import java.util.*;

class CustomHashMap<K, V> {
    private static final int SIZE = 16;
    private LinkedList<Node<K, V>>[] map;

    static class Node<K, V> {
        K key;
        V value;
        Node(K k, V v) { key = k; value = v; }
    }

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        map = new LinkedList[SIZE];
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        if (map[index] == null)
            map[index] = new LinkedList<>();

        for (Node<K, V> node : map[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        map[index].add(new Node<>(key, value));
    }

    public V get(K key) {
        int index = getIndex(key);
        if (map[index] == null) return null;

        for (Node<K, V> node : map[index])
            if (node.key.equals(key))
                return node.value;

        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        if (map[index] == null) return;

        map[index].removeIf(node -> node.key.equals(key));
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        System.out.println(map.get("One")); // 1
        map.remove("One");
        System.out.println(map.get("One")); // null
    }
}
