package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.b0;
import androidx.fragment.app.c0;
import androidx.fragment.app.c1;
import androidx.fragment.app.m0;
import androidx.fragment.app.m1;
import androidx.lifecycle.g0;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.k2;
import androidx.viewpager2.widget.ViewPager2;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import m0.j0;
import m0.l0;
import q.a;
import q.f;
import q.i;

public abstract class g extends g1 implements i {

    /* renamed from: a  reason: collision with root package name */
    public final t f2304a;

    /* renamed from: b  reason: collision with root package name */
    public final c1 f2305b;

    /* renamed from: c  reason: collision with root package name */
    public final i f2306c = new i();

    /* renamed from: d  reason: collision with root package name */
    public final i f2307d = new i();

    /* renamed from: e  reason: collision with root package name */
    public final i f2308e = new i();

    /* renamed from: f  reason: collision with root package name */
    public f f2309f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2310g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2311h = false;

    public g(c0 c0Var) {
        c1 u10 = c0Var.u();
        g0 g0Var = c0Var.V;
        this.f2305b = u10;
        this.f2304a = g0Var;
        super.setHasStableIds(true);
    }

    public static void a(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        } else if (view.getParent() != frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
        }
    }

    public final boolean b(long j10) {
        return j10 >= 0 && j10 < ((long) getItemCount());
    }

    public abstract c0 c(int i10);

    public final void d() {
        i iVar;
        i iVar2;
        boolean z10;
        c0 c0Var;
        View view;
        if (this.f2311h && !this.f2305b.N()) {
            f fVar = new f();
            int i10 = 0;
            while (true) {
                iVar = this.f2306c;
                int i11 = iVar.i();
                iVar2 = this.f2308e;
                if (i10 >= i11) {
                    break;
                }
                long f10 = iVar.f(i10);
                if (!b(f10)) {
                    fVar.add(Long.valueOf(f10));
                    iVar2.h(f10);
                }
                i10++;
            }
            if (!this.f2310g) {
                this.f2311h = false;
                for (int i12 = 0; i12 < iVar.i(); i12++) {
                    long f11 = iVar.f(i12);
                    if (iVar2.f13066h) {
                        iVar2.d();
                    }
                    boolean z11 = true;
                    if (q.g.b(iVar2.f13067i, iVar2.f13069k, f11) >= 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z10 && ((c0Var = (c0) iVar.e(f11, (Long) null)) == null || (view = c0Var.M) == null || view.getParent() == null)) {
                        z11 = false;
                    }
                    if (!z11) {
                        fVar.add(Long.valueOf(f11));
                    }
                }
            }
            a aVar = new a(fVar);
            while (aVar.hasNext()) {
                g(((Long) aVar.next()).longValue());
            }
        }
    }

    public final Long e(int i10) {
        Long l10 = null;
        int i11 = 0;
        while (true) {
            i iVar = this.f2308e;
            if (i11 >= iVar.i()) {
                return l10;
            }
            if (((Integer) iVar.j(i11)).intValue() == i10) {
                if (l10 == null) {
                    l10 = Long.valueOf(iVar.f(i11));
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
            i11++;
        }
    }

    public final void f(h hVar) {
        c0 c0Var = (c0) this.f2306c.e(hVar.getItemId(), (Long) null);
        if (c0Var != null) {
            FrameLayout frameLayout = (FrameLayout) hVar.itemView;
            View view = c0Var.M;
            if (c0Var.F() || view == null) {
                boolean F = c0Var.F();
                c1 c1Var = this.f2305b;
                if (F && view == null) {
                    ((CopyOnWriteArrayList) c1Var.f1384n.f1511a).add(new m0(new b(this, c0Var, frameLayout), false));
                } else if (!c0Var.F() || view.getParent() == null) {
                    if (c0Var.F()) {
                        a(view, frameLayout);
                    } else if (!c1Var.N()) {
                        ((CopyOnWriteArrayList) c1Var.f1384n.f1511a).add(new m0(new b(this, c0Var, frameLayout), false));
                        c1Var.getClass();
                        androidx.fragment.app.a aVar = new androidx.fragment.app.a(c1Var);
                        aVar.d(0, c0Var, "f" + hVar.getItemId(), 1);
                        aVar.l(c0Var, s.STARTED);
                        aVar.i();
                        this.f2309f.b(false);
                    } else if (!c1Var.I) {
                        this.f2304a.a(new FragmentStateAdapter$2(this, hVar));
                    }
                } else if (view.getParent() != frameLayout) {
                    a(view, frameLayout);
                }
            } else {
                throw new IllegalStateException("Design assumption violated.");
            }
        } else {
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    public final void g(long j10) {
        ViewParent parent;
        i iVar = this.f2306c;
        b0 b0Var = null;
        c0 c0Var = (c0) iVar.e(j10, (Long) null);
        if (c0Var != null) {
            View view = c0Var.M;
            if (!(view == null || (parent = view.getParent()) == null)) {
                ((FrameLayout) parent).removeAllViews();
            }
            boolean b10 = b(j10);
            i iVar2 = this.f2307d;
            if (!b10) {
                iVar2.h(j10);
            }
            if (!c0Var.F()) {
                iVar.h(j10);
                return;
            }
            c1 c1Var = this.f2305b;
            if (c1Var.N()) {
                this.f2311h = true;
                return;
            }
            if (c0Var.F() && b(j10)) {
                c1Var.getClass();
                m1 m1Var = (m1) c1Var.f1373c.f1514b.get(c0Var.f1356l);
                if (m1Var != null) {
                    c0 c0Var2 = m1Var.f1502c;
                    if (c0Var2.equals(c0Var)) {
                        if (c0Var2.f1352h > -1) {
                            b0Var = new b0(m1Var.o());
                        }
                        iVar2.g(j10, b0Var);
                    }
                }
                c1Var.e0(new IllegalStateException(h.l("Fragment ", c0Var, " is not currently in the FragmentManager")));
                throw null;
            }
            c1Var.getClass();
            androidx.fragment.app.a aVar = new androidx.fragment.app.a(c1Var);
            aVar.k(c0Var);
            aVar.i();
            iVar.h(j10);
        }
    }

    public final long getItemId(int i10) {
        return (long) i10;
    }

    public final void h(Parcelable parcelable) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        i iVar = this.f2307d;
        boolean z14 = false;
        if (iVar.i() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i iVar2 = this.f2306c;
            if (iVar2.i() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                Bundle bundle = (Bundle) parcelable;
                if (bundle.getClassLoader() == null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                }
                for (String next : bundle.keySet()) {
                    if (!next.startsWith("f#") || next.length() <= 2) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    if (z12) {
                        long parseLong = Long.parseLong(next.substring(2));
                        c1 c1Var = this.f2305b;
                        c1Var.getClass();
                        String string = bundle.getString(next);
                        c0 c0Var = null;
                        if (string != null) {
                            c0 B = c1Var.B(string);
                            if (B != null) {
                                c0Var = B;
                            } else {
                                c1Var.e0(new IllegalStateException("Fragment no longer exists for key " + next + ": unique id " + string));
                                throw null;
                            }
                        }
                        iVar2.g(parseLong, c0Var);
                    } else {
                        if (!next.startsWith("s#") || next.length() <= 2) {
                            z13 = false;
                        } else {
                            z13 = true;
                        }
                        if (z13) {
                            long parseLong2 = Long.parseLong(next.substring(2));
                            b0 b0Var = (b0) bundle.getParcelable(next);
                            if (b(parseLong2)) {
                                iVar.g(parseLong2, b0Var);
                            }
                        } else {
                            throw new IllegalArgumentException("Unexpected key in savedState: ".concat(next));
                        }
                    }
                }
                if (iVar2.i() == 0) {
                    z14 = true;
                }
                if (!z14) {
                    this.f2311h = true;
                    this.f2310g = true;
                    d();
                    Handler handler = new Handler(Looper.getMainLooper());
                    androidx.activity.h hVar = new androidx.activity.h(13, this);
                    this.f2304a.a(new FragmentStateAdapter$5(handler, hVar));
                    handler.postDelayed(hVar, 10000);
                    return;
                }
                return;
            }
        }
        throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
    }

    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        boolean z10;
        if (this.f2309f == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            f fVar = new f(this);
            this.f2309f = fVar;
            fVar.f2301d = f.a(recyclerView);
            d dVar = new d(0, fVar);
            fVar.f2298a = dVar;
            ((List) fVar.f2301d.f2315j.f2296b).add(dVar);
            e eVar = new e(fVar);
            fVar.f2299b = eVar;
            registerAdapterDataObserver(eVar);
            FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3 fragmentStateAdapter$FragmentMaxLifecycleEnforcer$3 = new FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3(fVar);
            fVar.f2300c = fragmentStateAdapter$FragmentMaxLifecycleEnforcer$3;
            this.f2304a.a(fragmentStateAdapter$FragmentMaxLifecycleEnforcer$3);
            return;
        }
        throw new IllegalArgumentException();
    }

    public final void onBindViewHolder(k2 k2Var, int i10) {
        boolean z10;
        Bundle bundle;
        h hVar = (h) k2Var;
        long itemId = hVar.getItemId();
        int id = ((FrameLayout) hVar.itemView).getId();
        Long e10 = e(id);
        i iVar = this.f2308e;
        if (!(e10 == null || e10.longValue() == itemId)) {
            g(e10.longValue());
            iVar.h(e10.longValue());
        }
        iVar.g(itemId, Integer.valueOf(id));
        long j10 = (long) i10;
        i iVar2 = this.f2306c;
        if (iVar2.f13066h) {
            iVar2.d();
        }
        if (q.g.b(iVar2.f13067i, iVar2.f13069k, j10) >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            c0 c10 = c(i10);
            Bundle bundle2 = null;
            b0 b0Var = (b0) this.f2307d.e(j10, (Long) null);
            if (c10.f1370z == null) {
                if (!(b0Var == null || (bundle = b0Var.f1328h) == null)) {
                    bundle2 = bundle;
                }
                c10.f1353i = bundle2;
                iVar2.g(j10, c10);
            } else {
                throw new IllegalStateException("Fragment already added");
            }
        }
        FrameLayout frameLayout = (FrameLayout) hVar.itemView;
        WeakHashMap weakHashMap = m0.c1.f10054a;
        if (l0.b(frameLayout)) {
            if (frameLayout.getParent() == null) {
                frameLayout.addOnLayoutChangeListener(new a(this, frameLayout, hVar));
            } else {
                throw new IllegalStateException("Design assumption violated.");
            }
        }
        d();
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        int i11 = h.f2312h;
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        WeakHashMap weakHashMap = m0.c1.f10054a;
        frameLayout.setId(j0.a());
        frameLayout.setSaveEnabled(false);
        return new h(frameLayout);
    }

    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        f fVar = this.f2309f;
        fVar.getClass();
        ViewPager2 a10 = f.a(recyclerView);
        ((List) a10.f2315j.f2296b).remove(fVar.f2298a);
        e eVar = fVar.f2299b;
        g gVar = fVar.f2303f;
        gVar.unregisterAdapterDataObserver(eVar);
        gVar.f2304a.c(fVar.f2300c);
        fVar.f2301d = null;
        this.f2309f = null;
    }

    public final /* bridge */ /* synthetic */ boolean onFailedToRecycleView(k2 k2Var) {
        h hVar = (h) k2Var;
        return true;
    }

    public final void onViewAttachedToWindow(k2 k2Var) {
        f((h) k2Var);
        d();
    }

    public final void onViewRecycled(k2 k2Var) {
        Long e10 = e(((FrameLayout) ((h) k2Var).itemView).getId());
        if (e10 != null) {
            g(e10.longValue());
            this.f2308e.h(e10.longValue());
        }
    }

    public final void setHasStableIds(boolean z10) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }
}
