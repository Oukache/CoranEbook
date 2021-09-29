package com.oukache.coranebook.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.oukache.coranebook.CEApplication;
import com.oukache.coranebook.R;
import com.oukache.coranebook.util.CELogger;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Oukache on 14/04/2015.
 */
public class SplashScreen extends Activity {

	private Thread _splashThread = null;
	private boolean _bExit = false;
	@BindView(R.id.screen_layout) LinearLayout _screen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		((CEApplication) getApplication()).component().inject(this);
		ButterKnife.bind(this);

		Animation anim = AnimationUtils.loadAnimation(this, R.anim.fade_in);
		_screen.startAnimation(anim);

		_splashThread = new Thread() {
			public void run() {
				try {
					sleep(2000);
				} catch(Exception e) {
					CELogger.error("Splash-Screen error : " + e.getMessage());
				} finally {
					if (!_bExit) {
						Intent intent = new Intent(SplashScreen.this, MainActivity.class);
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
		_bExit = true;
		try {
			_splashThread.join(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			_splashThread = null;
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		_splashThread = null;
	}

}

