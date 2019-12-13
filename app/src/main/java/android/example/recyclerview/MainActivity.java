package android.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;                  //filling RV
    private RecyclerView.LayoutManager layoutManager;      //placement of items
    boolean isChanged = true;
    boolean isLight = true;
    final ArrayList<RecyclerViewItem> recyclerViewItems = new ArrayList<>();
    final ArrayList<RecyclerViewItem> recyclerViewItems1 = new ArrayList<>();
    private ArrayList<RecyclerViewItem> data = new ArrayList<>();
    private Button buttonContent;
    private Button buttonTheme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_satisfied_black_24dp, "Happy", "Life is nice!"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_neutral_black_24dp , "OK", "Life is life"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_dissatisfied_black_24dp, "Sad", "Life is sad."));



        recyclerViewItems1.add(new RecyclerViewItem(R.drawable.ic_wb_sunny_black_24dp, "Sunny", "Time to go out!"));
        recyclerViewItems1.add(new RecyclerViewItem(R.drawable.ic_wb_cloudy_black_24dp, "Cloudy", "No need for sunglasses."));
        recyclerViewItems1.add(new RecyclerViewItem(R.drawable.ic_ac_unit_black_24dp, "Snowy", "Most beautiful weather."));


        data.addAll(recyclerViewItems);

        buttonContent = findViewById(R.id.buttonContent);
        buttonTheme = findViewById(R.id.buttonTheme);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(data, isLight);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);



        buttonContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceOldList();

            }
        });

        buttonTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isLight) {

                    adapter.notifyDataSetChanged();
                    isLight = false;

                } else {

                    adapter.notifyDataSetChanged();
                    isLight = true;

                }



            }
        });



    }

    private void replaceOldList() {

        if (isChanged) {
            data.clear();
            data.addAll(recyclerViewItems1);
            adapter.notifyDataSetChanged();
            isChanged = false;
        } else {
            data.clear();
            data.addAll(recyclerViewItems);
            adapter.notifyDataSetChanged();
            isChanged = true;
        }
    }





    }


