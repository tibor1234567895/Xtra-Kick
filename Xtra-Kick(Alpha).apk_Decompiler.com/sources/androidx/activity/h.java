package androidx.activity;

import a2.o;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.n;
import androidx.appcompat.widget.o2;
import androidx.lifecycle.k0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.g;
import b8.e;
import com.bumptech.glide.s;
import com.github.andreyasadchy.xtra.ui.view.SlidingLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import d5.b;
import d5.c;
import i.i;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import o3.d0;
import o3.f;
import o3.z;
import q0.a;
import q0.j;

public final class h implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f483h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f484i;

    public /* synthetic */ h(int i10, Object obj) {
        this.f483h = i10;
        this.f484i = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0084, code lost:
        if (((r3.y) r6.f484i).f13780f == null) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a1, code lost:
        if (((r3.y) r6.f484i).f13780f != null) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b7, code lost:
        if (((r3.y) r6.f484i).f13780f != null) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00be, code lost:
        if ((!r4.isEmpty()) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c0, code lost:
        r0 = (r3.y) r6.f484i;
        r1 = r0.f13786l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c6, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r0 = r0.f13786l.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00cd, code lost:
        r2 = (o.e) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d4, code lost:
        if (r2.hasNext() == false) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d6, code lost:
        ((r3.w) ((java.util.Map.Entry) r2.next()).getValue()).a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e6, code lost:
        r0 = la.v.f9814a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e8, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00ee, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f484i
            r3.y r0 = (r3.y) r0
            r3.n0 r0 = r0.f13775a
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r0.f13726i
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            java.lang.String r1 = "readWriteLock.readLock()"
            xa.j.e(r1, r0)
            r0.lock()
            r1 = 0
            r2 = 1
            java.lang.Object r3 = r6.f484i     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            r3.y r3 = (r3.y) r3     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            boolean r3 = r3.c()     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            if (r3 != 0) goto L_0x002d
            r0.unlock()
            java.lang.Object r0 = r6.f484i
            r3.y r0 = (r3.y) r0
            r3.b r0 = r0.f13780f
            if (r0 != 0) goto L_0x002c
            return
        L_0x002c:
            throw r1
        L_0x002d:
            java.lang.Object r3 = r6.f484i     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            r3.y r3 = (r3.y) r3     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            java.util.concurrent.atomic.AtomicBoolean r3 = r3.f13781g     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            r4 = 0
            boolean r3 = r3.compareAndSet(r2, r4)     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            if (r3 != 0) goto L_0x0047
            r0.unlock()
            java.lang.Object r0 = r6.f484i
            r3.y r0 = (r3.y) r0
            r3.b r0 = r0.f13780f
            if (r0 != 0) goto L_0x0046
            return
        L_0x0046:
            throw r1
        L_0x0047:
            java.lang.Object r3 = r6.f484i     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            r3.y r3 = (r3.y) r3     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            r3.n0 r3 = r3.f13775a     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            boolean r3 = r3.l()     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            if (r3 == 0) goto L_0x0060
            r0.unlock()
            java.lang.Object r0 = r6.f484i
            r3.y r0 = (r3.y) r0
            r3.b r0 = r0.f13780f
            if (r0 != 0) goto L_0x005f
            return
        L_0x005f:
            throw r1
        L_0x0060:
            java.lang.Object r3 = r6.f484i     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            r3.y r3 = (r3.y) r3     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            r3.n0 r3 = r3.f13775a     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            u3.l r3 = r3.i()     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            u3.f r3 = r3.x0()     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            r3.n0()     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            na.l r4 = r6.a()     // Catch:{ all -> 0x0087 }
            r3.h0()     // Catch:{ all -> 0x0087 }
            r3.g()     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            r0.unlock()
            java.lang.Object r0 = r6.f484i
            r3.y r0 = (r3.y) r0
            r3.b r0 = r0.f13780f
            if (r0 != 0) goto L_0x00ee
            goto L_0x00b9
        L_0x0087:
            r4 = move-exception
            r3.g()     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
            throw r4     // Catch:{ IllegalStateException -> 0x00a4, SQLiteException -> 0x008e }
        L_0x008c:
            r2 = move-exception
            goto L_0x00ef
        L_0x008e:
            r3 = move-exception
            java.lang.String r4 = "ROOM"
            java.lang.String r5 = "Cannot run invalidation tracker. Is the db closed?"
            android.util.Log.e(r4, r5, r3)     // Catch:{ all -> 0x008c }
            ma.d0 r4 = ma.d0.f10804h     // Catch:{ all -> 0x008c }
            r0.unlock()
            java.lang.Object r0 = r6.f484i
            r3.y r0 = (r3.y) r0
            r3.b r0 = r0.f13780f
            if (r0 != 0) goto L_0x00ee
            goto L_0x00b9
        L_0x00a4:
            r3 = move-exception
            java.lang.String r4 = "ROOM"
            java.lang.String r5 = "Cannot run invalidation tracker. Is the db closed?"
            android.util.Log.e(r4, r5, r3)     // Catch:{ all -> 0x008c }
            ma.d0 r4 = ma.d0.f10804h     // Catch:{ all -> 0x008c }
            r0.unlock()
            java.lang.Object r0 = r6.f484i
            r3.y r0 = (r3.y) r0
            r3.b r0 = r0.f13780f
            if (r0 != 0) goto L_0x00ee
        L_0x00b9:
            boolean r0 = r4.isEmpty()
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x00ed
            java.lang.Object r0 = r6.f484i
            r3.y r0 = (r3.y) r0
            o.g r1 = r0.f13786l
            monitor-enter(r1)
            o.g r0 = r0.f13786l     // Catch:{ all -> 0x00ea }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00ea }
        L_0x00cd:
            r2 = r0
            o.e r2 = (o.e) r2     // Catch:{ all -> 0x00ea }
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00ea }
            if (r3 == 0) goto L_0x00e6
            java.lang.Object r2 = r2.next()     // Catch:{ all -> 0x00ea }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00ea }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00ea }
            r3.w r2 = (r3.w) r2     // Catch:{ all -> 0x00ea }
            r2.a(r4)     // Catch:{ all -> 0x00ea }
            goto L_0x00cd
        L_0x00e6:
            la.v r0 = la.v.f9814a     // Catch:{ all -> 0x00ea }
            monitor-exit(r1)
            goto L_0x00ed
        L_0x00ea:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x00ed:
            return
        L_0x00ee:
            throw r1
        L_0x00ef:
            r0.unlock()
            java.lang.Object r0 = r6.f484i
            r3.y r0 = (r3.y) r0
            r3.b r0 = r0.f13780f
            if (r0 == 0) goto L_0x00fb
            throw r1
        L_0x00fb:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.h.b():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r0 = r0.f15459t;
        r0.getClass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        if (r0.f17265a != false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        r0.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        r0 = ma.b0.f10801h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00fc, code lost:
        if (r11 != false) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x011a, code lost:
        if (((android.net.ConnectivityManager) r11).isActiveNetworkMetered() == false) goto L_0x012d;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003d */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x016b A[EDGE_INSN: B:102:0x016b->B:84:0x016b ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0167 A[LOOP:0: B:27:0x006e->B:83:0x0167, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void c() {
        /*
            r15 = this;
            java.lang.Object r0 = r15.f484i
            u9.f r0 = (u9.f) r0
            boolean r0 = u9.f.c(r0)
            if (r0 == 0) goto L_0x01bc
            java.lang.Object r0 = r15.f484i
            u9.f r0 = (u9.f) r0
            s9.b r0 = r0.f15457r
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x01ab
            java.lang.Object r0 = r15.f484i
            u9.f r0 = (u9.f) r0
            boolean r0 = u9.f.c(r0)
            if (r0 == 0) goto L_0x01ab
            java.lang.Object r0 = r15.f484i
            u9.f r0 = (u9.f) r0
            java.lang.Object r1 = r0.f15447h
            monitor-enter(r1)
            u9.a r2 = r0.f15456q     // Catch:{ Exception -> 0x003d }
            p9.s r3 = r0.f15464y     // Catch:{ Exception -> 0x003d }
            r2.getClass()     // Catch:{ Exception -> 0x003d }
            java.lang.String r4 = "prioritySort"
            xa.j.g(r4, r3)     // Catch:{ Exception -> 0x003d }
            q9.h r2 = r2.f15440a     // Catch:{ Exception -> 0x003d }
            java.util.List r0 = r2.z0(r3)     // Catch:{ Exception -> 0x003d }
            goto L_0x004b
        L_0x003a:
            r0 = move-exception
            goto L_0x01a9
        L_0x003d:
            y9.l r0 = r0.f15459t     // Catch:{ all -> 0x003a }
            r0.getClass()     // Catch:{ all -> 0x003a }
            boolean r2 = r0.f17265a     // Catch:{ all -> 0x003a }
            if (r2 == 0) goto L_0x0049
            r0.c()     // Catch:{ all -> 0x003a }
        L_0x0049:
            ma.b0 r0 = ma.b0.f10801h     // Catch:{ all -> 0x003a }
        L_0x004b:
            monitor-exit(r1)
            boolean r1 = r0.isEmpty()
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0063
            java.lang.Object r1 = r15.f484i
            u9.f r1 = (u9.f) r1
            w9.a r1 = r1.f15458s
            boolean r1 = r1.b()
            if (r1 != 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r1 = 0
            goto L_0x0064
        L_0x0063:
            r1 = 1
        L_0x0064:
            if (r1 != 0) goto L_0x016d
            int r1 = ma.r.d(r0)
            if (r1 < 0) goto L_0x016e
            r4 = 0
            r5 = 1
        L_0x006e:
            java.lang.Object r6 = r15.f484i
            u9.f r6 = (u9.f) r6
            s9.b r6 = r6.f15457r
            boolean r6 = r6.e()
            if (r6 == 0) goto L_0x016b
            java.lang.Object r6 = r15.f484i
            u9.f r6 = (u9.f) r6
            boolean r6 = u9.f.c(r6)
            if (r6 == 0) goto L_0x016b
            java.lang.Object r6 = r0.get(r4)
            p9.b r6 = (p9.b) r6
            r7 = r6
            q9.e r7 = (q9.e) r7
            java.lang.String r8 = r7.f13435j
            boolean r8 = hb.h0.U0(r8)
            if (r8 != 0) goto L_0x00a1
            java.lang.Object r9 = r15.f484i
            u9.f r9 = (u9.f) r9
            w9.a r9 = r9.f15458s
            boolean r9 = r9.b()
            if (r9 == 0) goto L_0x016b
        L_0x00a1:
            java.lang.Object r9 = r15.f484i
            u9.f r9 = (u9.f) r9
            boolean r9 = u9.f.c(r9)
            if (r9 == 0) goto L_0x016b
            java.lang.Object r9 = r15.f484i
            u9.f r9 = (u9.f) r9
            p9.p r9 = r9.f15448i
            p9.p r10 = p9.p.GLOBAL_OFF
            if (r9 == r10) goto L_0x00bc
            java.lang.Object r9 = r15.f484i
            u9.f r9 = (u9.f) r9
            p9.p r9 = r9.f15448i
            goto L_0x00c2
        L_0x00bc:
            p9.p r9 = r7.f13444s
            if (r9 != r10) goto L_0x00c2
            p9.p r9 = p9.p.ALL
        L_0x00c2:
            java.lang.Object r10 = r15.f484i
            u9.f r10 = (u9.f) r10
            w9.a r10 = r10.f15458s
            r10.getClass()
            java.lang.String r11 = "networkType"
            xa.j.g(r11, r9)
            p9.p r11 = p9.p.WIFI_ONLY
            java.lang.String r12 = "null cannot be cast to non-null type android.net.ConnectivityManager"
            java.lang.String r13 = "connectivity"
            android.content.Context r10 = r10.f16177g
            if (r9 != r11) goto L_0x0105
            java.lang.String r11 = "$this$isOnWiFi"
            xa.j.g(r11, r10)
            java.lang.Object r11 = r10.getSystemService(r13)
            if (r11 == 0) goto L_0x00ff
            android.net.ConnectivityManager r11 = (android.net.ConnectivityManager) r11
            android.net.NetworkInfo r11 = r11.getActiveNetworkInfo()
            if (r11 == 0) goto L_0x00fb
            boolean r14 = r11.isConnected()
            if (r14 == 0) goto L_0x00fb
            int r11 = r11.getType()
            if (r11 != r3) goto L_0x00fb
            r11 = 1
            goto L_0x00fc
        L_0x00fb:
            r11 = 0
        L_0x00fc:
            if (r11 == 0) goto L_0x0105
            goto L_0x012d
        L_0x00ff:
            la.q r0 = new la.q
            r0.<init>(r12)
            throw r0
        L_0x0105:
            p9.p r11 = p9.p.UNMETERED
            if (r9 != r11) goto L_0x0123
            java.lang.String r11 = "$this$isOnMeteredConnection"
            xa.j.g(r11, r10)
            java.lang.Object r11 = r10.getSystemService(r13)
            if (r11 == 0) goto L_0x011d
            android.net.ConnectivityManager r11 = (android.net.ConnectivityManager) r11
            boolean r11 = r11.isActiveNetworkMetered()
            if (r11 != 0) goto L_0x0123
            goto L_0x012d
        L_0x011d:
            la.q r0 = new la.q
            r0.<init>(r12)
            throw r0
        L_0x0123:
            p9.p r11 = p9.p.ALL
            if (r9 != r11) goto L_0x012f
            boolean r9 = hb.h0.Y0(r10)
            if (r9 == 0) goto L_0x012f
        L_0x012d:
            r9 = 1
            goto L_0x0130
        L_0x012f:
            r9 = 0
        L_0x0130:
            if (r9 != 0) goto L_0x013f
            java.lang.Object r10 = r15.f484i
            u9.f r10 = (u9.f) r10
            z5.i r10 = r10.f15460u
            java.lang.Object r10 = r10.f17667e
            p9.l r10 = (p9.l) r10
            r10.h(r6)
        L_0x013f:
            if (r8 != 0) goto L_0x0143
            if (r9 == 0) goto L_0x0165
        L_0x0143:
            java.lang.Object r5 = r15.f484i
            u9.f r5 = (u9.f) r5
            s9.b r5 = r5.f15457r
            int r7 = r7.f13433h
            boolean r5 = r5.z(r7)
            if (r5 != 0) goto L_0x0164
            java.lang.Object r5 = r15.f484i
            u9.f r5 = (u9.f) r5
            boolean r5 = u9.f.c(r5)
            if (r5 == 0) goto L_0x0164
            java.lang.Object r5 = r15.f484i
            u9.f r5 = (u9.f) r5
            s9.b r5 = r5.f15457r
            r5.Y(r6)
        L_0x0164:
            r5 = 0
        L_0x0165:
            if (r4 == r1) goto L_0x016b
            int r4 = r4 + 1
            goto L_0x006e
        L_0x016b:
            r3 = r5
            goto L_0x016e
        L_0x016d:
            r3 = r1
        L_0x016e:
            if (r3 == 0) goto L_0x01ab
            java.lang.Object r0 = r15.f484i
            u9.f r0 = (u9.f) r0
            long r1 = r0.f15451l
            r3 = 500(0x1f4, double:2.47E-321)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0180
            r1 = 60000(0xea60, double:2.9644E-319)
            goto L_0x0186
        L_0x0180:
            long r1 = r0.f15451l
            r3 = 2
            long r1 = r1 * r3
        L_0x0186:
            r0.f15451l = r1
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r2 = r0.f15451l
            long r1 = r1.toMinutes(r2)
            y9.l r0 = r0.f15459t
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "PriorityIterator backoffTime increased to "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = " minute(s)"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.a(r1)
            goto L_0x01ab
        L_0x01a9:
            monitor-exit(r1)
            throw r0
        L_0x01ab:
            java.lang.Object r0 = r15.f484i
            u9.f r0 = (u9.f) r0
            boolean r0 = u9.f.c(r0)
            if (r0 == 0) goto L_0x01bc
            java.lang.Object r0 = r15.f484i
            u9.f r0 = (u9.f) r0
            r0.e()
        L_0x01bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.h.c():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0069, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        hb.h0.A(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006d, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final na.l a() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f484i
            r3.y r0 = (r3.y) r0
            na.l r1 = new na.l
            r1.<init>()
            r3.n0 r0 = r0.f13775a
            u3.b r2 = new u3.b
            java.lang.String r3 = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;"
            r2.<init>(r3)
            int r3 = r3.n0.f13717n
            r3 = 0
            android.database.Cursor r0 = r0.q(r2, r3)
        L_0x0019:
            boolean r2 = r0.moveToNext()     // Catch:{ all -> 0x0067 }
            if (r2 == 0) goto L_0x002c
            r2 = 0
            int r2 = r0.getInt(r2)     // Catch:{ all -> 0x0067 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0067 }
            r1.add(r2)     // Catch:{ all -> 0x0067 }
            goto L_0x0019
        L_0x002c:
            la.v r2 = la.v.f9814a     // Catch:{ all -> 0x0067 }
            hb.h0.A(r0, r3)
            ma.n0.a(r1)
            boolean r0 = r1.isEmpty()
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x0066
            java.lang.Object r0 = r4.f484i
            r3.y r0 = (r3.y) r0
            u3.o r0 = r0.f13783i
            java.lang.String r2 = "Required value was null."
            if (r0 == 0) goto L_0x005c
            java.lang.Object r0 = r4.f484i
            r3.y r0 = (r3.y) r0
            u3.o r0 = r0.f13783i
            if (r0 == 0) goto L_0x0052
            r0.x()
            goto L_0x0066
        L_0x0052:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x005c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0066:
            return r1
        L_0x0067:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r2 = move-exception
            hb.h0.A(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.h.a():na.l");
    }

    public final void run() {
        n nVar;
        Object obj;
        boolean z10 = true;
        switch (this.f483h) {
            case 0:
                try {
                    h.super.onBackPressed();
                    return;
                } catch (IllegalStateException e10) {
                    if (!TextUtils.equals(e10.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw e10;
                    }
                    return;
                }
            case 1:
                i iVar = (i) this.f484i;
                iVar.a(true);
                iVar.invalidateSelf();
                return;
            case 2:
                o2 o2Var = (o2) this.f484i;
                o2Var.f984s = null;
                o2Var.drawableStateChanged();
                return;
            case 3:
                ActionMenuView actionMenuView = ((Toolbar) this.f484i).f691h;
                if (actionMenuView != null && (nVar = actionMenuView.A) != null) {
                    nVar.n();
                    return;
                }
                return;
            case 4:
                q0.i iVar2 = (q0.i) this.f484i;
                if (iVar2.f13116v) {
                    if (iVar2.f13114t) {
                        iVar2.f13114t = false;
                        a aVar = iVar2.f13102h;
                        aVar.getClass();
                        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        aVar.f13094e = currentAnimationTimeMillis;
                        aVar.f13096g = -1;
                        aVar.f13095f = currentAnimationTimeMillis;
                        aVar.f13097h = 0.5f;
                    }
                    a aVar2 = iVar2.f13102h;
                    if (aVar2.f13096g <= 0 || AnimationUtils.currentAnimationTimeMillis() <= aVar2.f13096g + ((long) aVar2.f13098i)) {
                        z10 = false;
                    }
                    if (z10 || !iVar2.f()) {
                        iVar2.f13116v = false;
                        return;
                    }
                    if (iVar2.f13115u) {
                        iVar2.f13115u = false;
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        iVar2.f13104j.onTouchEvent(obtain);
                        obtain.recycle();
                    }
                    if (aVar2.f13095f != 0) {
                        long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                        float a10 = aVar2.a(currentAnimationTimeMillis2);
                        aVar2.f13095f = currentAnimationTimeMillis2;
                        ListView listView = iVar2.f13118x;
                        j.b(listView, (int) (((float) (currentAnimationTimeMillis2 - aVar2.f13095f)) * ((a10 * 4.0f) + (-4.0f * a10 * a10)) * aVar2.f13093d));
                        View view = iVar2.f13104j;
                        WeakHashMap weakHashMap = c1.f10054a;
                        i0.m(view, this);
                        return;
                    }
                    throw new RuntimeException("Cannot compute scroll delta before calling start()");
                }
                return;
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                ((u0.h) this.f484i).q(0);
                return;
            case 6:
                synchronized (((k0) this.f484i).f1719a) {
                    obj = ((k0) this.f484i).f1724f;
                    ((k0) this.f484i).f1724f = k0.f1718k;
                }
                ((k0) this.f484i).l(obj);
                return;
            case 7:
                ((o) this.f484i).b();
                return;
            case 8:
                ((f) this.f484i).w0();
                return;
            case 9:
                RecyclerView recyclerView = ((z) this.f484i).f12185f0;
                recyclerView.focusableViewAvailable(recyclerView);
                return;
            case 11:
                ((d0) this.f484i).e();
                return;
            case 12:
                b();
                return;
            case 13:
                g gVar = (g) this.f484i;
                gVar.f2310g = false;
                gVar.d();
                return;
            case 14:
                s sVar = (s) this.f484i;
                sVar.f3310j.c(sVar);
                return;
            case 15:
                c cVar = (c) this.f484i;
                cVar.getClass();
                while (true) {
                    try {
                        cVar.b((b) cVar.f4361c.remove());
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            case Constants.IV_SIZE /*16*/:
                SlidingLayout.c((SlidingLayout) this.f484i);
                return;
            case 17:
                e eVar = (e) this.f484i;
                eVar.f2670c = false;
                u0.h hVar = ((BottomSheetBehavior) eVar.f2672e).M;
                if (hVar == null || !hVar.g()) {
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) eVar.f2672e;
                    if (bottomSheetBehavior.L == 2) {
                        bottomSheetBehavior.F(eVar.f2669b);
                        return;
                    }
                    return;
                }
                eVar.a(eVar.f2669b);
                return;
            case 18:
                View view2 = (View) this.f484i;
                ((InputMethodManager) view2.getContext().getSystemService("input_method")).showSoftInput(view2, 1);
                return;
            case 19:
                c();
                return;
            default:
                xa.j.b("invoke(...)", ((wa.a) this.f484i).b());
                return;
        }
    }
}
