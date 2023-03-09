public class customList_Iterator{

    public static void main(String[] args){ // Testing
        ListSet t = new ListSet();
        ListSet t2 = new ListSet();
        ListSet t3 = new ListSet();

        t.add(6);
        System.out.println(t); // Returns [6, ] as 6 has been added to ListSet.
        t.remove(6);
        System.out.println(t); // Returns [] as 6 has been removed from ListSet.

        
        t.add(7);
        t.add(8);
        t.add(9);

        t2.add(7);
        t2.add(9);
        t2.add(8);

        t3.add(7);
        t3.add(8);
        t3.add(10);
        t3.add(12);

        System.out.println(t.equals(t2)); // Returns true - order doesn't matter in a set, same numbers are present.
        System.out.println(t.equals(t3)); // Returns false, t and t3 have different lengths.

        System.out.println(t3.remove(13)); // Returns false - t3 doesn't contain the passed value to remove.
        t3.remove(12); 
        System.out.println(t.equals(t3)); // Returns false, t and t3 contain differing values.

        t3.add("String");
        System.out.println(t3.contains("String")); // Returns true, as t3 contains this String.
        System.out.println(t3);

        Iterator<Integer> it = t.iterator();
        System.out.println(it.next()); // Returns 7, first element of t.
        System.out.println(it.next()); // Returns 8, second element of t.


        System.out.println(t);
        it.remove();                // 8, the last element accessed by the iterator, has been removed.
        System.out.println(t);

        System.out.println(it.next()); // this returns null when called, as there are no next elements.


    }

    

}
