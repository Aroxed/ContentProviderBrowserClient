package ua.kpi.spscs.contentproviderbrowserclient;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView txv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv = findViewById(R.id.textView);
        populateTxtWithData();
    }

    private void populateTxtWithData() {
        String str = "";
        String[] projection = {"id", "name"};
        Uri uri = Uri.parse("content://com.random/users");
        Cursor c = getContentResolver().query(uri, projection, null, null, null);
        str += "Count: " + c.getCount() + "\n";
        while (c.moveToNext()) {
            str += c.getString(0) + "---";
            String url = c.getString(1);
            str += url + "\n";
        }
        txv.setText(str);

    }

}