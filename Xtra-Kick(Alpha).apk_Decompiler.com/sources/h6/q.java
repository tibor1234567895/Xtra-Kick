package h6;

import android.os.Bundle;
import android.support.v4.media.h;
import j3.i;
import xa.j;

public final class q implements i {

    /* renamed from: g  reason: collision with root package name */
    public static final p f7679g = new p(0);

    /* renamed from: a  reason: collision with root package name */
    public final int f7680a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7681b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7682c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7683d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f7684e;

    /* renamed from: f  reason: collision with root package name */
    public final int f7685f;

    public q() {
        this(0, 0, (String) null, (String) null, (String) null, false);
    }

    public static final q fromBundle(Bundle bundle) {
        int i10;
        String str;
        String str2;
        String str3;
        boolean z10;
        int i11;
        f7679g.getClass();
        j.f("bundle", bundle);
        bundle.setClassLoader(q.class.getClassLoader());
        if (bundle.containsKey("channelId")) {
            i10 = bundle.getInt("channelId");
        } else {
            i10 = 0;
        }
        if (bundle.containsKey("channelLogin")) {
            str = bundle.getString("channelLogin");
        } else {
            str = null;
        }
        if (bundle.containsKey("channelName")) {
            str2 = bundle.getString("channelName");
        } else {
            str2 = null;
        }
        if (bundle.containsKey("channelLogo")) {
            str3 = bundle.getString("channelLogo");
        } else {
            str3 = null;
        }
        if (bundle.containsKey("updateLocal")) {
            z10 = bundle.getBoolean("updateLocal");
        } else {
            z10 = false;
        }
        if (bundle.containsKey("streamId")) {
            i11 = bundle.getInt("streamId");
        } else {
            i11 = 0;
        }
        return new q(i10, i11, str, str2, str3, z10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (h6.q) r5;
        r1 = r5.f7680a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof h6.q
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            h6.q r5 = (h6.q) r5
            int r1 = r5.f7680a
            int r3 = r4.f7680a
            if (r3 == r1) goto L_0x0013
            return r2
        L_0x0013:
            java.lang.String r1 = r4.f7681b
            java.lang.String r3 = r5.f7681b
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x001e
            return r2
        L_0x001e:
            java.lang.String r1 = r4.f7682c
            java.lang.String r3 = r5.f7682c
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x0029
            return r2
        L_0x0029:
            java.lang.String r1 = r4.f7683d
            java.lang.String r3 = r5.f7683d
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x0034
            return r2
        L_0x0034:
            boolean r1 = r4.f7684e
            boolean r3 = r5.f7684e
            if (r1 == r3) goto L_0x003b
            return r2
        L_0x003b:
            int r1 = r4.f7685f
            int r5 = r5.f7685f
            if (r1 == r5) goto L_0x0042
            return r2
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h6.q.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i10 = this.f7680a * 31;
        int i11 = 0;
        String str = this.f7681b;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f7682c;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f7683d;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        int i12 = (hashCode2 + i11) * 31;
        boolean z10 = this.f7684e;
        if (z10) {
            z10 = true;
        }
        return ((i12 + (z10 ? 1 : 0)) * 31) + this.f7685f;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ChannelPagerFragmentArgs(channelId=");
        sb2.append(this.f7680a);
        sb2.append(", channelLogin=");
        sb2.append(this.f7681b);
        sb2.append(", channelName=");
        sb2.append(this.f7682c);
        sb2.append(", channelLogo=");
        sb2.append(this.f7683d);
        sb2.append(", updateLocal=");
        sb2.append(this.f7684e);
        sb2.append(", streamId=");
        return h.o(sb2, this.f7685f, ")");
    }

    public q(int i10, int i11, String str, String str2, String str3, boolean z10) {
        this.f7680a = i10;
        this.f7681b = str;
        this.f7682c = str2;
        this.f7683d = str3;
        this.f7684e = z10;
        this.f7685f = i11;
    }
}
