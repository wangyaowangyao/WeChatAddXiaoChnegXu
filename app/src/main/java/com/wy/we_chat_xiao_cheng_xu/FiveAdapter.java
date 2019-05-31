package com.wy.we_chat_xiao_cheng_xu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Author: WangYao
 * Date: 2019/3/20
 * QQ: 1484991675
 */
public class FiveAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Object> dataList = null;
    BoxStateListener boxStateListener = null;

    public List<Object> getDataList() {
        return dataList;
    }


    public FiveAdapter(List<Object> dataList, BoxStateListener boxStateListener) {
        this.dataList = dataList;
        this.boxStateListener = boxStateListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        int bottom_text_height = getItemBottomTextHeight();
        int item_width = getItemWidth();
        RelativeLayout.LayoutParams layoutParams = null;
        RecyclerView.ViewHolder viewHolder = null;
        ImageView imageView = null;
        View view = null;
        switch (viewType) {
            case 1:
                view = layoutInflater.inflate(R.layout.first_item_layout, parent, false);
                viewHolder = new FirstViewHolder(view);
                break;
            case 2:
                view = View.inflate(MyApplication.getInstance().getContext(), R.layout.five_item_layout, null);
                imageView = view.findViewById(R.id.image);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(getImageWidth(), getImageWidth()));
                layoutParams = new RelativeLayout.LayoutParams(item_width, getImageWidth() + bottom_text_height);
                view.setLayoutParams(layoutParams);
                viewHolder = new SecondViewHolder(view);
                break;
            case 3:
                view = View.inflate(MyApplication.getInstance().getContext(), R.layout.fourth_item_layout, null);
                imageView = view.findViewById(R.id.image);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(getImageWidth(), getImageWidth()));
                layoutParams = new RelativeLayout.LayoutParams(item_width, getImageWidth() + bottom_text_height);
                view.setLayoutParams(layoutParams);
                viewHolder = new SecondViewHolder(view);
                break;
            case 4:
                view = View.inflate(MyApplication.getInstance().getContext(), R.layout.second_item_layout, null);
                imageView = view.findViewById(R.id.image);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(getImageWidth(), getImageWidth()));
                layoutParams = new RelativeLayout.LayoutParams(item_width, getImageWidth() + bottom_text_height);
                view.setLayoutParams(layoutParams);
                viewHolder = new SecondViewHolder(view);
                break;
            case 5:
                view = layoutInflater.inflate(R.layout.third_item_layout, parent, false);
                viewHolder = new FirstViewHolder(view);
                break;

        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int empty_count = getEmptyCount();
        if (empty_count == 8) {
            boxStateListener.showBox();
        } else {
            boxStateListener.hideBox();
        }
        if (position != 0 && position != 9) {
            int item_type = getItemViewType(position);
            ContentBean object = (ContentBean) dataList.get(position);
            if (object.getName().equals("Empty")) {
                holder.itemView.setVisibility(View.INVISIBLE);
            } else {
                holder.itemView.setVisibility(View.VISIBLE);
                setData((SecondViewHolder) holder, item_type, (ContentBean) object);
            }

        }

    }

    private void setData(SecondViewHolder holder, int item_type, ContentBean object) {
        switch (item_type) {
            case 2:
                setName(holder, object);
                break;
            case 3:
                setName(holder, object);

                break;
            case 4:
                setName(holder, object);

                break;
        }
    }

    private void setName(SecondViewHolder holder, ContentBean object) {
        SecondViewHolder secondViewHolder = holder;
        ContentBean contentBean = object;
        secondViewHolder.name.setText(contentBean.getName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;

        } else if (position == 1) {
            return 2;

        } else if (position == 2) {
            return 3;

        } else if (position == 3) {
            return 3;

        } else if (position == 4) {
            return 4;

        } else if (position == 5) {
            return 2;

        } else if (position == 6) {
            return 3;

        } else if (position == 7) {
            return 3;

        } else if (position == 8) {
            return 4;

        } else if (position == 9) {
            return 5;

        } else if (position == 10) {
            return 2;

        } else if (position == 11) {
            return 3;

        } else if (position == 12) {
            return 3;

        } else if (position == 13) {
            return 4;

        } else if (position == 14) {
            return 2;

        } else if (position == 15) {
            return 3;

        } else if (position == 16) {
            return 3;

        } else if (position == 17) {
            return 4;

        } else if (position == 18) {
            return 2;

        } else if (position == 19) {
            return 3;

        } else if (position == 20) {
            return 3;

        } else if (position == 21) {
            return 4;

        } else if (position == 22) {
            return 2;

        } else if (position == 23) {
            return 3;

        } else if (position == 24) {
            return 3;

        } else if (position == 25) {
            return 4;

        } else {
            return 6;
        }

    }


    /**
     * 获取1到9的位置的数据有几个为空
     *
     * @return
     */
    public int getEmptyCount() {
        //true显示box,false隐藏box
        int empty_count = 0;

        for (int i = 1; i < 9; i++) {
            ContentBean contentBean= (ContentBean) dataList.get(i);
            if (contentBean.getName().equals("Empty") ) {
                empty_count++;
            }
        }
        return empty_count;
    }

    public float getSpace() {
        float space = MyApplication.getInstance().getContext().getResources().getDimension(R.dimen.dp_30);

        return space;
    }

    public int getItemWidth() {
        float screen_width = MyApplication.getInstance().getContext().getResources().getDisplayMetrics().widthPixels - getSpace();

        return (int) (screen_width / 4);
    }

    public int getItemBottomTextHeight() {
        float bottom_text_height = MyApplication.getInstance().getContext().getResources().getDimension(R.dimen.dp_111);

        return (int) bottom_text_height;
    }

    public int getImageWidth() {
        float space = MyApplication.getInstance().getContext().getResources().getDimension(R.dimen.dp_120);

        return (int) space;
    }
}
