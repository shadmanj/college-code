/**
* Shadman Jubaer
* This program tests the hw9_matrix class for functionality.
*/

public class hw9_matrixTest{
	public static void main(String[] args){
		int[][] matrix1 = {{1,2},{3,4}};
		int[][] matrix2 = {{1,2},{3,4},{5,6,7},{8}};

		hw9_matrix m1 = new hw9_matrix(matrix1);
		hw9_matrix m2 = new hw9_matrix(matrix2);

		System.out.println("Sum matrix 1 = "+m1.sum());
		System.out.println("Sum matrix 2 = "+m2.sum());

	}
}