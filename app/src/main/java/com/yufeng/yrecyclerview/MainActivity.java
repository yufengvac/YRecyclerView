package com.yufeng.yrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.interfaces.OnItemClickListener;
import com.aspsine.irecyclerview.interfaces.OnLoadMoreListener;
import com.aspsine.irecyclerview.interfaces.OnRefreshListener;
import com.yufeng.yrecyclerview.beans.Student;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private IRecyclerView iRecyclerView;
    private MyAdapter myAdapter;
    private int index = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iRecyclerView = (IRecyclerView) findViewById(R.id.iRecyclerView);
        iRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter();
        iRecyclerView.setIAdapter(myAdapter);


        iRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(){
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    initData();
                                }
                            });
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });


        iRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                new Thread(){
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                   loadMoreData();
                                }
                            });
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });

        myAdapter.setOnItemClickListener(new OnItemClickListener<Student>() {
            @Override
            public void onItemClick(int position, Student student, View v) {
                Toast.makeText(MainActivity.this,student.getName(),Toast.LENGTH_LONG).show();
            }
        });

        initData();
    }

    private void initData(){
        List<Student> list = new ArrayList<>();
        index = 1;
        for (int i= index; i < index + 20; i++){
            Student student = new Student();
            student.setId(i);
            student.setName(String.valueOf(getRandomChar())+String.valueOf(getRandomChar()));
            list.add(student);
        }
        myAdapter.setData(list);
        iRecyclerView.setRefreshing(false);
        index = index + 20;
    }

    private void loadMoreData(){
        if (index > 60){
            iRecyclerView.setLoadMoreState(null);
        }else {
            List<Student> list = new ArrayList<>();
            for (int i= index; i < index + 20; i++){
                Student student = new Student();
                student.setId(i);
                student.setName(String.valueOf(getRandomChar())+String.valueOf(getRandomChar()));
                list.add(student);
            }
            myAdapter.addData(list);
            index = index + 20;
        }

    }

    private char getRandomChar() {
        String str = "";
        int hightPos;
        int lowPos;

        Random random = new Random();

        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str.charAt(0);
    }
}
