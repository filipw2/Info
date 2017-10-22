package com.example.filip.info.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.filip.info.R;
import com.example.filip.info.coin.Coins;

import java.util.List;

/**
 * Created by Filip on 2017-07-20.
 */

public class CoinsAdapter extends RecyclerView.Adapter<CoinsAdapter.ViewHolder> {

    private List<Coins> mCoins;
    private Context mContext;

    public CoinsAdapter(List<Coins> mCoins, Context mContext) {
        this.mCoins = mCoins;
        this.mContext = mContext;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setCoins(List<Coins> coins) {
        mCoins = coins;
    }

    @Override
    public CoinsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View coinView = inflater.inflate(R.layout.item_coin, parent, false);

        ViewHolder viewHolder = new ViewHolder(coinView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CoinsAdapter.ViewHolder holder, int position) {
        Coins coin = mCoins.get(position);

        TextView textView = holder.nameTextView;
        textView.setText(coin.getName());
        textView = holder.symbolTextView;
        textView.setText(coin.getSymbol());
        textView = holder.priceTextView;
        textView.setText(coin.getPrice_usd().toString() + "$");
    }

    @Override
    public int getItemCount() {
        return mCoins.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public TextView symbolTextView;
        public TextView priceTextView;


        public ViewHolder(View view) {
            super(view);

            nameTextView = view.findViewById(R.id.coin_name);
            symbolTextView = view.findViewById(R.id.coin_symbol);
            priceTextView = view.findViewById(R.id.coin_price);
        }
    }
}
