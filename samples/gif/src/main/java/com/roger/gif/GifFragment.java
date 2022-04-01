package com.roger.gif;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class GifFragment extends Fragment {

  static Fragment getInstance() {
    return new GifFragment();
  }

  private ImageView mGifView;
  private GifDrawable mGifDrawable;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_gif, container, false);
    mGifView = view.findViewById((R.id.fullscreen_gif));
    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }

  @Override
  public void onResume() {
    super.onResume();
    Glide.with(this)
        .asGif()
        .load(R.raw.toolbar_mom_animation)
        .addListener(new RequestListener<GifDrawable>() {
          @Override
          public boolean onLoadFailed(@Nullable GlideException e, Object model,
              Target<GifDrawable> target, boolean isFirstResource) {
            return false;
          }

          @Override
          public boolean onResourceReady(GifDrawable resource, Object model,
              Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
            mGifDrawable = resource;
            return false;
          }
        })
        .into(mGifView);
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
  }

  @Override
  public void onDestroy() {
    Log.e(getTag(), "onDestroy " + mGifDrawable.getSize());
//    Glide.with(this).onLowMemory();
//    mGifDrawable.getSize();
//    mGifDrawable.stop();
//    mGifDrawable.recycle();
    super.onDestroy();
  }
}
