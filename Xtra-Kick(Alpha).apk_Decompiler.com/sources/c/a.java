package c;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class a implements c {

    /* renamed from: c  reason: collision with root package name */
    public final IBinder f2707c;

    public a(IBinder iBinder) {
        this.f2707c = iBinder;
    }

    public final IBinder asBinder() {
        return this.f2707c;
    }

    public final void x0(int i10, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(c.f2709b);
            obtain.writeInt(i10);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f2707c.transact(1, obtain, (Parcel) null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
