import java.util.*;

public class TiredComp implements Comparator<DogBot>{ // comparator for 'tired' values.
    
    @Override
    public int compare(DogBot a, DogBot b){
        int res = a.tired - b.tired;
        if (res < 0){
            return -1;
        } else if (res > 0){
            return 1;
        } else {
            return 0;
        }
    }
}