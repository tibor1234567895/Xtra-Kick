package h3;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class m implements o {

    /* renamed from: c  reason: collision with root package name */
    public final IBinder f7192c;

    public m(IBinder iBinder) {
        this.f7192c = iBinder;
    }

    public final void Q(int i10, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            obtain.writeInt(i10);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f7192c.transact(3001, obtain, (Parcel) null, 1)) {
                int i11 = n.f7221c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void a0(int i10, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            obtain.writeInt(i10);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f7192c.transact(3009, obtain, (Parcel) null, 1)) {
                int i11 = n.f7221c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f7192c;
    }

    public final void d(int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            obtain.writeInt(i10);
            if (!this.f7192c.transact(3011, obtain, (Parcel) null, 1)) {
                int i11 = n.f7221c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void d0(int i10, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            obtain.writeInt(i10);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f7192c.transact(3008, obtain, (Parcel) null, 1)) {
                int i11 = n.f7221c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void e0(int i10, Bundle bundle, boolean z10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            obtain.writeInt(i10);
            int i11 = 0;
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (z10) {
                i11 = 1;
            }
            obtain.writeInt(i11);
            if (!this.f7192c.transact(3007, obtain, (Parcel) null, 1)) {
                int i12 = n.f7221c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void g(int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            obtain.writeInt(i10);
            if (!this.f7192c.transact(3006, obtain, (Parcel) null, 1)) {
                int i11 = n.f7221c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void k(int i10, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            obtain.writeInt(i10);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f7192c.transact(3003, obtain, (Parcel) null, 1)) {
                int i11 = n.f7221c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void n0(int i10, Bundle bundle, Bundle bundle2) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            obtain.writeInt(i10);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (bundle2 != null) {
                obtain.writeInt(1);
                bundle2.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f7192c.transact(3013, obtain, (Parcel) null, 1)) {
                int i11 = n.f7221c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void v0(int i10, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            obtain.writeInt(i10);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f7192c.transact(3002, obtain, (Parcel) null, 1)) {
                int i11 = n.f7221c;
            }
        } finally {
            obtain.recycle();
        }
    }
}
