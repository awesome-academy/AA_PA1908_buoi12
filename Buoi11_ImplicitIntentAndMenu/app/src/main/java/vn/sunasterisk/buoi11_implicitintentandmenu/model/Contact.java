package vn.sunasterisk.buoi11_implicitintentandmenu.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class Contact implements Parcelable {
    private int mAvatarId;
    private String mName;
    private String mPhone;
    private String mAddress;

    public Contact() {
    }

    public Contact(int avatarId, String name, String phone, String address) {
        mAvatarId = avatarId;
        mName = name;
        mPhone = phone;
        mAddress = address;
    }

    protected Contact(Parcel in) {
        mAvatarId = in.readInt();
        mName = in.readString();
        mPhone = in.readString();
        mAddress = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public int getAvatarId() {
        return mAvatarId;
    }

    public void setAvatarId(int avatarId) {
        mAvatarId = avatarId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mAvatarId);
        dest.writeString(mName);
        dest.writeString(mPhone);
        dest.writeString(mAddress);
    }
}
