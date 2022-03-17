package edu.jsu.mcis.cs408.dbexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import edu.jsu.mcis.cs408.dbexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        db = new DatabaseHandler(this, null, null, 1);
        updateRecyclerView();

        binding.addMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewMemo();
            }
        });
        binding.delMemo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ deleteMemo(); }

        });

    }

    public void deleteMemo() {
        String index = binding.deleteNumber.getText().toString();
        int ind;
        try {
            ind = Integer.parseInt(index);
        }catch(Exception e){
            ind = -1;
        }
        List<Memo> allMemos = db.getAllMemosAsList();
        db.deleteMemo(allMemos.get(ind-1).getId());
        updateRecyclerView();
        binding.deleteNumber.setText("");

    }

    public void addNewMemo() {
        String name = binding.nameInput.getText().toString();
        db.addMemo(new Memo(name));
        updateRecyclerView();
        for (Memo i : db.getAllMemosAsList()){
            Log.i("test", ""+i.getId());
        }
        binding.nameInput.setText("");
    }



    private void updateRecyclerView() {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(db.getAllMemosAsList());

        binding.output.setHasFixedSize(true);
        binding.output.setLayoutManager(new LinearLayoutManager(this));
        binding.output.setAdapter(adapter);
    }

}