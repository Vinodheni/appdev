package com.myname.tryy;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.searchactivity.R;

public class MainActivity extends Activity {

    private ListView listview;
    ArrayAdapter<String> adapter;
    EditText Search;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String programming_languages[] = { "Pyhton", "C", "C++", "Java", "C#", "JavaScript",
                "XML", "HTML5", "Operating Systems", "Android", "Windows",
                "PHP", "Mongodb", "SQL" };

        listview = (ListView) findViewById(R.id.listview);
        Search = (EditText) findViewById(R.id.input);

        adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.item,
                programming_languages);
        listview.setAdapter(adapter);

        Search.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2,
                                      int arg3) {
                // When user changed the Text
                MainActivity.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });
    }
}