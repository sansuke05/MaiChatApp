package com.alicelab.maiapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //writeFile();

        Button button = (Button)findViewById(R.id.talk_button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                talk();
            }
        });
    }

    /*public void writeFile(){

        try {
            FileOutputStream fileOutputStream;
            fileOutputStream = openFileOutput("random.txt",MODE_PRIVATE);
            String writeString = "test";
            fileOutputStream.write(writeString.getBytes());
        } catch (FileNotFoundException e){
        } catch (IOException e){
        }
    }*/

    /*public String[] openFile() {

        int i=0;
        String[] str = new String[1000];

        try {
            FileInputStream fileInputStream;
            fileInputStream = openFileInput("random.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream,"UTF-8"));

            String tmp;
            while ((tmp = reader.readLine()) != null){
                str[i] = tmp;
                i++;
            }

            reader.close();
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException e) {
        }
        return str;
    }*/

    public void talk(){
        Mai mai = new Mai("mai");

        TextView textView = (TextView)findViewById(R.id.textView);
        EditText editText = (EditText)findViewById(R.id.editText);

        if(editText.getText().toString().equals("")) return;

        //String[] phrases = openFile();
        String response = mai.dialogue(editText.getText().toString());

        textView.setText(response);
        hideKeyboard();
        editText.getEditableText().clear();
    }

    public void hideKeyboard(){
        KeyboardUtils keyboardUtils = new KeyboardUtils();
        keyboardUtils.hide(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
