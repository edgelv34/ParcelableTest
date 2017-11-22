package parkwow13.edgelv34.parcelabletest;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by com on 2017-11-22.
 */

public class ParcelableData implements Parcelable{

    String data1;
    String data2;
    String data3;

    public ParcelableData(String data1, String data2, String data3) {
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
    }

    private ParcelableData(Parcel parcel) {
        data1 = parcel.readString();
        data2 = parcel.readString();
        data3 = parcel.readString();
    }

    public String getData1() {
        return data1;
    }

    public String getData2() {
        return data2;
    }

    public String getData3() {
        return data3;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator<ParcelableData>() {
        @Override
        public ParcelableData createFromParcel(Parcel parcel) {
            return new ParcelableData(parcel);
        }

        @Override
        public ParcelableData[] newArray(int size) {
            return new ParcelableData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(data1);
        parcel.writeString(data2);
        parcel.writeString(data3);
    }
}
