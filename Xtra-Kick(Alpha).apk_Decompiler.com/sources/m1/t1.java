package m1;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.PowerManager;

public final class t1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10496a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f10497b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f10498c;

    public t1(Context context, int i10) {
        this.f10496a = i10;
        if (i10 != 1) {
            this.f10498c = (PowerManager) context.getApplicationContext().getSystemService("power");
        } else {
            this.f10498c = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        }
    }

    public final void a() {
        switch (this.f10496a) {
            case 0:
                this.f10497b = false;
                return;
            default:
                this.f10497b = false;
                return;
        }
    }

    public final void b(boolean z10) {
        switch (this.f10496a) {
        }
    }
}
