package m0;

import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import b2.n;
import b8.j;
import e0.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class x1 extends WindowInsetsAnimation.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final j f10159a;

    /* renamed from: b  reason: collision with root package name */
    public List f10160b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f10161c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap f10162d = new HashMap();

    public x1(j jVar) {
        super(0);
        this.f10159a = jVar;
    }

    public final a2 a(WindowInsetsAnimation windowInsetsAnimation) {
        a2 a2Var = (a2) this.f10162d.get(windowInsetsAnimation);
        if (a2Var != null) {
            return a2Var;
        }
        a2 a2Var2 = new a2(windowInsetsAnimation);
        this.f10162d.put(windowInsetsAnimation, a2Var2);
        return a2Var2;
    }

    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        j jVar = this.f10159a;
        a(windowInsetsAnimation);
        jVar.f2691b.setTranslationY(0.0f);
        this.f10162d.remove(windowInsetsAnimation);
    }

    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        j jVar = this.f10159a;
        a(windowInsetsAnimation);
        View view = jVar.f2691b;
        int[] iArr = jVar.f2694e;
        view.getLocationOnScreen(iArr);
        jVar.f2692c = iArr[1];
    }

    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        ArrayList arrayList = this.f10161c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.f10161c = arrayList2;
            this.f10160b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        int size = list.size();
        while (true) {
            size--;
            if (size >= 0) {
                WindowInsetsAnimation l10 = n.l(list.get(size));
                a2 a10 = a(l10);
                a10.f10039a.d(l10.getFraction());
                this.f10161c.add(a10);
            } else {
                j jVar = this.f10159a;
                q2 h10 = q2.h((View) null, windowInsets);
                jVar.a(h10, this.f10160b);
                return h10.g();
            }
        }
    }

    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        j jVar = this.f10159a;
        a(windowInsetsAnimation);
        android.support.v4.media.n nVar = new android.support.v4.media.n(bounds);
        View view = jVar.f2691b;
        int[] iArr = jVar.f2694e;
        view.getLocationOnScreen(iArr);
        int i10 = jVar.f2692c - iArr[1];
        jVar.f2693d = i10;
        view.setTranslationY((float) i10);
        n.n();
        return n.j(((d) nVar.f337i).d(), ((d) nVar.f338j).d());
    }
}
