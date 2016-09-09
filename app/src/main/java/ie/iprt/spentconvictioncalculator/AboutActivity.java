package ie.iprt.spentconvictioncalculator;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    private TextView mAbout;
    private TextView mAboutDevelopers;
    private TextView mAboutIskill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/american_typewriter_font.ttf");
        mAbout = (TextView)findViewById(R.id.about_text_id_font);
        mAbout.setTypeface(tf);
        mAboutDevelopers = (TextView)findViewById(R.id.about_developers_id_font);
        mAboutDevelopers.setTypeface(tf);
        mAboutIskill = (TextView)findViewById(R.id.about_iskill_id_font);
        mAboutIskill.setTypeface(tf);
    }
    public void onDonateClick(View View){
        goToUrl("https://www.iprt.ie/donation-form");

    }
    public void onIskillClick(View view){
        goToUrl("http://www.iskill.ie/");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
