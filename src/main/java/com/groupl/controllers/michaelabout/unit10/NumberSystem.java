public class NumberSystem {

  /** Precondition: a and b are positive integers.

  * Returns the greatest common factor of a and b, as described in part (a).

  */

  public static void print(String out) {

    System.out.println(out);

  }

  public static String intToString(int any) {
    return Integer.toString(any);
  }

  public static int gcf(int a, int b) { 
    /* to be implemented in part (a) */ 
    int max = Math.max(a, b);
    for(; max > 0; max--) {
      if(a % max == 0 && b % max == 0) return max;
    }
    return 1;
  }

   

  /** Precondition: numerator and denominator are positive integers.

  * Reduces the fraction numerator / denominator

  * and prints the result, as described in part (b).

  */

  public static String reduceFraction(int numerator, int denominator) {
    /* to be implemented in part (b) */ 

    int i_gcf = gcf(numerator, denominator);
    
    String output;
    if(i_gcf == denominator) {
      output = intToString(numerator / denominator);
    } else {
      output = (numerator / i_gcf) + " / " + (denominator / i_gcf);
    }

    return numerator + " / " + denominator + 
           " reduced to " +
          output;
  }

  public static void main(String args[]) {

    print(reduceFraction(22, 2));
    print(reduceFraction(30, 3));
    print(reduceFraction(8, 20));
    print(reduceFraction(24, 9));
    print(reduceFraction(7, 3));

  }

}

