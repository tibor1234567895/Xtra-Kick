package h3;

import android.content.ComponentName;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.f;
import androidx.versionedparcelable.ParcelImpl;
import b0.j;
import d4.e;
import j1.l0;
import java.util.Arrays;

public final class n4 implements k4 {

    /* renamed from: n  reason: collision with root package name */
    public static final String f7251n = l0.C(0);

    /* renamed from: o  reason: collision with root package name */
    public static final String f7252o = l0.C(1);

    /* renamed from: p  reason: collision with root package name */
    public static final String f7253p = l0.C(2);

    /* renamed from: q  reason: collision with root package name */
    public static final String f7254q = l0.C(3);

    /* renamed from: r  reason: collision with root package name */
    public static final String f7255r = l0.C(4);

    /* renamed from: s  reason: collision with root package name */
    public static final String f7256s = l0.C(5);

    /* renamed from: h  reason: collision with root package name */
    public final MediaSessionCompat$Token f7257h;

    /* renamed from: i  reason: collision with root package name */
    public final int f7258i;

    /* renamed from: j  reason: collision with root package name */
    public final int f7259j;

    /* renamed from: k  reason: collision with root package name */
    public final ComponentName f7260k;

    /* renamed from: l  reason: collision with root package name */
    public final String f7261l;

    /* renamed from: m  reason: collision with root package name */
    public final Bundle f7262m;

    static {
        new j3(17);
    }

    public n4(MediaSessionCompat$Token mediaSessionCompat$Token, int i10, int i11, ComponentName componentName, String str, Bundle bundle) {
        this.f7257h = mediaSessionCompat$Token;
        this.f7258i = i10;
        this.f7259j = i11;
        this.f7260k = componentName;
        this.f7261l = str;
        this.f7262m = bundle;
    }

    public final int a() {
        return this.f7258i;
    }

    public final boolean b() {
        return true;
    }

    public final ComponentName c() {
        return this.f7260k;
    }

    public final Object d() {
        return this.f7257h;
    }

    public final String e() {
        ComponentName componentName = this.f7260k;
        return componentName == null ? "" : componentName.getClassName();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r4 = (h3.n4) r4;
        r0 = r4.f7259j;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof h3.n4
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            h3.n4 r4 = (h3.n4) r4
            int r0 = r4.f7259j
            int r2 = r3.f7259j
            if (r2 == r0) goto L_0x000f
            return r1
        L_0x000f:
            r0 = 100
            if (r2 == r0) goto L_0x0021
            r0 = 101(0x65, float:1.42E-43)
            if (r2 == r0) goto L_0x0018
            return r1
        L_0x0018:
            android.content.ComponentName r0 = r3.f7260k
            android.content.ComponentName r4 = r4.f7260k
        L_0x001c:
            boolean r4 = j1.l0.a(r0, r4)
            return r4
        L_0x0021:
            android.support.v4.media.session.MediaSessionCompat$Token r0 = r3.f7257h
            android.support.v4.media.session.MediaSessionCompat$Token r4 = r4.f7257h
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.n4.equals(java.lang.Object):boolean");
    }

    public final Bundle f() {
        return new Bundle(this.f7262m);
    }

    public final String g() {
        return this.f7261l;
    }

    public final int getType() {
        return this.f7259j != 101 ? 0 : 2;
    }

    public final Bundle h() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        String str = f7251n;
        MediaSessionCompat$Token mediaSessionCompat$Token = this.f7257h;
        if (mediaSessionCompat$Token == null) {
            bundle = null;
        } else {
            Bundle bundle3 = new Bundle();
            bundle3.putParcelable("android.support.v4.media.session.TOKEN", mediaSessionCompat$Token);
            synchronized (mediaSessionCompat$Token.f350h) {
                try {
                    f fVar = mediaSessionCompat$Token.f352j;
                    if (fVar != null) {
                        j.b(bundle3, "android.support.v4.media.session.EXTRA_BINDER", fVar.asBinder());
                    }
                    e eVar = mediaSessionCompat$Token.f353k;
                    if (eVar != null) {
                        Bundle bundle4 = new Bundle();
                        bundle4.putParcelable("a", new ParcelImpl(eVar));
                        bundle3.putParcelable("android.support.v4.media.session.SESSION_TOKEN2", bundle4);
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            bundle = bundle3;
        }
        bundle2.putBundle(str, bundle);
        bundle2.putInt(f7252o, this.f7258i);
        bundle2.putInt(f7253p, this.f7259j);
        bundle2.putParcelable(f7254q, this.f7260k);
        bundle2.putString(f7255r, this.f7261l);
        bundle2.putBundle(f7256s, this.f7262m);
        return bundle2;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f7259j), this.f7260k, this.f7257h});
    }

    public final String toString() {
        return "SessionToken {legacyToken=" + this.f7257h + "}";
    }
}
