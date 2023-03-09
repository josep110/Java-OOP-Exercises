public class DogBotWrappers{
    public static void main(String[] args){
        PlainDogBot plain = new PlainDogBot(10,10,"Robert");
        EatingDogBot e_plain = new EatingDogBot(plain);         // Wrapping instance of PlainDogBot with name 'Robert'
        System.out.println(e_plain.toString());                 // Prints 'Eating Robert'
        
        System.out.println(e_plain.getFood());          // value of food is initialised to 0.
        System.out.println(e_plain.eat());              // ...so EatingDogBot cannot eat, and a call to the eat method returns False.
        e_plain.addFood(3);
        System.out.println(e_plain.getFood());
        System.out.println(e_plain.eat());              // <- 
        System.out.println(e_plain.eat());              // Prints True for this two call method calls, as underlying DogBot in plain has sufficient hunger to eat.
        System.out.println(e_plain.eat());              // Prints False, as hunger has decreased enough to disallow eating.

        DogBotActionCounter counter = new DogBotActionCounter();
        PlainDogBot c = new PlainDogBot(20,20,"Critter");
        ObservableDogBot co = counter.observeExisting(c);
        co.addObserver(counter);
        co.eat();
        co.eat();
        System.out.println(counter.eatCount("Critter"));    // Returns 2, number of times 'Critter' has eaten.

        co.rest();
        co.rest();
        co.rest();

        System.out.println(counter.restCount("Critter")); // Returns 3, number of times 'Critter' has rested.

        co.play();

        System.out.println(counter.playCount("Critter")); // Returns 1, number of times 'Critter' has played.


        PlainDogBot c1  = new PlainDogBot(20,20,"Russell");
        ObservableDogBot co1 = counter.observeExisting(c1);
        co1.addObserver(counter);
        co1.eat();
        co1.eat();
        co1.eat();
        System.out.println(counter.eatCount("Russell"));    // Returns 3, number of times 'Russell' has eaten.

        co1.rest();


        System.out.println(counter.restCount("Russell"));   // Returns 1, number of times 'Russell' has rested.

        co1.play();
        co1.play();

        System.out.println(counter.playCount("Russel"));    // Returns 0, As name is misentered. 
        System.out.println(counter.playCount("Russell"));   // Returns 2, number of times Russell has played.


        ObservableDogBot co2 = counter.observeNew();        // Generate new observable DogBot.
        co2.addObserver(counter);
        String newName = co2.toString();
        System.out.println(newName);                        // Returns default name for new DogBot (DogBot1)
        co2.eat();
        co2.eat();
        co2.eat();
        co2.eat();
        System.out.println(counter.eatCount(newName));      // Returns 4, number of times new DogBot has eaten.


    }
}
