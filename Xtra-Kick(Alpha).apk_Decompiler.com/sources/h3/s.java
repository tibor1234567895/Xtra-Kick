package h3;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class s implements u {

    /* renamed from: c  reason: collision with root package name */
    public final IBinder f7304c;

    public s(IBinder iBinder) {
        this.f7304c = iBinder;
    }

    public final IBinder asBinder() {
        return this.f7304c;
    }

    public final void r(o oVar, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSessionService");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f7304c.transact(3001, obtain, (Parcel) null, 1)) {
                int i10 = t.f7323c;
            }
        } finally {
            obtain.recycle();
        }
    }
}
