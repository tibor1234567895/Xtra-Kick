package b4;

import android.support.v4.media.h;
import android.view.ViewGroup;
import com.woxthebox.draglistview.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import m0.c1;
import m0.l0;
import q.e;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static final a f2609a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal f2610b = new ThreadLocal();

    /* renamed from: c  reason: collision with root package name */
    public static final ArrayList f2611c = new ArrayList();

    public x() {
        new e();
        new e();
    }

    public static void a(ViewGroup viewGroup, u uVar) {
        ArrayList arrayList = f2611c;
        if (!arrayList.contains(viewGroup)) {
            WeakHashMap weakHashMap = c1.f10054a;
            if (l0.c(viewGroup)) {
                arrayList.add(viewGroup);
                if (uVar == null) {
                    uVar = f2609a;
                }
                u j10 = uVar.clone();
                ArrayList arrayList2 = (ArrayList) b().getOrDefault(viewGroup, (Object) null);
                if (arrayList2 != null && arrayList2.size() > 0) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((u) it.next()).u(viewGroup);
                    }
                }
                if (j10 != null) {
                    j10.h(viewGroup, true);
                }
                h.y(viewGroup.getTag(R.id.transition_current_scene));
                viewGroup.setTag(R.id.transition_current_scene, (Object) null);
                if (j10 != null) {
                    w wVar = new w(viewGroup, j10);
                    viewGroup.addOnAttachStateChangeListener(wVar);
                    viewGroup.getViewTreeObserver().addOnPreDrawListener(wVar);
                }
            }
        }
    }

    public static e b() {
        e eVar;
        ThreadLocal threadLocal = f2610b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (eVar = (e) weakReference.get()) != null) {
            return eVar;
        }
        e eVar2 = new e();
        threadLocal.set(new WeakReference(eVar2));
        return eVar2;
    }
}
