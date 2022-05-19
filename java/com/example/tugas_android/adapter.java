/* program ini digunakan untuk menangani perpindahan data dari array resource ke tampilan list view */

package com.example.tugas_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class adapter extends BaseAdapter {

    private final Context context;
    private ArrayList<chat> new_chat = new ArrayList<>();

    void setNew_chat(ArrayList<chat> new_chat) {
        this.new_chat = new_chat;
    }

    adapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return new_chat.size();
    }

    @Override
    public Object getItem(int i) {
        return new_chat.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View item_view = view;

        if (item_view == null) {
            item_view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(item_view);

        chat monumen = (chat) getItem(i);
        viewHolder.bind(monumen);
        return item_view;

    }

    private static class ViewHolder {
        private final TextView txt_name;
        private final TextView txt_psn;
        private final ImageView img_orang;

        ViewHolder(View view) {
            txt_name = view.findViewById(R.id.nama_orang);
            txt_psn = view.findViewById(R.id.pesan_orang);
            img_orang = view.findViewById(R.id.img_orang);
        }

        void bind(chat monumen) {
            txt_name.setText(monumen.get_nama());
            txt_psn.setText(monumen.get_lokasi());
            img_orang.setImageResource(monumen.get_img());
        }
    }
}
