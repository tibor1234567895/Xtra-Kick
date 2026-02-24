package androidx.media3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import com.woxthebox.draglistview.R;
import g.c;
import g1.v1;
import g1.w1;
import g1.z1;
import i3.f;
import i3.p0;
import i3.q0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TrackSelectionView extends LinearLayout {

    /* renamed from: h  reason: collision with root package name */
    public final int f1857h;

    /* renamed from: i  reason: collision with root package name */
    public final LayoutInflater f1858i;

    /* renamed from: j  reason: collision with root package name */
    public final CheckedTextView f1859j;

    /* renamed from: k  reason: collision with root package name */
    public final CheckedTextView f1860k;

    /* renamed from: l  reason: collision with root package name */
    public final c f1861l;

    /* renamed from: m  reason: collision with root package name */
    public final ArrayList f1862m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    public final HashMap f1863n = new HashMap();

    /* renamed from: o  reason: collision with root package name */
    public boolean f1864o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f1865p;

    /* renamed from: q  reason: collision with root package name */
    public p0 f1866q = new f(getResources());

    /* renamed from: r  reason: collision with root package name */
    public CheckedTextView[][] f1867r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f1868s;

    public TrackSelectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setOrientation(1);
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843534});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.f1857h = resourceId;
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        this.f1858i = from;
        c cVar = new c(this);
        this.f1861l = cVar;
        CheckedTextView checkedTextView = (CheckedTextView) from.inflate(17367055, this, false);
        this.f1859j = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R.string.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(cVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(R.layout.exo_list_divider, this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) from.inflate(17367055, this, false);
        this.f1860k = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R.string.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(cVar);
        addView(checkedTextView2);
    }

    public final void a() {
        boolean z10;
        this.f1859j.setChecked(this.f1868s);
        boolean z11 = this.f1868s;
        HashMap hashMap = this.f1863n;
        if (z11 || hashMap.size() != 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f1860k.setChecked(z10);
        for (int i10 = 0; i10 < this.f1867r.length; i10++) {
            w1 w1Var = (w1) hashMap.get(((z1) this.f1862m.get(i10)).f6778i);
            int i11 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.f1867r[i10];
                if (i11 >= checkedTextViewArr.length) {
                    break;
                }
                if (w1Var != null) {
                    Object tag = checkedTextViewArr[i11].getTag();
                    tag.getClass();
                    this.f1867r[i10][i11].setChecked(w1Var.f6687i.contains(Integer.valueOf(((q0) tag).f8158b)));
                } else {
                    checkedTextViewArr[i11].setChecked(false);
                }
                i11++;
            }
        }
    }

    public final void b() {
        boolean z10;
        boolean z11;
        int i10;
        boolean z12;
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        ArrayList arrayList = this.f1862m;
        boolean isEmpty = arrayList.isEmpty();
        CheckedTextView checkedTextView = this.f1860k;
        CheckedTextView checkedTextView2 = this.f1859j;
        if (isEmpty) {
            checkedTextView2.setEnabled(false);
            checkedTextView.setEnabled(false);
            return;
        }
        checkedTextView2.setEnabled(true);
        checkedTextView.setEnabled(true);
        this.f1867r = new CheckedTextView[arrayList.size()][];
        if (!this.f1865p || arrayList.size() <= 1) {
            z10 = false;
        } else {
            z10 = true;
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            z1 z1Var = (z1) arrayList.get(i11);
            if (!this.f1864o || !z1Var.f6779j) {
                z11 = false;
            } else {
                z11 = true;
            }
            CheckedTextView[][] checkedTextViewArr = this.f1867r;
            int i12 = z1Var.f6777h;
            checkedTextViewArr[i11] = new CheckedTextView[i12];
            q0[] q0VarArr = new q0[i12];
            for (int i13 = 0; i13 < z1Var.f6777h; i13++) {
                q0VarArr[i13] = new q0(z1Var, i13);
            }
            for (int i14 = 0; i14 < i12; i14++) {
                LayoutInflater layoutInflater = this.f1858i;
                if (i14 == 0) {
                    addView(layoutInflater.inflate(R.layout.exo_list_divider, this, false));
                }
                if (z11 || z10) {
                    i10 = 17367056;
                } else {
                    i10 = 17367055;
                }
                CheckedTextView checkedTextView3 = (CheckedTextView) layoutInflater.inflate(i10, this, false);
                checkedTextView3.setBackgroundResource(this.f1857h);
                p0 p0Var = this.f1866q;
                q0 q0Var = q0VarArr[i14];
                checkedTextView3.setText(((f) p0Var).d(q0Var.f8157a.f6778i.f6676k[q0Var.f8158b]));
                checkedTextView3.setTag(q0VarArr[i14]);
                if (z1Var.f6780k[i14] != 4) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (z12) {
                    checkedTextView3.setFocusable(true);
                    checkedTextView3.setOnClickListener(this.f1861l);
                } else {
                    checkedTextView3.setFocusable(false);
                    checkedTextView3.setEnabled(false);
                }
                this.f1867r[i11][i14] = checkedTextView3;
                addView(checkedTextView3);
            }
        }
        a();
    }

    public boolean getIsDisabled() {
        return this.f1868s;
    }

    public Map<v1, w1> getOverrides() {
        return this.f1863n;
    }

    public void setAllowAdaptiveSelections(boolean z10) {
        if (this.f1864o != z10) {
            this.f1864o = z10;
            b();
        }
    }

    public void setAllowMultipleOverrides(boolean z10) {
        if (this.f1865p != z10) {
            this.f1865p = z10;
            if (!z10) {
                HashMap hashMap = this.f1863n;
                if (hashMap.size() > 1) {
                    ArrayList arrayList = this.f1862m;
                    HashMap hashMap2 = new HashMap();
                    for (int i10 = 0; i10 < arrayList.size(); i10++) {
                        w1 w1Var = (w1) hashMap.get(((z1) arrayList.get(i10)).f6778i);
                        if (w1Var != null && hashMap2.isEmpty()) {
                            hashMap2.put(w1Var.f6686h, w1Var);
                        }
                    }
                    hashMap.clear();
                    hashMap.putAll(hashMap2);
                }
            }
            b();
        }
    }

    public void setShowDisableOption(boolean z10) {
        this.f1859j.setVisibility(z10 ? 0 : 8);
    }

    public void setTrackNameProvider(p0 p0Var) {
        p0Var.getClass();
        this.f1866q = p0Var;
        b();
    }
}
