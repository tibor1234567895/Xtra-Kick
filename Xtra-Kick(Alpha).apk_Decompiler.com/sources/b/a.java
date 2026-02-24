package b;

import android.app.Notification;
import android.os.IBinder;
import android.os.Parcel;

public final class a implements c {

    /* renamed from: c  reason: collision with root package name */
    public final IBinder f2332c;

    public a(IBinder iBinder) {
        this.f2332c = iBinder;
    }

    public final void N(String str) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(c.f2334a);
            obtain.writeString(str);
            this.f2332c.transact(3, obtain, (Parcel) null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void U(int i10, String str, String str2) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(c.f2334a);
            obtain.writeString(str);
            obtain.writeInt(i10);
            obtain.writeString(str2);
            this.f2332c.transact(2, obtain, (Parcel) null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f2332c;
    }

    public final void f0(String str, int i10, String str2, Notification notification) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(c.f2334a);
            obtain.writeString(str);
            obtain.writeInt(i10);
            obtain.writeString(str2);
            if (notification != null) {
                obtain.writeInt(1);
                notification.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f2332c.transact(1, obtain, (Parcel) null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
