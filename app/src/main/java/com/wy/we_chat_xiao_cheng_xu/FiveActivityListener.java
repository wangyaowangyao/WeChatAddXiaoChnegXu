package com.wy.we_chat_xiao_cheng_xu;

/**
 * Author: WangYao
 * Date: 2019/3/20
 * QQ: 1484991675
 */
public interface FiveActivityListener {
    //开始拖动
    public void startDrag();


    //到达删除位置
    public void arriveDeleteLocation(int position);

    //到达添加位置
    public void arriveAddLocation(int position);

    //停止拖动
    public void stopDrag();

}