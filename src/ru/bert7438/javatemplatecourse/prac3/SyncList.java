package ru.bert7438.javatemplatecourse.prac3;

import java.util.*;
import java.util.concurrent.Semaphore;

public class SyncList<E> implements List {

    private List<E> list = new ArrayList<E>();
    Semaphore semaphore = new Semaphore(1);


    @Override
    public int size() {
        int s = 0;
        try {
            semaphore.acquire();
            s = list.size();
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public boolean isEmpty() {
        boolean empty = false;
        try{
            semaphore.acquire();
            empty = list.isEmpty();
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return empty;
    }

    @Override
    public boolean contains(Object o) {
        boolean c = false;
        try{
            semaphore.acquire();
             c = list.contains((E) o);
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public Iterator iterator() {
        Iterator i = list.iterator();
        try{
            semaphore.acquire();
            i = list.iterator();
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = null;
        try {
            semaphore.acquire();
            arr = list.toArray();
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return arr;
    }

    @Override
    public boolean add(Object o) {
        boolean added = false;
        try{
            semaphore.acquire();
            added  =list.add((E) o);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return added;
    }

    @Override
    public boolean remove(Object o) {
        boolean removed = false;
        try {
            semaphore.acquire();
            removed = list.remove((E) o);
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return removed;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean added = false;
        try{
            semaphore.acquire();
            added = list.addAll(c);
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return added;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        boolean added = false;
        try {
            semaphore.acquire();
            added = list.addAll(index, c);
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return added;
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            list.clear();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object get(int index) {
        Object o = null;
        try{
            semaphore.acquire();
            o = list.get(index);
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public Object set(int index, Object element) {
        Object o = null;
        try {
            semaphore.acquire();
            o = list.set(index, (E) element);
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public void add(int index, Object element) {
        try {
            semaphore.acquire();
            list.add(index, (E) element);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object remove(int index) {
        Object o = null;
        try {
            semaphore.acquire();
            o = list.remove(index);
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public int indexOf(Object o) {
        int i = 0;
        try {
            semaphore.acquire();
            i = list.indexOf((E) o);
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int lastIndexOf(Object o) {
        int i = 0;
        try {
            semaphore.acquire();
            i = list.lastIndexOf((E) o);
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ListIterator listIterator() {
        ListIterator li = list.listIterator();
        try {
            semaphore.acquire();
            li = list.listIterator();
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return li;
    }

    @Override
    public ListIterator listIterator(int index) {
        ListIterator li = list.listIterator();
        try {
            semaphore.acquire();
            li = list.listIterator();
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return li;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        List l = Collections.emptyList();
        try {
            semaphore.acquire();
            l = list.subList(fromIndex,toIndex);
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return l;
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean ra = false;
        try {
            semaphore.acquire();
            ra = list.retainAll(c);
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return ra;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean removed = false;
        try {
            semaphore.acquire();
            removed = list.removeAll(c);
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return removed;
    }

    @Override
    public boolean containsAll(Collection c) {
        boolean contain = false;
        try {
            semaphore.acquire();
            contain = list.containsAll(c);
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return contain;
    }

    @Override
    public Object[] toArray(Object[] a) {
        Object[] arr = a;
        try {
            semaphore.acquire();
            arr = list.toArray(a);
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return arr;
    }

    @Override
    public String toString() {
        return "SyncList{" + "list=" + list + '}';
    }
}
