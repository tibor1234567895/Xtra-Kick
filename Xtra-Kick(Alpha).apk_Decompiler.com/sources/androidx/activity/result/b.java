package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: h  reason: collision with root package name */
    public final int f502h;

    /* renamed from: i  reason: collision with root package name */
    public final Intent f503i;

    public b(int i10, Intent intent) {
        this.f502h = i10;
        this.f503i = intent;
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("ActivityResult{resultCode=");
        int i10 = this.f502h;
        if (i10 == -1) {
            str = "RESULT_OK";
        } else if (i10 != 0) {
            str = String.valueOf(i10);
        } else {
            str = "RESULT_CANCELED";
        }
        sb2.append(str);
        sb2.append(", data=");
        sb2.append(this.f503i);
        sb2.append('}');
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f502h);
        Intent intent = this.f503i;
        parcel.writeInt(intent == null ? 0 : 1);
        if (intent != null) {
            intent.writeToParcel(parcel, i10);
        }
    }

    public b(Parcel parcel) {
        this.f502h = parcel.readInt();
        this.f503i = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
