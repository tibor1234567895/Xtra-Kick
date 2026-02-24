package f7;

import android.os.Bundle;
import j3.i;
import xa.j;

public final class k implements i {

    /* renamed from: f  reason: collision with root package name */
    public static final j f5932f = new j(0);

    /* renamed from: a  reason: collision with root package name */
    public final int f5933a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5934b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5935c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5936d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f5937e;

    public k() {
        this(0, (String) null, (String) null, (String) null, false);
    }

    public static final k fromBundle(Bundle bundle) {
        int i10;
        String str;
        String str2;
        String str3;
        boolean z10;
        f5932f.getClass();
        j.f("bundle", bundle);
        bundle.setClassLoader(k.class.getClassLoader());
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
        if (bundle.containsKey("getGameTags")) {
            z10 = bundle.getBoolean("getGameTags");
        } else {
            z10 = false;
        }
        return new k(i10, str, str2, str3, z10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (f7.k) r5;
        r1 = r5.f5933a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof f7.k
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            f7.k r5 = (f7.k) r5
            int r1 = r5.f5933a
            int r3 = r4.f5933a
            if (r3 == r1) goto L_0x0013
            return r2
        L_0x0013:
            java.lang.String r1 = r4.f5934b
            java.lang.String r3 = r5.f5934b
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x001e
            return r2
        L_0x001e:
            java.lang.String r1 = r4.f5935c
            java.lang.String r3 = r5.f5935c
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x0029
            return r2
        L_0x0029:
            java.lang.String r1 = r4.f5936d
            java.lang.String r3 = r5.f5936d
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x0034
            return r2
        L_0x0034:
            boolean r1 = r4.f5937e
            boolean r5 = r5.f5937e
            if (r1 == r5) goto L_0x003b
            return r2
        L_0x003b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f7.k.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i10 = this.f5933a * 31;
        int i11 = 0;
        String str = this.f5934b;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f5935c;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f5936d;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        int i12 = (hashCode2 + i11) * 31;
        boolean z10 = this.f5937e;
        if (z10) {
            z10 = true;
        }
        return i12 + (z10 ? 1 : 0);
    }

    public final String toString() {
        return "TagSearchFragmentArgs(gameId=" + this.f5933a + ", gameSlug=" + this.f5934b + ", gameName=" + this.f5935c + ", boxArt=" + this.f5936d + ", getGameTags=" + this.f5937e + ")";
    }

    public k(int i10, String str, String str2, String str3, boolean z10) {
        this.f5933a = i10;
        this.f5934b = str;
        this.f5935c = str2;
        this.f5936d = str3;
        this.f5937e = z10;
    }
}
