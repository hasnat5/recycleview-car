package com.example.recyclermobil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class AddEditOne extends AppCompatActivity {
    Button btn_ok, btn_cancel;
    List<Mobil> mobilList;
    EditText et_mobilDate, et_mobilName, et_mobilImageURL;
    TextView tv_pressId;
    int id;

    MyApplication myApplication = (MyApplication) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_one);

        mobilList = myApplication.getMobilList();

        btn_ok = findViewById(R.id.btn_ok);
        btn_cancel = findViewById(R.id.btn_cancel);
        et_mobilDate = findViewById(R.id.et_dateElection);
        et_mobilName = findViewById(R.id.et_mobilName);
        et_mobilImageURL = findViewById(R.id.et_pictureURL);
        tv_pressId = findViewById(R.id.tv_mobilIdNumber);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        Mobil mobil = null;

        if (id >= 0){
            //edit mobil
            for (Mobil m: mobilList) {
                if(m.getId() == id){
                    mobil = m;
                }
            }
            et_mobilName.setText(mobil.getName());
            et_mobilDate.setText(String.valueOf(mobil.getDateOfElection()));
            et_mobilImageURL.setText(mobil.getImageURL());
            tv_pressId.setText(String.valueOf(id));
        }
        else{

        }

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (id >-0){
                    // update
                    Mobil updatedMobil = new Mobil(id, et_mobilName.getText().toString(), Integer.parseInt(et_mobilDate.getText().toString()), et_mobilImageURL.getText().toString());
                    mobilList.set(id, updatedMobil);
                }
                else{
                    // add new mobil
                    // create mobil object
                    int nextId = myApplication.getNextId();
                    Mobil newMobil = new Mobil(nextId, et_mobilName.getText().toString(), Integer.parseInt(et_mobilDate.getText().toString()), et_mobilImageURL.getText().toString());
                    // add the object of the global list of mobils.


                    mobilList.add(newMobil);
                    myApplication.setNextId(nextId++);
                    // go back to main activity
                }


                Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}