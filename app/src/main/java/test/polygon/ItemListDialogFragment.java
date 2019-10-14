package test.polygon;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
//        View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_item_list_dialog, null);
//        dialog.setContentView(v);

//        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) v.getParent()).getLayoutParams();
//        CoordinatorLayout.Behavior behavior = params.getBehavior();
//        ((BottomSheetBehavior) behavior).setState(BottomSheetBehavior.STATE_EXPANDED);

//        BottomSheetDialog sheetDialog = (BottomSheetDialog) dialog;
//        sheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
//
//        BottomSheetBehavior behavior=BottomSheetBehavior.from(sheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet));
//        behavior.setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
//        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);


//        BottomSheetBehavior.from(v).setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
//        BottomSheetBehavior.from(v).setState(BottomSheetBehavior.STATE_EXPANDED);


        super.setupDialog(dialog, style);
        View inflatedView = View.inflate(getContext(), R.layout.fragment_item_list_dialog, null);
        dialog.setContentView(inflatedView);


        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) inflatedView.getParent()).getLayoutParams();
        CoordinatorLayout.Behavior behavior = params.getBehavior();

//        if (behavior != null && behavior instanceof BottomSheetBehavior) {
//            ((BottomSheetBehavior) behavior).setBottomSheetCallback(mBottomSheetBehaviorCallback);
//        }

        View parent = (View) inflatedView.getParent();
        parent.setFitsSystemWindows(true);
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(parent);
        inflatedView.measure(0, 0);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenHeight = displaymetrics.heightPixels;
        bottomSheetBehavior.setPeekHeight(screenHeight);

//        if (params.getBehavior() instanceof BottomSheetBehavior) {
//            ((BottomSheetBehavior) params.getBehavior()).setBottomSheetCallback(mBottomSheetBehaviorCallback);
//        }

        params.height = screenHeight;
        parent.setLayoutParams(params);
    }
}
