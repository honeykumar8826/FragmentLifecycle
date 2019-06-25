










package fragmentlifecycle.com.fragmentlifecycle.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fragmentlifecycle.com.fragmentlifecycle.R;


public class SecondFragment extends Fragment {

private TextView showChangeValue;
    public final static String DATA_RECEIVE = "data_receive";
    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

             View view=   inflater.inflate(R.layout.fragment_second, container, false);
             showChangeValue = view.findViewById(R.id.tv_changeValue);
             return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        Bundle args = this.getArguments();
        if (args != null) {
            showChangeValue.setText(args.getString(DATA_RECEIVE));
        }
    }

}
