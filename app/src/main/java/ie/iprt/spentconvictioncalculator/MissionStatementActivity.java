package ie.iprt.spentconvictioncalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MissionStatementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_statement);
    }

    public void FormActivity (View view){
        Intent intent = new Intent(this,FormActivity.class);
        HomeScreen.createDialogIntent(this, intent);
    }

    public void onExternalLinksActivity(View view) {
        Intent intent = new Intent(this, ExternalLinksActivity.class);
        HomeScreen.createDialogIntent(this, intent);
    }

    public void onAboutClick(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        HomeScreen.createDialogIntent(this, intent);
    }






}
