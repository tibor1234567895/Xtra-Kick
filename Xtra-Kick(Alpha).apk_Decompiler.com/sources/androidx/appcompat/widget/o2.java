package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.activity.h;
import com.woxthebox.draglistview.R;
import java.lang.reflect.InvocationTargetException;
import q0.i;

public class o2 extends ListView {

    /* renamed from: h  reason: collision with root package name */
    public final Rect f973h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    public int f974i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f975j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f976k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f977l = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f978m;

    /* renamed from: n  reason: collision with root package name */
    public m2 f979n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f980o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f981p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f982q;

    /* renamed from: r  reason: collision with root package name */
    public i f983r;

    /* renamed from: s  reason: collision with root package name */
    public h f984s;

    public o2(Context context, boolean z10) {
        super(context, (AttributeSet) null, R.attr.dropDownListViewStyle);
        this.f981p = z10;
        setCacheColorHint(0);
    }

    public final int a(int i10, int i11) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        int i12 = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return i12;
        }
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i13 = 0;
        for (int i14 = 0; i14 < count; i14++) {
            int itemViewType = adapter.getItemViewType(i14);
            if (itemViewType != i13) {
                view = null;
                i13 = itemViewType;
            }
            view = adapter.getView(i14, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i15 = layoutParams.height;
            view.measure(i10, i15 > 0 ? View.MeasureSpec.makeMeasureSpec(i15, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i14 > 0) {
                i12 += dividerHeight;
            }
            i12 += view.getMeasuredHeight();
            if (i12 >= i11) {
                return i11;
            }
        }
        return i12;
    }

    /* JADX WARNING: Removed duplicated region for block: B:80:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0177  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(android.view.MotionEvent r17, int r18) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            int r3 = r17.getActionMasked()
            r4 = 1
            r5 = 0
            if (r3 == r4) goto L_0x0017
            r0 = 2
            if (r3 == r0) goto L_0x0015
            r0 = 3
            if (r3 == r0) goto L_0x001e
            r0 = 1
            goto L_0x0143
        L_0x0015:
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            int r6 = r17.findPointerIndex(r18)
            if (r6 >= 0) goto L_0x0021
        L_0x001e:
            r0 = 0
            goto L_0x0143
        L_0x0021:
            float r7 = r2.getX(r6)
            int r7 = (int) r7
            float r6 = r2.getY(r6)
            int r6 = (int) r6
            int r8 = r1.pointToPosition(r7, r6)
            r9 = -1
            if (r8 != r9) goto L_0x0035
            r5 = 1
            goto L_0x0143
        L_0x0035:
            int r0 = r16.getFirstVisiblePosition()
            int r0 = r8 - r0
            android.view.View r10 = r1.getChildAt(r0)
            float r7 = (float) r7
            float r6 = (float) r6
            r1.f982q = r4
            androidx.appcompat.widget.j2.a(r1, r7, r6)
            boolean r0 = r16.isPressed()
            if (r0 != 0) goto L_0x004f
            r1.setPressed(r4)
        L_0x004f:
            r16.layoutChildren()
            int r0 = r1.f978m
            if (r0 == r9) goto L_0x006c
            int r11 = r16.getFirstVisiblePosition()
            int r0 = r0 - r11
            android.view.View r0 = r1.getChildAt(r0)
            if (r0 == 0) goto L_0x006c
            if (r0 == r10) goto L_0x006c
            boolean r11 = r0.isPressed()
            if (r11 == 0) goto L_0x006c
            r0.setPressed(r5)
        L_0x006c:
            r1.f978m = r8
            int r0 = r10.getLeft()
            float r0 = (float) r0
            float r0 = r7 - r0
            int r11 = r10.getTop()
            float r11 = (float) r11
            float r11 = r6 - r11
            androidx.appcompat.widget.j2.a(r10, r0, r11)
            boolean r0 = r10.isPressed()
            if (r0 != 0) goto L_0x0088
            r10.setPressed(r4)
        L_0x0088:
            android.graphics.drawable.Drawable r11 = r16.getSelector()
            if (r11 == 0) goto L_0x0092
            if (r8 == r9) goto L_0x0092
            r12 = 1
            goto L_0x0093
        L_0x0092:
            r12 = 0
        L_0x0093:
            if (r12 == 0) goto L_0x0098
            r11.setVisible(r5, r5)
        L_0x0098:
            int r0 = r10.getLeft()
            int r13 = r10.getTop()
            int r14 = r10.getRight()
            int r15 = r10.getBottom()
            android.graphics.Rect r5 = r1.f973h
            r5.set(r0, r13, r14, r15)
            int r0 = r5.left
            int r13 = r1.f974i
            int r0 = r0 - r13
            r5.left = r0
            int r0 = r5.top
            int r13 = r1.f975j
            int r0 = r0 - r13
            r5.top = r0
            int r0 = r5.right
            int r13 = r1.f976k
            int r0 = r0 + r13
            r5.right = r0
            int r0 = r5.bottom
            int r13 = r1.f977l
            int r0 = r0 + r13
            r5.bottom = r0
            boolean r0 = i0.b.a()
            if (r0 == 0) goto L_0x00d4
            boolean r0 = androidx.appcompat.widget.l2.a(r16)
            goto L_0x00e3
        L_0x00d4:
            java.lang.reflect.Field r0 = androidx.appcompat.widget.n2.f968a
            if (r0 == 0) goto L_0x00e2
            boolean r0 = r0.getBoolean(r1)     // Catch:{ IllegalAccessException -> 0x00dd }
            goto L_0x00e3
        L_0x00dd:
            r0 = move-exception
            r13 = r0
            r13.printStackTrace()
        L_0x00e2:
            r0 = 0
        L_0x00e3:
            boolean r13 = r10.isEnabled()
            if (r13 == r0) goto L_0x0109
            r0 = r0 ^ r4
            boolean r13 = i0.b.a()
            if (r13 == 0) goto L_0x00f4
            androidx.appcompat.widget.l2.b(r1, r0)
            goto L_0x0104
        L_0x00f4:
            java.lang.reflect.Field r13 = androidx.appcompat.widget.n2.f968a
            if (r13 == 0) goto L_0x0104
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ IllegalAccessException -> 0x0100 }
            r13.set(r1, r0)     // Catch:{ IllegalAccessException -> 0x0100 }
            goto L_0x0104
        L_0x0100:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0104:
            if (r8 == r9) goto L_0x0109
            r16.refreshDrawableState()
        L_0x0109:
            if (r12 == 0) goto L_0x0123
            float r0 = r5.exactCenterX()
            float r5 = r5.exactCenterY()
            int r12 = r16.getVisibility()
            if (r12 != 0) goto L_0x011b
            r12 = 1
            goto L_0x011c
        L_0x011b:
            r12 = 0
        L_0x011c:
            r13 = 0
            r11.setVisible(r12, r13)
            f0.b.e(r11, r0, r5)
        L_0x0123:
            android.graphics.drawable.Drawable r0 = r16.getSelector()
            if (r0 == 0) goto L_0x012e
            if (r8 == r9) goto L_0x012e
            f0.b.e(r0, r7, r6)
        L_0x012e:
            androidx.appcompat.widget.m2 r0 = r1.f979n
            if (r0 == 0) goto L_0x0135
            r5 = 0
            r0.f931i = r5
        L_0x0135:
            r16.refreshDrawableState()
            if (r3 != r4) goto L_0x0141
            long r5 = r1.getItemIdAtPosition(r8)
            r1.performItemClick(r10, r8, r5)
        L_0x0141:
            r0 = 1
            r5 = 0
        L_0x0143:
            if (r0 == 0) goto L_0x0147
            if (r5 == 0) goto L_0x0160
        L_0x0147:
            r3 = 0
            r1.f982q = r3
            r1.setPressed(r3)
            r16.drawableStateChanged()
            int r5 = r1.f978m
            int r6 = r16.getFirstVisiblePosition()
            int r5 = r5 - r6
            android.view.View r5 = r1.getChildAt(r5)
            if (r5 == 0) goto L_0x0160
            r5.setPressed(r3)
        L_0x0160:
            if (r0 == 0) goto L_0x0177
            q0.i r3 = r1.f983r
            if (r3 != 0) goto L_0x016d
            q0.i r3 = new q0.i
            r3.<init>(r1)
            r1.f983r = r3
        L_0x016d:
            q0.i r3 = r1.f983r
            boolean r5 = r3.f13117w
            r3.f13117w = r4
            r3.d(r1, r2)
            goto L_0x0185
        L_0x0177:
            q0.i r2 = r1.f983r
            if (r2 == 0) goto L_0x0185
            boolean r3 = r2.f13117w
            if (r3 == 0) goto L_0x0182
            r2.e()
        L_0x0182:
            r3 = 0
            r2.f13117w = r3
        L_0x0185:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.o2.b(android.view.MotionEvent, int):boolean");
    }

    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f973h;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    public final void drawableStateChanged() {
        if (this.f984s == null) {
            super.drawableStateChanged();
            m2 m2Var = this.f979n;
            if (m2Var != null) {
                m2Var.f931i = true;
            }
            Drawable selector = getSelector();
            if (selector != null && this.f982q && isPressed()) {
                selector.setState(getDrawableState());
            }
        }
    }

    public final boolean hasFocus() {
        return this.f981p || super.hasFocus();
    }

    public final boolean hasWindowFocus() {
        return this.f981p || super.hasWindowFocus();
    }

    public final boolean isFocused() {
        return this.f981p || super.isFocused();
    }

    public final boolean isInTouchMode() {
        return (this.f981p && this.f980o) || super.isInTouchMode();
    }

    public final void onDetachedFromWindow() {
        this.f984s = null;
        super.onDetachedFromWindow();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f984s == null) {
            h hVar = new h(2, this);
            this.f984s = hVar;
            post(hVar);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i10 < 30 || !k2.f912d) {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    } else {
                        try {
                            k2.f909a.invoke(this, new Object[]{Integer.valueOf(pointToPosition), childAt, Boolean.FALSE, -1, -1});
                            k2.f910b.invoke(this, new Object[]{Integer.valueOf(pointToPosition)});
                            k2.f911c.invoke(this, new Object[]{Integer.valueOf(pointToPosition)});
                        } catch (IllegalAccessException | InvocationTargetException e10) {
                            e10.printStackTrace();
                        }
                    }
                }
                Drawable selector = getSelector();
                if (selector != null && this.f982q && isPressed()) {
                    selector.setState(getDrawableState());
                }
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f978m = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        h hVar = this.f984s;
        if (hVar != null) {
            o2 o2Var = (o2) hVar.f484i;
            o2Var.f984s = null;
            o2Var.removeCallbacks(hVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z10) {
        this.f980o = z10;
    }

    public void setSelector(Drawable drawable) {
        m2 m2Var = drawable != null ? new m2(drawable) : null;
        this.f979n = m2Var;
        super.setSelector(m2Var);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f974i = rect.left;
        this.f975j = rect.top;
        this.f976k = rect.right;
        this.f977l = rect.bottom;
    }
}
