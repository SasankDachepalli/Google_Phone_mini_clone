package com.example.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

import java.net.URI;

public class MainActivity2 extends AppCompatActivity {
TextView tv9,tv10,tv22,tv18,tv19;
Button b1,b2,b3,b6,b7;
ImageView img3,img6;
LinearLayout wll,ll2;
Chip chip2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        img6 = findViewById(R.id.imageView6);
        tv9 = findViewById(R.id.textView9);
        tv10 = findViewById(R.id.textView10);
        tv18 = findViewById(R.id.textView18);
        tv19 = findViewById(R.id.textView19);
        tv22 = findViewById(R.id.textView22);
        ll2 = findViewById(R.id.ll2);
        chip2 = findViewById(R.id.chip2);
        Intent i = getIntent();
        img6.setImageResource(R.drawable.contactp_round);
        String name = i.getStringExtra("name");
        String phone = i.getStringExtra("phone");
        int flag = i.getIntExtra("flag",0);
        String phn = "+91 "+phone;
        tv9.setText(name);
        tv18.setText(name);
        tv10.setText(phn);
        tv19.setText(phn);
        tv22.setText("Message "+phn);
        wll = findViewById(R.id.wachat);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        img3 = findViewById(R.id.imageView3);
        int r=0 ;
        String n;
        n = String.valueOf(name.toString().charAt(0));
        switch (n){
            case "A":
                r = R.drawable.a;
                break;
            case "B":
                r = R.drawable.b;
                break;
            case "C":
                r = R.drawable.c;
                break;
            case "D":
                r = R.drawable.d;
                break;
            case "E":
                r=R.drawable.e;
                break;
            case "J":
                r = R.drawable.j;
                break;
            case "K":
                r = R.drawable.k;
                break;
            case "M":
                r = R.drawable.m;
                break;
            case "N":
                r = R.drawable.n_round;
                break;
            case "P":
                r=R.drawable.p;
                break;
            case "R":
                r = R.drawable.r;
                break;
            case "S":
                r = R.drawable.s;
                break;
            case "U":
                r = R.drawable.u;
                break;
            case "V":
                r = R.drawable.v;
                break;
            case "Y":
                r=R.drawable.y;
                break;
            default:
                r =R.drawable.contactp_round;
        }
        img6.setImageResource(r);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String call = "tel:"+tv10.getText();
                Uri uri = Uri.parse(call);
                Intent i1 = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(i1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Intent.ACTION_SENDTO);
                String msg = tv10.getText().toString();
                i2.setData(Uri.parse("smsto:"+Uri.encode(msg)));
                i2.putExtra("sms-body","");
                startActivity(i2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Sorry,Video call not possible", Toast.LENGTH_SHORT).show();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String call = "tel:"+tv10.getText();
                Uri uri = Uri.parse(call);
                Intent i1 = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(i1);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Intent.ACTION_SENDTO);
                String msg = tv10.getText().toString();
                i2.setData(Uri.parse("smsto:"+Uri.encode(msg)));
                i2.putExtra("sms-body","");
                startActivity(i2);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Sorry,Video call not possible", Toast.LENGTH_SHORT).show();
            }
        });
        wll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://api.whatsapp.com/send?phone="+tv10.getText();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String call = "tel:"+tv10.getText();
                Uri uri = Uri.parse(call);
                Intent i1 = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(i1);
            }
        });
        chip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                Bundle b=new Bundle();
                b.putString("contact",tv9.getText().toString());
                intent.putExtra("bundle",b);
                Toast.makeText(MainActivity2.this,tv9.getText(), Toast.LENGTH_SHORT).show();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });
    }
}