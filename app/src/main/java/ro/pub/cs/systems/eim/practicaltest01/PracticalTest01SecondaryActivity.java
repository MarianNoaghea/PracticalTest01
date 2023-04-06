package ro.pub.cs.systems.eim.practicaltest01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PracticalTest01SecondaryActivity extends AppCompatActivity {

    private Button ok_button;
    private Button cancel_button;
    private EditText n2dLayoutText;

    private int sum = 0;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.activity2_ok_button:
                    System.out.println("ok\n");
                    setResult(RESULT_OK, new Intent().putExtra("sum_label", String.valueOf(sum)));
                    break;
                case R.id.activity2_cancel_button:
                    System.out.println("cancel\n");
                    setResult(RESULT_CANCELED);
                    break;

            }

            finish();
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);

        n2dLayoutText = new EditText(this);

        n2dLayoutText = (EditText) findViewById(R.id.n2dLayoutText);

        ok_button = (Button) findViewById(R.id.activity2_ok_button);
        cancel_button = (Button) findViewById(R.id.activity2_cancel_button);


        ok_button.setOnClickListener(buttonClickListener);
        cancel_button.setOnClickListener(buttonClickListener);

        System.out.println("da4\n");

        Intent intent = getIntent();
        if (intent != null) {
            System.out.println("da5\n");
            int leftNumberOfClicks = intent.getIntExtra("leftNumberOfClicks", -1);
            int rightNumberOfClicks = intent.getIntExtra("rightNumberOfClicks", -1);
            sum = leftNumberOfClicks + rightNumberOfClicks;
            this.n2dLayoutText.setText(String.valueOf(sum));
        }


    }
}

