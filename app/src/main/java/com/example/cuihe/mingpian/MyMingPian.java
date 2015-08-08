package com.example.cuihe.mingpian;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.Hashtable;
import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


public class MyMingPian extends ActionBarActivity {

    public String display_name="崔鹤";
    public String display_studentnumber="3120000406";
    public String display_phone="18937318681";
    public String display_email="18937318681@163.com";
    public String url = "BEGIN:VCARD\nN:"+display_name + "\nNOTE:SN:" + display_studentnumber + "\nTEL:" + display_phone + "\nEMAIL:" + display_email+"\nEND:VCARD ";

    public EditText phone;
    public EditText name;
    public EditText studentnumber;
    public EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ming_pian);

        RelativeLayout rLayout = (RelativeLayout) findViewById(R.id.my_ming_pian_1);
//        rLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.dota_fire));
        rLayout.setBackgroundResource(R.drawable.dota_fire);

        name= (EditText)super.findViewById(R.id.name);
        name.setText(display_name);

        studentnumber = (EditText)super.findViewById(R.id.studentnumber);
        studentnumber.setText(display_studentnumber);

        phone = (EditText)super.findViewById(R.id.phone);
        phone.setText(display_phone);

        email = (EditText)super.findViewById(R.id.email);
        email.setText(display_email);

        createQR(url);

        Button btn_create_QR = (Button)this.findViewById(R.id.btn_create_qrcode);
        btn_create_QR.setOnClickListener(new QROnClickListener());

    }
    private class QROnClickListener implements View.OnClickListener {
        public void onClick(View v) {
            display_name=name.getText().toString();
            display_studentnumber=studentnumber.getText().toString();
            display_phone=phone.getText().toString();
            display_email=email.getText().toString();
            url = "BEGIN:VCARD\nN:"+display_name + "\nNOTE:SN:" + display_studentnumber + "\nTEL:" + display_phone + "\nEMAIL:" + display_email+"\nEND:VCARD ";

            createQR(url);
        }
    }
    public void createQR(String url){
        try {
            int QR_WIDTH = 300, QR_HEIGHT = 300;

            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            ImageView QRimg = (ImageView) findViewById(R.id.QR);
            BitMatrix bitMatrix = new QRCodeWriter().encode(url, BarcodeFormat.QR_CODE, QR_WIDTH, QR_HEIGHT, hints);
            int[] pixels = new int[QR_WIDTH * QR_HEIGHT];
            //下面这里按照二维码的算法，逐个生成二维码的图片，
            //两个for循环是图片横列扫描的结果
            for (int y = 0; y < QR_HEIGHT; y++) {
                for (int x = 0; x < QR_WIDTH; x++) {
                    if (bitMatrix.get(x, y)) {
                        pixels[y * QR_WIDTH + x] = 0xff000000;
                    } else {
                        pixels[y * QR_WIDTH + x] = 0xffffffff;
                    }
                }
            }
            //生成二维码图片的格式，使用ARGB_8888
            Bitmap bitmap = Bitmap.createBitmap(QR_WIDTH, QR_HEIGHT, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, QR_WIDTH, 0, 0, QR_WIDTH, QR_HEIGHT);
            //显示到一个ImageView上面
            QRimg.setImageBitmap(bitmap);
        }catch (WriterException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_ming_pian, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
