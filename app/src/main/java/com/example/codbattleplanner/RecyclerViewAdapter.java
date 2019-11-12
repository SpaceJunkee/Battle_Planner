package com.example.codbattleplanner;

/**
 * Created by Kevin Sandy
 * https://github.com/SpaceJunkee
 */
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    //Variables
    private List<String> mapNamesArr;
    private List<String> mapImagesArr;
    private Context context;

    //Constructor
    public RecyclerViewAdapter(Context context, List<String> mapNamesArr, List<String> mapImagesArr) {
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
    //Will get the items per each position in the list
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).asBitmap().load(mapImagesArr.get(position)).into(holder.mapImages);

        holder.mapNames.setText(mapNamesArr.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Set up a new intent whenever an element is clicked in the recycler view list
                Intent intent = new Intent(context,EditMapImage.class);
                intent.putExtra("image_url", mapImagesArr.get(position));
                intent.putExtra("name_url", mapNamesArr.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    //Tells the adapter how many list items are in the list
    public int getItemCount() {

        return mapNamesArr.size();
    }

    //Holds widgets in memory and recycles when necessary
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView mapImages;
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
