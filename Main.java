import java.util.*;



public class Main {
    public static void main(String[] args) {
        //just for checking
        MyHashTable<String, Integer> h = new MyHashTable<String, Integer>(5);
        h.put("Saniya", 8);
        h.put("Sabina", 16);
        h.put("Adiya", 10);
        h.put("Dariya", 31);
        System.out.println( h.get("Dariya"));

        System.out.println(h.getkey(31));
//just for checking
//testing: number of elements in each linked list
        Random random = new Random();

        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(1000);
        for(int i=0;i<1000;i++){
            int randomNumber = random.nextInt(1001);
            table.put(new MyTestingClass(randomNumber),new Student());
        }

        for (int i=0;i<1000;i++){
            int size = table.sizeOfeach(i);
            System.out.println(size);
        }

        //testing BST and inOrder method printing each value and key
        BST tree = new BST();
        tree.put(90, "Dilnaz");
        tree.put(28, "Saniya");
        tree.put(78, "Alnur");
        tree.put(41, "Assemai");
        tree.put(54, "Angelina");
        //testing put and get methods
        Object o = tree.get(41);
        System.out.println(o);
        tree.inOrder();



    }}