package o3;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.n;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.h;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.k2;
import h.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;

public final class d0 extends g1 {

    /* renamed from: a  reason: collision with root package name */
    public final PreferenceGroup f12112a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f12113b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f12114c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f12115d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f12116e;

    /* renamed from: f  reason: collision with root package name */
    public final h f12117f = new h(11, this);

    public d0(PreferenceScreen preferenceScreen) {
        this.f12112a = preferenceScreen;
        this.f12116e = new Handler(Looper.getMainLooper());
        preferenceScreen.N = this;
        this.f12113b = new ArrayList();
        this.f12114c = new ArrayList();
        this.f12115d = new ArrayList();
        setHasStableIds(preferenceScreen.f1906a0);
        e();
    }

    public static boolean d(PreferenceGroup preferenceGroup) {
        return preferenceGroup.Z != Integer.MAX_VALUE;
    }

    public final ArrayList a(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int A = preferenceGroup.A();
        int i10 = 0;
        for (int i11 = 0; i11 < A; i11++) {
            Preference z10 = preferenceGroup.z(i11);
            if (z10.D) {
                if (!d(preferenceGroup) || i10 < preferenceGroup.Z) {
                    arrayList.add(z10);
                } else {
                    arrayList2.add(z10);
                }
                if (!(z10 instanceof PreferenceGroup)) {
                    i10++;
                } else {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) z10;
                    if (!(!(preferenceGroup2 instanceof PreferenceScreen))) {
                        continue;
                    } else if (!d(preferenceGroup) || !d(preferenceGroup2)) {
                        Iterator it = a(preferenceGroup2).iterator();
                        while (it.hasNext()) {
                            Preference preference = (Preference) it.next();
                            if (!d(preferenceGroup) || i10 < preferenceGroup.Z) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            i10++;
                        }
                    } else {
                        throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                    }
                }
            }
        }
        if (d(preferenceGroup) && i10 > preferenceGroup.Z) {
            g gVar = new g(preferenceGroup.f1887h, arrayList2, preferenceGroup.f1889j);
            gVar.f1892m = new n((Object) this, (Object) preferenceGroup, 20);
            arrayList.add(gVar);
        }
        return arrayList;
    }

    public final void b(PreferenceGroup preferenceGroup, ArrayList arrayList) {
        synchronized (preferenceGroup) {
            Collections.sort(preferenceGroup.V);
        }
        int A = preferenceGroup.A();
        for (int i10 = 0; i10 < A; i10++) {
            Preference z10 = preferenceGroup.z(i10);
            arrayList.add(z10);
            c0 c0Var = new c0(z10);
            if (!this.f12115d.contains(c0Var)) {
                this.f12115d.add(c0Var);
            }
            if (z10 instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) z10;
                if (!(preferenceGroup2 instanceof PreferenceScreen)) {
                    b(preferenceGroup2, arrayList);
                }
            }
            z10.N = this;
        }
    }

    public final Preference c(int i10) {
        if (i10 < 0 || i10 >= getItemCount()) {
            return null;
        }
        return (Preference) this.f12114c.get(i10);
    }

    public final void e() {
        Iterator it = this.f12113b.iterator();
        while (it.hasNext()) {
            ((Preference) it.next()).N = null;
        }
        ArrayList arrayList = new ArrayList(this.f12113b.size());
        this.f12113b = arrayList;
        PreferenceGroup preferenceGroup = this.f12112a;
        b(preferenceGroup, arrayList);
        this.f12114c = a(preferenceGroup);
        notifyDataSetChanged();
        Iterator it2 = this.f12113b.iterator();
        while (it2.hasNext()) {
            ((Preference) it2.next()).getClass();
        }
    }

    public final int getItemCount() {
        return this.f12114c.size();
    }

    public final long getItemId(int i10) {
        if (!hasStableIds()) {
            return -1;
        }
        return c(i10).d();
    }

    public final int getItemViewType(int i10) {
        c0 c0Var = new c0(c(i10));
        ArrayList arrayList = this.f12115d;
        int indexOf = arrayList.indexOf(c0Var);
        if (indexOf != -1) {
            return indexOf;
        }
        int size = arrayList.size();
        arrayList.add(c0Var);
        return size;
    }

    public final void onBindViewHolder(k2 k2Var, int i10) {
        ColorStateList colorStateList;
        l0 l0Var = (l0) k2Var;
        Preference c10 = c(i10);
        Drawable background = l0Var.itemView.getBackground();
        Drawable drawable = l0Var.f12144h;
        if (background != drawable) {
            View view = l0Var.itemView;
            WeakHashMap weakHashMap = c1.f10054a;
            i0.q(view, drawable);
        }
        TextView textView = (TextView) l0Var.a(16908310);
        if (!(textView == null || (colorStateList = l0Var.f12145i) == null || textView.getTextColors().equals(colorStateList))) {
            textView.setTextColor(colorStateList);
        }
        c10.l(l0Var);
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        c0 c0Var = (c0) this.f12115d.get(i10);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, m0.f12149a);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable == null) {
            drawable = a.a(viewGroup.getContext(), 17301602);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(c0Var.f12108a, viewGroup, false);
        if (inflate.getBackground() == null) {
            WeakHashMap weakHashMap = c1.f10054a;
            i0.q(inflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            int i11 = c0Var.f12109b;
            if (i11 != 0) {
                from.inflate(i11, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new l0(inflate);
    }
}
