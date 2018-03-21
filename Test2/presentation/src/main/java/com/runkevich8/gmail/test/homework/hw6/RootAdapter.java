package com.runkevich8.gmail.test.homework.hw6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.runkevich8.gmail.test.R;

import java.util.ArrayList;
import java.util.List;



public class RootAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Schedule> itemList = new ArrayList<>();
  //  public List<Schedule> filteredList;

    public void setItems(List<Schedule> itemList) {
        this.itemList.clear();
        this.itemList.addAll(itemList);
        notifyDataSetChanged();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hw6_bus,
                parent, false);
      Context context = parent.getContext();
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder myHolder = (Holder) holder;

        Schedule schedule = itemList.get(position);

        myHolder.busNumber.setText(String.valueOf(schedule.getBusNumber()));
        myHolder.locationStart.setText(schedule.getLocationStart());
        myHolder.locationEnd.setText(schedule.getLocationEnd());
        myHolder.price.setText(String.valueOf(schedule.getPrice()));
        myHolder.dateStart.setText(String.valueOf(schedule.getDateStart()));
        myHolder.dateEnd.setText(String.valueOf(schedule.getDateEnd()));

    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    private static class Holder extends RecyclerView.ViewHolder {
        TextView busNumber;
        TextView locationStart;
        TextView locationEnd;
        TextView price;
        TextView dateStart;
        TextView dateEnd;

        public Holder(View itemView) {
            super(itemView);
            busNumber = itemView.findViewById(R.id.hw6_item_bus_busNumber);
            locationStart = itemView.findViewById(R.id.hw6_item_bus_locationStart);
            locationEnd = itemView.findViewById(R.id.hw6_item_bus_locationEnd);
            price = itemView.findViewById(R.id.hw6_item_bus_price);
            dateStart = itemView.findViewById(R.id.hw6_item_bus_dateStart);
            dateEnd = itemView.findViewById(R.id.hw6_item_bus_dateEnd);
        }
    }
}
//class CustomFilter extends Filter {
//    private List<Schedule> itemList;
//    private RootAdapter mAdapter;
//
//    public CustomFilter(RootAdapter mAdapter) {
//        super();
//        this.mAdapter = mAdapter;
//    }
//
//    @Override
//    protected FilterResults performFiltering(CharSequence constraint) {
//
//        itemList.clear();
//        final FilterResults results = new FilterResults();
//        if (constraint.length() == 0) {
//            itemList.addAll(itemList);
//        } else {
//            final String filterPattern = constraint.toString().toLowerCase().trim();
//            for (final Schedule mWords : itemList) {
//                if (mWords.getLocationStart().toLowerCase().startsWith(filterPattern)) {
//                    itemList.add(mWords);
//                }
//            }
//        }
//        System.out.println("Count Number " + itemList.size());
//        results.values = itemList;
//        results.count = itemList.size();
//        return results;
//    }
//
//    @Override
//    protected void publishResults(CharSequence constraint, FilterResults results) {
//        System.out.println("Count Number 2 " + ((List<Schedule>) results.values).size());
//        this.mAdapter.notifyDataSetChanged();
//    }
//}
