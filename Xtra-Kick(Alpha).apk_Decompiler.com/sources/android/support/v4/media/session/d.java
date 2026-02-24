package android.support.v4.media.session;

import android.os.IBinder;
import android.os.Parcel;

public final class d implements f {

    /* renamed from: c  reason: collision with root package name */
    public final IBinder f392c;

    public d(IBinder iBinder) {
        this.f392c = iBinder;
    }

    public final int A() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f392c.transact(47, obtain, obtain2, 0)) {
                int i10 = e.f393c;
            }
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int E() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f392c.transact(32, obtain, obtain2, 0)) {
                int i10 = e.f393c;
            }
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean G() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            boolean z10 = false;
            if (!this.f392c.transact(45, obtain, obtain2, 0)) {
                int i10 = e.f393c;
            }
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z10 = true;
            }
            return z10;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void T(c cVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
            if (!this.f392c.transact(4, obtain, obtain2, 0)) {
                int i10 = e.f393c;
            }
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f392c;
    }

    public final PlaybackStateCompat b() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f392c.transact(28, obtain, obtain2, 0)) {
                int i10 = e.f393c;
            }
            obtain2.readException();
            return obtain2.readInt() != 0 ? PlaybackStateCompat.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int h() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (!this.f392c.transact(37, obtain, obtain2, 0)) {
                int i10 = e.f393c;
            }
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void m(c cVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
            if (!this.f392c.transact(3, obtain, obtain2, 0)) {
                int i10 = e.f393c;
            }
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
