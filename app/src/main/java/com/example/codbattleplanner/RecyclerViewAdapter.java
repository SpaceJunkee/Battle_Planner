package com.example.codbattleplanner;

/**
 * Created by Kevin Sandy
 * https://github.com/SpaceJunkee
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    //Variables
    private ArrayList<String> mapNamesArr = new ArrayList<String>();
    private ArrayList<String> mapImagesArr = new ArrayList<String>();
    private Context context;

    //Constructor
    public RecyclerViewAdapter(ArrayList<String> mapNamesArr, ArrayList<String> mapImagesArr, Context context) {
        this.mapNamesArr = mapNamesArr;
        this.mapImagesArr = mapImagesArr;
        this.context = context;
    }

    @NonNull
    @Override
    //This method will inflate the view
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        //get view holder
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    //Holds widgets in memory and recycles when necessary
    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView mapImages;
        TextView mapNames;

        //user to attach onClickListener
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Find widget id's
             mapImages = itemView.findViewById(R.id.mapImage);
             mapNames = itemView.findViewById(R.id.mapName);
             parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
