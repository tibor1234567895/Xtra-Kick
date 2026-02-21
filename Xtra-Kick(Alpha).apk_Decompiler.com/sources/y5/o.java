package y5;

import android.os.Bundle;
import android.support.v4.media.h;
import com.woxthebox.draglistview.R;
import j3.d1;

public final class o implements d1 {

    /* renamed from: a  reason: collision with root package name */
    public final int f17034a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17035b;

    /* renamed from: c  reason: collision with root package name */
    public final String f17036c;

    /* renamed from: d  reason: collision with root package name */
    public final String f17037d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f17038e;

    /* renamed from: f  reason: collision with root package name */
    public final int f17039f;

    /* renamed from: g  reason: collision with root package name */
    public final int f17040g;

    public o() {
        this(0, 0, (String) null, (String) null, (String) null, false);
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt("channelId", this.f17034a);
        bundle.putString("channelLogin", this.f17035b);
        bundle.putString("channelName", this.f17036c);
        bundle.putString("channelLogo", this.f17037d);
        bundle.putBoolean("updateLocal", this.f17038e);
        bundle.putInt("streamId", this.f17039f);
        return bundle;
    }

    public final int b() {
        return this.f17040g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (y5.o) r5;
        r1 = r5.f17034a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof y5.o
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            y5.o r5 = (y5.o) r5
            int r1 = r5.f17034a
            int r3 = r4.f17034a
            if (r3 == r1) goto L_0x0013
            return r2
        L_0x0013:
            java.lang.String r1 = r4.f17035b
            java.lang.String r3 = r5.f17035b
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x001e
            return r2
        L_0x001e:
            java.lang.String r1 = r4.f17036c
            java.lang.String r3 = r5.f17036c
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x0029
            return r2
        L_0x0029:
            java.lang.String r1 = r4.f17037d
            java.lang.String r3 = r5.f17037d
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x0034
            return r2
        L_0x0034:
            boolean r1 = r4.f17038e
            boolean r3 = r5.f17038e
            if (r1 == r3) goto L_0x003b
            return r2
        L_0x003b:
            int r1 = r4.f17039f
            int r5 = r5.f17039f
            if (r1 == r5) goto L_0x0042
            return r2
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y5.o.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i10 = this.f17034a * 31;
        int i11 = 0;
        String str = this.f17035b;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f17036c;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f17037d;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        int i12 = (hashCode2 + i11) * 31;
        boolean z10 = this.f17038e;
        if (z10) {
            z10 = true;
        }
        return ((i12 + (z10 ? 1 : 0)) * 31) + this.f17039f;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ActionGlobalChannelPagerFragment(channelId=");
        sb2.append(this.f17034a);
        sb2.append(", channelLogin=");
        sb2.append(this.f17035b);
        sb2.append(", channelName=");
        sb2.append(this.f17036c);
        sb2.append(", channelLogo=");
        sb2.append(this.f17037d);
        sb2.append(", updateLocal=");
        sb2.append(this.f17038e);
        sb2.append(", streamId=");
        return h.o(sb2, this.f17039f, ")");
    }

    public o(int i10, int i11, String str, String str2, String str3, boolean z10) {
        this.f17034a = i10;
        this.f17035b = str;
        this.f17036c = str2;
        this.f17037d = str3;
        this.f17038e = z10;
        this.f17039f = i11;
        this.f17040g = R.id.action_global_channelPagerFragment;
    }
}
