package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

public class o0 extends ImageView {

    /* renamed from: h  reason: collision with root package name */
    public final b0 f970h;

    /* renamed from: i  reason: collision with root package name */
    public final n0 f971i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f972j = false;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        r4.a(context);
        q4.a(getContext(), this);
        b0 b0Var = new b0(this);
        this.f970h = b0Var;
        b0Var.e(attributeSet, i10);
        n0 n0Var = new n0(this);
        this.f971i = n0Var;
        n0Var.d(attributeSet, i10);
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        b0 b0Var = this.f970h;
        if (b0Var != null) {
            b0Var.a();
        }
        n0 n0Var = this.f971i;
        if (n0Var != null) {
            n0Var.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        b0 b0Var = this.f970h;
        if (b0Var != null) {
            return b0Var.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        b0 b0Var = this.f970h;
        if (b0Var != null) {
            return b0Var.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        s4 s4Var;
        n0 n0Var = this.f971i;
        if (n0Var == null || (s4Var = (s4) n0Var.f966d) == null) {
            return null;
        }
        return s4Var.f1055a;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        s4 s4Var;
        n0 n0Var = this.f971i;
        if (n0Var == null || (s4Var = (s4) n0Var.f966d) == null) {
            return null;
        }
        return s4Var.f1056b;
    }

    public final boolean hasOverlappingRendering() {
        if (!(!(((ImageView) this.f971i.f964b).getBackground() instanceof RippleDrawable)) || !super.hasOverlappingRendering()) {
            return false;
        }
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        b0 b0Var = this.f970h;
        if (b0Var != null) {
            b0Var.f();
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        b0 b0Var = this.f970h;
        if (b0Var != null) {
            b0Var.g(i10);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        n0 n0Var = this.f971i;
        if (n0Var != null) {
            n0Var.b();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        n0 n0Var = this.f971i;
        if (!(n0Var == null || drawable == null || this.f972j)) {
            n0Var.f963a = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (n0Var != null) {
            n0Var.b();
            if (!this.f972j) {
                ImageView imageView = (ImageView) n0Var.f964b;
                if (imageView.getDrawable() != null) {
                    imageView.getDrawable().setLevel(n0Var.f963a);
                }
            }
        }
    }

    public void setImageLevel(int i10) {
        super.setImageLevel(i10);
        this.f972j = true;
    }

    public void setImageResource(int i10) {
        n0 n0Var = this.f971i;
        if (n0Var != null) {
            n0Var.e(i10);
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        n0 n0Var = this.f971i;
        if (n0Var != null) {
            n0Var.b();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        b0 b0Var = this.f970h;
        if (b0Var != null) {
            b0Var.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        b0 b0Var = this.f970h;
        if (b0Var != null) {
            b0Var.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        n0 n0Var = this.f971i;
        if (n0Var != null) {
            n0Var.f(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        n0 n0Var = this.f971i;
        if (n0Var != null) {
            n0Var.g(mode);
        }
    }
}
