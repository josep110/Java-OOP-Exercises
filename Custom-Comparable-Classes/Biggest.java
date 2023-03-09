import java.util.*;

public class Biggest{
    public static <E extends Comparable<? super E>> E biggest(ArrayList<E> list, Comparator<E> c)
    {

        E biggest=list.get(0);
        for (int i=1; i<list.size(); i++){
            E next=list.get(i);
            if (c.compare(biggest,next)<0) biggest=next;
        }
    return biggest;   
    }

    public static <E extends Comparable<? super E>> ArrayList<E> listBiggest(ArrayList<E> list, Comparator<E> c){


        E biggest=list.get(0);
        ArrayList<E> bigList = new ArrayList<E>();
        bigList.add(biggest);
        for (int i=1;i<list.size();i++){
            E next=list.get(i);
            if (c.compare(biggest, next)<0){
                biggest=next;
                bigList = new ArrayList<E>();
                bigList.add(biggest);
            } else if (c.compare(biggest,next)==0){
                bigList.add(next);
            }
        }
        return bigList;
    }

    public static <E extends Comparable<? super E>> Set<E> setBiggest(Set<E> set, Comparator<E> c){ // new method for Set<E>
        
        HashSet<E> bigSet = new HashSet<E>();

        Iterator<E> it = set.iterator();
        E biggest = it.next();
        bigSet.add(biggest);
        
        while (it.hasNext()){
            E next = it.next();
            if (c.compare(biggest, next) < 0){
                biggest=next;
                bigSet = new HashSet<E>();
                bigSet.add(biggest);
            } else {
                bigSet.add(next);
            }
        }
    return bigSet;
    }
}