package com.example.tablayoutlabel.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.tablayoutlabel.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.Arrays;

public class TabFragment extends Fragment {
    private String[] nameDatas = new String[]{"最新","热门","我的"};
    private RecyclerView recyclerView;
    private CommonAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        adapter = new CommonAdapter<String>(getActivity(),R.layout.item, Arrays.asList(nameDatas)) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {}
        };
        recyclerView.setAdapter(adapter);
    }

}
