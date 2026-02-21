package androidx.recyclerview.widget;

import i0.m;
import i0.n;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class k0 implements Runnable {

    /* renamed from: l  reason: collision with root package name */
    public static final ThreadLocal f2066l = new ThreadLocal();

    /* renamed from: m  reason: collision with root package name */
    public static final h0 f2067m = new h0();

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f2068h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public long f2069i;

    /* renamed from: j  reason: collision with root package name */
    public long f2070j;

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f2071k = new ArrayList();

    public static k2 c(RecyclerView recyclerView, int i10, long j10) {
        boolean z10;
        int h10 = recyclerView.mChildHelper.h();
        int i11 = 0;
        while (true) {
            if (i11 >= h10) {
                z10 = false;
                break;
            }
            k2 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.g(i11));
            if (childViewHolderInt.mPosition == i10 && !childViewHolderInt.isInvalid()) {
                z10 = true;
                break;
            }
            i11++;
        }
        if (z10) {
            return null;
        }
        y1 y1Var = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            k2 m10 = y1Var.m(i10, j10);
            if (m10 != null) {
                if (!m10.isBound() || m10.isInvalid()) {
                    y1Var.a(m10, false);
                } else {
                    y1Var.j(m10.itemView);
                }
            }
            return m10;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public final void a(RecyclerView recyclerView, int i10, int i11) {
        if (recyclerView.isAttachedToWindow() && this.f2069i == 0) {
            this.f2069i = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        i0 i0Var = recyclerView.mPrefetchRegistry;
        i0Var.f2045a = i10;
        i0Var.f2046b = i11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0093, code lost:
        r2 = (androidx.recyclerview.widget.j0) r4.get(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(long r17) {
        /*
            r16 = this;
            r1 = r16
            java.util.ArrayList r0 = r1.f2068h
            int r2 = r0.size()
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x000b:
            if (r4 >= r2) goto L_0x0026
            java.lang.Object r6 = r0.get(r4)
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            int r7 = r6.getWindowVisibility()
            if (r7 != 0) goto L_0x0023
            androidx.recyclerview.widget.i0 r7 = r6.mPrefetchRegistry
            r7.b(r6, r3)
            androidx.recyclerview.widget.i0 r6 = r6.mPrefetchRegistry
            int r6 = r6.f2048d
            int r5 = r5 + r6
        L_0x0023:
            int r4 = r4 + 1
            goto L_0x000b
        L_0x0026:
            java.util.ArrayList r4 = r1.f2071k
            r4.ensureCapacity(r5)
            r5 = 0
            r6 = 0
        L_0x002d:
            r7 = 1
            if (r5 >= r2) goto L_0x0087
            java.lang.Object r8 = r0.get(r5)
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            int r9 = r8.getWindowVisibility()
            if (r9 == 0) goto L_0x003d
            goto L_0x0084
        L_0x003d:
            androidx.recyclerview.widget.i0 r9 = r8.mPrefetchRegistry
            int r10 = r9.f2045a
            int r10 = java.lang.Math.abs(r10)
            int r11 = r9.f2046b
            int r11 = java.lang.Math.abs(r11)
            int r11 = r11 + r10
            r10 = 0
        L_0x004d:
            int r12 = r9.f2048d
            int r12 = r12 * 2
            if (r10 >= r12) goto L_0x0084
            int r12 = r4.size()
            if (r6 < r12) goto L_0x0062
            androidx.recyclerview.widget.j0 r12 = new androidx.recyclerview.widget.j0
            r12.<init>()
            r4.add(r12)
            goto L_0x0068
        L_0x0062:
            java.lang.Object r12 = r4.get(r6)
            androidx.recyclerview.widget.j0 r12 = (androidx.recyclerview.widget.j0) r12
        L_0x0068:
            int[] r13 = r9.f2047c
            int r14 = r10 + 1
            r14 = r13[r14]
            if (r14 > r11) goto L_0x0072
            r15 = 1
            goto L_0x0073
        L_0x0072:
            r15 = 0
        L_0x0073:
            r12.f2051a = r15
            r12.f2052b = r11
            r12.f2053c = r14
            r12.f2054d = r8
            r13 = r13[r10]
            r12.f2055e = r13
            int r6 = r6 + 1
            int r10 = r10 + 2
            goto L_0x004d
        L_0x0084:
            int r5 = r5 + 1
            goto L_0x002d
        L_0x0087:
            androidx.recyclerview.widget.h0 r0 = f2067m
            java.util.Collections.sort(r4, r0)
            r0 = 0
        L_0x008d:
            int r2 = r4.size()
            if (r0 >= r2) goto L_0x0130
            java.lang.Object r2 = r4.get(r0)
            androidx.recyclerview.widget.j0 r2 = (androidx.recyclerview.widget.j0) r2
            androidx.recyclerview.widget.RecyclerView r5 = r2.f2054d
            if (r5 != 0) goto L_0x009f
            goto L_0x0130
        L_0x009f:
            boolean r6 = r2.f2051a
            if (r6 == 0) goto L_0x00a9
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L_0x00ab
        L_0x00a9:
            r8 = r17
        L_0x00ab:
            int r6 = r2.f2055e
            androidx.recyclerview.widget.k2 r5 = c(r5, r6, r8)
            if (r5 == 0) goto L_0x011f
            java.lang.ref.WeakReference<androidx.recyclerview.widget.RecyclerView> r6 = r5.mNestedRecyclerView
            if (r6 == 0) goto L_0x011f
            boolean r6 = r5.isBound()
            if (r6 == 0) goto L_0x011f
            boolean r6 = r5.isInvalid()
            if (r6 != 0) goto L_0x011f
            java.lang.ref.WeakReference<androidx.recyclerview.widget.RecyclerView> r5 = r5.mNestedRecyclerView
            java.lang.Object r5 = r5.get()
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            if (r5 != 0) goto L_0x00ce
            goto L_0x011f
        L_0x00ce:
            boolean r6 = r5.mDataSetHasChangedAfterLayout
            if (r6 == 0) goto L_0x00dd
            androidx.recyclerview.widget.k r6 = r5.mChildHelper
            int r6 = r6.h()
            if (r6 == 0) goto L_0x00dd
            r5.removeAndRecycleViews()
        L_0x00dd:
            androidx.recyclerview.widget.i0 r6 = r5.mPrefetchRegistry
            r6.b(r5, r7)
            int r8 = r6.f2048d
            if (r8 == 0) goto L_0x011f
            java.lang.String r8 = "RV Nested Prefetch"
            int r9 = i0.n.f7952a     // Catch:{ all -> 0x0118 }
            i0.m.a(r8)     // Catch:{ all -> 0x0118 }
            androidx.recyclerview.widget.g2 r8 = r5.mState     // Catch:{ all -> 0x0118 }
            androidx.recyclerview.widget.g1 r9 = r5.mAdapter     // Catch:{ all -> 0x0118 }
            r8.f2021d = r7     // Catch:{ all -> 0x0118 }
            int r9 = r9.getItemCount()     // Catch:{ all -> 0x0118 }
            r8.f2022e = r9     // Catch:{ all -> 0x0118 }
            r8.f2024g = r3     // Catch:{ all -> 0x0118 }
            r8.f2025h = r3     // Catch:{ all -> 0x0118 }
            r8.f2026i = r3     // Catch:{ all -> 0x0118 }
            r8 = 0
        L_0x0100:
            int r9 = r6.f2048d     // Catch:{ all -> 0x0118 }
            int r9 = r9 * 2
            if (r8 >= r9) goto L_0x0112
            int[] r9 = r6.f2047c     // Catch:{ all -> 0x0118 }
            r9 = r9[r8]     // Catch:{ all -> 0x0118 }
            r10 = r17
            c(r5, r9, r10)     // Catch:{ all -> 0x0118 }
            int r8 = r8 + 2
            goto L_0x0100
        L_0x0112:
            r10 = r17
            i0.m.b()
            goto L_0x0121
        L_0x0118:
            r0 = move-exception
            int r2 = i0.n.f7952a
            i0.m.b()
            throw r0
        L_0x011f:
            r10 = r17
        L_0x0121:
            r2.f2051a = r3
            r2.f2052b = r3
            r2.f2053c = r3
            r5 = 0
            r2.f2054d = r5
            r2.f2055e = r3
            int r0 = r0 + 1
            goto L_0x008d
        L_0x0130:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.k0.b(long):void");
    }

    public final void run() {
        try {
            int i10 = n.f7952a;
            m.a("RV Prefetch");
            ArrayList arrayList = this.f2068h;
            if (arrayList.isEmpty()) {
                this.f2069i = 0;
                m.b();
                return;
            }
            int size = arrayList.size();
            long j10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                RecyclerView recyclerView = (RecyclerView) arrayList.get(i11);
                if (recyclerView.getWindowVisibility() == 0) {
                    j10 = Math.max(recyclerView.getDrawingTime(), j10);
                }
            }
            if (j10 == 0) {
                this.f2069i = 0;
                m.b();
                return;
            }
            b(TimeUnit.MILLISECONDS.toNanos(j10) + this.f2070j);
            this.f2069i = 0;
            m.b();
        } catch (Throwable th) {
            this.f2069i = 0;
            int i12 = n.f7952a;
            m.b();
            throw th;
        }
    }
}
