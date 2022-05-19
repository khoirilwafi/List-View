/* program ini digunakan untuk menangani proses utama dari aplikasi */
package com.example.tugas_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.res.TypedArray;
import android.widget.ListView;

import java.util.ArrayList;

// main activity
public class MainActivity extends AppCompatActivity {

    // variabel untuk menampung data dari resource
    private String[] namaMonumen;
    private String[] lokasiMonumen;
    private TypedArray imgMonumen;
    private adapter Adapter;

    // deklarasi array list
    private final ArrayList<chat> my_list = new ArrayList<>();

    @Override
    // oncreate function
    protected void onCreate(Bundle savedInstanceState) {

        // menampilkan layout main activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // membuat adapter untuk menghubungkan array dengan list view
        Adapter = new adapter(this);
        ListView listView = findViewById(R.id.list_monumen);
        listView.setAdapter(Adapter);

        // mengambil data dari array
        siapkan_data();
        // mengisikan data ke list view
        isi_list();

        // on click handler
        listView.setOnItemClickListener((adapterView, view, position, id) -> {

            // nothing to do
        });

    }

    // fungsi untuk memindahkan data dari array ke list view
    private void siapkan_data() {
        // ambil dan pindahkan data nama chat
        namaMonumen = getResources().getStringArray(R.array.nama);
        // ambil dan pindahkan data lokasi chat
        lokasiMonumen = getResources().getStringArray(R.array.pesan);
        // ambil dan pindahkan gambar dari chat
        imgMonumen = getResources().obtainTypedArray(R.array.foto);
    }

    // fungsi untuk memindahkan data ke list view
    private void isi_list() {
        // ulangi untuk setiap nama dari chat
        for (int i = 0; i < namaMonumen.length; i++) {
            // membuat objek chat baru untuk dimasukkan le list view
            chat Monumen = new chat();
            // atur data dari objek
            Monumen.set_img(imgMonumen.getResourceId(i, -1));
            Monumen.set_nama(namaMonumen[i]);
            Monumen.set_lokasi(lokasiMonumen[i]);
            // tambahkan ke list view
            my_list.add(Monumen);
        }

        Adapter.setNew_chat(my_list);
    }
}