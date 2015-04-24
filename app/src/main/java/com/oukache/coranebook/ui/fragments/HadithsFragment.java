package com.oukache.coranebook.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.oukache.coranebook.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Oukache on 14/04/2015.
 */
public class HadithsFragment extends Fragment {

	@InjectView(R.id.title_bar_layout) LinearLayout _titleBar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);

		View root = inflater.inflate(R.layout.fragment_hadiths, container, false);
		ButterKnife.inject(this, root);


		((TextView) _titleBar.findViewById(R.id.title_bar_tv_title)).setText("Hadiths");

		return root;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		ButterKnife.reset(this);
	}

}
