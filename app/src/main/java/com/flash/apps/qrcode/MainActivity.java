package com.flash.apps.qrcode;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
//import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    EditText input_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_text = findViewById(R.id.input_text);

        Button generate_qr = findViewById(R.id.generate_qr);
        final ImageView generated_qrcode = findViewById(R.id.generated_qrcode);
        generate_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = input_text.getText().toString();
                QRCodeWriter qrcodewriter = new QRCodeWriter();
                try {
                    BitMatrix bitMatrix = qrcodewriter.encode(text, BarcodeFormat.QR_CODE,400,400);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    generated_qrcode.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }


            }
        });
    }
}
