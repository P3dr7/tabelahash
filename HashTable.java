package hashTableTree;

public class HashTable<T> {
    
	private Tree[] buckets;

    public HashTable() {
        this.buckets = new Tree[3];
        for(int i=0; i<this.buckets.length; i++) {
            this.buckets[i] = new Tree();
        }
    }

    private int hash_function(int key) {
        return key % this.buckets.length; 
    }

    public void put(int key, String value) {
        int b = this.hash_function(key);
        Pair pair = new Pair(key, value);
        this.buckets[b].insert(key, pair);
    }

    public String get(int key) {
        int b = this.hash_function(key);
        Pair pair = (Pair)this.buckets[b].get(key);
        if(pair != null) {
            return pair.value;
        }
        return null;
    }
    

    @Override
    public String toString() {
        String out = "{\n";
        for(int i=0; i<this.buckets.length; i++) {
            out += "\t" + this.buckets[i].toString() + "\n";
        }
        return out + "}";
    }
	
    public static void main(String[] args) {

        HashTable ht = new HashTable();
        System.out.println(ht.toString());
        ht.put(0, "a");
        System.out.println(ht.toString());
        ht.put(1, "b");
        System.out.println(ht.toString());
        ht.put(2, "c");
        System.out.println(ht.toString());
        ht.put(3, "d");
        System.out.println(ht.toString());
        ht.put(4, "e");
        System.out.println(ht.toString());
        ht.put(5, "f");
        System.out.println(ht.toString());

        System.out.println(ht.get(2));
        System.out.println(ht.get(10));
    }
}

