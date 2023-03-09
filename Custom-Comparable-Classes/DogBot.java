import java.util.*;

public class DogBot implements Comparable<DogBot>
{
 protected int hungry,tired;
 private String name;
 private static int count=0;

 public DogBot(int h,int t,String nm)
 {
  hungry=h;
  tired=t;
  name=nm;
 }

 public DogBot(int h, int n)
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

 public int compareTo(DogBot that)
 { 
    TiredComp c = tired();
    return c.compare(this,that);
 }

 public static TiredComp tired(){ // returns comparator for 'tired' values.
    return new TiredComp();
 }

}