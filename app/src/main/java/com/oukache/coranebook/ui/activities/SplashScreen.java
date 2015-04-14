package com.oukache.coranebook.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.oukache.coranebook.R;
import com.oukache.coranebook.util.CLogger;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Oukache on 14/04/2015.
 */
public class SplashScreen extends Activity {

	private Thread _splashThread = null;
	private Context _context = null;

	@InjectView(R.id.screen_layout) LinearLayout _screen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.splash_screen);
		_context = SplashScreen.this;
		ButterKnife.inject(this);

		Animation anim = AnimationUtils.loadAnimation(this, R.anim.fade_in);
		_screen.startAnimation(anim);

		_splashThread = new Thread() {
			public void run() {
				try {
					sleep(2000);
				} catch(Exception e) {
					CLogger.error("Splash-Screen error : " + e.getMessage());
				} finally {
					if (_context != null) {
						Intent intent = new Intent(_context, CoranBaseActivity.class);
						startActivity(intent);
					}
					finish();
				}
			}
		};

		_splashThread.start();
	}


	/**
	 * à l'appui de la touche back, on remet le context à null
	 * afin de ne pas lancer l'application.
	 */
	public void onBackPressed() {
		super.onBackPressed();
		_context = null;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		_splashThread = null;
		ButterKnife.reset(this);
	}

}

