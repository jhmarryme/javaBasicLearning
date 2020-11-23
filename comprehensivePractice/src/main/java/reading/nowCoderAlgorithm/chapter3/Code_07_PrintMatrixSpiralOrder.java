package reading.nowCoderAlgorithm.chapter3;

/**
 * 转圈打印矩阵
 * 【题目】 给定一个整型矩阵matrix，请按照转圈的方式打印它。
 * 例如： 1   2   3   4 5   6   7   8 9  10  11  12 13 14  15  16 打印结果为：1，2，3，4，8，12，16，15，14，13，9， 5，6，7，11， 10
 * 【要求】 额外空间复杂度为O(1)
 * @author jhmarryme.cn
 * @date 2019/7/29 11:16
 */
public class Code_07_PrintMatrixSpiralOrder {


    public static void printMatrixSpiralOrder(int[][] matrix){

        // 初始化坐标, a, b 为左上和右下的点, 形成对角线.
        int row1 = 0, col1 = 0;
        int row2 = matrix.length - 1, col2 = matrix[0].length - 1;

        // 打印后移动到下一条对角线
        while(row1 <= row2 && col1 <= col2){
            printMatrix(matrix, row1++, col1++, row2--, col2--);
        }
    }

    private static void printMatrix(int[][] matrix, int row1, int col1, int row2, int col2) {

        int rowEnd = row1;
        int colEnd = col1;
        //向右移动
        while(col1< col2){
            System.out.print(matrix[row1][col1++] + " ,");
        }
        //向下移动
        while(row1 < row2){
            System.out.print(matrix[row1++][col1] + " ,");
        }
        //向左移动
        while(col1 > colEnd){
            System.out.print(matrix[row1][col1--] + " ,");
        }
        //向上移动
        while(row1 > rowEnd){
            System.out.print(matrix[row1--][col1] + " ,");
        }

    }


    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4, 5 }, {  6, 7, 8, 9, 10 }, {11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 }, {21, 22, 23, 24, 25} };
        printMatrixSpiralOrder(matrix);
    }
}
