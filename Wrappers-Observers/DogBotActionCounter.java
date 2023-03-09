
import java.util.Observable;
import java.util.Observer;
import java.util.HashMap;

class ObservableDogBot extends Observable{              // observable wrapper.
    private PlainDogBot under;

    public ObservableDogBot(PlainDogBot dg){
        under = dg;
    }

    public boolean eat(){
        if (under.eat()){ setChanged(); notifyObservers("eat"); return true; }
        return false;
    }

    public void rest(){ under.rest(); setChanged(); notifyObservers("rest");}

    public void play(){ under.play(); setChanged(); notifyObservers("play");}

    public String toString(){
        return under.toString();
    }
}



class DogBotActionCounter implements Observer{
    
    private HashMap<String, Integer> rest_mp;
    private HashMap<String, Integer> eat_mp;
    private HashMap<String, Integer> play_mp;


    public DogBotActionCounter(){               // Return whole new wrapped object.
        rest_mp = new HashMap();
        eat_mp = new HashMap();
        play_mp = new HashMap();
    }

    public ObservableDogBot observeExisting(PlainDogBot dg){
        return new ObservableDogBot(dg);
    }

    public ObservableDogBot observeNew(){
        return new ObservableDogBot(new PlainDogBot(20,20));
    }

    public void update(Observable obj, Object act){
        if (obj instanceof ObservableDogBot){
            ObservableDogBot dug = (ObservableDogBot)obj;
            String nm = dug.toString();
            if (act.equals("eat")) { 
                if (eat_mp.containsKey(nm)) { eat_mp.put(nm, eat_mp.get(nm)+1);}
                else { eat_mp.put(nm,1);}
            } else if (act.equals("rest")){ 
                if (rest_mp.containsKey(nm)) { rest_mp.put(nm, rest_mp.get(nm)+1);}
                else { rest_mp.put(nm, 1);}
            } else if (act.equals("play")){ 
                if (play_mp.containsKey(nm)) { play_mp.put(nm, play_mp.get(nm)+1);}
                else { play_mp.put(nm, 1);}    
            }   
        }
    }

    public int eatCount(String name){ 
        if (eat_mp.containsKey(name)) { return eat_mp.get(name); }
        else { return 0; }
    }

    public int restCount(String name){
        if (rest_mp.containsKey(name)) { return rest_mp.get(name); }
        else { return 0; }
    }

    public int playCount(String name){
        if (play_mp.containsKey(name)) { return play_mp.get(name); }
        else { return 0; }
     }


}