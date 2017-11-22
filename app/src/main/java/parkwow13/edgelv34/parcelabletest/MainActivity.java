package parkwow13.edgelv34.parcelabletest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout data1, data2, data3;
    private EditText data1Edit, data2Edit, data3Edit;
    private Button sendDataBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setResource();
    }

    private void setResource() {
        data1 = findViewById(R.id.input_data1_layout);
        data2 = findViewById(R.id.input_data2_layout);
        data3 = findViewById(R.id.input_data3_layout);

        data1Edit = findViewById(R.id.lm_find_data1_edit);
        data2Edit = findViewById(R.id.lm_find_data2_edit);
        data3Edit = findViewById(R.id.lm_find_data3_edit);

        data1Edit.addTextChangedListener(new MyTextWatcher(data1Edit));
        data2Edit.addTextChangedListener(new MyTextWatcher(data2Edit));
        data3Edit.addTextChangedListener(new MyTextWatcher(data3Edit));

        sendDataBtn = findViewById(R.id.send_data_btn);
        sendDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkForm()) {
                    Intent intent = new Intent(MainActivity.this, ReceiveDataActivity.class);
                    intent.putExtra("data", new ParcelableData(data1Edit.getText().toString(), data2Edit.getText().toString(), data3Edit.getText().toString()));
                    startActivity(intent);
                }
            }
        });
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


    private boolean validateData1() {
        if (data1Edit.getText().toString().trim().isEmpty()) {
            data1.setError("Data를 입력해주세요");
            requestFocus(data1Edit);
            return false;
        } else {
            data1.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateData2() {
        if (data2Edit.getText().toString().trim().isEmpty()) {
            data2.setError("Data를 입력해주세요");
            requestFocus(data2Edit);
            return false;
        } else {
            data2.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateData3() {
        if (data3Edit.getText().toString().trim().isEmpty()) {
            data3.setError("Data를 입력해주세요");
            requestFocus(data3Edit);
            return false;
        } else {
            data3.setErrorEnabled(false);
        }
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.lm_find_data1_edit:
                    validateData1();
                    break;

                case R.id.lm_find_data2_edit:
                    validateData2();
                    break;

                case R.id.lm_find_data3_edit:
                    validateData3();
                    break;
            }
        }
    }

    private boolean checkForm() {
        if (!validateData1()) {
            return false;
        }

        if (!validateData2()) {
            return false;
        }

        if (!validateData3()) {
            return false;
        }

        return true;
    }





}
