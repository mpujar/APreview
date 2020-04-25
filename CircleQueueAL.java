
/**
 * Write a description of class CircleQueueAL here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class CircleQueueAL
{
    //create an arraylist to hold all teh objects
    private ArrayList<Object> arr;
    private int indx; //current element mirroring currentPosition
    
    //cobstructor for the arraylist, creates an empty list
    
    public CircleQueueAL(){
     arr.clear();
    }
    
    public Object getFirstObject(){
        Object first;
        if (arr.size() == 0) {
         first = null;   
        }
        else {
            first = arr.get(0);
        }   
        return first;
    }
    
    public Object getLast() {
        Object last;
        int temporary = arr.size() -1;
        if (arr.size() == 0) {
            last = null;
        }
        else{
         last = arr.get(temporary);   
        }
        return last;
    }
    
    public Object getObject(){
        Object current;
        if(arr.size() == 0) {
            current = null;
        }
        else {
            current = arr.get(indx);
        }
        return current;
    }
    
   
    public void setNext()
    {
       int maximum = arr.size() - 1;
        if  (indx != maximum) indx++;
        
        else System.out.println("You reached the end of the Array List Circle Queue");
    } 
  
    public void setPrevious()
    {
        if (indx != 0) indx--;
        else System.out.println("Can't go previous, you are at the start");
        }
  
        public void add(Object opaqueObject)
        {
      arr.add(opaqueObject);
    }
    //delete an object at the start
    public Object delete()
    {
      Object delete = null;
          
      if (arr.size() != 0) {
        delete = arr.get(0);
        arr.remove(0);
        }
            
      return delete;
    }
  
  
  /**
   *  Returns a string representation of this Queue,
   *  polymorphic nature of toString overrides of standard System.out.print behavior
   *
   * @return    string representation of this Queue
   */
  public String toString()
  {
    String queueToString = "[";

    int size = arr.size();
    int y;
    for (y = 0; y < size; y++) {
        queueToString += "("+arr.get(y)+")";
    }
    queueToString += "]";
    return queueToString;
  }
  
  /**
   * Performs insertion sort based off of the contents of object
   */
  public void insertionSort() { 
    ArrayList<Object> presort = arr;
    int y = presort.size();
    indx = 1;
    String during = presort.get(indx).toString();
    int temporary = indx - 1;
    
    for (indx = 1; indx < y; indx++){
     during = presort.get(indx).toString();
     temporary = indx - 1;
     while( temporary > 0 && presort.get(temporary).toString().compareTo(during) > 0){
         presort.set(temporary + 1, presort.get(temporary));
         temporary--;
        }
    }    
    presort.set(temporary + 1, during);
  } 
  
  
  /**
   * Performs selection sort based off of the contents of the object
   * 
   */
  
  public void selectionSort() {
      //declare integer for length
        ArrayList <Object> presort = arr;
        int len = presort.size();
        Object temporary;
        //move the boundary of the unsorted subarry
        for (int i = 0; i < len-1; i++) {
            //find the minimum element of the subarray
            int minIndx = i;
            for (int j = i + 1; j < len; j++) {
                if (presort.get(j).toString().compareTo(presort.get(minIndx).toString()) < 0){
                 minIndx = j;   
                }
            }
            //Make the first element the minumum element
            temporary = presort.get(minIndx); 
            presort.set(i, temporary); //assigns a temporary variable have the original value preserved
            presort.set(minIndx, presort.get(i));
        }
    }
}
