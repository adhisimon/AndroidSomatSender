package id.co.mondial.android.somatsender;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SomatSenderSetting extends Activity {
	
	public static final String PREFS_NAME = "id.co.mondial.android.somatsender.config";
	public static String apikey = "";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		EditText apikeyEditText;
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        apikey = settings.getString("apikey", "");
        
        apikeyEditText = (EditText)findViewById(R.id.apikey);
        apikeyEditText.setText(apikey);
    }
	
	public void testApikey(View view) {
    	Toast.makeText(SomatSenderSetting.this, "test", Toast.LENGTH_SHORT).show();
    }
	
	@Override
	public void onStop() {
		EditText apikeyEditText;
		
		super.onStop();
		
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		
		apikeyEditText = (EditText)findViewById(R.id.apikey);
        apikey = apikeyEditText.getText().toString();
        
		editor.putString("apikey", apikey);
		editor.commit();
	}
	
	
}
