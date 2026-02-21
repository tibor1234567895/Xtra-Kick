package android.support.v4.media.session;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public abstract class e extends Binder implements f {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f393c = 0;

    public e() {
        attachInterface(this, "android.support.v4.media.session.IMediaSession");
    }

    public static f A0(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof f)) ? new d(iBinder) : (f) queryLocalInterface;
    }

    public final IBinder asBinder() {
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v35, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v38, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v41, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v44, resolved type: android.os.Bundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v46, resolved type: android.os.Bundle} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.os.ResultReceiver] */
    /* JADX WARNING: type inference failed for: r3v6, types: [android.support.v4.media.session.c] */
    /* JADX WARNING: type inference failed for: r3v10, types: [android.support.v4.media.session.c] */
    /* JADX WARNING: type inference failed for: r3v49 */
    /* JADX WARNING: type inference failed for: r3v50 */
    /* JADX WARNING: type inference failed for: r3v51 */
    /* JADX WARNING: type inference failed for: r3v52 */
    /* JADX WARNING: type inference failed for: r3v53 */
    /* JADX WARNING: type inference failed for: r3v54 */
    /* JADX WARNING: type inference failed for: r3v55 */
    /* JADX WARNING: type inference failed for: r3v56 */
    /* JADX WARNING: type inference failed for: r3v57 */
    /* JADX WARNING: type inference failed for: r3v58 */
    /* JADX WARNING: type inference failed for: r3v59 */
    /* JADX WARNING: type inference failed for: r3v60 */
    /* JADX WARNING: type inference failed for: r3v61 */
    /* JADX WARNING: type inference failed for: r3v62 */
    /* JADX WARNING: type inference failed for: r3v63 */
    /* JADX WARNING: type inference failed for: r3v64 */
    /* JADX WARNING: type inference failed for: r3v65 */
    /* JADX WARNING: type inference failed for: r3v66 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTransact(int r11, android.os.Parcel r12, android.os.Parcel r13, int r14) {
        /*
            r10 = this;
            java.lang.String r0 = "android.support.v4.media.session.IMediaSession"
            r1 = 1598968902(0x5f4e5446, float:1.4867585E19)
            r2 = 1
            if (r11 == r1) goto L_0x0584
            r1 = 0
            r3 = 0
            switch(r11) {
                case 1: goto L_0x053d;
                case 2: goto L_0x0510;
                case 3: goto L_0x04e7;
                case 4: goto L_0x04be;
                case 5: goto L_0x04a5;
                case 6: goto L_0x0485;
                case 7: goto L_0x0465;
                case 8: goto L_0x044b;
                case 9: goto L_0x0441;
                case 10: goto L_0x0437;
                case 11: goto L_0x0414;
                case 12: goto L_0x03f1;
                case 13: goto L_0x03e4;
                case 14: goto L_0x03c4;
                case 15: goto L_0x03a4;
                case 16: goto L_0x0378;
                case 17: goto L_0x0367;
                case 18: goto L_0x035a;
                case 19: goto L_0x034d;
                case 20: goto L_0x0340;
                case 21: goto L_0x0333;
                case 22: goto L_0x0326;
                case 23: goto L_0x0319;
                case 24: goto L_0x0308;
                case 25: goto L_0x02de;
                case 26: goto L_0x02be;
                case 27: goto L_0x029e;
                case 28: goto L_0x0284;
                case 29: goto L_0x0274;
                case 30: goto L_0x0254;
                case 31: goto L_0x024a;
                case 32: goto L_0x0239;
                case 33: goto L_0x022c;
                case 34: goto L_0x020c;
                case 35: goto L_0x01ec;
                case 36: goto L_0x01c0;
                case 37: goto L_0x01af;
                case 38: goto L_0x01a5;
                case 39: goto L_0x0194;
                case 40: goto L_0x018a;
                case 41: goto L_0x0160;
                case 42: goto L_0x0135;
                case 43: goto L_0x010b;
                case 44: goto L_0x00e7;
                case 45: goto L_0x00d7;
                case 46: goto L_0x00b1;
                case 47: goto L_0x00a0;
                case 48: goto L_0x008f;
                case 49: goto L_0x007e;
                case 50: goto L_0x004c;
                case 51: goto L_0x0012;
                default: goto L_0x000d;
            }
        L_0x000d:
            boolean r11 = super.onTransact(r11, r12, r13, r14)
            return r11
        L_0x0012:
            r12.enforceInterface(r0)
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x0024
            android.os.Parcelable$Creator<android.support.v4.media.RatingCompat> r11 = android.support.v4.media.RatingCompat.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            android.support.v4.media.RatingCompat r11 = (android.support.v4.media.RatingCompat) r11
            goto L_0x0025
        L_0x0024:
            r11 = r3
        L_0x0025:
            int r14 = r12.readInt()
            if (r14 == 0) goto L_0x0034
            android.os.Parcelable$Creator r14 = android.os.Bundle.CREATOR
            java.lang.Object r12 = r14.createFromParcel(r12)
            r3 = r12
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x0034:
            r12 = r10
            android.support.v4.media.session.h0 r12 = (android.support.v4.media.session.h0) r12
            int r14 = r12.f397d
            switch(r14) {
                case 0: goto L_0x003d;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x0046
        L_0x003d:
            r14 = 31
            r12.O0(r14, r11, r3)
            r13.writeNoException()
            return r2
        L_0x0046:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        L_0x004c:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r12 = r11.f397d
            android.support.v4.media.session.z r11 = r11.f398e
            switch(r12) {
                case 0: goto L_0x005a;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x0060
        L_0x005a:
            android.support.v4.media.session.i0 r11 = (android.support.v4.media.session.i0) r11
            r11.getClass()
            goto L_0x006e
        L_0x0060:
            android.support.v4.media.session.a0 r11 = (android.support.v4.media.session.a0) r11
            android.os.Bundle r12 = r11.f380d
            if (r12 != 0) goto L_0x0067
            goto L_0x006e
        L_0x0067:
            android.os.Bundle r3 = new android.os.Bundle
            android.os.Bundle r11 = r11.f380d
            r3.<init>(r11)
        L_0x006e:
            r13.writeNoException()
            if (r3 == 0) goto L_0x007a
            r13.writeInt(r2)
            r3.writeToParcel(r13, r2)
            goto L_0x007d
        L_0x007a:
            r13.writeInt(r1)
        L_0x007d:
            return r2
        L_0x007e:
            r12.enforceInterface(r0)
            float r11 = r12.readFloat()
            r12 = r10
            android.support.v4.media.session.h0 r12 = (android.support.v4.media.session.h0) r12
            r12.Y0(r11)
            r13.writeNoException()
            return r2
        L_0x008f:
            r12.enforceInterface(r0)
            int r11 = r12.readInt()
            r12 = r10
            android.support.v4.media.session.h0 r12 = (android.support.v4.media.session.h0) r12
            r12.a1(r11)
            r13.writeNoException()
            return r2
        L_0x00a0:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r11 = r11.A()
            r13.writeNoException()
            r13.writeInt(r11)
            return r2
        L_0x00b1:
            r12.enforceInterface(r0)
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x00bb
            r1 = 1
        L_0x00bb:
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r12 = r11.f397d
            switch(r12) {
                case 0: goto L_0x00c4;
                default: goto L_0x00c3;
            }
        L_0x00c3:
            goto L_0x00d1
        L_0x00c4:
            r12 = 29
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r1)
            r11.N0(r12, r14)
            r13.writeNoException()
            return r2
        L_0x00d1:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        L_0x00d7:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            r11.G()
            r13.writeNoException()
            r13.writeInt(r1)
            return r2
        L_0x00e7:
            r12.enforceInterface(r0)
            int r6 = r12.readInt()
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r12 = r11.f397d
            switch(r12) {
                case 0: goto L_0x00f7;
                default: goto L_0x00f6;
            }
        L_0x00f6:
            goto L_0x0105
        L_0x00f7:
            r5 = 28
            android.support.v4.media.session.z r11 = r11.f398e
            r4 = r11
            android.support.v4.media.session.i0 r4 = (android.support.v4.media.session.i0) r4
            r7 = 0
            r8 = 0
            r9 = 0
            r4.d(r5, r6, r7, r8, r9)
            throw r3
        L_0x0105:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        L_0x010b:
            r12.enforceInterface(r0)
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x011d
            android.os.Parcelable$Creator<android.support.v4.media.MediaDescriptionCompat> r11 = android.support.v4.media.MediaDescriptionCompat.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            r3 = r11
            android.support.v4.media.MediaDescriptionCompat r3 = (android.support.v4.media.MediaDescriptionCompat) r3
        L_0x011d:
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r12 = r11.f397d
            switch(r12) {
                case 0: goto L_0x0126;
                default: goto L_0x0125;
            }
        L_0x0125:
            goto L_0x012f
        L_0x0126:
            r12 = 27
            r11.N0(r12, r3)
            r13.writeNoException()
            return r2
        L_0x012f:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        L_0x0135:
            r12.enforceInterface(r0)
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x0146
            android.os.Parcelable$Creator<android.support.v4.media.MediaDescriptionCompat> r11 = android.support.v4.media.MediaDescriptionCompat.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            android.support.v4.media.MediaDescriptionCompat r11 = (android.support.v4.media.MediaDescriptionCompat) r11
        L_0x0146:
            r12.readInt()
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r12 = r11.f397d
            switch(r12) {
                case 0: goto L_0x0152;
                default: goto L_0x0151;
            }
        L_0x0151:
            goto L_0x015a
        L_0x0152:
            android.support.v4.media.session.z r11 = r11.f398e
            android.support.v4.media.session.i0 r11 = (android.support.v4.media.session.i0) r11
            r11.getClass()
            throw r3
        L_0x015a:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        L_0x0160:
            r12.enforceInterface(r0)
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x0172
            android.os.Parcelable$Creator<android.support.v4.media.MediaDescriptionCompat> r11 = android.support.v4.media.MediaDescriptionCompat.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            r3 = r11
            android.support.v4.media.MediaDescriptionCompat r3 = (android.support.v4.media.MediaDescriptionCompat) r3
        L_0x0172:
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r12 = r11.f397d
            switch(r12) {
                case 0: goto L_0x017b;
                default: goto L_0x017a;
            }
        L_0x017a:
            goto L_0x0184
        L_0x017b:
            r12 = 25
            r11.N0(r12, r3)
            r13.writeNoException()
            return r2
        L_0x0184:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        L_0x018a:
            r12.enforceInterface(r0)
            r12.readInt()
            r13.writeNoException()
            return r2
        L_0x0194:
            r12.enforceInterface(r0)
            int r11 = r12.readInt()
            r12 = r10
            android.support.v4.media.session.h0 r12 = (android.support.v4.media.session.h0) r12
            r12.Z0(r11)
            r13.writeNoException()
            return r2
        L_0x01a5:
            r12.enforceInterface(r0)
            r13.writeNoException()
            r13.writeInt(r1)
            return r2
        L_0x01af:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r11 = r11.h()
            r13.writeNoException()
            r13.writeInt(r11)
            return r2
        L_0x01c0:
            r12.enforceInterface(r0)
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x01d2
            android.os.Parcelable$Creator r11 = android.net.Uri.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            android.net.Uri r11 = (android.net.Uri) r11
            goto L_0x01d3
        L_0x01d2:
            r11 = r3
        L_0x01d3:
            int r14 = r12.readInt()
            if (r14 == 0) goto L_0x01e2
            android.os.Parcelable$Creator r14 = android.os.Bundle.CREATOR
            java.lang.Object r12 = r14.createFromParcel(r12)
            r3 = r12
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x01e2:
            r12 = r10
            android.support.v4.media.session.h0 r12 = (android.support.v4.media.session.h0) r12
            r12.S0(r11, r3)
            r13.writeNoException()
            return r2
        L_0x01ec:
            r12.enforceInterface(r0)
            java.lang.String r11 = r12.readString()
            int r14 = r12.readInt()
            if (r14 == 0) goto L_0x0202
            android.os.Parcelable$Creator r14 = android.os.Bundle.CREATOR
            java.lang.Object r12 = r14.createFromParcel(r12)
            r3 = r12
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x0202:
            r12 = r10
            android.support.v4.media.session.h0 r12 = (android.support.v4.media.session.h0) r12
            r12.R0(r3, r11)
            r13.writeNoException()
            return r2
        L_0x020c:
            r12.enforceInterface(r0)
            java.lang.String r11 = r12.readString()
            int r14 = r12.readInt()
            if (r14 == 0) goto L_0x0222
            android.os.Parcelable$Creator r14 = android.os.Bundle.CREATOR
            java.lang.Object r12 = r14.createFromParcel(r12)
            r3 = r12
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x0222:
            r12 = r10
            android.support.v4.media.session.h0 r12 = (android.support.v4.media.session.h0) r12
            r12.Q0(r3, r11)
            r13.writeNoException()
            return r2
        L_0x022c:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            r11.P0()
            r13.writeNoException()
            return r2
        L_0x0239:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r11 = r11.E()
            r13.writeNoException()
            r13.writeInt(r11)
            return r2
        L_0x024a:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            r11.C0()
            throw r3
        L_0x0254:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r12 = r11.f397d
            switch(r12) {
                case 0: goto L_0x0260;
                default: goto L_0x025f;
            }
        L_0x025f:
            goto L_0x026e
        L_0x0260:
            android.support.v4.media.session.z r11 = r11.f398e
            android.support.v4.media.session.i0 r11 = (android.support.v4.media.session.i0) r11
            r11.getClass()
            r13.writeNoException()
            r13.writeInt(r1)
            return r2
        L_0x026e:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        L_0x0274:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            r11.E0()
            r13.writeNoException()
            r13.writeTypedList(r3)
            return r2
        L_0x0284:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            android.support.v4.media.session.PlaybackStateCompat r11 = r11.b()
            r13.writeNoException()
            if (r11 == 0) goto L_0x029a
            r13.writeInt(r2)
            r11.writeToParcel(r13, r2)
            goto L_0x029d
        L_0x029a:
            r13.writeInt(r1)
        L_0x029d:
            return r2
        L_0x029e:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r12 = r11.f397d
            switch(r12) {
                case 0: goto L_0x02aa;
                default: goto L_0x02a9;
            }
        L_0x02a9:
            goto L_0x02b8
        L_0x02aa:
            android.support.v4.media.session.z r11 = r11.f398e
            android.support.v4.media.session.i0 r11 = (android.support.v4.media.session.i0) r11
            r11.getClass()
            r13.writeNoException()
            r13.writeInt(r1)
            return r2
        L_0x02b8:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        L_0x02be:
            r12.enforceInterface(r0)
            java.lang.String r11 = r12.readString()
            int r14 = r12.readInt()
            if (r14 == 0) goto L_0x02d4
            android.os.Parcelable$Creator r14 = android.os.Bundle.CREATOR
            java.lang.Object r12 = r14.createFromParcel(r12)
            r3 = r12
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x02d4:
            r12 = r10
            android.support.v4.media.session.h0 r12 = (android.support.v4.media.session.h0) r12
            r12.X0(r3, r11)
            r13.writeNoException()
            return r2
        L_0x02de:
            r12.enforceInterface(r0)
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x02f0
            android.os.Parcelable$Creator<android.support.v4.media.RatingCompat> r11 = android.support.v4.media.RatingCompat.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            r3 = r11
            android.support.v4.media.RatingCompat r3 = (android.support.v4.media.RatingCompat) r3
        L_0x02f0:
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r12 = r11.f397d
            switch(r12) {
                case 0: goto L_0x02f9;
                default: goto L_0x02f8;
            }
        L_0x02f8:
            goto L_0x0302
        L_0x02f9:
            r12 = 19
            r11.N0(r12, r3)
            r13.writeNoException()
            return r2
        L_0x0302:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        L_0x0308:
            r12.enforceInterface(r0)
            long r11 = r12.readLong()
            r14 = r10
            android.support.v4.media.session.h0 r14 = (android.support.v4.media.session.h0) r14
            r14.W0(r11)
            r13.writeNoException()
            return r2
        L_0x0319:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            r11.V0()
            r13.writeNoException()
            return r2
        L_0x0326:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            r11.B0()
            r13.writeNoException()
            return r2
        L_0x0333:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            r11.T0()
            r13.writeNoException()
            return r2
        L_0x0340:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            r11.G0()
            r13.writeNoException()
            return r2
        L_0x034d:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            r11.c1()
            r13.writeNoException()
            return r2
        L_0x035a:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            r11.H0()
            r13.writeNoException()
            return r2
        L_0x0367:
            r12.enforceInterface(r0)
            long r11 = r12.readLong()
            r14 = r10
            android.support.v4.media.session.h0 r14 = (android.support.v4.media.session.h0) r14
            r14.b1(r11)
            r13.writeNoException()
            return r2
        L_0x0378:
            r12.enforceInterface(r0)
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x038a
            android.os.Parcelable$Creator r11 = android.net.Uri.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            android.net.Uri r11 = (android.net.Uri) r11
            goto L_0x038b
        L_0x038a:
            r11 = r3
        L_0x038b:
            int r14 = r12.readInt()
            if (r14 == 0) goto L_0x039a
            android.os.Parcelable$Creator r14 = android.os.Bundle.CREATOR
            java.lang.Object r12 = r14.createFromParcel(r12)
            r3 = r12
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x039a:
            r12 = r10
            android.support.v4.media.session.h0 r12 = (android.support.v4.media.session.h0) r12
            r12.L0(r11, r3)
            r13.writeNoException()
            return r2
        L_0x03a4:
            r12.enforceInterface(r0)
            java.lang.String r11 = r12.readString()
            int r14 = r12.readInt()
            if (r14 == 0) goto L_0x03ba
            android.os.Parcelable$Creator r14 = android.os.Bundle.CREATOR
            java.lang.Object r12 = r14.createFromParcel(r12)
            r3 = r12
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x03ba:
            r12 = r10
            android.support.v4.media.session.h0 r12 = (android.support.v4.media.session.h0) r12
            r12.K0(r3, r11)
            r13.writeNoException()
            return r2
        L_0x03c4:
            r12.enforceInterface(r0)
            java.lang.String r11 = r12.readString()
            int r14 = r12.readInt()
            if (r14 == 0) goto L_0x03da
            android.os.Parcelable$Creator r14 = android.os.Bundle.CREATOR
            java.lang.Object r12 = r14.createFromParcel(r12)
            r3 = r12
            android.os.Bundle r3 = (android.os.Bundle) r3
        L_0x03da:
            r12 = r10
            android.support.v4.media.session.h0 r12 = (android.support.v4.media.session.h0) r12
            r12.J0(r3, r11)
            r13.writeNoException()
            return r2
        L_0x03e4:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            r11.I0()
            r13.writeNoException()
            return r2
        L_0x03f1:
            r12.enforceInterface(r0)
            r12.readInt()
            r12.readInt()
            r12.readString()
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r12 = r11.f397d
            switch(r12) {
                case 0: goto L_0x0406;
                default: goto L_0x0405;
            }
        L_0x0405:
            goto L_0x040e
        L_0x0406:
            android.support.v4.media.session.z r11 = r11.f398e
            android.support.v4.media.session.i0 r11 = (android.support.v4.media.session.i0) r11
            r11.getClass()
            throw r3
        L_0x040e:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        L_0x0414:
            r12.enforceInterface(r0)
            r12.readInt()
            r12.readInt()
            r12.readString()
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r12 = r11.f397d
            switch(r12) {
                case 0: goto L_0x0429;
                default: goto L_0x0428;
            }
        L_0x0428:
            goto L_0x0431
        L_0x0429:
            android.support.v4.media.session.z r11 = r11.f398e
            android.support.v4.media.session.i0 r11 = (android.support.v4.media.session.i0) r11
            r11.getClass()
            throw r3
        L_0x0431:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        L_0x0437:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            r11.F0()
            throw r3
        L_0x0441:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            r11.D0()
            throw r3
        L_0x044b:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r12 = r11.f397d
            switch(r12) {
                case 0: goto L_0x0457;
                default: goto L_0x0456;
            }
        L_0x0456:
            goto L_0x045f
        L_0x0457:
            android.support.v4.media.session.z r11 = r11.f398e
            android.support.v4.media.session.i0 r11 = (android.support.v4.media.session.i0) r11
            r11.getClass()
            throw r3
        L_0x045f:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        L_0x0465:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r12 = r11.f397d
            switch(r12) {
                case 0: goto L_0x0471;
                default: goto L_0x0470;
            }
        L_0x0470:
            goto L_0x047f
        L_0x0471:
            android.support.v4.media.session.z r11 = r11.f398e
            android.support.v4.media.session.i0 r11 = (android.support.v4.media.session.i0) r11
            r11.getClass()
            r13.writeNoException()
            r13.writeString(r3)
            return r2
        L_0x047f:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        L_0x0485:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r12 = r11.f397d
            switch(r12) {
                case 0: goto L_0x0491;
                default: goto L_0x0490;
            }
        L_0x0490:
            goto L_0x049f
        L_0x0491:
            android.support.v4.media.session.z r11 = r11.f398e
            android.support.v4.media.session.i0 r11 = (android.support.v4.media.session.i0) r11
            r11.getClass()
            r13.writeNoException()
            r13.writeString(r3)
            return r2
        L_0x049f:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        L_0x04a5:
            r12.enforceInterface(r0)
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r11 = r11.f397d
            switch(r11) {
                case 0: goto L_0x04b1;
                default: goto L_0x04b0;
            }
        L_0x04b0:
            goto L_0x04b8
        L_0x04b1:
            r13.writeNoException()
            r13.writeInt(r2)
            return r2
        L_0x04b8:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        L_0x04be:
            r12.enforceInterface(r0)
            android.os.IBinder r11 = r12.readStrongBinder()
            if (r11 != 0) goto L_0x04c8
            goto L_0x04dd
        L_0x04c8:
            java.lang.String r12 = "android.support.v4.media.session.IMediaControllerCallback"
            android.os.IInterface r12 = r11.queryLocalInterface(r12)
            if (r12 == 0) goto L_0x04d8
            boolean r14 = r12 instanceof android.support.v4.media.session.c
            if (r14 == 0) goto L_0x04d8
            r3 = r12
            android.support.v4.media.session.c r3 = (android.support.v4.media.session.c) r3
            goto L_0x04dd
        L_0x04d8:
            android.support.v4.media.session.a r3 = new android.support.v4.media.session.a
            r3.<init>(r11)
        L_0x04dd:
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            r11.T(r3)
            r13.writeNoException()
            return r2
        L_0x04e7:
            r12.enforceInterface(r0)
            android.os.IBinder r11 = r12.readStrongBinder()
            if (r11 != 0) goto L_0x04f1
            goto L_0x0506
        L_0x04f1:
            java.lang.String r12 = "android.support.v4.media.session.IMediaControllerCallback"
            android.os.IInterface r12 = r11.queryLocalInterface(r12)
            if (r12 == 0) goto L_0x0501
            boolean r14 = r12 instanceof android.support.v4.media.session.c
            if (r14 == 0) goto L_0x0501
            r3 = r12
            android.support.v4.media.session.c r3 = (android.support.v4.media.session.c) r3
            goto L_0x0506
        L_0x0501:
            android.support.v4.media.session.a r3 = new android.support.v4.media.session.a
            r3.<init>(r11)
        L_0x0506:
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            r11.m(r3)
            r13.writeNoException()
            return r2
        L_0x0510:
            r12.enforceInterface(r0)
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x0522
            android.os.Parcelable$Creator r11 = android.view.KeyEvent.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            r3 = r11
            android.view.KeyEvent r3 = (android.view.KeyEvent) r3
        L_0x0522:
            r11 = r10
            android.support.v4.media.session.h0 r11 = (android.support.v4.media.session.h0) r11
            int r12 = r11.f397d
            switch(r12) {
                case 0: goto L_0x052b;
                default: goto L_0x052a;
            }
        L_0x052a:
            goto L_0x0537
        L_0x052b:
            r12 = 21
            r11.N0(r12, r3)
            r13.writeNoException()
            r13.writeInt(r2)
            return r2
        L_0x0537:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        L_0x053d:
            r12.enforceInterface(r0)
            java.lang.String r11 = r12.readString()
            int r14 = r12.readInt()
            if (r14 == 0) goto L_0x0553
            android.os.Parcelable$Creator r14 = android.os.Bundle.CREATOR
            java.lang.Object r14 = r14.createFromParcel(r12)
            android.os.Bundle r14 = (android.os.Bundle) r14
            goto L_0x0554
        L_0x0553:
            r14 = r3
        L_0x0554:
            int r0 = r12.readInt()
            if (r0 == 0) goto L_0x0563
            android.os.Parcelable$Creator<android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper> r0 = android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper.CREATOR
            java.lang.Object r12 = r0.createFromParcel(r12)
            android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper r12 = (android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper) r12
            goto L_0x0564
        L_0x0563:
            r12 = r3
        L_0x0564:
            r0 = r10
            android.support.v4.media.session.h0 r0 = (android.support.v4.media.session.h0) r0
            int r1 = r0.f397d
            switch(r1) {
                case 0: goto L_0x056d;
                default: goto L_0x056c;
            }
        L_0x056c:
            goto L_0x057e
        L_0x056d:
            android.support.v4.media.session.g0 r1 = new android.support.v4.media.session.g0
            if (r12 != 0) goto L_0x0572
            goto L_0x0574
        L_0x0572:
            android.os.ResultReceiver r3 = r12.f349h
        L_0x0574:
            r1.<init>(r11, r14, r3)
            r0.N0(r2, r1)
            r13.writeNoException()
            return r2
        L_0x057e:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        L_0x0584:
            r13.writeString(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.e.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
