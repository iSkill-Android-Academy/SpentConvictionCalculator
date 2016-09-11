package ie.iprt.spentconvictioncalculator;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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

public class ExternalLinksActivity extends AppCompatActivity {

    public static Button btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_links);


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

}
