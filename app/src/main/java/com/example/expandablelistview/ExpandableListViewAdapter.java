package com.example.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    private String[] provinces;
    private String[][] cities;
    private Context context;

    public ExpandableListViewAdapter(Context context, String[] provinces, String[][] cities) {
        this.provinces = provinces;
        this.cities = cities;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return provinces.length;
    }

    @Override
    public int getChildrenCount(int i) {
        return cities[i].length;
    }

    @Override
    public Object getGroup(int i) {
        return provinces[i];
    }

    @Override
    public Object getChild(int i, int i1) {
        return cities[i][i1];
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean isExpanded, View view, ViewGroup viewGroup) {
        TextView tv_parenttext;
        ImageView iv_parenting;

        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_item, viewGroup, false);

        tv_parenttext = view.findViewById(R.id.tv_parenttext);
        iv_parenting = view.findViewById(R.id.iv_parentimg);

        tv_parenttext.setText(provinces[i]);
        if (isExpanded) {
            iv_parenting.setImageResource(R.mipmap.down);
        } else {
            iv_parenting.setImageResource(R.mipmap.right);
        }
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean isExpanded, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.children_item, viewGroup, false);
        TextView tv_childrentext = view.findViewById(R.id.tv_childrentext);
        tv_childrentext.setText(cities[i][i1]);
        return view;

    }
}
