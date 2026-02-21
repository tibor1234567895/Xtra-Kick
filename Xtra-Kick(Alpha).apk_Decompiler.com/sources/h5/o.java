package h5;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import b5.a;
import com.bumptech.glide.j;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import java.io.IOException;
import java.io.InputStream;
import m5.b;

public final class o implements e {

    /* renamed from: h  reason: collision with root package name */
    public final Resources.Theme f7596h;

    /* renamed from: i  reason: collision with root package name */
    public final Resources f7597i;

    /* renamed from: j  reason: collision with root package name */
    public final p f7598j;

    /* renamed from: k  reason: collision with root package name */
    public final int f7599k;

    /* renamed from: l  reason: collision with root package name */
    public Object f7600l;

    public o(Resources.Theme theme, Resources resources, p pVar, int i10) {
        this.f7596h = theme;
        this.f7597i = resources;
        this.f7598j = pVar;
        this.f7599k = i10;
    }

    public final Class a() {
        switch (((n) this.f7598j).f7594a) {
            case 0:
                return AssetFileDescriptor.class;
            case 1:
                return Drawable.class;
            default:
                return InputStream.class;
        }
    }

    public final void c() {
        Object obj = this.f7600l;
        if (obj != null) {
            try {
                switch (((n) this.f7598j).f7594a) {
                    case 0:
                        ((AssetFileDescriptor) obj).close();
                        return;
                    case 1:
                        Drawable drawable = (Drawable) obj;
                        return;
                    default:
                        ((InputStream) obj).close();
                        return;
                }
            } catch (IOException unused) {
            }
        }
    }

    public final void cancel() {
    }

    public final a d() {
        return a.LOCAL;
    }

    public final void f(j jVar, d dVar) {
        Object obj;
        try {
            p pVar = this.f7598j;
            Resources.Theme theme = this.f7596h;
            Resources resources = this.f7597i;
            int i10 = this.f7599k;
            n nVar = (n) pVar;
            switch (nVar.f7594a) {
                case 0:
                    obj = resources.openRawResourceFd(i10);
                    break;
                case 1:
                    Context context = nVar.f7595b;
                    obj = b.a(context, context, i10, theme);
                    break;
                default:
                    obj = resources.openRawResource(i10);
                    break;
            }
            this.f7600l = obj;
            dVar.g(obj);
        } catch (Resources.NotFoundException e10) {
            dVar.e(e10);
        }
    }
}
