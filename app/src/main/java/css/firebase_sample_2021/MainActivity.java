package css.firebase_sample_2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText editTextItem;
    Button buttonPost;
    RecyclerView recyclerViewItems;
    ItemRecycleViewAdapter iItemRecycleViewAdapter;

    ItemViewModel itemViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup ViewModel
        // May need to add the following to the Module build.gradle file's dependencies section
        // implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
        itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);

        editTextItem = findViewById(R.id.editTextItem);
        setupButtonPost();
        setupItemRecycleView();

    }

    private void setupButtonPost() {
        buttonPost = findViewById(R.id.buttonPost);
        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334", "Post button clicked");
                String item = editTextItem.getText().toString();

            }
        });
    }

    private void setupItemRecycleView() {
        recyclerViewItems = (RecyclerView) findViewById(R.id.recycleViewItems);
        iItemRecycleViewAdapter = new ItemRecycleViewAdapter(itemViewModel);
        recyclerViewItems.setAdapter(iItemRecycleViewAdapter);
        recyclerViewItems.setLayoutManager(new LinearLayoutManager(this));
    }

}