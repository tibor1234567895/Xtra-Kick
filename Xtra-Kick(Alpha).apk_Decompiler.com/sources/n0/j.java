package n0;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

public abstract class j extends AccessibilityNodeProvider {

    /* renamed from: a  reason: collision with root package name */
    public final m f10919a;

    public j(m mVar) {
        this.f10919a = mVar;
    }

    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
        i a10 = this.f10919a.a(i10);
        if (a10 == null) {
            return null;
        }
        return a10.f10916a;
    }

    public final List findAccessibilityNodeInfosByText(String str, int i10) {
        this.f10919a.getClass();
        return null;
    }

    public final boolean performAction(int i10, int i11, Bundle bundle) {
        return this.f10919a.c(i10, i11, bundle);
    }
}
