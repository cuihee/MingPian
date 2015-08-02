package com.example.cuihe.mingpian;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RelativeLayout;


public class MyMingPian extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ming_pian);

        RelativeLayout rLayout = (RelativeLayout) findViewById(R.id.my_ming_pian_1);
        rLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.dota_fire));


        String display_name="崔鹤";
        EditText name = (EditText)this.findViewById(R.id.name);
        name.setText(display_name);

        String display_studentnumber="学号：3120000406";
        EditText studentnumber = (EditText)this.findViewById(R.id.studentnumber);
        studentnumber.setText(display_studentnumber);

        String display_phone="Phone：18937318681";
        EditText phone = (EditText)this.findViewById(R.id.phone);
        phone.setText(display_phone);

        String display_email="Email：18937318681@163.com";
        EditText email = (EditText)this.findViewById(R.id.email);
        email.setText(display_email);
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
