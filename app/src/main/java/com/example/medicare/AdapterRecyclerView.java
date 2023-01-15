package com.example.medicare;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    private ArrayList<ItemModel> dataItem;
    private final Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {

        // Inisialisasi
        TextView textHead;
        TextView textSubhead;
        ImageView imageMed;
        LinearLayoutCompat parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textHead = itemView.findViewById(R.id.text_title);
            textSubhead = itemView.findViewById(R.id.text_subtitle);
            imageMed = itemView.findViewById(R.id.imageList);
            parentLayout = itemView.findViewById(R.id.paretLayout);
        }
    }

    AdapterRecyclerView(Context context, ArrayList<ItemModel> dataItem){
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView textHead = holder.textHead;
        TextView textSubhead = holder.textSubhead;
        ImageView imageMed = holder.imageMed;

        textHead.setText(dataItem.get(position).getName());
        textSubhead.setText(dataItem.get(position).getDesc());
        imageMed.setImageResource(dataItem.get(position).getImage());

        holder.parentLayout.setOnClickListener(v -> {
            Toast.makeText(context, dataItem.get(position).getName(), Toast.LENGTH_SHORT).show();

            //Intent tiap Obat
            if (dataItem.get(position).getName().equals("Paracetamol")){
                context.startActivity(new Intent(context, ActivityMedParacetamol.class));
            }

            if (dataItem.get(position).getName().equals("Ambroxol")){
                context.startActivity(new Intent(context, ActivityMedAmbroxol.class));
            }

            if (dataItem.get(position).getName().equals("Antangin")){
                context.startActivity(new Intent(context, ActivityMedAntangin.class));
            }

            if (dataItem.get(position).getName().equals("Fitkom")){
                context.startActivity(new Intent(context, ActivityMedFitkom.class));
            }

            if (dataItem.get(position).getName().equals("Konidin")){
                context.startActivity(new Intent(context, ActivityMedKonidin.class));
            }

            if (dataItem.get(position).getName().equals("Scott's")){
                context.startActivity(new Intent(context, ActivityMedScotts.class));
            }

            if (dataItem.get(position).getName().equals("Cefixime")){
                context.startActivity(new Intent(context, ActivityMedCefixime.class));
            }

            if (dataItem.get(position).getName().equals("Alpara")){
                context.startActivity(new Intent(context, ActivityMedAlpara.class));
            }

            if (dataItem.get(position).getName().equals("Plantacid")){
                context.startActivity(new Intent(context, ActivityMedPlantacid.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

    void setFilter(ArrayList<ItemModel> filterModel){
        dataItem = new ArrayList<>();
        dataItem.addAll(filterModel);
        notifyDataSetChanged();
    }

}
