package com.example.jorge_pc.seccion_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> names;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names=this.getAllNames();
        mRecyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        mLayoutManager=new LinearLayoutManager(this);

        mAdapter= new MyAdapter(names, R.layout.reycler_view_item, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                //Toast.makeText(MainActivity.this,name+"-"+position,Toast.LENGTH_LONG).show();
                deleteName(position);
            }
        });

        //performance
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
     getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.add_name:
                this.addName(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }


    }

    private void addName(int position) {
        names.add(position,"New name"+(++counter));
        mAdapter.notifyItemInserted(position);
        mLayoutManager.scrollToPosition(position);
    }

    private void deleteName(int position){
        names.remove(position);
        mAdapter.notifyItemRemoved(position);


    }

    private List<String> getAllNames(){
        return new ArrayList<String>(){{
            add("Juan");
            add("Jorge");
            add("Jose");
            add("Magaly");
            add("Monica");
            add("Andrea");
            add("Julio");

        }};
    }
}
