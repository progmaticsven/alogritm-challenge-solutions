public class RotateMatrix {

    public static int[][] rotateMatrix(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int n = 0; n < matrix.length ; n++){
                newMatrix[i][n] = matrix[matrix.length - n - 1][i];
            }
        }

        return  newMatrix;
    }


}
