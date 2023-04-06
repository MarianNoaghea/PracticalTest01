package ro.pub.cs.systems.eim.practicaltest01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PracticalTest01MainActivity extends AppCompatActivity {

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private EditText leftEditText;
    private EditText rightEditText;
    private Button button1;
    private Button button2;
    private Button button3;

    int leftNumberOfClicks = 0;
    int rightNumberOfClicks = 0;
    
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.button1:
                    System.out.println("da1\n");
                    leftNumberOfClicks++;
                    leftEditText.setText(String.valueOf(leftNumberOfClicks));
                    break;
                case R.id.button2:
                    System.out.println("da2\n");
                    rightNumberOfClicks++;
                    rightEditText.setText(String.valueOf(rightNumberOfClicks));
                    break;
                case R.id.navigate_to_secondary_activity_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01SecondaryActivity.class);
                    System.out.println("da3\n");
                    intent.putExtra("leftNumberOfClicks", leftNumberOfClicks);
                    intent.putExtra("rightNumberOfClicks", rightNumberOfClicks);
                    startActivityForResult(intent, 1);
                    break;
            }
        }
    }
    @Override//            String n2dLayoutText = intent.getStringExtra("n2dLayoutText");
//            this.n2dLayoutText.setText(n2dLayoutText);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);

        leftEditText = new EditText(this);
        rightEditText = new EditText(this);

        leftEditText = (EditText) findViewById(R.id.leftEditText);
        rightEditText = (EditText) findViewById(R.id.rightEditText);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.navigate_to_secondary_activity_button);

        button1.setOnClickListener(buttonClickListener);
        button2.setOnClickListener(buttonClickListener);
        button3.setOnClickListener(buttonClickListener);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1) {
            System.out.println("TOAST!\n");
            if (resultCode == RESULT_OK) {

                Toast.makeText(this, "The activity returned with result OK", Toast.LENGTH_LONG).show();
                String sum = intent.getStringExtra("sum_label");
                System.out.println("sum = " + sum +  "\n");
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "The activity returned with result CANCEL", Toast.LENGTH_LONG).show();
            }
        }
    }
}