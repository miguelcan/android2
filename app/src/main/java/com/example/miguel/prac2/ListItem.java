package com.example.miguel.prac2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;


public class ListItem implements Parcelable {
    private String company = null;
    private String business = null;
    private Drawable compLogo = null;

    public ListItem() {

    }

    public ListItem(Parcel source) {
        company = source.readString();
        business = source.readString();

        Bitmap bitmap = (Bitmap) source.readParcelable(((Object) this).getClass().getClassLoader());
        if ( bitmap != null ) {
            compLogo = new BitmapDrawable(bitmap);
        }
        else {
            compLogo = null;
        }

    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(company);
        dest.writeString(business);

        if (compLogo != null) {
            Bitmap bitmap = ((BitmapDrawable) compLogo).getBitmap();
            dest.writeParcelable(bitmap, flags);
        } else {
            dest.writeParcelable(null, flags);
        }
    }

    public static final Parcelable.Creator<ListItem> CREATOR  = new Parcelable.Creator<ListItem>() {
        public ListItem createFromParcel(Parcel in) {
            return new ListItem(in);
        }

        public ListItem[] newArray(int size) {
            return new ListItem[size];
        }
    };

    @Override
    public int hashCode() {
        int result = company != null ? company.hashCode() : 0;
        result = 31 * result + (business != null ? business.hashCode() : 0);
        result = 31 * result + (compLogo != null ? compLogo.hashCode() : 0);
        return result;
    }

    public Drawable getCompLogo() {
        return compLogo;
    }

    public void setCompLogo(Drawable compLogo) {
        this.compLogo = compLogo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

}
