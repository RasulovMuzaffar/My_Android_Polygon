package test.polygon;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;


public class MyFragment extends Fragment {

    public static final String TAG = "my_fragment";
    private TextView btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_my, container, false);

        btn = view.findViewById(R.id.btnClick);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemListDialogFragment dialogFragment = new ItemListDialogFragment();
                dialogFragment.show(getFragmentManager(), dialogFragment.getTag());
//                BottomSheetBehavior behavior = BottomSheetBehavior.from((View)view.getParent());
//                behavior.setPeekHeight(WindowManager.LayoutParams.MATCH_PARENT);
            }
        });
        return view;
    }

}
