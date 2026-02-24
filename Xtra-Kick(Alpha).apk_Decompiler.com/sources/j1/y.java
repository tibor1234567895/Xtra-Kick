package j1;

import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;

public final class y extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {

    /* renamed from: a  reason: collision with root package name */
    public final z f8481a;

    public y(z zVar) {
        this.f8481a = zVar;
    }

    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        int c10 = telephonyDisplayInfo.getOverrideNetworkType();
        int i10 = 5;
        boolean z10 = c10 == 3 || c10 == 4 || c10 == 5;
        z zVar = this.f8481a;
        if (z10) {
            i10 = 10;
        }
        z.a(i10, zVar);
    }
}
