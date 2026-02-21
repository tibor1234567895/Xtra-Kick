package r3;

import android.os.IBinder;
import android.os.Parcel;

public final class m implements o {

    /* renamed from: c  reason: collision with root package name */
    public final IBinder f13714c;

    public m(IBinder iBinder) {
        this.f13714c = iBinder;
    }

    public final void F(String[] strArr) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
            obtain.writeStringArray(strArr);
            this.f13714c.transact(1, obtain, (Parcel) null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f13714c;
    }
}
