package vn.sunasterisk.buoi11_implicitintentandmenu.screen.contact;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.sunasterisk.buoi11_implicitintentandmenu.R;
import vn.sunasterisk.buoi11_implicitintentandmenu.model.Contact;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private List<Contact> mContacts;
    private OnItemListeners mListeners;

    public ContactsAdapter(List<Contact> contacts) {
        mContacts = contacts;
    }

    public void setListeners(OnItemListeners listeners) {
        mListeners = listeners;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = mContacts.get(position);
        holder.bindData(contact);
    }

    @Override
    public int getItemCount() {
        return mContacts == null ? 0 : mContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

        private ImageView mImageAvatar;
        private TextView mTextName;
        private TextView mTextPhone;
        private ConstraintLayout mLayoutContact;

        private ImageView mImageOption;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageAvatar = itemView.findViewById(R.id.image_avatar);
            mTextName = itemView.findViewById(R.id.text_name);
            mTextPhone = itemView.findViewById(R.id.text_phone);
            mLayoutContact = itemView.findViewById(R.id.layout_contact);
            mLayoutContact.setOnClickListener(this);

            mImageOption = itemView.findViewById(R.id.image_option);
            mImageOption.setOnClickListener(this);
        }

        public void bindData(Contact contact) {
            //mImageAvatar.setImageResource(contact.getAvatarId());

            Glide.with(itemView.getContext()).load(contact.getAvatarId()).into(mImageAvatar);

            mTextName.setText(contact.getName());
            mTextPhone.setText(contact.getPhone());
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.frame_container:
                    mListeners.onItemClick(mContacts.get(getAdapterPosition()));
                    break;
                case R.id.image_option:
                    showPopupMenu();
                    break;
                default:
                    break;
            }

        }

        private void showPopupMenu() {
            PopupMenu popupMenu = new PopupMenu(itemView.getContext(), mImageOption);
            popupMenu.inflate(R.menu.menu_item);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.item_call:
                    Toast.makeText(itemView.getContext(), "Calling", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.item_send_message:
                    Toast.makeText(itemView.getContext(), "Send msg", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.item_favorite:
                    return true;
                case R.id.item_delete:
                    return true;
                default:
                    return false;
            }
        }
    }

    public interface OnItemListeners {
        void onItemClick(Contact contact);
    }
}
