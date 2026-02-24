package android.support.v4.media.session;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import androidx.preference.PreferenceScreen;
import e1.c0;
import h3.d2;
import h3.e2;
import h3.g;
import h3.o2;
import h3.x2;
import j1.a;
import java.lang.ref.WeakReference;
import o3.d0;
import o3.z;

public final class w extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f431a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f432b;

    public w(DialogInterface dialogInterface) {
        this.f431a = 2;
        this.f432b = new WeakReference(dialogInterface);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r3 >= r1) goto L_0x000d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        r4 = r2[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (((java.util.ArrayList) r4.f338j).size() > 0) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        android.support.v4.media.h.y(((java.util.ArrayList) r4.f338j).get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0046, code lost:
        throw null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.os.Message r7) {
        /*
            r6 = this;
            int r0 = r7.what
            r1 = 1
            if (r0 == r1) goto L_0x0009
            super.handleMessage(r7)
            goto L_0x0019
        L_0x0009:
            java.lang.Object r7 = r6.f432b
            d1.a r7 = (d1.a) r7
        L_0x000d:
            java.util.HashMap r0 = r7.f4132b
            monitor-enter(r0)
            java.util.ArrayList r1 = r7.f4134d     // Catch:{ all -> 0x0047 }
            int r1 = r1.size()     // Catch:{ all -> 0x0047 }
            if (r1 > 0) goto L_0x001a
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
        L_0x0019:
            return
        L_0x001a:
            android.support.v4.media.n[] r2 = new android.support.v4.media.n[r1]     // Catch:{ all -> 0x0047 }
            java.util.ArrayList r3 = r7.f4134d     // Catch:{ all -> 0x0047 }
            r3.toArray(r2)     // Catch:{ all -> 0x0047 }
            java.util.ArrayList r3 = r7.f4134d     // Catch:{ all -> 0x0047 }
            r3.clear()     // Catch:{ all -> 0x0047 }
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            r0 = 0
            r3 = 0
        L_0x0029:
            if (r3 >= r1) goto L_0x000d
            r4 = r2[r3]
            java.lang.Object r5 = r4.f338j
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r5 = r5.size()
            if (r5 > 0) goto L_0x003a
            int r3 = r3 + 1
            goto L_0x0029
        L_0x003a:
            java.lang.Object r7 = r4.f338j
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            java.lang.Object r7 = r7.get(r0)
            android.support.v4.media.h.y(r7)
            r7 = 0
            throw r7
        L_0x0047:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.w.a(android.os.Message):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: s1.d} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0055 A[LOOP:1: B:26:0x0055->B:29:0x0060, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007b A[LOOP:2: B:36:0x007b->B:39:0x0086, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0021 A[LOOP:0: B:7:0x0021->B:10:0x002c, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(android.os.Message r11) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.f432b
            s1.e r0 = (s1.e) r0
            java.util.ArrayDeque r1 = s1.e.f13992g
            r0.getClass()
            int r1 = r11.what
            r2 = 0
            if (r1 == 0) goto L_0x0064
            r3 = 1
            if (r1 == r3) goto L_0x0035
            r3 = 2
            if (r1 == r3) goto L_0x002f
            java.util.concurrent.atomic.AtomicReference r1 = r0.f13997d
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            int r11 = r11.what
            java.lang.String r11 = java.lang.String.valueOf(r11)
            r3.<init>(r11)
        L_0x0021:
            boolean r11 = r1.compareAndSet(r2, r3)
            if (r11 == 0) goto L_0x0028
            goto L_0x0089
        L_0x0028:
            java.lang.Object r11 = r1.get()
            if (r11 == 0) goto L_0x0021
            goto L_0x0089
        L_0x002f:
            j1.g r11 = r0.f13998e
            r11.b()
            goto L_0x0089
        L_0x0035:
            java.lang.Object r11 = r11.obj
            r1 = r11
            s1.d r1 = (s1.d) r1
            int r4 = r1.f13986a
            int r5 = r1.f13987b
            android.media.MediaCodec$CryptoInfo r6 = r1.f13989d
            long r7 = r1.f13990e
            int r9 = r1.f13991f
            java.lang.Object r11 = s1.e.f13993h     // Catch:{ RuntimeException -> 0x0051 }
            monitor-enter(r11)     // Catch:{ RuntimeException -> 0x0051 }
            android.media.MediaCodec r3 = r0.f13994a     // Catch:{ all -> 0x004e }
            r3.queueSecureInputBuffer(r4, r5, r6, r7, r9)     // Catch:{ all -> 0x004e }
            monitor-exit(r11)     // Catch:{ all -> 0x004e }
            goto L_0x0062
        L_0x004e:
            r3 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x004e }
            throw r3     // Catch:{ RuntimeException -> 0x0051 }
        L_0x0051:
            r11 = move-exception
            r3 = r11
            java.util.concurrent.atomic.AtomicReference r4 = r0.f13997d
        L_0x0055:
            boolean r11 = r4.compareAndSet(r2, r3)
            if (r11 == 0) goto L_0x005c
            goto L_0x0062
        L_0x005c:
            java.lang.Object r11 = r4.get()
            if (r11 == 0) goto L_0x0055
        L_0x0062:
            r2 = r1
            goto L_0x0089
        L_0x0064:
            java.lang.Object r11 = r11.obj
            s1.d r11 = (s1.d) r11
            int r4 = r11.f13986a
            int r5 = r11.f13987b
            int r6 = r11.f13988c
            long r7 = r11.f13990e
            int r9 = r11.f13991f
            android.media.MediaCodec r3 = r0.f13994a     // Catch:{ RuntimeException -> 0x0078 }
            r3.queueInputBuffer(r4, r5, r6, r7, r9)     // Catch:{ RuntimeException -> 0x0078 }
            goto L_0x0088
        L_0x0078:
            r1 = move-exception
            java.util.concurrent.atomic.AtomicReference r0 = r0.f13997d
        L_0x007b:
            boolean r3 = r0.compareAndSet(r2, r1)
            if (r3 == 0) goto L_0x0082
            goto L_0x0088
        L_0x0082:
            java.lang.Object r3 = r0.get()
            if (r3 == 0) goto L_0x007b
        L_0x0088:
            r2 = r11
        L_0x0089:
            if (r2 == 0) goto L_0x008e
            s1.e.c(r2)
        L_0x008e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.w.b(android.os.Message):void");
    }

    public final void handleMessage(Message message) {
        z zVar;
        Object obj;
        w wVar;
        switch (this.f431a) {
            case 0:
                if (message.what == 1) {
                    synchronized (((y) this.f432b).f434a) {
                        zVar = (z) ((y) this.f432b).f437d.get();
                        obj = this.f432b;
                        wVar = ((y) obj).f438e;
                    }
                    if (zVar != null && ((y) obj) == zVar.q() && wVar != null) {
                        zVar.m((c0) message.obj);
                        ((y) this.f432b).a(zVar, wVar);
                        zVar.m((c0) null);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                ((i0) this.f432b).getClass();
                return;
            case 2:
                int i10 = message.what;
                if (i10 == -3 || i10 == -2 || i10 == -1) {
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) ((WeakReference) this.f432b).get(), message.what);
                    return;
                } else if (i10 == 1) {
                    ((DialogInterface) message.obj).dismiss();
                    return;
                } else {
                    return;
                }
            case 3:
                a(message);
                return;
            case 4:
                b(message);
                return;
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                e2 e2Var = (e2) message.obj;
                g gVar = (g) this.f432b;
                if (gVar.g(e2Var)) {
                    try {
                        d2 d2Var = e2Var.f6998c;
                        a.f(d2Var);
                        d2Var.b();
                    } catch (RemoteException unused) {
                    }
                    gVar.k(e2Var);
                    return;
                }
                return;
            case 6:
                x2 x2Var = (x2) this.f432b;
                int i11 = x2.f7435t;
                x2Var.f7441k.removeMessages(1002);
                x2Var.G(1, (c0) message.obj, new o2(x2Var, 0));
                return;
            default:
                if (message.what == 1) {
                    z zVar2 = (z) this.f432b;
                    PreferenceScreen preferenceScreen = zVar2.f12184e0.f12133h;
                    if (preferenceScreen != null) {
                        zVar2.f12185f0.setAdapter(new d0(preferenceScreen));
                        preferenceScreen.j();
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(Looper looper, g gVar) {
        super(looper);
        this.f431a = 5;
        this.f432b = gVar;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(Object obj, Looper looper, int i10) {
        super(looper);
        this.f431a = i10;
        this.f432b = obj;
    }
}
