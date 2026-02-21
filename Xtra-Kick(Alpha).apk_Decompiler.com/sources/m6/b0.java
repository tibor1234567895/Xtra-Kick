package m6;

import android.app.Application;
import com.github.andreyasadchy.xtra.model.VideoDownloadInfo;
import com.github.andreyasadchy.xtra.ui.download.VideoDownloadViewModel;
import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class b0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public VideoDownloadViewModel f10615i;

    /* renamed from: j  reason: collision with root package name */
    public String f10616j;

    /* renamed from: k  reason: collision with root package name */
    public VideoDownloadInfo f10617k;

    /* renamed from: l  reason: collision with root package name */
    public Application f10618l;

    /* renamed from: m  reason: collision with root package name */
    public String f10619m;

    /* renamed from: n  reason: collision with root package name */
    public int f10620n;

    /* renamed from: o  reason: collision with root package name */
    public int f10621o;

    /* renamed from: p  reason: collision with root package name */
    public int f10622p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ VideoDownloadViewModel f10623q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f10624r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f10625s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ String f10626t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ String f10627u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ String f10628v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b0(VideoDownloadViewModel videoDownloadViewModel, int i10, int i11, String str, String str2, String str3, e eVar) {
        super(2, eVar);
        this.f10623q = videoDownloadViewModel;
        this.f10624r = i10;
        this.f10625s = i11;
        this.f10626t = str;
        this.f10627u = str2;
        this.f10628v = str3;
    }

    public final e create(Object obj, e eVar) {
        return new b0(this.f10623q, this.f10624r, this.f10625s, this.f10626t, this.f10627u, this.f10628v, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((b0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: com.github.andreyasadchy.xtra.model.VideoDownloadInfo} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f10622p
            r3 = 1
            if (r2 == 0) goto L_0x002b
            if (r2 != r3) goto L_0x0023
            int r1 = r0.f10621o
            int r2 = r0.f10620n
            java.lang.String r3 = r0.f10619m
            android.app.Application r4 = r0.f10618l
            com.github.andreyasadchy.xtra.model.VideoDownloadInfo r5 = r0.f10617k
            java.lang.String r6 = r0.f10616j
            com.github.andreyasadchy.xtra.ui.download.VideoDownloadViewModel r7 = r0.f10615i
            hb.h0.O1(r19)
            r8 = r1
            r12 = r3
            r11 = r6
            r1 = r19
            goto L_0x012a
        L_0x0023:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x002b:
            hb.h0.O1(r19)
            com.github.andreyasadchy.xtra.ui.download.VideoDownloadViewModel r7 = r0.f10623q
            androidx.lifecycle.o0 r2 = r7.f3396g
            java.lang.Object r2 = r2.d()
            xa.j.c(r2)
            java.lang.String r6 = r0.f10628v
            r5 = r2
            com.github.andreyasadchy.xtra.model.VideoDownloadInfo r5 = (com.github.andreyasadchy.xtra.model.VideoDownloadInfo) r5
            java.lang.String r2 = "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication"
            android.app.Application r4 = r7.f1665d
            xa.j.d(r2, r4)
            java.util.List r2 = r5.getRelativeStartTimes()
            int r15 = r0.f10624r
            java.lang.Object r2 = r2.get(r15)
            java.lang.Number r2 = (java.lang.Number) r2
            long r8 = r2.longValue()
            java.util.List r2 = r5.getRelativeStartTimes()
            int r14 = r0.f10625s
            java.lang.Object r2 = r2.get(r14)
            java.lang.Number r2 = (java.lang.Number) r2
            long r10 = r2.longValue()
            java.util.List r2 = r5.getDurations()
            java.lang.Object r2 = r2.get(r14)
            java.lang.Number r2 = (java.lang.Number) r2
            long r12 = r2.longValue()
            long r12 = r12 + r10
            long r12 = r12 - r8
            r10 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 - r10
            java.lang.String r2 = java.io.File.separator
            com.github.andreyasadchy.xtra.model.ui.Video r10 = r5.getVideo()
            java.lang.String r10 = r10.getUuid()
            if (r10 == 0) goto L_0x008d
            boolean r10 = fb.w.h(r10)
            if (r10 == 0) goto L_0x008b
            goto L_0x008d
        L_0x008b:
            r10 = 0
            goto L_0x008e
        L_0x008d:
            r10 = 1
        L_0x008e:
            if (r10 != 0) goto L_0x00ac
            com.github.andreyasadchy.xtra.model.ui.Video r10 = r5.getVideo()
            java.lang.String r10 = r10.getUuid()
            java.lang.String r11 = r0.f10627u
            r16 = r1
            java.lang.String r1 = "Audio"
            boolean r1 = fb.y.n(r11, r1, r3)
            if (r1 != 0) goto L_0x00a5
            goto L_0x00a7
        L_0x00a5:
            java.lang.String r11 = "audio"
        L_0x00a7:
            java.lang.String r1 = q0.f.g(r10, r11)
            goto L_0x00b7
        L_0x00ac:
            r16 = r1
            long r10 = java.lang.System.currentTimeMillis()
            java.lang.Long r1 = new java.lang.Long
            r1.<init>(r10)
        L_0x00b7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r10 = r0.f10626t
            r3.append(r10)
            r3.append(r2)
            r3.append(r1)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            s7.d r1 = s7.d.f14369a
            com.github.andreyasadchy.xtra.model.ui.Video r2 = r5.getVideo()
            java.lang.Long r11 = new java.lang.Long
            r11.<init>(r12)
            java.lang.Long r13 = new java.lang.Long
            r13.<init>(r8)
            java.lang.Integer r12 = new java.lang.Integer
            r12.<init>(r15)
            java.lang.Integer r10 = new java.lang.Integer
            r10.<init>(r14)
            r1.getClass()
            r8 = r4
            r9 = r2
            r1 = r10
            r10 = r6
            r2 = r11
            r11 = r3
            r17 = r12
            r12 = r2
            r2 = r14
            r14 = r17
            r17 = r2
            r2 = r15
            r15 = r1
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r1 = s7.d.b(r8, r9, r10, r11, r12, r13, r14, r15)
            r0.f10615i = r7
            r0.f10616j = r6
            r0.f10617k = r5
            r0.f10618l = r4
            r0.f10619m = r3
            r0.f10620n = r2
            r8 = r17
            r0.f10621o = r8
            r9 = 1
            r0.f10622p = r9
            e6.o1 r9 = r7.f3395f
            r9.getClass()
            nb.d r10 = hb.p0.f7834b
            e6.l1 r11 = new e6.l1
            r12 = 0
            r11.<init>(r9, r1, r12)
            java.lang.Object r1 = hb.h0.c2(r10, r11, r0)
            r9 = r16
            if (r1 != r9) goto L_0x0128
            return r9
        L_0x0128:
            r12 = r3
            r11 = r6
        L_0x012a:
            java.lang.Number r1 = (java.lang.Number) r1
            long r9 = r1.longValue()
            int r10 = (int) r9
            com.github.andreyasadchy.xtra.model.offline.Request r1 = new com.github.andreyasadchy.xtra.model.offline.Request
            com.github.andreyasadchy.xtra.model.ui.Video r3 = r5.getVideo()
            java.lang.String r13 = r3.getUuid()
            com.github.andreyasadchy.xtra.model.ui.Video r3 = r5.getVideo()
            java.lang.String r14 = r3.getType()
            java.lang.Integer r15 = new java.lang.Integer
            r15.<init>(r2)
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r8)
            r9 = r1
            r16 = r2
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            e6.o1 r2 = r7.f3395f
            r2.getClass()
            hb.d1 r3 = hb.d1.f7786h
            e6.k1 r5 = new e6.k1
            r6 = 0
            r5.<init>(r2, r1, r6)
            r2 = 3
            r7 = 0
            hb.h0.b1(r3, r6, r7, r5, r2)
            s7.d r2 = s7.d.f14369a
            r2.getClass()
            s7.d.a(r4, r1)
            la.v r1 = la.v.f9814a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: m6.b0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
