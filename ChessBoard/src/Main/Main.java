package Main;

import cn.edu.stu.zzheng.Calculator.Calculator;
import cn.edu.stu.zzheng.chessboard.ChessBoard;
import cn.edu.stu.zzheng.chessboard.LimitGrid;
import cn.edu.stu.zzheng.chessboard.LimitPartOfChessBoard;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by neng-zheng on 2015/12/14.
 */
public class Main {

    public static void main(String[] arg0){
        HashSet<LimitGrid> limitGrids=new HashSet<LimitGrid>();
        //输入棋盘规格
        System.out.println("Please i4,4nput ChessBoard width and height (10,10)");
        Scanner scanner=new Scanner(System.in);
        String s0=scanner.nextLine();
        String[] ss=s0.split(",");
        //输入棋子个数
        System.out.println("Please input Chess numbers");
        String s1=scanner.nextLine();
        ChessBoard chessBoard =new ChessBoard(Integer.valueOf(ss[0]),Integer.valueOf(ss[1]),Integer.valueOf(s1));
        //输入禁区棋盘格（x,y）
        System.out.println("Please input LimitGrid (one grid a row : 1,3) input 'end' to end ");
        String s2;
        //输入end结束输入禁区棋盘格
        while(!(s2=scanner.nextLine()).equals("end")){
            String[] s2s=s2.split(",");
            LimitGrid limitGrid=new LimitGrid(Integer.valueOf(s2s[0]),Integer.valueOf(s2s[1]));
            limitGrids.add(limitGrid);
        }
        scanner.close();
        LimitPartOfChessBoard limitPartOfChessBoard=new LimitPartOfChessBoard(limitGrids);
        Calculator calculator=new Calculator(chessBoard,limitPartOfChessBoard);
        calculator.calculateRc();

    }
}
