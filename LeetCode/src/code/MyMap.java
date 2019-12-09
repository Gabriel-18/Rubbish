package code;

public interface MyMap<K, V> {
    // 插入一个值
    V put(K key, V value);

    // 获取一个值
    V get(K key);

    // HashMap 中的节点
    interface Entry<K, V> {
        K getKey();

        V getValue();
    }
}
