package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView =  findViewById(R.id.tennisVideoView);

        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.tennisvideo);

        //to mute video
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0f, 0f);
                mp.setLooping(true);
            }
        });

        MediaController mediaController = new MediaController(this); //to add pause, play and other functionalities

        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);

        videoView.start();

    }
}