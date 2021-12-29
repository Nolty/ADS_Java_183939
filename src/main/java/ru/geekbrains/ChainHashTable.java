package ru.geekbrains;

public class ChainHashTable<K, V> implements HashTable<K, V> {
    private final Item<K, V>[] data;
    private int size;

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;
        private Item<K, V> next;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item { " + "key=" + key + ", value=" + value + " }";
        }

        public Item<K, V> getNext() {
            return next;
        }

        public void setNext(Item<K, V> next) {
            this.next = next;
        }
    }

    public ChainHashTable(int initialCapacity) {
        this.data = new Item[initialCapacity * 2];
        this.size = 0;
    }

    public ChainHashTable() {
        this(16);
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    private boolean isKeysEquals(Item<K, V> item, K key) {
        return (item.getKey() == null) ? (key == null) : item.getKey().equals(key);
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);

        if (data[index] == null) {
            data[index] = new Item<>(key, value);
            size++;
        } else {
            Item<K, V> entry = data[index];

            while (entry.getNext() != null && !isKeysEquals(entry, key)) {
                entry = entry.getNext();
            }

            if (isKeysEquals(entry, key)) {
                entry.setValue(value);
            } else {
                entry.setNext(new Item<>(key, value));
                size++;
            }
        }

        return true;
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);

        if (data[index] != null) {
            Item<K, V> entry = data[index];

            while (entry != null && !isKeysEquals(entry, key)) {
                entry = entry.getNext();
            }

            if (entry != null) {
                return entry.getValue();
            }
        }

        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);

        if (data[index] != null) {
            Item<K, V> prevEntry = null;
            Item<K, V> entry = data[index];

            while (entry.getNext() != null && !isKeysEquals(entry, key)) {
                prevEntry = entry;
                entry = entry.getNext();
            }

            if (isKeysEquals(entry, key)) {
                if (prevEntry == null) {
                    data[index] = entry.getNext();
                } else {
                    prevEntry.setNext(entry.getNext());
                }

                size--;
                return entry.getValue();
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hash table: [\n");
        for (Item<K, V> datum : data) {
            sb.append("{ ");
            if (datum != null) {
                Item<K, V> entry = datum;
                do {
                    sb.append(String.format("%s ", entry));
                    entry = entry.getNext();
                } while (entry != null);
            }
            sb.append("}\n");
        }

        sb.append(']');
        return sb.toString();
    }
}
