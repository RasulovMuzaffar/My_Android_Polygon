package test.polygon;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

import test.polygon.POJO.MyItem;
import test.polygon.adapter.MyAdapter;


public class ItemListDialogFragment extends BottomSheetDialogFragment implements MyAdapter.BottomSheetListener {

    private static final String TAG = "ItemListDialogFragment";

    private BottomSheetBehavior mBehavior;
    private MyAdapter adapter;
    private List<MyItem> mItemList;
    private TextView sheetClose;
    private CardView cv;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mItemList = createItems();
        adapter = new MyAdapter(mItemList);
    }

    @Override
    public void onStart() {
        super.onStart();
        mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

        View view = View.inflate(getContext(), R.layout.fragment_item_list_dialog, null);

        sheetClose = view.findViewById(R.id.sheet_close);
        sheetClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        cv = view.findViewById(R.id.cv);

        LinearLayout linearLayout = view.findViewById(R.id.bottomSheet);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        params.height = getScreenHeight();
        linearLayout.setLayoutParams(params);

        RecyclerView recyclerView = view.findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
//
//        EditText editTextSearch = view.findViewById(R.id.editTextSearch);
//        editTextSearch.addTextChangedListener(textWatcher);

        dialog.setContentView(view);
        mBehavior = BottomSheetBehavior.from((View) view.getParent());
        return dialog;
    }


    public List<MyItem> createItems() {
        ArrayList<MyItem> items = new ArrayList<>();
        items.add(new MyItem("Moscow", "Russia"));
        items.add(new MyItem("Saint-Petersburg", "Russia"));
        items.add(new MyItem("Tashkent", "Uzbekistan"));
        items.add(new MyItem("London", "England"));
        items.add(new MyItem("Rome", "Italy"));
        items.add(new MyItem("Madrid", "Spain"));
        items.add(new MyItem("Berlin", "Germany"));
        return items;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public void onItemClicked(String text) {
        Log.d(TAG, text);
    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_item_list_dialog, container, false);
//        return view;
//    }
//
//    @Override
//    public void setupDialog(@NonNull Dialog dialog, int style) {
//        View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_item_list_dialog, null);
//        dialog.setContentView(v);
//    }

}
