class Solution {
    public int[][] solution(int[][] arr) {
        int [][] result = addZero(arr);
        return result;
    }
    
    public int [][] addZero(int [][] arr) {
        int [][] result;
        int row = arr.length;
        int col = arr[0].length;
        
        if(row < col) {
            // row의 값을 늘려줄 것
            result = new int [col][col];
            
            for(int r = 0; r < col; r++) {
                for(int c = 0; c < col; c++) {
                    if(r >= row)
                        result[r][c] = 0;
                    else 
                        result[r][c] = arr[r][c];
                }    
            }
        }
        else if (row > col) {
            //col의 값을 늘려줄 것
            result = new int [row][row];

            for(int r = 0; r < row; r++) {
                for(int c = 0; c < row; c++) {
                    if(c >= col)
                        result[r][c] = 0;
                    else 
                        result[r][c] = arr[r][c];
                }    
            }
        }
        else
            return arr;
        
        return result;
    }
}