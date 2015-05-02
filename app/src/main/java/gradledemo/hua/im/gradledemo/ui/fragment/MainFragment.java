package gradledemo.hua.im.gradledemo.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import gradledemo.hua.im.gradledemo.R;

/**
 * Created by hua on 15-4-18.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
    private Button spinner;

    private FragmentManager fragmentManager;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        fragmentManager = getFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initView(rootView);

        initEvent();

        return rootView;
    }

    private void initEvent() {
        spinner.setOnClickListener(this);
    }

    private void initView(View rootView) {
        spinner = (Button) rootView.findViewById(R.id.main_btn_spinner);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_btn_spinner:
                fragmentManager.beginTransaction().replace(R.id.container,new SpinnerFragment()).addToBackStack("spinner").commit();
            break;
        }
    }
}
