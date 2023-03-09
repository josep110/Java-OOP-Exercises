class EatingDogBot{
    private PlainDogBot under;
    private int food;

    EatingDogBot(PlainDogBot db){
        under = db;
        food = 0;
    }

    public boolean eat(){
        if (food > 0){
            if (under.eat()){ food--; return true; }
            else {return false; }
        } else { return false; }
    }

    public String toString(){
        return "Eating " + under.toString();
    }

    public int getFood(){
        return food;
    }

    public void addFood(int n){
        food += n;
    }

}

