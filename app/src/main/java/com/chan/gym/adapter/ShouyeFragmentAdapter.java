package com.chan.gym.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chan.gym.R;
import com.chan.gym.activities.GymDetailActivity;
import com.chan.gym.beans.GymBean;

import java.util.List;

/**
 * Created by Chan on 2016/6/27.
 *
 * 用于显示首页商家列表的Adapter
 */
public class ShouyeFragmentAdapter
		extends
			RecyclerView.Adapter<ShouyeFragmentAdapter.ShouyeViewHolder> {

	private List<GymBean> dataList;
	private Context context;
	private LayoutInflater inflater;

	public ShouyeFragmentAdapter(Context context, List<GymBean> dataList) {
		this.context = context;
		this.dataList = dataList;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public ShouyeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View itemView = inflater.inflate(R.layout.shouye_item_layout, parent,
				false);
		return new ShouyeViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(ShouyeViewHolder holder, int position) {
		holder.tv.setText(dataList.get(position).getText());
		holder.cv.setOnClickListener (new View.OnClickListener () {
			@Override
			public void onClick (View v) {
				context.startActivity (new Intent (context, GymDetailActivity.class));
			}
		});
	}

	@Override
	public int getItemCount() {
		return dataList.size();
	}

	public static class ShouyeViewHolder extends RecyclerView.ViewHolder {

		TextView tv;
		CardView cv;

		public ShouyeViewHolder(View itemView) {
			super(itemView);
			tv = (TextView) itemView.findViewById(R.id.tv_gymName_item_shouyeFragment);
			cv = (CardView) itemView.findViewById (R.id.cv_shouye_item);
		}
	}

}
