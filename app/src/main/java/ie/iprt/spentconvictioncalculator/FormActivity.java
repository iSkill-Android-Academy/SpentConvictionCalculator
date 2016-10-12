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



    public static final String RESULTS_KEY = "RESULTS";


    private CheckBox mDOB;
    private DatePicker mConvictionDate;
    private Spinner mOffenseSpinner;
    private Spinner mCourtSpinner;
    private EditText mNumOffense;
    private Spinner mPunishmentSpinner;

    String resultsLogic = "Results not available"; //results logic variable

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        mDOB = (CheckBox) findViewById(R.id.dobCheckBox);
        mConvictionDate = (DatePicker) findViewById(R.id.date_picker_conviction_date);
        mOffenseSpinner = (Spinner) findViewById(R.id.offense_spinner);
        mCourtSpinner = (Spinner) findViewById(R.id.court_list_spinner);
        mNumOffense = (EditText) findViewById(R.id.edit_text_num_convictions);

        mPunishmentSpinner = (Spinner) findViewById(R.id.punishment_spinner);

    }

    public void onSubmitButtonClicked(View view) {


        calculationLogic();
        Intent intent = new Intent(this, ResultsActivity.class);
        Bundle extras = new Bundle();      //setting up bundle to put the result values in.
        extras.putString(RESULTS_KEY, resultsLogic);
        intent.putExtras(extras);


        startActivity(intent);


    }

    public java.util.Date getDateFromDatePicker() {  //method to get the day date and month from the conviction date date picker element
        int day = mConvictionDate.getDayOfMonth();
        int month = mConvictionDate.getMonth();
        int year = mConvictionDate.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();


    }

    public void calculationLogic() {


        Date convictionDate = getDateFromDatePicker();  //gets date of conviction from the conviction date picker


        long difference = System.currentTimeMillis() - convictionDate.getTime(); //gets the difference between conviction date and system date and returns a long of milliseconds



        if (mOffenseSpinner.getSelectedItem().toString().equals("Sexual offense") ||
                mOffenseSpinner.getSelectedItem().toString().equals("Homicide") ||
                mOffenseSpinner.getSelectedItem().toString().equals("Dangerous Driving") ||
                mCourtSpinner.getSelectedItem().toString().equals("Central Criminal Court") ||
                mCourtSpinner.getSelectedItem().toString().equals("Special Criminal Court") ||
                mPunishmentSpinner.getSelectedItem().toString().equals("Prison sentence longer than 12 months") ||
                mPunishmentSpinner.getSelectedItem().toString().equals("Suspended sentence of more than 24 months")

                ) {

            resultsLogic = "Must Declare Conviction(s) \n\nFor more serious crimes, sentences and convictions handed down by the higher courts you must always declare the conviction.";


        } else if (mOffenseSpinner.getSelectedItem().toString().equals("Assault") &&
                Integer.parseInt(mNumOffense.getText().toString()) > 1) {

            resultsLogic = "Must Declare Conviction(s) \n" +
                    "\nYou must always declare multiple assault convictions.";


        } else if (mOffenseSpinner.getSelectedItem().toString().equals("Insurance Fraud") &&
                Integer.parseInt(mNumOffense.getText().toString()) > 1) {


            resultsLogic = "Must Declare Convictions \n" +
                    "\nYou must always declare multiple insurance fraud convictions, including when applying for insurance";
        } else if (mOffenseSpinner.getSelectedItem().toString().equals("All Other Offenses") &&
                Integer.parseInt(mNumOffense.getText().toString()) > 1) {

            resultsLogic = "Must Declare Convictions \n" +
                    "\nMust always declare convictions when there are two or more.";
        } else if (mDOB.isChecked()) {

            if (difference > 94670778000l) {
                if (mOffenseSpinner.getSelectedItem().toString().equals("Assault") &&
                        Integer.parseInt(mNumOffense.getText().toString()) == 1) {

                    resultsLogic = "Your conviction is spent. \n\nYou not have to declare a single Assault conviction after 3 years (for a minor), however must it be declared during the Garda vetting process.";

                }else if (mOffenseSpinner.getSelectedItem().toString().equals("Insurance Fraud") &&
                        Integer.parseInt(mNumOffense.getText().toString()) == 1) {

                    resultsLogic = "Your conviction is spent in most circumstances. \n" +
                            "\nHowever, it must continue to be declared on insurance policies.";
                }else {
                    resultsLogic = "Your conviction is spent. \n" +
                            "\nIf asked, you no longer have to declare the conviction as the 3 year period for a minor has passed.";
                }

            } else {


                resultsLogic = " Your conviction(s) is not spent. \n\nIf asked, you still have to declare the conviction as the 3 year period for a minor has not passed.";
            }
        }else {

            if (difference > 220898482000l) {
                if (mOffenseSpinner.getSelectedItem().toString().equals("Assault") &&
                        Integer.parseInt(mNumOffense.getText().toString()) == 1) {

                    resultsLogic = "Your conviction is spent. \n" +
                            "\nYou do not have to declare a single Assault conviction after 7 years (for an adult), however it must be declared during Garda vetting process.";

                }else if (mOffenseSpinner.getSelectedItem().toString().equals("Insurance Fraud") &&
                        Integer.parseInt(mNumOffense.getText().toString()) == 1) {

                    resultsLogic = "Your conviction is spent in most circumstances. \n" +
                            "\nHowever, it must continue to be declared on insurance policies.";
                }else {
                    resultsLogic = "Your conviction is spent. \n" +
                            "\nIf asked, you no longer have to declare the conviction as the 7 year period for an adult has passed.";
                }
            }else {


                resultsLogic = "Your conviction(s) is not spent. \n\nIf asked, you still have to declare the conviction as the 7 year period for an adult has not passed.";
            }
        }
    }
}





