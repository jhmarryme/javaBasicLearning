package chapter3;

/**
 *“之”字形打印矩阵
 * 给定一个矩阵matrix，按照“之”字形的方式打印这 个矩阵，
 * 例如： 1   2   3   4 5   6   7   8 9  10  11  12 “之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11， 8，12
 * 【要求】 额外空间复杂度为O(1)
 * @author jhmarryme.cn
 * @date 2019/7/29 10:29
 */
public class Code_08_ZigZagPrintMatrix {


    public static void printMatrixZigZag(int[][] matrix){
        // 起始坐标a(0, 0) b(0, 0)
        int row1 = 0, col1 = 0, row2 = 0, col2 = 0;

        //行列最大边界值
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;

        //转向标记位
        boolean fromUp = false;

        while(row1 <= rowEnd){
            printLevel(matrix, row1, col1, row2, col2, fromUp);
            //这里的顺序很重要 a坐标 先往右走, 走到边界再往下, b先往下走, 走到边界在往右. 两个坐标同时运动, 形成一条对角线
            // a坐标一定要先移动row, 因为是根据col作为判断条件的
            // a向右移动时, 即将到达边界时, 此时如果col先动, col就会等于colEnd, 此时a会判断出再加一, 就会跳过一个点
            row1 = (col1 == colEnd) ? row1 + 1 : row1;
            col1 = (col1 < colEnd) ? col1 + 1 : col1;
            // b坐标一定要先移动col, 理由同上
            col2 = (row2 == rowEnd) ? col2 + 1 : col2;
            row2 = (row2 < rowEnd) ? row2 + 1 : row2;
            fromUp = !fromUp;
        }
    }

    /**
     * 沿着对角线打印, 标记位控制方向
     * @param matrix
     * @param row1
     * @param col1
     * @param row2
     * @param col2
     * @param fromUp
     */
    private static void printLevel(int[][] matrix, int row1, int col1, int row2, int col2, boolean fromUp) {
        if (fromUp){
            while(row1 <= row2 && col1 >= col2){
                System.out.print(matrix[row1++][col1--] + ",");
            }
        } else {
            while(row2 >= row1 && col2 <= col1){
                System.out.print(matrix[row2--][col2++] + ",");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrixZigZag(matrix);
    }
}
