package com.example.phone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    Button favourites, recents, contacts;
    int flag=0;
    int flag2=0;
    int k=0;
    String newname="";
    String newno="";
    RecyclerView rv1, rv2, rv3;
    GridView fgv;
    ScrollView sv2;
    LinearLayout fll, createc,rll;
    ImageView img, img2;
    TextView tv4,tv26;
    String names[] = {"Yudhistir", "Duryodhana", "Bhima", "Arjuna", "Dushasana", "Vikarna", "Chitrasena", "Upachitran", "Suvarma", "Dussaha", "Jalagandha", "Sama", "Saha", "Vindha", "Anuvindha", "Durdharsha", "Subahu", "Dushpradarshan", "Durmarshan", "Durmukha", "Dushkarna", "Karna", "Salan", "Sathwa", "Sulochan", "Chithra", "Chitraksha", "Charuchithra", "Sarasana", "Durmada", "Durviga", "Vivitsu", "Viktana", "Urnanabha", "Sunabha", "Nanda", "Upananda", "Chitravarma", "Suvarma", "Durvimochan", "Ayobahu", "Mahabahu", "Chitranga", "Chitrakundala", "Bhimvega", "Bhimba", "Balaki", "Balvardhana", "Ugrayudha", "Sushena", "Kundhadhara", "Mahodara", "Chithrayudha", "Nishangi", "Pashi", "Vridaraka", "Dridhavarma", "Dridhakshatra", "Somakirti", "Anudara", "Dridasandha", "Jarasangha", "Sathyasandha", "Sadas", "Suvak", "Ugrasarva", "Ugrasena", "Senani", "Dushparajai", "Aparajit", "Kundusai", "Vishalaksha", "Duradhara", "Dridhahastha", "Suhastha", "Vatvega", "Suvarcha", "Aadiyaketu", "Bahvasi", "Nagaadat", "Agrayayi", "Kavachi", "Kradhan", "Kundi", "Kundadhara", "Dhanurdhara", "Bhimaratha", "Virabahi", "Alolupa", "Abhaya", "Raudrakarma", "Dhridarathasraya", "Anaghrushya", "Kundhabhedi", "Viravi", "Chitrakundala", "Dirghlochan", "Pramati", "Veeryavan", "Dirgharoma", "Dirghabhu", "Kundashi", "Virjasa", "Nakula", "Sahadeva", "Dusala"};
    String unumbers[] = {"900000001", "900000002", "900000003", "900000004", "900000005", "900000006", "900000007", "900000008", "900000009", "900000010", "900000011", "900000012", "900000013", "900000014", "900000015", "900000016", "900000017", "900000018", "900000019", "900000020", "900000021", "900000022", "900000023", "900000024", "900000025", "900000026", "900000027", "900000028", "900000029", "900000030", "900000031", "900000032", "900000033", "900000034", "900000035", "900000036", "900000037", "900000038", "900000039", "900000040", "900000041", "900000042", "900000043", "900000044", "900000045", "900000046", "900000047", "900000048", "900000049", "900000050", "900000051", "900000052", "900000053", "900000054", "900000055", "900000056", "900000057", "900000058", "900000059", "900000060", "900000061", "900000062", "900000063", "900000064", "900000065", "900000066", "900000067", "900000068", "900000069", "900000070", "900000071", "900000072", "900000073", "900000074", "900000075", "900000076", "900000077", "900000078", "900000079", "900000080", "900000081", "900000082", "900000083", "900000084", "900000085", "900000086", "900000087", "900000088", "900000089", "900000090", "900000091", "900000092", "900000093", "900000094", "900000095", "900000096", "900000097", "900000098", "900000099", "900000100", "900000101", "900000102", "900000103", "900000104", "900000105", "900000106"};
    String favourite[] = {"Arjuna", "Yudhistir", "Bhima", "Vikarna", "Dusala"};
    String frequentnos[] = new String[5];
    String frequentname[]=new String[5];
    String fnumbers[] = new String[favourite.length];
    int fimage[] = new int[favourite.length];
    String array1[] = {"Yudhistir", "Duryodhana", "Bhima", "Arjuna", "Dushasana", "Vikarna", "Chitrasena", "Upachitran", "Suvarma", "Dussaha", "Jalagandha", "Sama", "Saha", "Vindha", "Anuvindha", "Durdharsha", "Subahu", "Dushpradarshan", "Durmarshan", "Durmukha", "Dushkarna", "Karna", "Salan", "Sathwa", "Sulochan", "Chithra", "Chitraksha", "Charuchithra", "Sarasana", "Durmada", "Durviga", "Vivitsu", "Viktana", "Urnanabha", "Sunabha", "Nanda", "Upananda", "Chitravarma", "Suvarma", "Durvimochan", "Ayobahu", "Mahabahu", "Chitranga", "Chitrakundala", "Bhimvega", "Bhimba", "Balaki", "Balvardhana", "Ugrayudha", "Sushena", "Kundhadhara", "Mahodara", "Chithrayudha", "Nishangi", "Pashi", "Vridaraka", "Dridhavarma", "Dridhakshatra", "Somakirti", "Anudara", "Dridasandha", "Jarasangha", "Sathyasandha", "Sadas", "Suvak", "Ugrasarva", "Ugrasena", "Senani", "Dushparajai", "Aparajit", "Kundusai", "Vishalaksha", "Duradhara", "Dridhahastha", "Suhastha", "Vatvega", "Suvarcha", "Aadiyaketu", "Bahvasi", "Nagaadat", "Agrayayi", "Kavachi", "Kradhan", "Kundi", "Kundadhara", "Dhanurdhara", "Bhimaratha", "Virabahi", "Alolupa", "Abhaya", "Raudrakarma", "Dhridarathasraya", "Anaghrushya", "Kundhabhedi", "Viravi", "Chitrakundala", "Dirghlochan", "Pramati", "Veeryavan", "Dirgharoma", "Dirghabhu", "Kundashi", "Virjasa", "Nakula", "Sahadeva", "Dusala"};
    LinearLayout contactll, favouritell;
    ArrayList<String> ALnames = new ArrayList<>();
    ArrayList<String> ALnumbers = new ArrayList<>();
    ArrayList<Integer> ALflags = new ArrayList<>();
    ArrayList<String> ALrecents = new ArrayList<>();
    ArrayList<String> ALfavourites = new ArrayList<>();
    ArrayList<String> ALrecentno = new ArrayList<>();
    ArrayList<String> ALfrequent = new ArrayList<>();
    ArrayList<Integer> ALfrequency = new ArrayList<>();
    int flags[] = new int[ALnames.size()];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        array = array1;

        favourites = findViewById(R.id.Button1);
        rll = findViewById(R.id.recentsll);
        fgv = findViewById(R.id.favgv);
        fgv.setAdapter(new NewAdapter(this));
        createc = findViewById(R.id.createc);
        recents = findViewById(R.id.Button2);
        img = findViewById(R.id.imageView);
        sv2 = findViewById(R.id.scrollView2);
        tv4 = findViewById(R.id.textView4);
        tv26 = findViewById(R.id.textView26);
        contacts = findViewById(R.id.Button3);
        contactll = findViewById(R.id.contactsll);
        favouritell = findViewById(R.id.favouritesll);
        for(int i=0;i<array1.length;i++){
            int flag2 = 0;
            for(int j=0;j<ALnames.size();j++){
                if(array1[i]==ALnames.get(j)){
                    flag2=1;
                    break;
                }
            }
            if(flag2==0){
                ALnames.add(array1[i]);
                ALnumbers.add(unumbers[i]);
            }
        }

        createc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,CreateContactMA3.class);
                startActivityForResult(i,1);
            }
        });
        rv1 = findViewById(R.id.contactsrv);
        rv2 = findViewById(R.id.favouritesrv);
        rv3 = findViewById(R.id.recentsrv);
        recents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rv3.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rv3.setAdapter(new MyAdapter3(MainActivity.this));
                rll.setVisibility(View.VISIBLE);
                createc.setVisibility(View.INVISIBLE);
                favouritell.setVisibility(View.INVISIBLE);
                sv2.setVisibility(View.INVISIBLE);
                contactll.setVisibility(View.INVISIBLE);
            }
        });
        favourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < favourite.length; i++) {
                    for (int j = 0; j < ALnames.size(); j++) {
                        if (favourite[i] == ALnames.get(j)) {
                            fnumbers[i] = ALnumbers.get(j);
                            fimage[i] = getImage(favourite[i]);
                        }
                    }
                }
                favouritell.setVisibility(View.VISIBLE);
                createc.setVisibility(View.INVISIBLE);
                rll.setVisibility(View.INVISIBLE);
