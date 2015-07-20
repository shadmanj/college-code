/**
* Shadman Jubaer
* This class creates an nxm matrix of integers and takes the sum of all the
* elements in the matrix.
*/

public class hw9_matrix{

	private int[][] matrix;

	public hw9_matrix(int[][] matrixIn){
		this.matrix = matrixIn;
	}

	public int sum(){
		int sum = 0;
		for (int i = 0; i < matrix.length;i++){
			for (int j = 0; j < matrix[i].length; j++){
				sum += matrix[i][j];
			}
		}
		return sum;
	}
}