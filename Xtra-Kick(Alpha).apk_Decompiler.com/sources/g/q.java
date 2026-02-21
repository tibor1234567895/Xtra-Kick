package g;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6198h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Context f6199i;

    public /* synthetic */ q(Context context, int i10) {
        this.f6198h = i10;
        this.f6199i = context;
    }

    public final void run() {
        int i10 = this.f6198h;
        Context context = this.f6199i;
        switch (i10) {
            case 0:
                t.C(context);
                return;
            default:
                if (Build.VERSION.SDK_INT >= 33) {
                    ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
                    if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                        if (t.f().d()) {
                            String b10 = u0.b(context);
                            Object systemService = context.getSystemService("locale");
                            if (systemService != null) {
                                s.b(systemService, r.a(b10));
                            }
                        }
                        context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
                    }
                }
                t.f6213m = true;
                return;
        }
    }
}
