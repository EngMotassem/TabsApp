package com.example.mac.tabsapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class CustomerDetails extends AppCompatActivity {
private TextView customer_name,customer_des,customer_address,customer_phone;
    private String cName,cDetails,cAddress,cPhone;

    private ImageButton phoneButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        cName=getIntent().getStringExtra("name");
        cDetails=getIntent().getStringExtra("details");
        cPhone=getIntent().getStringExtra("phone");

        customer_name=(TextView) findViewById(R.id.custnametxt);
        customer_des=(TextView) findViewById(R.id.customerdeatsilstxt);
        customer_phone=(TextView) findViewById(R.id.customerphonetxt);
       // customer_name=(TextView) findViewById(R.id.custnametxt);
        customer_name.setText(cName);
        customer_phone.setText(cPhone);
        customer_des.setText(cDetails);
        phoneButton=(ImageButton)findViewById(R.id.imageButton);
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Intent.ACTION_CALL );

                intent.setData( Uri.parse( "tel:"+cPhone ) );
                if (ActivityCompat.checkSelfPermission( getApplicationContext(), Manifest.permission.CALL_PHONE ) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity( intent );
            }
        });






    }
}
