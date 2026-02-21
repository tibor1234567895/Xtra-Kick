package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

public final class b0 extends o1 {

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f1939d = {16843284};

    /* renamed from: a  reason: collision with root package name */
    public final Drawable f1940a;

    /* renamed from: b  reason: collision with root package name */
    public int f1941b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f1942c = new Rect();

    public b0(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f1939d);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.f1940a = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        this.f1941b = 1;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, g2 g2Var) {
        Drawable drawable = this.f1940a;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f1941b == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    public final void onDraw(Canvas canvas, RecyclerView recyclerView, g2 g2Var) {
        Drawable drawable;
        int i10;
        int i11;
        int i12;
        int i13;
        if (recyclerView.getLayoutManager() != null && (drawable = this.f1940a) != null) {
            int i14 = this.f1941b;
            int i15 = 0;
            Rect rect = this.f1942c;
            if (i14 == 1) {
                canvas.save();
                if (recyclerView.getClipToPadding()) {
                    i13 = recyclerView.getPaddingLeft();
                    i12 = recyclerView.getWidth() - recyclerView.getPaddingRight();
                    canvas.clipRect(i13, recyclerView.getPaddingTop(), i12, recyclerView.getHeight() - recyclerView.getPaddingBottom());
                } else {
                    i12 = recyclerView.getWidth();
                    i13 = 0;
                }
                int childCount = recyclerView.getChildCount();
                while (i15 < childCount) {
                    View childAt = recyclerView.getChildAt(i15);
                    recyclerView.getDecoratedBoundsWithMargins(childAt, rect);
                    int round = Math.round(childAt.getTranslationY()) + rect.bottom;
                    drawable.setBounds(i13, round - drawable.getIntrinsicHeight(), i12, round);
                    drawable.draw(canvas);
                    i15++;
                }
                canvas.restore();
                return;
            }
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                i11 = recyclerView.getPaddingTop();
                i10 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                canvas.clipRect(recyclerView.getPaddingLeft(), i11, recyclerView.getWidth() - recyclerView.getPaddingRight(), i10);
            } else {
                i10 = recyclerView.getHeight();
                i11 = 0;
            }
            int childCount2 = recyclerView.getChildCount();
            while (i15 < childCount2) {
                View childAt2 = recyclerView.getChildAt(i15);
                recyclerView.getLayoutManager().K(childAt2, rect);
                int round2 = Math.round(childAt2.getTranslationX()) + rect.right;
                drawable.setBounds(round2 - drawable.getIntrinsicWidth(), i11, round2, i10);
                drawable.draw(canvas);
                i15++;
            }
            canvas.restore();
        }
    }
}
