package com.hckim.myapplication.adapterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.hckim.myapplication.R;

import java.util.ArrayList;

public class AdapterViewExamActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_adapter_view_exam);
//
//        // View
//        ListView listView = (ListView) findViewById(R.id.list_view);
//
//        // Data
//        ArrayList<String> data = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            data.add("데이터 " + i);
//        }
//
//        // Adapter
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AdapterViewExamActivity.this,
//                android.R.layout.simple_list_item_1,
//                data);
//
//        listView.setAdapter(adapter);
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_exam);

        // View
        ListView listView = (ListView) findViewById(R.id.list_view);

        // Data
//        final ArrayList<People> data = new ArrayList<>();
        ArrayList<People> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int picture;
            if (i % 2 == 0) {
                picture = R.drawable.federer;
            } else {
                picture = R.mipmap.ic_launcher;
            }
            People people = new People("아무개 " + i, "전화번호 " + i, picture);
            data.add(people);
        }

        // Adapter
//        ArrayAdapter<People> adapter = new ArrayAdapter<People>(AdapterViewExamActivity.this,
//                android.R.layout.simple_list_item_1,
//                data); // 다시 만들어야 함
        PeopleAdapter adapter = new PeopleAdapter(AdapterViewExamActivity.this, data);

        listView.setAdapter(adapter);
//        gridView.setAdapter(adapter);
//        spinner.setAdapter(adapter);

        // OnItemClickListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // B(1) new On... enter
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(AdapterViewExamActivity.this, "" + position, Toast.LENGTH_SHORT).show();
//                People people = data.get(position); // 빨간 줄. 위(// Data) 다음 final 붙임<방법 1>
                People people = (People) parent.getAdapter().getItem(position); // Alt Enter Cast to... Enter (people) 생김<방법 2>
//                data.get(position); // <방법 3> Alt Enter Make 'data' final
                Toast.makeText(AdapterViewExamActivity.this, people.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
