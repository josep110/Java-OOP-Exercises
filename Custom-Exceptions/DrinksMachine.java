class DrinksMachine{            // base DrinksMachine class.
 private ArrayList<Can> cans;
 private int balance,cash;

 public DrinksMachine()
 {
  balance = 0;
  cash = 0;
  cans = new ArrayList<Can>();
 }

 public void insert(int n)
 {
  balance=balance+n;
 }

 public int getBalance()
 {
  return balance;
 }

 public int collectCash()
 {
  int oldCash = cash;
  cash = 0;
  return oldCash;
 }

 public int pressChange()
 {
  int change=balance;
  balance=0;
  return change;
 }

 public Can press(String drink) throws NoDrinksException, NoFundsException, MachineEmptyException{
    try {
        if (cans.size()==0) { throw new MachineEmptyException(); }
        else 
           { for (int i=0;i < cans.size();i++){
                Can targ = cans.get(i);
                if (targ.type.equals(drink)){
                    int p = targ.price;
                    if (balance - p >= 0){
                        cans.remove(i);
                        balance = balance - p;
                        cash = cash + p;
                        return targ; }
                    else { throw new NoFundsException(); }
                }
            }
            throw new NoDrinksException();}
    }
    catch (NullPointerException e){
        throw new MachineEmptyException();
    }
 }


 public boolean load(String type, int p){
    if (cans.add(new Can(type, p))){
        return true;
    }
    return false;
 }

 public void setPrice(String drink, int p) throws NoDrinksException{
        for (int i=0; i < cans.size();i++){
            Can targ = cans.get(i);
            if (targ.type.equals(drink)){
                targ.setPrice(p);
            }
            throw new NoDrinksException();
        }
    }

}
