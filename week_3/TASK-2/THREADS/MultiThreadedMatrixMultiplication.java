class MatrixMultiplication implements Runnable {
    private final int[][] A, B, C;
    private final int row;
    
    public MatrixMultiplication(int[][] A, int[][] B, int[][] C, int row) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.row = row;
    }
    
    public void run() {
        for (int j = 0; j < B[0].length; j++) {
            C[row][j] = 0;
            for (int k = 0; k < A[0].length; k++) {
                C[row][j] += A[row][k] * B[k][j];
            }
        }
    }
}

public class MultiThreadedMatrixMultiplication {
    public static void main(String[] args) {
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};
        int[][] C = new int[2][2];
        
        Thread[] threads = new Thread[2];
        for (int i = 0; i < 2; i++) {
            threads[i] = new Thread(new MatrixMultiplication(A, B, C, i));
            threads[i].start();
        }
        
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        for (int[] row : C) {
            System.out.println(Arrays.toString(row));
        }
    }
}