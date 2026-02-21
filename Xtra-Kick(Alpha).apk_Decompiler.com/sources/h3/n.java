package h3;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public abstract class n extends Binder implements o {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f7221c = 0;

    public n() {
        attachInterface(this, "androidx.media3.session.IMediaController");
    }

    public static o A0(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.media3.session.IMediaController");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof o)) ? new m(iBinder) : (o) queryLocalInterface;
    }

    public final IBinder asBinder() {
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v30, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v33, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v39, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v39, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v45, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v35, resolved type: android.os.Bundle} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTransact(int r7, android.os.Parcel r8, android.os.Parcel r9, int r10) {
        /*
            r6 = this;
            r0 = 4001(0xfa1, float:5.607E-42)
            r1 = 0
            java.lang.String r2 = "MediaControllerStub"
            r3 = 0
            r4 = 1
            java.lang.String r5 = "androidx.media3.session.IMediaController"
            if (r7 == r0) goto L_0x023c
            r0 = 4002(0xfa2, float:5.608E-42)
            if (r7 == r0) goto L_0x01fe
            r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
            if (r7 == r0) goto L_0x01fa
            switch(r7) {
                case 3001: goto L_0x01dd;
                case 3002: goto L_0x01c0;
                case 3003: goto L_0x01a3;
                case 3004: goto L_0x017d;
                case 3005: goto L_0x0134;
                case 3006: goto L_0x0126;
                case 3007: goto L_0x0102;
                case 3008: goto L_0x00e5;
                case 3009: goto L_0x00c8;
                case 3010: goto L_0x007a;
                case 3011: goto L_0x006c;
                case 3012: goto L_0x0049;
                case 3013: goto L_0x001c;
                default: goto L_0x0017;
            }
        L_0x0017:
            boolean r7 = super.onTransact(r7, r8, r9, r10)
            return r7
        L_0x001c:
            r8.enforceInterface(r5)
            int r7 = r8.readInt()
            int r9 = r8.readInt()
            if (r9 == 0) goto L_0x0032
            android.os.Parcelable$Creator r9 = android.os.Bundle.CREATOR
            java.lang.Object r9 = r9.createFromParcel(r8)
            android.os.Bundle r9 = (android.os.Bundle) r9
            goto L_0x0033
        L_0x0032:
            r9 = r3
        L_0x0033:
            int r10 = r8.readInt()
            if (r10 == 0) goto L_0x0042
            android.os.Parcelable$Creator r10 = android.os.Bundle.CREATOR
            java.lang.Object r8 = r10.createFromParcel(r8)
            r3 = r8
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x0042:
            r8 = r6
            h3.o1 r8 = (h3.o1) r8
            r8.n0(r7, r9, r3)
            return r4
        L_0x0049:
            r8.enforceInterface(r5)
            r8.readInt()
            int r7 = r8.readInt()
            if (r7 == 0) goto L_0x005e
            android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
            java.lang.Object r7 = r7.createFromParcel(r8)
            r3 = r7
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x005e:
            r7 = r6
            h3.o1 r7 = (h3.o1) r7
            p0.c r8 = new p0.c
            r9 = 12
            r8.<init>(r9, r3)
            r7.B0(r8)
            return r4
        L_0x006c:
            r8.enforceInterface(r5)
            int r7 = r8.readInt()
            r8 = r6
            h3.o1 r8 = (h3.o1) r8
            r8.d(r7)
            return r4
        L_0x007a:
            r8.enforceInterface(r5)
            r8.readInt()
            int r7 = r8.readInt()
            if (r7 == 0) goto L_0x008f
            android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
            java.lang.Object r7 = r7.createFromParcel(r8)
            android.os.Bundle r7 = (android.os.Bundle) r7
            goto L_0x0090
        L_0x008f:
            r7 = r3
        L_0x0090:
            int r9 = r8.readInt()
            if (r9 == 0) goto L_0x009f
            android.os.Parcelable$Creator r9 = android.os.Bundle.CREATOR
            java.lang.Object r8 = r9.createFromParcel(r8)
            r3 = r8
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x009f:
            r8 = r6
            h3.o1 r8 = (h3.o1) r8
            h3.j3 r9 = h3.h4.f7077k     // Catch:{ RuntimeException -> 0x00c1 }
            g1.m r7 = r9.e(r7)     // Catch:{ RuntimeException -> 0x00c1 }
            h3.h4 r7 = (h3.h4) r7     // Catch:{ RuntimeException -> 0x00c1 }
            g1.a r9 = g1.g1.f6384k     // Catch:{ RuntimeException -> 0x00bd }
            g1.m r9 = r9.e(r3)     // Catch:{ RuntimeException -> 0x00bd }
            g1.g1 r9 = (g1.g1) r9     // Catch:{ RuntimeException -> 0x00bd }
            androidx.fragment.app.g r10 = new androidx.fragment.app.g
            r0 = 25
            r10.<init>(r7, r0, r9)
            r8.B0(r10)
            goto L_0x00c7
        L_0x00bd:
            r7 = move-exception
            java.lang.String r8 = "Ignoring malformed Bundle for Commands"
            goto L_0x00c4
        L_0x00c1:
            r7 = move-exception
            java.lang.String r8 = "Ignoring malformed Bundle for SessionCommands"
        L_0x00c4:
            j1.v.h(r2, r8, r7)
        L_0x00c7:
            return r4
        L_0x00c8:
            r8.enforceInterface(r5)
            int r7 = r8.readInt()
            int r9 = r8.readInt()
            if (r9 == 0) goto L_0x00de
            android.os.Parcelable$Creator r9 = android.os.Bundle.CREATOR
            java.lang.Object r8 = r9.createFromParcel(r8)
            r3 = r8
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x00de:
            r8 = r6
            h3.o1 r8 = (h3.o1) r8
            r8.a0(r7, r3)
            return r4
        L_0x00e5:
            r8.enforceInterface(r5)
            int r7 = r8.readInt()
            int r9 = r8.readInt()
            if (r9 == 0) goto L_0x00fb
            android.os.Parcelable$Creator r9 = android.os.Bundle.CREATOR
            java.lang.Object r8 = r9.createFromParcel(r8)
            r3 = r8
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x00fb:
            r8 = r6
            h3.o1 r8 = (h3.o1) r8
            r8.d0(r7, r3)
            return r4
        L_0x0102:
            r8.enforceInterface(r5)
            int r7 = r8.readInt()
            int r9 = r8.readInt()
            if (r9 == 0) goto L_0x0118
            android.os.Parcelable$Creator r9 = android.os.Bundle.CREATOR
            java.lang.Object r9 = r9.createFromParcel(r8)
            r3 = r9
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x0118:
            int r8 = r8.readInt()
            if (r8 == 0) goto L_0x011f
            r1 = 1
        L_0x011f:
            r8 = r6
            h3.o1 r8 = (h3.o1) r8
            r8.e0(r7, r3, r1)
            return r4
        L_0x0126:
            r8.enforceInterface(r5)
            int r7 = r8.readInt()
            r8 = r6
            h3.o1 r8 = (h3.o1) r8
            r8.g(r7)
            return r4
        L_0x0134:
            r8.enforceInterface(r5)
            int r7 = r8.readInt()
            int r9 = r8.readInt()
            if (r9 == 0) goto L_0x014a
            android.os.Parcelable$Creator r9 = android.os.Bundle.CREATOR
            java.lang.Object r9 = r9.createFromParcel(r8)
            android.os.Bundle r9 = (android.os.Bundle) r9
            goto L_0x014b
        L_0x014a:
            r9 = r3
        L_0x014b:
            int r10 = r8.readInt()
            if (r10 == 0) goto L_0x015a
            android.os.Parcelable$Creator r10 = android.os.Bundle.CREATOR
            java.lang.Object r8 = r10.createFromParcel(r8)
            r3 = r8
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x015a:
            r8 = r6
            h3.o1 r8 = (h3.o1) r8
            if (r3 != 0) goto L_0x0165
            java.lang.String r7 = "Ignoring custom command with null args."
            j1.v.g(r2, r7)
            goto L_0x017c
        L_0x0165:
            h3.j3 r10 = h3.f4.f7033o     // Catch:{ RuntimeException -> 0x0176 }
            g1.m r9 = r10.e(r9)     // Catch:{ RuntimeException -> 0x0176 }
            h3.f4 r9 = (h3.f4) r9     // Catch:{ RuntimeException -> 0x0176 }
            n1.h r10 = new n1.h
            r10.<init>((int) r7, (h3.f4) r9, (android.os.Bundle) r3)
            r8.B0(r10)
            goto L_0x017c
        L_0x0176:
            r7 = move-exception
            java.lang.String r8 = "Ignoring malformed Bundle for SessionCommand"
            j1.v.h(r2, r8, r7)
        L_0x017c:
            return r4
        L_0x017d:
            r8.enforceInterface(r5)
            int r7 = r8.readInt()
            android.os.Parcelable$Creator r9 = android.os.Bundle.CREATOR
            java.util.ArrayList r8 = r8.createTypedArrayList(r9)
            r9 = r6
            h3.o1 r9 = (h3.o1) r9
            f3.a r10 = h3.d.f6970t     // Catch:{ RuntimeException -> 0x019c }
            d9.r1 r8 = j1.c.a(r10, r8)     // Catch:{ RuntimeException -> 0x019c }
            e7.b r10 = new e7.b
            r10.<init>((int) r7, (java.lang.Object) r8)
            r9.B0(r10)
            goto L_0x01a2
        L_0x019c:
            r7 = move-exception
            java.lang.String r8 = "Ignoring malformed Bundle for CommandButton"
            j1.v.h(r2, r8, r7)
        L_0x01a2:
            return r4
        L_0x01a3:
            r8.enforceInterface(r5)
            int r7 = r8.readInt()
            int r9 = r8.readInt()
            if (r9 == 0) goto L_0x01b9
            android.os.Parcelable$Creator r9 = android.os.Bundle.CREATOR
            java.lang.Object r8 = r9.createFromParcel(r8)
            r3 = r8
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x01b9:
            r8 = r6
            h3.o1 r8 = (h3.o1) r8
            r8.k(r7, r3)
            return r4
        L_0x01c0:
            r8.enforceInterface(r5)
            int r7 = r8.readInt()
            int r9 = r8.readInt()
            if (r9 == 0) goto L_0x01d6
            android.os.Parcelable$Creator r9 = android.os.Bundle.CREATOR
            java.lang.Object r8 = r9.createFromParcel(r8)
            r3 = r8
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x01d6:
            r8 = r6
            h3.o1 r8 = (h3.o1) r8
            r8.v0(r7, r3)
            return r4
        L_0x01dd:
            r8.enforceInterface(r5)
            int r7 = r8.readInt()
            int r9 = r8.readInt()
            if (r9 == 0) goto L_0x01f3
            android.os.Parcelable$Creator r9 = android.os.Bundle.CREATOR
            java.lang.Object r8 = r9.createFromParcel(r8)
            r3 = r8
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x01f3:
            r8 = r6
            h3.o1 r8 = (h3.o1) r8
            r8.Q(r7, r3)
            return r4
        L_0x01fa:
            r9.writeString(r5)
            return r4
        L_0x01fe:
            r8.enforceInterface(r5)
            r8.readInt()
            java.lang.String r7 = r8.readString()
            int r9 = r8.readInt()
            int r10 = r8.readInt()
            if (r10 == 0) goto L_0x021b
            android.os.Parcelable$Creator r10 = android.os.Bundle.CREATOR
            java.lang.Object r8 = r10.createFromParcel(r8)
            r3 = r8
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x021b:
            r8 = r6
            h3.o1 r8 = (h3.o1) r8
            boolean r10 = android.text.TextUtils.isEmpty(r7)
            if (r10 == 0) goto L_0x0227
            java.lang.String r7 = "onSearchResultChanged(): Ignoring empty query"
            goto L_0x022f
        L_0x0227:
            if (r9 >= 0) goto L_0x0233
            java.lang.String r7 = "onSearchResultChanged(): Ignoring negative itemCount: "
            java.lang.String r7 = android.support.v4.media.h.i(r7, r9)
        L_0x022f:
            j1.v.g(r2, r7)
            goto L_0x023b
        L_0x0233:
            g1.a r10 = new g1.a
            r10.<init>(r9, r4, r3, r7)
            r8.B0(r10)
        L_0x023b:
            return r4
        L_0x023c:
            r8.enforceInterface(r5)
            r8.readInt()
            java.lang.String r7 = r8.readString()
            int r9 = r8.readInt()
            int r10 = r8.readInt()
            if (r10 == 0) goto L_0x0259
            android.os.Parcelable$Creator r10 = android.os.Bundle.CREATOR
            java.lang.Object r8 = r10.createFromParcel(r8)
            r3 = r8
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x0259:
            r8 = r6
            h3.o1 r8 = (h3.o1) r8
            boolean r10 = android.text.TextUtils.isEmpty(r7)
            if (r10 == 0) goto L_0x0265
            java.lang.String r7 = "onChildrenChanged(): Ignoring empty parentId"
            goto L_0x026d
        L_0x0265:
            if (r9 >= 0) goto L_0x0271
            java.lang.String r7 = "onChildrenChanged(): Ignoring negative itemCount: "
            java.lang.String r7 = android.support.v4.media.h.i(r7, r9)
        L_0x026d:
            j1.v.g(r2, r7)
            goto L_0x0279
        L_0x0271:
            g1.a r10 = new g1.a
            r10.<init>(r9, r1, r3, r7)
            r8.B0(r10)
        L_0x0279:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.n.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
