package h3;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.media.h;

public abstract class t extends Binder implements u {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f7323c = 0;

    public t() {
        attachInterface(this, "androidx.media3.session.IMediaSessionService");
    }

    public final IBinder asBinder() {
        return this;
    }

    public final boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
        Bundle bundle;
        if (i10 == 3001) {
            o f10 = h.f(parcel, "androidx.media3.session.IMediaSessionService");
            if (parcel.readInt() != 0) {
                bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
            } else {
                bundle = null;
            }
            ((a3) this).r(f10, bundle);
            return true;
        } else if (i10 != 1598968902) {
            return super.onTransact(i10, parcel, parcel2, i11);
        } else {
            parcel2.writeString("androidx.media3.session.IMediaSessionService");
            return true;
        }
    }
}
