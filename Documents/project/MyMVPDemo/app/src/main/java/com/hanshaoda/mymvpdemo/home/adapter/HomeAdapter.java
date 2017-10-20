package com.hanshaoda.mymvpdemo.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hanshaoda.mymvpdemo.R;

import java.util.List;

/**
 * author: hanshaoda
 * created on: 2017/10/19 下午4:21
 * description:
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyHolder> {

    private Context mContext;
    private List<String> mList;
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public HomeAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.tvName.setText(TextUtils.isEmpty(mList.get(position)) ? "出错了" : mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvName;

        public MyHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.onClickListener(getLayoutPosition());
            }
        }
    }
}
