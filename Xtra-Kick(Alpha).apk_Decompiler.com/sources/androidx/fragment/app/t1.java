package androidx.fragment.app;

import android.transition.Transition;
import java.util.ArrayList;

public final class t1 implements Transition.TransitionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f1580a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1581b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f1582c = null;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1583d = null;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f1584e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1585f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ v1 f1586g;

    public t1(v1 v1Var, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        this.f1586g = v1Var;
        this.f1580a = obj;
        this.f1581b = arrayList;
        this.f1584e = obj2;
        this.f1585f = arrayList2;
    }

    public final void onTransitionCancel(Transition transition) {
    }

    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    public final void onTransitionPause(Transition transition) {
    }

    public final void onTransitionResume(Transition transition) {
    }

    public final void onTransitionStart(Transition transition) {
        v1 v1Var = this.f1586g;
        Object obj = this.f1580a;
        if (obj != null) {
            v1Var.t(obj, this.f1581b, (ArrayList) null);
        }
        Object obj2 = this.f1582c;
        if (obj2 != null) {
            v1Var.t(obj2, this.f1583d, (ArrayList) null);
        }
        Object obj3 = this.f1584e;
        if (obj3 != null) {
            v1Var.t(obj3, this.f1585f, (ArrayList) null);
        }
    }
}
