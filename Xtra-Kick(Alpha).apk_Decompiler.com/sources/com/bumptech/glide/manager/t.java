package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.f0;
import b4.e0;
import com.bumptech.glide.c;
import com.bumptech.glide.f;
import com.bumptech.glide.s;
import java.util.HashMap;
import java.util.Map;
import k5.c0;
import q.e;
import w5.p;

public final class t implements Handler.Callback {

    /* renamed from: o  reason: collision with root package name */
    public static final r f3276o = new r();

    /* renamed from: h  reason: collision with root package name */
    public volatile s f3277h;

    /* renamed from: i  reason: collision with root package name */
    public final HashMap f3278i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    public final HashMap f3279j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    public final Handler f3280k;

    /* renamed from: l  reason: collision with root package name */
    public final s f3281l;

    /* renamed from: m  reason: collision with root package name */
    public final k f3282m;

    /* renamed from: n  reason: collision with root package name */
    public final o f3283n;

    public t(s sVar, e0 e0Var) {
        k kVar;
        new e();
        new e();
        new Bundle();
        sVar = sVar == null ? f3276o : sVar;
        this.f3281l = sVar;
        this.f3280k = new Handler(Looper.getMainLooper(), this);
        this.f3283n = new o(sVar);
        if (!c0.f9132h || !c0.f9131g) {
            kVar = new g();
        } else if (((Map) e0Var.f2538i).containsKey(f.class)) {
            kVar = new i();
        } else {
            kVar = new j();
        }
        this.f3282m = kVar;
    }

