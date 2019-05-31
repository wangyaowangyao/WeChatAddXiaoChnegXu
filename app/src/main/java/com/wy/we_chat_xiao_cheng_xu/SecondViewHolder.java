package com.wy.we_chat_xiao_cheng_xu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Author: WangYao
 * Date: 2019/3/20
 * QQ: 1484991675
 */
public class SecondViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView name;

    public SecondViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        name = itemView.findViewById(R.id.name);
    }
}