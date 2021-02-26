package com.example.ecommerceapp.util.dataBinding;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;


import com.example.ecommerceapp.R;
import com.example.ecommerceapp.feature.onBourding.OnBoarding;
import com.example.ecommerceapp.feature.onBourding.OnBoardingPagerAdapter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.util.ArrayList;

@InverseBindingMethods(value = {@InverseBindingMethod(type = MaterialButton.class, attribute = "android:checked")})
public class BindingAdapterUtils {

    @BindingAdapter("textChange")
    public static void setTextChange(EditText view, TextChange mTextChange) {
        view.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTextChange.onChange(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @BindingAdapter("textViewChange")
    public static void setTextChange(TextView view, TextChange mTextChange) {
        view.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTextChange.onChange(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @BindingAdapter("errorText")
    public static void setErrorText(TextInputLayout view, Integer errorRes) {
        if (errorRes == null || errorRes == 0) {
            view.setError("");
        } else {
            view.setError(view.getContext().getResources().getString(errorRes));
        }
    }





    @BindingAdapter("marginDecoration")
    public static void setMarginDecoration(RecyclerView view, int margin) {
        MarginDecoration marginDecoration = new MarginDecoration(view.getContext(), margin);
        view.addItemDecoration(marginDecoration);
    }


    @BindingAdapter("android:src")
    public static void setImageResource(ImageView view, int imgRes) {
        if (imgRes == 0) return;
        view.setImageResource(imgRes);
    }

    @BindingAdapter("android:text")
    public static void setTextRes(TextView view, int textRes) {
        if (textRes == 0) return;
        view.setText(textRes);
    }





    @BindingAdapter({"isVisible"})
    public static void setIsVisible(View view, boolean isVisible) {
        if (isVisible) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    @BindingAdapter({"loadImage"})
    public static void loadImage(SimpleDraweeView view, String url) {
        Log.e("LoadImage", "URL : " + url);
        DraweeController mDraweeController;
        if (URLUtil.isValidUrl(url)) {
            mDraweeController = Fresco.newDraweeControllerBuilder()
                    .setUri(url)
                    .setAutoPlayAnimations(true)
                    .build();
        } else if (url != null && !url.isEmpty()) {
            Uri picUri = Uri.fromFile(new File(url));
            ImageRequest mImageRequest = ImageRequestBuilder.newBuilderWithSource(picUri).build();
            mDraweeController = Fresco.newDraweeControllerBuilder()
                    .setUri(mImageRequest.getSourceUri())
                    .setAutoPlayAnimations(true)
                    .build();
        } else {
            ImageRequest mImageRequest = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.ic_launcher_background).build();
            mDraweeController = Fresco.newDraweeControllerBuilder()
                    .setUri(mImageRequest.getSourceUri())
                    .setAutoPlayAnimations(true)
                    .build();
        }
        view.setController(mDraweeController);
    }





    @BindingAdapter("bottomSheetState")
    public static void setBottomSheetState(View view, int state) {
        //BottomSheetBehavior.from(view).setState(state);
        BottomSheetBehavior behavior = BottomSheetBehavior.from(view);
        //behavior.setFitToContents(false);
        behavior.setState(state);
        //behavior.setHalfExpandedRatio(0.0000001f);
    }

    @BindingAdapter("imageColor")
    public static void setImageColor(ImageView view, int color) {
        view.setColorFilter(view.getContext().getResources().getColor(color));
    }

    @BindingAdapter("textColor")
    public static void setTextColor(TextView view, int color) {
        view.setTextColor(view.getContext().getResources().getColor(color));
    }


    @BindingAdapter({"chip"})
    public static void makeChip(Chip chip, String name) {
        //   chip = new Chip();
        chip.setText(name);
        //chip.setChipIcon(ContextCompat.getDrawable(requireActivity(), R.drawable.ic_close));
        chip.setCloseIconVisible(true);
        chip.setCheckable(false);
        chip.setClickable(false);
        chip.setPadding(60, 10, 60, 10);
        //chip.setOnCloseIconClickListener(View.OnClickListener);
    }



//
//    @BindingAdapter({"fragmentActivity", "fragmentManager", "viewPager2List"})
//    public static void setFragmentViewPager2(ViewPager2 view, FragmentActivity fragmentActivity, FragmentManager fragmentManager, ArrayList<Fragment> data) {
//        AddCarViewPagerAdapter adapter = new AddCarViewPagerAdapter(fragmentActivity, fragmentManager, data);
//        view.setAdapter(adapter);
//        view.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
//    }

    @BindingAdapter("currentPage")
    public static void setCurrentPage(ViewPager2 view, int currentPage) {
        view.setCurrentItem(currentPage);
    }
    @BindingAdapter("currentPage")
    public static void setCurrentPage(ViewPager view, int currentPage) {
        view.setCurrentItem(currentPage);
    }
    @BindingAdapter("viewPageListener")
    public static void setViewPagerListener(ViewPager view, ViewPager.OnPageChangeListener onPageChangeListener) {
        view.addOnPageChangeListener(onPageChangeListener);
    }

    @BindingAdapter("viewPageListener")
    public static void setViewPagerListener(ViewPager2 view, ViewPager2.OnPageChangeCallback onPageChangeListener) {
        view.registerOnPageChangeCallback(onPageChangeListener);
    }
    @BindingAdapter({"fragmentManager", "viewPagerList"})
    public static void setFragmentViewPager(ViewPager view, FragmentManager fragmentManager, ArrayList<OnBoarding> onBoardingArrayList) {
        OnBoardingPagerAdapter adapter = new OnBoardingPagerAdapter(fragmentManager, onBoardingArrayList);
        view.setAdapter(adapter);
    }





    @BindingAdapter({"checkedClick"})
    public static void setCheckedButton(MaterialButtonToggleGroup button, int id) {
        button.check(id);
    }


    @BindingAdapter({"onToggleButtonClick"})
    public static void onToggleButtonClick(MaterialButtonToggleGroup button, MaterialButtonToggleGroup.OnButtonCheckedListener listener) {
        button.addOnButtonCheckedListener(listener);
    }

    @SuppressLint("ResourceAsColor")
    @BindingAdapter({"android:checked"})
    public static void setChecked(MaterialButton view, boolean checked) {
        if (view.isChecked() != checked) {
            view.setChecked(checked);
        } else {
            if (view.isChecked()) {
                view.setBackgroundColor(Color.parseColor("#DFDFDF"));
                view.setTextColor(Color.parseColor("#BA1928"));
            } else {
                view.setBackgroundColor(Color.parseColor("#ffffff"));
                view.setTextColor(Color.parseColor("#666666"));
            }
        }
    }

    @BindingAdapter(value = {"android:checkedAttrChanged"}, requireAll = false)
    public static void setListeners(MaterialButton view, final InverseBindingListener attrChange) {
        if (attrChange != null) {
            view.clearOnCheckedChangeListeners();
            view.addOnCheckedChangeListener(new MaterialButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(MaterialButton buttonView, boolean isChecked) {
                    attrChange.onChange();
                }
            });
        }
    }

    @BindingAdapter("rating")
    public static void setRating(RatingBar view, String rating) {
        if (view != null) {
            float rate = Float.parseFloat(rating);
            view.setRating(rate);
        }
    }
    @BindingAdapter("setTab")
    public static void setViewPagerToTab(TabLayout view, ViewPager viewPager) {
        view.setupWithViewPager(viewPager);
    }














    @BindingAdapter({"setImgeUri", "setBitmapImge"})
    public static void setImgeUri(ImageView view, Uri uri, Bitmap bitmap) {
        if (uri != null) {
            Log.d("ewfewew", "" + uri);
            view.setImageURI(uri);
            if (bitmap != null) {
                view.setImageBitmap(bitmap);
            }
        } else {
            view.setImageBitmap(bitmap);
        }
    }


}

