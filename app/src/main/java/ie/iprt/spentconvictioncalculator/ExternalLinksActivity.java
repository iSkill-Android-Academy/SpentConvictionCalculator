package ie.iprt.spentconvictioncalculator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ExternalLinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_links);

    }

    public void oncharity1Click(View View){
        goToUrl("https://www.iasio.ie");

    }

    public void oncharity2Click(View View){
        goToUrl("https://www.ucasadh.ie");

    }

    public void oncharity3Click(View View){
        goToUrl("https://www.careafterprison.ie");

    }

    public void oncharity4Click(View View){
        goToUrl("https://www.bridge.ie");

    }


    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }




}
