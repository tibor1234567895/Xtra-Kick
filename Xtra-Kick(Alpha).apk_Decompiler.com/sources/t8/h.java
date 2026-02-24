package t8;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import j8.a;

public class h extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public n f14723a;

    /* renamed from: b  reason: collision with root package name */
    public a f14724b;

    /* renamed from: c  reason: collision with root package name */
    public ColorStateList f14725c = null;

    /* renamed from: d  reason: collision with root package name */
    public ColorStateList f14726d = null;

    /* renamed from: e  reason: collision with root package name */
    public final ColorStateList f14727e = null;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f14728f = null;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f14729g = PorterDuff.Mode.SRC_IN;

    /* renamed from: h  reason: collision with root package name */
    public Rect f14730h = null;

    /* renamed from: i  reason: collision with root package name */
    public final float f14731i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    public float f14732j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    public float f14733k;

    /* renamed from: l  reason: collision with root package name */
    public int f14734l = 255;

    /* renamed from: m  reason: collision with root package name */
    public float f14735m = 0.0f;

    /* renamed from: n  reason: collision with root package name */
    public float f14736n = 0.0f;

    /* renamed from: o  reason: collision with root package name */
    public final float f14737o = 0.0f;

    /* renamed from: p  reason: collision with root package name */
    public final int f14738p = 0;

    /* renamed from: q  reason: collision with root package name */
    public int f14739q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f14740r = 0;

    /* renamed from: s  reason: collision with root package name */
    public int f14741s = 0;

    /* renamed from: t  reason: collision with root package name */
    public boolean f14742t = false;

    /* renamed from: u  reason: collision with root package name */
    public final Paint.Style f14743u = Paint.Style.FILL_AND_STROKE;

    public h(h hVar) {
        this.f14723a = hVar.f14723a;
        this.f14724b = hVar.f14724b;
        this.f14733k = hVar.f14733k;
        this.f14725c = hVar.f14725c;
        this.f14726d = hVar.f14726d;
        this.f14729g = hVar.f14729g;
        this.f14728f = hVar.f14728f;
        this.f14734l = hVar.f14734l;
        this.f14731i = hVar.f14731i;
        this.f14740r = hVar.f14740r;
        this.f14738p = hVar.f14738p;
        this.f14742t = hVar.f14742t;
        this.f14732j = hVar.f14732j;
        this.f14735m = hVar.f14735m;
        this.f14736n = hVar.f14736n;
        this.f14737o = hVar.f14737o;
        this.f14739q = hVar.f14739q;
        this.f14741s = hVar.f14741s;
        this.f14727e = hVar.f14727e;
        this.f14743u = hVar.f14743u;
        if (hVar.f14730h != null) {
            this.f14730h = new Rect(hVar.f14730h);
        }
    }

    public final int getChangingConfigurations() {
        return 0;
    }

    public Drawable newDrawable() {
        i iVar = new i(this);
        iVar.f14748l = true;
        return iVar;
    }

    public h(n nVar) {
        this.f14723a = nVar;
        this.f14724b = null;
    }
}
