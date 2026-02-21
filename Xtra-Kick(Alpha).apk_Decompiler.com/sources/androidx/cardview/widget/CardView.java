package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.media.n;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.woxthebox.draglistview.R;
import p.a;

public class CardView extends FrameLayout {

    /* renamed from: m  reason: collision with root package name */
    public static final int[] f1155m = {16842801};

    /* renamed from: n  reason: collision with root package name */
    public static final a f1156n = new a();

    /* renamed from: h  reason: collision with root package name */
    public boolean f1157h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1158i;

    /* renamed from: j  reason: collision with root package name */
    public final Rect f1159j;

    /* renamed from: k  reason: collision with root package name */
    public final Rect f1160k = new Rect();

    /* renamed from: l  reason: collision with root package name */
    public final n f1161l;

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.cardViewStyle);
        ColorStateList colorStateList;
        Resources resources;
        int i10;
        Rect rect = new Rect();
        this.f1159j = rect;
        n nVar = new n(this);
        this.f1161l = nVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f12401a, R.attr.cardViewStyle, R.style.CardView);
        if (obtainStyledAttributes.hasValue(2)) {
            colorStateList = obtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f1155m);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                resources = getResources();
                i10 = R.color.cardview_light_background;
            } else {
                resources = getResources();
                i10 = R.color.cardview_dark_background;
            }
            colorStateList = ColorStateList.valueOf(resources.getColor(i10));
        }
        float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(5, 0.0f);
        this.f1157h = obtainStyledAttributes.getBoolean(7, false);
        this.f1158i = obtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        a aVar = f1156n;
        aVar.getClass();
        RoundRectDrawable roundRectDrawable = new RoundRectDrawable(colorStateList, dimension);
        nVar.f337i = roundRectDrawable;
        ((CardView) nVar.f338j).setBackgroundDrawable(roundRectDrawable);
        CardView cardView = (CardView) nVar.f338j;
        cardView.setClipToOutline(true);
        cardView.setElevation(dimension2);
        aVar.a(nVar, dimension3);
    }

    public ColorStateList getCardBackgroundColor() {
        f1156n.getClass();
        return ((RoundRectDrawable) ((Drawable) this.f1161l.f337i)).getColor();
    }

    public float getCardElevation() {
        f1156n.getClass();
        return ((CardView) this.f1161l.f338j).getElevation();
    }

    public int getContentPaddingBottom() {
        return this.f1159j.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f1159j.left;
    }

    public int getContentPaddingRight() {
        return this.f1159j.right;
    }

    public int getContentPaddingTop() {
        return this.f1159j.top;
    }

    public float getMaxCardElevation() {
        f1156n.getClass();
        return ((RoundRectDrawable) ((Drawable) this.f1161l.f337i)).getPadding();
    }

    public boolean getPreventCornerOverlap() {
        return this.f1158i;
    }

    public float getRadius() {
        f1156n.getClass();
        return ((RoundRectDrawable) ((Drawable) this.f1161l.f337i)).getRadius();
    }

    public boolean getUseCompatPadding() {
        return this.f1157h;
    }

    public final void onMeasure(int i10, int i11) {
        a aVar = f1156n;
        if (!(aVar instanceof a)) {
            int mode = View.MeasureSpec.getMode(i10);
            n nVar = this.f1161l;
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                aVar.getClass();
                i10 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) (((RoundRectDrawable) ((Drawable) nVar.f337i)).getRadius() * 2.0f)), View.MeasureSpec.getSize(i10)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i11);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                aVar.getClass();
                i11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) (((RoundRectDrawable) ((Drawable) nVar.f337i)).getRadius() * 2.0f)), View.MeasureSpec.getSize(i11)), mode2);
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setCardBackgroundColor(int i10) {
        ColorStateList valueOf = ColorStateList.valueOf(i10);
        f1156n.getClass();
        ((RoundRectDrawable) ((Drawable) this.f1161l.f337i)).setColor(valueOf);
    }

    public void setCardElevation(float f10) {
        f1156n.getClass();
        ((CardView) this.f1161l.f338j).setElevation(f10);
    }

    public void setMaxCardElevation(float f10) {
        f1156n.a(this.f1161l, f10);
    }

    public void setMinimumHeight(int i10) {
        super.setMinimumHeight(i10);
    }

    public void setMinimumWidth(int i10) {
        super.setMinimumWidth(i10);
    }

    public final void setPadding(int i10, int i11, int i12, int i13) {
    }

    public final void setPaddingRelative(int i10, int i11, int i12, int i13) {
    }

    public void setPreventCornerOverlap(boolean z10) {
        if (z10 != this.f1158i) {
            this.f1158i = z10;
            a aVar = f1156n;
            aVar.getClass();
            n nVar = this.f1161l;
            aVar.a(nVar, ((RoundRectDrawable) ((Drawable) nVar.f337i)).getPadding());
        }
    }

    public void setRadius(float f10) {
        f1156n.getClass();
        ((RoundRectDrawable) ((Drawable) this.f1161l.f337i)).setRadius(f10);
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f1157h != z10) {
            this.f1157h = z10;
            a aVar = f1156n;
            aVar.getClass();
            n nVar = this.f1161l;
            aVar.a(nVar, ((RoundRectDrawable) ((Drawable) nVar.f337i)).getPadding());
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f1156n.getClass();
        ((RoundRectDrawable) ((Drawable) this.f1161l.f337i)).setColor(colorStateList);
    }
}
