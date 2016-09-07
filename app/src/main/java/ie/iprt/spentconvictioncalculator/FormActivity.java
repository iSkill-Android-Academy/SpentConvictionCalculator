package ie.iprt.spentconvictioncalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


public class FormActivity extends AppCompatActivity {

    public static final String DOB_KEY ="DOB";
    public static final String CONVICTION_DATE_KEY ="CONVICTION";
    public static final String OFFENSE_CAT_KEY ="OFFENSE_CAT";
    public static final String COURT_SPINNER_KEY ="COURT_SPINNER";
    public static final String NO_CONVICTIONS_KEY ="NUMBER_CONVICTIONS";
    public static final String SUSPENDED_SENTENCE_RADIO_KEY ="SUSPENDED_SENTENCE";
    public static final String YES_RADIO_KEY = "YES_RADIO";
    public static final String NO_RADIO_KEY = "NO_RADIO";
    public static final String PUNISHMENT_SPINNER_KEY ="PUNISHMENT_SPINNER";


    private DatePicker mDOB;
    private DatePicker mConvictionDate;
    private Spinner mOffenseSpinner;
    private Spinner mCourtSpinner;
    private EditText mNumOffense;
    private RadioGroup mSuspendedSentenceRadio;
    private RadioButton mYes;
    private RadioButton mNo;
    private Spinner mPunishmentSpinner;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        mDOB = (DatePicker)findViewById(R.id.date_picker_dob);
        mConvictionDate = (DatePicker)findViewById(R.id.date_picker_conviction_date);
        mOffenseSpinner = (Spinner)findViewById(R.id.offense_spinner);
        mCourtSpinner = (Spinner)findViewById(R.id.court_list_spinner);
        mNumOffense = (EditText)findViewById(R.id.edit_text_num_convictions);
        mSuspendedSentenceRadio = (RadioGroup)findViewById(R.id.radioGroup_suspended_sentence);
        mYes = (RadioButton)findViewById(R.id.radio_yes);
        mNo = (RadioButton)findViewById(R.id.radio_no);
        mPunishmentSpinner = (Spinner)findViewById(R.id.punishment_spinner);

    }
    public void onSubmitButtonClicked(){
        Intent intent = new Intent(this , ResultsActivity.class);
        startActivity(intent);






    }
}
