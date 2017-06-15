package tk.azizardy.freeview;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.VideoView;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class PlayActivity extends Activity {

    VideoView video;
    //String Url="https://livestream-hybrid.akamaized.net/live/smil:trans7.smil/chunklist_b216000.m3u8";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        video = (VideoView) this.findViewById(R.id.videoView);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        video.setVideoPath(url);
        video.requestFocus();
        video.start();
    }

}
