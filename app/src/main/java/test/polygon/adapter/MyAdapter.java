package test.polygon.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import test.polygon.POJO.MyItem;
import test.polygon.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private static final String TAG = "MyAdapter";

    private BottomSheetListener mListener;
    private List<MyItem> mList;


    public MyAdapter(List<MyItem> list) {
        this.mList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_list_dialog_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final MyItem item = this.mList.get(position);

        holder.name.setText(item.getName());
        holder.gov.setText(item.getGov());


        holder.itemView.setOnClickListener(v -> {
            if (mListener != null)
                mListener.onItemClicked(item);
            Log.d(TAG, item.toString());
        });
    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        return mList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView gov;

        MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.city);
            gov = itemView.findViewById(R.id.gov);
        }
    }

    public interface BottomSheetListener {
        void onItemClicked(MyItem item);
    }

    public void setmListener(BottomSheetListener listener) {
        this.mListener = listener;
    }
}
