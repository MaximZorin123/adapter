package com.example.spiski;

import android.app.GameState;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import java.util.List;

public class GameAdapter extends ArrayAdapter<gam> {

    private LayoutInflater inflater;
    private int layout;
    private List<gam> games;

    public GameAdapter(Context context, int resource, List<gam> games) {
        super(context, resource, games);
        this.games= games;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=inflater.inflate(this.layout, parent, false);
        gam state = games.get(position);
        TextView textView1 = view.findViewById(R.id.capital);
        ImageView flagView = view.findViewById(R.id.flag);
        textView1.setText(state.getOps());
        flagView.setImageResource(state.getFoto());

        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final gam product = games.get(position);

        viewHolder.nameView.setText(product.getName());
        viewHolder.countView.setText(product.getCount() + " " );
        viewHolder.descriptionView.setText(product.getOps());
        viewHolder.photo.setImageResource(product.getFoto());
        viewHolder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = product.getCount() - 1;
                if (count < 0) count = 0;
                product.setCount(count);
                viewHolder.countView.setText(count + " " );
            }
        });
        viewHolder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = product.getCount() + 1;
                product.setCount(count);
                viewHolder.countView.setText(count + " " );
            }
        });

        return convertView;
    }
    private class ViewHolder {
        final Button addButton, removeButton;
        final TextView nameView, countView, descriptionView;
        final ImageView photo;
        ViewHolder(View view) {
            addButton = view.findViewById(R.id.addButton);
            removeButton = view.findViewById(R.id.removeButton);
            nameView = view.findViewById(R.id.name);
            countView = view.findViewById(R.id.countView);
            descriptionView = view.findViewById(R.id.capital);
            photo = view.findViewById(R.id.flag);
        }
    }
}
