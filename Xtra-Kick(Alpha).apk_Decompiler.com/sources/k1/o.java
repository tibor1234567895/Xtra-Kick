package k1;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import j1.a;
import j1.l0;
import j1.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public final class o implements h {

    /* renamed from: a  reason: collision with root package name */
    public final Context f9034a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f9035b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final h f9036c;

    /* renamed from: d  reason: collision with root package name */
    public v f9037d;

    /* renamed from: e  reason: collision with root package name */
    public b f9038e;

    /* renamed from: f  reason: collision with root package name */
    public e f9039f;

    /* renamed from: g  reason: collision with root package name */
    public h f9040g;

    /* renamed from: h  reason: collision with root package name */
    public h0 f9041h;

    /* renamed from: i  reason: collision with root package name */
    public f f9042i;

    /* renamed from: j  reason: collision with root package name */
    public d0 f9043j;

    /* renamed from: k  reason: collision with root package name */
    public h f9044k;

    public o(Context context, h hVar) {
        this.f9034a = context.getApplicationContext();
        hVar.getClass();
        this.f9036c = hVar;
    }

    public static void t(h hVar, f0 f0Var) {
        if (hVar != null) {
            hVar.i(f0Var);
        }
    }

    public final void close() {
        h hVar = this.f9044k;
        if (hVar != null) {
            try {
                hVar.close();
            } finally {
                this.f9044k = null;
            }
        }
    }

    public final Map e() {
        h hVar = this.f9044k;
        return hVar == null ? Collections.emptyMap() : hVar.e();
    }

    public final void i(f0 f0Var) {
        f0Var.getClass();
        this.f9036c.i(f0Var);
        this.f9035b.add(f0Var);
        t(this.f9037d, f0Var);
        t(this.f9038e, f0Var);
        t(this.f9039f, f0Var);
        t(this.f9040g, f0Var);
        t(this.f9041h, f0Var);
        t(this.f9042i, f0Var);
        t(this.f9043j, f0Var);
    }

    public final Uri j() {
        h hVar = this.f9044k;
        if (hVar == null) {
            return null;
        }
        return hVar.j();
    }

    public final int o(byte[] bArr, int i10, int i11) {
        h hVar = this.f9044k;
        hVar.getClass();
        return hVar.o(bArr, i10, i11);
    }

    public final long q(m mVar) {
        boolean z10;
        h hVar;
        boolean z11 = true;
        if (this.f9044k == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.e(z10);
        String scheme = mVar.f9022a.getScheme();
        int i10 = l0.f8453a;
        Uri uri = mVar.f9022a;
        String scheme2 = uri.getScheme();
        if (!TextUtils.isEmpty(scheme2) && !"file".equals(scheme2)) {
            z11 = false;
        }
        if (z11) {
            String path = uri.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.f9037d == null) {
                    v vVar = new v();
                    this.f9037d = vVar;
                    r(vVar);
                }
                hVar = this.f9037d;
                this.f9044k = hVar;
                return this.f9044k.q(mVar);
            }
        } else if (!"asset".equals(scheme)) {
            boolean equals = "content".equals(scheme);
            Context context = this.f9034a;
            if (equals) {
                if (this.f9039f == null) {
                    e eVar = new e(context);
                    this.f9039f = eVar;
                    r(eVar);
                }
                hVar = this.f9039f;
            } else {
                boolean equals2 = "rtmp".equals(scheme);
                h hVar2 = this.f9036c;
                if (equals2) {
                    if (this.f9040g == null) {
                        try {
                            h hVar3 = (h) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                            this.f9040g = hVar3;
                            r(hVar3);
                        } catch (ClassNotFoundException unused) {
                            v.g("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                        } catch (Exception e10) {
                            throw new RuntimeException("Error instantiating RTMP extension", e10);
                        }
                        if (this.f9040g == null) {
                            this.f9040g = hVar2;
                        }
                    }
                    hVar = this.f9040g;
                } else if ("udp".equals(scheme)) {
                    if (this.f9041h == null) {
                        h0 h0Var = new h0();
                        this.f9041h = h0Var;
                        r(h0Var);
                    }
                    hVar = this.f9041h;
                } else if ("data".equals(scheme)) {
                    if (this.f9042i == null) {
                        f fVar = new f();
                        this.f9042i = fVar;
                        r(fVar);
                    }
                    hVar = this.f9042i;
                } else if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
                    if (this.f9043j == null) {
                        d0 d0Var = new d0(context);
                        this.f9043j = d0Var;
                        r(d0Var);
                    }
                    hVar = this.f9043j;
                } else {
                    this.f9044k = hVar2;
                    return this.f9044k.q(mVar);
                }
            }
            this.f9044k = hVar;
            return this.f9044k.q(mVar);
        }
        hVar = s();
        this.f9044k = hVar;
        return this.f9044k.q(mVar);
    }

    public final void r(h hVar) {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f9035b;
            if (i10 < arrayList.size()) {
                hVar.i((f0) arrayList.get(i10));
                i10++;
            } else {
                return;
            }
        }
    }

    public final h s() {
        if (this.f9038e == null) {
            b bVar = new b(this.f9034a);
            this.f9038e = bVar;
            r(bVar);
        }
        return this.f9038e;
    }
}
