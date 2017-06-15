package company.com.happy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import company.com.happy.R;


public class FragmentB extends BaseFragment {


    @BindView(R.id.tv_fragment_skip)
    TextView textView_2;
    public FragmentB() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        ButterKnife.bind(this,view);
        skip(textView_2);
        return view;
    }
}
