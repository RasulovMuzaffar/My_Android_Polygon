package test.polygon;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import test.polygon.POJO.MyItem;
import test.polygon.adapter.MyAdapter;
import test.polygon.db.DBHelper;


public class ItemListDialogFragment extends BottomSheetDialogFragment implements MyAdapter.BottomSheetListener {

    private static final String TAG = "ItemListDialogFragment";

    private BottomSheetBehavior mBehavior;
    public MyAdapter adapter;
    private List<MyItem> mItemList;
    private List<MyItem> mSearchItemList;
    private TextView sheetClose;

    private DBHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mItemList = createItems();
        mSearchItemList = createItems();
        adapter = new MyAdapter(mSearchItemList);
    }

    @Override
    public void onStart() {
        super.onStart();
        mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

        View view = View.inflate(getContext(), R.layout.fragment_item_list_dialog, null);




        final TextView txt = view.findViewById(R.id.txt);

        sheetClose = view.findViewById(R.id.sheet_close);
        sheetClose.setOnClickListener(v -> dialog.dismiss());


        LinearLayout linearLayout = view.findViewById(R.id.bottomSheet);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        params.height = getScreenHeight();
        linearLayout.setLayoutParams(params);

        RecyclerView recyclerView = view.findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        adapter.setmListener(this);
//        adapter.setmListener(item -> {
//            Toast.makeText(getContext(), item.toString(), Toast.LENGTH_SHORT).show();
//            if (callback != null)
//                callback.callingBack(item);

//            dismiss();
//        });


//
        EditText editTextSearch = view.findViewById(R.id.editText);
        editTextSearch.addTextChangedListener(textWatcher);

        dialog.setContentView(view);
        mBehavior = BottomSheetBehavior.from((View) view.getParent());
        return dialog;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mDBHelper = new DBHelper(context);
        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
    }

    public List<MyItem> createItems() {
//        String product = "";
        ArrayList<MyItem> items = new ArrayList<>();

        Cursor cursor = mDb.rawQuery("SELECT * FROM stations LIMIT 20", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            items.add(new MyItem(cursor.getString(2), cursor.getString(3)));
//            product += cursor.getString(2) + " | "+cursor.;
            cursor.moveToNext();
        }
        cursor.close();
//        System.out.println(product);
//        textView.setText(product);

//        items.add(new MyItem("Moscow", "Russia"));
//        items.add(new MyItem("Saint-Petersburg", "Russia"));
//        items.add(new MyItem("Tashkent", "Uzbekistan"));
//        items.add(new MyItem("London", "England"));
//        items.add(new MyItem("Rome", "Italy"));
//        items.add(new MyItem("Madrid", "Spain"));
//        items.add(new MyItem("Berlin", "Germany"));
        return items;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    private TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            search(s.toString().toLowerCase());
        }

    };

    private void search(String searchTerm) {
        mSearchItemList.clear();
        for (MyItem item : mItemList) {
            if (item.getName().toLowerCase().contains(searchTerm)) {
                mSearchItemList.add(item);
                System.out.println(mSearchItemList);
            }
        }

        adapter.notifyDataSetChanged();

    }

    public void onItemClicked(MyItem item) {
        Log.d(TAG, item.toString());
        System.out.println("---------------");
        if (callback != null)
            callback.callingBack(item);
        dismiss();
    }

    interface Callback {
        void callingBack(MyItem item);
    }

    Callback callback;
    MyItem itm;

    public void registerCallBack(Callback callback) {
        this.callback = callback;
    }

    void doSomething() {
        // вызываем метод обратного вызова
        callback.callingBack(itm);
    }
}
