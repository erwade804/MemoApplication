package edu.jsu.mcis.cs408.dbexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import edu.jsu.mcis.cs408.dbexample.databinding.ContactItemBinding;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ContactItemBinding binding;
    private List<Memo> data;

    public RecyclerViewAdapter(List<Memo> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        binding = ContactItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ViewHolder holder = new ViewHolder(binding.getRoot());
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setContact(data.get(position));
        holder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private Memo contact;
        private TextView nameLabel;
        private TextView addressLabel;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        public Memo getContact() {
            return contact;
        }

        public void setContact(Memo contact) {
            this.contact = contact;
        }

        public void bindData(int id) {

            if (nameLabel == null) {
                nameLabel = (TextView) itemView.findViewById(R.id.contactNameLabel);
            }
            nameLabel.setText((id+1) + ": " + contact.getName());


        }

    }

}