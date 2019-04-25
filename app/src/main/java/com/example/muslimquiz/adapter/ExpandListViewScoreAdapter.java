package com.example.muslimquiz.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.muslimquiz.R;
import com.example.muslimquiz.model.Continent;
import com.example.muslimquiz.model.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpandListViewScoreAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<Continent> continentList;
    private ArrayList<Continent> originalList;

    public ExpandListViewScoreAdapter(Context context, ArrayList<Continent> continentList) {
        this.context = context;
        this.continentList = new ArrayList<Continent>();
        this.continentList.addAll(continentList);
        this.originalList = new ArrayList<Continent>();
        this.originalList.addAll(continentList);
    }

    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<Score> countryList = continentList.get(groupPosition).getScoreList();
        return countryList.get(childPosition);
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        Score score = (Score) getChild(groupPosition, childPosition);
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.child_score_layout, null);
        }

        TextView item = view.findViewById(R.id.category_level);
        TextView sumcoint = view.findViewById(R.id.category_level_count);

        ImageView delete = view.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        item.setText(score.getName().trim());
        sumcoint.setText(score.getPoint());
        return view;
    }

    public int getChildrenCount(int groupPosition) {
        ArrayList<Score> countryList = continentList.get(groupPosition).getScoreList();
        return countryList.size();
    }

    public Object getGroup(int groupPosition) {
        return continentList.get(groupPosition);
    }

    public int getGroupCount() {
        return continentList.size();
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        Continent continent = (Continent) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.parent_score_layout, null);
        }

        TextView item = convertView.findViewById(R.id.category);
        item.setTypeface(null, Typeface.BOLD);
        item.setText(continent.getName().trim());
        return convertView;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
