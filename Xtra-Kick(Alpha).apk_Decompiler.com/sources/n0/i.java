package n0;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.gson.internal.bind.l;
import i0.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class i {

    /* renamed from: d  reason: collision with root package name */
    public static int f10915d;

    /* renamed from: a  reason: collision with root package name */
    public final AccessibilityNodeInfo f10916a;

    /* renamed from: b  reason: collision with root package name */
    public int f10917b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f10918c = -1;

    public i(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f10916a = accessibilityNodeInfo;
    }

    public static String d(int i10) {
        if (i10 == 1) {
            return "ACTION_FOCUS";
        }
        if (i10 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i10) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case Constants.IV_SIZE:
                return "ACTION_CLICK";
            case Constants.IV_SIZE_ALTERNATIVE:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i10) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i10) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            case 16908362:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i10) {
                                    case 16908372:
                                        return "ACTION_IME_ENTER";
                                    case 16908373:
                                        return "ACTION_DRAG_START";
                                    case 16908374:
                                        return "ACTION_DRAG_DROP";
                                    case 16908375:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    public final void a(int i10) {
        this.f10916a.addAction(i10);
    }

    public final void b(g gVar) {
        this.f10916a.addAction((AccessibilityNodeInfo.AccessibilityAction) gVar.f10911a);
    }

    public final ArrayList c(String str) {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f10916a;
        ArrayList<Integer> integerArrayList = h.a(accessibilityNodeInfo).getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        h.a(accessibilityNodeInfo).putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public final void e(Rect rect) {
        this.f10916a.getBoundsInParent(rect);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = iVar.f10916a;
        AccessibilityNodeInfo accessibilityNodeInfo2 = this.f10916a;
        if (accessibilityNodeInfo2 == null) {
            if (accessibilityNodeInfo != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo2.equals(accessibilityNodeInfo)) {
            return false;
        }
        return this.f10918c == iVar.f10918c && this.f10917b == iVar.f10917b;
    }

    public final CharSequence f() {
        boolean z10 = !c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
        AccessibilityNodeInfo accessibilityNodeInfo = this.f10916a;
        if (!z10) {
            return accessibilityNodeInfo.getText();
        }
        ArrayList c10 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        ArrayList c11 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        ArrayList c12 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        ArrayList c13 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(accessibilityNodeInfo.getText(), 0, accessibilityNodeInfo.getText().length()));
        for (int i10 = 0; i10 < c10.size(); i10++) {
            spannableString.setSpan(new a(((Integer) c13.get(i10)).intValue(), this, h.a(accessibilityNodeInfo).getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) c10.get(i10)).intValue(), ((Integer) c11.get(i10)).intValue(), ((Integer) c12.get(i10)).intValue());
        }
        return spannableString;
    }

    public final void g(int i10, boolean z10) {
        Bundle a10 = h.a(this.f10916a);
        if (a10 != null) {
            int i11 = a10.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i10);
            if (!z10) {
                i10 = 0;
            }
            a10.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i10 | i11);
        }
    }

    public final void h(CharSequence charSequence) {
        this.f10916a.setClassName(charSequence);
    }

    public final int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f10916a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public final void i(l lVar) {
        this.f10916a.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) lVar.f4038a);
    }

    public final void j(String str) {
        int i10 = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f10916a;
        if (i10 >= 26) {
            accessibilityNodeInfo.setHintText(str);
        } else {
            h.a(accessibilityNodeInfo).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", str);
        }
    }

    public final void k(boolean z10) {
        this.f10916a.setScrollable(z10);
    }

    public final void l(CharSequence charSequence) {
        this.f10916a.setText(charSequence);
    }

    public final String toString() {
        String str;
        ArrayList arrayList;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        Rect rect = new Rect();
        e(rect);
        sb2.append("; boundsInParent: " + rect);
        AccessibilityNodeInfo accessibilityNodeInfo = this.f10916a;
        accessibilityNodeInfo.getBoundsInScreen(rect);
        sb2.append("; boundsInScreen: " + rect);
        sb2.append("; packageName: ");
        sb2.append(accessibilityNodeInfo.getPackageName());
        sb2.append("; className: ");
        sb2.append(accessibilityNodeInfo.getClassName());
        sb2.append("; text: ");
        sb2.append(f());
        sb2.append("; contentDescription: ");
        sb2.append(accessibilityNodeInfo.getContentDescription());
        sb2.append("; viewId: ");
        sb2.append(accessibilityNodeInfo.getViewIdResourceName());
        sb2.append("; uniqueId: ");
        if (b.a()) {
            str = accessibilityNodeInfo.getUniqueId();
        } else {
            str = h.a(accessibilityNodeInfo).getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
        }
        sb2.append(str);
        sb2.append("; checkable: ");
        sb2.append(accessibilityNodeInfo.isCheckable());
        sb2.append("; checked: ");
        sb2.append(accessibilityNodeInfo.isChecked());
        sb2.append("; focusable: ");
        sb2.append(accessibilityNodeInfo.isFocusable());
        sb2.append("; focused: ");
        sb2.append(accessibilityNodeInfo.isFocused());
        sb2.append("; selected: ");
        sb2.append(accessibilityNodeInfo.isSelected());
        sb2.append("; clickable: ");
        sb2.append(accessibilityNodeInfo.isClickable());
        sb2.append("; longClickable: ");
        sb2.append(accessibilityNodeInfo.isLongClickable());
        sb2.append("; enabled: ");
        sb2.append(accessibilityNodeInfo.isEnabled());
        sb2.append("; password: ");
        sb2.append(accessibilityNodeInfo.isPassword());
        sb2.append("; scrollable: " + accessibilityNodeInfo.isScrollable());
        sb2.append("; [");
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = accessibilityNodeInfo.getActionList();
        if (actionList != null) {
            ArrayList arrayList2 = new ArrayList();
            int size = actionList.size();
            for (int i10 = 0; i10 < size; i10++) {
                arrayList2.add(new g(actionList.get(i10), 0, (String) null, (x) null, (Class) null));
            }
            arrayList = arrayList2;
        } else {
            arrayList = Collections.emptyList();
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            g gVar = (g) arrayList.get(i11);
            String d10 = d(gVar.a());
            if (d10.equals("ACTION_UNKNOWN")) {
                Object obj = gVar.f10911a;
                if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                    d10 = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
                }
            }
            sb2.append(d10);
            if (i11 != arrayList.size() - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
