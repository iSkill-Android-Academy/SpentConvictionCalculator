package ie.iprt.spentconvictioncalculator;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ExternalLinksActivity extends AppCompatActivity {

    public static Button btnEmail;
    private TextView mWhoCanHelp;
    private TextView mCitizenLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_links);
        //Tomas added
        mWhoCanHelp = (TextView) findViewById(R.id.who_can_help_title_page);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/american_typewriter_font.ttf");
        mWhoCanHelp.setTypeface(tf);
        TextView whoCanHelpTitle = (TextView) findViewById(R.id.who_can_help_title_page);
        whoCanHelpTitle.setPaintFlags(whoCanHelpTitle.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        whoCanHelpTitle.setTypeface(tf, Typeface.BOLD);
        TextView mCitizenLink = (TextView) findViewById(R.id.link6);
        mCitizenLink.setTypeface(tf);
        TextView mJusticeLink =(TextView) findViewById(R.id.link5);
        mJusticeLink.setTypeface(tf);
        TextView mCareAfterPrisonLink = (TextView) findViewById(R.id.link3);
        mCareAfterPrisonLink.setTypeface(tf);
        TextView mUcasadh = (TextView) findViewById(R.id.link2);
        mUcasadh.setTypeface(tf);
        TextView mBridge =(TextView) findViewById(R.id.link4);
        mBridge.setTypeface(tf);
        TextView mIasio = (TextView) findViewById(R.id.link1);
        mIasio.setTypeface(tf);


    }
    public void onMainReturn(View view){
        onBackPressed();
    }


    public void oncharity1Click(View View){
        goToUrl("http://www.iasio.ie");

    }


    public void oncharity2Click(View View){
        goToUrl("http://www.ucasadh.ie");

    }

    public void oncharity3Click(View View){
        goToUrl("http://www.careafterprison.ie");

    }

    public void oncharity4Click(View View){
        goToUrl("http://www.bridge.ie");

    }

    public void oncharity5Click(View View){
        goToUrl("http://www.justice.ie");

    }

    public void oncharity6Click(View View){
        goToUrl("http://www.citizensinformation.ie");

    }

    public void sendContact(View view){
        String targetEmail[] = null;
        String mSubject = "Enquiry";
        String mMessage = "I am seeking advice....";

        switch(view.getId()){
            case R.id.email_charity_1 : {
                targetEmail = new String[]{"prichardson@iasio.ie"};
                break;
            }

            case R.id.email_charity_2 : {
                targetEmail = new String[]{"press@ucasadh.ie"};
                break;
            }

            case R.id.email_charity_3 : {
                targetEmail = new String[]{"info@careafterprison.ie"};
                break;
            }

            case R.id.email_charity_4 : {
                targetEmail = new String[]{"siobhan@bridge.ie"};
                break;
            }

            case R.id.email_charity_5 : {
                targetEmail = new String[]{"foi@justice.ie"};
                break;
            }

            case R.id.email_charity_6 : {
                targetEmail = new String[]{"ciofeedback@ciboard.ie"};
                break;
            }
        }

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, targetEmail);
        intent.putExtra(Intent.EXTRA_SUBJECT, mSubject);
        intent.putExtra(Intent.EXTRA_TEXT, mMessage);

        try {
            startActivity(Intent.createChooser(intent, "Send Email"));
        } catch (android.content.ActivityNotFoundException ex) {
            //Toast.makeText(getContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }


    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void onMissionStatementClick(View view) {
        Intent intent = new Intent(this, MissionStatementActivity.class);
        startActivity(intent);
    }

    public void FormActivity1 (View view){
        Intent intent = new Intent(this,ExternalLinksActivity.class);
        createDialogIntent(this, intent);
    }

    public void FormActivity2 (View view){
        Intent intent = new Intent(this,ExternalLinksActivity.class);
        createDialogIntent2(this, intent);
    }

    public void FormActivity3 (View view){
        Intent intent = new Intent(this,ExternalLinksActivity.class);
        createDialogIntent3(this, intent);
    }

    public void FormActivity4 (View view){
        Intent intent = new Intent(this,ExternalLinksActivity.class);
        createDialogIntent4(this, intent);
    }

    public void FormActivity5 (View view){
        Intent intent = new Intent(this,ExternalLinksActivity.class);
        createDialogIntent5(this, intent);
    }

    public void FormActivity6 (View view){
        Intent intent = new Intent(this,ExternalLinksActivity.class);
        createDialogIntent6(this, intent);
    }


    //for additional info on the charities
    public static void createDialogIntent(final Context context, final Intent intent) {
        new AlertDialog.Builder(context).setTitle(R.string.alert_title1)
                .setMessage(R.string.alert_message1)
                .setIcon(R.drawable.ic_external_links)
                .setPositiveButton(R.string.alert_disagree_option1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //this is what happens when Accept is clicked
                        //context.startActivity(intent);
                    }
                }).show();

    }

    //for additional info on the charities
    public static void createDialogIntent2(final Context context, final Intent intent) {
        new AlertDialog.Builder(context).setTitle(R.string.alert_title2)
                .setMessage(R.string.alert_message2)
                .setIcon(R.drawable.ic_external_links)
                .setPositiveButton(R.string.alert_disagree_option1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //this is what happens when Accept is clicked
                        //context.startActivity(intent);
                    }
                }).show();

    }


    //for additional info on the charities
    public static void createDialogIntent3(final Context context, final Intent intent) {
        new AlertDialog.Builder(context).setTitle(R.string.alert_title3)
                .setMessage(R.string.alert_message3)
                .setIcon(R.drawable.ic_external_links)
                .setPositiveButton(R.string.alert_disagree_option1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //this is what happens when Accept is clicked
                        //context.startActivity(intent);
                    }
                }).show();

    }

    //for additional info on the charities
    public static void createDialogIntent4(final Context context, final Intent intent) {
        new AlertDialog.Builder(context).setTitle(R.string.alert_title4)
                .setMessage(R.string.alert_message4)
                .setIcon(R.drawable.ic_external_links)
                .setPositiveButton(R.string.alert_disagree_option1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //this is what happens when Accept is clicked
                        //context.startActivity(intent);
                    }
                }).show();

    }

    //for additional info on the charities justice.ie
    public static void createDialogIntent5(final Context context, final Intent intent) {
        new AlertDialog.Builder(context).setTitle(R.string.alert_title5)
                .setMessage(R.string.alert_message5)
                .setIcon(R.drawable.ic_external_links)
                .setPositiveButton(R.string.alert_disagree_option1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //this is what happens when Accept is clicked
                        //context.startActivity(intent);
                    }
                }).show();

    }

    //for additional info on the charities citizensinformation
    public static void createDialogIntent6(final Context context, final Intent intent) {
        new AlertDialog.Builder(context).setTitle(R.string.alert_title6)
                .setMessage(R.string.alert_message6)
                .setIcon(R.drawable.ic_external_links)
                .setPositiveButton(R.string.alert_disagree_option1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //this is what happens when Accept is clicked
                        //context.startActivity(intent);
                    }
                }).show();

    }

}
