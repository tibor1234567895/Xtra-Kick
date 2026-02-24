package k1;

import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import c9.r;
import i1.f;
import java.util.Map;

public final /* synthetic */ class q implements r {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9049h;

    public /* synthetic */ q(int i10) {
        this.f9049h = i10;
    }

    public final boolean apply(Object obj) {
        switch (this.f9049h) {
            case 0:
                if (((Map.Entry) obj).getKey() != null) {
                    return true;
                }
                return false;
            case 1:
                if (((String) obj) != null) {
                    return true;
                }
                return false;
            case 2:
                return !(obj instanceof f);
            default:
                if ((obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan)) {
                    return true;
                }
                return false;
        }
    }
}
