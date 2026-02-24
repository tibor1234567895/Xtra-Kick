package h3;

import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.z;
import b0.l0;
import c0.e;
import c0.g;
import h9.e0;
import h9.w;
import j0.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import o1.b0;

public final class y1 {

    /* renamed from: a  reason: collision with root package name */
    public final b3 f7479a;

    /* renamed from: b  reason: collision with root package name */
    public final q1 f7480b;

    /* renamed from: c  reason: collision with root package name */
    public final h f7481c;

    /* renamed from: d  reason: collision with root package name */
    public final l0 f7482d;

    /* renamed from: e  reason: collision with root package name */
    public final b0 f7483e = new b0(4, new Handler(Looper.getMainLooper()));

    /* renamed from: f  reason: collision with root package name */
    public final Intent f7484f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap f7485g;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap f7486h;

    /* renamed from: i  reason: collision with root package name */
    public int f7487i;

    /* renamed from: j  reason: collision with root package name */
    public r1 f7488j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f7489k;

    public y1(b3 b3Var, q1 q1Var, h hVar) {
        this.f7479a = b3Var;
        this.f7480b = q1Var;
        this.f7481c = hVar;
        this.f7482d = new l0(b3Var);
        this.f7484f = new Intent(b3Var, b3Var.getClass());
        this.f7485g = new HashMap();
        this.f7486h = new HashMap();
        this.f7489k = false;
    }

    public final b0 a(g2 g2Var) {
        e0 e0Var = (e0) this.f7485g.get(g2Var);
        if (e0Var == null) {
            return null;
        }
        try {
            return (b0) w.b(e0Var);
        } catch (ExecutionException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public final void b(boolean z10) {
        ArrayList arrayList;
        r1 r1Var;
        boolean z11;
        b3 b3Var = this.f7479a;
        synchronized (b3Var.f6934h) {
            arrayList = new ArrayList(b3Var.f6936j.values());
        }
        int i10 = 0;
        while (i10 < arrayList.size()) {
            if (!c((g2) arrayList.get(i10), false)) {
                i10++;
            } else {
                return;
            }
        }
        int i11 = j1.l0.f8453a;
        b3 b3Var2 = this.f7479a;
        if (i11 >= 24) {
            v1.a(b3Var2, z10);
        } else {
            if (z10 || i11 < 21) {
                z11 = true;
            } else {
                z11 = false;
            }
            b3Var2.stopForeground(z11);
        }
        this.f7489k = false;
        if (z10 && (r1Var = this.f7488j) != null) {
            this.f7482d.f2376b.cancel((String) null, r1Var.f7299a);
            this.f7487i++;
            this.f7488j = null;
        }
    }

    public final boolean c(g2 g2Var, boolean z10) {
        b0 a10 = a(g2Var);
        return a10 != null && (a10.y() || z10) && (a10.b() == 3 || a10.b() == 2);
    }

    public final void d(g2 g2Var, r1 r1Var, boolean z10) {
        int i10 = j1.l0.f8453a;
        if (i10 >= 21) {
            r1Var.f7300b.extras.putParcelable("android.mediaSession", (MediaSession.Token) ((z) g2Var.f7047a.f7234g.f7442l.f428i).h().f351i);
        }
        this.f7488j = r1Var;
        if (z10) {
            Intent intent = this.f7484f;
            Object obj = g.f2717a;
            int i11 = Build.VERSION.SDK_INT;
            b3 b3Var = this.f7479a;
            if (i11 >= 26) {
                e.b(b3Var, intent);
            } else {
                b3Var.startService(intent);
            }
            if (i10 >= 29) {
                w1.a(b3Var, r1Var);
            } else {
                b3Var.startForeground(r1Var.f7299a, r1Var.f7300b);
            }
            this.f7489k = true;
            return;
        }
        this.f7482d.a(r1Var.f7299a, r1Var.f7300b);
        b(false);
    }
}
