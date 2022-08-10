/*
Link: https://www.youtube.com/watch?v=2ijH5vcKIxQ&list=PL-Jc9J83PIiHq5rMZasunIR19QG3E-PAA&index=21
Question: Write Implementation of Hashmap
1. You are required to complete the code of our Hashmap class. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.
2. Input and Output is managed for you.
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class _12_HahmapImplementation {

    public static class HashMap<K, V> {
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList<HMNode>[] buckets; // N = buckets.length

        public HashMap() {  // Constructor
            initbuckets(4);   // initializing buckets
            size = 0;
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {  // bi -> bucketIndex
                buckets[bi] = new LinkedList<>();
            }
        }

        /* Put */

        public void put(K key, V value) throws Exception {
            int bi = hashfn(key);        // hashFunction will give bucketIndex
            int di = getIndexWithinBucket(key, bi);  // di -> dataIndex

            // Case of 'update'
            if (di != -1){
                HMNode node = buckets[bi].get(di);
                node.value = value;
            }
            // Case of 'insert'
            else {
                HMNode node = new HMNode(key, value);
                buckets[bi].add(node);
                size++;
            }
            // Calculating lambda
            double lambda = size * 1.0 / buckets.length;  // n/N
            if (lambda > 2.0){
                rehash();
            }
        }

        private void rehash() throws Exception {
            LinkedList<HMNode>[] oldBucketArray = buckets;

            initbuckets(oldBucketArray.length * 2);
            size = 0;

            for (int i = 0; i < oldBucketArray.length; i++){
                for (HMNode node : oldBucketArray[i]){
                    put(node.key, node.value);
                }
            }
        }

        private int hashfn(K key) {
            int hc = key.hashCode(); // hc -> hashCode which can be -ve, 0, +ve.
            return Math.abs(hc) % buckets.length; // Taking +ve only upto buckets.length (i.e doing modulus i.e compression)
        }
        private int getIndexWithinBucket(K key, int bi) {  // for finding dataIndex by traversing through linked-list at particular bucketIndex.
            int di = 0;
            for (HMNode node : buckets[bi]){
                if (node.key.equals(key)){
                    return di;   // return found di
                }
                di++;
            }
            return -1;
        }

        /* get */

        public V get(K key) throws Exception {
            int bi = hashfn(key);        // hashFunction will give bucketIndex
            int di = getIndexWithinBucket(key, bi);  // di -> dataIndex

            // Case of 'update'
            if (di != -1){
                HMNode node = buckets[bi].get(di);
                return node.value;
            }
            // Case of 'insert'
            else {
                return null;
            }
        }

        /* containsKey */

        public boolean containsKey(K key) {
            int bi = hashfn(key);        // hashFunction will give bucketIndex
            int di = getIndexWithinBucket(key, bi);  // di -> dataIndex

            // Case of 'update'
            if (di != -1){
                return true;
            }
            // Case of 'insert'
            else {
                return false;
            }
        }

        /* Remove */

        public V remove(K key) throws Exception {
            int bi = hashfn(key);        // hashFunction will give bucketIndex
            int di = getIndexWithinBucket(key, bi);  // di -> dataIndex

            // Case of 'update'
            if (di != -1){
                HMNode node = buckets[bi].remove(di);
                size--;
                return node.value;
            }
            // Case of 'insert'
            else {
                return null;
            }
        }

        /* keySet */

        public ArrayList<K> keySet() throws Exception {
            ArrayList<K> keys = new ArrayList<>();

            // Loop inside buckets (outer)
            for (int bi = 0; bi < buckets.length; bi++) {  // bi -> bucketIndex

                // Loop inside linkedList (inner)
                for (HMNode node : buckets[bi]){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        /* size */

        public int size() {
            return size;
        }

        /* Display */
        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node : buckets[bi]) {
                    System.out.print( node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
    }

    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> map = new HashMap();
        map.put("India", 135);
        map.put("Aus", 5);
        map.put("Canada", 5);
        map.display();   // Display Begins
                         // Bucket0 .
                         // Bucket1 .
                         // Bucket2 Canada@5 .
                         // Bucket3 India@135 Aus@5 .
                         // Display Ends

        System.out.println(map.get("China"));  // null
        System.out.println(map.remove("Aus"));  // 5
        System.out.println(map.get("Aus"));  // null
        System.out.println(map.containsKey("US"));  // false
        map.put("US", 10);
        map.put("UK", 20);
        System.out.println(map.remove("US"));  // 10
        System.out.println(map.containsKey("US"));  // false
        map.put("Pak", 80);
        map.put("China", 200);
        map.display();    // Display Begins
                          // Bucket0 .
                          // Bucket1 .
                          // Bucket2 Canada@5 UK@20 Pak@80 .
                          // Bucket3 India@135 China@200 .
                          // Display Ends

        map.put("Utopia", 0);
        map.display();  // Display Begins
                        // Bucket0 Utopia@0 .
                        // Bucket1 .
                        // Bucket2 Canada@5 UK@20 Pak@80 .
                        // Bucket3 India@135 China@200 .
                        // Display Ends
    }
}

/*
Output:
Display Begins
Bucket0 .
Bucket1 .
Bucket2 Canada@5 .
Bucket3 India@135 Aus@5 .
Display Ends
null
5
null
false
10
false
Display Begins
Bucket0 .
Bucket1 .
Bucket2 Canada@5 UK@20 Pak@80 .
Bucket3 India@135 China@200 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@5 UK@20 Pak@80 .
Bucket3 India@135 China@200 .
Display Ends

 */