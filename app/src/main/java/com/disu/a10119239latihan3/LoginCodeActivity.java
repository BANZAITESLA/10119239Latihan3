package com.disu.a10119239latihan3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;

public class LoginCodeActivity extends AppCompatActivity {

//  Mendeklarasikan / Binding View menggunakan butterknife
    @BindView(R.id.txtCheckCodeAgree)
    TextView txtAgree;
    @BindView(R.id.edtInputCode)
    EditText edtInputCode;
    @BindString(R.string.check_code_warning_empty_title)
    String emptyTitle;
    @BindString(R.string.check_code_warning_empty_desc)
    String emptyMessage;
    @BindString(R.string.warning_title)
    String warningTitle;
    private String code;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_code);

//      mendeklarasikan butterknife di activity
        ButterKnife.bind(this);

//      Convert string dengan tag html </b> ke bentuk html kemudian di set ke textAgree
        txtAgree.setText(Html.fromHtml(getString(R.string.check_code_text_agreement)));
    }

//  ketika button "Mask dikilik"
    @OnClick(R.id.btnCheckCode)
    public void masuk(View view) {

//      Menampung nilai string dari edittext
        code = edtInputCode.getText().toString();

//      validasi jika inputan kode masih kosong
        if (isStringEmpty(code)) {
//          menampilkan dialog pesan warning
            showWarningMessage();
        } else {
//          pindah halaman
            startActivity(new Intent(this, BiodataActivity.class));
        }
    }

//  Method membandingkan string
    public static boolean isStringEmpty(String str) {
        return "".equals(str);
    }

//  Method menampilkan dialog pesan warning
    public void showWarningMessage(){
//      custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_warning_dialog);
        dialog.setTitle(warningTitle);

//      TODO WAS CLEAR :)
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

//      set the custom dialog components - text, image and button
        TextView textTitle = (TextView) dialog.findViewById(R.id.txtWarningDialogTitle);
        TextView text = (TextView) dialog.findViewById(R.id.txtWarningDialogDesc);
        Button dialogButton = (Button) dialog.findViewById(R.id.btnWarningDialogOk);

        textTitle.setText(emptyTitle);
        text.setText(emptyMessage);

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
    Deskripsi   : Set class LoginCodeActivity dan Dialog untuk form Login Code
    NIM         : 10119239
    Nama        : Dea Inesia Sri Utami
    Kelas       : IF6
*/