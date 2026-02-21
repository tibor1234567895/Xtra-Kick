package u7;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public int f15407a;

    /* renamed from: b  reason: collision with root package name */
    public int f15408b;

    /* renamed from: c  reason: collision with root package name */
    public int f15409c;

    /* renamed from: d  reason: collision with root package name */
    public int f15410d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15411e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15412f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15413g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ FlexboxLayoutManager f15414h;

    public i(FlexboxLayoutManager flexboxLayoutManager) {
        this.f15414h = flexboxLayoutManager;
    }

    public static void a(i iVar) {
        int i10;
        FlexboxLayoutManager flexboxLayoutManager = iVar.f15414h;
        if (flexboxLayoutManager.j() || !flexboxLayoutManager.A) {
            if (!iVar.f15411e) {
                i10 = flexboxLayoutManager.I.j();
                iVar.f15409c = i10;
            }
        } else if (!iVar.f15411e) {
            i10 = flexboxLayoutManager.f2156u - flexboxLayoutManager.I.j();
            iVar.f15409c = i10;
        }
        i10 = flexboxLayoutManager.I.h();
        iVar.f15409c = i10;
    }

    public static void b(i iVar) {
        int i10;
        int i11;
        iVar.f15407a = -1;
        iVar.f15408b = -1;
        iVar.f15409c = RecyclerView.UNDEFINED_DURATION;
        boolean z10 = false;
        iVar.f15412f = false;
        iVar.f15413g = false;
        FlexboxLayoutManager flexboxLayoutManager = iVar.f15414h;
        if (!flexboxLayoutManager.j() ? !((i10 = flexboxLayoutManager.f3576x) != 0 ? i10 != 2 : flexboxLayoutManager.f3575w != 3) : !((i11 = flexboxLayoutManager.f3576x) != 0 ? i11 != 2 : flexboxLayoutManager.f3575w != 1)) {
            z10 = true;
        }
        iVar.f15411e = z10;
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.f15407a + ", mFlexLinePosition=" + this.f15408b + ", mCoordinate=" + this.f15409c + ", mPerpendicularCoordinate=" + this.f15410d + ", mLayoutFromEnd=" + this.f15411e + ", mValid=" + this.f15412f + ", mAssignedFromSavedState=" + this.f15413g + '}';
    }
}
