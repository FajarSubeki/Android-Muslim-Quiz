package com.example.muslimquiz.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muslimquiz.R;
import com.example.muslimquiz.helper.PrefManager;
import com.example.muslimquiz.model.VideoCategory;
import com.example.muslimquiz.ui.MainGameActivity;
import com.example.muslimquiz.ui.VideoListActivity;

import java.util.List;
import java.util.Random;

public class VideoCategoryAdapter extends RecyclerView.Adapter<VideoCategoryAdapter.ViewHolder> {

    Context context;
    List<VideoCategory> videoCategoryList;
    PrefManager prefManager;

    public VideoCategoryAdapter(Context context, List<VideoCategory> videoCategoryList) {
        this.context = context;
        this.videoCategoryList = videoCategoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_category_video, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);

        prefManager = new PrefManager(context);
        //Total coint
        int sum_koin = 0;
        String jumlahsemuakoin = prefManager.getTotalKoin();
        if (jumlahsemuakoin == null){
            sum_koin = 0;
        }
        if (jumlahsemuakoin != null){
            sum_koin = Integer.parseInt(jumlahsemuakoin);
        }
        final int finalSum_koin = sum_koin;
        viewHolder.bg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String name_category2 = videoCategoryList.get(viewHolder.getAdapterPosition()).getName();
                    if (name_category2.equals("Ngaji")) {
                        String lock_video = prefManager.getlockngaji();
                        if (lock_video == null) {
                            final Dialog dialogCorrect = new Dialog(viewGroup.getContext());
                            dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            if (dialogCorrect.getWindow() != null) {
                                ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
                                dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
                            }
                            dialogCorrect.setContentView(R.layout.dialog_confirm_video);
                            dialogCorrect.setCancelable(true);

                            TextView description, title;
                            Button lanjut;
                            title = dialogCorrect.findViewById(R.id.title_Text);
                            description = dialogCorrect.findViewById(R.id.correctDescription);
                            lanjut = dialogCorrect.findViewById(R.id.dialog_lanjut);

                            final int koin_video = Integer.parseInt(videoCategoryList.get(viewHolder.getAdapterPosition()).getCoin());

                            lanjut.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (finalSum_koin < koin_video){
                                        Toast.makeText(context, "Koin anda kurang", Toast.LENGTH_SHORT).show();
                                        dialogCorrect.dismiss();
                                    }else{
                                        Intent intent = null;
                                        int sisa_koin = finalSum_koin - koin_video;
                                        Log.e("Sum Koin", String.valueOf(finalSum_koin));
                                        Log.e("Sisa Koin", String.valueOf(sisa_koin));
                                        prefManager.saveTotalKoin(context, String.valueOf(sisa_koin));
                                        intent = new Intent(context, VideoListActivity.class);
                                        intent.putExtra("Ngaji", name_category2);
                                        prefManager.savelockngaji(context, "a");
                                        context.startActivity(intent);
                                        dialogCorrect.dismiss();
                                    }
                                }
                            });

                            description.setText("Tonton Video dengan menukar poin anda sebanyak " + videoCategoryList.get(viewHolder.getAdapterPosition()).getCoin() + " Koin");
                            title.setText("Tonton Video " + videoCategoryList.get(viewHolder.getAdapterPosition()).getName() + " ?");

                            dialogCorrect.show();
                        }else{
                            Intent intent = null;
                            intent = new Intent(context, VideoListActivity.class);
                            intent.putExtra("Ngaji", name_category2);
                            context.startActivity(intent);
                        }
                    }
                    if (name_category2.equals("Rezeki")){
                        String lock_video = prefManager.getlocknrezeki();
                        if (lock_video == null) {
                            final Dialog dialogCorrect = new Dialog(viewGroup.getContext());
                            dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            if (dialogCorrect.getWindow() != null) {
                                ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
                                dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
                            }
                            dialogCorrect.setContentView(R.layout.dialog_confirm_video);
                            dialogCorrect.setCancelable(true);

                            TextView description, title;
                            Button lanjut;
                            title = dialogCorrect.findViewById(R.id.title_Text);
                            description = dialogCorrect.findViewById(R.id.correctDescription);
                            lanjut = dialogCorrect.findViewById(R.id.dialog_lanjut);

                            final int koin_video = Integer.parseInt(videoCategoryList.get(viewHolder.getAdapterPosition()).getCoin());

                            lanjut.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (finalSum_koin < koin_video){
                                        Toast.makeText(context, "Koin anda kurang", Toast.LENGTH_SHORT).show();
                                        dialogCorrect.dismiss();
                                    }else{
                                        Intent intent = null;
                                        int sisa_koin = finalSum_koin - koin_video;
                                        Log.e("Sum Koin", String.valueOf(finalSum_koin));
                                        Log.e("Sisa Koin", String.valueOf(sisa_koin));
                                        prefManager.saveTotalKoin(context, String.valueOf(sisa_koin));
                                        intent = new Intent(context, VideoListActivity.class);
                                        intent.putExtra("Rezeki", name_category2);
                                        prefManager.savelockrezeki(context, "a");
                                        context.startActivity(intent);
                                        dialogCorrect.dismiss();
                                    }
                                }
                            });

                            description.setText("Tonton Video dengan menukar poin anda sebanyak " + videoCategoryList.get(viewHolder.getAdapterPosition()).getCoin() + " Koin");
                            title.setText("Tonton Video " + videoCategoryList.get(viewHolder.getAdapterPosition()).getName() + " ?");

                            dialogCorrect.show();
                        }else{
                            Intent intent = null;
                            intent = new Intent(context, VideoListActivity.class);
                            intent.putExtra("Rezeki", name_category2);
                            context.startActivity(intent);
                        }
                    }
                    if (name_category2.equals("Shalat")){
                        String lock_video = prefManager.getlockshalat();
                        if (lock_video == null) {
                            final Dialog dialogCorrect = new Dialog(viewGroup.getContext());
                            dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            if (dialogCorrect.getWindow() != null) {
                                ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
                                dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
                            }
                            dialogCorrect.setContentView(R.layout.dialog_confirm_video);
                            dialogCorrect.setCancelable(true);

                            TextView description, title;
                            Button lanjut;
                            title = dialogCorrect.findViewById(R.id.title_Text);
                            description = dialogCorrect.findViewById(R.id.correctDescription);
                            lanjut = dialogCorrect.findViewById(R.id.dialog_lanjut);

                            final int koin_video = Integer.parseInt(videoCategoryList.get(viewHolder.getAdapterPosition()).getCoin());

                            lanjut.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (finalSum_koin < koin_video){
                                        Toast.makeText(context, "Koin anda kurang", Toast.LENGTH_SHORT).show();
                                        dialogCorrect.dismiss();
                                    }else{
                                        Intent intent = null;
                                        int sisa_koin = finalSum_koin - koin_video;
                                        Log.e("Sum Koin", String.valueOf(finalSum_koin));
                                        Log.e("Sisa Koin", String.valueOf(sisa_koin));
                                        prefManager.saveTotalKoin(context, String.valueOf(sisa_koin));
                                        intent = new Intent(context, VideoListActivity.class);
                                        intent.putExtra("Shalat", name_category2);
                                        prefManager.savelockshalat(context, "a");
                                        context.startActivity(intent);
                                        dialogCorrect.dismiss();
                                    }
                                }
                            });

                            description.setText("Tonton Video dengan menukar poin anda sebanyak " + videoCategoryList.get(viewHolder.getAdapterPosition()).getCoin() + " Koin");
                            title.setText("Tonton Video " + videoCategoryList.get(viewHolder.getAdapterPosition()).getName() + " ?");

                            dialogCorrect.show();
                        }else{
                            Intent intent = null;
                            intent = new Intent(context, VideoListActivity.class);
                            intent.putExtra("Shalat", name_category2);
                            context.startActivity(intent);
                        }
                    }
                    if (name_category2.equals("Jodoh")){
                        String lock_video = prefManager.getlockjodoh();
                        if (lock_video == null) {
                            final Dialog dialogCorrect = new Dialog(viewGroup.getContext());
                            dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            if (dialogCorrect.getWindow() != null) {
                                ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
                                dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
                            }
                            dialogCorrect.setContentView(R.layout.dialog_confirm_video);
                            dialogCorrect.setCancelable(true);

                            TextView description, title;
                            Button lanjut;
                            title = dialogCorrect.findViewById(R.id.title_Text);
                            description = dialogCorrect.findViewById(R.id.correctDescription);
                            lanjut = dialogCorrect.findViewById(R.id.dialog_lanjut);

                            final int koin_video = Integer.parseInt(videoCategoryList.get(viewHolder.getAdapterPosition()).getCoin());

                            lanjut.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (finalSum_koin < koin_video){
                                        Toast.makeText(context, "Koin anda kurang", Toast.LENGTH_SHORT).show();
                                        dialogCorrect.dismiss();
                                    }else{
                                        Intent intent = null;
                                        int sisa_koin = finalSum_koin - koin_video;
                                        Log.e("Sum Koin", String.valueOf(finalSum_koin));
                                        Log.e("Sisa Koin", String.valueOf(sisa_koin));
                                        prefManager.saveTotalKoin(context, String.valueOf(sisa_koin));
                                        intent = new Intent(context, VideoListActivity.class);
                                        intent.putExtra("Jodoh", name_category2);
                                        prefManager.savelockjodoh(context, "a");
                                        context.startActivity(intent);
                                        dialogCorrect.dismiss();
                                    }
                                }
                            });

                            description.setText("Tonton Video dengan menukar poin anda sebanyak " + videoCategoryList.get(viewHolder.getAdapterPosition()).getCoin() + " Koin");
                            title.setText("Tonton Video " + videoCategoryList.get(viewHolder.getAdapterPosition()).getName() + " ?");

                            dialogCorrect.show();
                        }else{
                            Intent intent = null;
                            intent = new Intent(context, VideoListActivity.class);
                            intent.putExtra("Jodoh", name_category2);
                            context.startActivity(intent);
                        }
                    }
                    if (name_category2.equals("Kisah")){
                        String lock_video = prefManager.getlockkisah();
                        if (lock_video == null) {
                            final Dialog dialogCorrect = new Dialog(viewGroup.getContext());
                            dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            if (dialogCorrect.getWindow() != null) {
                                ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
                                dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
                            }
                            dialogCorrect.setContentView(R.layout.dialog_confirm_video);
                            dialogCorrect.setCancelable(true);

                            TextView description, title;
                            Button lanjut;
                            title = dialogCorrect.findViewById(R.id.title_Text);
                            description = dialogCorrect.findViewById(R.id.correctDescription);
                            lanjut = dialogCorrect.findViewById(R.id.dialog_lanjut);

                            final int koin_video = Integer.parseInt(videoCategoryList.get(viewHolder.getAdapterPosition()).getCoin());

                            lanjut.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (finalSum_koin < koin_video){
                                        Toast.makeText(context, "Koin anda kurang", Toast.LENGTH_SHORT).show();
                                        dialogCorrect.dismiss();
                                    }else{
                                        Intent intent = null;
                                        int sisa_koin = finalSum_koin - koin_video;
                                        Log.e("Sum Koin", String.valueOf(finalSum_koin));
                                        Log.e("Sisa Koin", String.valueOf(sisa_koin));
                                        prefManager.saveTotalKoin(context, String.valueOf(sisa_koin));
                                        intent = new Intent(context, VideoListActivity.class);
                                        intent.putExtra("Kisah", name_category2);
                                        prefManager.savelockkisah(context, "a");
                                        context.startActivity(intent);
                                        dialogCorrect.dismiss();
                                    }
                                }
                            });

                            description.setText("Tonton Video dengan menukar poin anda sebanyak " + videoCategoryList.get(viewHolder.getAdapterPosition()).getCoin() + " Koin");
                            title.setText("Tonton Video " + videoCategoryList.get(viewHolder.getAdapterPosition()).getName() + " ?");

                            dialogCorrect.show();
                        }else{
                            Intent intent = null;
                            intent = new Intent(context, VideoListActivity.class);
                            intent.putExtra("Kisah", name_category2);
                            context.startActivity(intent);
                        }
                    }
                    if (name_category2.equals("Shalawat")){
                        String lock_video = prefManager.getlockshalawat();
                        if (lock_video == null) {
                            final Dialog dialogCorrect = new Dialog(viewGroup.getContext());
                            dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            if (dialogCorrect.getWindow() != null) {
                                ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
                                dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
                            }
                            dialogCorrect.setContentView(R.layout.dialog_confirm_video);
                            dialogCorrect.setCancelable(true);

                            TextView description, title;
                            Button lanjut;
                            title = dialogCorrect.findViewById(R.id.title_Text);
                            description = dialogCorrect.findViewById(R.id.correctDescription);
                            lanjut = dialogCorrect.findViewById(R.id.dialog_lanjut);

                            final int koin_video = Integer.parseInt(videoCategoryList.get(viewHolder.getAdapterPosition()).getCoin());

                            lanjut.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (finalSum_koin < koin_video){
                                        Toast.makeText(context, "Koin anda kurang", Toast.LENGTH_SHORT).show();
                                        dialogCorrect.dismiss();
                                    }else{
                                        Intent intent = null;
                                        int sisa_koin = finalSum_koin - koin_video;
                                        Log.e("Sum Koin", String.valueOf(finalSum_koin));
                                        Log.e("Sisa Koin", String.valueOf(sisa_koin));
                                        prefManager.saveTotalKoin(context, String.valueOf(sisa_koin));
                                        intent = new Intent(context, VideoListActivity.class);
                                        intent.putExtra("Shalawat", name_category2);
                                        prefManager.savelockshalawat(context, "a");
                                        context.startActivity(intent);
                                        dialogCorrect.dismiss();
                                    }
                                }
                            });

                            description.setText("Tonton Video dengan menukar poin anda sebanyak " + videoCategoryList.get(viewHolder.getAdapterPosition()).getCoin() + " Koin");
                            title.setText("Tonton Video " + videoCategoryList.get(viewHolder.getAdapterPosition()).getName() + " ?");

                            dialogCorrect.show();
                        }else{
                            Intent intent = null;
                            intent = new Intent(context, VideoListActivity.class);
                            intent.putExtra("Shalawat", name_category2);
                            context.startActivity(intent);
                        }
                    }
                }
            });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(videoCategoryList.get(i));
        VideoCategory vc = videoCategoryList.get(i);

        Random rnd2 = new Random();
        int color = Color.argb(255, rnd2.nextInt(256), rnd2.nextInt(256), rnd2.nextInt(256));
        viewHolder.bg.setCardBackgroundColor(color);
        viewHolder.name.setText(vc.getName());
        viewHolder.coin.setText(vc.getCoin());
        String checkvideo = prefManager.getlockngaji();
        String checkvideorezeki = prefManager.getlocknrezeki();
        String checkvideoshalat = prefManager.getlockshalat();
        String checkvideojodoh = prefManager.getlockjodoh();
        String checkvideokisah = prefManager.getlockkisah();
        String checkvideoshalawat = prefManager.getlockshalawat();
        final String name_category2 = videoCategoryList.get(viewHolder.getAdapterPosition()).getName();
        if (name_category2.equals("Ngaji")){
            if (checkvideo != null){
                viewHolder.locked.setImageResource(R.drawable.correct);
            }else{
                viewHolder.locked.setImageResource(R.drawable.ic_lock_black_24dp);
            }
        }
        if (name_category2.equals("Rezeki")){
            if (checkvideorezeki != null){
                viewHolder.locked.setImageResource(R.drawable.correct);
            }else{
                viewHolder.locked.setImageResource(R.drawable.ic_lock_black_24dp);
            }
        }
        if (name_category2.equals("Shalat")){
            if (checkvideoshalat != null){
                viewHolder.locked.setImageResource(R.drawable.correct);
            }else{
                viewHolder.locked.setImageResource(R.drawable.ic_lock_black_24dp);
            }
        }
        if (name_category2.equals("Jodoh")){
            if (checkvideojodoh != null){
                viewHolder.locked.setImageResource(R.drawable.correct);
            }else{
                viewHolder.locked.setImageResource(R.drawable.ic_lock_black_24dp);
            }
        }
        if (name_category2.equals("Kisah")){
            if (checkvideokisah!= null){
                viewHolder.locked.setImageResource(R.drawable.correct);
            }else{
                viewHolder.locked.setImageResource(R.drawable.ic_lock_black_24dp);
            }
        }
        if (name_category2.equals("Shalawat")){
            if (checkvideoshalawat != null){
                viewHolder.locked.setImageResource(R.drawable.correct);
            }else{
                viewHolder.locked.setImageResource(R.drawable.ic_lock_black_24dp);
            }
        }

    }

    @Override
    public int getItemCount() {
        return videoCategoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView bg;
        ImageView locked;
        TextView name, coin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name_category);
            coin = itemView.findViewById(R.id.tv_point_category);
            bg = itemView.findViewById(R.id.card_category_video);
            locked = itemView.findViewById(R.id.iv_locked);
        }
    }

}
