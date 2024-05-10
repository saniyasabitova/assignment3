public class MyTestingClass {
    private String field1;
    private int field2;

    public MyTestingClass(int field2) {
        this.field2 = field2;
    }
    // Constructor, getters, setters, etc.


    public int myhashCode() {
//        int result = 19; // Start with a non-zero prime number
//
//        // Combine hash codes of fields
//        result = 31 * result + hashForString(field1);
//        result = 31 * result + field2;
//
//        return result;
        return field2;
    }

    public int hashForString(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = s.charAt(i) + 31 * hash; // Using a prime number like 31 is common
        }
        return hash;
    }
}