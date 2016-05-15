package info.axbase.appex;

import android.app.Activity;
import android.os.Bundle;

public class InternalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_internal);
	}
}
