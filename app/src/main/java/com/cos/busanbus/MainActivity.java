package com.cos.busanbus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;

import lombok.val;

public class MainActivity extends AppCompatActivity {

    private EditText mBusEditText;
    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBusEditText = findViewById(R.id.busEdit);
        mResult = findViewById(R.id.result);


        final BusDb db = Room.databaseBuilder(this,BusDb.class,"Bus-db")
                .allowMainThreadQueries()
                .build();

        mResult.setText(db.busDao().findAll().toString());

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*db.busDao().insert(new Bus(mBusEditText.getText().toString()));
                mResult.setText(db.busDao().findAll().toString());*/
            }
        });

    }

    public void readCSV(String filePath) throws IOException {
        CSVReader cr = new CSVReader(new FileReader(filePath));
        String [] nextLine;
        while ((nextLine = cr.readNext()) != null){
            for(int i=0; i<nextLine.length; i++){
                System.out.println(nextLine[i]);
            }
            System.out.println();
        }
    }
}