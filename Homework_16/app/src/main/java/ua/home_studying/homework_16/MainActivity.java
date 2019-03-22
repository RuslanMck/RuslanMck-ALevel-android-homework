package ua.home_studying.homework_16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "tag";
    ImagesListCreator imagesListCreator = new ImagesListCreator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),3);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<ImageItem> imageItems = imagesListCreator.create();
        CustomAdapter adapter = new CustomAdapter(imageItems, getApplicationContext());
        Log.e(TAG, "imgIts " + imageItems.size() );
        recyclerView.setAdapter(adapter);



    }




//    private ArrayList<ImageItem> setItems() {
//        ArrayList<ImageItem> arrayList = new ArrayList();
//        arrayList.add(new ImageItem(R.drawable.bengal_01));
//        arrayList.add(new ImageItem(R.drawable.bengal_02));
//        arrayList.add(new ImageItem(R.drawable.bengal_03));
//        arrayList.add(new ImageItem(R.drawable.bengal_04));
//        arrayList.add(new ImageItem(R.drawable.bengal_05));
//        arrayList.add(new ImageItem(R.drawable.bengal_06));
//        arrayList.add(new ImageItem(R.drawable.bengal_07));
//        arrayList.add(new ImageItem(R.drawable.cat_001));
//        arrayList.add(new ImageItem(R.drawable.cat_002));
//        arrayList.add(new ImageItem(R.drawable.cat_003));
//        arrayList.add(new ImageItem(R.drawable.cat_004));
//        arrayList.add(new ImageItem(R.drawable.cat_005));
//        arrayList.add(new ImageItem(R.drawable.cat_006));
//        arrayList.add(new ImageItem(R.drawable.cat_007));
//        arrayList.add(new ImageItem(R.drawable.cat_008));
//        arrayList.add(new ImageItem(R.drawable.cat_009));
//        arrayList.add(new ImageItem(R.drawable.cat_010));
//        arrayList.add(new ImageItem(R.drawable.cat_011));
//        arrayList.add(new ImageItem(R.drawable.cat_012));
//        arrayList.add(new ImageItem(R.drawable.cat_013));
//        arrayList.add(new ImageItem(R.drawable.cat_014));
//        arrayList.add(new ImageItem(R.drawable.cat_015));
//        arrayList.add(new ImageItem(R.drawable.cat_016));
//        arrayList.add(new ImageItem(R.drawable.cat_017));
//        arrayList.add(new ImageItem(R.drawable.cat_018));
//        arrayList.add(new ImageItem(R.drawable.cat_019));
//        return arrayList;

}
