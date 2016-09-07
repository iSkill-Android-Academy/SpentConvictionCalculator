package ie.iprt.spentconvictioncalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;


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


    private CheckBox mDOB;
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


        mDOB = (CheckBox)findViewById(R.id.dobCheckBox);
        mConvictionDate = (DatePicker)findViewById(R.id.date_picker_conviction_date);
        mOffenseSpinner = (Spinner)findViewById(R.id.offense_spinner);
        mCourtSpinner = (Spinner)findViewById(R.id.court_list_spinner);
        mNumOffense = (EditText)findViewById(R.id.edit_text_num_convictions);
        mSuspendedSentenceRadio = (RadioGroup)findViewById(R.id.radioGroup_suspended_sentence);
        mYes = (RadioButton)findViewById(R.id.radio_yes);
        mNo = (RadioButton)findViewById(R.id.radio_no);
        mPunishmentSpinner = (Spinner)findViewById(R.id.punishment_spinner);

    }
    public void onSubmitButtonClicked(View view){
        Intent intent = new Intent(this , ResultsActivity.class);
        startActivity(intent);
        calculationLogic();

    }

    public  java.util.Date getDateFromDatePicker(){
        int day = mConvictionDate.getDayOfMonth();
        int month = mConvictionDate.getMonth();
        int year =  mConvictionDate.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();



    }

    public void calculationLogic(){



        Date convictionDate = getDateFromDatePicker();
        //Date currentDate = new Date(System.currentTimeMillis());

        long difference = System.currentTimeMillis() - convictionDate.getTime() ;



       if (mDOB.isChecked() ){
           Toast.makeText(this,"dude is under 18", Toast.LENGTH_LONG).show();


           // put the under 18 code here

       }
       else if(mOffenseSpinner.getSelectedItem().toString().equals("Sexual offense")||
               mOffenseSpinner.getSelectedItem().toString().equals("Murder")||
               mOffenseSpinner.getSelectedItem().toString().equals("Dangerous Driving")||
               mCourtSpinner.getSelectedItem().toString().equals("Central Criminal Court")||
               mCourtSpinner.getSelectedItem().toString().equals("Special Criminal Court")||
               mPunishmentSpinner.getSelectedItem().toString().equals("Prison greater than 12 months")||
               mPunishmentSpinner.getSelectedItem().toString().equals("Suspended sentence greater than 24 months")||
               mPunishmentSpinner.getSelectedItem().toString().equals("Probation greater than 24 months")
               ){
           Toast.makeText(this, "Must always declare", Toast.LENGTH_LONG).show();
        }

       else if(mOffenseSpinner.getSelectedItem().toString().equals("Assault")&&
               Integer.parseInt(mNumOffense.getText().toString())> 1){
           Toast.makeText(this, "" +
                   "Must declare " +
                   "(assault) If only one such conviction, it can become spent but must continue to be declared under Garda Vetting", Toast.LENGTH_LONG).show();
       }
       else if(mOffenseSpinner.getSelectedItem().toString().equals("Insurance Fraud")&&
               Integer.parseInt(mNumOffense.getText().toString())> 1){
           Toast.makeText(this, "" +
                   "Must declare " +
                   "(Insurance fraud) If only one such conviction, can become spent but must continue to be declared when taking out insurance policies", Toast.LENGTH_LONG).show();
       }
        else if (mOffenseSpinner.getSelectedItem().toString().equals("All Other Offenses")&&
               Integer.parseInt(mNumOffense.getText().toString())> 1){
           Toast.makeText(this, "Must always declare", Toast.LENGTH_LONG).show();

       }

        else if(difference > 220898482000l){
            Toast.makeText(this, "over 7 years Do not have to declare", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "less than 7 years, must declare", Toast.LENGTH_LONG).show();
        }





    }


}
