package parkwow13.edgelv34.parcelabletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveDataActivity extends AppCompatActivity {

    private TextView data1Text, data2Text, data3Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_data);

        setResource();

        ParcelableData data;
        Intent intent = getIntent();
        if (intent != null) {
            data = intent.getParcelableExtra("data");
            setData(data.getData1(), data.getData2(), data.getData3());
        }
    }

    private void setResource() {
        data1Text = findViewById(R.id.receive_data1);
        data2Text = findViewById(R.id.receive_data2);
        data3Text = findViewById(R.id.receive_data3);
    }

    private void setData(String data1, String data2, String data3) {
        data1Text.setText(data1);
        data2Text.setText(data2);
        data3Text.setText(data3);
    }
}
