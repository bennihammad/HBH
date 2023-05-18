package com.hotel.hbh;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder>{

    ArrayList<itemsDomain> items;
    DecimalFormat formatter;
    Context context;

    public ItemsAdapter(ArrayList<itemsDomain> items) {
        this.items = items;
        formatter=new DecimalFormat("###,###,###,###,##");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewholder,parent,false);
        context=parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.addressTxt.setText(items.get(position).getAddress());
        holder.priceTxt.setText("$"+formatter.format(items.get(position).getPrice()));

        int drawbleResourceId=items.get(position).getPic();
        Glide.with(holder.itemView.getContext())
                .load(drawbleResourceId)
                .into(holder.chambreimg);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context,DetailActivity.class);
            intent.putExtra("object",items.get(position));
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt,addressTxt,priceTxt;
        ImageView chambreimg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt=itemView.findViewById(R.id.titleTxt);
            addressTxt=itemView.findViewById(R.id.addressTxt);
            priceTxt=itemView.findViewById(R.id.priceTxt);
            chambreimg =itemView.findViewById(R.id.chambredouble);
            chambreimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent openActivity = null;
                    if(titleTxt.getText().toString().contains("chambre single"))
                    {
                        openActivity = new Intent(chambreimg.getContext(),chambre_single.class);

                    }
                    else
                    if(titleTxt.getText().toString().contains("chambre double"))
                    {
                        openActivity = new Intent(chambreimg.getContext(),chambre_double.class);

                    }
                    else
                    if(titleTxt.getText().toString().contains("junior single"))
                    {
                        openActivity = new Intent(chambreimg.getContext(),suite_junior_single.class);

                    }
                    else
                    if(titleTxt.getText().toString().contains("junior double"))
                    {
                        openActivity = new Intent(chambreimg.getContext(),suite_junior_double.class);

                    }
                    else
                    if(titleTxt.getText().toString().contains("senior single"))
                    {
                        openActivity = new Intent(chambreimg.getContext(),suite_senior_single.class);

                    }else
                    if(titleTxt.getText().toString().contains("senior double"))
                    {
                        openActivity = new Intent(chambreimg.getContext(),suite_senior_double.class);

                    }





                    chambreimg.getContext().startActivity(openActivity);


                }
            });

        }
    }


}








