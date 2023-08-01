package com.example.phone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

public class CreateContactMA3 extends AppCompatActivity {
EditText etf,etl,etp;
Button b4;
ImageView img9,img12;
Chip chip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_ma3);
        Intent i = getIntent();
        img9 = findViewById(R.id.imageView9);
        img12 = findViewById(R.id.imageView12);
        chip = findViewById(R.id.chip);
//        b4 = findViewById(R.id.button4);
        etf = findViewById(R.id.editTextTextPersonName3);
        etl = findViewById(R.id.editTextTextPersonName4);
        etp = findViewById(R.id.editTextPhone2);
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CreateContactMA3.this,MainActivity.class);
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });
//        b4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(CreateContactMA3.this,MainActivity.class);
////                setResult(RESULT_OK,intent);
////                finish();
//                if((etp.getText().toString().trim().length() > 0) || (etf.getText().toString().trim().length() > 0)){
//                    Bundle b = new Bundle();
//                    b.putString("fname",etf.getText().toString());
//                    b.putString("lname",etl.getText().toString());
//                    b.putString("pno",etp.getText().toString());
//                    intent.putExtra("bundle",b);
//                    setResult(RESULT_OK,intent);
//                    finish();
//                }
//                else{
//                    setResult(RESULT_CANCELED,intent);
//                    finish();
//                }
//            }
//        });
        chip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateContactMA3.this,MainActivity.class);
//                setResult(RESULT_OK,intent);
//                finish();
                if((etp.getText().toString().trim().length() > 0) && (etf.getText().toString().trim().length() > 0)){
                    Bundle b = new Bundle();
                    b.putString("fname",etf.getText().toString());
                    b.putString("lname",etl.getText().toString());
                    b.putString("pno",etp.getText().toString());
                    intent.putExtra("bundle",b);
                    setResult(RESULT_OK,intent);
                    finish();
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateContactMA3.this);
                    builder.setMessage("Add info to save contact");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            builder.setCancelable(true);
                        }
                    });
                    builder.create();
                    builder.show();
                }
            }
        });
    }
}