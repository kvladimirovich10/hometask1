public class Task_5 {    public static void main(String[] args) {        int dim = 11;        int[][] matrix = new int[dim][dim];        for (int i = 0 ; i < dim ; i++) {            for (int j = 0 ; j < dim ; j++) {                if (i == j || i == dim - j - 1)                    matrix[i][j] = 1;                else                    matrix[i][j] = 0;            }        }        print_matrix(matrix);    }    static void print_matrix(int[][] matrix) {        for (int i = 0 ; i < matrix.length ; i++) {            for (int j = 0 ; j < matrix[0].length ; j++) {                System.out.format("%d ", matrix[i][j]);            }            System.out.println();        }    }}