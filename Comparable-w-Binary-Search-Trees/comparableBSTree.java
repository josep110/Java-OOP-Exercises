public class comparableBSTree{

    public static void main(String[] args){      // testing
        BSTree<String> t = BSTree.empty();
        System.out.println(t.isEmpty());         // Returns true, tree is empty at initialisation.
        t = t.add("Steve");                      // New BSTree with added object returned.
        System.out.println(t.root());            // Returns "Steve".
        System.out.println(t.isEmpty());         // Returns false, tree no longer empty.
        t = t.add("Karen");
        t = t.add("Daniel");
        t = t.add("Nathan");
        t = t.add("Jack");
        t = t.add("Melissa");


        BSTree<Integer> t1 = BSTree.empty();
        System.out.println(t1.isEmpty());         // Returns true, tree is empty at initialisation. 

        t1.add(6);
        t1.add(4);
        t1.add(2);
        t1.add(12);
        t1.add(78);
        t1.add(54);


        System.out.println(t1.contains(20)); // Returns false, as 20 is not present in tree.
        System.out.println(t1.contains(78)); // Returns true, as 78 is present in tree.

        BSTree<Integer> l1 = t1.left();
        BSTree<Integer> r1 = t1.right();
        System.out.println(t1.root());
        System.out.println(l1.root());
        System.out.println(r1.root());
        System.out.println(l1.left().root());
        System.out.println(r1.right().root());

        System.out.println(t1.contains(78));
        t1 = t1.remove(78);
        System.out.println(t1.contains(78)); // Returns false, 78 not present in new tree.
        System.out.println(t1.contains(6));
        System.out.println(t1.root()); // Returns true, as new tree still has other items.

    }
    
}
