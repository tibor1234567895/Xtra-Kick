package u0;

import android.graphics.Rect;
import java.util.Comparator;
import n0.i;

public final class d implements Comparator {

    /* renamed from: h  reason: collision with root package name */
    public final Rect f15170h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    public final Rect f15171i = new Rect();

    /* renamed from: j  reason: collision with root package name */
    public final boolean f15172j;

    /* renamed from: k  reason: collision with root package name */
    public final a f15173k;

    public d(boolean z10, a aVar) {
        this.f15172j = z10;
        this.f15173k = aVar;
    }

    public final int compare(Object obj, Object obj2) {
        this.f15173k.getClass();
        Rect rect = this.f15170h;
        ((i) obj).e(rect);
        Rect rect2 = this.f15171i;
        ((i) obj2).e(rect2);
        int i10 = rect.top;
        int i11 = rect2.top;
        if (i10 < i11) {
            return -1;
        }
        if (i10 > i11) {
            return 1;
        }
        int i12 = rect.left;
        int i13 = rect2.left;
        boolean z10 = this.f15172j;
        if (i12 < i13) {
            if (z10) {
                return 1;
            }
            return -1;
        } else if (i12 <= i13) {
            int i14 = rect.bottom;
            int i15 = rect2.bottom;
            if (i14 < i15) {
                return -1;
            }
            if (i14 > i15) {
                return 1;
            }
            int i16 = rect.right;
            int i17 = rect2.right;
            if (i16 < i17) {
                if (z10) {
                    return 1;
                }
                return -1;
            } else if (i16 <= i17) {
                return 0;
            } else {
                if (z10) {
                    return -1;
                }
                return 1;
            }
        } else if (z10) {
            return -1;
        } else {
            return 1;
        }
    }
}
