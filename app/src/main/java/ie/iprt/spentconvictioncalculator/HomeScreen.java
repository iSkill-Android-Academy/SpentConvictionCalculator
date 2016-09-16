package ie.iprt.spentconvictioncalculator;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {

    private Button mMissionStatemnt;
    private Button mForm;
    private Button mExternalLinks;
    private Button mAbout;
    private TextView mSubtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        //setting up the font
        mMissionStatemnt = (Button) findViewById(R.id.mission_statement);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/american_typewriter_font.ttf");
        mMissionStatemnt.setTypeface(tf);
        mForm = (Button) findViewById(R.id.form_button_main);
        mForm.setTypeface(tf);
        mExternalLinks = (Button) findViewById(R.id.external_links);
        mExternalLinks.setTypeface(tf);
        mAbout = (Button) findViewById(R.id.about_button);
        mAbout.setTypeface(tf);
        mSubtitle =(TextView) findViewById(R.id.subtitle);
        mSubtitle.setTypeface(tf);

    }

    public void onViewButtonClicked(View view) {
        Intent intent = new Intent(this, FormActivity.class);
        createDialogIntent(this, intent);
    }

    public void onAboutClick(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void onMissionStatementClick(View view) {
        Intent intent = new Intent(this, MissionStatementActivity.class);
        startActivity(intent);
    }

    public void onExternalLinksActivity(View view) {
        Intent intent = new Intent(this, ExternalLinksActivity.class);
        startActivity(intent);
    }

    public static void createDialogIntent(final Context context, final Intent intent) {
        new AlertDialog.Builder(context).setTitle(R.string.alert_title)
                .setMessage(R.string.alert_message)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(R.string.alert_agree_option, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //this is what happens when Accept is clicked
                        context.startActivity(intent);
                    }
                }).setNegativeButton(R.string.alert_disagree_option,  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //creating toast, when decline is the alert
                        Toast.makeText(context, context.getString(R.string.alert_disagree_toast), Toast.LENGTH_LONG).show();
                    }
                }).show();

    }
}
