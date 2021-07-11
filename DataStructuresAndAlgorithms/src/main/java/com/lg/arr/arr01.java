package com.lg.arr;

import java.util.HashSet;
import java.util.Set;

public class arr01 {
    public static void main(String[] args) {
        char[][] board = {{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board)  {
        Boolean flag = true;
        //判断行
        for (int i = 0; i < 9; i++) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.' && !set1.add(Integer.valueOf(String.valueOf(board[i][j])))){
                    flag = false;
                    System.out.println("同一行有相同数字："+"第"+i+"行，第"+j+"列,存在重复数字"+String.valueOf(board[i][j]));
                }
                if(board[j][i] != '.' && !set2.add(Integer.valueOf(String.valueOf(board[j][i])))){
                    flag = false;
                    System.out.println("同一列有相同数字："+"第"+j+"行，第"+i+"列,存在重复数字"+String.valueOf(board[j][i]));
                }
                if(i%3 == 0 && j%3 == 0){
                    Set<Integer> set3 = new HashSet<>();
                    for (int k = i; k <= i+2; k++) {
                        for(int l = j; l <= j+2; l++){
                            if(board[k][l] != '.' && !set3.add(Integer.valueOf(String.valueOf(board[k][l])))){
                                flag = false;
                                System.out.println("同一九宫格有相同数字："+"第"+k+"行，第"+l+"列,存在重复数字"+String.valueOf(board[k][l]));
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }
}
