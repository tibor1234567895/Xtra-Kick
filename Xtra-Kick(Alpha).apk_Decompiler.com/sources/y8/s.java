package y8;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import e0.a;
import f0.b;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;

public final class s extends ArrayAdapter {

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f17209h;

    /* renamed from: i  reason: collision with root package name */
    public ColorStateList f17210i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ t f17211j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(t tVar, Context context, int i10, String[] strArr) {
        super(context, i10, strArr);
        this.f17211j = tVar;
        a();
    }

    public final void a() {
        boolean z10;
        ColorStateList colorStateList;
        boolean z11;
        boolean z12;
        t tVar = this.f17211j;
        ColorStateList colorStateList2 = tVar.f17218r;
        if (colorStateList2 != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        ColorStateList colorStateList3 = null;
        if (!z10) {
            colorStateList = null;
        } else {
            int[] iArr = {16842919};
            colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
        }
        this.f17210i = colorStateList;
        if (tVar.f17217q != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (tVar.f17218r != null) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                int[] iArr2 = {16843623, -16842919};
                int[] iArr3 = {16842913, -16842919};
                colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{a.b(tVar.f17218r.getColorForState(iArr3, 0), tVar.f17217q), a.b(tVar.f17218r.getColorForState(iArr2, 0), tVar.f17217q), tVar.f17217q});
            }
        }
        this.f17209h = colorStateList3;
    }

    public final View getView(int i10, View view, ViewGroup viewGroup) {
        boolean z10;
        View view2 = super.getView(i10, view, viewGroup);
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            t tVar = this.f17211j;
            RippleDrawable rippleDrawable = null;
            if (tVar.getText().toString().contentEquals(textView.getText())) {
                if (tVar.f17217q != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    ColorDrawable colorDrawable = new ColorDrawable(tVar.f17217q);
                    if (this.f17210i != null) {
                        b.h(colorDrawable, this.f17209h);
                        rippleDrawable = new RippleDrawable(this.f17210i, colorDrawable, (Drawable) null);
                    } else {
                        rippleDrawable = colorDrawable;
                    }
                }
            }
            WeakHashMap weakHashMap = c1.f10054a;
            i0.q(textView, rippleDrawable);
        }
        return view2;
    }
}
