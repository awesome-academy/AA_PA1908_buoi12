package vn.sunasterisk.buoi11_implicitintentandmenu.screen.contact;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.sunasterisk.buoi11_implicitintentandmenu.R;
import vn.sunasterisk.buoi11_implicitintentandmenu.base.BaseFragment;
import vn.sunasterisk.buoi11_implicitintentandmenu.model.Contact;
import vn.sunasterisk.buoi11_implicitintentandmenu.screen.profile.ProfileActivity;

public class ContactFragment extends BaseFragment
        implements ContactsAdapter.OnItemListeners {
    public static final String KEY_CONTACT = "key_contact";

    private RecyclerView mRecyclerContacts;
    private ContactsAdapter mContactsAdapter;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_contact;
    }

    @Override
    protected void initComponents(View view) {
        mRecyclerContacts = view.findViewById(R.id.recycler_contacts);
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getActivity(),
                        RecyclerView.VERTICAL,
                        false);
        mRecyclerContacts.setLayoutManager(layoutManager);

        mContactsAdapter = new ContactsAdapter(getContacts());
        mContactsAdapter.setListeners(this);
        mRecyclerContacts.setAdapter(mContactsAdapter);
        mContactsAdapter.notifyDataSetChanged();
    }

    private List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();
        Contact contact1 = new Contact(R.drawable.kaka,
                "Nguyen Van Kaka", "0912213960", "TP Vinh Nghe An");
        Contact contact2 = new Contact(R.drawable.kaka,
                "Nguyen Van Kaka", "0912213960", "Brazil");
        Contact contact3 = new Contact(R.drawable.kaka,
                "Nguyen Van Kaka", "0912213960", "Brazil");
        Contact contact4 = new Contact(R.drawable.kaka,
                "Nguyen Van Kaka", "0912213960", "Brazil");
        Contact contact5 = new Contact(R.drawable.kaka,
                "Nguyen Van Kaka", "0912213960", "Hanoi Vietnam");

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts.add(contact4);
        contacts.add(contact5);

        return contacts;
    }

    @Override
    public void onItemClick(Contact contact) {
        Intent intent = new Intent(getActivity(), ProfileActivity.class);
        /*int avatarId = contact.getAvatarId();
        String name = contact.getName();
        String phone = contact.getPhone();
        String address = contact.getAddress();*/
        intent.putExtra(KEY_CONTACT, contact);

        getContext().startActivity(intent);
    }
}
