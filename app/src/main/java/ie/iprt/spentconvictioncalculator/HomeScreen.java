package ie.iprt.spentconvictioncalculator;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    private Button mMissionStatemnt;
    private Button mForm;
    private Button mExternalLinks;
    private Button mAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    //setting up the font
        mMissionStatemnt =(Button)findViewById(R.id.mission_statement);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/american_typewriter_font.ttf");
        mMissionStatemnt.setTypeface(tf);
        mForm = (Button)findViewById(R.id.form_button_main);
        mForm.setTypeface(tf);
        mExternalLinks = (Button)findViewById(R.id.external_links);
        mExternalLinks.setTypeface(tf);
        mAbout = (Button)findViewById(R.id.about_button);
        mAbout.setTypeface(tf);

    }
    public void onViewButtonClicked(View view) {
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }

    public void onAboutClick(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void onMissionStatementClick(View view) {
        Intent intent = new Intent(this, MissionStatementActivity.class);
        startActivity(intent);
    }
    public void onExternalLinksActivity(View view){
        Intent intent = new Intent(this, ExternalLinksActivity.class);
        startActivity(intent);
    }


}
