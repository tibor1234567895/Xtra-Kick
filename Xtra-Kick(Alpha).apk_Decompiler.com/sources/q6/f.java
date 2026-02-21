package q6;

import android.os.Bundle;
import android.support.v4.media.h;
import j3.i;
import java.util.Arrays;
import xa.j;

public final class f implements i {

    /* renamed from: i  reason: collision with root package name */
    public static final e f13352i = new e(0);

    /* renamed from: a  reason: collision with root package name */
    public final int f13353a;

    /* renamed from: b  reason: collision with root package name */
    public final String f13354b;

    /* renamed from: c  reason: collision with root package name */
    public final String f13355c;

    /* renamed from: d  reason: collision with root package name */
    public final String f13356d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f13357e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f13358f;

    /* renamed from: g  reason: collision with root package name */
    public final int f13359g;

    /* renamed from: h  reason: collision with root package name */
    public final String f13360h;

    public f() {
        this(0, (String) null, (String) null, (String) null, (String[]) null, false, 0, (String) null);
    }

    public static final f fromBundle(Bundle bundle) {
        int i10;
        String str;
        String str2;
        String str3;
        String[] strArr;
        boolean z10;
        int i11;
        String str4;
        f13352i.getClass();
        j.f("bundle", bundle);
        bundle.setClassLoader(f.class.getClassLoader());
        if (bundle.containsKey("gameId")) {
            i10 = bundle.getInt("gameId");
        } else {
            i10 = 0;
        }
        if (bundle.containsKey("gameSlug")) {
            str = bundle.getString("gameSlug");
        } else {
            str = null;
        }
        if (bundle.containsKey("gameName")) {
            str2 = bundle.getString("gameName");
        } else {
            str2 = null;
        }
        if (bundle.containsKey("boxArt")) {
            str3 = bundle.getString("boxArt");
        } else {
            str3 = null;
        }
        if (bundle.containsKey("tags")) {
            strArr = bundle.getStringArray("tags");
        } else {
            strArr = null;
        }
        if (bundle.containsKey("updateLocal")) {
            z10 = bundle.getBoolean("updateLocal");
        } else {
            z10 = false;
        }
        if (bundle.containsKey("channelId")) {
            i11 = bundle.getInt("channelId");
        } else {
            i11 = 0;
        }
        if (bundle.containsKey("channelLogin")) {
            str4 = bundle.getString("channelLogin");
        } else {
            str4 = null;
        }
        return new f(i10, str, str2, str3, strArr, z10, i11, str4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (q6.f) r5;
        r1 = r5.f13353a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof q6.f
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            q6.f r5 = (q6.f) r5
            int r1 = r5.f13353a
            int r3 = r4.f13353a
            if (r3 == r1) goto L_0x0013
            return r2
        L_0x0013:
            java.lang.String r1 = r4.f13354b
            java.lang.String r3 = r5.f13354b
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x001e
            return r2
        L_0x001e:
            java.lang.String r1 = r4.f13355c
            java.lang.String r3 = r5.f13355c
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x0029
            return r2
        L_0x0029:
            java.lang.String r1 = r4.f13356d
            java.lang.String r3 = r5.f13356d
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x0034
            return r2
        L_0x0034:
            java.lang.String[] r1 = r4.f13357e
            java.lang.String[] r3 = r5.f13357e
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x003f
            return r2
        L_0x003f:
            boolean r1 = r4.f13358f
            boolean r3 = r5.f13358f
            if (r1 == r3) goto L_0x0046
            return r2
        L_0x0046:
            int r1 = r4.f13359g
            int r3 = r5.f13359g
            if (r1 == r3) goto L_0x004d
            return r2
        L_0x004d:
            java.lang.String r1 = r4.f13360h
            java.lang.String r5 = r5.f13360h
            boolean r5 = xa.j.a(r1, r5)
            if (r5 != 0) goto L_0x0058
            return r2
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.f.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i10 = this.f13353a * 31;
        int i11 = 0;
        String str = this.f13354b;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f13355c;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f13356d;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String[] strArr = this.f13357e;
        int hashCode4 = (hashCode3 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        boolean z10 = this.f13358f;
        if (z10) {
            z10 = true;
        }
        int i12 = (((hashCode4 + (z10 ? 1 : 0)) * 31) + this.f13359g) * 31;
        String str4 = this.f13360h;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return i12 + i11;
    }

    public final String toString() {
        String arrays = Arrays.toString(this.f13357e);
        StringBuilder sb2 = new StringBuilder("GamePagerFragmentArgs(gameId=");
        sb2.append(this.f13353a);
        sb2.append(", gameSlug=");
        sb2.append(this.f13354b);
        sb2.append(", gameName=");
        sb2.append(this.f13355c);
        sb2.append(", boxArt=");
        q0.f.k(sb2, this.f13356d, ", tags=", arrays, ", updateLocal=");
        sb2.append(this.f13358f);
        sb2.append(", channelId=");
        sb2.append(this.f13359g);
        sb2.append(", channelLogin=");
        return h.p(sb2, this.f13360h, ")");
    }

    public f(int i10, String str, String str2, String str3, String[] strArr, boolean z10, int i11, String str4) {
        this.f13353a = i10;
        this.f13354b = str;
        this.f13355c = str2;
        this.f13356d = str3;
        this.f13357e = strArr;
        this.f13358f = z10;
        this.f13359g = i11;
        this.f13360h = str4;
    }
}
