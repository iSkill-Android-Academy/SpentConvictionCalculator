package ie.iprt.spentconvictioncalculator;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MissionStatementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_statement);
//casting the font to the text view
        TextView instructions_header= (TextView) findViewById(R.id.instructions_header);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/american_typewriter_font.ttf");
        instructions_header.setTypeface(tf);
    }

    public void FormActivity (View view){
        Intent intent = new Intent(this,FormActivity.class);
        HomeScreen.createDialogIntent(this, intent);
    }

    public void onExternalLinksActivity(View view) {
        Intent intent = new Intent(this, ExternalLinksActivity.class);
        startActivity(intent);
    }

    public void onAboutClick(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }






}
