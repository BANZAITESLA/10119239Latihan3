package com.disu.a10119239latihan3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;

public class BiodataActivity extends AppCompatActivity {

//  Mendeklarasikan / Binding View menggunakan butterknife
    @BindView(R.id.edtBiodataName)
    EditText edtNama;
    @BindString(R.string.check_code_warning_empty_title_name)
    String emptyTitle;
    @BindString(R.string.check_code_warning_empty_desc_name)
    String emptyMessage;
    @BindString(R.string.warning_title)
    String warningTitle;

    final Context context = this;

    private String nameBiodata;

//  Id unik untuk putekstra (melempar nilai ke activity lain)
    public static final String ID_EXTRA_MSG = "com.disu.a10119239latihan3.MSG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);

//      mendeklarasikan butterknife di activity
        ButterKnife.bind(this);
    }

//  ketika "Selanjutnya" diklik
    @OnClick(R.id.btnBiodataNext)
    void selanjutnya() {

//      get Nama
        nameBiodata = edtNama.getText().toString();

//      validasi Nama
        if (isStringEmpty(nameBiodata)) {
            showWarningMessage();
        } else {
            Intent intent = new Intent(this, DoneActivity.class);

            //Melempar isi nama biodata ke kelas DoneActivity
            intent.putExtra(ID_EXTRA_MSG, nameBiodata);
            startActivity(intent);
        }
    }

//  validasi input
    public static boolean isStringEmpty(String str) {
        return "".equals(str);
    }

//  set warning dialog
    public void showWarningMessage(){

//      custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_warning_dialog);
        dialog.setTitle(warningTitle);

//      TODO WAS CLEAR :)
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

//      set the custom dialog components - text, image and button
        TextView textTitle = (TextView) dialog.findViewById(R.id.txtWarningDialogTitle);
        TextView textDesc = (TextView) dialog.findViewById(R.id.txtWarningDialogDesc);
        Button dialogButton = (Button) dialog.findViewById(R.id.btnWarningDialogOk);

        textTitle.setText(emptyTitle);
        textDesc.setText(emptyMessage);

//      jika button ditekan, dialog ditutup
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}

/*
    Tanggal     : Rabu, 27 April 2022
    Deskripsi   : Set class BiodataActivity dan Dialog untuk form Biodata
    NIM         : 10119239
    Nama        : Dea Inesia Sri Utami
    Kelas       : IF6
*/