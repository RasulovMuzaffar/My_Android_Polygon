package test.polygon;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import test.polygon.POJO.MyItem;


public class MyFragment extends Fragment implements ItemListDialogFragment.Callback {
    public static final String TAG = "my_fragment";
    final static String MY_DATA = "my_data";

    private TextView btn;
    private TextView txt;
    private TextView btn2;
    private TextView txt2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_my, container, false);

        txt = view.findViewById(R.id.txt);

        btn = view.findViewById(R.id.btnClick);


        btn.setOnClickListener(v -> {
            flag = 1;
            ItemListDialogFragment dialogFragment = new ItemListDialogFragment();

            dialogFragment.registerCallBack(this);

            dialogFragment.show(getFragmentManager(), dialogFragment.getTag());

        });

        txt2 = view.findViewById(R.id.txt2);

        btn2 = view.findViewById(R.id.btnClick2);

        btn2.setOnClickListener(v -> {
            flag = 2;
            ItemListDialogFragment dialogFragment = new ItemListDialogFragment();

            dialogFragment.registerCallBack(this);

            dialogFragment.show(getFragmentManager(), dialogFragment.getTag());

        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    static int flag = 0;

    @Override
    public void callingBack(MyItem item) {
        if (flag == 1)
            txt.setText(item.toString());
        if (flag == 2)
            txt2.setText(item.toString());
        flag = 0;
    }
}
