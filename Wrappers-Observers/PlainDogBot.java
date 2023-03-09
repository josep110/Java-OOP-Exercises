class PlainDogBot implements DogBot, Comparable<PlainDogBot>
{
   protected int hungry,tired;
   private String name;
   private static int count=0;

 public PlainDogBot(int h,int t,String nm)
 {
  hungry=h;
  tired=t;
  name=nm;
 }

 public PlainDogBot(int h, int n)
 {
  this(h,n,"DogBot"+(++count));
 }

 public boolean eat()
 {
  if(hungry>6)
     {
      hungry-=3;
      return true;
     }
  else
     return false;
 }

 public void rest()
 {
  hungry++;
  tired-=2;
 }

 public void play()
 {
  hungry+=2;
  tired+=3;
 }

 public String noise()
 {
  if(hungry>8&&tired<11)
     return "whine ";
  else if(tired>7&&tired>hungry)
     return "snore ";
  else
     return "woof ";
 }
 
 public String toString()
 {
  return name;
 }

 public int compareTo(PlainDogBot that)
 {
  return this.hungry-that.hungry;
 }

}
