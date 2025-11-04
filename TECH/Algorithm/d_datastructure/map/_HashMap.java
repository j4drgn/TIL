package com.mc.algorithm.d_datastructure.map;

import java.util.Arrays;

import com.mc.algorithm.d_datastructure.list._LinkedList;
import com.mc.algorithm.d_datastructure.set._HashSet_P3;

@SuppressWarnings("unchecked")
public class _HashMap<K,V> {
	
	private int size = 0;
	private Object[] table;
	private int arraySize = 10;
	private _HashSet_P3<Entry<K,V>> entrySet = new _HashSet_P3<>();
	
	public _HashMap() {
		this.table = new Object[arraySize];
	}
	
	public _HashMap(int initialCapacity) {
		this.table = new Object[initialCapacity];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return this.size;
	}
	
	private int hash(Object e) {
		int hashCode = Math.abs(e.hashCode());
		return hashCode % arraySize;
	}
	
	private V addEntry(Entry<K,V> entry) {
		int index = hash(entry);
		_LinkedList<Entry<K,V>> row = (_LinkedList<Entry<K,V>>) table[index];
		
		if(row == null) {
			_LinkedList<Entry<K,V>> newRow = new _LinkedList<Entry<K,V>>();
			newRow.add(entry);
			table[index] = newRow;
			entrySet.add(entry);
			return null;
		}
		
		if(row.contains(entry)) {
			int i = row.indexOf(entry);
			entrySet.remove(entry);
			
			V prevValue = row.get(i).getValue();
			row.remove(i);
			row.add(entry);
			entrySet.add(entry);
			return prevValue;
		}
		
		row.add(entry);
		entrySet.add(entry);
		return null;
	}
	
	private void resize() {
		Object[] temp = Arrays.copyOf(table, arraySize);
		arraySize *= 2;
		table = new Object[arraySize];
		
		for (int i = 0; i < temp.length; i++) {
			if(temp[i] == null) continue;
			_LinkedList<Entry<K,V>> row = (_LinkedList<Entry<K,V>>) temp[i];
			
			for (Entry<K,V> e : row) {
				addEntry(e);
			}
		}
	}
	
	public V put(K key, V value) {
		if(size == arraySize) {
			resize();
		}
		
		V res = addEntry(new Entry<K, V>(key, value));
		size++;
		return res;
	}
	
	public V get(Object key) {
		Entry<K, V> dummy = new Entry<K, V>((K)key, null);
		int index = hash(dummy);
		_LinkedList<Entry<K, V>> row = (_LinkedList<Entry<K, V>>) table[index];
		
		if(row == null) return null;
		
		if(!row.contains(dummy)) return null;
		return row.get(row.indexOf(dummy)).getValue();
	}
	
	public V remove(K key) {
		Entry<K, V> dummy = new Entry<K, V>(key, null);
		int index = hash(dummy);

		_LinkedList<Entry<K, V>> row = (_LinkedList<Entry<K, V>>) table[index];
		
		if(row == null) return null;
		if(!row.contains(dummy)) return null;
		
		Entry<K, V> prevEntry = row.get(row.indexOf(dummy));
		row.remove(row.indexOf(dummy));
		entrySet.remove(dummy);
		if(row.isEmpty()) table[index] = null;
		
		size--;
		return prevEntry.getValue();
	}
	
	public _HashSet_P3<Entry<K,V>> entrySet(){
		return this.entrySet;
	}
	
	
	
	
	
	
	

}
