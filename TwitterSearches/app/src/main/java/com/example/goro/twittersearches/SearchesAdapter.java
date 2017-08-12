package com.example.goro.twittersearches;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Goro on 13.08.2017.
 */

public class SearchesAdapter extends RecyclerView.Adapter<SearchesAdapter.ViewHolder> {
    private final View.OnClickListener clickListener;
    private final View.OnLongClickListener longClickListener;
    private final List<String> tags;

    public SearchesAdapter(List<String> tags, View.OnClickListener clickListener, View.OnLongClickListener longClickListener) {
        this.tags = tags;
        this.clickListener = clickListener;
        this.longClickListener = longClickListener;


    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return (new ViewHolder(view, clickListener, longClickListener));
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(tags.get(position));
    }

    public int getItemCount() {
        return tags.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView textView;

        public ViewHolder(View itemView, View.OnClickListener onClickListener, View.OnLongClickListener longClickListener) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(onClickListener);
            itemView.setOnLongClickListener(longClickListener);
        }

    }
}
