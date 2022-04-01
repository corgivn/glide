package com.roger.gif;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
  private FrameLayout mRootView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mRootView = findViewById(R.id.container);

    Button mBtnAdd = findViewById(R.id.btn_add);
    mBtnAdd.setOnClickListener(view -> {
//      for(int i = 0; i < 1000; i++) {
//
//      }
      addFrag();
    });

    Button mBtnRemove = findViewById(R.id.btn_remove);
    mBtnRemove.setOnClickListener(view -> removeFrag());
  }

  private void addFrag() {
    if (VERSION.SDK_INT >= VERSION_CODES.O) {
      Log.e("TAG", "frag size " + getFragmentManager().getFragments().size());
    }
    String tag = "GifFragment" + System.currentTimeMillis();
    FragmentTransaction transaction = getFragmentManager().beginTransaction();
    transaction
        .add(R.id.container, GifFragment.getInstance(), tag)
        .isAddToBackStackAllowed();
    transaction.addToBackStack(tag);
    transaction.commit();
  }

  private void removeFrag() {
    if (VERSION.SDK_INT >= VERSION_CODES.O) {
      Log.e("TAG", "frag size " + getFragmentManager().getFragments().size());
    }
    this.onBackPressed();
  }
}