//                tv4.setVisibility(View.INVISIBLE);
                sv2.setVisibility(View.VISIBLE);
                contactll.setVisibility(View.INVISIBLE);
                rv2.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rv2.setAdapter(new MyAdapter2(MainActivity.this));
            }
        });
        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rv1.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rv1.setAdapter(new MyAdapter(MainActivity.this));
//                String array[] =new String[array1.length+k] ;

                createc.setVisibility(View.VISIBLE);
//                tv4.setVisibility(View.VISIBLE);

                for(int i=ALnames.size()-1;i>=0;i--){
                    ALnames.remove(i);
                    ALnumbers.remove(i);
                }
                for(int i=0;i<array1.length;i++){
                    int flag2 = 0;
                    for(int j=0;j<ALnames.size();j++){
                        if(array1[i]==ALnames.get(j)){
                            flag2=1;
                            break;
                        }
                    }
                    if(flag2==0){
                        ALnames.add(array1[i]);
                        ALnumbers.add(unumbers[i]);
                    }
                }

                if(newname.isEmpty()){

                }
                else{
                    for(int i=0;i<ALnames.size();i++){
                        if (ALnames.get(i)==newname){
                            flag=1;
                            break;
                        }
                        else{

                        }
                    }
                    if (flag == 0) {
                        ALnames.add(newname);
                        ALnumbers.add(newno);
                    }
                }
                String Aname[] = new String[ALnames.size()];
                String Ano[] = new String[ALnumbers.size()];
                for(int j=0;j<ALnames.size();j++){
                    Aname[j]=ALnames.get(j);
                    Ano[j] = ALnumbers.get(j);
                }
                Arrays.sort(Aname);
                String sno[] = new String[Ano.length];
                for(int k=0;k<Ano.length;k++){
                    for(int j=0;j<=Aname.length;j++){
                        if(Aname[k]==ALnames.get(j)){
                            sno[k]=Ano[j];
                            break;
                        }
                    }
                }
                for(int i=ALnames.size()-1;i>=0;i--){
                    ALnames.remove(i);
                    ALnumbers.remove(i);
                }
                for(int i=0;i<Aname.length;i++){
                    ALnames.add(Aname[i]);
                    ALnumbers.add(sno[i]);
                }

                sv2.setVisibility(View.INVISIBLE);
                favouritell.setVisibility(View.INVISIBLE);
                rll.setVisibility(View.INVISIBLE);
                contactll.setVisibility(View.VISIBLE);
            }
        });
        contactll.setVisibility(View.VISIBLE);
    }
    private int getImage(String s) {
        int chrimg=0;
        for (int i = 0; i < s.length(); i++) {
            int r = 0;
            String chr = String.valueOf(s.charAt(0));
            switch (chr) {
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
                    r = R.drawable.e;
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
                    r = R.drawable.p;
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
                    r = R.drawable.y;
                    break;
                default:
                    r = R.drawable.contactp_round;
            }
            chrimg = r;
        }
        return chrimg;
    }

    private class MyAdapter extends RecyclerView.Adapter<MyHolder> {
        Context mycontext;

        public MyAdapter(MainActivity mainActivity) {
            mycontext = mainActivity;
        }
        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mycontext).inflate(R.layout.contacts, parent, false);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            String delname = tv26.getText().toString();
            for(int i=0;i<ALnames.size();i++){
                if(ALnames.get(i)==delname){
                    ALnames.remove(i);
                    ALnumbers.remove(i);
                    break;
                }
            }
            holder.tv2.setText(ALnames.get(position));
            holder.tv11.setText(ALnumbers.get(position));
            holder.img8.setImageResource(getImage(ALnames.get(position)));
