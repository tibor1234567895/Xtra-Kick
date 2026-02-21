package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.media.h;
import b4.u;
import c4.c;
import c4.f;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import java.util.ArrayList;
import m8.k;

public final class d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f785a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f786b;

    public /* synthetic */ d(int i10, Object obj) {
        this.f785a = i10;
        this.f786b = obj;
    }

    public final void onAnimationCancel(Animator animator) {
        switch (this.f785a) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f786b;
                actionBarOverlayLayout.D = null;
                actionBarOverlayLayout.f614r = false;
                return;
            default:
                super.onAnimationCancel(animator);
                return;
        }
    }

    public final void onAnimationEnd(Animator animator) {
        int i10 = this.f785a;
        Object obj = this.f786b;
        switch (i10) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) obj;
                actionBarOverlayLayout.D = null;
                actionBarOverlayLayout.f614r = false;
                return;
            case 1:
                ((u) obj).m();
                animator.removeListener(this);
                return;
            case 2:
                f fVar = (f) obj;
                ArrayList arrayList = new ArrayList(fVar.f2888l);
                int size = arrayList.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((c) arrayList.get(i11)).a(fVar);
                }
                return;
            case 3:
                ((HideBottomViewOnScrollBehavior) obj).f3652h = null;
                return;
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                h.y(obj);
                throw null;
            case 6:
                k kVar = (k) obj;
                if (kVar.f10769b == animator) {
                    kVar.f10769b = null;
                    return;
                }
                return;
            case 7:
                y8.k kVar2 = (y8.k) obj;
                kVar2.q();
                kVar2.f17152r.start();
                return;
            case 8:
                ((ExpandableTransformationBehavior) obj).f3961b = null;
                return;
            default:
                super.onAnimationEnd(animator);
                return;
        }
    }

    public final void onAnimationStart(Animator animator) {
        int i10 = this.f785a;
        Object obj = this.f786b;
        switch (i10) {
            case 2:
                f fVar = (f) obj;
                ArrayList arrayList = new ArrayList(fVar.f2888l);
                int size = arrayList.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((c) arrayList.get(i11)).b(fVar);
                }
                return;
            case 4:
                h.y(obj);
                throw null;
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                h.y(obj);
                throw null;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }
}
