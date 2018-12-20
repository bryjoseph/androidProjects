package nachocompany.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FunFactsActivity extends AppCompatActivity {
    public static final String TAG = FunFactsActivity.class.getSimpleName();

    private ColorWheel colorWheel = new ColorWheel();
    private FactBook factBook = new FactBook();

    // declare view variables
    private TextView factTextView;
    private Button showFactButton;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // assign the views from the layout file to the associated variables
        factTextView = findViewById(R.id.factTextView);
        showFactButton = findViewById(R.id.showFactButton);
        relativeLayout = findViewById(R.id.relativeLayout);

        // create onlick listener
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fact = factBook.getFact();

                // Update the screen with the new fact
                factTextView.setText(fact);

                int color = colorWheel.getColor();
                relativeLayout.setBackgroundColor(color);
                showFactButton.setTextColor(color);
            }
        };
        showFactButton.setOnClickListener(listener);

        //Toast message
        // Toast.makeText(this, "The activity was created!", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Logging from the onCreate() method");
    }
}
