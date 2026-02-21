package m8;

import android.content.Context;
import android.text.TextPaint;
import f8.b;
import java.lang.ref.WeakReference;
import q8.g;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final TextPaint f10787a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    public final b f10788b = new b(1, this);

    /* renamed from: c  reason: collision with root package name */
    public float f10789c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10790d = true;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference f10791e = new WeakReference((Object) null);

    /* renamed from: f  reason: collision with root package name */
    public g f10792f;

    public o(n nVar) {
        this.f10791e = new WeakReference(nVar);
    }

    public final float a(String str) {
        float f10;
        if (!this.f10790d) {
            return this.f10789c;
        }
        if (str == null) {
            f10 = 0.0f;
        } else {
            f10 = this.f10787a.measureText(str, 0, str.length());
        }
        this.f10789c = f10;
        this.f10790d = false;
        return f10;
    }

    public final void b(g gVar, Context context) {
        if (this.f10792f != gVar) {
            this.f10792f = gVar;
            if (gVar != null) {
                TextPaint textPaint = this.f10787a;
                b bVar = this.f10788b;
                gVar.f(context, textPaint, bVar);
                n nVar = (n) this.f10791e.get();
                if (nVar != null) {
                    textPaint.drawableState = nVar.getState();
                }
                gVar.e(context, textPaint, bVar);
                this.f10790d = true;
            }
            n nVar2 = (n) this.f10791e.get();
            if (nVar2 != null) {
                nVar2.a();
                nVar2.onStateChange(nVar2.getState());
            }
        }
    }
}
