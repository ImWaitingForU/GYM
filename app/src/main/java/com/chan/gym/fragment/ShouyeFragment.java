package com.chan.gym.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chan.gym.R;
import com.chan.gym.adapter.ShouyeFragmentAdapter;
import com.chan.gym.beans.GymBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShouyeFragment extends Fragment {

	private View v;

	public ShouyeFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.fragment_shouye, container, false);
		initRecylerView();
		return v;
	}

	private void initRecylerView() {
		RecyclerView rv = (RecyclerView) v.findViewById(R.id.rv_shouyeFragment);
		rv.setLayoutManager(new LinearLayoutManager(getContext()));
		List<GymBean> dataList = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			dataList.add(new GymBean(i + ""));
		}
		ShouyeFragmentAdapter adapter = new ShouyeFragmentAdapter(getContext(),
				dataList);
		rv.setAdapter(adapter);
		rv.addItemDecoration(new RecyclerView.ItemDecoration() {
			@Override
			public void getItemOffsets(Rect outRect, View view,
					RecyclerView parent, RecyclerView.State state) {
				if (parent.getChildLayoutPosition(view) != 0) {
					outRect.top = 5;
				}
			}
		});
	}
}
