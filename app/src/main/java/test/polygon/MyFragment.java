package test.polygon;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import test.polygon.POJO.MyItem;
import test.polygon.adapter.MyAdapter;


public class MyFragment extends Fragment implements MyAdapter.BottomSheetListener {
    public static final String TAG = "my_fragment";
    final static String MY_DATA = "my_data";

    private TextView btn;
    private TextView txt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_my, container, false);


        txt = view.findViewById(R.id.txt);

        btn = view.findViewById(R.id.btnClick);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemListDialogFragment dialogFragment = new ItemListDialogFragment();
                dialogFragment.show(getFragmentManager(), dialogFragment.getTag());
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onItemClicked(MyItem item) {
        txt.setText(item.toString());
    }
}
