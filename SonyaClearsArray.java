import java.lang.*;
import java.io.*;
import java.util.*;
public class SonyaClearsArray

{

public static int[] removeelement(int[] a,int index)
{
 int[] newarr = new int[a.length - 1];
for(int i = 0; i<index;i++)
  {
    newarr[i] = a[i];
  }
  for(int i = index + 1; i<a.length;i++)
    {
      newarr[i - 1] = a[i];
    }
  return newarr;
}
public static boolean isPrime(int n)
{
  if(n == 1){return false;}
  int x = 2;
  boolean found = false;
  int s = (int)Math.sqrt(n);
  while( x<= s)
  {
    if(n%x == 0){found = true;}
    x++;
  }
  return !found;
}

public static int findNextPrime(int n)
 {
   int x = 1;
   boolean  primefound = false;
  while(!primefound)
  {
    if(isPrime(n+x)){primefound = true;}
    x++;
  }
  return n+x-1;
}
public static String toString(int[] a)
{
  String s = " ";
  for(int i = 0; i < a.length; i++)
  {s = s + a[i];}
  return s;
}
public static int findmindiff(int[] a) //returns the index i such that a[i] - a[i+1] is minimal
{
  if(a.length == 2){return 0;}
  int mindiff= a[1] - a[0];
  int minind = 0;
  for(int i = 0; i<a.length-1; i++)
  {
    if (a[i] - a[i+1] <mindiff){minind = i;}
  }
  return minind;
}
public static int minsteps(int[] a)
{
  int stepcount = 0;
  int i = 0;
  int j = 1;
  while(a.length > 0)
  {
    if(a[i]<a[j]){
      if(isPrime(a[i]) && isPrime(a[j]))
      {
          if(findNextPrime(a[i]) == a[j])
          {
            a = removeelement(a,j);
            a = removeelement(a,i);
            stepcount++;
           if(i>=2)
            {i = i - 2;
            j = j - 2;}
            else{i = 0;j = i + 1;}
          }
          else
          {
            int tempi = a[i];
           a[i] = findNextPrime(a[i]);
            stepcount = stepcount + (a[i] - tempi);
            if(j<a.length-1)
             {j++;i++;}
            }
          }
        else
          {
            if(isPrime(a[j]))
              {
              int tempi = a[i];
              a[i] = findNextPrime(a[i]);
              stepcount = stepcount + (a[i] - tempi);
              if(j<a.length-1)
               {j++;i++;}
               }
             else
                {
                  int tempj = a[j];
                  a[j] = findNextPrime(a[j]);
                  stepcount = stepcount + (a[j] - tempj);
                }
              }

        }

    else
      {

        if(i>1){
        i--;
        j--;}
        else{
        int temp = a[j];
        a[j] = a[i];
        a[j] = findNextPrime(a[i]);
        stepcount = stepcount + (a[j] - temp);}
       }

  }
  return stepcount;
}

public static void main(String[] args) throws IOException
{
 String filename = args[0];
  Scanner fileInput = new Scanner(new File(filename));
  int size = fileInput.nextInt();
  int[] inputarr = new int[size];
  int i = 0;
  while(fileInput.hasNext())
  {
    inputarr[i] = fileInput.nextInt();
    i++;
  }
System.out.println(minsteps(inputarr));
}
}
