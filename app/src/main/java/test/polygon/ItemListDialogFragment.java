package test.polygon;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class ItemListDialogFragment extends BottomSheetDialogFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list_dialog, container, false);
//        CoordinatorLayout.LayoutParams params  = (CoordinatorLayout.LayoutParams) ((View)view.getParent()).getLayoutParams();
//        CoordinatorLayout.Behavior behavior = params.getBehavior();
//        ((BottomSheetBehavior)behavior).setState(BottomSheetBehavior.STATE_EXPANDED);
//
        return view;
    }

    @Override
    public void setupDialog(@NonNull Dialog dialog, int style) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_item_list_dialog, null);
        dialog.setContentView(v);

//        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) v.getParent()).getLayoutParams();
//        CoordinatorLayout.Behavior behavior = params.getBehavior();
//        ((BottomSheetBehavior) behavior).setState(BottomSheetBehavior.STATE_EXPANDED);

        BottomSheetBehavior.from(v).setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
        BottomSheetBehavior.from(v).setState(BottomSheetBehavior.STATE_EXPANDED);
    }
}
