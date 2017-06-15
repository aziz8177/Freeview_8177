package tk.azizardy.freeview;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import tk.azizardy.freeview.adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    MyAdapter adapter;
    ArrayList<Integer> idImages;
    ArrayList<String> nameList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listview);
        idImages = new ArrayList<>();
        idImages = getList();
        nameList = new ArrayList<>();
        nameList = getNameList();
        adapter = new MyAdapter(MainActivity.this, idImages, nameList);
        lv.setAdapter(adapter);
        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Memutar " + nameList.get(position), Toast.LENGTH_SHORT).show();
                @Override
            }
        });
        */
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id)
            {
                // In the following line "v" refers to the View returned by the `getView()` method; meaning the clicked View.
                Toast.makeText(MainActivity.this, "Memutar Saluran  " + nameList.get(position),Toast.LENGTH_SHORT).show();
                TextView txtName = (TextView)v.findViewById(R.id.textView);
                String name = txtName.getText().toString();
                switch(name)
                {
                    case "TRANS 7":
                        Intent trans7 = new Intent(MainActivity.this, PlayActivity.class);
                        trans7.putExtra("url","https://livestream-hybrid.akamaized.net/live/smil:trans7.smil/playlist.m3u8");
                        startActivity(trans7);
                        break;

                    case "TRANS TV":
                        Intent transtv = new Intent(MainActivity.this, PlayActivity.class);
                        transtv.putExtra("url","https://livestream-hybrid.akamaized.net/live/smil:transtv.smil/playlist.m3u8");
                        startActivity(transtv);
                        break;

                    case "TVONE":
                        Intent tvone = new Intent(MainActivity.this, PlayActivity.class);
                        tvone.putExtra("url","https://livestream-hybrid.akamaized.net/live/smil:tvone.smil/playlist.m3u8");
                        startActivity(tvone);
                        break;

                    case "ANTV":
                        Intent antv = new Intent(MainActivity.this, PlayActivity.class);
                        antv.putExtra("url","https://livestream-hybrid.akamaized.net/live/smil:antv.smil/playlist.m3u8");
                        startActivity(antv);
                        break;

                    case "SCTV":
                        Intent sctv = new Intent(MainActivity.this, PlayActivity.class);
                        sctv.putExtra("url","https://livestream-hybrid.akamaized.net/live/smil:sctv.smil/playlist.m3u8");
                        startActivity(sctv);
                        break;

                    case "INDOSIAR":
                        Intent indosiar = new Intent(MainActivity.this, PlayActivity.class);
                        indosiar.putExtra("url","https://livestream-hybrid.akamaized.net/live/smil:indosiar.smil/playlist.m3u8");
                        startActivity(indosiar);
                        break;

                    case "RTV":
                        Intent rtv = new Intent(MainActivity.this, PlayActivity.class);
                        rtv.putExtra("url","https://livestream-hybrid.akamaized.net/live/smil:rtv.smil/playlist.m3u8");
                        startActivity(rtv);
                        break;

                    case "KOMPAS TV":
                        Intent kompastv = new Intent(MainActivity.this, PlayActivity.class);
                        kompastv.putExtra("url","https://livestream-hybrid.akamaized.net/live/smil:kompastv.smil/playlist.m3u8");
                        startActivity(kompastv);
                        break;

                    case "DW TV":
                        Intent dwtv = new Intent(MainActivity.this, PlayActivity.class);
                        dwtv.putExtra("url","https://livestream-hybrid.akamaized.net/live/smil:dwtv.smil/playlist.m3u8");
                        startActivity(dwtv);
                        break;

                    case "OCHANNEL":
                        Intent ochannel = new Intent(MainActivity.this, PlayActivity.class);
                        ochannel.putExtra("url","https://livestream-hybrid.akamaized.net/live/smil:ochannel.smil/playlist.m3u8");
                        startActivity(ochannel);
                        break;
                    //And so on and so forth....https://stream.sindonews.net/live/inewstvokezone.com.m3u8

                    case "RCTI":
                        Intent rcti = new Intent(MainActivity.this, PlayActivity.class);
                        rcti.putExtra("url","http://livemedia.mncplaymedia.net/cdn/iptv/Tvod/001/channel2000042/index.m3u8");
                        startActivity(rcti);
                        break;
                    case "GLOBAL TV":
                        Intent globaltv = new Intent(MainActivity.this, PlayActivity.class);
                        globaltv.putExtra("url","http://livemedia.mncplaymedia.net/cdn/iptv/Tvod/001/channel2000041/index.m3u8");
                        startActivity(globaltv);
                        break;
                    case "MNCTV":
                        Intent mnctv = new Intent(MainActivity.this, PlayActivity.class);
                        mnctv.putExtra("url","http://livemedia.mncplaymedia.net/cdn/iptv/Tvod/001/channel2000022/index.m3u8");
                        startActivity(mnctv);
                        break;
                    case "INEWS TV":
                        Intent inewstv = new Intent(MainActivity.this, PlayActivity.class);
                        inewstv.putExtra("url","http://livemedia.mncplaymedia.net/cdn/iptv/Tvod/001/channel2000029/index.m3u8");
                        startActivity(inewstv);
                        break;
                    case "TVRI":
                        Intent tvri = new Intent(MainActivity.this, PlayActivity.class);
                        tvri.putExtra("url","http://ott.tvri.co.id/Content/HLS/Live/Channel(TVRINasional)/Stream(04)/index.m3u8");
                        startActivity(tvri);
                        break;
                    case "ADI TV":
                        Intent aditv = new Intent(MainActivity.this, PlayActivity.class);
                        aditv.putExtra("url","http://aditv.onlivestreaming.net/aditv/livestream/playlist.m3u8");
                        startActivity(aditv);
                        break;
                }

            }
        });
    }

    public ArrayList<Integer> getList() {
        idImages = new ArrayList<>();
        idImages.add(R.drawable.trans7);
        idImages.add(R.drawable.transtv);
        idImages.add(R.drawable.tvone);
        idImages.add(R.drawable.antv);
        idImages.add(R.drawable.sctv);
        idImages.add(R.drawable.indosiar);
        idImages.add(R.drawable.rtv);
        idImages.add(R.drawable.kompastv);
        idImages.add(R.drawable.dwtv);
        idImages.add(R.drawable.ochannel);
        idImages.add(R.drawable.rcti);
        idImages.add(R.drawable.globaltv);
        idImages.add(R.drawable.mnctv);
        idImages.add(R.drawable.inewstv);
        idImages.add(R.drawable.tvri);
        idImages.add(R.drawable.aditv);
        idImages.add(R.drawable.creator);
        return idImages;
    }

    public ArrayList<String> getNameList() {
        nameList = new ArrayList<>();
        nameList.add("TRANS 7");
        nameList.add("TRANS TV");
        nameList.add("TVONE");
        nameList.add("ANTV");
        nameList.add("SCTV");
        nameList.add("INDOSIAR");
        nameList.add("RTV");
        nameList.add("KOMPAS TV");
        nameList.add("DW TV");
        nameList.add("OCHANNEL");
        nameList.add("RCTI");
        nameList.add("GLOBAL TV");
        nameList.add("MNCTV");
        nameList.add("INEWS TV");
        nameList.add("TVRI");
        nameList.add("ADI TV");
        nameList.add("Aziz Juniardy / 8177");
        return nameList;
    }


}