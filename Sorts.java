
/**
 * Write a description of class isort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sorts
{
    enum ListType {Standard, Bubble, Insert, Selection};
    ListType listType = ListType.Standard;
    
    private int[] list;
    private int[] blist; int bcompares = 0; int bswaps = 0;
    private int[] ilist; int icompares = 0; int iswaps = 0;
    private int[] slist; int scompares = 0; int sSwaps = 0;
    /**
     * Constructor for objects of class isort
     */
    public Sorts()
    {
        int size = 50;
        list = new int[size];
        for (int i = 0; i < list.length; i++)
            list[i] = (int)(Math.random() * size) + 1;
            
        blist = list.clone();
        this.BubbleSort();
        ilist = list.clone();
        this.InsertionSort();
        slist = list.clone();
        this.SelectionSort();
    }
    
    public String toString() {
        int[] list;
        
        switch(listType) {
            case Standard:
                System.out.println("Original List");
                list = this.list;
                break;
            case Bubble:
                System.out.println("Bubble Sort -- "
                  + " Operations: " + (this.bcompares + this.bswaps)
                  + " Compares: " + this.bcompares
                  + " Swaps: " + this.bswaps);
                list = this.blist;
                break;
            case Insert:
            default:
                System.out.println("Insertions Sort -- "
                  + " Operations: " + (this.icompares + this.iswaps)
                  + " Compares: " + this.icompares
                  + " Swaps: " + this.iswaps);
                list = this.ilist;
            case Selection:
                System.out.println("Selection Sort -- "
                  + " Operations: " + (this.scompares + this.sSwaps)
                  + " Compares: " + this.scompares
                  + " Swaps: " + this.sSwaps);
                list = this.slist;
        }
                
        String output = "[";
        for (int i = 0; i < list.length; i++)
            output += " " + list[i];
        return output +" ]";    
    }
    
    private int[] BubbleSort() { 
        /* This is a simple method of sorting although it is very inefficient. 
         * It swaps two elements of the array in 
         * 
         * 
         */
        // iterate list, one less than length
        for (int i = 0; i < blist.length - 1; i++) {
            
            // bubble sort key logic
            for (int k = 1; k < blist.length - i; k++) {
                
                // analytics
                this.bcompares++; // compare counter
                
                // bubble sort swap logic
                if (blist[k-1] > blist[k]) {
                    int swap = blist[k];
                    blist[k] = blist[k-1];
                    blist[k-1] = swap;
               
                    // analytics
                    this.bswaps++; // swap counter
                }
            
            }
            
        }
        return blist;
    }

    
    private int[] InsertionSort() {
        /*Insertion sort works by parsing through the array and placing the lowest element first
         * It is similar to how we would sort cards in our hand by taking the lowest card and inserting it on top of the deck
         * This is more efficient than the bubble sort method as it doesn't have to go through two elements at a time, but it is 
         * less efficient than the Selection sort as it would have to continue iterating through the list to make the value correct
         */
        
        // iterate list, one less than length
        for (int i = 0; i < ilist.length - 1; i++) {
            
            // insertion sort key logic
            int k = i + 1;
            int swap = ilist[k];            
            while( k > 0 && swap < ilist[k-1]) {
                ilist[k] = ilist[k-1];
                k--;
                
                // analytics
                this.icompares++; // compare counter
                this.iswaps++; // shift counter
            }
            ilist[k] = swap;
            
            this.iswaps++;  // increment swap counter
            
        }
        
        return ilist;
    }
    
    private int[] SelectionSort() {
        /*Selection sort works by moving the minimum element in an array to the beginning
         * It changes the selection (subarray) to move the minimum to the beginning of the selection
         * Far more efficient than bubble sort because it is not looking at inidividual elements getting compared to each other
         */
        //declare integer for length
        int len = slist.length;
        
        //move the boundary of the unsorted subarry
        for (int i = 0; i < len-1; i++) {
            //find the minimjm element of the subarray
            int minIndx = i;
            for (int j = i + 1; j < len; j++) {
                if (slist[j] < slist[minIndx]){
                 minIndx = j;   
                }
            }
            //Make the first element the minumum element
            int temporary = slist[minIndx]; //assigns a temporary variable have the original value preserved
            slist[minIndx] = slist[i];
            slist[i] = temporary;
        }
        return slist;
    }

    /**
     *
     */
    public static void main(String[] args)
    {
        // Original List
        Sorts is = new Sorts();
        System.out.println(is);
        
        // Bubble Sort
        is.listType = ListType.Bubble;
        System.out.println(is);
        
        // Insertion Sort
        is.listType = ListType.Insert;
        System.out.println(is);
        
        //Selection Sort
        is.listType = ListType.Selection;
        System.out.println(is);
    }
}
