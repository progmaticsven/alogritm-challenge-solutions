public class ZeroMatrix {
    public static int[][] zeroWhenCellIsZero(int[][] matrix){

        int rowCount = matrix.length;
        boolean[] zeroRowIndexes =  new boolean[rowCount];
        int columnCount = matrix[0].length;
        boolean[] zeroColumnIndexes =  new boolean[columnCount];

        for(int row = 0; row < zeroRowIndexes.length; row++){
            for(int col = 0; col < zeroColumnIndexes.length; col++){
                if(matrix[row][col] == 0){
                    zeroColumnIndexes[col] = true;
                    zeroRowIndexes[col] = true;
                    break;
                };

            }
        }

        for(int row = 0; row < rowCount; row++){
            for(int col = 0; col < columnCount; col++){
                if(zeroColumnIndexes[col] || zeroRowIndexes[row]){
                    matrix[row][col] = 0;
                }
            }
        }

        return matrix;

    }
}
