package b0;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import com.woxthebox.draglistview.R;
import java.util.ArrayList;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2385a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f2386b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f2387c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f2388d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f2389e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f2390f;

    /* renamed from: g  reason: collision with root package name */
    public PendingIntent f2391g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f2392h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2393i = true;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2394j;

    /* renamed from: k  reason: collision with root package name */
    public q f2395k;

    /* renamed from: l  reason: collision with root package name */
    public int f2396l;

    /* renamed from: m  reason: collision with root package name */
    public int f2397m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f2398n;

    /* renamed from: o  reason: collision with root package name */
    public String f2399o;

    /* renamed from: p  reason: collision with root package name */
    public Bundle f2400p;

    /* renamed from: q  reason: collision with root package name */
    public int f2401q = 0;

    /* renamed from: r  reason: collision with root package name */
    public final String f2402r;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f2403s;

    /* renamed from: t  reason: collision with root package name */
    public final Notification f2404t;

    /* renamed from: u  reason: collision with root package name */
    public final ArrayList f2405u;

    public p(Context context, String str) {
        Notification notification = new Notification();
        this.f2404t = notification;
        this.f2385a = context;
        this.f2402r = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.f2405u = new ArrayList();
        this.f2403s = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final Notification a() {
        d0 d0Var = new d0(this);
        p pVar = d0Var.f2336b;
        q qVar = pVar.f2395k;
        if (qVar != null) {
            qVar.a(d0Var);
        }
        if (qVar != null) {
            qVar.c();
        }
        int i10 = Build.VERSION.SDK_INT;
        Notification.Builder builder = d0Var.f2335a;
        if (i10 < 26 && i10 < 24) {
            t.a(builder, d0Var.f2337c);
        }
        Notification a10 = r.a(builder);
        if (qVar != null) {
            qVar.b();
        }
        if (qVar != null) {
            pVar.f2395k.getClass();
        }
        if (qVar != null) {
            Bundle bundle = a10.extras;
        }
        return a10;
    }

    public final void c(int i10, boolean z10) {
        int i11;
        Notification notification = this.f2404t;
        if (z10) {
            i11 = i10 | notification.flags;
        } else {
            i11 = (~i10) & notification.flags;
        }
        notification.flags = i11;
    }

    public final void d(Bitmap bitmap) {
        if (bitmap != null && Build.VERSION.SDK_INT < 27) {
            Resources resources = this.f2385a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                double min = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
                bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * min), (int) Math.ceil(((double) bitmap.getHeight()) * min), true);
            }
        }
        this.f2392h = bitmap;
    }

    public final void e(q qVar) {
        if (this.f2395k != qVar) {
            this.f2395k = qVar;
            if (qVar != null) {
                qVar.d(this);
            }
        }
    }
}
