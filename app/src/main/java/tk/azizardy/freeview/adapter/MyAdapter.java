package tk.azizardy.freeview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tk.azizardy.freeview.R;

/**
 * Created by Aziz Juniardy on 26/05/2017.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Integer> listId;
    private ArrayList<String> nameList;

    public MyAdapter(Context context, ArrayList<Integer> listId, ArrayList<String> nameList) {
        this.context = context;
        this.listId = listId;
        this.nameList = nameList;
    }

    @Override
    public int getCount() {
        return nameList.size();
    }

    @Override
    public Object getItem(int position) {
        return nameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = View.inflate(context, R.layout.items_list,null);
        }
        ImageView images = (ImageView) convertView.findViewById(R.id.imageView);
        TextView text  = (TextView) convertView.findViewById(R.id.textView);
        images.setImageResource(listId.get(position));
        text.setText(nameList.get(position));
        return convertView ;
    }
}
