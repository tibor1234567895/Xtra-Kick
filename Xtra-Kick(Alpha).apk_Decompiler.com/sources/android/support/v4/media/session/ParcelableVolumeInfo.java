package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new n0();

    /* renamed from: h  reason: collision with root package name */
    public final int f354h;

    /* renamed from: i  reason: collision with root package name */
    public final int f355i;

    /* renamed from: j  reason: collision with root package name */
    public final int f356j;

    /* renamed from: k  reason: collision with root package name */
    public final int f357k;

    /* renamed from: l  reason: collision with root package name */
    public final int f358l;

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f354h = parcel.readInt();
        this.f356j = parcel.readInt();
        this.f357k = parcel.readInt();
        this.f358l = parcel.readInt();
        this.f355i = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f354h);
        parcel.writeInt(this.f356j);
        parcel.writeInt(this.f357k);
        parcel.writeInt(this.f358l);
        parcel.writeInt(this.f355i);
    }
}
