package es.iessoterhernandez.endes;

public class fibonacci {
	 // Function to print N Fibonacci Number 
    public void Fibonacci(int N) 
    { 
        int num1 = 0, num2 = 1; 
  
        int counter = 0; 
  
        // Iterate till counter is N 
        while (counter < N) { 
  
            // Print the number 
            System.out.print(num1 + " "); 
  
            // Swap 
            int num3 = num2 + num1; 
            num1 = num2; 
            num2 = num3; 
            counter = counter + 1; 
        } 
    } 
 }