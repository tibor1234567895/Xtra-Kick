package androidx.fragment.app;

import android.transition.Transition;
import android.view.View;
import java.util.ArrayList;

public final class s1 implements Transition.TransitionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f1561a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1562b;

    public s1(View view, ArrayList arrayList) {
        this.f1561a = view;
        this.f1562b = arrayList;
    }

    public final void onTransitionCancel(Transition transition) {
    }

    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
        this.f1561a.setVisibility(8);
        ArrayList arrayList = this.f1562b;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((View) arrayList.get(i10)).setVisibility(0);
        }
    }

    public final void onTransitionPause(Transition transition) {
    }

    public final void onTransitionResume(Transition transition) {
    }

    public final void onTransitionStart(Transition transition) {
        transition.removeListener(this);
        transition.addListener(this);
    }
}
