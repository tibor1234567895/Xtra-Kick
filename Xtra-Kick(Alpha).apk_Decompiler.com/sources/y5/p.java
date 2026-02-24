package y5;

import android.os.Bundle;
import android.support.v4.media.h;
import com.woxthebox.draglistview.R;
import j3.d1;
import java.util.Arrays;
import q0.f;

public final class p implements d1 {

    /* renamed from: a  reason: collision with root package name */
    public final int f17041a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17042b;

    /* renamed from: c  reason: collision with root package name */
    public final String f17043c;

    /* renamed from: d  reason: collision with root package name */
    public final String f17044d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f17045e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f17046f;

    /* renamed from: g  reason: collision with root package name */
    public final int f17047g;

    /* renamed from: h  reason: collision with root package name */
    public final String f17048h;

    /* renamed from: i  reason: collision with root package name */
    public final int f17049i;

    public p() {
        this(0, (String) null, (String) null, (String) null, (String[]) null, false, 0, (String) null);
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt("gameId", this.f17041a);
        bundle.putString("gameSlug", this.f17042b);
        bundle.putString("gameName", this.f17043c);
        bundle.putString("boxArt", this.f17044d);
        bundle.putStringArray("tags", this.f17045e);
        bundle.putBoolean("updateLocal", this.f17046f);
        bundle.putInt("channelId", this.f17047g);
        bundle.putString("channelLogin", this.f17048h);
        return bundle;
    }

    public final int b() {
        return this.f17049i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (y5.p) r5;
        r1 = r5.f17041a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof y5.p
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            y5.p r5 = (y5.p) r5
            int r1 = r5.f17041a
            int r3 = r4.f17041a
            if (r3 == r1) goto L_0x0013
            return r2
        L_0x0013:
            java.lang.String r1 = r4.f17042b
            java.lang.String r3 = r5.f17042b
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x001e
            return r2
        L_0x001e:
            java.lang.String r1 = r4.f17043c
            java.lang.String r3 = r5.f17043c
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x0029
            return r2
        L_0x0029:
            java.lang.String r1 = r4.f17044d
            java.lang.String r3 = r5.f17044d
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x0034
            return r2
        L_0x0034:
            java.lang.String[] r1 = r4.f17045e
            java.lang.String[] r3 = r5.f17045e
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x003f
            return r2
        L_0x003f:
            boolean r1 = r4.f17046f
            boolean r3 = r5.f17046f
            if (r1 == r3) goto L_0x0046
            return r2
        L_0x0046:
            int r1 = r4.f17047g
            int r3 = r5.f17047g
            if (r1 == r3) goto L_0x004d
            return r2
        L_0x004d:
            java.lang.String r1 = r4.f17048h
            java.lang.String r5 = r5.f17048h
            boolean r5 = xa.j.a(r1, r5)
            if (r5 != 0) goto L_0x0058
            return r2
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y5.p.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i10 = this.f17041a * 31;
        int i11 = 0;
        String str = this.f17042b;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f17043c;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f17044d;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String[] strArr = this.f17045e;
        int hashCode4 = (hashCode3 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        boolean z10 = this.f17046f;
        if (z10) {
            z10 = true;
        }
        int i12 = (((hashCode4 + (z10 ? 1 : 0)) * 31) + this.f17047g) * 31;
        String str4 = this.f17048h;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return i12 + i11;
    }

    public final String toString() {
        String arrays = Arrays.toString(this.f17045e);
        StringBuilder sb2 = new StringBuilder("ActionGlobalGameMediaFragment(gameId=");
        sb2.append(this.f17041a);
        sb2.append(", gameSlug=");
        sb2.append(this.f17042b);
        sb2.append(", gameName=");
        sb2.append(this.f17043c);
        sb2.append(", boxArt=");
        f.k(sb2, this.f17044d, ", tags=", arrays, ", updateLocal=");
        sb2.append(this.f17046f);
        sb2.append(", channelId=");
        sb2.append(this.f17047g);
        sb2.append(", channelLogin=");
        return h.p(sb2, this.f17048h, ")");
    }

    public p(int i10, String str, String str2, String str3, String[] strArr, boolean z10, int i11, String str4) {
        this.f17041a = i10;
        this.f17042b = str;
        this.f17043c = str2;
        this.f17044d = str3;
        this.f17045e = strArr;
        this.f17046f = z10;
        this.f17047g = i11;
        this.f17048h = str4;
        this.f17049i = R.id.action_global_gameMediaFragment;
    }
}
