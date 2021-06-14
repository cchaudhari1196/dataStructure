package HashMap;

import java.security.KeyException;
import java.util.LinkedList;
import java.util.List;

/*This Solution is By Me. Also, Refer Mosh Solution in same Package.*/
public class HashMapMain {
	
	public static void main(String[] args) throws Exception {

		HashMap hm = new HashMap(5);
		hm.put(23, 858);
		hm.put(76, 9696);
		hm.put(28, 48934);
		hm.put(29, 2);
		hm.print();
		hm.remove(28);
		hm.print();
		
		System.out.println(hm.get(29));
	}

}


/*
 * Custome HashMap with Chaining method to prevent collition.
 * We will be using Array to Store the Data.
 */
class HashMap{
	
	private List<Entry>[] hashMapArray;

	public HashMap(int capacity) {
		this.hashMapArray = new LinkedList[capacity];
	}
	
	public void put(Integer key, Integer value) throws Exception {
		if(this.get(key)!= null)
			throw new Exception("Key Already Exists");
		var entry = new Entry(key, value);
		
		var hasedIndex = hash(key);
		List<Entry> ll;
		if(hashMapArray[hasedIndex] == null)
			ll = new LinkedList<>();
		else
			ll = hashMapArray[hasedIndex];
		
		ll.add(entry);
		
		hashMapArray[hasedIndex] = ll;
	}
	
	public Entry get(Integer key) {
		var hasedIndex = hash(key);
		
		if(hashMapArray[hasedIndex] == null)
			return null;
		List<Entry> lList = hashMapArray[hasedIndex];
		for(Entry entry:lList) {
			if(key.equals(entry.getKey()))
				return entry;
		}
		return null;
	}
	
	public Boolean remove(Integer key) throws Exception {
		var isRemoved = false;
		
		List<Entry> ll = hashMapArray[hash(key)];
		if(ll == null)
			throw new Exception("Key Not Available");
		
		Entry entryToRemove = null;
		for(Entry entry : ll) {
			if(key.equals(entry.getKey())) {
				entryToRemove = entry;
				isRemoved = true;
			}
		}
		ll.remove(entryToRemove);
		return isRemoved;
	}
	
	/*This is the Hash Function*/
	private Integer hash(Integer key) {
		var hash = key % hashMapArray.length;
		return hash;
	}
	
	
	
	public void print() {
		for(List<Entry> l : hashMapArray) {
			if( l == null)
				continue;
			for(Entry e :l) {

				System.out.println(e.toString());
			}
		}
		System.out.println("____________________");
	}
	
}

class Entry{
	
	private Integer key;
	private Integer value;
	
	public Entry(Integer key, Integer value) {
		this.key = key;
		this.value = value;
	}
	
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Entry [key=" + key + ", value=" + value + "]";
	}
}