package r3;

import android.content.Context;
import android.content.Intent;
import android.support.v4.media.k;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f13664a;

    /* renamed from: b  reason: collision with root package name */
    public final y f13665b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f13666c;

    /* renamed from: d  reason: collision with root package name */
    public final Context f13667d;

    /* renamed from: e  reason: collision with root package name */
    public int f13668e;

    /* renamed from: f  reason: collision with root package name */
    public v f13669f;

    /* renamed from: g  reason: collision with root package name */
    public r f13670g;

    /* renamed from: h  reason: collision with root package name */
    public final c0 f13671h = new c0(this);

    /* renamed from: i  reason: collision with root package name */
    public final AtomicBoolean f13672i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    public final k f13673j;

    /* renamed from: k  reason: collision with root package name */
    public final z f13674k;

    /* renamed from: l  reason: collision with root package name */
    public final z f13675l;

    public d0(Context context, String str, Intent intent, y yVar, Executor executor) {
        this.f13664a = str;
        this.f13665b = yVar;
        this.f13666c = executor;
        Context applicationContext = context.getApplicationContext();
        this.f13667d = applicationContext;
        k kVar = new k(this);
        this.f13673j = kVar;
        this.f13674k = new z(this, 0);
        this.f13675l = new z(this, 1);
        this.f13669f = new a0(this, (String[]) yVar.f13778d.keySet().toArray(new String[0]));
        applicationContext.bindService(intent, kVar, 1);
    }
}
