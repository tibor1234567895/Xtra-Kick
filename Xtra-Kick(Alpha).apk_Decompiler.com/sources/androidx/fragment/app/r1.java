package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

public final class r1 extends Transition.EpicenterCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1556a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Rect f1557b;

    public /* synthetic */ r1(Rect rect, int i10) {
        this.f1556a = i10;
        this.f1557b = rect;
    }

    public final Rect onGetEpicenter(Transition transition) {
        int i10 = this.f1556a;
        Rect rect = this.f1557b;
        switch (i10) {
            case 0:
                return rect;
            default:
                if (rect == null || rect.isEmpty()) {
                    return null;
                }
                return rect;
        }
    }
}
