package com.example.muslimquiz.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muslimquiz.R;
import com.example.muslimquiz.holder_activity.HadistSlide;
import com.example.muslimquiz.holder_activity.QuranSlide;
import com.example.muslimquiz.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>  {

    private Context context;
    private List<Category> categoryList;
    MediaPlayer player;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_category_home, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(categoryList.get(position));
        Category ct = categoryList.get(position);

        holder.bg_card.setImageResource(ct.getBg_card());
        holder.name_category.setText(ct.getName_category());
        holder.ct = ct;
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView bg_card;
        TextView name_category;
        TextView main;
        Category ct;

        public ViewHolder(View itemView) {
            super(itemView);
            bg_card = itemView.findViewById(R.id.iv_bg_card);
            name_category = itemView.findViewById(R.id.tv_name_category);
            main = itemView.findViewById(R.id.btn_main);

            main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playsound();
                    String name = ct.getName_category();
                    if (name.equals("Tafsir Quran")){
                        Intent intent = new Intent(context, QuranSlide.class);
                        intent.putExtra("Quran", ct.getName_category());
                        context.startActivity(intent);
                    }else if(name.equals("Tafsir Hadist")){
                        Intent intent = new Intent(context, HadistSlide.class);
                        intent.putExtra("Hadist", ct.getName_category());
                        context.startActivity(intent);
                    }
                }
            });

        }
    }

    public void playsound(){
        try{
            if(player.isPlaying()){
                player.stop();
                player.release();
            }
        }catch (Exception e){

        }
        player = MediaPlayer.create(context, R.raw.buttonclick);
        player.setLooping(false);
        player.start();
    }

}
