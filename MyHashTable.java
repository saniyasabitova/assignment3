public class MyHashTable <K,V>{
    private class HashNode<K,V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
public HashNode(){

}
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
     private HashNode<K,V> [] chainArray;
    private int M;
    private  int size;
    private MyHashTable(){

    }
    public MyHashTable(int capacity){
    this.M = capacity;
    chainArray = new HashNode[capacity];
    size = 0;
    }
   public int hash(K key) {
    if (key instanceof String) {
        String key1 = (String) key;
        int hash = 0;
    for (int i = 0; i < key1.length(); i++) {
        hash = (hash * 31 + key1.charAt(i)) % M; // Using a prime number like 31 is common
    }
    return hash;
    } else if (key instanceof Integer) {
        int key1  = (Integer) key;
        return key1%M;

    } else {
   if (key instanceof MyTestingClass) {
            int customKey = ((MyTestingClass) key).myhashCode() ;
            return customKey% M;
        }
    }
return -1;
}
    public void put(K key,V value){
    int index = hash(key);
    HashNode<K,V> node = chainArray[index];

    if(node==null){
        chainArray[index] = new HashNode<>(key,value);
    }
    else{
        while (node.next!=null){
            if(node.key.equals(key)){
                node.setValue(value);
                return;
            }
            node = node.next;
        }
        if (node.key.equals(key)){
            node.setValue(value);
            return;
        }
        node.next = new HashNode<>(key,value);
    }
    }
    public V get(K key){
    int index = hash(key);
    HashNode<K,V> node = chainArray[index];

    if(node==null){
        return null;
    }
    else{
        while(node.next!=null){
            if(node.key.equals(key)){
                return node.getValue();
            }
            node = node.next;
        }
        if (node.key.equals(key)){
            return node.getValue();
        }

    }
return null;
    }

    public V remove (K key){
         int index = hash(key);
    HashNode<K,V> node = chainArray[index];

    if(node==null){
        return null;
    }
    if(node.key.equals(key)){
        chainArray[index] = node.next;
        node.next = null;
        return (V) node.getValue();
    }

    HashNode<K,V> prev =node;
    node = node.next;

    while(node.next!=null){
        if(node.getKey()==key){
            prev.next = node.next;
            node.next = null;
            return node.getValue();
        }
        prev = node; // Update prev to the current node
        node = node.next; // Move to the next node
    }
    if(node.getKey()==key){
        prev.next = null;
        return node.getValue();

    }
return  null;
    }

    public int sizeOfeach(int number) {
        HashNode<K, V> n = new HashNode<>();
        n = chainArray[number];
        int size = 0;
        while (n!= null) {
            size++;
            n = n.next;
        }

        return size;
    }
    public boolean contains (K key){
int index = hash(key);
    HashNode<K,V> node = chainArray[index];

    if(node==null){
        return false;
    }
    else{
        while(node.next!=null){
            if(node.key.equals(key)){
                return true;
            }
            node = node.next;
        }
        if (node.key.equals(key)){
            return true;
        }

    }

return false;
    }
    public K getkey(V value){
    for(int i=0;i<chainArray.length;i++){
        HashNode<K,V> n = chainArray[i];
        while (n!=null){
            if(n.getValue().equals(value)){
                return n.getKey();
            }
            n=n.next;
        }
    }return null;
    }



}
