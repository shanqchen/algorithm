package exercise.algorithm.leetcode.array;

public class ToeplitzMatrix {

    public static boolean isToeplitzMatrix(int[][] matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        for(int i = 0; i < rows - 1; i++){
            for(int j = 0; j < columns - 1; j++){
                if(matrix[i][j] != matrix[i+1][j+1]){
                    return false;
                }
            }
        }
        return true;
    }
    
    //method2 HashMap https://leetcode.com/problems/toeplitz-matrix/solution/
    
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3,4}, {5,1,2,3}, {9,5,1,2}};
        int[][] matrix2 = {{1,2}, {2,2}};
        
        System.out.println(isToeplitzMatrix(matrix1));
        System.out.println(isToeplitzMatrix(matrix2));
    }
}
