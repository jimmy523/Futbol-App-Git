package com.futbol.manager.model.utils.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: aandrade
 * @fecha: 04/09/2014
 */
public class SetModificable<E> implements Set<E> {

    private Set<E> hashSet;
    private Iterator<E> iterator;

    public SetModificable(Collection<? extends E> c) {
        hashSet = new HashSet<E>(c);
        iterator = hashSet.iterator();
    }

    public SetModificable() {
        hashSet = new HashSet<E>();
        iterator = hashSet.iterator();
    }


    @Override
    public int size() {
        return hashSet.size();
    }

    @Override
    public boolean isEmpty() {
        return hashSet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return hashSet.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return hashSet.iterator();
    }

    @Override
    public Object[] toArray() {
        return hashSet.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        T[] resultado = hashSet.toArray(a);
        iterator = hashSet.iterator();
        return resultado;
    }

    @Override
    public boolean add(E e) {
        boolean resultado = hashSet.add(e);
        iterator = hashSet.iterator();
        return resultado;
    }

    @Override
    public boolean remove(Object o) {
        boolean resultado = hashSet.remove(o);
        iterator = hashSet.iterator();
        return resultado;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return hashSet.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean resultado = hashSet.addAll(c);
        iterator = hashSet.iterator();
        return resultado;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean resultado =  hashSet.retainAll(c);
        iterator = hashSet.iterator();
        return resultado;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean resultado = hashSet.removeAll(c);
        iterator = hashSet.iterator();
        return resultado;
    }

    @Override
    public void clear() {
        hashSet.clear();
        iterator = hashSet.iterator();
    }

    public E getAndRemove(){
        if (iterator.hasNext()){
            E instance = iterator.next();
            hashSet.remove(instance);
            iterator = hashSet.iterator();
            return instance;
        }else return null;
    }
}
