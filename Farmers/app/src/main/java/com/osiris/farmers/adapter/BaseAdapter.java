package com.osiris.farmers.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.BaseViewHolder> {
    private List<T> datas;
    public OnItemClickListener onItemClickListener;
    private int maxNum = Integer.MAX_VALUE;
    private LayoutInflater inflater;
    private Activity activity;

    public BaseAdapter(Activity activity) {
        inflater = LayoutInflater.from(activity);
        this.activity = activity;
    }

    public abstract int getItemResId();

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
        notifyDataSetChanged();
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void setDatas(T[] datas) {
        if (this.datas == null) {
            this.datas = new ArrayList<>();
        }
        this.datas.clear();
        for (T data :
                datas) {
            this.datas.add(data);
        }
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public Activity getActivity() {
        return activity;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BaseViewHolder(inflater.inflate(getItemResId(), viewGroup, false));
    }

    public T getItem(int position) {
        return datas.get(position);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        onBindViewHolder(baseViewHolder, i, datas.get(i));
    }

    public void onBindViewHolder(BaseViewHolder viewHolder, int position, T item) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : (datas.size() > maxNum ? maxNum : datas.size());
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public static class BaseViewHolder extends RecyclerView.ViewHolder {

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public View getView(int resId) {
            return itemView.findViewById(resId);
        }


    }
}
