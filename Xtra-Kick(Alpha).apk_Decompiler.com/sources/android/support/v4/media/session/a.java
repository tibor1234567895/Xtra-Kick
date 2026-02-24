package android.support.v4.media.session;

import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.util.ArrayList;

public final class a implements c {

    /* renamed from: c  reason: collision with root package name */
    public final IBinder f376c;

    public a(IBinder iBinder) {
        this.f376c = iBinder;
    }

    public final void I(int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            obtain.writeInt(i10);
            if (!this.f376c.transact(12, obtain, (Parcel) null, 1)) {
                int i11 = b.f391c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void M(ArrayList arrayList) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            obtain.writeTypedList(arrayList);
            if (!this.f376c.transact(5, obtain, (Parcel) null, 1)) {
                int i10 = b.f391c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void a(int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            obtain.writeInt(i10);
            if (!this.f376c.transact(9, obtain, (Parcel) null, 1)) {
                int i11 = b.f391c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f376c;
    }

    public final void e(CharSequence charSequence) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (charSequence != null) {
                obtain.writeInt(1);
                TextUtils.writeToParcel(charSequence, obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f376c.transact(6, obtain, (Parcel) null, 1)) {
                int i10 = b.f391c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void n() {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (!this.f376c.transact(2, obtain, (Parcel) null, 1)) {
                int i10 = b.f391c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void o0(PlaybackStateCompat playbackStateCompat) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (playbackStateCompat != null) {
                obtain.writeInt(1);
                playbackStateCompat.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f376c.transact(3, obtain, (Parcel) null, 1)) {
                int i10 = b.f391c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void q(MediaMetadataCompat mediaMetadataCompat) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (mediaMetadataCompat != null) {
                obtain.writeInt(1);
                obtain.writeBundle(mediaMetadataCompat.f309h);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f376c.transact(4, obtain, (Parcel) null, 1)) {
                int i10 = b.f391c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void z0(ParcelableVolumeInfo parcelableVolumeInfo) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (parcelableVolumeInfo != null) {
                obtain.writeInt(1);
                parcelableVolumeInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f376c.transact(8, obtain, (Parcel) null, 1)) {
                int i10 = b.f391c;
            }
        } finally {
            obtain.recycle();
        }
    }
}
