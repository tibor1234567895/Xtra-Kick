package c4;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import l8.a;

public final class e extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2882a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final Object f2883b;

    public e(Drawable.ConstantState constantState) {
        this.f2883b = constantState;
    }

    public final boolean canApplyTheme() {
        switch (this.f2882a) {
            case 0:
                return ((Drawable.ConstantState) this.f2883b).canApplyTheme();
            default:
                return super.canApplyTheme();
        }
    }

    public final int getChangingConfigurations() {
        switch (this.f2882a) {
            case 0:
                return ((Drawable.ConstantState) this.f2883b).getChangingConfigurations();
            default:
                return 0;
        }
    }

    public final Drawable newDrawable() {
        int i10 = this.f2882a;
        Object obj = this.f2883b;
        switch (i10) {
            case 0:
                f fVar = new f();
                Drawable newDrawable = ((Drawable.ConstantState) obj).newDrawable();
                fVar.f2892h = newDrawable;
                newDrawable.setCallback(fVar.f2889m);
                return fVar;
            default:
                return (a) obj;
        }
    }

    public e(a aVar) {
        this.f2883b = aVar;
    }

    public /* synthetic */ e(a aVar, int i10) {
        this(aVar);
    }

    public final Drawable newDrawable(Resources resources) {
        switch (this.f2882a) {
            case 0:
                f fVar = new f();
                Drawable newDrawable = ((Drawable.ConstantState) this.f2883b).newDrawable(resources);
                fVar.f2892h = newDrawable;
                newDrawable.setCallback(fVar.f2889m);
                return fVar;
            default:
                return super.newDrawable(resources);
        }
    }

    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        switch (this.f2882a) {
            case 0:
                f fVar = new f();
                Drawable newDrawable = ((Drawable.ConstantState) this.f2883b).newDrawable(resources, theme);
                fVar.f2892h = newDrawable;
                newDrawable.setCallback(fVar.f2889m);
                return fVar;
            default:
                return super.newDrawable(resources, theme);
        }
    }
}
