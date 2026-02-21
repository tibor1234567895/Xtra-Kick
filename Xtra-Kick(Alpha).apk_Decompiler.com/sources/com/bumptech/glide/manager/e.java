package com.bumptech.glide.manager;

import android.content.Context;
import com.bumptech.glide.r;
import java.util.Set;

public final class e implements d {

    /* renamed from: h  reason: collision with root package name */
    public final Context f3264h;

    /* renamed from: i  reason: collision with root package name */
    public final c f3265i;

    public e(Context context, r rVar) {
        this.f3264h = context.getApplicationContext();
        this.f3265i = rVar;
    }

    public final void c() {
        b0 c10 = b0.c(this.f3264h);
        c cVar = this.f3265i;
        synchronized (c10) {
            ((Set) c10.f3258c).remove(cVar);
            if (c10.f3256a) {
                if (((Set) c10.f3258c).isEmpty()) {
                    ((x) c10.f3257b).a();
                    c10.f3256a = false;
                }
            }
        }
    }

    public final void j() {
        b0 c10 = b0.c(this.f3264h);
        c cVar = this.f3265i;
        synchronized (c10) {
            ((Set) c10.f3258c).add(cVar);
            if (!c10.f3256a) {
                if (!((Set) c10.f3258c).isEmpty()) {
                    c10.f3256a = ((x) c10.f3257b).b();
                }
            }
        }
    }

    public final void k() {
    }
}
