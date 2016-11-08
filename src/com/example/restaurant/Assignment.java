package com.example.restaurant;
import java.io.*;
import java.util.*;


//Class Assignment contains main() which reads data from data.txt and passes it to solve() to generate maximum satisfaction value
public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("data.txt"); //Open file		
		ArrayList<String> data = new ArrayList(); //empty arraylist
		
		try 
		{
		    Scanner scanner = new Scanner(file);
	        
	        while (scanner.hasNextLine()) 
	        {
                String line = scanner.nextLine(); //Read entries from file into ArrayList
                data.add(line);
                }
	        
	       //First element contains total available time and number of items
	       String first_element = data.get(0); 
	       
	       //Split out values into two different variables
	       int total_time = Integer.parseInt(first_element.split(" ")[0]);
	       int number_of_items = Integer.parseInt(first_element.split(" ")[1]);
	       
	       System.out.println("Total time = " + total_time);
	       System.out.println("Number of items = " + number_of_items);
	       
	       data.remove(0); //Remove first element as it's not needed in the ArrayList anymore
	       
	       //declare empty arrays each for values of satisfaction and time
	       int[] satisfaction = new int[number_of_items]; 
	       int[] time = new int[number_of_items];
	       
	       //Parse through data arraylist and filter out satisfaction and time into respective arrays
	       for (int i = 0; i < number_of_items; i++) 
	       {
	           satisfaction[i] = Integer.parseInt(data.get(i).split(" ")[0]);
	           time[i] = Integer.parseInt(data.get(i).split(" ")[1]);
	       }
	       
	       //Call solve method and pass in the parameters
	       System.out.println("Maximum achievable satisfaction = " + solve(total_time,time,satisfaction,number_of_items));
	       
        } 
		catch (IOException e) 
		{
            e.printStackTrace();
        }

	}
	
    // Returns the maximum value of satisfaction that can be attained in the time limit using Knapsack algorithm
    static int solve(int T, int time[], int satisfaction[], int n)
    {
    	
        int i, j;
        int K[][] = new int[n+1][T+1];
         
        //Use Knapsack algorithm
        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (j = 0; j <= T; j++)
            {
                if (i==0 || j==0)
                     K[i][j] = 0;
                else if (time[i-1] <= j)
                      K[i][j] = Math.max(satisfaction[i-1] + K[i-1][j-time[i-1]],  K[i-1][j]);
                else
                      K[i][j] = K[i-1][j];
            }
         }
         
         return K[n][T];// Return maximum value
     }
   
}