//            holder.imgs.setImageResource(ALflags.get(position));
//            if(ALnames.size()==0){
//                holder.tv29.setText("");
//            }
//            else{
//                holder.tv29.setText(String.valueOf(flags[position]));
//            }
//            holder.tv11.setText(String.valueOf(position));
        }
        @Override
        public int getItemCount() {
            return ALnames.size();
        }
    }


    private class MyHolder extends RecyclerView.ViewHolder {
        TextView tv2, tv11, tv,tv29;
        EditText et;
        ImageView img8,imgs;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.textView);
            tv2 = itemView.findViewById(R.id.textView2);
            tv29 = itemView.findViewById(R.id.textView29);
            et = itemView.findViewById(R.id.etp);
            tv11 = itemView.findViewById(R.id.textView11);
            img8 = itemView.findViewById(R.id.imageView8);
            imgs = itemView.findViewById(R.id.imageViewstar);
            tv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i2 = new Intent(MainActivity.this, MainActivity2.class);
                    Bundle b = new Bundle();
                    i2.putExtra("name", tv2.getText().toString());
                    i2.putExtra("phone", tv11.getText().toString());
                    i2.putExtra("flag", 1);
//                    i.putExtra("img",img8.getResources().toString());
                    startActivityForResult(i2,11);
                }
            });
            imgs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

    private class MyAdapter2 extends RecyclerView.Adapter<MyHolder2> {
        Context mycontext2;

        public MyAdapter2(MainActivity mainActivity) {
            mycontext2 = mainActivity;
        }

        @NonNull
        @Override
        public MyHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mycontext2).inflate(R.layout.favouritesl, parent, false);
            return new MyHolder2(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder2 holder, int position) {
            String recentp[] = new String[ALrecentno.size()];
            for(int i=0;i<ALrecentno.size();i++){
                recentp[i]=ALrecentno.get(i);
            }
                holder.img2.setVisibility(View.VISIBLE);
                holder.tv2.setText(favourite[position]);
                holder.tv8.setText(fnumbers[position]);
                holder.img7.setImageResource(getImage(favourite[position]));
        }

        @Override
        public int getItemCount() {
            return favourite.length;
        }
    }


    private class MyHolder2 extends RecyclerView.ViewHolder {
        TextView tv2, tv8;
        ImageView img7,img2;

        public MyHolder2(@NonNull View itemView) {
            super(itemView);
            fll = itemView.findViewById(R.id.favll);
            tv2 = itemView.findViewById(R.id.textView7);
            tv8 = itemView.findViewById(R.id.textView8);
            img2 = itemView.findViewById(R.id.imageView2);
            img7 = itemView.findViewById(R.id.imageView7);
//            img7.setImageResource(R.drawable.contactp_round);
            img7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("name", tv2.getText().toString());
                    i.putExtra("phone", tv8.getText().toString());
                    startActivity(i);
                }
            });
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String number = "tel:" + tv8.getText();
                    ALrecentno.add(tv8.getText().toString());
                    Uri uri = Uri.parse(number);
                    Intent it = new Intent(Intent.ACTION_DIAL, uri);
                    startActivity(it);
                }
            });
            fll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("name", tv2.getText().toString());
                    i.putExtra("phone", tv8.getText().toString());
                    startActivity(i);
                }
            });
        }
    }

    private class NewAdapter extends BaseAdapter {
        Context c;

        public NewAdapter(MainActivity mainActivity) {
            c = mainActivity;
        }

        @Override
        public int getCount() {
            return favourite.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v1 = LayoutInflater.from(c).inflate(R.layout.favlayout, viewGroup, false);
//            v1.setLayoutParams(new GridLayout.LayoutParams());
            v1.setPadding(20, 0, 20, 0);
            ImageView fimg = v1.findViewById(R.id.imageView14);
            TextView t20 = v1.findViewById(R.id.textView20);
            t20.setText(favourite[i]);
            fimg.setImageResource(getImage(favourite[i]));
            v1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String num = "tel:" + fnumbers[i];
                    ALrecentno.add(fnumbers[i]);
                    Uri uri = Uri.parse(num);
                    Intent i = new Intent(Intent.ACTION_DIAL, uri);
                    startActivity(i);
                }
            });
            return v1;
        }
    }

    private class MyAdapter3 extends RecyclerView.Adapter<MyHolder3> {
        Context mycontext3;

        public MyAdapter3(MainActivity mainActivity) {
            mycontext3 = mainActivity;
        }

        @NonNull
        @Override
        public MyHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mycontext3).inflate(R.layout.favouritesl, parent, false);
            return new MyHolder3(view);
        }
        @Override
        public void onBindViewHolder(@NonNull MyHolder3 holder, int p) {
            int alns=ALrecentno.size();
            String rname="";
            for(int k=0;k<ALnumbers.size();k++){
                if(ALrecentno.get(alns-p-1)==ALnumbers.get(k)){
                    rname = ALnames.get(k);
                    break;
                }
            }
            holder.tv2.setText(rname);
            holder.tv8.setText(ALrecentno.get(alns-p-1));
            holder.img7.setImageResource(getImage(rname));
        }

        @Override
        public int getItemCount() {
            return ALrecentno.size();
        }
    }

    private class MyHolder3 extends RecyclerView.ViewHolder {
        TextView tv2, tv8;
        ImageView img7;
        public MyHolder3(@NonNull View itemView) {
            super(itemView);
            fll = itemView.findViewById(R.id.favll);
            tv2 = itemView.findViewById(R.id.textView7);
            tv8 = itemView.findViewById(R.id.textView8);
            img2 = itemView.findViewById(R.id.imageView2);
            img7 = itemView.findViewById(R.id.imageView7);
            img7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("name", tv2.getText().toString());
                    i.putExtra("phone", tv8.getText().toString());
                    startActivity(i);
                }
            });
            img7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("name", tv2.getText().toString());
                    i.putExtra("phone", tv8.getText().toString());
                    startActivity(i);
                }
            });
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String number = "tel:" + tv8.getText();
                    ALrecentno.add(tv8.getText().toString());
                    Uri uri = Uri.parse(number);
                    Intent it = new Intent(Intent.ACTION_DIAL, uri);
                    startActivity(it);
                }
            });
            fll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("name", tv2.getText().toString());
                    i.putExtra("phone", tv8.getText().toString());
                    startActivity(i);
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if (resultCode==RESULT_OK){
                Bundle b=data.getBundleExtra("bundle");
                String fname =b.getString("fname");
                String lname =b.getString("lname");
                String pno =b.getString("pno");
                String name = fname+" "+lname;
                k=k+1;
                newname=name;
//                names1[names1.length-1]=name;
                newno=pno;
            }
        }
        else if(requestCode==1){
            if(resultCode==RESULT_CANCELED){
                Bundle b=data.getBundleExtra("bundle");
                String dname = b.getString("contact");
                for(int i=0;i<ALnames.size();i++){
                    if(dname==ALnames.get(i)){
                        ALnames.remove(i);
                        ALnumbers.remove(i);
                    }
                }
                tv26.setText(dname);
            }
        }
    }
}
