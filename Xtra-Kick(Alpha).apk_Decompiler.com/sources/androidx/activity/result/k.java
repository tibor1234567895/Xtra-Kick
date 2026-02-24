package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

public final class k implements Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new i();

    /* renamed from: h  reason: collision with root package name */
    public final IntentSender f521h;

    /* renamed from: i  reason: collision with root package name */
    public final Intent f522i;

    /* renamed from: j  reason: collision with root package name */
    public final int f523j;

    /* renamed from: k  reason: collision with root package name */
    public final int f524k;

    public k(IntentSender intentSender, Intent intent, int i10, int i11) {
        this.f521h = intentSender;
        this.f522i = intent;
        this.f523j = i10;
        this.f524k = i11;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f521h, i10);
        parcel.writeParcelable(this.f522i, i10);
        parcel.writeInt(this.f523j);
        parcel.writeInt(this.f524k);
    }

    public k(Parcel parcel) {
        this.f521h = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f522i = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f523j = parcel.readInt();
        this.f524k = parcel.readInt();
    }
}
