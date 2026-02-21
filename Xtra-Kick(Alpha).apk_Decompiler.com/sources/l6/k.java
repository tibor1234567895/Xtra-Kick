package l6;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.github.andreyasadchy.xtra.model.chat.Image;
import la.i;
import r7.a;
import t5.c;
import u5.g;
import xa.j;

public final class k extends c {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Image f9618k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ l f9619l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ SpannableStringBuilder f9620m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ h f9621n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ CharSequence f9622o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f9623p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f9624q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ String f9625r;

    public k(Image image, l lVar, SpannableStringBuilder spannableStringBuilder, h hVar, String str, int i10, int i11, String str2) {
        this.f9618k = image;
        this.f9619l = lVar;
        this.f9620m = spannableStringBuilder;
        this.f9621n = hVar;
        this.f9622o = str;
        this.f9623p = i10;
        this.f9624q = i11;
        this.f9625r = str2;
    }

    public final void f(Object obj, g gVar) {
        i iVar;
        Drawable drawable = (Drawable) obj;
        Image image = this.f9618k;
        boolean isEmote = image.isEmote();
        l lVar = this.f9619l;
        if (isEmote) {
            iVar = l.a(lVar, drawable);
        } else {
            iVar = new i(Integer.valueOf(lVar.f9628c), Integer.valueOf(lVar.f9628c));
        }
        boolean isZeroWidth = image.isZeroWidth();
        Object obj2 = iVar.f9799h;
        Object obj3 = iVar.f9800i;
        if (!isZeroWidth || !lVar.f9633h) {
            drawable.setBounds(0, 0, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        } else {
            drawable.setBounds(-90, 0, ((Number) obj2).intValue() - 90, ((Number) obj3).intValue());
        }
        if ((drawable instanceof Animatable) && !j.a(image.isAnimated(), Boolean.FALSE) && lVar.f9632g) {
            drawable.setCallback(new j(1, this.f9621n));
            ((Animatable) drawable).start();
        }
        try {
            this.f9620m.setSpan(new a(drawable), image.getStart(), image.getEnd(), 33);
        } catch (IndexOutOfBoundsException unused) {
        }
        this.f9621n.a(this.f9622o, this.f9620m, this.f9623p, this.f9624q, this.f9625r);
    }

    public final void i(Drawable drawable) {
    }
}
