package c4;

import android.animation.AnimatorSet;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import l6.j;
import q.e;

public final class d extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public s f2878a;

    /* renamed from: b  reason: collision with root package name */
    public AnimatorSet f2879b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f2880c;

    /* renamed from: d  reason: collision with root package name */
    public e f2881d;

    public d(j jVar) {
    }

    public final int getChangingConfigurations() {
        return 0;
    }

    public final Drawable newDrawable() {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }

    public final Drawable newDrawable(Resources resources) {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }
}
