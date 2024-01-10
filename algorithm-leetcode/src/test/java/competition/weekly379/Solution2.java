package competition.weekly379;

/**
 * 100187. 捕获黑皇后需要的最少移动次数
 * https://leetcode.cn/problems/minimum-moves-to-capture-the-queen/description/
 * 对角线 abs == abs
 */
class Solution2 {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if (a == e) {
            if (c != e || d > Math.max(b,f) || d < Math.min(b, f)){
                return 1;
            }
            return 2;
        }

        if (b == f) {
            if (d != b || (c > Math.max(a, e) || c < Math.min(a, e))){
                return 1;
            }
            return 2;
        }

        if (isDiagonalWithoutPointsInBetween(c,d,e,f,a,b)) {
            return 1;
        }

        return 2;
    }
    public static boolean isDiagonalWithoutPointsInBetween(int x1, int y1, int x2, int y2, int x3, int y3) {
        int rowDiffAC = Math.abs(y2 - y1);
        int colDiffAC = Math.abs(x2 - x1);

        if (rowDiffAC == colDiffAC) {
            int startCol, endCol, startRow, endRow;

            if (x1 < x2) {
                startCol = x1 + 1;
                endCol = x2 - 1;
            } else {
                startCol = x2 + 1;
                endCol = x1 - 1;
            }

            if (y1 < y2) {
                startRow = y1 + 1;
                endRow = y2 - 1;
            } else {
                startRow = y2 + 1;
                endRow = y1 - 1;
            }

            for (int col = startCol, row = startRow; col <= endCol && row <= endRow; col++, row++) {
                    if (col == x3 && row == y3){
                        return false;
                    }
            }
            return true;
        }
        return false;
    }
}