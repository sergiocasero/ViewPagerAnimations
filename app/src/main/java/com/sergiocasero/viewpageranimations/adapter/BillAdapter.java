package com.sergiocasero.viewpageranimations.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sergiocasero.viewpageranimations.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sergiocasero on 17/3/16.
 */
public class BillAdapter extends RecyclerView.Adapter<BillAdapter.BillViewHolder> {

    private List<String> items;

    private OnItemClickListener onItemClickListener;

    private OnLongItemClickListener onLongItemClickListener;


    public BillAdapter(List<String> items) {
        this.items = items;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnLongItemClickListener(OnLongItemClickListener onLongItemClickListener) {
        this.onLongItemClickListener = onLongItemClickListener;
    }

    @Override
    public BillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // TODO: 17/3/16 change fragment_one by your layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_one, parent, false);
        return new BillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BillViewHolder holder, int position) {
        String item = items.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class BillViewHolder extends RecyclerView.ViewHolder {

        // TODO: 17/3/16 change this
        @Bind(R.id.fragment1_container)
        LinearLayout container;

        public BillViewHolder(final View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemPosition = getAdapterPosition();
                    onItemClickListener.onClick(itemPosition, items.get(itemPosition));
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int itemPosition = getAdapterPosition();
                    onLongItemClickListener.onLongClick(itemPosition, items.get(itemPosition), container);
                    return false;
                }
            });
        }

        public void bind(String item) {
            //do something...
        }
    }

    public interface OnItemClickListener {
        void onClick(int position, String item);
    }

    public interface OnLongItemClickListener {
        void onLongClick(int position, String item, LinearLayout containerView);
    }
}
