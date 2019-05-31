package com.wy.we_chat_xiao_cheng_xu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: WangYao
 * Date: 2019/3/20
 * QQ: 1484991675
 */
public class FiveActivity extends AppCompatActivity implements FiveActivityListener, BoxStateListener {
    String TAG = "FiveActivity";
    RecyclerView content_recycler_view;
    List<Object> objectList = new ArrayList<>();
    FiveAdapter fiveAdapter;
    TextView bottom_hint_text;
    TextView box;
    ContentBean firstContentBean = new ContentBean("0");
    List<ContentBean> topList = new ArrayList<>();
    ContentBean secondContentBean = new ContentBean("9");
    List<ContentBean> bottomList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_activity);
        box = findViewById(R.id.box);
        bottom_hint_text = findViewById(R.id.bottom_hint_text);
        content_recycler_view = findViewById(R.id.content_recycler_view);
        objectList = getData();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 4;
                } else if (position == 9) {
                    return 4;

                } else {
                    return 1;
                }
            }
        });
        content_recycler_view.setLayoutManager(gridLayoutManager);
        fiveAdapter = new FiveAdapter(objectList, this);
        content_recycler_view.setAdapter(fiveAdapter);
        FiveCallBack fiveCallBack = new FiveCallBack();
        fiveCallBack.setDataList(objectList);
        fiveCallBack.setFiveActivityListener(this);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(fiveCallBack);
        itemTouchHelper.attachToRecyclerView(content_recycler_view);
        content_recycler_view.addOnItemTouchListener(new OnRecyclerItemClickListener(content_recycler_view) {

            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {

            }

            @Override
            public void onItemLongClick(RecyclerView.ViewHolder vh) {
                //如果item不是第一个，则执行拖拽
                if (vh.getAdapterPosition() == 0 || vh.getAdapterPosition() == 9) {

                } else {
                    itemTouchHelper.startDrag(vh);
                }
            }
        });
    }

    @NonNull
    private List<Object> getData() {
        for (int i = 1; i < 9; i++) {
            topList.add(new ContentBean(i + ""));
        }
        for (int i = 10; i < 26; i++) {
            bottomList.add(new ContentBean(i + ""));

        }
        objectList.add(firstContentBean);
        objectList.addAll(topList);
        objectList.add(secondContentBean);
        objectList.addAll(bottomList);
        return objectList;
    }

    boolean drag_state = false;
    int drag_position = 0;

    @Override
    public void startDrag() {
        drag_state = true;
        bottom_hint_text.setVisibility(View.VISIBLE);
    }

    int delete_data_position;
    List<Object> list = new ArrayList<>();

    @Override
    public void arriveDeleteLocation(int position) {
        if (position > 0 && position < 9) {
            Log.e(TAG, "arriveDeleteLocation" + position);
            topList.remove(position - 1);
            topList.add(new ContentBean("Empty"));
            objectList.clear();
            objectList.add(firstContentBean);
            objectList.addAll(topList);
            objectList.add(secondContentBean);
            objectList.addAll(bottomList);
            fiveAdapter.notifyDataSetChanged();
        } else {
            Log.e(TAG, "arriveDeleteLocation" + position);

            bottomList.remove(position - 10);
            bottomList.add(new ContentBean("Empty"));
            objectList.clear();
            objectList.add(firstContentBean);
            objectList.addAll(topList);
            objectList.add(secondContentBean);
            objectList.addAll(bottomList);
            fiveAdapter.notifyDataSetChanged();
        }

    }

    Toast toast = null;

    @Override
    public void arriveAddLocation(int position) {
        ContentBean contentBean = (ContentBean) fiveAdapter.getDataList().get(position);
        if (topList.get(0).getName().equals("Empty")) {
            topList.set(0, contentBean);
            objectList.clear();
            objectList.add(firstContentBean);
            objectList.addAll(topList);
            objectList.add(secondContentBean);
            objectList.addAll(bottomList);
            fiveAdapter.notifyDataSetChanged();
        } else if (topList.get(1).getName().equals("Empty")) {
            topList.set(1, contentBean);
            objectList.clear();
            objectList.add(firstContentBean);
            objectList.addAll(topList);
            objectList.add(secondContentBean);
            objectList.addAll(bottomList);
            fiveAdapter.notifyDataSetChanged();
        } else if (topList.get(2).getName().equals("Empty")) {
            topList.set(2, contentBean);
            objectList.clear();
            objectList.add(firstContentBean);
            objectList.addAll(topList);
            objectList.add(secondContentBean);
            objectList.addAll(bottomList);
            fiveAdapter.notifyDataSetChanged();


        } else if (topList.get(3).getName().equals("Empty")) {
            topList.set(3, contentBean);
            objectList.clear();
            objectList.add(firstContentBean);
            objectList.addAll(topList);
            objectList.add(secondContentBean);
            objectList.addAll(bottomList);
            fiveAdapter.notifyDataSetChanged();

        } else if (topList.get(4).getName().equals("Empty")) {
            topList.set(4, contentBean);
            objectList.clear();
            objectList.add(firstContentBean);
            objectList.addAll(topList);
            objectList.add(secondContentBean);
            objectList.addAll(bottomList);
            fiveAdapter.notifyDataSetChanged();


        } else if (topList.get(5).getName().equals("Empty")) {
            topList.set(5, contentBean);
            objectList.clear();
            objectList.add(firstContentBean);
            objectList.addAll(topList);
            objectList.add(secondContentBean);
            objectList.addAll(bottomList);
            fiveAdapter.notifyDataSetChanged();

        } else if (topList.get(6).getName().equals("Empty")) {
            topList.set(6, contentBean);
            objectList.clear();
            objectList.add(firstContentBean);
            objectList.addAll(topList);
            objectList.add(secondContentBean);
            objectList.addAll(bottomList);
            fiveAdapter.notifyDataSetChanged();


        } else if (topList.get(7).getName().equals("Empty")) {

            topList.set(7, contentBean);
            objectList.clear();
            objectList.add(firstContentBean);
            objectList.addAll(topList);
            objectList.add(secondContentBean);
            objectList.addAll(bottomList);
            fiveAdapter.notifyDataSetChanged();

        } else {
            if (toast == null) {
                toast = Toast.makeText(MyApplication.getInstance().getContext(), "请先删除一个我的设备", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    @Override
    public void stopDrag() {

        drag_state = false;
        bottom_hint_text.setVisibility(View.GONE);
    }


    @Override
    public void showBox() {
        box.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideBox() {

        box.setVisibility(View.INVISIBLE);
    }
}
