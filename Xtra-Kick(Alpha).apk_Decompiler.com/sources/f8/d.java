package f8;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.woxthebox.draglistview.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m0.c;
import m0.c1;
import m0.i0;
import n0.g;
import n0.i;
import n0.m;
import u0.a;
import u0.b;

public final class d extends c {

    /* renamed from: o  reason: collision with root package name */
    public static final Rect f5943o = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, RecyclerView.UNDEFINED_DURATION, RecyclerView.UNDEFINED_DURATION);

    /* renamed from: p  reason: collision with root package name */
    public static final a f5944p = new a();

    /* renamed from: q  reason: collision with root package name */
    public static final b f5945q = new b();

    /* renamed from: d  reason: collision with root package name */
    public final Rect f5946d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    public final Rect f5947e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public final Rect f5948f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    public final int[] f5949g = new int[2];

    /* renamed from: h  reason: collision with root package name */
    public final AccessibilityManager f5950h;

    /* renamed from: i  reason: collision with root package name */
    public final View f5951i;

    /* renamed from: j  reason: collision with root package name */
    public u0.c f5952j;

    /* renamed from: k  reason: collision with root package name */
    public int f5953k = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: l  reason: collision with root package name */
    public int f5954l = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: m  reason: collision with root package name */
    public int f5955m = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Chip f5956n;

    public d(Chip chip, Chip chip2) {
        this.f5956n = chip;
        if (chip2 != null) {
            this.f5951i = chip2;
            this.f5950h = (AccessibilityManager) chip2.getContext().getSystemService("accessibility");
            chip2.setFocusable(true);
            WeakHashMap weakHashMap = c1.f10054a;
            if (i0.c(chip2) == 0) {
                i0.s(chip2, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    public final m b(View view) {
        if (this.f5952j == null) {
            this.f5952j = new u0.c(this);
        }
        return this.f5952j;
    }

    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
    }

    public final void d(View view, i iVar) {
        boolean z10;
        View.AccessibilityDelegate accessibilityDelegate = this.f10052a;
        AccessibilityNodeInfo accessibilityNodeInfo = iVar.f10916a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        Chip chip = this.f5956n;
        f fVar = chip.f3719l;
        if (fVar == null || !fVar.X) {
            z10 = false;
        } else {
            z10 = true;
        }
        accessibilityNodeInfo.setCheckable(z10);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        iVar.h(chip.getAccessibilityClassName());
        CharSequence text = chip.getText();
        if (Build.VERSION.SDK_INT >= 23) {
            iVar.l(text);
        } else {
            accessibilityNodeInfo.setContentDescription(text);
        }
    }

    public final boolean j(int i10) {
        if (this.f5954l != i10) {
            return false;
        }
        this.f5954l = RecyclerView.UNDEFINED_DURATION;
        if (i10 == 1) {
            Chip chip = this.f5956n;
            chip.f3727t = false;
            chip.refreshDrawableState();
        }
        q(i10, 8);
        return true;
    }

    public final i k(int i10) {
        boolean z10;
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        i iVar = new i(obtain);
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        iVar.h("android.view.View");
        Rect rect = f5943o;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        iVar.f10917b = -1;
        View view = this.f5951i;
        obtain.setParent(view);
        o(i10, iVar);
        if (iVar.f() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.f5947e;
        iVar.e(rect2);
        if (!rect2.equals(rect)) {
            int actions = obtain.getActions();
            if ((actions & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((actions & 128) == 0) {
                obtain.setPackageName(view.getContext().getPackageName());
                iVar.f10918c = i10;
                obtain.setSource(view, i10);
                boolean z11 = false;
                if (this.f5953k == i10) {
                    obtain.setAccessibilityFocused(true);
                    iVar.a(128);
                } else {
                    obtain.setAccessibilityFocused(false);
                    iVar.a(64);
                }
                if (this.f5954l == i10) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    iVar.a(2);
                } else if (obtain.isFocusable()) {
                    iVar.a(1);
                }
                obtain.setFocused(z10);
                int[] iArr = this.f5949g;
                view.getLocationOnScreen(iArr);
                Rect rect3 = this.f5946d;
                obtain.getBoundsInScreen(rect3);
                if (rect3.equals(rect)) {
                    iVar.e(rect3);
                    if (iVar.f10917b != -1) {
                        i iVar2 = new i(AccessibilityNodeInfo.obtain());
                        for (int i11 = iVar.f10917b; i11 != -1; i11 = iVar2.f10917b) {
                            iVar2.f10917b = -1;
                            AccessibilityNodeInfo accessibilityNodeInfo = iVar2.f10916a;
                            accessibilityNodeInfo.setParent(view, -1);
                            accessibilityNodeInfo.setBoundsInParent(rect);
                            o(i11, iVar2);
                            iVar2.e(rect2);
                            rect3.offset(rect2.left, rect2.top);
                        }
                    }
                    rect3.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
                }
                Rect rect4 = this.f5948f;
                if (view.getLocalVisibleRect(rect4)) {
                    rect4.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
                    if (rect3.intersect(rect4)) {
                        iVar.f10916a.setBoundsInScreen(rect3);
                        if (!rect3.isEmpty() && view.getWindowVisibility() == 0) {
                            while (true) {
                                ViewParent parent = view.getParent();
                                if (parent instanceof View) {
                                    view = (View) parent;
                                    if (view.getAlpha() > 0.0f) {
                                        if (view.getVisibility() != 0) {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                } else if (parent != null) {
                                    z11 = true;
                                }
                            }
                        }
                        if (z11) {
                            obtain.setVisibleToUser(true);
                        }
                    }
                }
                return iVar;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    public final void l(ArrayList arrayList) {
        boolean z10 = false;
        arrayList.add(0);
        Rect rect = Chip.D;
        Chip chip = this.f5956n;
        if (chip.c()) {
            f fVar = chip.f3719l;
            if (fVar != null && fVar.R) {
                z10 = true;
            }
            if (z10 && chip.f3722o != null) {
                arrayList.add(1);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0144, code lost:
        if (r14 < ((r15 * r15) + ((r13 * 13) * r13))) goto L_0x0146;
     */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0150 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x014b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m(int r19, android.graphics.Rect r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r0.l(r3)
            q.l r4 = new q.l
            r4.<init>()
            r6 = 0
        L_0x0014:
            int r7 = r3.size()
            if (r6 >= r7) goto L_0x0038
            java.lang.Object r7 = r3.get(r6)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            n0.i r7 = r0.k(r7)
            java.lang.Object r8 = r3.get(r6)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            r4.f(r8, r7)
            int r6 = r6 + 1
            goto L_0x0014
        L_0x0038:
            int r3 = r0.f5954l
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 0
            if (r3 != r6) goto L_0x0041
            r3 = r7
            goto L_0x0047
        L_0x0041:
            java.lang.Object r3 = r4.d(r3, r7)
            n0.i r3 = (n0.i) r3
        L_0x0047:
            r9 = 1
            u0.a r10 = f5944p
            u0.b r11 = f5945q
            android.view.View r12 = r0.f5951i
            r13 = 2
            if (r1 == r9) goto L_0x0158
            if (r1 == r13) goto L_0x0158
            r13 = 130(0x82, float:1.82E-43)
            r14 = 66
            r15 = 33
            r7 = 17
            if (r1 == r7) goto L_0x006c
            if (r1 == r15) goto L_0x006c
            if (r1 == r14) goto L_0x006c
            if (r1 != r13) goto L_0x0064
            goto L_0x006c
        L_0x0064:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1.<init>(r2)
            throw r1
        L_0x006c:
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            int r5 = r0.f5954l
            java.lang.String r8 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            if (r5 == r6) goto L_0x007f
            n0.i r2 = r0.n(r5)
            r2.e(r9)
            goto L_0x00b0
        L_0x007f:
            if (r2 == 0) goto L_0x0085
            r9.set(r2)
            goto L_0x00b0
        L_0x0085:
            int r2 = r12.getWidth()
            int r5 = r12.getHeight()
            if (r1 == r7) goto L_0x00ac
            if (r1 == r15) goto L_0x00a7
            if (r1 == r14) goto L_0x00a1
            if (r1 != r13) goto L_0x009b
            r5 = 0
            r12 = -1
            r9.set(r5, r12, r2, r12)
            goto L_0x00b0
        L_0x009b:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r8)
            throw r1
        L_0x00a1:
            r2 = 0
            r12 = -1
            r9.set(r12, r2, r12, r5)
            goto L_0x00b0
        L_0x00a7:
            r12 = 0
            r9.set(r12, r5, r2, r5)
            goto L_0x00b0
        L_0x00ac:
            r12 = 0
            r9.set(r2, r12, r2, r5)
        L_0x00b0:
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>(r9)
            if (r1 == r7) goto L_0x00df
            if (r1 == r15) goto L_0x00d4
            if (r1 == r14) goto L_0x00cb
            if (r1 != r13) goto L_0x00c5
            int r5 = r9.height()
            r7 = 1
            int r5 = r5 + r7
            int r5 = -r5
            goto L_0x00da
        L_0x00c5:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r8)
            throw r1
        L_0x00cb:
            r7 = 1
            int r5 = r9.width()
            int r5 = r5 + r7
            int r5 = -r5
            r8 = 0
            goto L_0x00e6
        L_0x00d4:
            r7 = 1
            int r5 = r9.height()
            int r5 = r5 + r7
        L_0x00da:
            r8 = 0
            r2.offset(r8, r5)
            goto L_0x00e9
        L_0x00df:
            r7 = 1
            r8 = 0
            int r5 = r9.width()
            int r5 = r5 + r7
        L_0x00e6:
            r2.offset(r5, r8)
        L_0x00e9:
            r11.getClass()
            int r5 = r4.g()
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>()
            r11 = 0
            r16 = 0
        L_0x00f8:
            if (r11 >= r5) goto L_0x0153
            java.lang.Object r12 = r4.h(r11)
            n0.i r12 = (n0.i) r12
            if (r12 != r3) goto L_0x0103
            goto L_0x0150
        L_0x0103:
            r10.getClass()
            r12.e(r7)
            boolean r13 = u0.e.c(r1, r9, r7)
            if (r13 != 0) goto L_0x0110
            goto L_0x0148
        L_0x0110:
            boolean r13 = u0.e.c(r1, r9, r2)
            if (r13 != 0) goto L_0x0117
            goto L_0x0146
        L_0x0117:
            boolean r13 = u0.e.a(r1, r9, r7, r2)
            if (r13 == 0) goto L_0x011e
            goto L_0x0146
        L_0x011e:
            boolean r13 = u0.e.a(r1, r9, r2, r7)
            if (r13 == 0) goto L_0x0125
            goto L_0x0148
        L_0x0125:
            int r13 = u0.e.d(r1, r9, r7)
            int r14 = u0.e.e(r1, r9, r7)
            int r15 = r13 * 13
            int r15 = r15 * r13
            int r14 = r14 * r14
            int r14 = r14 + r15
            int r13 = u0.e.d(r1, r9, r2)
            int r15 = u0.e.e(r1, r9, r2)
            int r17 = r13 * 13
            int r17 = r17 * r13
            int r15 = r15 * r15
            int r15 = r15 + r17
            if (r14 >= r15) goto L_0x0148
        L_0x0146:
            r13 = 1
            goto L_0x0149
        L_0x0148:
            r13 = 0
        L_0x0149:
            if (r13 == 0) goto L_0x0150
            r2.set(r7)
            r16 = r12
        L_0x0150:
            int r11 = r11 + 1
            goto L_0x00f8
        L_0x0153:
            r1 = r16
            r2 = -1
            goto L_0x01c7
        L_0x0158:
            r8 = 0
            java.util.WeakHashMap r2 = m0.c1.f10054a
            int r2 = m0.j0.d(r12)
            r5 = 1
            if (r2 != r5) goto L_0x0164
            r5 = 1
            goto L_0x0165
        L_0x0164:
            r5 = 0
        L_0x0165:
            r11.getClass()
            int r2 = r4.g()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>(r2)
            r9 = 0
        L_0x0172:
            if (r9 >= r2) goto L_0x0180
            java.lang.Object r11 = r4.h(r9)
            n0.i r11 = (n0.i) r11
            r7.add(r11)
            int r9 = r9 + 1
            goto L_0x0172
        L_0x0180:
            u0.d r2 = new u0.d
            r2.<init>(r5, r10)
            java.util.Collections.sort(r7, r2)
            r2 = 1
            if (r1 == r2) goto L_0x01ac
            if (r1 != r13) goto L_0x01a4
            int r1 = r7.size()
            if (r3 != 0) goto L_0x0195
            r12 = -1
            goto L_0x0199
        L_0x0195:
            int r12 = r7.lastIndexOf(r3)
        L_0x0199:
            int r12 = r12 + r2
            if (r12 >= r1) goto L_0x01a2
            java.lang.Object r7 = r7.get(r12)
            r2 = -1
            goto L_0x01c1
        L_0x01a2:
            r2 = -1
            goto L_0x01c0
        L_0x01a4:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}."
            r1.<init>(r2)
            throw r1
        L_0x01ac:
            int r1 = r7.size()
            if (r3 != 0) goto L_0x01b3
            goto L_0x01b7
        L_0x01b3:
            int r1 = r7.indexOf(r3)
        L_0x01b7:
            r2 = -1
            int r1 = r1 + r2
            if (r1 < 0) goto L_0x01c0
            java.lang.Object r7 = r7.get(r1)
            goto L_0x01c1
        L_0x01c0:
            r7 = 0
        L_0x01c1:
            r16 = r7
            n0.i r16 = (n0.i) r16
            r1 = r16
        L_0x01c7:
            if (r1 != 0) goto L_0x01ca
            goto L_0x01e6
        L_0x01ca:
            boolean r3 = r4.f13083h
            if (r3 == 0) goto L_0x01d1
            r4.c()
        L_0x01d1:
            r5 = 0
        L_0x01d2:
            int r3 = r4.f13086k
            if (r5 >= r3) goto L_0x01e1
            java.lang.Object[] r3 = r4.f13085j
            r3 = r3[r5]
            if (r3 != r1) goto L_0x01de
            r8 = r5
            goto L_0x01e2
        L_0x01de:
            int r5 = r5 + 1
            goto L_0x01d2
        L_0x01e1:
            r8 = -1
        L_0x01e2:
            int r6 = r4.e(r8)
        L_0x01e6:
            boolean r1 = r0.p(r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: f8.d.m(int, android.graphics.Rect):boolean");
    }

    public final i n(int i10) {
        if (i10 != -1) {
            return k(i10);
        }
        View view = this.f5951i;
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(view);
        i iVar = new i(obtain);
        WeakHashMap weakHashMap = c1.f10054a;
        view.onInitializeAccessibilityNodeInfo(obtain);
        ArrayList arrayList = new ArrayList();
        l(arrayList);
        if (obtain.getChildCount() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                iVar.f10916a.addChild(view, ((Integer) arrayList.get(i11)).intValue());
            }
            return iVar;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    public final void o(int i10, i iVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = iVar.f10916a;
        CharSequence charSequence = "";
        if (i10 == 1) {
            Chip chip = this.f5956n;
            CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                accessibilityNodeInfo.setContentDescription(closeIconContentDescription);
            } else {
                CharSequence text = chip.getText();
                Context context = chip.getContext();
                Object[] objArr = new Object[1];
                if (!TextUtils.isEmpty(text)) {
                    charSequence = text;
                }
                objArr[0] = charSequence;
                accessibilityNodeInfo.setContentDescription(context.getString(R.string.mtrl_chip_close_icon_content_description, objArr).trim());
            }
            accessibilityNodeInfo.setBoundsInParent(chip.getCloseIconTouchBoundsInt());
            iVar.b(g.f10903e);
            accessibilityNodeInfo.setEnabled(chip.isEnabled());
            return;
        }
        accessibilityNodeInfo.setContentDescription(charSequence);
        accessibilityNodeInfo.setBoundsInParent(Chip.D);
    }

    public final boolean p(int i10) {
        int i11;
        View view = this.f5951i;
        if ((view.isFocused() || view.requestFocus()) && (i11 = this.f5954l) != i10) {
            if (i11 != Integer.MIN_VALUE) {
                j(i11);
            }
            if (i10 != Integer.MIN_VALUE) {
                this.f5954l = i10;
                if (i10 == 1) {
                    Chip chip = this.f5956n;
                    chip.f3727t = true;
                    chip.refreshDrawableState();
                }
                q(i10, 8);
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = r5.f5951i;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(int r6, int r7) {
        /*
            r5 = this;
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r6 == r0) goto L_0x008b
            android.view.accessibility.AccessibilityManager r0 = r5.f5950h
            boolean r0 = r0.isEnabled()
            if (r0 != 0) goto L_0x000e
            goto L_0x008b
        L_0x000e:
            android.view.View r0 = r5.f5951i
            android.view.ViewParent r1 = r0.getParent()
            if (r1 != 0) goto L_0x0017
            goto L_0x008b
        L_0x0017:
            r2 = -1
            if (r6 == r2) goto L_0x0081
            android.view.accessibility.AccessibilityEvent r7 = android.view.accessibility.AccessibilityEvent.obtain(r7)
            n0.i r2 = r5.n(r6)
            java.util.List r3 = r7.getText()
            java.lang.CharSequence r4 = r2.f()
            r3.add(r4)
            android.view.accessibility.AccessibilityNodeInfo r2 = r2.f10916a
            java.lang.CharSequence r3 = r2.getContentDescription()
            r7.setContentDescription(r3)
            boolean r3 = r2.isScrollable()
            r7.setScrollable(r3)
            boolean r3 = r2.isPassword()
            r7.setPassword(r3)
            boolean r3 = r2.isEnabled()
            r7.setEnabled(r3)
            boolean r3 = r2.isChecked()
            r7.setChecked(r3)
            java.util.List r3 = r7.getText()
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x006b
            java.lang.CharSequence r3 = r7.getContentDescription()
            if (r3 == 0) goto L_0x0063
            goto L_0x006b
        L_0x0063:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r7 = "Callbacks must add text or a content description in populateEventForVirtualViewId()"
            r6.<init>(r7)
            throw r6
        L_0x006b:
            java.lang.CharSequence r2 = r2.getClassName()
            r7.setClassName(r2)
            n0.o.a(r7, r0, r6)
            android.content.Context r6 = r0.getContext()
            java.lang.String r6 = r6.getPackageName()
            r7.setPackageName(r6)
            goto L_0x0088
        L_0x0081:
            android.view.accessibility.AccessibilityEvent r7 = android.view.accessibility.AccessibilityEvent.obtain(r7)
            r0.onInitializeAccessibilityEvent(r7)
        L_0x0088:
            r1.requestSendAccessibilityEvent(r0, r7)
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f8.d.q(int, int):void");
    }
}
