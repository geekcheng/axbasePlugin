package info.axbase.appex;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class PluginApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("PluginApplication", "onCreate");
		context = this;
	}

	private static Context context;

	public static void showMessage(String msg) {
		if (context == null) {
			Log.e("PluginApplication", "context is null");
			return;
		}
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
}
