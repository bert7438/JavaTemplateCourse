package ru.bert7438.javatemplatecourse.prac3;

import java.awt.*;
import java.util.*;
import java.util.List;

public class SyncMap<K,V> implements Map<K,V> {

    Set<Map.Entry<K,V>> entrySet;
    int size;

    static class Element <K,V> implements Map.Entry<K,V>{

        K key;
        V value;

        public Element(K key, V value) {
            this.key = key;
            this.value = value;
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
        public synchronized V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized boolean isEmpty() {
        return size == 0;
    }



    @Override
    public synchronized boolean containsKey(Object key) {
        for(Entry<K,V> i: entrySet)
            if (i.getKey() == key) return true;
        return false;
    }

    @Override
    public synchronized boolean containsValue(Object value) {
        for(Entry<K, V> i: entrySet)
            if (i.getKey() == value) return true;
        return false;
    }

    @Override
    public synchronized V get(Object key) {
        for (Entry<K,V> i:entrySet) {
            if(i.getKey() == key)
                return i.getValue();
        }
        return null;
    }

    @Override
    public synchronized V put(K key, V value) {
        if (this.get(key) != null) try {
            throw new Exception("This key already exists");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Element<K,V> e = new Element<K,V>(key, value);
        entrySet.add(e);
        size++;
        return e.value;
    }

    @Override
    public synchronized V remove(Object key) {
        for (Entry<K,V> i:entrySet) {
            if (i.getKey() == key){
                entrySet.remove(i);
                size--;
                return i.getValue();
            }
        }
        return null;
    }

    @Override
    public synchronized void putAll(Map m) {
        for (Object i : m.entrySet()) {
            var j = Entry.class.cast(i);

            try {
                put((K)(j.getKey()), (V)(j.getValue()));
            } catch (Exception e) {

            }
        }
    }

    @Override
    public synchronized void clear() {
        entrySet.clear();
        size = 0;
    }

    @Override
    public synchronized Set<K> keySet() {
        Set<K> keySet = new HashSet<K>();
        for (Entry<K,V> i:entrySet) {
            keySet.add(i.getKey());
        }
        return keySet;
    }

    @Override
    public synchronized Collection<V> values() {
        List<V> vals = new ArrayList<>();
        for (Entry<K,V> i:entrySet)
            vals.add(i.getValue());
        return vals;
    }

    @Override
    public synchronized Set<Entry<K, V>> entrySet() {
        return entrySet;
    }

    public SyncMap() {
        entrySet = new HashSet<>();
        size = 0;
    }

    @Override
    public String toString() {
        return "SyncMap{" +
                "entrySet=" + entrySet +
                '}';
    }
}
