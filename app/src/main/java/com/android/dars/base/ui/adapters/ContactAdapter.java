package com.android.dars.base.ui.adapters;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.dars.base.R;
import com.android.dars.base.data.Contact;
import com.android.dars.base.utils.GlideHelper;
import com.bumptech.glide.RequestManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private RequestManager glide;
    private List<Contact> list;
    private Context context;

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.ivPicture)
        ImageView ivPicture;
        @BindView(R.id.tvWithoutPicture)
        TextView tvWithoutPicture;

        ContactViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public ContactAdapter(Context context, RequestManager glide, List<Contact> list) {
        this.context = context;
        this.glide = glide;
        this.list = list;
    }

    public ContactAdapter(Context context, RequestManager glide) {
        this.list = new ArrayList<>();
        this.context = context;
        this.glide = glide;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact contact = list.get(position);

        holder.tvName.setText(context.getResources().getString(
                R.string.main_contact_name,
                contact.getFirst_name(),
                contact.getLast_name()));

        if(contact.getThumb().isEmpty()){
            holder.ivPicture.setImageDrawable(context.getResources().getDrawable(GlideHelper.getRandomCircularColor()));
            holder.tvWithoutPicture.setVisibility(View.VISIBLE);
            holder.tvWithoutPicture.setText(contact.getFirstLetter());

        }else{
            glide
                    .load(contact.getThumb())
                    .placeholder(R.mipmap.placeholder_contact)
                    .error(R.mipmap.ic_error_404)
                    .dontAnimate()
                    .into(holder.ivPicture);
        }

    }

    public Contact getItemPosition(int position) {
        return list.get(position);
    }

}