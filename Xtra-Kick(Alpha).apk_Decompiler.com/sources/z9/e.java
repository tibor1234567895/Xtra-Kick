package z9;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.h;
import java.io.Serializable;
import java.util.Date;
import xa.j;

public final class e implements Parcelable, Serializable {
    public static final d CREATOR = new d(0);

    /* renamed from: h  reason: collision with root package name */
    public final int f17801h;

    /* renamed from: i  reason: collision with root package name */
    public final int f17802i;

    /* renamed from: j  reason: collision with root package name */
    public final int f17803j;

    /* renamed from: k  reason: collision with root package name */
    public final long f17804k;

    /* renamed from: l  reason: collision with root package name */
    public final long f17805l;

    /* renamed from: m  reason: collision with root package name */
    public final String f17806m;

    /* renamed from: n  reason: collision with root package name */
    public final String f17807n;

    public e() {
        this(415, -1, 0, new Date().getTime(), 0, "", "");
    }

    public final int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r6 = (z9.e) r6;
        r0 = r6.f17801h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            if (r5 == r6) goto L_0x0041
            boolean r0 = r6 instanceof z9.e
            if (r0 == 0) goto L_0x003f
            z9.e r6 = (z9.e) r6
            int r0 = r6.f17801h
            int r1 = r5.f17801h
            if (r1 != r0) goto L_0x003f
            int r0 = r5.f17802i
            int r1 = r6.f17802i
            if (r0 != r1) goto L_0x003f
            int r0 = r5.f17803j
            int r1 = r6.f17803j
            if (r0 != r1) goto L_0x003f
            long r0 = r5.f17804k
            long r2 = r6.f17804k
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x003f
            long r0 = r5.f17805l
            long r2 = r6.f17805l
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x003f
            java.lang.String r0 = r5.f17806m
            java.lang.String r1 = r6.f17806m
            boolean r0 = xa.j.a(r0, r1)
            if (r0 == 0) goto L_0x003f
            java.lang.String r0 = r5.f17807n
            java.lang.String r6 = r6.f17807n
            boolean r6 = xa.j.a(r0, r6)
            if (r6 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r6 = 0
            return r6
        L_0x0041:
            r6 = 1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: z9.e.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        long j10 = this.f17804k;
        long j11 = this.f17805l;
        int i10 = ((((((((this.f17801h * 31) + this.f17802i) * 31) + this.f17803j) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        int i11 = 0;
        String str = this.f17806m;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f17807n;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("FileResponse(status=");
        sb2.append(this.f17801h);
        sb2.append(", type=");
        sb2.append(this.f17802i);
        sb2.append(", connection=");
        sb2.append(this.f17803j);
        sb2.append(", date=");
        sb2.append(this.f17804k);
        sb2.append(", contentLength=");
        sb2.append(this.f17805l);
        sb2.append(", md5=");
        sb2.append(this.f17806m);
        sb2.append(", sessionId=");
        return h.p(sb2, this.f17807n, ")");
    }

    public final String u() {
        StringBuilder sb2 = new StringBuilder("{\"Status\":");
        sb2.append(this.f17801h);
        sb2.append(",\"Md5\":");
        sb2.append("\"" + this.f17806m + '\"');
        sb2.append(",\"Connection\":");
        sb2.append(this.f17803j);
        sb2.append(",\"Date\":");
        sb2.append(this.f17804k);
        sb2.append(",\"Content-Length\":");
        sb2.append(this.f17805l);
        sb2.append(",\"Type\":");
        sb2.append(this.f17802i);
        sb2.append(",\"SessionId\":");
        sb2.append(this.f17807n);
        sb2.append('}');
        String sb3 = sb2.toString();
        j.b("builder.toString()", sb3);
        return sb3;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        j.g("dest", parcel);
        parcel.writeInt(this.f17801h);
        parcel.writeInt(this.f17802i);
        parcel.writeInt(this.f17803j);
        parcel.writeLong(this.f17804k);
        parcel.writeLong(this.f17805l);
        parcel.writeString(this.f17806m);
        parcel.writeString(this.f17807n);
    }

    public e(int i10, int i11, int i12, long j10, long j11, String str, String str2) {
        j.g("md5", str);
        j.g("sessionId", str2);
        this.f17801h = i10;
        this.f17802i = i11;
        this.f17803j = i12;
        this.f17804k = j10;
        this.f17805l = j11;
        this.f17806m = str;
        this.f17807n = str2;
    }
}
