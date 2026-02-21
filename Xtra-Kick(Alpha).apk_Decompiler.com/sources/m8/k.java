package m8;

import android.animation.ValueAnimator;
import android.support.v4.media.session.g0;
import androidx.appcompat.widget.d;
import java.util.ArrayList;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f10768a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public ValueAnimator f10769b = null;

    /* renamed from: c  reason: collision with root package name */
    public final d f10770c = new d(6, this);

    public final void a(int[] iArr, ValueAnimator valueAnimator) {
        g0 g0Var = new g0(iArr, valueAnimator);
        valueAnimator.addListener(this.f10770c);
        this.f10768a.add(g0Var);
    }
}
