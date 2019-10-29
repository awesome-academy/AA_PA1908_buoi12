package vn.sunasterisk.buoi11_implicitintentandmenu.screen.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import vn.sunasterisk.buoi11_implicitintentandmenu.R;
import vn.sunasterisk.buoi11_implicitintentandmenu.base.BaseActivity;
import vn.sunasterisk.buoi11_implicitintentandmenu.model.Contact;
import vn.sunasterisk.buoi11_implicitintentandmenu.screen.contact.ContactFragment;

public class ProfileActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mImageAvatar;
    private TextView mTextName;
    private TextView mTextPhone;
    private TextView mTextAddress;

    private TextView mTextWebsite;

    private ImageView mImageCall;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void registerListeners() {
        mImageCall.setOnClickListener(this);
        mTextWebsite.setOnClickListener(this);
        mTextAddress.setOnClickListener(this);
    }

    @Override
    protected void initComponents() {

        initViews();

    }

    private void initViews() {
        mImageAvatar = findViewById(R.id.image_avatar);
        mTextName = findViewById(R.id.text_name);
        mTextPhone = findViewById(R.id.text_phone);
        mTextAddress = findViewById(R.id.text_address);

        mImageCall = findViewById(R.id.image_call);

        mTextWebsite = findViewById(R.id.text_website);

        Intent intent = getIntent();
        if (intent == null) {

            return;
        }

        Contact contact = intent.getParcelableExtra(ContactFragment.KEY_CONTACT);
        //mImageAvatar.setImageResource(contact.getAvatarId());

        Glide.with(this)
                .load(contact.getAvatarId())
                .placeholder(R.drawable.neymar)
                .circleCrop()
                .into(mImageAvatar);
        mTextName.setText(contact.getName());
        mTextPhone.setText(contact.getPhone());
        mTextAddress.setText(contact.getAddress());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_profile_02;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_call:
                call();
                break;
            case R.id.text_website:
                openWebsite();
                break;
            case R.id.text_address:
                openMap();
                break;
            default:
                break;
        }
    }

    private void openMap() {
        String location = mTextAddress.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
        startActivity(intent);
    }

    private void openWebsite() {
        String website = mTextWebsite.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
        startActivity(intent);
    }

    private void call() {
        String phoneNumber = mTextPhone.getText().toString();
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        Uri uri = Uri.parse("tel:" + phoneNumber);
        intent.setData(uri);
        startActivity(intent);
    }
}
