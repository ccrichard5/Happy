package company.com.happy.fragment;


import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import company.com.happy.R;
import company.com.happy.ui.MainActivity;

public class FragmentA extends BaseFragment {

@BindView(R.id.tv_fragment_skip)
    TextView textView_1;
    public FragmentA() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_a, container, false);
        ButterKnife.bind(this,view);
         skip(textView_1);
        return view;
    }


}
