package com.example.yerler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class TKYerlerAdapter extends ArrayAdapter<TKYerler> {
    private Context context;
    private int tkLayoutResourceId;
    private ArrayList<TKYerler> tkYerlerListesi;

    public TKYerlerAdapter(Context context, int layoutResourceId, ArrayList<TKYerler> yerlerListesi) {
        super(context, layoutResourceId, yerlerListesi);
        this.context = context;
        this.tkLayoutResourceId = layoutResourceId;
        this.tkYerlerListesi = yerlerListesi;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        TKViewHolder tkHolder;

        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(tkLayoutResourceId, parent, false);

            tkHolder = new TKViewHolder();
            tkHolder.tkImageViewResim = row.findViewById(R.id.imageViewResim);
            tkHolder.tkTextViewIsim = row.findViewById(R.id.textViewIsim);

            row.setTag(tkHolder);
        } else {
            tkHolder = (TKViewHolder) row.getTag();
        }

        TKYerler tkYer = tkYerlerListesi.get(position);
        tkHolder.tkTextViewIsim.setText(tkYer.getTkIsim());
        Picasso.get().load(tkYer.getTkResimUrl()).into(tkHolder.tkImageViewResim);

        return row;
    }

    static class TKViewHolder {
        ImageView tkImageViewResim;
        TextView tkTextViewIsim;
    }
}
