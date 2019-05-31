package com.wy.we_chat_xiao_cheng_xu;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;

import java.util.List;

/**
 * Author: WangYao
 * Date: 2019/3/20
 * QQ: 1484991675
 */
public class FiveCallBack extends ItemTouchHelper.Callback {
    String TAG = "FiveCallBack";
    FiveActivityListener fiveActivityListener;
    List<Object> dataList = null;


    public void setFiveActivityListener(FiveActivityListener fiveActivityListener) {
        this.fiveActivityListener = fiveActivityListener;
    }


    public void setDataList(List<Object> dataList) {
        this.dataList = dataList;
    }


    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }

    //是否可以把拖动的ViewHolder拖动到目标ViewHolder之上
    @Override
    public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder current, RecyclerView.ViewHolder target) {

        return super.canDropOver(recyclerView, current, target);
    }

    //返回值决定是否有拖动操作
    @Override
    public boolean isLongPressDragEnabled() {

        return super.isLongPressDragEnabled();
    }

    //返回值决定是否有滑动操作
    @Override
    public boolean isItemViewSwipeEnabled() {
        return super.isItemViewSwipeEnabled();
    }

    @Override
    public int getBoundingBoxMargin() {

        return super.getBoundingBoxMargin();
    }

    //返回值滑动消失的距离, 这里是相对于RecycleView的宽度，0.5f表示为RecycleView的宽度的一半，取值为0~1f之间
    @Override
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        return super.getSwipeThreshold(viewHolder);
    }

    //返回值作为用户视为拖动的距离
    @Override
    public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {

        return super.getMoveThreshold(viewHolder);
    }

    //返回值滑动消失的距离，滑动小于这个值不消失，大于消失
    @Override
    public float getSwipeEscapeVelocity(float defaultValue) {

        return super.getSwipeEscapeVelocity(defaultValue);
    }

    //返回值作为滑动的流畅程度，越小越难滑动，越大越好滑动
    @Override
    public float getSwipeVelocityThreshold(float defaultValue) {

        return super.getSwipeVelocityThreshold(defaultValue);
    }

    //获取拖动
    @Override
    public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder selected, List<RecyclerView.ViewHolder> dropTargets, int curX, int curY) {

        return super.chooseDropTarget(selected, dropTargets, curX, curY);
    }

    //当拖动或者滑动的ViewHolder改变时调用
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        fiveActivityListener.startDrag();
        super.onSelectedChanged(viewHolder, actionState);
    }

    //当onMove return true的时候调用
    @Override
    public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int fromPos, RecyclerView.ViewHolder target, int toPos, int x, int y) {

        super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y);
    }

    //调用时与元素的用户交互已经结束，也就是它也完成了它的动画时候
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        try {
            fiveActivityListener.stopDrag();
        } catch (Exception e) {

        }
    }

    /**
     * @param c
     * @param recyclerView
     * @param viewHolder        当前移动的ViewHolder
     * @param dX                手指水平移动的距离
     * @param dY                手指垂直移动的距离
     * @param actionState
     * @param isCurrentlyActive 是否处于移动状态
     */
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        Log.e(TAG, "onChildDraw()--dY" + dY);
        int margin_top = (int) MyApplication.getInstance().getContext().getResources().getDimension(R.dimen.dp_165);
        int margin_top_and_content_height = (int) MyApplication.getInstance().getContext().getResources().getDimension(R.dimen.dp_635);
        int dp_225 = (int) MyApplication.getInstance().getContext().getResources().getDimension(R.dimen.dp_225);
        if (isCurrentlyActive == false) {
            if (viewHolder.itemView.getTop() - Math.abs(dY) > margin_top && viewHolder.itemView.getTop() - Math.abs(dY) < margin_top_and_content_height) {
                if (viewHolder.getAdapterPosition() > 0 && viewHolder.getAdapterPosition() < 9) {

                } else {

                    fiveActivityListener.arriveAddLocation(viewHolder.getAdapterPosition());
                }

            }
        }
        //获取距离底部的距离
        if (isCurrentlyActive == false) {
            if (dY >= (recyclerView.getHeight() - viewHolder.itemView.getBottom() - dp_225)) {
                //如果手指松开
                fiveActivityListener.arriveDeleteLocation(viewHolder.getAdapterPosition());
                //拖到删除处
                //在删除处放手，则删除item
                //先设置不可见，如果不设置的话，会看到viewHolder返回到原位置时才消失，因为remove会在viewHolder动画执行完成后才将viewHolder删除
                viewHolder.itemView.setVisibility(View.INVISIBLE);

            }
        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

    }

    @Override
    public void onChildDrawOver(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

        super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public long getAnimationDuration(RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
        return super.getAnimationDuration(recyclerView, animationType, animateDx, animateDy);
    }

    //当用户拖动一个视图出界的ItemTouchHelper调用
    @Override
    public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int viewSize, int viewSizeOutOfBounds, int totalSize, long msSinceStartScroll) {

        return super.interpolateOutOfBoundsScroll(recyclerView, viewSize, viewSizeOutOfBounds, totalSize, msSinceStartScroll);
    }

    //声明不同状态下可以移动的方向（idle, swiping, dragging）
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {

        //可以上下左右拖动
        final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        //禁止滑动
        final int swipeFlags = 0;
        return makeMovementFlags(dragFlags, swipeFlags);

    }


    //拖动的项目从旧位置移动到新位置时调用
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    //滑动到消失后的调用
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }
}
