package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import b4.e0;
import com.bumptech.glide.c;
import com.bumptech.glide.s;
import java.util.HashSet;

public final class q extends Fragment {

    /* renamed from: h  reason: collision with root package name */
    public final a f3270h;

    /* renamed from: i  reason: collision with root package name */
    public final e0 f3271i = new e0(13, this);

    /* renamed from: j  reason: collision with root package name */
    public final HashSet f3272j = new HashSet();

    /* renamed from: k  reason: collision with root package name */
    public s f3273k;

    /* renamed from: l  reason: collision with root package name */
    public q f3274l;

    /* renamed from: m  reason: collision with root package name */
    public Fragment f3275m;

    public q() {
        a aVar = new a();
        this.f3270h = aVar;
    }

    public final void a(Activity activity) {
        q qVar = this.f3274l;
        if (qVar != null) {
            qVar.f3272j.remove(this);
            this.f3274l = null;
        }
        t tVar = c.a(activity).f3168l;
        tVar.getClass();
        q d10 = tVar.d(activity.getFragmentManager());
        this.f3274l = d10;
        if (!equals(d10)) {
            this.f3274l.f3272j.add(this);
        }
    }

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException e10) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e10);
            }
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f3270h.a();
        q qVar = this.f3274l;
        if (qVar != null) {
            qVar.f3272j.remove(this);
            this.f3274l = null;
        }
    }

    public final void onDetach() {
        super.onDetach();
        q qVar = this.f3274l;
        if (qVar != null) {
            qVar.f3272j.remove(this);
            this.f3274l = null;
        }
    }

    public final void onStart() {
        super.onStart();
        this.f3270h.b();
    }

    public final void onStop() {
        super.onStop();
        this.f3270h.d();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.f3275m;
        }
        sb2.append(parentFragment);
        sb2.append("}");
        return sb2.toString();
    }
}
