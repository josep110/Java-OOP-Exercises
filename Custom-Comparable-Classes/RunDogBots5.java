import java.util.*;

public class RunDogBots5{

    public static void main(String[] args){ // Testing

        
        HashSet<DogBot> dogs = new HashSet<DogBot>();
        DogBot d1 = new DogBot(5,4,"Marcus");
        DogBot d2 = new DogBot(10,6,"Aurelius");
        DogBot d3 = new DogBot(12,5,"Julius");
        TiredComp t = DogBot.tired();
        System.out.println(t.compare(d1,d1)); // returns 0, as tired values are equal.
        System.out.println(t.compare(d1,d3)); // returns -1, as d1.tired < d3.tired.
        System.out.println(t.compare(d3,d1)); // returns 1, as d3.tired > d1.tired.
        dogs.add(d1);
        dogs.add(d2);
        dogs.add(d3);
        dogs.add(d1);
        
        Set<DogBot> tSet = Biggest.setBiggest(dogs, t);
        System.out.println(tSet);                          // Returns [Aurelius, Julius, Marcus], these are correctly sorted by order of 'tired', biggest to smallest. 
                                                        // Only one reference to Marcus exists in the Set, despite being added twice.


        
        TreeSet<DogBot> dogs2 = new TreeSet<DogBot>();
        dogs2.add(d1);
        dogs2.add(d2);
        dogs2.add(d3);
        System.out.println(dogs2); // Returns [Marcus, Julius, Aurelius], sorted from smallest to biggest as a TreeSet<> is ordered according to result of compareTo() method.

        Set<DogBot> tSet2 = Biggest.setBiggest(dogs2, t);
        System.out.println(tSet2);                        // Returns [Aurelius], the object with the highest tired value. 
                                                          // This is because when navigating a TreeMap, larger elements are children of smaller elements, so traversal is always smallest->largest,
                                                          // resulting in only the largest element being placed in the new Set returned by the setBiggest() method.
    }
}
