package android.support.v4.media.session;

import android.os.Binder;
import android.os.IBinder;

public abstract class b extends Binder implements c {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f391c = 0;

    public b() {
        attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
    }

    public final IBinder asBinder() {
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.support.v4.media.session.PlaybackStateCompat} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: android.support.v4.media.MediaMetadataCompat} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: android.support.v4.media.session.ParcelableVolumeInfo} */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r0v11, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: type inference failed for: r0v25 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) {
        /*
            r3 = this;
            r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
            r1 = 1
            java.lang.String r2 = "android.support.v4.media.session.IMediaControllerCallback"
            if (r4 == r0) goto L_0x0119
            r0 = 0
            switch(r4) {
                case 1: goto L_0x00f2;
                case 2: goto L_0x00eb;
                case 3: goto L_0x00d2;
                case 4: goto L_0x00bc;
                case 5: goto L_0x00af;
                case 6: goto L_0x0099;
                case 7: goto L_0x0083;
                case 8: goto L_0x006d;
                case 9: goto L_0x005f;
                case 10: goto L_0x0058;
                case 11: goto L_0x0035;
                case 12: goto L_0x0027;
                case 13: goto L_0x0011;
                default: goto L_0x000c;
            }
        L_0x000c:
            boolean r4 = super.onTransact(r4, r5, r6, r7)
            return r4
        L_0x0011:
            r5.enforceInterface(r2)
            r4 = r3
            android.support.v4.media.session.i r4 = (android.support.v4.media.session.i) r4
            java.lang.ref.WeakReference r4 = r4.f399d
            java.lang.Object r4 = r4.get()
            android.support.v4.media.session.j r4 = (android.support.v4.media.session.j) r4
            if (r4 == 0) goto L_0x0026
            r5 = 13
            r4.m(r5, r0, r0)
        L_0x0026:
            return r1
        L_0x0027:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            r5 = r3
            android.support.v4.media.session.i r5 = (android.support.v4.media.session.i) r5
            r5.I(r4)
            return r1
        L_0x0035:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x0040
            r4 = 1
            goto L_0x0041
        L_0x0040:
            r4 = 0
        L_0x0041:
            r5 = r3
            android.support.v4.media.session.i r5 = (android.support.v4.media.session.i) r5
            java.lang.ref.WeakReference r5 = r5.f399d
            java.lang.Object r5 = r5.get()
            android.support.v4.media.session.j r5 = (android.support.v4.media.session.j) r5
            if (r5 == 0) goto L_0x0057
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r6 = 11
            r5.m(r6, r4, r0)
        L_0x0057:
            return r1
        L_0x0058:
            r5.enforceInterface(r2)
            r5.readInt()
            return r1
        L_0x005f:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            r5 = r3
            android.support.v4.media.session.i r5 = (android.support.v4.media.session.i) r5
            r5.a(r4)
            return r1
        L_0x006d:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x007f
            android.os.Parcelable$Creator<android.support.v4.media.session.ParcelableVolumeInfo> r4 = android.support.v4.media.session.ParcelableVolumeInfo.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r5)
            r0 = r4
            android.support.v4.media.session.ParcelableVolumeInfo r0 = (android.support.v4.media.session.ParcelableVolumeInfo) r0
        L_0x007f:
            r3.z0(r0)
            return r1
        L_0x0083:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x0095
            android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r5)
            r0 = r4
            android.os.Bundle r0 = (android.os.Bundle) r0
        L_0x0095:
            r3.J(r0)
            return r1
        L_0x0099:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x00ab
            android.os.Parcelable$Creator r4 = android.text.TextUtils.CHAR_SEQUENCE_CREATOR
            java.lang.Object r4 = r4.createFromParcel(r5)
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
        L_0x00ab:
            r3.e(r0)
            return r1
        L_0x00af:
            r5.enforceInterface(r2)
            android.os.Parcelable$Creator<android.support.v4.media.session.MediaSessionCompat$QueueItem> r4 = android.support.v4.media.session.MediaSessionCompat$QueueItem.CREATOR
            java.util.ArrayList r4 = r5.createTypedArrayList(r4)
            r3.M(r4)
            return r1
        L_0x00bc:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x00ce
            android.os.Parcelable$Creator<android.support.v4.media.MediaMetadataCompat> r4 = android.support.v4.media.MediaMetadataCompat.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r5)
            r0 = r4
            android.support.v4.media.MediaMetadataCompat r0 = (android.support.v4.media.MediaMetadataCompat) r0
        L_0x00ce:
            r3.q(r0)
            return r1
        L_0x00d2:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x00e4
            android.os.Parcelable$Creator<android.support.v4.media.session.PlaybackStateCompat> r4 = android.support.v4.media.session.PlaybackStateCompat.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r5)
            r0 = r4
            android.support.v4.media.session.PlaybackStateCompat r0 = (android.support.v4.media.session.PlaybackStateCompat) r0
        L_0x00e4:
            r4 = r3
            android.support.v4.media.session.i r4 = (android.support.v4.media.session.i) r4
            r4.o0(r0)
            return r1
        L_0x00eb:
            r5.enforceInterface(r2)
            r3.n()
            return r1
        L_0x00f2:
            r5.enforceInterface(r2)
            java.lang.String r4 = r5.readString()
            int r6 = r5.readInt()
            if (r6 == 0) goto L_0x0108
            android.os.Parcelable$Creator r6 = android.os.Bundle.CREATOR
            java.lang.Object r5 = r6.createFromParcel(r5)
            r0 = r5
            android.os.Bundle r0 = (android.os.Bundle) r0
        L_0x0108:
            r5 = r3
            android.support.v4.media.session.i r5 = (android.support.v4.media.session.i) r5
            java.lang.ref.WeakReference r5 = r5.f399d
            java.lang.Object r5 = r5.get()
            android.support.v4.media.session.j r5 = (android.support.v4.media.session.j) r5
            if (r5 == 0) goto L_0x0118
            r5.m(r1, r4, r0)
        L_0x0118:
            return r1
        L_0x0119:
            r6.writeString(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.b.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
