class DrinksMachineCustomer{ // Wrapper class for restricting methods accessible to customer.

    private DrinksMachine under;
    DrinksMachineCustomer(DrinksMachine dm) { under = dm; }

    public void insert(int n){ under.insert(n); }

    public int getBalance(){ return under.getBalance(); }

    public int pressChange(){ return under.pressChange(); }

    public Can press(String drink) throws NoDrinksException, NoFundsException, MachineEmptyException { return under.press(drink); }
 
}
