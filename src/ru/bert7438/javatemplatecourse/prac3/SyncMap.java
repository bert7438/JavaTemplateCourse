package ru.bert7438.javatemplatecourse.prac3;

import java.util.*;

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
    public boolean containsValue(Object value) {
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
    //TODO ALL THIS SHIT
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
    public void putAll(Map<K,V> m) {
        Set<Map.Entry<K,V>> es = m.entrySet();
        for (Entry i:es) {
            put(i.key, i.value);
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
    public Set<Entry<K, V>> entrySet() {
        return entrySet;
    }

    public SyncMap() {
        entrySet = new HashSet<>();
        size = 0;
    }
}
