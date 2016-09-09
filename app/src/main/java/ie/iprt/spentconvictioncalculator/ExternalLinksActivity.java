package ie.iprt.spentconvictioncalculator;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
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
}
