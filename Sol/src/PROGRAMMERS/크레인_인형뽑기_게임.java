package PROGRAMMERS;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by bangjinhyuk on 2022/04/17.
 */
public class 크레인_인형뽑기_게임 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
//        int[][] board = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};


        int answer = 0;

        Stack<Integer> stack = new Stack<>();


        for(int i = 0; i < moves.length ; i++ ){
            int tmp = moves[i]-1;
            for(int j = 0; j < board.length; j++){
                if(board[j][tmp]!=0){
                    System.out.println(board[j][tmp]);
                    if(stack.size()>0 && stack.peek()== board[j][tmp]) {
                        stack.pop();
                        answer+=2;
                        board[j][tmp] =0;
                    }else{
                        stack.push(board[j][tmp]);
                    }
                    board[j][tmp] =0;
                    break;
                }
            }
        }
        System.out.println(answer);

    }
}
