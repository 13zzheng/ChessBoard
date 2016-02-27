package cn.edu.stu.zzheng.chessboard;

/**
 * Created by neng-zheng on 2015/12/14.
 */
public class LimitGrid {
    private int x;
    private int y;
    private boolean available =true;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public LimitGrid(int x,int y){
        this.x=x;
        this.y=y;
    }
}
