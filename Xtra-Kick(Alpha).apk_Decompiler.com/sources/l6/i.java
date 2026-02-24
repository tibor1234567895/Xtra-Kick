package l6;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.github.andreyasadchy.xtra.model.chat.Image;
import u4.a;
import xa.j;

public final class i implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Image f9608h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l f9609i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SpannableStringBuilder f9610j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ h f9611k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ CharSequence f9612l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f9613m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f9614n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f9615o;

    public i(Image image, l lVar, SpannableStringBuilder spannableStringBuilder, h hVar, String str, int i10, int i11, String str2) {
        this.f9608h = image;
        this.f9609i = lVar;
        this.f9610j = spannableStringBuilder;
        this.f9611k = hVar;
        this.f9612l = str;
        this.f9613m = i10;
        this.f9614n = i11;
        this.f9615o = str2;
    }

    public final void c(Drawable drawable) {
    }

    public final void h(Drawable drawable) {
        la.i iVar;
        Image image = this.f9608h;
        boolean isEmote = image.isEmote();
        l lVar = this.f9609i;
        if (isEmote) {
            iVar = l.a(lVar, drawable);
        } else {
            iVar = new la.i(Integer.valueOf(lVar.f9628c), Integer.valueOf(lVar.f9628c));
        }
        boolean isZeroWidth = image.isZeroWidth();
        Object obj = iVar.f9799h;
        if (!isZeroWidth || !lVar.f9633h) {
            drawable.setBounds(0, 0, ((Number) obj).intValue(), ((Number) iVar.f9800i).intValue());
        } else {
            drawable.setBounds(-90, 0, ((Number) obj).intValue() - 90, ((Number) iVar.f9800i).intValue());
        }
        if ((drawable instanceof Animatable) && !j.a(image.isAnimated(), Boolean.FALSE) && lVar.f9632g) {
            drawable.setCallback(new j(0, this.f9611k));
            ((Animatable) drawable).start();
        }
        try {
            this.f9610j.setSpan(new r7.a(drawable), image.getStart(), image.getEnd(), 33);
        } catch (IndexOutOfBoundsException unused) {
        }
        this.f9611k.a(this.f9612l, this.f9610j, this.f9613m, this.f9614n, this.f9615o);
    }

    public final void i(Drawable drawable) {
    }
}
