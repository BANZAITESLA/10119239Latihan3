package com.disu.a10119239latihan3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.disu.a10119239latihan3.DoneActivity.ID_EXTRA_MSG_EXIT;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

//      mendeklarasikan butterknife di activity
        ButterKnife.bind(this);

/*      logika untuk menampung nilai putekstra dari kelas DoneActivity ,
        agar ketika dihalaman akhir (DoneActivity) ditekan button ok,
        Semua activity dapat tertutup juga (finish). */
        if (getIntent().getBooleanExtra(ID_EXTRA_MSG_EXIT, false)) {
            finish();
        }
    }

//  Method dari butterknife untuk mengklik tombol dengan id btnWalkthroughStart
    @OnClick(R.id.btnWalkthroughStart)
    void mulai() {

//      Perintah pindah halaman
        Intent intent = new Intent(this, LoginCodeActivity.class);
        startActivity(intent);
    }
}

/*
    Tanggal     : Rabu, 27 April 2022
    Deskripsi   : Set class WelcomeActivity untuk form Welcome
    NIM         : 10119239
    Nama        : Dea Inesia Sri Utami
    Kelas       : IF6
*/