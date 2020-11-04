package com.example.json_xml_parsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ParseJSONFile extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter<String>arrayAdapter;
    String student_array="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_jsonfile);

        byte[] buffer = new byte[0];
        listView=findViewById(R.id.list_view);
        InputStream is = null;

        try {
            is = getAssets().open("student.json");
            int size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();

            student_array=new String(buffer, "UTF-8");

            JSONObject jsonObject=new JSONObject(student_array);
            JSONArray jsonArray=jsonObject.getJSONArray("student");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject object=jsonArray.getJSONObject(i);
                String name=object.getString("name");
                String surname=object.getString("surname");
                int marks=object.getInt("marks");
                arrayList.add("First Name:"+name+"\nLast Name:"+surname+"\nPercentage:"+marks+"%");
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),arrayList.get(position),Toast.LENGTH_SHORT).show();
            }
        });

    }
}