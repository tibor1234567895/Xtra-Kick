package e1;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.b;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import com.google.gson.internal.bind.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import q.e;

public abstract class a0 extends Service {

    /* renamed from: o  reason: collision with root package name */
    public static final /* synthetic */ int f4886o = 0;

    /* renamed from: h  reason: collision with root package name */
    public n f4887h;

    /* renamed from: i  reason: collision with root package name */
    public final j f4888i = new j(this, "android.media.session.MediaController", -1, -1, (l) null);

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList f4889j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public final e f4890k = new e();

    /* renamed from: l  reason: collision with root package name */
    public j f4891l;

    /* renamed from: m  reason: collision with root package name */
    public final b f4892m = new b(this);

    /* renamed from: n  reason: collision with root package name */
    public MediaSessionCompat$Token f4893n;

    static {
        Log.isLoggable("MBServiceCompat", 3);
    }

    public abstract h a(Bundle bundle);

    public abstract void b(v vVar);

    public final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final IBinder onBind(Intent intent) {
        return this.f4887h.f4930b.onBind(intent);
    }

    public final void onCreate() {
        super.onCreate();
        int i10 = Build.VERSION.SDK_INT;
        n tVar = i10 >= 28 ? new t(this) : i10 >= 26 ? new s(this) : i10 >= 23 ? new p(this) : new n(this);
        this.f4887h = tVar;
        tVar.onCreate();
    }
}
