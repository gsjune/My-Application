package com.hckim.myapplication.adapterview;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.hckim.myapplication.R;

import java.util.ArrayList;

public class AdapterViewExamActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    private static final String TAG = AdapterViewExamActivity.class.getSimpleName(); // C(1)의 결과
    private ArrayList<People> mPeopleData; // F(4)의 결과
    private PeopleAdapter mAdapter; // F(6)의 결과
    private EditText mWeatherEditText; // G(1)의 결과

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
//        ArrayList<People> data = new ArrayList<>(); // Find Action field Enter 결과 F(4)
        mPeopleData = new ArrayList<>(); // F(4)
        for (int i = 0; i < 100; i++) {
            int picture;
            if (i % 2 == 0) {
                picture = R.drawable.federer;
            } else {
                picture = R.mipmap.ic_launcher;
            }
            People people = new People("아무개 " + i, "전화번호 " + i, picture);
            mPeopleData.add(people);
        }

        // Adapter
//        ArrayAdapter<People> adapter = new ArrayAdapter<People>(AdapterViewExamActivity.this,
//                android.R.layout.simple_list_item_1,
//                data); // 다시 만들어야 함
//        PeopleAdapter adapter = new PeopleAdapter(AdapterViewExamActivity.this, mPeopleData); // Find Action field Enter 결과 F(6)
        mAdapter = new PeopleAdapter(AdapterViewExamActivity.this, mPeopleData); // F(6)

        listView.setAdapter(mAdapter);
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
//                Toast.makeText(AdapterViewExamActivity.this, people.toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(AdapterViewExamActivity.this, "그냥 클릭", Toast.LENGTH_SHORT).show();
//                Log.d(TAG, "onItemClick: " + people.toString()); // debug C(1) Alt Enter Create constant field 'TAG'
//                Log.e(TAG, "onItemClick: 에러"); // error
//                Log.i(TAG, "onItemClick: 정보"); // information
//                Log.w(TAG, "onItemClick: 경고"); // warning

                Intent intent = new Intent(AdapterViewExamActivity.this, DetailAddressActivity.class); // E(1) 데이터 전달
                intent.putExtra("name", people.getName());
                intent.putExtra("phone", people.getPhone());
                intent.putExtra("picture", people.getPicture());
                startActivity(intent);
            }
        });

//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // D(1) new O... Enter
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(AdapterViewExamActivity.this, "롱 클릭", Toast.LENGTH_SHORT).show();
//                return true; // 이벤트 소비를 제어. 이벤트 소비를 하겠다. 더 이상 이벤트가 흘러가지 않는다.
//           }
//        });

        // Context 메뉴 연결
        registerForContextMenu(listView); // F(2) 롱클릭과 같이 쓸 수 없다(롱클릭 주석 처리)

        // SharedPreference 데이터 복원
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this); // G(1)
        String weather = settings.getString("weather", "맑음");

        mWeatherEditText = (EditText) findViewById(R.id.weather_edit);
        mWeatherEditText.setText(weather);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // E(1)
        // Inflate the menu; this adds items to the action bar if it is present.
        // 메뉴버튼이 처음 눌러졌을 때 실행되는 콜백메서드
        // 메뉴버튼을 눌렀을 때 보여줄 menu 에 대해서 정의
        getMenuInflater().inflate(R.menu.menu_address, menu);
        Log.d("test", "onCreateOptionsMenu - 최초 메뉴키를 눌렀을 때 호출됨");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 메뉴의 항목을 선택(클릭)했을 때 호출되는 콜백메서드
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Log.d("test", "onOptionsItemSelected - 메뉴항목을 클릭했을 때 호출됨");

        int id = item.getItemId();

        switch (id) {
            case R.id.action_add:
                Intent intent = new Intent(AdapterViewExamActivity.this,
                        DetailAddressActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) { // F(1) ALt Enter (Import class)
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_coffee, menu); // menu_coffee로 바꿈
    }

//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo(); // ALt Enter (Import class)
//        switch (item.getItemId()) {
//            case R.id.action_item1:
//                Toast.makeText(this, "action 1", Toast.LENGTH_SHORT).show();
//                // 삭제
//                mPeopleData.remove(info.position); // F(3) F(5)
//                // 업데이트
//                mAdapter.notifyDataSetChanged();
//                return true;
//            case R.id.action_item2:
//                Toast.makeText(this, "action 2", Toast.LENGTH_SHORT).show();
//                return true;
//            default:
//                return super.onContextItemSelected(item);
//        }
//    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.action_item1:
                Toast.makeText(this, "action 1", Toast.LENGTH_SHORT).show();

//                // 물어보자 AlertDialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(this); // H(1)
//                builder.setTitle("삭제");
//                builder.setMessage("정말로 삭제하시겠습니까?");
//                builder.setCancelable(false);
////                builder.setPositiveButton("삭제", null);
//                builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() { // H(2) new On... Enter
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // 삭제
//                        mPeopleData.remove(info.position); // H(3) 이동. info 빨간 줄 Alt Enter Make 'info' final
//                        // 업데이트
//                        mAdapter.notifyDataSetChanged();
//                    }
//                });
//                builder.setNegativeButton("아니오", this); // H(4) 맨 위 implements DialogInterface.OnClickListener
//                builder.setIcon(R.drawable.federer); // 큰 그림은 넣으면 안됨
//
//                builder.create().show();
//
////                // 삭제
////                mPeopleData.remove(info.position);
////                // 업데이트
////                mAdapter.notifyDataSetChanged(); // 복잡해서 메소드로 뺌
                showDefaultDialog(info); // H(5)
                return true;
            case R.id.action_item2:
                Toast.makeText(this, "action 2", Toast.LENGTH_SHORT).show();
                showCustomDialog(); // H(6) Alt Enter Create method 'showCustomDialog'
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void showCustomDialog() { // H(6)의 결과
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View view = getLayoutInflater().inflate(R.layout.dialog_signin, null, false);
        builder.setView(view);
//        builder.create().show(); // 수정
        final AlertDialog dialog = builder.create();

        view.findViewById(R.id.positive_button).setOnClickListener(new View.OnClickListener() { // H(7) 추가 new On... Enter
            @Override
            public void onClick(View v) {
                Toast.makeText(AdapterViewExamActivity.this, "잘 눌림", Toast.LENGTH_SHORT).show();

                // 다이얼로그 닫기
                dialog.dismiss();
            }
        });
        view.findViewById(R.id.negative_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

//        builder.setView(view);
//        builder.create().show(); // 위로 이동 및 수정
    }

    private void showDefaultDialog(final AdapterView.AdapterContextMenuInfo info) { // H(5)의 결과
        // 물어보자 AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this); // H(1)
        builder.setTitle("삭제");
        builder.setMessage("정말로 삭제하시겠습니까?");
        builder.setCancelable(false);
//                builder.setPositiveButton("삭제", null);
        builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() { // H(2) new On... Enter
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 삭제
                mPeopleData.remove(info.position); // H(3) 이동. info 빨간 줄 Alt Enter Make 'info' final
                // 업데이트
                mAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("아니오", this); // H(4) 맨 위 implements DialogInterface.OnClickListener
        builder.setIcon(R.drawable.federer); // 큰 그림은 넣으면 안됨

        builder.create().show();

//                // 삭제
//                mPeopleData.remove(info.position);
//                // 업데이트
//                mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() { // G(2)
        // 저장
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("weather", mWeatherEditText.getText().toString());

        // Commit the edits! 비동기
        editor.apply();

        // 뒤로 가기
        super.onBackPressed();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) { // H(4)의 결과 생김

    }
}
