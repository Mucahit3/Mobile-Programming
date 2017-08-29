package com.example.muhammetmucahit.systemservices_clipboardmanager;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    EditText editText_copy, editText_paste;
    Button btn_copy, btn_paste;
    ClipboardManager myClipBoard;
    ClipData myClip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_copy = (EditText) findViewById(R.id.editText_copy);
        editText_paste = (EditText) findViewById(R.id.editText_paste);
        btn_copy = (Button) findViewById(R.id.btn_copy);
        btn_paste = (Button) findViewById(R.id.btn_paste);
        myClipBoard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        btn_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String copyText = editText_copy.getText().toString();
                myClip = ClipData.newPlainText("label", copyText);
                myClipBoard.setPrimaryClip(myClip);
                Toast.makeText(context, "The text was copied!", Toast.LENGTH_SHORT).show();
            }
        });

        btn_paste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myClipBoard.hasPrimaryClip()){
                    myClip = myClipBoard.getPrimaryClip();
                    ClipData.Item item = myClip.getItemAt(0);
                    editText_paste.setText(item.getText().toString());
                    Toast.makeText(context, "The text was pasted!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
