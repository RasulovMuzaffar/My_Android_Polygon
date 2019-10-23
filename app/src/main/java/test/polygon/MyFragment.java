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


public class MyFragment extends Fragment implements ItemListDialogFragment.Callback{
    public static final String TAG = "my_fragment";
    final static String MY_DATA = "my_data";

    private TextView btn;
    private TextView txt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_my, container, false);

        txt = getActivity().findViewById(R.id.txt);

        btn = view.findViewById(R.id.btnClick);

        btn.setOnClickListener(v -> {
            ItemListDialogFragment dialogFragment = new ItemListDialogFragment();

            dialogFragment.registerCallBack(new MyFragment());
            dialogFragment.doSomething();

            dialogFragment.show(getFragmentManager(), dialogFragment.getTag());

        });


        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void callingBack(MyItem item) {
        System.out.println("==== "+item);
    }
}
