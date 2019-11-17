package com.example.codbattleplanner;

/**
 * Created by Kevin Sandy
 * https://github.com/SpaceJunkee
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;




public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    //Variables
    private List<String> mapNamesArr;
    private List<String> mapImagesArr;
    private Context context;
    private OnElementListener OnElementListener;

    //Constructor
    public RecyclerViewAdapter(Context context, List<String> mapNamesArr, List<String> mapImagesArr, OnElementListener onElementListener) {
        this.mapNamesArr = mapNamesArr;
        this.mapImagesArr = mapImagesArr;
        this.context = context;
        this.OnElementListener = onElementListener;
    }

    @NonNull
    @Override
    //This method will inflate the view
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        //get view holder
        ViewHolder holder = new ViewHolder(view, OnElementListener);
        return holder;
    }

    @Override
    //Will get the items per each position in the list
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).asBitmap().load(mapImagesArr.get(position)).into(holder.mapImages);

        holder.mapNames.setText(mapNamesArr.get(position));

    }

    @Override
    //Tells the adapter how many list items are in the list
    public int getItemCount() {

        return mapNamesArr.size();
    }

    //Holds widgets in memory and recycles when necessary
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView mapImages;
        TextView mapNames;
        OnElementListener onElementListener;

        //user to attach onClickListener
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView, OnElementListener onElementListener) {
            super(itemView);
            //Find widget id's
             mapImages = itemView.findViewById(R.id.mapImage);
             mapNames = itemView.findViewById(R.id.mapName);
             parentLayout = itemView.findViewById(R.id.parentLayout);
             this.onElementListener = onElementListener;

             itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onElementListener.onElementClick(getAdapterPosition());
        }
    }

    public interface OnElementListener{
        void onElementClick(int position);

    }
}
