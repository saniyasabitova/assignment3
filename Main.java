import java.util.*;


public class Main {
    public static void main(String[] args) {
        MyHashTable<String, Integer> h =new MyHashTable<String,Integer>(5);
        h.put("Saniya", 8);
        h.put("Sabina", 16);
        h.put("Adiya", 10);
        h.put("Dariya", 31);
        System.out.println( h.get("Dariya"));

        System.out.println(h.getkey(31));


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

    }
}