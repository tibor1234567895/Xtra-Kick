package e6;

import a6.e;
import a6.m;
import a6.x;
import a6.y;
import android.content.Context;
import androidx.lifecycle.m0;
import androidx.lifecycle.u1;
import androidx.lifecycle.v1;
import c6.b;
import com.github.andreyasadchy.xtra.XtraApp;
import com.github.andreyasadchy.xtra.api.MiscApi;
import com.github.andreyasadchy.xtra.model.VideoPosition;
import hb.d1;
import hb.h0;
import javax.inject.Inject;
import pa.h;
import r3.s0;
import r3.u0;
import xa.j;
import y5.v;

public final class z1 {

    /* renamed from: a  reason: collision with root package name */
    public final MiscApi f5283a;

    /* renamed from: b  reason: collision with root package name */
    public final m f5284b;

    /* renamed from: c  reason: collision with root package name */
    public final x f5285c;

    /* renamed from: d  reason: collision with root package name */
    public final x f5286d;

    /* renamed from: e  reason: collision with root package name */
    public final b f5287e;

    /* renamed from: f  reason: collision with root package name */
    public final s0 f5288f;

    @Inject
    public z1(MiscApi miscApi, m mVar, x xVar, x xVar2, b bVar, s0 s0Var) {
        j.f("misc", miscApi);
        j.f("recentEmotes", mVar);
        j.f("videoPositions", xVar);
        j.f("apiRepository", xVar2);
        j.f("kickMapper", bVar);
        j.f("kickApi", s0Var);
        this.f5283a = miscApi;
        this.f5284b = mVar;
        this.f5285c = xVar;
        this.f5286d = xVar2;
        this.f5287e = bVar;
        this.f5288f = s0Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(pa.e r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof e6.u1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            e6.u1 r0 = (e6.u1) r0
            int r1 = r0.f5252j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f5252j = r1
            goto L_0x0018
        L_0x0013:
            e6.u1 r0 = new e6.u1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f5250h
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f5252j
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            hb.h0.O1(r6)
            goto L_0x0043
        L_0x0027:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x002f:
            hb.h0.O1(r6)
            nb.d r6 = hb.p0.f7834b
            e6.v1 r2 = new e6.v1
            r4 = 0
            r2.<init>(r4)
            r0.f5252j = r3
            java.lang.Object r6 = hb.h0.c2(r6, r2, r0)
            if (r6 != r1) goto L_0x0043
            return r1
        L_0x0043:
            java.lang.String r0 = "withContext(Dispatchers.…ponse.success(null)\n    }"
            xa.j.e(r0, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.z1.a(pa.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Comparable b(java.lang.String r6, pa.e r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof e6.w1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            e6.w1 r0 = (e6.w1) r0
            int r1 = r0.f5264j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f5264j = r1
            goto L_0x0018
        L_0x0013:
            e6.w1 r0 = new e6.w1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f5262h
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f5264j
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0030
            if (r2 != r4) goto L_0x0028
            hb.h0.O1(r7)
            goto L_0x0048
        L_0x0028:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0030:
            hb.h0.O1(r7)
            r0.f5264j = r4
            e6.x r7 = r5.f5286d
            r7.getClass()
            nb.d r2 = hb.p0.f7834b
            e6.u r4 = new e6.u
            r4.<init>(r7, r6, r3)
            java.lang.Object r7 = hb.h0.c2(r2, r4, r0)
            if (r7 != r1) goto L_0x0048
            return r1
        L_0x0048:
            com.github.andreyasadchy.xtra.model.ui.Video r7 = (com.github.andreyasadchy.xtra.model.ui.Video) r7
            if (r7 == 0) goto L_0x005b
            java.lang.String r6 = r7.getVideoUrl()
            if (r6 == 0) goto L_0x005b
            android.net.Uri r3 = android.net.Uri.parse(r6)
            java.lang.String r6 = "parse(this)"
            xa.j.e(r6, r3)
        L_0x005b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.z1.b(java.lang.String, pa.e):java.lang.Comparable");
    }

    public final m0 c() {
        y yVar = (y) this.f5285c;
        yVar.getClass();
        u0 b10 = yVar.f265a.f13722e.b(new String[]{"video_positions"}, new e(yVar, s0.k(0, "SELECT * FROM video_positions"), 3));
        x1 x1Var = x1.f5269h;
        j.f("transform", x1Var);
        m0 m0Var = new m0();
        m0Var.m(b10, new v1(0, new u1(m0Var, 0, x1Var)));
        return m0Var;
    }

    public final void d(VideoPosition videoPosition) {
        XtraApp.f3319k.getClass();
        Context applicationContext = v.a().getApplicationContext();
        j.e("appContext", applicationContext);
        if (h0.l1(applicationContext).getBoolean("player_use_videopositions", true)) {
            h0.b1(d1.f7786h, (h) null, 0, new y1(this, videoPosition, (pa.e) null), 3);
        }
    }
}
