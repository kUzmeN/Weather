package com.example.kuzmen.weather.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kuzmen.weather.R;
import com.example.kuzmen.weather.domain.DayInfo;

import java.util.ArrayList;


public class WeatherListAdapter extends ArrayAdapter<DayInfo> {
    private ArrayList<DayInfo> weatherList;
    private LayoutInflater mInflater;

    public WeatherListAdapter(Context context, ArrayList<DayInfo> weatherListFromResponse) {
        super(context, R.layout.item_weather, weatherListFromResponse);
        this.weatherList = new ArrayList<DayInfo>();
        weatherList = weatherListFromResponse;
        this.mInflater = LayoutInflater.from(context);
    }

    private class ViewHolder {
        TextView tvDate;
        TextView tvTempDay;
        TextView tvWeekDay;
    }

    @Override
    public int getCount() {
        return weatherList.size();
    }

    @Override
    public DayInfo getItem(int position) {
        return weatherList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public void add(ArrayList<DayInfo> dayInfoArrayList) {
        int startSize = weatherList.size();
        int finishSize = dayInfoArrayList.size();
        for (int i = startSize; i < finishSize; i++) {
            this.weatherList.add(dayInfoArrayList.get(i));
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {

            convertView = mInflater.inflate(R.layout.item_weather, null);

            holder = new ViewHolder();
            holder.tvDate = (TextView) convertView.findViewById(R.id.tvWeatherListDate);
            holder.tvWeekDay = (TextView) convertView.findViewById(R.id.tvWeatherListWeeakDay);
            holder.tvTempDay = (TextView) convertView.findViewById(R.id.tvWeatherListTempDay);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        DayInfo dayInfo = this.weatherList.get(position);
        holder.tvDate.setText(dayInfo.getDate());
        holder.tvWeekDay.setText(dayInfo.getWeekDay());
        holder.tvTempDay.setText(dayInfo.getTempDay());
        return convertView;

    }

}