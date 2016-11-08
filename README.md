# Restaurant Satisfaction
# Problem Statement

Gordon Ramsey, a very smart guy, likes eating food. Now, Gordon is at a restaurant and he has many different types of food to choose from. Gordon gets x amount of satisfaction and requires y amount of time to eat an item from the menu. Given t minutes, write a java program that reads the text file and ﬁnds out the maximum satisfaction that Gordon can get from eating at the restaurant. You will be given a text file with the following format:

[t][Number of items on menu]

[amount of satisfaction from eating dish 1][time taken for dish 1]

[amount of satisfaction from dish 2][time taken for dish 2]

There is a file (data.txt) which contains a sample of data in this format and is used for this test.

#Steps

1. Read contents of file line-by-line into an ArrayList.

2. Get the first element of the ArrayList. This contains the 'Total Available Time' and 'Number of Items' values as a string. Split them and store them in separate variables. Remove this element from the ArrayList.

3. Iterate over the remaining elements of the ArrayList and split out the 'Satisfaction' and 'Time needed' values into two separate arrays.

4. Pass these two arrays into the method which finds out maximum satisfaction using the Knapsack algorithm.

Using the file (data.txt), the Maximum Achievable Satisfaction = 2493893
