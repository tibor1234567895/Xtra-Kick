package com.google.android.material.datepicker;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import m0.c;
import n0.i;

public final class o extends c {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f3780d;

    public /* synthetic */ o(Object obj) {
        this.f3780d = obj;
    }

    public final void d(View view, i iVar) {
        View.AccessibilityDelegate accessibilityDelegate = this.f10052a;
        AccessibilityNodeInfo accessibilityNodeInfo = iVar.f10916a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) null);
    }
}
