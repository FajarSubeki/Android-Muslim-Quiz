package com.example.muslimquiz.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.allattentionhere.autoplayvideos.AAH_CustomRecyclerView;
import com.example.muslimquiz.R;
import com.example.muslimquiz.adapter.VideoListAdapter;
import com.example.muslimquiz.base.BaseActivity;
import com.example.muslimquiz.model.VideoModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class VideoListActivity extends BaseActivity {

    AAH_CustomRecyclerView recyclerView;
    private final List<VideoModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        init();
    }

    void init(){

        recyclerView = findViewById(R.id.rv_video);
        Intent data  = getIntent();
        String ngaji, rezeki, shalat, jodoh, kisah, shalawat;
        if (data != null){
            ngaji = getIntent().getStringExtra("Ngaji");
            rezeki = getIntent().getStringExtra("Rezeki");
            shalat = getIntent().getStringExtra("Shalat");
            jodoh = getIntent().getStringExtra("Jodoh");
            kisah = getIntent().getStringExtra("Kisah");
            shalawat = getIntent().getStringExtra("Shalawat");
            if (ngaji != null){
                super.setUpActionBar(ngaji);
                Log.e("Kategori Video", ngaji);
                Picasso p = Picasso.with(this);
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1491561340/hello_cuwgcb.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1491561340/hello_cuwgcb.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Muhammad Taha"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/3_yqeudi.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/3_yqeudi.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Muhammad Taha"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/1_pyn1fm.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/1_pyn1fm.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Muhammad Taha"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/3_yqeudi.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/3_yqeudi.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Muhammad Taha"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795676/4_nvnzry.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795676/4_nvnzry.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Muhammad Taha"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/2_qwpgis.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/3_lfndfq.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/1_ybonak.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));

                VideoListAdapter mAdapter = new VideoListAdapter(modelList, p);
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());

                recyclerView.setActivity(this);
                recyclerView.setPlayOnlyFirstVideo(false);
                recyclerView.setCheckForMp4(true);
                recyclerView.setDownloadPath(Environment.getExternalStorageDirectory() + "/MyVideo"); // (Environment.getExternalStorageDirectory() + "/Video") by default

                recyclerView.setDownloadVideos(true); // false by default

                recyclerView.setVisiblePercent(50); // percentage of View that needs to be visible to start playing

                //extra - start downloading all videos in background before loading RecyclerView
                List<String> urls = new ArrayList<>();
                for (VideoModel object : modelList) {
                    if (object.getVideo_url() != null && object.getVideo_url().contains("http"))
                        urls.add(object.getVideo_url());
                }
                recyclerView.preDownload(urls);

                recyclerView.setAdapter(mAdapter);
                //call this functions when u want to start autoplay on loading async lists (eg firebase)
                recyclerView.smoothScrollBy(0,1);
                recyclerView.smoothScrollBy(0,-1);
            }else if(rezeki != null){
                super.setUpActionBar(rezeki);
                Log.e("Kategori Video", rezeki);
                Picasso p = Picasso.with(this);
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/2_qwpgis.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/3_lfndfq.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/1_ybonak.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1491561340/hello_cuwgcb.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1491561340/hello_cuwgcb.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/3_yqeudi.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/3_yqeudi.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/1_pyn1fm.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/1_pyn1fm.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/3_yqeudi.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/3_yqeudi.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795676/4_nvnzry.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795676/4_nvnzry.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));

                VideoListAdapter mAdapter = new VideoListAdapter(modelList, p);
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());

                recyclerView.setActivity(this);
                recyclerView.setPlayOnlyFirstVideo(false);
                recyclerView.setCheckForMp4(true);
                recyclerView.setDownloadPath(Environment.getExternalStorageDirectory() + "/MyVideo"); // (Environment.getExternalStorageDirectory() + "/Video") by default

                recyclerView.setDownloadVideos(true); // false by default

                recyclerView.setVisiblePercent(50); // percentage of View that needs to be visible to start playing

                //extra - start downloading all videos in background before loading RecyclerView
                List<String> urls = new ArrayList<>();
                for (VideoModel object : modelList) {
                    if (object.getVideo_url() != null && object.getVideo_url().contains("http"))
                        urls.add(object.getVideo_url());
                }
                recyclerView.preDownload(urls);

                recyclerView.setAdapter(mAdapter);
                //call this functions when u want to start autoplay on loading async lists (eg firebase)
                recyclerView.smoothScrollBy(0,1);
                recyclerView.smoothScrollBy(0,-1);
            }else if(shalat != null){
                super.setUpActionBar(shalat);
                Log.e("Kategori Video", shalat);
                Picasso p = Picasso.with(this);
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/2_qwpgis.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/3_lfndfq.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/1_ybonak.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1491561340/hello_cuwgcb.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1491561340/hello_cuwgcb.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/3_yqeudi.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/3_yqeudi.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/1_pyn1fm.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/1_pyn1fm.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/3_yqeudi.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/3_yqeudi.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795676/4_nvnzry.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795676/4_nvnzry.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));

                VideoListAdapter mAdapter = new VideoListAdapter(modelList, p);
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());

                recyclerView.setActivity(this);
                recyclerView.setPlayOnlyFirstVideo(false);
                recyclerView.setCheckForMp4(true);
                recyclerView.setDownloadPath(Environment.getExternalStorageDirectory() + "/MyVideo"); // (Environment.getExternalStorageDirectory() + "/Video") by default

                recyclerView.setDownloadVideos(true); // false by default

                recyclerView.setVisiblePercent(50); // percentage of View that needs to be visible to start playing

                //extra - start downloading all videos in background before loading RecyclerView
                List<String> urls = new ArrayList<>();
                for (VideoModel object : modelList) {
                    if (object.getVideo_url() != null && object.getVideo_url().contains("http"))
                        urls.add(object.getVideo_url());
                }
                recyclerView.preDownload(urls);

                recyclerView.setAdapter(mAdapter);
                //call this functions when u want to start autoplay on loading async lists (eg firebase)
                recyclerView.smoothScrollBy(0,1);
                recyclerView.smoothScrollBy(0,-1);
            }else if(jodoh != null){
                super.setUpActionBar(jodoh);
                Log.e("Kategori Video", jodoh);
                Picasso p = Picasso.with(this);
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/2_qwpgis.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/3_lfndfq.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/1_ybonak.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1491561340/hello_cuwgcb.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1491561340/hello_cuwgcb.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/3_yqeudi.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/3_yqeudi.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/1_pyn1fm.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/1_pyn1fm.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/3_yqeudi.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/3_yqeudi.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795676/4_nvnzry.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795676/4_nvnzry.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));

                VideoListAdapter mAdapter = new VideoListAdapter(modelList, p);
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());

                recyclerView.setActivity(this);
                recyclerView.setPlayOnlyFirstVideo(false);
                recyclerView.setCheckForMp4(true);
                recyclerView.setDownloadPath(Environment.getExternalStorageDirectory() + "/MyVideo"); // (Environment.getExternalStorageDirectory() + "/Video") by default

                recyclerView.setDownloadVideos(true); // false by default

                recyclerView.setVisiblePercent(50); // percentage of View that needs to be visible to start playing

                //extra - start downloading all videos in background before loading RecyclerView
                List<String> urls = new ArrayList<>();
                for (VideoModel object : modelList) {
                    if (object.getVideo_url() != null && object.getVideo_url().contains("http"))
                        urls.add(object.getVideo_url());
                }
                recyclerView.preDownload(urls);

                recyclerView.setAdapter(mAdapter);
                //call this functions when u want to start autoplay on loading async lists (eg firebase)
                recyclerView.smoothScrollBy(0,1);
                recyclerView.smoothScrollBy(0,-1);
            }else if(kisah != null){
                super.setUpActionBar(kisah);
                Log.e("Kategori Video", kisah);
                Picasso p = Picasso.with(this);
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/2_qwpgis.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/3_lfndfq.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/1_ybonak.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1491561340/hello_cuwgcb.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1491561340/hello_cuwgcb.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/3_yqeudi.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/3_yqeudi.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/1_pyn1fm.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/1_pyn1fm.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/3_yqeudi.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/3_yqeudi.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795676/4_nvnzry.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795676/4_nvnzry.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));

                VideoListAdapter mAdapter = new VideoListAdapter(modelList, p);
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());

                recyclerView.setActivity(this);
                recyclerView.setPlayOnlyFirstVideo(false);
                recyclerView.setCheckForMp4(true);
                recyclerView.setDownloadPath(Environment.getExternalStorageDirectory() + "/MyVideo"); // (Environment.getExternalStorageDirectory() + "/Video") by default

                recyclerView.setDownloadVideos(true); // false by default

                recyclerView.setVisiblePercent(50); // percentage of View that needs to be visible to start playing

                //extra - start downloading all videos in background before loading RecyclerView
                List<String> urls = new ArrayList<>();
                for (VideoModel object : modelList) {
                    if (object.getVideo_url() != null && object.getVideo_url().contains("http"))
                        urls.add(object.getVideo_url());
                }
                recyclerView.preDownload(urls);

                recyclerView.setAdapter(mAdapter);
                //call this functions when u want to start autoplay on loading async lists (eg firebase)
                recyclerView.smoothScrollBy(0,1);
                recyclerView.smoothScrollBy(0,-1);
            }else if(shalawat != null){
                super.setUpActionBar(shalawat);
                Log.e("Kategori Video", shalawat);
                Picasso p = Picasso.with(this);
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/2_qwpgis.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/3_lfndfq.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/image/upload/q_70/v1481795690/1_ybonak.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1491561340/hello_cuwgcb.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1491561340/hello_cuwgcb.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/3_yqeudi.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/3_yqeudi.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/1_pyn1fm.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/1_pyn1fm.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/3_yqeudi.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/3_yqeudi.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));
                modelList.add(new VideoModel("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795676/4_nvnzry.mp4", "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795676/4_nvnzry.jpg", "Ar-Rahman 1-5", "Lantunan surat Al-Rahman ayat 1-10 sangat merdu sekali dibawakan oleh Fajar Subeki"));

                VideoListAdapter mAdapter = new VideoListAdapter(modelList, p);
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());

                recyclerView.setActivity(this);
                recyclerView.setPlayOnlyFirstVideo(false);
                recyclerView.setCheckForMp4(true);
                recyclerView.setDownloadPath(Environment.getExternalStorageDirectory() + "/MyVideo"); // (Environment.getExternalStorageDirectory() + "/Video") by default

                recyclerView.setDownloadVideos(true); // false by default

                recyclerView.setVisiblePercent(50); // percentage of View that needs to be visible to start playing

                //extra - start downloading all videos in background before loading RecyclerView
                List<String> urls = new ArrayList<>();
                for (VideoModel object : modelList) {
                    if (object.getVideo_url() != null && object.getVideo_url().contains("http"))
                        urls.add(object.getVideo_url());
                }
                recyclerView.preDownload(urls);

                recyclerView.setAdapter(mAdapter);
                //call this functions when u want to start autoplay on loading async lists (eg firebase)
                recyclerView.smoothScrollBy(0,1);
                recyclerView.smoothScrollBy(0,-1);
            }

        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        recyclerView.stopVideos();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), ChooseVideoCategory.class));
    }
}
