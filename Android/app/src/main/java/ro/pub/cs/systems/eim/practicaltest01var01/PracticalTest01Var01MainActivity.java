package ro.pub.cs.systems.eim.practicaltest01var01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var01MainActivity extends AppCompatActivity {

    private Button north, south, west, east, navigateToSecond;
    private TextView lista;
    private int counter;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.south:
                    counter++;
                    lista.append(",south");
                    break;
                case R.id.east:
                    counter++;
                    lista.append(",east");
                    break;
                case R.id.west:
                    counter++;
                    lista.append(",west");
                    break;
                case R.id.north:
                    counter++;
                    lista.append(",north");
                    break;
                case R.id.second_activ:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01SecondaryActivity.class);
                    intent.putExtra("counter", counter);
                    startActivityForResult(intent, 1);
                    break;
            }
            if (counter> 4) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01Service.class);


                getApplicationContext().startService(intent);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);

        counter = 0;

        north = (Button) findViewById(R.id.north);
        north.setOnClickListener(buttonClickListener);
        south = (Button) findViewById(R.id.south);
        south.setOnClickListener(buttonClickListener);
        west = (Button) findViewById(R.id.west);
        west.setOnClickListener(buttonClickListener);
        east = (Button) findViewById(R.id.east);
        east.setOnClickListener(buttonClickListener);
        lista = (TextView) findViewById(R.id.lista);
        navigateToSecond = (Button) findViewById(R.id.second_activ);
        navigateToSecond.setOnClickListener(buttonClickListener);
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("counter", String.valueOf(counter));
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("counter")) {
            counter = Integer.parseInt(savedInstanceState.getString("counter"));
            Toast.makeText(this, counter, Toast.LENGTH_LONG);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
