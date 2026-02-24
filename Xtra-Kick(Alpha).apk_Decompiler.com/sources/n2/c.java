package n2;

import android.os.Parcel;
import android.os.Parcelable;
import g1.a0;
import g1.u0;
import g1.y0;
import j1.a;
import j1.l0;

public final class c implements y0 {
    public static final Parcelable.Creator<c> CREATOR = new b();

    /* renamed from: h  reason: collision with root package name */
    public final int f11025h;

    /* renamed from: i  reason: collision with root package name */
    public final String f11026i;

    /* renamed from: j  reason: collision with root package name */
    public final String f11027j;

    /* renamed from: k  reason: collision with root package name */
    public final String f11028k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f11029l;

    /* renamed from: m  reason: collision with root package name */
    public final int f11030m;

    public c(int i10, int i11, String str, String str2, String str3, boolean z10) {
        a.b(i11 == -1 || i11 > 0);
        this.f11025h = i10;
        this.f11026i = str;
        this.f11027j = str2;
        this.f11028k = str3;
        this.f11029l = z10;
        this.f11030m = i11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static n2.c u(java.util.Map r14) {
        /*
            java.lang.String r0 = "Invalid metadata interval: "
            java.lang.String r1 = "Invalid bitrate: "
            java.lang.String r2 = "icy-br"
            java.lang.Object r2 = r14.get(r2)
            java.util.List r2 = (java.util.List) r2
            java.lang.String r3 = "IcyHeaders"
            r4 = 1
            r5 = 0
            r6 = -1
            if (r2 == 0) goto L_0x004b
            java.lang.Object r2 = r2.get(r5)
            java.lang.String r2 = (java.lang.String) r2
            int r7 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0036 }
            int r7 = r7 * 1000
            if (r7 <= 0) goto L_0x0023
            r1 = 1
            goto L_0x0034
        L_0x0023:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0037 }
            r8.<init>(r1)     // Catch:{ NumberFormatException -> 0x0037 }
            r8.append(r2)     // Catch:{ NumberFormatException -> 0x0037 }
            java.lang.String r1 = r8.toString()     // Catch:{ NumberFormatException -> 0x0037 }
            j1.v.g(r3, r1)     // Catch:{ NumberFormatException -> 0x0037 }
            r1 = 0
            r7 = -1
        L_0x0034:
            r8 = r7
            goto L_0x004d
        L_0x0036:
            r7 = -1
        L_0x0037:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r8 = "Invalid bitrate header: "
            r1.<init>(r8)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            j1.v.g(r3, r1)
            r8 = r7
            r1 = 0
            goto L_0x004d
        L_0x004b:
            r1 = 0
            r8 = -1
        L_0x004d:
            java.lang.String r2 = "icy-genre"
            java.lang.Object r2 = r14.get(r2)
            java.util.List r2 = (java.util.List) r2
            r7 = 0
            if (r2 == 0) goto L_0x0061
            java.lang.Object r1 = r2.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            r10 = r1
            r1 = 1
            goto L_0x0062
        L_0x0061:
            r10 = r7
        L_0x0062:
            java.lang.String r2 = "icy-name"
            java.lang.Object r2 = r14.get(r2)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x0075
            java.lang.Object r1 = r2.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            r11 = r1
            r1 = 1
            goto L_0x0076
        L_0x0075:
            r11 = r7
        L_0x0076:
            java.lang.String r2 = "icy-url"
            java.lang.Object r2 = r14.get(r2)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x0089
            java.lang.Object r1 = r2.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            r12 = r1
            r1 = 1
            goto L_0x008a
        L_0x0089:
            r12 = r7
        L_0x008a:
            java.lang.String r2 = "icy-pub"
            java.lang.Object r2 = r14.get(r2)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x00a3
            java.lang.Object r1 = r2.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "1"
            boolean r1 = r1.equals(r2)
            r13 = r1
            r1 = 1
            goto L_0x00a4
        L_0x00a3:
            r13 = 0
        L_0x00a4:
            java.lang.String r2 = "icy-metaint"
            java.lang.Object r14 = r14.get(r2)
            java.util.List r14 = (java.util.List) r14
            if (r14 == 0) goto L_0x00e0
            java.lang.Object r14 = r14.get(r5)
            java.lang.String r14 = (java.lang.String) r14
            int r2 = java.lang.Integer.parseInt(r14)     // Catch:{ NumberFormatException -> 0x00cf }
            if (r2 <= 0) goto L_0x00bc
            r6 = r2
            goto L_0x00cc
        L_0x00bc:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00ce }
            r4.<init>(r0)     // Catch:{ NumberFormatException -> 0x00ce }
            r4.append(r14)     // Catch:{ NumberFormatException -> 0x00ce }
            java.lang.String r4 = r4.toString()     // Catch:{ NumberFormatException -> 0x00ce }
            j1.v.g(r3, r4)     // Catch:{ NumberFormatException -> 0x00ce }
            r4 = r1
        L_0x00cc:
            r1 = r4
            goto L_0x00de
        L_0x00ce:
            r6 = r2
        L_0x00cf:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            r2.append(r14)
            java.lang.String r14 = r2.toString()
            j1.v.g(r3, r14)
        L_0x00de:
            r9 = r6
            goto L_0x00e1
        L_0x00e0:
            r9 = -1
        L_0x00e1:
            if (r1 == 0) goto L_0x00e9
            n2.c r14 = new n2.c
            r7 = r14
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x00e9:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: n2.c.u(java.util.Map):n2.c");
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f11025h == cVar.f11025h && l0.a(this.f11026i, cVar.f11026i) && l0.a(this.f11027j, cVar.f11027j) && l0.a(this.f11028k, cVar.f11028k) && this.f11029l == cVar.f11029l && this.f11030m == cVar.f11030m;
    }

    public final /* synthetic */ a0 g() {
        return null;
    }

    public final void h(u0 u0Var) {
        String str = this.f11027j;
        if (str != null) {
            u0Var.E = str;
        }
        String str2 = this.f11026i;
        if (str2 != null) {
            u0Var.C = str2;
        }
    }

    public final int hashCode() {
        int i10 = (527 + this.f11025h) * 31;
        int i11 = 0;
        String str = this.f11026i;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f11027j;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f11028k;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return ((((hashCode2 + i11) * 31) + (this.f11029l ? 1 : 0)) * 31) + this.f11030m;
    }

    public final /* synthetic */ byte[] r() {
        return null;
    }

    public final String toString() {
        return "IcyHeaders: name=\"" + this.f11027j + "\", genre=\"" + this.f11026i + "\", bitrate=" + this.f11025h + ", metadataInterval=" + this.f11030m;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f11025h);
        parcel.writeString(this.f11026i);
        parcel.writeString(this.f11027j);
        parcel.writeString(this.f11028k);
        int i11 = l0.f8453a;
        parcel.writeInt(this.f11029l ? 1 : 0);
        parcel.writeInt(this.f11030m);
    }

    public c(Parcel parcel) {
        this.f11025h = parcel.readInt();
        this.f11026i = parcel.readString();
        this.f11027j = parcel.readString();
        this.f11028k = parcel.readString();
        int i10 = l0.f8453a;
        this.f11029l = parcel.readInt() != 0;
        this.f11030m = parcel.readInt();
    }
}
