# QR-Code-Generator
Very basic QR Code Generator using ZXing

Libraries used: Zebra Crossing (ZXing)
Link: https://github.com/zxing/zxing

Steps to create a similar application:

1. Add dependencies to the build gradle of the 'App' directory

        compile 'com.google.zxing:core:3.2.1'
        compile 'com.journeyapps:zxing-android-embedded:3.2.0@aar'

2. Add the required Views (ImageView, Buttons, Text fields) in your XML view. 

    <LinearLayout
        android:layout_width="368dp"
        android:layout_height="495dp"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="8dp"
        tools:layout_editor_absoluteY="8dp">

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="QR Codes"
            android:textSize="25sp"
            tools:layout_editor_absoluteX="7dp"
            tools:layout_editor_absoluteY="5dp" />

        <ImageView
            android:id="@+id/generated_qrcode"
            android:layout_width="209dp"
            android:layout_height="289dp"
            android:layout_marginTop="8dp"
            app:layout_constraintTop_toBottomOf="@+id/textView"
            app:srcCompat="@drawable/qrcode"
            tools:layout_editor_absoluteX="88dp" />

        <EditText
            android:id="@+id/input_text"
            android:layout_width="350dp"
            android:layout_height="wrap_content"
            android:hint="@string/input_hint"
            android:inputType="text"
            tools:layout_editor_absoluteX="16dp"
            tools:layout_editor_absoluteY="348dp" />

        <Button
            android:id="@+id/generate_qr"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="8dp"
            android:text="Generate QR Code"
            app:layout_constraintTop_toBottomOf="@+id/input_text"
            tools:layout_editor_absoluteX="115dp" />
    </LinearLayout>

3. Define the corresponding Views in your Java file

4. Write the following code for the button that generates the QR Code:

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

5. Run the application and test it with a Barcode Scanner!
