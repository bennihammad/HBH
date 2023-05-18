package com.hotel.hbh.ui.customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hotel.hbh.R;
import com.hotel.hbh.ui.Site;
import com.hotel.hbh.data.Chambre;

import java.util.ArrayList;

public class ChambersHome extends AppCompatActivity {
    private RecyclerView.Adapter adapterchambre, adaptersuite;
    private RecyclerView recyclerViewchambre, recyclerViewsuite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir);

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<Chambre> ItemsArraylist = new ArrayList<>();

        ItemsArraylist.add(new Chambre("chambre single", "BBA", "2bad", 2, 1, 9600, R.drawable.img_6, true));
        ItemsArraylist.add(new Chambre("chambre double", "BBA", "2bad", 2, 1, 134000, R.drawable.img_3, true));

        recyclerViewchambre = findViewById(R.id.viewchambres);
        recyclerViewchambre.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterchambre = new ChambreAdapter(ItemsArraylist);
        recyclerViewchambre.setAdapter(adapterchambre);


        ArrayList<Chambre> ItemsArraylist2 = new ArrayList<>();

        ItemsArraylist2.add(new Chambre("suite junior single", "BBA", "2bad", 2, 1, 13900,R.drawable.img_13, true));
        ItemsArraylist2.add(new Chambre("suite junior double ", "BBA", "2bad", 2, 1, 17400, R.drawable.img_13, true));
        ItemsArraylist2.add(new Chambre("suite senior single", "BBA", "2bad", 2, 1, 17000, R.drawable.img_13, true));
        ItemsArraylist2.add(new Chambre("suite senior double", "BBA", "2bad", 2, 1, 20800,R.drawable.img_13 , true));


        recyclerViewsuite = findViewById(R.id.viewsuites);
        recyclerViewsuite.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adaptersuite = new ChambreAdapter(ItemsArraylist2);
        recyclerViewsuite.setAdapter(adaptersuite);
    }
    public void openActivity1(View view){
        Intent openActivity = new Intent(this, Site.class);
        startActivity(openActivity);
    }



}


