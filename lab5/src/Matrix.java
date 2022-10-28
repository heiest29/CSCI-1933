public class Matrix {
    private int nrows,ncols;
    private int[][] matrix;

    public Matrix(int nrows,int ncols){
        this.nrows = nrows;
        this.ncols = ncols;
        this.matrix = new int[nrows][ncols];
    }
    public Matrix(int[][] arr) {
        this.matrix = arr;
        this.nrows = arr.length;
        this.ncols = arr[0].length;
    }

//    public int getCols() {
//        return this.ncols;
//    }
//    public int getRows() {
//        return this.nrows;
//    }

    public Matrix transpose() {
        Matrix posermat = new Matrix(this.ncols,this.nrows);  // makes a matrix with the inverted size

        for (int i = 0; i<matrix.length; i++) {
            for (int j = 0; j<matrix[0].length; j++) {
                posermat.matrix[j][i] = this.matrix[i][j];
            }
        }
        return posermat;
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i<matrix.length; i++) {
            temp += "\n";
            for (int j = 0; j<matrix[0].length; j++) {
                temp += matrix[i][j] + "  ";
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},
                        {1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}};
        Matrix newmat = new Matrix(arr);
        System.out.println(newmat);
        System.out.println(newmat.transpose());
//        System.out.println(newmat.getCols());
//        System.out.println(newmat.getRows());

    }

}
