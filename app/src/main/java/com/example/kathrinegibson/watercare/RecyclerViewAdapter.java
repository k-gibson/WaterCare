package com.example.kathrinegibson.watercare;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<Plant> itemList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Plant> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolders holder, final int position) {
        holder.plantName.setText(itemList.get(position).getName());
        holder.plantType.setText(itemList.get(position).getPlantType());
        holder.plantPhoto.setImageResource(itemList.get(position).getImagePath());
        holder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(context, holder.buttonViewOption);
                //inflating menu from xml resource
                popup.inflate(R.menu.plant_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu1:
                                Toast.makeText(context, "menu 1 clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu2:
                                Toast.makeText(context, "menu 2 clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu3:
                                Toast.makeText(context, "menu 3 clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu4:
                                int itemLabel = holder.getAdapterPosition();
                                itemList.remove(itemLabel);
                                notifyItemRemoved(itemLabel);
                                notifyItemRangeChanged(itemLabel,itemList.size());
                                Toast.makeText(context,"Removed : " + itemLabel, Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
