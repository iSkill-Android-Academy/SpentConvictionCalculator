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
        startActivity(intent);
    }


}
