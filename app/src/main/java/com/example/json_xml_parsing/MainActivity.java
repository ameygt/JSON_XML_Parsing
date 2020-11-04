package com.example.json_xml_parsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
    }

    public void parseXML(View view){

        Intent intent=new Intent(MainActivity.this,ParseXMLFile.class);
        startActivity(intent);

    }

    public void parseJSON(View view){
        Intent intent=new Intent(MainActivity.this,ParseJSONFile.class);
        startActivity(intent);
    }
}
