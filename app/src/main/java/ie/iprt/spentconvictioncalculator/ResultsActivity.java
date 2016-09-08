package ie.iprt.spentconvictioncalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    String resultsLogic;
    private TextView mEditTextResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mEditTextResults = (TextView) findViewById(R.id.resultsTextView);
        resultsLogic = getIntent().getExtras().getString(FormActivity.RESULTS_KEY);
        mEditTextResults.setText(resultsLogic);



    }
}
