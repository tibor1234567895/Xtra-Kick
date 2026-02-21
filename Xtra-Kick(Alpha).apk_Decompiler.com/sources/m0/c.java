package m0;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import com.woxthebox.draglistview.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import n0.g;
import n0.i;
import n0.m;
import n0.p;
import n0.x;

public class c {

    /* renamed from: c  reason: collision with root package name */
    public static final View.AccessibilityDelegate f10051c = new View.AccessibilityDelegate();

    /* renamed from: a  reason: collision with root package name */
    public final View.AccessibilityDelegate f10052a;

    /* renamed from: b  reason: collision with root package name */
    public final a f10053b;

    public c() {
        this(f10051c);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f10052a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public m b(View view) {
        AccessibilityNodeProvider a10 = b.a(this.f10052a, view);
        if (a10 != null) {
            return new m(a10);
        }
        return null;
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f10052a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, i iVar) {
        this.f10052a.onInitializeAccessibilityNodeInfo(view, iVar.f10916a);
    }

    public void e(View view, AccessibilityEvent accessibilityEvent) {
        this.f10052a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f10052a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean g(View view, int i10, Bundle bundle) {
        boolean z10;
        WeakReference weakReference;
        boolean z11;
        ClickableSpan[] clickableSpanArr;
        List list = (List) view.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.emptyList();
        }
        boolean z12 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= list.size()) {
                break;
            }
            g gVar = (g) list.get(i11);
            if (gVar.a() == i10) {
                x xVar = gVar.f10914d;
                if (xVar != null) {
                    Class cls = gVar.f10913c;
                    if (cls != null) {
                        try {
                            ((p) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0])).getClass();
                        } catch (Exception e10) {
                            Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(cls.getName()), e10);
                        }
                    }
                    z10 = xVar.b(view);
                }
            } else {
                i11++;
            }
        }
        z10 = false;
        if (!z10) {
            z10 = b.b(this.f10052a, view, i10, bundle);
        }
        if (z10 || i10 != R.id.accessibility_action_clickable_span || bundle == null) {
            return z10;
        }
        int i12 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (!(sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i12)) == null)) {
            ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
            if (clickableSpan != null) {
                CharSequence text = view.createAccessibilityNodeInfo().getText();
                if (text instanceof Spanned) {
                    clickableSpanArr = (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class);
                } else {
                    clickableSpanArr = null;
                }
                int i13 = 0;
                while (true) {
                    if (clickableSpanArr == null || i13 >= clickableSpanArr.length) {
                        break;
                    } else if (clickableSpan.equals(clickableSpanArr[i13])) {
                        z11 = true;
                        break;
                    } else {
                        i13++;
                    }
                }
            }
            z11 = false;
            if (z11) {
                clickableSpan.onClick(view);
                z12 = true;
            }
        }
        return z12;
    }

    public void h(View view, int i10) {
        this.f10052a.sendAccessibilityEvent(view, i10);
    }

    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.f10052a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public c(View.AccessibilityDelegate accessibilityDelegate) {
        this.f10052a = accessibilityDelegate;
        this.f10053b = new a(this);
    }
}
