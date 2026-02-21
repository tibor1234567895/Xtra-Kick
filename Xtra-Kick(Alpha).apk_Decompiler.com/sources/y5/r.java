package y5;

import android.os.Bundle;
import com.woxthebox.draglistview.R;
import j3.d1;

public final class r implements d1 {

    /* renamed from: a  reason: collision with root package name */
    public final int f17059a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17060b;

    /* renamed from: c  reason: collision with root package name */
    public final String f17061c;

    /* renamed from: d  reason: collision with root package name */
    public final String f17062d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f17063e;

    /* renamed from: f  reason: collision with root package name */
    public final int f17064f;

    public r() {
        this(0, (String) null, (String) null, (String) null, false);
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt("gameId", this.f17059a);
        bundle.putString("gameSlug", this.f17060b);
        bundle.putString("gameName", this.f17061c);
        bundle.putString("boxArt", this.f17062d);
        bundle.putBoolean("getGameTags", this.f17063e);
        return bundle;
    }

    public final int b() {
        return this.f17064f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (y5.r) r5;
        r1 = r5.f17059a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof y5.r
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            y5.r r5 = (y5.r) r5
            int r1 = r5.f17059a
            int r3 = r4.f17059a
            if (r3 == r1) goto L_0x0013
            return r2
        L_0x0013:
            java.lang.String r1 = r4.f17060b
            java.lang.String r3 = r5.f17060b
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x001e
            return r2
        L_0x001e:
            java.lang.String r1 = r4.f17061c
            java.lang.String r3 = r5.f17061c
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x0029
            return r2
        L_0x0029:
            java.lang.String r1 = r4.f17062d
            java.lang.String r3 = r5.f17062d
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x0034
            return r2
        L_0x0034:
            boolean r1 = r4.f17063e
            boolean r5 = r5.f17063e
            if (r1 == r5) goto L_0x003b
            return r2
        L_0x003b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y5.r.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i10 = this.f17059a * 31;
        int i11 = 0;
        String str = this.f17060b;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f17061c;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f17062d;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        int i12 = (hashCode2 + i11) * 31;
        boolean z10 = this.f17063e;
        if (z10) {
            z10 = true;
        }
        return i12 + (z10 ? 1 : 0);
    }

    public final String toString() {
        return "ActionGlobalTagSearchFragment(gameId=" + this.f17059a + ", gameSlug=" + this.f17060b + ", gameName=" + this.f17061c + ", boxArt=" + this.f17062d + ", getGameTags=" + this.f17063e + ")";
    }

    public r(int i10, String str, String str2, String str3, boolean z10) {
        this.f17059a = i10;
        this.f17060b = str;
        this.f17061c = str2;
        this.f17062d = str3;
        this.f17063e = z10;
        this.f17064f = R.id.action_global_tagSearchFragment;
    }
}
