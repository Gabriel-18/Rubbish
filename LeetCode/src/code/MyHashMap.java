package code;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private static final int DEAFALT_INITAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private float loadFactor = 0;
    private int initCapacity = 0;
    private Entry<K,V>[] table = null;

    // 默认构造函数
    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.initCapacity = DEAFALT_INITAL_CAPACITY;
        table = new Entry[this.initCapacity];
    }

    public MyHashMap(int initCapacity, float loadFactor) {
        this.loadFactor = loadFactor;
        this.initCapacity = initCapacity;
        table = new Entry[this.initCapacity];
    }
    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }
}

