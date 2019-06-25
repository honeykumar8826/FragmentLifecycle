package fragmentlifecycle.com.fragmentlifecycle;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import fragmentlifecycle.com.fragmentlifecycle.fragment.FirstFragment;
import fragmentlifecycle.com.fragmentlifecycle.fragment.SecondFragment;
import fragmentlifecycle.com.fragmentlifecycle.fragment.ThirdFragment;

public class MainActivity extends AppCompatActivity implements FirstFragment.DataPassListener {
    private FragmentManager fragmentManager;
    private FrameLayout fl_first,fl_second,fl_third;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: ");
        fl_first = findViewById(R.id.first_container);
        fl_second = findViewById(R.id.second_container);
        fl_third = findViewById(R.id.third_container);

        fragmentManager = getSupportFragmentManager();
        firstFragmetnSetup();
        secondFragmetnSetup();
        thirdFragmetnSetup();
    }

    private void thirdFragmetnSetup() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().add(R.id.first_container,new FirstFragment());
        fragmentTransaction.commit();
    }

    private void secondFragmetnSetup() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().add(R.id.second_container,new SecondFragment());
        fragmentTransaction.commit();
    }

    private void firstFragmetnSetup() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().add(R.id.third_container,new ThirdFragment());
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(TAG, "onSaveInstanceState: ");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState: ");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(TAG, "onConfigurationChanged: ");
    }

    @Override
    public void passData(String data) {
        SecondFragment secondFragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(SecondFragment.DATA_RECEIVE,data);
        secondFragment.setArguments(args);
      FragmentTransaction fragmentTransaction=  fragmentManager.beginTransaction().replace(R.id.second_container,new SecondFragment());
      fragmentTransaction.commit();
    }
}

