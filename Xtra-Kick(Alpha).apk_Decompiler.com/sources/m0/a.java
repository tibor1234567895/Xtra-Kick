package m0;

import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.woxthebox.draglistview.R;
import i0.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import n0.g;
import n0.h;
import n0.i;
import n0.m;

public final class a extends View.AccessibilityDelegate {

    /* renamed from: a  reason: collision with root package name */
    public final c f10038a;

    public a(c cVar) {
        this.f10038a = cVar;
    }

    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.f10038a.a(view, accessibilityEvent);
    }

    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        m b10 = this.f10038a.b(view);
        if (b10 != null) {
            return (AccessibilityNodeProvider) b10.f10920a;
        }
        return null;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f10038a.c(view, accessibilityEvent);
    }

    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean z10;
        boolean z11;
        ClickableSpan[] clickableSpanArr;
        int i10;
        View view2 = view;
        AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfo;
        i iVar = new i(accessibilityNodeInfo2);
        WeakHashMap weakHashMap = c1.f10054a;
        Boolean bool = (Boolean) new e0(R.id.tag_screen_reader_focusable, 0).b(view2);
        boolean z12 = true;
        if (bool == null || !bool.booleanValue()) {
            z10 = false;
        } else {
            z10 = true;
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            accessibilityNodeInfo2.setScreenReaderFocusable(z10);
        } else {
            iVar.g(1, z10);
        }
        Boolean bool2 = (Boolean) new e0(R.id.tag_accessibility_heading, 3).b(view2);
        if (bool2 == null || !bool2.booleanValue()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (i11 >= 28) {
            accessibilityNodeInfo2.setHeading(z11);
        } else {
            iVar.g(2, z11);
        }
        CharSequence d10 = c1.d(view);
        if (i11 >= 28) {
            accessibilityNodeInfo2.setPaneTitle(d10);
        } else {
            h.a(accessibilityNodeInfo).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", d10);
        }
        CharSequence charSequence = (CharSequence) new e0(R.id.tag_state_description, 64, 30, 2).b(view2);
        int i12 = b.f7941a;
        if (i11 < 30) {
            z12 = false;
        }
        if (z12) {
            accessibilityNodeInfo2.setStateDescription(charSequence);
        } else {
            h.a(accessibilityNodeInfo).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
        this.f10038a.d(view2, iVar);
        CharSequence text = accessibilityNodeInfo.getText();
        if (i11 < 26) {
            h.a(accessibilityNodeInfo).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            h.a(accessibilityNodeInfo).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            h.a(accessibilityNodeInfo).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            h.a(accessibilityNodeInfo).remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SparseArray sparseArray = (SparseArray) view2.getTag(R.id.tag_accessibility_clickable_spans);
            if (sparseArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i13 = 0; i13 < sparseArray.size(); i13++) {
                    if (((WeakReference) sparseArray.valueAt(i13)).get() == null) {
                        arrayList.add(Integer.valueOf(i13));
                    }
                }
                for (int i14 = 0; i14 < arrayList.size(); i14++) {
                    sparseArray.remove(((Integer) arrayList.get(i14)).intValue());
                }
            }
            if (text instanceof Spanned) {
                clickableSpanArr = (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class);
            } else {
                clickableSpanArr = null;
            }
            if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                h.a(iVar.f10916a).putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R.id.accessibility_action_clickable_span);
                SparseArray sparseArray2 = (SparseArray) view2.getTag(R.id.tag_accessibility_clickable_spans);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    view2.setTag(R.id.tag_accessibility_clickable_spans, sparseArray2);
                }
                for (int i15 = 0; i15 < clickableSpanArr.length; i15++) {
                    ClickableSpan clickableSpan = clickableSpanArr[i15];
                    int i16 = 0;
                    while (true) {
                        if (i16 >= sparseArray2.size()) {
                            i10 = i.f10915d;
                            i.f10915d = i10 + 1;
                            break;
                        } else if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray2.valueAt(i16)).get())) {
                            i10 = sparseArray2.keyAt(i16);
                            break;
                        } else {
                            i16++;
                        }
                    }
                    sparseArray2.put(i10, new WeakReference(clickableSpanArr[i15]));
                    ClickableSpan clickableSpan2 = clickableSpanArr[i15];
                    Spanned spanned = (Spanned) text;
                    iVar.c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan2)));
                    iVar.c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan2)));
                    iVar.c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan2)));
                    iVar.c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i10));
                }
            }
        }
        List list = (List) view2.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.emptyList();
        }
        for (int i17 = 0; i17 < list.size(); i17++) {
            iVar.b((g) list.get(i17));
        }
    }

    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f10038a.e(view, accessibilityEvent);
    }

    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f10038a.f(viewGroup, view, accessibilityEvent);
    }

    public final boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
        return this.f10038a.g(view, i10, bundle);
    }

    public final void sendAccessibilityEvent(View view, int i10) {
        this.f10038a.h(view, i10);
    }

    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.f10038a.i(view, accessibilityEvent);
    }
}
