package com.app.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNotes extends AppCompatActivity {

    EditText title,description;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        title = findViewById(R.id.add_title);
        description = findViewById(R.id.add_desc);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveNote();
            }
        });
    }

    private void saveNote(){

        String str1 = title.getText().toString();
        String str2 = description.getText().toString();

        if(str1.equals("") || str2.equals("")){

            Toast.makeText(getApplicationContext(),"Field cannot be empty",Toast.LENGTH_SHORT).show();
        }else{

            Intent i = new Intent(AddNotes.this,MainActivity.class);
            i.putExtra("title",str1);
            i.putExtra("desc",str2);
            setResult(RESULT_OK,i);
            finish();

        }
    }
}
