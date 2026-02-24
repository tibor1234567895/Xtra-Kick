package m1;

import android.util.Base64;
import c9.w;
import h3.p4;
import h9.f0;
import h9.g0;
import h9.j0;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import n1.z;

public final /* synthetic */ class s implements w {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10458h;

    public /* synthetic */ s(int i10) {
        this.f10458h = i10;
    }

    public final Object get() {
        Object obj;
        switch (this.f10458h) {
            case 0:
                return new l();
            case 1:
                byte[] bArr = new byte[12];
                z.f11014i.nextBytes(bArr);
                return Base64.encodeToString(bArr, 10);
            default:
                w wVar = p4.f7287b;
                ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                if (newSingleThreadExecutor instanceof f0) {
                    return (f0) newSingleThreadExecutor;
                }
                if (newSingleThreadExecutor instanceof ScheduledExecutorService) {
                    obj = new j0((ScheduledExecutorService) newSingleThreadExecutor);
                } else {
                    obj = new g0(newSingleThreadExecutor);
                }
                return obj;
        }
    }
}
