package com.bumptech.glide.manager;

import android.content.IntentFilter;
import android.util.Log;
import w5.p;

public final class z implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f3291h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ a0 f3292i;

    public /* synthetic */ z(a0 a0Var, int i10) {
        this.f3291h = i10;
        this.f3292i = a0Var;
    }

    public final void run() {
        switch (this.f3291h) {
            case 0:
                a0 a0Var = this.f3292i;
                a0Var.f3252k = a0Var.c();
                try {
                    a0 a0Var2 = this.f3292i;
                    a0Var2.f3249h.registerReceiver(a0Var2.f3254m, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    this.f3292i.f3253l = true;
                    return;
                } catch (SecurityException e10) {
                    if (Log.isLoggable("ConnectivityMonitor", 5)) {
                        Log.w("ConnectivityMonitor", "Failed to register", e10);
                    }
                    this.f3292i.f3253l = false;
                    return;
                }
            case 1:
                if (this.f3292i.f3253l) {
                    this.f3292i.f3253l = false;
                    a0 a0Var3 = this.f3292i;
                    a0Var3.f3249h.unregisterReceiver(a0Var3.f3254m);
                    return;
                }
                return;
            default:
                boolean z10 = this.f3292i.f3252k;
                a0 a0Var4 = this.f3292i;
                a0Var4.f3252k = a0Var4.c();
                if (z10 != this.f3292i.f3252k) {
                    if (Log.isLoggable("ConnectivityMonitor", 3)) {
                        boolean z11 = this.f3292i.f3252k;
                    }
                    a0 a0Var5 = this.f3292i;
                    p.e().post(new y(1, a0Var5, a0Var5.f3252k));
                    return;
                }
                return;
        }
    }
}
