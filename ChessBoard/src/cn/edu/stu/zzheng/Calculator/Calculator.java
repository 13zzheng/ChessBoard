package cn.edu.stu.zzheng.Calculator;

import cn.edu.stu.zzheng.chessboard.ChessBoard;
import cn.edu.stu.zzheng.chessboard.LimitGrid;
import cn.edu.stu.zzheng.chessboard.LimitPartOfChessBoard;

import java.util.Iterator;

/**
 * Created by neng-zheng on 2015/12/14.
 */
public class Calculator {

    private ChessBoard chessBoard;
    private LimitPartOfChessBoard limitChessBoard;
    private int methodNum;

    public Calculator(ChessBoard chessBoard,LimitPartOfChessBoard limitChessBoard){
        this.chessBoard=chessBoard;
        this.limitChessBoard=limitChessBoard;
    }

    //求阶乘
    public int jieCheng(int n){
        int k=1;
        for (int i=1;i<=n;i++){
            k=k*i;
        }
        return k;
    }

    //计算R（C）
    public void calculateRc(){
        int n=chessBoard.getNumChess(); //棋子总个数n
        int[] r=new int[n+1];
        r[0]=1;
        System.out.println("r0=1");
        for (int i=1;i<=n;i++){
            LimitPartOfChessBoard temp0=limitChessBoard.copy();
            calculateMethodNum(temp0,i);
            System.out.println("r" + i + "=" + methodNum);
            r[i]=methodNum;
            methodNum=0;
        }
        int rc=0;
        //输出R（C）结果
        System.out.print("R(C)=");
        for (int i=0;i<n+1;i++){
            if(i==n){
                System.out.println(r[i] + "x^" + i);
            }else {
                System.out.print(r[i]+"x^"+i+"+");
            }
        }
        System.out.print("result=");
        //输出最终方法数结果
        int method=0;
        for (int i=0;i<n+1;i++){
            method+=Math.pow(-1,i)*r[i]*jieCheng(n-i);
            if(i==0){
                System.out.print(n-i+"!");
            }else if(i%2==0){
                System.out.print("+"+r[i]+"("+n+"-"+i+")"+"!");
            }else {
                System.out.print("-"+r[i]+"("+n+"-"+i+")"+"!");
            }
        }
        System.out.println("="+method);



    }
    //计算n个棋子在禁区棋盘里的方法数
    public void calculateMethodNum(LimitPartOfChessBoard limitPartOfChessBoard,int n){
        if(n>=1){
            while(!(limitPartOfChessBoard.getLimitGrid()==null)){
                LimitPartOfChessBoard temp1=limitPartOfChessBoard.copy();
                if (n>1){
                    temp1.occupyLimitGrid(limitPartOfChessBoard.getLimitGrid());
                    calculateMethodNum(temp1,n-1);
                }
                limitPartOfChessBoard.removeLimitGrid(limitPartOfChessBoard.getLimitGrid());
                if (n==1){
                    methodNum++;
                }
            }
        }

    }



}
