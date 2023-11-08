/******************************************************************************

cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first 
and last element of that pair. 
For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

*******************************************************************************/

public class Main
{
    static class cons<T>{
        T first;
        T last;
        cons(T first,T last){
            this.first=first;
            this.last=last;
        }
        
        public T getFirst(){
            return this.first;
        }
        
        public T getLast(){
            return this.last;
        }
    }
    
    private static Object car(cons pair){
        return pair.getFirst();
    }
    
    private static Object cdr(cons pair){
        return pair.getLast();
    }

    public static void main(String[] args) {
	//call car - should give us first element
	System.out.println(car(new cons(1,2)));
	//call cdr - should give us last element
	System.out.println(cdr(new cons("a","b")));
   }
}
