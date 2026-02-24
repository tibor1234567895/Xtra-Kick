package z9;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.HashMap;
import ma.j0;
import y9.j;

public final class c implements Parcelable, Serializable {
    public static final b CREATOR = new b(0);

    /* renamed from: h  reason: collision with root package name */
    public final int f17791h;

    /* renamed from: i  reason: collision with root package name */
    public final String f17792i;

    /* renamed from: j  reason: collision with root package name */
    public final long f17793j;

    /* renamed from: k  reason: collision with root package name */
    public final long f17794k;

    /* renamed from: l  reason: collision with root package name */
    public final String f17795l;

    /* renamed from: m  reason: collision with root package name */
    public final String f17796m;

    /* renamed from: n  reason: collision with root package name */
    public final j f17797n;

    /* renamed from: o  reason: collision with root package name */
    public final int f17798o;

    /* renamed from: p  reason: collision with root package name */
    public final int f17799p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f17800q;

    public c() {
        this(0);
    }

    public final int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r6 = (z9.c) r6;
        r0 = r6.f17791h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            if (r5 == r6) goto L_0x005b
            boolean r0 = r6 instanceof z9.c
            if (r0 == 0) goto L_0x0059
            z9.c r6 = (z9.c) r6
            int r0 = r6.f17791h
            int r1 = r5.f17791h
            if (r1 != r0) goto L_0x0059
            java.lang.String r0 = r5.f17792i
            java.lang.String r1 = r6.f17792i
            boolean r0 = xa.j.a(r0, r1)
            if (r0 == 0) goto L_0x0059
            long r0 = r5.f17793j
            long r2 = r6.f17793j
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0059
            long r0 = r5.f17794k
            long r2 = r6.f17794k
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0059
            java.lang.String r0 = r5.f17795l
            java.lang.String r1 = r6.f17795l
            boolean r0 = xa.j.a(r0, r1)
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = r5.f17796m
            java.lang.String r1 = r6.f17796m
            boolean r0 = xa.j.a(r0, r1)
            if (r0 == 0) goto L_0x0059
            y9.j r0 = r5.f17797n
            y9.j r1 = r6.f17797n
            boolean r0 = xa.j.a(r0, r1)
            if (r0 == 0) goto L_0x0059
            int r0 = r5.f17798o
            int r1 = r6.f17798o
            if (r0 != r1) goto L_0x0059
            int r0 = r5.f17799p
            int r1 = r6.f17799p
            if (r0 != r1) goto L_0x0059
            boolean r0 = r5.f17800q
            boolean r6 = r6.f17800q
            if (r0 != r6) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r6 = 0
            return r6
        L_0x005b:
            r6 = 1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: z9.c.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i10 = this.f17791h * 31;
        int i11 = 0;
        String str = this.f17792i;
        int hashCode = str != null ? str.hashCode() : 0;
        long j10 = this.f17793j;
        long j11 = this.f17794k;
        int i12 = (((((i10 + hashCode) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        String str2 = this.f17795l;
        int hashCode2 = (i12 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f17796m;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        j jVar = this.f17797n;
        if (jVar != null) {
            i11 = jVar.hashCode();
        }
        int i13 = (((((hashCode3 + i11) * 31) + this.f17798o) * 31) + this.f17799p) * 31;
        boolean z10 = this.f17800q;
        if (z10) {
            z10 = true;
        }
        return i13 + (z10 ? 1 : 0);
    }

    public final String toString() {
        return "FileRequest(type=" + this.f17791h + ", fileResourceId=" + this.f17792i + ", rangeStart=" + this.f17793j + ", rangeEnd=" + this.f17794k + ", authorization=" + this.f17795l + ", client=" + this.f17796m + ", extras=" + this.f17797n + ", page=" + this.f17798o + ", size=" + this.f17799p + ", persistConnection=" + this.f17800q + ")";
    }

    public final String u() {
        StringBuilder sb2 = new StringBuilder("{\"Type\":");
        sb2.append(this.f17791h);
        sb2.append(",\"FileResourceId\":");
        sb2.append("\"" + this.f17792i + '\"');
        sb2.append(",\"Range-Start\":");
        sb2.append(this.f17793j);
        sb2.append(",\"Range-End\":");
        sb2.append(this.f17794k);
        sb2.append(",\"Authorization\":");
        sb2.append("\"" + this.f17795l + '\"');
        sb2.append(",\"Client\":");
        sb2.append("\"" + this.f17796m + '\"');
        sb2.append(",\"Extras\":");
        sb2.append(this.f17797n.u());
        sb2.append(",\"Page\":");
        sb2.append(this.f17798o);
        sb2.append(",\"Size\":");
        sb2.append(this.f17799p);
        sb2.append(",\"Persist-Connection\":");
        sb2.append(this.f17800q);
        sb2.append('}');
        String sb3 = sb2.toString();
        xa.j.b("builder.toString()", sb3);
        return sb3;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        xa.j.g("dest", parcel);
        parcel.writeInt(this.f17791h);
        parcel.writeString(this.f17792i);
        parcel.writeLong(this.f17793j);
        parcel.writeLong(this.f17794k);
        parcel.writeString(this.f17795l);
        parcel.writeString(this.f17796m);
        parcel.writeSerializable(new HashMap(j0.g(this.f17797n.f17264h)));
        parcel.writeInt(this.f17798o);
        parcel.writeInt(this.f17799p);
        parcel.writeInt(this.f17800q ? 1 : 0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(int r14) {
        /*
            r13 = this;
            r1 = -1
            r2 = -1
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r3 = 0
            r5 = -1
            java.lang.String r8 = ""
            y9.i r14 = y9.j.CREATOR
            r14.getClass()
            y9.j r9 = y9.j.f17263i
            r10 = 0
            r11 = 0
            r12 = 1
            r0 = r13
            r7 = r8
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z9.c.<init>(int):void");
    }

    public c(int i10, String str, long j10, long j11, String str2, String str3, j jVar, int i11, int i12, boolean z10) {
        xa.j.g("fileResourceId", str);
        xa.j.g("authorization", str2);
        xa.j.g("client", str3);
        xa.j.g("extras", jVar);
        this.f17791h = i10;
        this.f17792i = str;
        this.f17793j = j10;
        this.f17794k = j11;
        this.f17795l = str2;
        this.f17796m = str3;
        this.f17797n = jVar;
        this.f17798o = i11;
        this.f17799p = i12;
        this.f17800q = z10;
    }
}
