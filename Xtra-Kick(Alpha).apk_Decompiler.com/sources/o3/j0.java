package o3;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g1;
import b8.h;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.gson.internal.bind.l;
import m0.c;
import n0.i;

public final class j0 extends c {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f12138d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f12139e;

    public /* synthetic */ j0(int i10, Object obj) {
        this.f12138d = i10;
        this.f12139e = obj;
    }

    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f12138d) {
            case 3:
                super.c(view, accessibilityEvent);
                accessibilityEvent.setChecked(((CheckableImageButton) this.f12139e).isChecked());
                return;
            default:
                super.c(view, accessibilityEvent);
                return;
        }
    }

    public final void d(View view, i iVar) {
        int i10;
        boolean z10 = true;
        AccessibilityNodeInfo accessibilityNodeInfo = iVar.f10916a;
        int i11 = this.f12138d;
        View.AccessibilityDelegate accessibilityDelegate = this.f10052a;
        Object obj = this.f12139e;
        switch (i11) {
            case 0:
                k0 k0Var = (k0) obj;
                k0Var.f12142g.d(view, iVar);
                RecyclerView recyclerView = k0Var.f12141f;
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                g1 adapter = recyclerView.getAdapter();
                if (adapter instanceof d0) {
                    ((d0) adapter).c(childAdapterPosition);
                    return;
                }
                return;
            case 1:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                if (((h) obj).f2683p) {
                    iVar.a(1048576);
                } else {
                    z10 = false;
                }
                accessibilityNodeInfo.setDismissable(z10);
                return;
            case 2:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj;
                int i12 = MaterialButtonToggleGroup.f3707r;
                materialButtonToggleGroup.getClass();
                if (view instanceof MaterialButton) {
                    int i13 = 0;
                    i10 = 0;
                    while (true) {
                        if (i13 < materialButtonToggleGroup.getChildCount()) {
                            if (materialButtonToggleGroup.getChildAt(i13) != view) {
                                if ((materialButtonToggleGroup.getChildAt(i13) instanceof MaterialButton) && materialButtonToggleGroup.d(i13)) {
                                    i10++;
                                }
                                i13++;
                            }
                        }
                    }
                    iVar.i(l.c(0, 1, i10, 1, ((MaterialButton) view).isChecked()));
                    return;
                }
                i10 = -1;
                iVar.i(l.c(0, 1, i10, 1, ((MaterialButton) view).isChecked()));
                return;
            case 3:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                accessibilityNodeInfo.setCheckable(checkableImageButton.f3831l);
                accessibilityNodeInfo.setChecked(checkableImageButton.isChecked());
                return;
            default:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setCheckable(((NavigationMenuItemView) obj).E);
                return;
        }
    }

    public final boolean g(View view, int i10, Bundle bundle) {
        int i11 = this.f12138d;
        Object obj = this.f12139e;
        switch (i11) {
            case 0:
                return ((k0) obj).f12142g.g(view, i10, bundle);
            case 1:
                if (i10 == 1048576) {
                    h hVar = (h) obj;
                    if (hVar.f2683p) {
                        hVar.cancel();
                        return true;
                    }
                }
                return super.g(view, i10, bundle);
            default:
                return super.g(view, i10, bundle);
        }
    }
}
