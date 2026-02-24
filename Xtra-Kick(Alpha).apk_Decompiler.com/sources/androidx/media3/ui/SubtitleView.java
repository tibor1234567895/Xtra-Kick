package androidx.media3.ui;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import i1.a;
import i1.b;
import i3.c;
import i3.d;
import i3.m0;
import i3.n0;
import i3.t0;
import j1.l0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k1.q;

public final class SubtitleView extends FrameLayout {

    /* renamed from: h  reason: collision with root package name */
    public List f1847h = Collections.emptyList();

    /* renamed from: i  reason: collision with root package name */
    public d f1848i = d.f8064g;

    /* renamed from: j  reason: collision with root package name */
    public int f1849j = 0;

    /* renamed from: k  reason: collision with root package name */
    public float f1850k = 0.0533f;

    /* renamed from: l  reason: collision with root package name */
    public float f1851l = 0.08f;

    /* renamed from: m  reason: collision with root package name */
    public boolean f1852m = true;

    /* renamed from: n  reason: collision with root package name */
    public boolean f1853n = true;

    /* renamed from: o  reason: collision with root package name */
    public int f1854o;

    /* renamed from: p  reason: collision with root package name */
    public m0 f1855p;

    /* renamed from: q  reason: collision with root package name */
    public View f1856q;

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c cVar = new c(context);
        this.f1855p = cVar;
        this.f1856q = cVar;
        addView(cVar);
        this.f1854o = 1;
    }

    private List<b> getCuesWithStylingPreferencesApplied() {
        if (this.f1852m && this.f1853n) {
            return this.f1847h;
        }
        ArrayList arrayList = new ArrayList(this.f1847h.size());
        for (int i10 = 0; i10 < this.f1847h.size(); i10++) {
            b bVar = (b) this.f1847h.get(i10);
            bVar.getClass();
            a aVar = new a(bVar);
            if (!this.f1852m) {
                aVar.f7966n = false;
                CharSequence charSequence = aVar.f7953a;
                if (charSequence instanceof Spanned) {
                    if (!(charSequence instanceof Spannable)) {
                        aVar.f7953a = SpannableString.valueOf(charSequence);
                    }
                    CharSequence charSequence2 = aVar.f7953a;
                    charSequence2.getClass();
                    n0.b((Spannable) charSequence2, new q(2));
                }
                n0.a(aVar);
            } else if (!this.f1853n) {
                n0.a(aVar);
            }
            arrayList.add(aVar.a());
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (l0.f8453a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private d getUserCaptionStyle() {
        CaptioningManager captioningManager;
        d dVar;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = l0.f8453a;
        d dVar2 = d.f8064g;
        if (i15 < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return dVar2;
        }
        CaptioningManager.CaptionStyle userStyle = captioningManager.getUserStyle();
        if (i15 >= 21) {
            if (userStyle.hasForegroundColor()) {
                i10 = userStyle.foregroundColor;
            } else {
                i10 = -1;
            }
            if (userStyle.hasBackgroundColor()) {
                i11 = userStyle.backgroundColor;
            } else {
                i11 = -16777216;
            }
            if (userStyle.hasWindowColor()) {
                i12 = userStyle.windowColor;
            } else {
                i12 = 0;
            }
            if (userStyle.hasEdgeType()) {
                i13 = userStyle.edgeType;
            } else {
                i13 = 0;
            }
            if (userStyle.hasEdgeColor()) {
                i14 = userStyle.edgeColor;
            } else {
                i14 = -1;
            }
            dVar = new d(i10, i11, i12, i13, i14, userStyle.getTypeface());
        } else {
            dVar = new d(userStyle.foregroundColor, userStyle.backgroundColor, 0, userStyle.edgeType, userStyle.edgeColor, userStyle.getTypeface());
        }
        return dVar;
    }

    private <T extends View & m0> void setView(T t10) {
        removeView(this.f1856q);
        View view = this.f1856q;
        if (view instanceof t0) {
            ((t0) view).f8171i.destroy();
        }
        this.f1856q = t10;
        this.f1855p = (m0) t10;
        addView(t10);
    }

    public final void a() {
        setStyle(getUserCaptionStyle());
    }

    public final void b() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public final void c() {
        this.f1855p.a(getCuesWithStylingPreferencesApplied(), this.f1848i, this.f1850k, this.f1849j, this.f1851l);
    }

    public void setApplyEmbeddedFontSizes(boolean z10) {
        this.f1853n = z10;
        c();
    }

    public void setApplyEmbeddedStyles(boolean z10) {
        this.f1852m = z10;
        c();
    }

    public void setBottomPaddingFraction(float f10) {
        this.f1851l = f10;
        c();
    }

    public void setCues(List<b> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f1847h = list;
        c();
    }

    public void setFractionalTextSize(float f10) {
        this.f1849j = 0;
        this.f1850k = f10;
        c();
    }

    public void setStyle(d dVar) {
        this.f1848i = dVar;
        c();
    }

    public void setViewType(int i10) {
        View view;
        if (this.f1854o != i10) {
            if (i10 == 1) {
                view = new c(getContext());
            } else if (i10 == 2) {
                view = new t0(getContext());
            } else {
                throw new IllegalArgumentException();
            }
            setView(view);
            this.f1854o = i10;
        }
    }
}
