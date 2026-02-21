package n0;

import android.view.accessibility.AccessibilityNodeInfo;

public class k extends j {
    public k(m mVar) {
        super(mVar);
    }

    public final AccessibilityNodeInfo findFocus(int i10) {
        i b10 = this.f10919a.b(i10);
        if (b10 == null) {
            return null;
        }
        return b10.f10916a;
    }
}
