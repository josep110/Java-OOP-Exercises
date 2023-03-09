import java.util.ArrayList;

public class CustomExceptions{

    public static void main(String[] args){ // testing
        DrinksMachine dm = new DrinksMachine();

        try { System.out.println(dm.press("Fanta").type); } catch (Exception e) { System.out.println(e); } // Throws MachineEmptyException, as the machine is initially empty.

        System.out.println(dm.getBalance()); // Returns 0, as machine has no money entered.

        System.out.println(dm.load("Fanta", 2)); // returns true, can is loaded into machine.
        System.out.println(dm.load("Coke", 2)); 
        System.out.println(dm.load("Red Bull", 4));

        try { System.out.println(dm.press("Shasta").type); } catch (Exception e) { System.out.println(e); } // NoDrinksException thrown, as this drink type does not exist in 'cans'.

        try { System.out.println(dm.press("Fanta").type); } catch (Exception e) { System.out.println(e); } // NoFundsException thrown, as no cash has been inserted into machine.

        dm.insert(1);

        System.out.println(dm.getBalance()); // Entered balance returned.

        try { System.out.println(dm.press("Fanta").type); } catch (Exception e) { System.out.println(e); } // NoFundsException thrown, as not enough cash has been inserted into machine.

        dm.insert(1);

        try { System.out.println(dm.press("Fanta").type);  } catch (Exception e) { System.out.println(e); } // "Fanta" returned, as transaction is successful. 

        try { System.out.println(dm.press("Fanta").type);  } catch (Exception e) { System.out.println(e); } // NoDrinksException returned, as the instance of Fanta in the DrinksMachine has been removed.

        try { System.out.println(dm.press("Coke").type);  } catch (Exception e) { System.out.println(e); } //  NoFundsException returned as the entered balance has already been spent. 

        dm.insert(2);

        try { System.out.println(dm.press("Coke").type);  } catch (Exception e) { System.out.println(e); } // "Coke" returned, as transaction is successful. 

        dm.insert(3);

        try { System.out.println(dm.press("Red Bull").type);  } catch (Exception e) { System.out.println(e); } // NoFundsException thrown, as not enough cash has been inserted into machine.

        dm.insert(1);

        try { System.out.println(dm.press("Red Bull").type);  } catch (Exception e) { System.out.println(e); } // "Red Bull" returned, as transaction is successful.

        try { System.out.println(dm.press("Red Bull").type);  } catch (Exception e) { System.out.println(e); } // Throws MachineEmptyException, as the machine is now empty again.

        dm.load("Red Bull", 4);

        dm.insert(3);

        try { System.out.println(dm.press("Red Bull").type);  } catch (Exception e) { System.out.println(e); } // NoFundsException thrown, as not enough cash has been inserted into machine.

        try { dm.setPrice("Red Bul", 3); } catch (Exception e) { System.out.println(e); }                       // Throws no drink exception, as type is misentered.

        try { dm.setPrice("Red Bull", 3); } catch (Exception e) { System.out.println(e); } 

        try { System.out.println(dm.press("Red Bull").type);  } catch (Exception e) { System.out.println(e); } // Returns "Red Bull", as the price has been modifed, so there is now sufficient funds to buy Red Bull.

        dm.insert(1);
        System.out.println(dm.getBalance());
        System.out.println(dm.collectCash());

        System.out.println(dm.load("Fanta", 2)); // returns true, can is loaded into machine.
        System.out.println(dm.load("Coke", 2)); 
        System.out.println(dm.load("Red Bull", 4));


        DrinksMachineCustomer dmc = new DrinksMachineCustomer(dm); // Testing wrapper class.

        dmc.insert(2); // Funds can be added to underlying DrinksMachine through wrapper class.

        try { System.out.println(dmc.press("Fanta").type); } catch (Exception e) { System.out.println(e); } // Returns "Fanta", drinks can still be purchased if present and enough funds are added.

        
      //  try { System.out.println(dmc.setPrice("Fanta",1).type); } catch (Exception e) { System.out.println(e); } // Crashes, customer does not have access to setPrice() method, as this is not listed in wrapper class body.
        
      //  try { System.out.println(dmc.dm.setPrice("Fanta",1).type); } catch (Exception e) { System.out.println(e); } // Crashes, as underlying DrinksMachine has private access in wrapper class.

        dmc.insert(3);
        
        System.out.println(dmc.getBalance()); // Balance returned, getBalance() can still be accessed through wrapper class.

        System.out.println(dmc.pressChange()); // Change returned, pressChange() in underlying DrinksMachine can be accessed through WrapperClass.



    }
}
