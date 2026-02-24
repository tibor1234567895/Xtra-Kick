package i4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.media.session.g0;
import android.support.v4.media.session.u;
import android.view.View;
import coil.target.GenericViewTarget;
import h3.j3;
import hb.d2;
import hb.h0;
import hb.l1;
import hb.o1;
import hb.p0;
import j4.d;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.CoroutineExceptionHandler;
import la.e;
import la.i;
import la.o;
import m4.l;
import ma.z;
import mb.f;
import p4.b;
import p4.c;
import p4.g;
import pa.k;
import pb.t0;
import s4.a;
import w4.j;

public final class t implements m {

    /* renamed from: a  reason: collision with root package name */
    public final a f8272a;

    /* renamed from: b  reason: collision with root package name */
    public final e f8273b;

    /* renamed from: c  reason: collision with root package name */
    public final h f8274c;

    /* renamed from: d  reason: collision with root package name */
    public final f f8275d;

    /* renamed from: e  reason: collision with root package name */
    public final u f8276e;

    /* renamed from: f  reason: collision with root package name */
    public final c f8277f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList f8278g;

    static {
        new o(0);
    }

    public t(Context context, a aVar, o oVar, o oVar2, o oVar3, j3 j3Var, c cVar, j jVar) {
        this.f8272a = aVar;
        this.f8273b = oVar;
        this.f8274c = j3Var;
        d2 d2Var = new d2((l1) null);
        nb.e eVar = p0.f7833a;
        k I0 = h0.j1(d2Var, mb.u.f10886a.Q0()).I0(new s(CoroutineExceptionHandler.f9430e, this));
        this.f8275d = new f(I0.N(l1.f7823b) == null ? I0.I0(new o1((l1) null)) : I0);
        w4.o oVar4 = new w4.o(this, context, jVar.f16092b);
        u uVar = new u((m) this, oVar4);
        this.f8276e = uVar;
        b bVar = new b(cVar);
        bVar.c(new c(), t0.class);
        bVar.c(new g(), String.class);
        Class<Uri> cls = Uri.class;
        bVar.c(new b(), cls);
        bVar.c(new p4.f(), cls);
        bVar.c(new p4.e(), Integer.class);
        bVar.c(new p4.a(), byte[].class);
        i iVar = new i(new o4.c(), cls);
        ArrayList arrayList = bVar.f8234c;
        arrayList.add(iVar);
        Class<File> cls2 = File.class;
        arrayList.add(new i(new o4.a(jVar.f16091a), cls2));
        bVar.b(new m4.o(oVar3, oVar2, jVar.f16093c), cls);
        bVar.b(new l(), cls2);
        bVar.b(new m4.a(), cls);
        bVar.b(new m4.f(), cls);
        bVar.b(new m4.t(), cls);
        bVar.b(new m4.g(), Drawable.class);
        bVar.b(new m4.c(), Bitmap.class);
        bVar.b(new m4.e(), ByteBuffer.class);
        bVar.f8236e.add(new d(jVar.f16094d, jVar.f16095e));
        c d10 = bVar.d();
        this.f8277f = d10;
        this.f8278g = z.D(new n4.j(this, uVar), d10.f8237a);
        new AtomicBoolean(false);
        context.registerComponentCallbacks(oVar4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e4 A[Catch:{ all -> 0x00f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0103 A[Catch:{ all -> 0x00f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010f A[Catch:{ all -> 0x00f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x011f A[Catch:{ all -> 0x00f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x016b A[Catch:{ all -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0174 A[Catch:{ all -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x019a A[Catch:{ all -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(i4.t r22, s4.i r23, pa.e r24) {
        /*
            r1 = r22
            r0 = r23
            r2 = r24
            r22.getClass()
            boolean r3 = r2 instanceof i4.q
            if (r3 == 0) goto L_0x001c
            r3 = r2
            i4.q r3 = (i4.q) r3
            int r4 = r3.f8264o
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x001c
            int r4 = r4 - r5
            r3.f8264o = r4
            goto L_0x0021
        L_0x001c:
            i4.q r3 = new i4.q
            r3.<init>(r1, r2)
        L_0x0021:
            r8 = r3
            java.lang.Object r2 = r8.f8262m
            qa.a r9 = qa.a.COROUTINE_SUSPENDED
            int r3 = r8.f8264o
            r10 = 3
            r11 = 2
            r12 = 1
            r13 = 0
            if (r3 == 0) goto L_0x006c
            if (r3 == r12) goto L_0x005a
            if (r3 == r11) goto L_0x0049
            if (r3 != r10) goto L_0x0041
            i4.i r1 = r8.f8260k
            s4.i r3 = r8.f8259j
            s4.q r4 = r8.f8258i
            i4.t r5 = r8.f8257h
            hb.h0.O1(r2)     // Catch:{ all -> 0x0069 }
            goto L_0x016d
        L_0x0041:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0049:
            android.graphics.Bitmap r0 = r8.f8261l
            i4.i r1 = r8.f8260k
            s4.i r3 = r8.f8259j
            s4.q r4 = r8.f8258i
            i4.t r5 = r8.f8257h
            hb.h0.O1(r2)     // Catch:{ all -> 0x0069 }
            r19 = r0
            goto L_0x0143
        L_0x005a:
            i4.i r1 = r8.f8260k
            s4.i r3 = r8.f8259j
            s4.q r4 = r8.f8258i
            i4.t r5 = r8.f8257h
            hb.h0.O1(r2)     // Catch:{ all -> 0x0069 }
            r2 = r1
            r1 = r5
            goto L_0x00da
        L_0x0069:
            r0 = move-exception
            goto L_0x01ad
        L_0x006c:
            hb.h0.O1(r2)
            pa.k r2 = r8.getContext()
            hb.l1 r7 = hb.h0.u0(r2)
            android.support.v4.media.session.u r2 = r1.f8276e
            r2.getClass()
            androidx.lifecycle.t r6 = r0.f14271w
            u4.a r3 = r0.f14251c
            boolean r4 = r3 instanceof coil.target.GenericViewTarget
            if (r4 == 0) goto L_0x0097
            coil.request.ViewTargetRequestDelegate r14 = new coil.request.ViewTargetRequestDelegate
            java.lang.Object r2 = r2.f428i
            r4 = r2
            i4.m r4 = (i4.m) r4
            r5 = r3
            coil.target.GenericViewTarget r5 = (coil.target.GenericViewTarget) r5
            r2 = r14
            r3 = r4
            r4 = r23
            r2.<init>(r3, r4, r5, r6, r7)
            r4 = r14
            goto L_0x009d
        L_0x0097:
            coil.request.BaseRequestDelegate r2 = new coil.request.BaseRequestDelegate
            r2.<init>(r6, r7)
            r4 = r2
        L_0x009d:
            r4.g()
            s4.g r2 = new s4.g
            android.content.Context r3 = r0.f14249a
            r2.<init>(r0, r3)
            s4.a r0 = r1.f8272a
            r2.f14224b = r0
            r0 = 0
            r2.O = r0
            s4.i r3 = r2.a()
            i4.h r0 = r1.f8274c
            h3.j3 r0 = (h3.j3) r0
            r0.getClass()
            int r0 = i4.f.f8243a
            i4.d r2 = i4.i.f8246a
            java.lang.Object r0 = r3.f14250b     // Catch:{ all -> 0x00f7 }
            s4.k r5 = s4.k.f14275a     // Catch:{ all -> 0x00f7 }
            if (r0 == r5) goto L_0x01b0
            r4.start()     // Catch:{ all -> 0x00f7 }
            androidx.lifecycle.t r0 = r3.f14271w     // Catch:{ all -> 0x00f7 }
            r8.f8257h = r1     // Catch:{ all -> 0x00f7 }
            r8.f8258i = r4     // Catch:{ all -> 0x00f7 }
            r8.f8259j = r3     // Catch:{ all -> 0x00f7 }
            r8.f8260k = r2     // Catch:{ all -> 0x00f7 }
            r8.f8264o = r12     // Catch:{ all -> 0x00f7 }
            java.lang.Object r0 = hb.h0.l(r0, r8)     // Catch:{ all -> 0x00f7 }
            if (r0 != r9) goto L_0x00da
            goto L_0x01e0
        L_0x00da:
            la.e r0 = r1.f8273b     // Catch:{ all -> 0x00f7 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x00f7 }
            q4.h r0 = (q4.h) r0     // Catch:{ all -> 0x00f7 }
            if (r0 == 0) goto L_0x0100
            q4.d r5 = r3.f14274z     // Catch:{ all -> 0x00f7 }
            if (r5 == 0) goto L_0x00fa
            q4.o r6 = r0.f13331a     // Catch:{ all -> 0x00f7 }
            q4.e r6 = r6.b(r5)     // Catch:{ all -> 0x00f7 }
            if (r6 != 0) goto L_0x00fb
            q4.p r0 = r0.f13332b     // Catch:{ all -> 0x00f7 }
            q4.e r6 = r0.b(r5)     // Catch:{ all -> 0x00f7 }
            goto L_0x00fb
        L_0x00f7:
            r0 = move-exception
            goto L_0x01b6
        L_0x00fa:
            r6 = r13
        L_0x00fb:
            if (r6 == 0) goto L_0x0100
            android.graphics.Bitmap r0 = r6.f13327a     // Catch:{ all -> 0x00f7 }
            goto L_0x0101
        L_0x0100:
            r0 = r13
        L_0x0101:
            if (r0 == 0) goto L_0x010f
            android.content.Context r5 = r3.f14249a     // Catch:{ all -> 0x00f7 }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ all -> 0x00f7 }
            android.graphics.drawable.BitmapDrawable r6 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x00f7 }
            r6.<init>(r5, r0)     // Catch:{ all -> 0x00f7 }
            goto L_0x011b
        L_0x010f:
            s4.a r5 = r3.H     // Catch:{ all -> 0x00f7 }
            android.graphics.drawable.Drawable r5 = r5.f14197j     // Catch:{ all -> 0x00f7 }
            android.graphics.drawable.Drawable r6 = r3.B     // Catch:{ all -> 0x00f7 }
            java.lang.Integer r7 = r3.A     // Catch:{ all -> 0x00f7 }
            android.graphics.drawable.Drawable r6 = w4.c.b(r3, r6, r7, r5)     // Catch:{ all -> 0x00f7 }
        L_0x011b:
            u4.a r5 = r3.f14251c     // Catch:{ all -> 0x00f7 }
            if (r5 == 0) goto L_0x0122
            r5.c(r6)     // Catch:{ all -> 0x00f7 }
        L_0x0122:
            r2.getClass()     // Catch:{ all -> 0x00f7 }
            t4.h r5 = r3.f14272x     // Catch:{ all -> 0x00f7 }
            r8.f8257h = r1     // Catch:{ all -> 0x00f7 }
            r8.f8258i = r4     // Catch:{ all -> 0x00f7 }
            r8.f8259j = r3     // Catch:{ all -> 0x00f7 }
            r8.f8260k = r2     // Catch:{ all -> 0x00f7 }
            r8.f8261l = r0     // Catch:{ all -> 0x00f7 }
            r8.f8264o = r11     // Catch:{ all -> 0x00f7 }
            java.lang.Object r5 = r5.a(r8)     // Catch:{ all -> 0x00f7 }
            if (r5 != r9) goto L_0x013b
            goto L_0x01e0
        L_0x013b:
            r19 = r0
            r21 = r5
            r5 = r1
            r1 = r2
            r2 = r21
        L_0x0143:
            r17 = r2
            t4.g r17 = (t4.g) r17     // Catch:{ all -> 0x0069 }
            r1.getClass()     // Catch:{ all -> 0x0069 }
            hb.d0 r0 = r3.f14267s     // Catch:{ all -> 0x0069 }
            i4.r r2 = new i4.r     // Catch:{ all -> 0x0069 }
            r20 = 0
            r14 = r2
            r15 = r3
            r16 = r5
            r18 = r1
            r14.<init>(r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x0069 }
            r8.f8257h = r5     // Catch:{ all -> 0x0069 }
            r8.f8258i = r4     // Catch:{ all -> 0x0069 }
            r8.f8259j = r3     // Catch:{ all -> 0x0069 }
            r8.f8260k = r1     // Catch:{ all -> 0x0069 }
            r8.f8261l = r13     // Catch:{ all -> 0x0069 }
            r8.f8264o = r10     // Catch:{ all -> 0x0069 }
            java.lang.Object r2 = hb.h0.c2(r0, r2, r8)     // Catch:{ all -> 0x0069 }
            if (r2 != r9) goto L_0x016d
            goto L_0x01e0
        L_0x016d:
            r9 = r2
            s4.j r9 = (s4.j) r9     // Catch:{ all -> 0x0069 }
            boolean r0 = r9 instanceof s4.r     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x019a
            r0 = r9
            s4.r r0 = (s4.r) r0     // Catch:{ all -> 0x0069 }
            u4.a r2 = r3.f14251c     // Catch:{ all -> 0x0069 }
            r5.getClass()     // Catch:{ all -> 0x0069 }
            s4.i r6 = r0.f14295b     // Catch:{ all -> 0x0069 }
            boolean r7 = r2 instanceof coil.target.GenericViewTarget     // Catch:{ all -> 0x0069 }
            android.graphics.drawable.Drawable r0 = r0.f14294a     // Catch:{ all -> 0x0069 }
            if (r7 != 0) goto L_0x0187
            if (r2 == 0) goto L_0x0194
            goto L_0x0191
        L_0x0187:
            v4.c r7 = r6.f14260l     // Catch:{ all -> 0x0069 }
            r8 = r2
            coil.target.GenericViewTarget r8 = (coil.target.GenericViewTarget) r8     // Catch:{ all -> 0x0069 }
            v4.a r7 = (v4.a) r7     // Catch:{ all -> 0x0069 }
            r7.getClass()     // Catch:{ all -> 0x0069 }
        L_0x0191:
            r2.h(r0)     // Catch:{ all -> 0x0069 }
        L_0x0194:
            r1.getClass()     // Catch:{ all -> 0x0069 }
            s4.h r0 = r6.f14252d     // Catch:{ all -> 0x0069 }
            goto L_0x01a9
        L_0x019a:
            boolean r0 = r9 instanceof s4.d     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x01a9
            r0 = r9
            s4.d r0 = (s4.d) r0     // Catch:{ all -> 0x0069 }
            u4.a r2 = r3.f14251c     // Catch:{ all -> 0x0069 }
            r5.getClass()     // Catch:{ all -> 0x0069 }
            c(r0, r2, r1)     // Catch:{ all -> 0x0069 }
        L_0x01a9:
            r4.e()
            goto L_0x01e0
        L_0x01ad:
            r2 = r1
            r1 = r5
            goto L_0x01b6
        L_0x01b0:
            s4.l r0 = new s4.l     // Catch:{ all -> 0x00f7 }
            r0.<init>()     // Catch:{ all -> 0x00f7 }
            throw r0     // Catch:{ all -> 0x00f7 }
        L_0x01b6:
            boolean r5 = r0 instanceof java.util.concurrent.CancellationException     // Catch:{ all -> 0x01ea }
            if (r5 != 0) goto L_0x01e1
            android.support.v4.media.session.u r1 = r1.f8276e     // Catch:{ all -> 0x01ea }
            r1.getClass()     // Catch:{ all -> 0x01ea }
            s4.d r9 = new s4.d     // Catch:{ all -> 0x01ea }
            boolean r1 = r0 instanceof s4.l     // Catch:{ all -> 0x01ea }
            if (r1 == 0) goto L_0x01d3
            s4.a r1 = r3.H     // Catch:{ all -> 0x01ea }
            android.graphics.drawable.Drawable r1 = r1.f14199l     // Catch:{ all -> 0x01ea }
            android.graphics.drawable.Drawable r5 = r3.F     // Catch:{ all -> 0x01ea }
            java.lang.Integer r6 = r3.E     // Catch:{ all -> 0x01ea }
            android.graphics.drawable.Drawable r1 = w4.c.b(r3, r5, r6, r1)     // Catch:{ all -> 0x01ea }
            if (r1 != 0) goto L_0x01d7
        L_0x01d3:
            android.graphics.drawable.Drawable r1 = r3.a()     // Catch:{ all -> 0x01ea }
        L_0x01d7:
            r9.<init>(r1, r3, r0)     // Catch:{ all -> 0x01ea }
            u4.a r0 = r3.f14251c     // Catch:{ all -> 0x01ea }
            c(r9, r0, r2)     // Catch:{ all -> 0x01ea }
            goto L_0x01a9
        L_0x01e0:
            return r9
        L_0x01e1:
            r1.getClass()     // Catch:{ all -> 0x01ea }
            r2.getClass()     // Catch:{ all -> 0x01ea }
            s4.h r1 = r3.f14252d     // Catch:{ all -> 0x01ea }
            throw r0     // Catch:{ all -> 0x01ea }
        L_0x01ea:
            r0 = move-exception
            r4.e()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.t.a(i4.t, s4.i, pa.e):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        if (r4 != null) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(s4.d r3, u4.a r4, i4.i r5) {
        /*
            s4.i r0 = r3.f14219b
            boolean r1 = r4 instanceof coil.target.GenericViewTarget
            if (r1 != 0) goto L_0x0009
            if (r4 == 0) goto L_0x0018
            goto L_0x0013
        L_0x0009:
            v4.c r1 = r0.f14260l
            r2 = r4
            coil.target.GenericViewTarget r2 = (coil.target.GenericViewTarget) r2
            v4.a r1 = (v4.a) r1
            r1.getClass()
        L_0x0013:
            android.graphics.drawable.Drawable r3 = r3.f14218a
            r4.i(r3)
        L_0x0018:
            r5.getClass()
            s4.h r3 = r0.f14252d
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.t.c(s4.d, u4.a, i4.i):void");
    }

    public final s4.c b(s4.i iVar) {
        h0.i(this.f8275d, new p(this, iVar, (pa.e) null));
        u4.a aVar = iVar.f14251c;
        if (!(aVar instanceof GenericViewTarget)) {
            return new g0();
        }
        ((GenericViewTarget) aVar).k();
        w4.e.c((View) null);
        throw null;
    }
}
