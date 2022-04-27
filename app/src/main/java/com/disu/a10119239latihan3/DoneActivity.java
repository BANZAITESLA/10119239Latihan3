package com.disu.a10119239latihan3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class DoneActivity extends AppCompatActivity {

//  Mendeklarasikan / Binding View menggunakan butterknife
    @BindView(R.id.txtDoneTitle)
    TextView txtNama;
    @BindString(R.string.activation_beres)
    String beres;
    @BindString(R.string.activation_sudah_bisa)
    String sudahBisa;
    @BindString(R.string.activation_setiap)
    String setiap;
    @BindString(R.string.activation_buat)
    String buat;

//  Id unik untuk putekstra (melempar nilai ke activity lain)
    public static final String ID_EXTRA_MSG_EXIT = "com.disu.a10119239latihan3.MSG_EXIT";

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

//      mendeklarasikan butterknife di activity
        ButterKnife.bind(this);
        bindExtra();
    }

    private void bindExtra(){
//      Menampung value yang dilempar dari BiodatActivity
        Intent intent = getIntent();
        name = intent.getStringExtra(BiodataActivity.ID_EXTRA_MSG);

//      set nama sesuai dengan data nama yang dilempar menjadi satu kesatuan kalimat
        txtNama.setText(beres+" "+name+" "+sudahBisa+" "+name+" "+setiap+" "+name+" "+buat);
    }

//  ketika button "Oke" diklik
    @OnClick(R.id.btnDoneNext)
    public void selesai(View view) {

//      set agar ketika menekan tombol Oke, Aplikasi close
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(ID_EXTRA_MSG_EXIT, true);
        startActivity(intent);
    }
}

/*
    Tanggal     : Rabu, 27 April 2022
    Deskripsi   : Set class DoneActivity untuk form Done
    NIM         : 10119239
    Nama        : Dea Inesia Sri Utami
    Kelas       : IF6
*/