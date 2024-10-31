//Shawn Ray
//Period 4
//Pascals_Triangle.java
// This program creates and later prints a jagged matrix
// that contains Pascal's Triangle.  Uses the
// fact that each value other than the 1's that appear at the
// beginning and end of each row is the sum of two values
// from the previous row.
import java.util.Arrays;

class Pascals_Triangle { //overhanging class to contain methods and main methods
	public static void main(String[] args) //main method where we will
	{
		//Make sure you are testing your method here
		//Print your Triangle here
		int[][] testMatrix = pascal(11); //creating a matrix for initial testing
		for (int i = 0; i < testMatrix.length; i++) { //these two loops iterate through the array, in row-column order
            for (int j = 0; j < testMatrix[i].length; j++) {
                System.out.print(testMatrix[i][j] + " "); //this is printing each value of the matrix with a space following it for the next value
            }
            System.out.println(); //adding a line after each column
        }
    }


	//Returns a jagged matrix that stores Pascal's Triangle
		//with the number of rows specified
	public static int[][] pascal(int rows) //function where the matrix is being made
	{
		int[][] pascalMatrix = new int[rows][]; //initializing a matrix with just the rows which are given as a parameter
		for (int i = 0; i < pascalMatrix.length; i++) { //iterating through the number of rows to set the columns and eventually the values
			pascalMatrix[i] = new int[i + 1]; //setting a given row with the correct number of columns, and in this case it should be one more than the actual row number since java is 0 index
            pascalMatrix[i][0] = 1; //the first element of each column is 1, that's a given with pascal's triangle. we're setting that here.
            pascalMatrix[i][i] = 1; //we want to preset the final value to 1
            for (int j = 1; j < i; j++) { //iterating until we reach the current value of the rows as we set the values for the actual individual elements of the matrix
            	pascalMatrix[i][j] = pascalMatrix[i - 1][j - 1] //we want the value at i rows and j columns to be the value at one row and one column before....
                    + pascalMatrix[i - 1][j]; //.... plus the value at the same column and 1 row before, that's just a rule with pascal's triangle
            }
        }
		return pascalMatrix; //returning the completed jaggeed matrix of the function
  	}
}




//Attempted Bonus - Reuleaux triangle
///*
// * Shawn Ray
// * Period 4
// * Pascals_Triangle.java
// * Creating and Printing a jagged matrix containing Pascal's triangle with the number of rows specified with an attempt to have the triangle print in the middle with centrally aligned numbers
// */
//import java.util.Arrays;
//
//public class Pascals_Triangle {
//    public static void main(String[] args) {
//        int rows = 8; // Specify the number of rows here
//        int[][] pascalTriangle = pascal(rows);
//
//        // Print the Pascal's Triangle
//        printPascalTriangle(pascalTriangle);
//    }
//
//    /**
//     * Returns a jagged matrix that stores Pascal's Triangle with the number of rows specified.
//     *
//     * The parameter "rows" represents the number of rows for the Pascal's Triangle to be printed
//     * To return: A jagged matrix representing Pascal's Triangle
//     */
//    public static int[][] pascal(int rows) {
//        int[][] pascalMatrix = new int[rows][];
//        
//        for (int x = 0; x < rows; x++) {
//            pascalMatrix[x] = new int[x + 1];
//        }
//        
//        for (int x = 0; x < rows; x++) {
//            for (int y = 0; y < pascalMatrix[x].length; y++) {
//                if (y == 0 || y == x) {
//                    pascalMatrix[x][y] = 1;
//                } else {
//                    pascalMatrix[x][y] = pascalMatrix[x - 1][y - 1] + pascalMatrix[x - 1][y];
//                }
//            }
//        }
//        
//        return pascalMatrix;
//    }
//
//    /**
//     * Prints the Pascal's Triangle with symmetrical central alignment.
//     *
//     * The parameter "triangle" is the jagged matrix representing Pascal's Triangle
//     */
//    public static void printPascalTriangle(int[][] triangle) {
//        // Calculate the maximum width of the triangle
//        int maxWidth = String.valueOf(triangle[triangle.length - 1][triangle[triangle.length - 1].length / 2]).length() * (triangle[triangle.length - 1].length);
//
//        for (int[] row : triangle) {
//            // Calculate the width of the current row
//            int rowWidth = 0;
//            for (int num : row) {
//                rowWidth += String.valueOf(num).length() + 1; // +1 for the space after each number
//            }
//
//            // Calculate the padding needed to center the current row
//            int padding = (maxWidth - rowWidth) / 2;
//
//            // Print the padding
//            for (int i = 0; i < padding; i++) {
//                System.out.print(" ");
//            }
//
//            // Print the numbers in the current row
//            for (int num : row) {
//                System.out.print(num + " ");
//            }
//
//            System.out.println();
//        }
//    }
//}