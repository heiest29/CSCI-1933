public class Arr {

    public static double[][] add2DArray(double[][] arr1, double[][] arr2) {
        if (arr1.length == arr2.length && arr1[0].length == arr2[0].length) {
            double[][] newdubs = new double[arr1.length][arr1[0].length];
            for (int i = 0; i<arr1.length;i++) {
                for (int j = 0; j<arr1[0].length;j++) {
                    newdubs[i][j] = arr1[i][j] + arr2[i][j];
                }
            }
            return newdubs;
        }
        else {
            return arr1;
        }
    }

}
