package b0;

import android.app.Notification;
import android.support.v4.media.h;

public final class g0 implements k0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2353a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2354b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2355c = null;

    /* renamed from: d  reason: collision with root package name */
    public final Notification f2356d;

    public g0(String str, int i10, Notification notification) {
        this.f2353a = str;
        this.f2354b = i10;
        this.f2356d = notification;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("NotifyTask[packageName:");
        sb2.append(this.f2353a);
        sb2.append(", id:");
        sb2.append(this.f2354b);
        sb2.append(", tag:");
        return h.p(sb2, this.f2355c, "]");
    }
}
