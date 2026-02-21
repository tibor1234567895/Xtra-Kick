package u0;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import f8.d;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import n0.i;
import n0.m;

public final class c extends m {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f15169b;

    public c(d dVar) {
        this.f15169b = dVar;
    }

    public final i a(int i10) {
        return new i(AccessibilityNodeInfo.obtain(this.f15169b.n(i10).f10916a));
    }

    public final i b(int i10) {
        d dVar = this.f15169b;
        int i11 = i10 == 2 ? dVar.f5953k : dVar.f5954l;
        if (i11 == Integer.MIN_VALUE) {
            return null;
        }
        return a(i11);
    }

    public final boolean c(int i10, int i11, Bundle bundle) {
        int i12;
        d dVar = this.f15169b;
        View view = dVar.f5951i;
        if (i10 != -1) {
            boolean z10 = true;
            if (i11 == 1) {
                return dVar.p(i10);
            }
            if (i11 == 2) {
                return dVar.j(i10);
            }
            boolean z11 = false;
            if (i11 == 64) {
                AccessibilityManager accessibilityManager = dVar.f5950h;
                if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled() && (i12 = dVar.f5953k) != i10) {
                    if (i12 != Integer.MIN_VALUE) {
                        dVar.f5953k = RecyclerView.UNDEFINED_DURATION;
                        dVar.f5951i.invalidate();
                        dVar.q(i12, 65536);
                    }
                    dVar.f5953k = i10;
                    view.invalidate();
                    dVar.q(i10, 32768);
                    return z10;
                }
            } else if (i11 != 128) {
                if (i11 == 16) {
                    Chip chip = dVar.f5956n;
                    if (i10 == 0) {
                        return chip.performClick();
                    }
                    if (i10 == 1) {
                        chip.playSoundEffect(0);
                        View.OnClickListener onClickListener = chip.f3722o;
                        if (onClickListener != null) {
                            onClickListener.onClick(chip);
                            z11 = true;
                        }
                        if (chip.f3733z) {
                            chip.f3732y.q(1, 1);
                        }
                    }
                }
                return z11;
            } else if (dVar.f5953k == i10) {
                dVar.f5953k = RecyclerView.UNDEFINED_DURATION;
                view.invalidate();
                dVar.q(i10, 65536);
                return z10;
            }
            z10 = false;
            return z10;
        }
        WeakHashMap weakHashMap = c1.f10054a;
        return i0.j(view, i11, bundle);
    }
}
