package r3;

import android.os.IBinder;
import android.os.Parcel;

public final class p implements r {

    /* renamed from: c  reason: collision with root package name */
    public final IBinder f13732c;

    public p(IBinder iBinder) {
        this.f13732c = iBinder;
    }

    public final IBinder asBinder() {
        return this.f13732c;
    }

    public final void b0(int i10, String[] strArr) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
            obtain.writeInt(i10);
            obtain.writeStringArray(strArr);
            this.f13732c.transact(3, obtain, (Parcel) null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final int g0(o oVar, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
            obtain.writeStrongInterface(oVar);
            obtain.writeString(str);
            this.f13732c.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void m0(o oVar, int i10) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
            obtain.writeStrongInterface(oVar);
            obtain.writeInt(i10);
            this.f13732c.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
