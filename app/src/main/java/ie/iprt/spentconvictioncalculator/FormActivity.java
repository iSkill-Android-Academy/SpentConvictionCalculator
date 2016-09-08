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

    public java.util.Date getDateFromDatePicker() {
        int day = mConvictionDate.getDayOfMonth();
        int month = mConvictionDate.getMonth();
        int year = mConvictionDate.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();


    }

    public void calculationLogic() {


        Date convictionDate = getDateFromDatePicker();


        long difference = System.currentTimeMillis() - convictionDate.getTime();


        //}
        if (mOffenseSpinner.getSelectedItem().toString().equals("Sexual offense") ||
                mOffenseSpinner.getSelectedItem().toString().equals("Murder") ||
                mOffenseSpinner.getSelectedItem().toString().equals("Dangerous Driving") ||
                mCourtSpinner.getSelectedItem().toString().equals("Central Criminal Court") ||
                mCourtSpinner.getSelectedItem().toString().equals("Special Criminal Court") ||
                mPunishmentSpinner.getSelectedItem().toString().equals("Prison greater than 12 months") ||
                mPunishmentSpinner.getSelectedItem().toString().equals("Suspended sentence greater than 24 months") ||
                mPunishmentSpinner.getSelectedItem().toString().equals("Probation greater than 24 months")
                ) {

            resultsLogic = " For more serious crimes, sentences and higher courts you must always declare";


        } else if (mOffenseSpinner.getSelectedItem().toString().equals("Assault") &&
                Integer.parseInt(mNumOffense.getText().toString()) > 1) {

            resultsLogic = "Must always declare multiple assault convictions including Garda vetting";


        } else if (mOffenseSpinner.getSelectedItem().toString().equals("Insurance Fraud") &&
                Integer.parseInt(mNumOffense.getText().toString()) > 1) {


            resultsLogic = "Must always declare multiple insurance fraud convictions including when applying for insurance";
        } else if (mOffenseSpinner.getSelectedItem().toString().equals("All Other Offenses") &&
                Integer.parseInt(mNumOffense.getText().toString()) > 1) {

            resultsLogic = " Must always declare when  there are two or more offenses";
        } else if (mDOB.isChecked()) {


            if (difference > 94670778000l) {
                if (mOffenseSpinner.getSelectedItem().toString().equals("Assault") &&
                        Integer.parseInt(mNumOffense.getText().toString()) == 1) {

                    resultsLogic = "Do not have to declare if less than one Assault conviction after 3 years in general but must be declared under Garda Vetting";

                }

                else if (mOffenseSpinner.getSelectedItem().toString().equals("Insurance Fraud") &&
                        Integer.parseInt(mNumOffense.getText().toString()) == 1) {

                    resultsLogic = "Do not have to declare if less than one Insurance Fraud conviction after 3 years in general but must  be declared when taking out insurance policies";
                } else {
                    resultsLogic = "Do not have to declare, 3 years have passed";
                }

            } else {


                resultsLogic = "Must declare 3 years have not passed yet";
            }
        } else {
            if (difference > 220898482000l) {
                if (mOffenseSpinner.getSelectedItem().toString().equals("Assault") &&
                        Integer.parseInt(mNumOffense.getText().toString()) == 1) {

                    resultsLogic = "Do not have to declare if less than one Assault conviction after 7 years in general but must be declared under Garda Vetting";

                }
                else if (mOffenseSpinner.getSelectedItem().toString().equals("Insurance Fraud") &&
                        Integer.parseInt(mNumOffense.getText().toString()) == 1) {

                    resultsLogic = "Do not have to declare if less than one Insurance Fraud conviction after 7 years in general but must  be declared when taking out insurance policies";
                } else {
                    resultsLogic = "Do not have to declare 7 years have passed";
                }
            } else {


                resultsLogic = "Must declare 7 years have not passed yet";
            }
        }
    }
}





