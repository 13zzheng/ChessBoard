package cn.edu.stu.zzheng.chessboard;

/**
 * Created by neng-zheng on 2015/12/14.
 */
public class ChessBoard {

    private int width;
    private int height;
    private int numChess;

    public int getWidth() {
        return width;
    }

    public int getNumChess() {
        return numChess;
    }

    public int getHeight() {
        return height;
    }

    public ChessBoard(int width,int height,int numChess){
        this.width=width;
        this.height=height;
        this.numChess=numChess;
    }
}
