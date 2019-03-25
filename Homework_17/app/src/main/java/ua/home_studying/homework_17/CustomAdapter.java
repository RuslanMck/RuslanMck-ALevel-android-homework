package ua.home_studying.homework_17;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ua.home_studying.homework_17.fighters.BaseFighter;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<BaseFighter> fighters;
    private Context context;

    public CustomAdapter(ArrayList<BaseFighter> fighters, Context context) {
        this.fighters = fighters;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        TextView health;
        TextView attack;
        TextView defence;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_description_image);
            name = itemView.findViewById(R.id.item_name_field);
            health = itemView.findViewById(R.id.item_hp_field);
            attack = itemView.findViewById(R.id.item_attack_field);
            defence = itemView.findViewById(R.id.item_defence_field);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fighter_short_descr, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Picasso.get().load(fighters.get(i).getImgLink()).into(viewHolder.imageView);
        viewHolder.name.setText(fighters.get(i).getName());
        viewHolder.attack.setText(String.valueOf(fighters.get(i).getAttack()));
        viewHolder.health.setText(String.valueOf(fighters.get(i).getHealth()));
        viewHolder.defence.setText(String.valueOf(fighters.get(i).getDefence()));

    }

    @Override
    public int getItemCount() {
        return fighters.size();
    }

}
