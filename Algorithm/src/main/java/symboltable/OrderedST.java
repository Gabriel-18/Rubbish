package symboltable;

import java.util.List;

public interface OrderedST<Key extends Comparable<Key>, Value> {
    int size();

    Value get(Key key);

    void put(Key key, Value value);

    Key min();

    Key max();

    int rank(Key key);

    List<Key> keys(Key l, Key h);
}
