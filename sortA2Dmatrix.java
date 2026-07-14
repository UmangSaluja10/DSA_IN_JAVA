class Solution {
    public int[][] sortMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Step 1: Flatten matrix into array
        int[] arr = new int[m * n];
        int idx = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[idx++] = matrix[i][j];
            }
        }

        // Step 2: Sort the array
        java.util.Arrays.sort(arr);

        // Step 3: Fill back into matrix
        idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = arr[idx++];
            }
        }

        return matrix;
    }
}