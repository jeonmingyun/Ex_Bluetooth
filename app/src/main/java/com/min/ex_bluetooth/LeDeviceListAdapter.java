package com.min.ex_bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LeDeviceListAdapter extends RecyclerView.Adapter<LeDeviceListAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<BluetoothDevice> itemList;

    public LeDeviceListAdapter(Context mContext, ArrayList<BluetoothDevice> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_device_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BluetoothDevice item = itemList.get(position);

        holder.itemName.setText(item.getName());
        holder.itemAddr.setText(item.getAddress());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemName, itemAddr;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.item_name);
            itemAddr = itemView.findViewById(R.id.item_addr);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Log.e("dfdfd", "dfdfdf");
//                }
//            });
        }
    }

    public void addItem(BluetoothDevice device) {
        /*기기 중복 검색 확인*/
        if(!itemList.contains(device)) {
            this.itemList.add(device);
        }
        notifyDataSetChanged();
    }

    public void clearItemList() {
        itemList.clear();
        notifyDataSetChanged();
    }

    public ArrayList<BluetoothDevice> getItemList() {
        return itemList;
    }
}
