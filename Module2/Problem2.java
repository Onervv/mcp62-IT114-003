package Module2; // Important: the package corresponds to the folder it resides in
import java.util.Arrays;

// usage
// compile: javac Module2/Problem2.java
// run: java Module2.Problem2

public class Problem2 {
    public static void main(String[] args) {
        //Don't edit anything here
        double[] a1 = new double[]{10.001, 11.591, 0.011, 5.991, 16.121, 0.131, 100.981, 1.001};
        double[] a2 = new double[]{1.99, 1.99, 0.99, 1.99, 0.99, 1.99, 0.99, 0.99};
        double[] a3 = new double[]{0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01};
        double[] a4 = new double[]{10.01, -12.22, 0.23, 19.20, -5.13, 3.12};
        
        getTotal(a1);
        getTotal(a2);
        getTotal(a3);
        getTotal(a4);
    }
    static void getTotal(double[] arr){
        System.out.println("Processing Array:" + Arrays.toString(arr));
        double total = 0;

        //hint: use the arr variable; don't diretly use the a1-a4 variables
        // Goal 1: Sum all the values inside the passed in array
        // Goal 2: Ensure the resulting total is represented in currency format (without the $) (i.e., two decimal places always present)
        

        // Sum all the values inside the array
        for (double value : arr) {
            total += value;
        }

        

        // Convert the total to a string with two decimal places
        String totalString = String.format("%.2f", total);
        // Convert the fstring back to a double
        double formattedTotal = Double.parseDouble(totalString);
        // Convert the double back to a string
        String totalOutput = String.format("%.2f", formattedTotal);

        //end add/edit section
        System.out.println("Total is " + totalOutput);
        System.out.println("End process");
    }
    
}
