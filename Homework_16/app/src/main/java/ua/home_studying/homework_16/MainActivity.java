package ua.home_studying.homework_16;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 101;
    private static final String TAG = "tag2";
    ArrayList<ImageItem> imageItems = new ArrayList<>();
    String stringUri;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (adapter == null){
            adapter = initAdapter();
        }

        initRecyclerView();
        setButton();


        if (getIntent().getData() != null) {
            Log.e(TAG, "getIntent().getData( " + getIntent().getData().toString());
            Uri uri = getIntent().getData();
            stringUri = uri.toString();
            Intent intent = new Intent(MainActivity.this, SingleImageActivity.class);
            intent.putExtra("image", stringUri);
            startActivity(intent);
            Log.e(TAG, "onCreate: " + imageItems.size() );
        }
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private RecyclerView.Adapter initAdapter() {
        ImagesListCreator imagesListCreator = new ImagesListCreator();
        imageItems = imagesListCreator.create();
        return new CustomAdapter(imageItems, getApplicationContext());
    }

    private void refreshAdapter(RecyclerView.Adapter adapter) {
        adapter.notifyDataSetChanged();
    }


    private void setButton() {

        Button button = findViewById(R.id.select_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImage();
            }
        });
    }

    private void pickImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "Choose your app"), PICK_IMAGE);
        Log.e(TAG, "pickImage: " );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Uri uri;

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            uri = data.getData();
            stringUri = uri.toString();
            Log.e(TAG, "size " + imageItems.size());
            imageItems.add(new ImageItem(stringUri));
            refreshAdapter(adapter);
            Log.e(TAG, "size " + imageItems.size());
        }
    }
}
