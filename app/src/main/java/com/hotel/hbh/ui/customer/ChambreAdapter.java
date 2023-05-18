package com.hotel.hbh.ui.customer;

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
import com.hotel.hbh.ui.DetailActivity;
import com.hotel.hbh.R;
import com.hotel.hbh.data.Chambre;
import com.hotel.hbh.ui.chambers.ChambreDouble;
import com.hotel.hbh.ui.chambers.ChambreSingle;
import com.hotel.hbh.ui.chambers.SuitJuniorDouble;
import com.hotel.hbh.ui.chambers.SuiteJuniorSingle;
import com.hotel.hbh.ui.chambers.SuiteSeniorDouble;
import com.hotel.hbh.ui.chambers.SuiteSeniorSingle;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ChambreAdapter extends RecyclerView.Adapter<ChambreAdapter.ViewHolder>{

    ArrayList<Chambre> items;
    DecimalFormat formatter;
    Context context;

    public ChambreAdapter(ArrayList<Chambre> items) {
        this.items = items;
        formatter=new DecimalFormat("###,###,###,###,##");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.chambre_viewholder,parent,false);
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
            Intent intent = new Intent(context, DetailActivity.class);
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
                        openActivity = new Intent(chambreimg.getContext(), ChambreSingle.class);

                    }
                    else
                    if(titleTxt.getText().toString().contains("chambre double"))
                    {
                        openActivity = new Intent(chambreimg.getContext(), ChambreDouble.class);

                    }
                    else
                    if(titleTxt.getText().toString().contains("junior single"))
                    {
                        openActivity = new Intent(chambreimg.getContext(), SuiteJuniorSingle.class);

                    }
                    else
                    if(titleTxt.getText().toString().contains("junior double"))
                    {
                        openActivity = new Intent(chambreimg.getContext(), SuitJuniorDouble.class);

                    }
                    else
                    if(titleTxt.getText().toString().contains("senior single"))
                    {
                        openActivity = new Intent(chambreimg.getContext(), SuiteSeniorSingle.class);

                    }else
                    if(titleTxt.getText().toString().contains("senior double"))
                    {
                        openActivity = new Intent(chambreimg.getContext(), SuiteSeniorDouble.class);

                    }





                    chambreimg.getContext().startActivity(openActivity);


                }
            });

        }
    }


}








