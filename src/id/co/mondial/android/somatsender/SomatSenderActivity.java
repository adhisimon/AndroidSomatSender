package id.co.mondial.android.somatsender;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SomatSenderActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.setting:
                Intent i = new Intent(this, SomatSenderSetting.class);
                startActivity(i);                        
                
                return true;
        default:
                return super.onOptionsItemSelected(item);
        }
    }

    
    public void sendSms(View view) {
    	EditText _destination = (EditText)findViewById(R.id.destination);
    	String destination = _destination.getText().toString();
    	
    	EditText _message = (EditText)findViewById(R.id.message);
    	String message = _message.getText().toString();
    	
    	SharedPreferences settings = getSharedPreferences(SomatSenderSetting.PREFS_NAME, 0);
        String apikey = settings.getString("apikey", "");
    	
    	Toast.makeText(
    			SomatSenderActivity.this, 
    			"Sending to " + destination,
    			Toast.LENGTH_SHORT
    		).show();
    }
}