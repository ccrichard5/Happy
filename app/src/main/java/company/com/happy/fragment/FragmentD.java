package company.com.happy.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import company.com.happy.R;
import company.com.happy.ui.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentD extends BaseFragment {


    @BindView(R.id.btn_fragment_skip)
    Button btn_skip;
    public FragmentD() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view= inflater.inflate(R.layout.fragment_d, container, false);
        ButterKnife.bind(this,view);
        skip(btn_skip);
    return view;
    }



}
