package cn.edu.stu.zzheng.chessboard;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by neng-zheng on 2015/12/14.
 */
public class LimitPartOfChessBoard {

    private HashSet limitGrids=new HashSet();

    public HashSet getLimitGrids() {
        return limitGrids;
    }

    public LimitPartOfChessBoard(HashSet limitGrids){
        this.limitGrids=limitGrids;
    }
    //取出禁区棋盘里的一个可用的棋盘格
    public LimitGrid getLimitGrid(){
        LimitGrid temp=null;
        Iterator<LimitGrid> it = limitGrids.iterator();
        if (it.hasNext()){
            temp=it.next();
        }
        return temp;
    }

//    //重设禁区棋盘的所有棋盘格为可用状态（即未被占据）
//    public void resetLimitGridAvailable(){
//        Iterator<LimitGrid> it=limitGrids.iterator();
//        while(it.hasNext()){
//            it.next().setAvailable(true);
//        }
//
//    }
    //copy禁区棋盘
    public LimitPartOfChessBoard copy(){
        LimitPartOfChessBoard temp=new LimitPartOfChessBoard((HashSet) limitGrids.clone());
        return temp;
    }
    //移除禁区棋盘的一个棋盘格
    public void removeLimitGrid(LimitGrid limitGrid){
        limitGrids.remove(limitGrid);
    }

    //当禁区棋盘的一个棋盘格被占据删除其和其同行同列的其余棋盘格
    public void occupyLimitGrid(LimitGrid limitGrid){

        removeLimitGrid(limitGrid);
        LimitGrid temp;
        Iterator<LimitGrid> it = limitGrids.iterator();
        HashSet limitGrids1=new HashSet();
        while(it.hasNext()){
            temp=it.next();
            if(temp.getX()==limitGrid.getX() || temp.getY()==limitGrid.getY()){
                limitGrids1.add(temp);
            }
        }
        Iterator<LimitGrid> it1 =limitGrids1.iterator();
        while(it1.hasNext()){
            removeLimitGrid(it1.next());
        }
    }
}
