package com.hckim.myapplication.adapterview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hckim.myapplication.R;

import java.util.List;

/**
 * Created by K on 2017-08-07.
 */

public class PeopleAdapter extends BaseAdapter { // (1) Alt Enter Implement methods -> @Override 4개

//    @Override
//    public int getCount() {
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        return null;
//    }

    private final List<People> mData; // (3)의 결과
    private final Context mContext; // B(2)의 결과

    public PeopleAdapter(Context context, List<People> data) { // (2) Ctrl N Constructor B(1) Context context 추가
        mData = data; // (3) Alt Enter Create field 'mData'
        mContext = context; // B(2) Create field 'mContext'
    }

    // 데이터 갯수
    @Override
    public int getCount() {
        return mData.size(); // (4)
    }

    // position 번째에 어떤 아이템이 있는지 알려 줘야 함
    @Override
    public Object getItem(int position) {
        return mData.get(position); // (5)
    }

    // 데이터베이스의 id 관련
    @Override
    public long getItemId(int position) {
        return position; // (6)
    }

    // position 번째의 레이아웃 완성해서 알려 줘야 함
    // convertView: position 번째 레이아웃의 레퍼런스
    // parent: 이 어댑터가 붙을 부모의 레퍼런스(ListView 또는 GridView)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder; // C(2)
        if (convertView == null) {
            // 최초
            // 레이아웃 가져오기
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.item_exam, parent, false); // B(3) -> item_exam.xml id 3개
            holder = new ViewHolder(); // C(3)
            ImageView imageView = (ImageView) convertView.findViewById(R.id.image_view); // B(4)
            TextView nameTextView = (TextView) convertView.findViewById(R.id.name_text); // B(5)
            TextView phoneTextView = (TextView) convertView.findViewById(R.id.phone_text); // B(6)
            holder.image = imageView; // C(4)
            holder.name = nameTextView;
            holder.phone = phoneTextView;

            convertView.setTag(holder); // C(5)

        } else {
            // 재사용
            holder = (ViewHolder) convertView.getTag(); // C(6)
        }

        // data
        People people = (People) getItem(position); // C(7)

        //뿌리기
        holder.image.setImageResource(people.getPicture()); // C(8)
        holder.name.setText(people.getName());
        holder.phone.setText(people.getPhone());

        return convertView;
    }

    private static class ViewHolder { // C(1)
        ImageView image;
        TextView name;
        TextView phone;
    }
}
