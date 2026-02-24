package com.google.android.material.datepicker;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.woxthebox.draglistview.R;
import m0.c;
import n0.i;

public final class j extends c {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f3761d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ n f3762e;

    public /* synthetic */ j(n nVar, int i10) {
        this.f3761d = i10;
        this.f3762e = nVar;
    }

    public final void d(View view, i iVar) {
        int i10;
        AccessibilityNodeInfo accessibilityNodeInfo = iVar.f10916a;
        int i11 = this.f3761d;
        View.AccessibilityDelegate accessibilityDelegate = this.f10052a;
        switch (i11) {
            case 0:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) null);
                return;
            case 1:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                iVar.k(false);
                return;
            default:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                n nVar = this.f3762e;
                if (nVar.f3779p0.getVisibility() == 0) {
                    i10 = R.string.mtrl_picker_toggle_to_year_selection;
                } else {
                    i10 = R.string.mtrl_picker_toggle_to_day_selection;
                }
                iVar.j(nVar.z(i10));
                return;
        }
    }
}
