package com.runkevich8.gmail.test.classwork.classwork6;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.runkevich8.gmail.test.R;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<User> itemList = new ArrayList<>();
    private OnUserClickListener listener;

    public void setItems(List<User> itemList) {
        this.itemList.clear();
        this.itemList.addAll(itemList);
        notifyDataSetChanged();  //поменялись данные - перерисуй их на экране
    }

    public void setListener(OnUserClickListener listener) {
        this.listener = listener;
    }

    //перевод xml в layout
    //создает холдер,которые содержит - ,он кешируется,
    // т.е. для разных позиций может использоваться один и тот же холдер

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,
                parent, false);
        return new Holder(view);
    }

    //для каждого item -------> onBindViewHolder,используется дл заполнения данных item- один элемент
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        Holder myHolder = (Holder) holder;

        final User user = itemList.get(position);

        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null) listener.onClick(user,position);
            }
        });

        // Glide.with(myHolder.imageView.getContext()).load("sova_anmation_1.png").into(myHolder.imageView);
        // myHolder.imageView.set//FIXME Implement Glide
        myHolder.nameTextView.setText(user.getName());
        myHolder.surnameTextView.setText(user.getSurname());
    }

    //возвращаем количество элементов
    @Override
    public int getItemCount() {
        return itemList.size();
    }

    //технический класс для хранения item и ссылок на элементы
    private static class Holder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView surnameTextView;
        ImageView imageView;

        public Holder(View itemView) {
            super(itemView);
            Log.e("UserAdaaaaaaaaaaaapter", "Holder");
            imageView = itemView.findViewById(R.id.image_cw6);
            nameTextView = itemView.findViewById(R.id.textView1_cw6);
            surnameTextView = itemView.findViewById(R.id.textView2_cw6);
        }
    }

    interface OnUserClickListener {
        void onClick(User user, int position);
    }

}
