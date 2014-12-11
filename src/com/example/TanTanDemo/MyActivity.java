package com.example.TanTanDemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.util.ArrayList;


public class MyActivity extends Activity implements View.OnClickListener {

    //    private ArrayList<String> al;
    private ArrayList<CardModel> al;
    //    private ArrayAdapter<String> arrayAdapter;
    private MyCardAdapter mAdapter;
    //    private ArrayAdapter<String> arrayAdapter;
    private int i;

    SwipeFlingAdapterView flingContainer;
    private Button left;
    private Button right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);
        left = (Button) findViewById(R.id.left);
        right = (Button) findViewById(R.id.right);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
//        al = new ArrayList<String>();
//        al.add("php");
//        al.add("c");
//        al.add("python");
//        al.add("java");
//        al.add("html");
//        al.add("c++");
//        al.add("css");
//        al.add("javascript");
        al = new ArrayList<CardModel>();
        al.add(new CardModel("chh", 21, 4));
        al.add(new CardModel("ruansheng", 23, 6));
        al.add(new CardModel("java", 22, 1));
        al.add(new CardModel("html", 18, 2));
        al.add(new CardModel("c--", 18, 2));
//        arrayAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.helloText, al);
        mAdapter = new MyCardAdapter(this, al);

        flingContainer.setAdapter(mAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!" + mAdapter.getCount());
                mAdapter.getCount();
                al.remove(0);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                makeToast(MyActivity.this, "Left!");
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                makeToast(MyActivity.this, "Right!");
            }



            //没数据了，可以请求服务器获取数据
            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                al.add(new CardModel("name" + i, 24, 2));
                al.add(new CardModel("name" + i+1, 24, 2));
                mAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                makeToast(MyActivity.this, "Clicked!");
            }
        });

    }

    static void makeToast(Context ctx, String s) {
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left:
                flingContainer.getTopCardListener().selectLeft();
                break;
            case R.id.right:
                flingContainer.getTopCardListener().selectRight();
                break;
        }
    }
}
