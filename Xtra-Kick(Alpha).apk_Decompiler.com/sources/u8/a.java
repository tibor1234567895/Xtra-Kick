package u8;

import com.google.android.material.sidesheet.SideSheetBehavior;

public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public final SideSheetBehavior f15438a;

    public a(SideSheetBehavior sideSheetBehavior) {
        this.f15438a = sideSheetBehavior;
    }

    public final int a() {
        SideSheetBehavior sideSheetBehavior = this.f15438a;
        return Math.max(0, (sideSheetBehavior.f3847m - sideSheetBehavior.f3846l) - sideSheetBehavior.f3848n);
    }
}