    public static Activity a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public final s b(Context context) {
        boolean z10;
        boolean z11;
        if (context != null) {
            char[] cArr = p.f16126a;
            boolean z12 = false;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 && !(context instanceof Application)) {
                if (context instanceof f0) {
                    return c((f0) context);
                }
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11) {
                        return b(activity.getApplicationContext());
                    }
                    if (activity instanceof f0) {
                        return c((f0) activity);
                    }
                    if (!activity.isDestroyed()) {
                        this.f3282m.a();
                        FragmentManager fragmentManager = activity.getFragmentManager();
                        Activity a10 = a(activity);
                        if (a10 == null || !a10.isFinishing()) {
                            z12 = true;
                        }
                        q d10 = d(fragmentManager);
                        s sVar = d10.f3273k;
                        if (sVar != null) {
                            return sVar;
                        }
                        s a11 = this.f3281l.a(c.a(activity), d10.f3270h, d10.f3271i, activity);
                        if (z12) {
                            a11.j();
                        }
                        d10.f3273k = a11;
                        return a11;
                    }
                    throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
                } else if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return b(contextWrapper.getBaseContext());
                    }
                }
            }
            if (this.f3277h == null) {
                synchronized (this) {
                    if (this.f3277h == null) {
                        this.f3277h = this.f3281l.a(c.a(context.getApplicationContext()), new b(), new h(), context.getApplicationContext());
                    }
                }
            }
            return this.f3277h;
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public final s c(f0 f0Var) {
        boolean z10;
        boolean z11;
        char[] cArr = p.f16126a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return b(f0Var.getApplicationContext());
        }
        if (!f0Var.isDestroyed()) {
            this.f3282m.a();
            Activity a10 = a(f0Var);
            if (a10 == null || !a10.isFinishing()) {
                z11 = true;
            } else {
                z11 = false;
            }
            return this.f3283n.a(f0Var, c.a(f0Var.getApplicationContext()), f0Var.f450k, f0Var.A(), z11);
        }
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    public final q d(FragmentManager fragmentManager) {
        HashMap hashMap = this.f3278i;
        q qVar = (q) hashMap.get(fragmentManager);
        if (qVar != null) {
            return qVar;
        }
        q qVar2 = (q) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (qVar2 == null) {
            qVar2 = new q();
            qVar2.f3275m = null;
            hashMap.put(fragmentManager, qVar2);
            fragmentManager.beginTransaction().add(qVar2, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f3280k.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return qVar2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r14v6, types: [java.lang.Object, android.app.FragmentManager] */
    /* JADX WARNING: type inference failed for: r14v9, types: [androidx.fragment.app.c1, java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0087, code lost:
        if (r0 == false) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0102, code lost:
        if (r0 == false) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x010b, code lost:
        r14 = null;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r14) {
        /*
            r13 = this;
            int r0 = r14.arg1
            r1 = 1
            r2 = 0
            if (r0 != r1) goto L_0x0008
            r0 = 1
            goto L_0x0009
        L_0x0008:
            r0 = 0
        L_0x0009:
            int r3 = r14.what
            android.os.Handler r4 = r13.f3280k
            r5 = 3
            java.lang.String r6 = "com.bumptech.glide.manager"
            r7 = 5
            java.lang.String r8 = "RMRetriever"
            r9 = 0
            if (r3 == r1) goto L_0x008b
            r10 = 2
            if (r3 == r10) goto L_0x001d
            r14 = r9
            r1 = 0
            goto L_0x010c
        L_0x001d:
            java.lang.Object r14 = r14.obj
            androidx.fragment.app.c1 r14 = (androidx.fragment.app.c1) r14
            java.util.HashMap r3 = r13.f3279j
            java.lang.Object r11 = r3.get(r14)
            com.bumptech.glide.manager.c0 r11 = (com.bumptech.glide.manager.c0) r11
            androidx.fragment.app.c0 r12 = r14.E(r6)
            com.bumptech.glide.manager.c0 r12 = (com.bumptech.glide.manager.c0) r12
            if (r12 != r11) goto L_0x0032
            goto L_0x0086
        L_0x0032:
            if (r0 != 0) goto L_0x0065
            boolean r0 = r14.I
            if (r0 == 0) goto L_0x0039
            goto L_0x0065
        L_0x0039:
            androidx.fragment.app.a r0 = new androidx.fragment.app.a
            r0.<init>((androidx.fragment.app.c1) r14)
            r0.d(r2, r11, r6, r1)
            if (r12 == 0) goto L_0x0046
            r0.k(r12)
        L_0x0046:
            boolean r6 = r0.f1539g
            if (r6 != 0) goto L_0x005d
            r0.f1540h = r2
            androidx.fragment.app.c1 r6 = r0.f1319q
            r6.z(r0, r1)
            android.os.Message r0 = r4.obtainMessage(r10, r1, r2, r14)
            r0.sendToTarget()
            android.util.Log.isLoggable(r8, r5)
            r0 = 0
            goto L_0x0087
        L_0x005d:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "This transaction is already being added to the back stack"
            r14.<init>(r0)
            throw r14
        L_0x0065:
            boolean r0 = r14.I
            if (r0 == 0) goto L_0x0075
            boolean r0 = android.util.Log.isLoggable(r8, r7)
            if (r0 == 0) goto L_0x0081
            java.lang.String r0 = "Parent was destroyed before our Fragment could be added, all requests for the destroyed parent are cancelled"
            android.util.Log.w(r8, r0)
            goto L_0x0081
        L_0x0075:
            r0 = 6
            boolean r0 = android.util.Log.isLoggable(r8, r0)
            if (r0 == 0) goto L_0x0081
            java.lang.String r0 = "ERROR: Tried adding Fragment twice and failed twice, giving up and cancelling all associated requests! This probably means you're starting loads in a unit test with an Activity that you haven't created and never create. If you're using Robolectric, create the Activity as part of your test setup"
            android.util.Log.e(r8, r0)
        L_0x0081:
            com.bumptech.glide.manager.a r0 = r11.f3259d0
            r0.a()
        L_0x0086:
            r0 = 1
        L_0x0087:
            if (r0 == 0) goto L_0x010b
            goto L_0x0104
        L_0x008b:
            java.lang.Object r14 = r14.obj
            android.app.FragmentManager r14 = (android.app.FragmentManager) r14
            java.util.HashMap r3 = r13.f3278i
            java.lang.Object r10 = r3.get(r14)
            com.bumptech.glide.manager.q r10 = (com.bumptech.glide.manager.q) r10
            android.app.Fragment r11 = r14.findFragmentByTag(r6)
            com.bumptech.glide.manager.q r11 = (com.bumptech.glide.manager.q) r11
            if (r11 != r10) goto L_0x00a0
            goto L_0x0101
        L_0x00a0:
            if (r11 == 0) goto L_0x00c3
            com.bumptech.glide.s r12 = r11.f3273k
            if (r12 != 0) goto L_0x00a7
            goto L_0x00c3
        L_0x00a7:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "We've added two fragments with requests! Old: "
            r0.<init>(r1)
            r0.append(r11)
            java.lang.String r1 = " New: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        L_0x00c3:
            if (r0 != 0) goto L_0x00e8
            boolean r0 = r14.isDestroyed()
            if (r0 == 0) goto L_0x00cc
            goto L_0x00e8
        L_0x00cc:
            android.app.FragmentTransaction r0 = r14.beginTransaction()
            android.app.FragmentTransaction r0 = r0.add(r10, r6)
            if (r11 == 0) goto L_0x00d9
            r0.remove(r11)
        L_0x00d9:
            r0.commitAllowingStateLoss()
            android.os.Message r0 = r4.obtainMessage(r1, r1, r2, r14)
            r0.sendToTarget()
            android.util.Log.isLoggable(r8, r5)
            r0 = 0
            goto L_0x0102
        L_0x00e8:
            boolean r0 = android.util.Log.isLoggable(r8, r7)
            if (r0 == 0) goto L_0x00fc
            boolean r0 = r14.isDestroyed()
            if (r0 == 0) goto L_0x00f7
            java.lang.String r0 = "Parent was destroyed before our Fragment could be added"
            goto L_0x00f9
        L_0x00f7:
            java.lang.String r0 = "Tried adding Fragment twice and failed twice, giving up!"
        L_0x00f9:
            android.util.Log.w(r8, r0)
        L_0x00fc:
            com.bumptech.glide.manager.a r0 = r10.f3270h
            r0.a()
        L_0x0101:
            r0 = 1
        L_0x0102:
            if (r0 == 0) goto L_0x010b
        L_0x0104:
            java.lang.Object r0 = r3.remove(r14)
            r9 = r0
            r2 = 1
            goto L_0x010c
        L_0x010b:
            r14 = r9
        L_0x010c:
            boolean r0 = android.util.Log.isLoggable(r8, r7)
            if (r0 == 0) goto L_0x0127
            if (r2 == 0) goto L_0x0127
            if (r9 != 0) goto L_0x0127
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to remove expected request manager fragment, manager: "
            r0.<init>(r2)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            android.util.Log.w(r8, r14)
        L_0x0127:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.manager.t.handleMessage(android.os.Message):boolean");
    }
}
