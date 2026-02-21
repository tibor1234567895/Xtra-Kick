package o8;

import android.content.Context;
import android.support.v4.media.h;
import android.view.SubMenu;
import m.o;
import m.q;

public final class e extends o {
    public final int A;

    /* renamed from: z  reason: collision with root package name */
    public final Class f12329z;

    public e(Context context, Class cls, int i10) {
        super(context);
        this.f12329z = cls;
        this.A = i10;
    }

    public final q a(int i10, int i11, int i12, CharSequence charSequence) {
        int size = size() + 1;
        int i13 = this.A;
        if (size <= i13) {
            x();
            q a10 = super.a(i10, i11, i12, charSequence);
            a10.f10022x = (a10.f10022x & -5) | 4;
            w();
            return a10;
        }
        String simpleName = this.f12329z.getSimpleName();
        StringBuilder sb2 = new StringBuilder("Maximum number of items supported by ");
        sb2.append(simpleName);
        sb2.append(" is ");
        sb2.append(i13);
        sb2.append(". Limit can be checked with ");
        throw new IllegalArgumentException(h.p(sb2, simpleName, "#getMaxItemCount()"));
    }

    public final SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        throw new UnsupportedOperationException(this.f12329z.getSimpleName().concat(" does not support submenus"));
    }
}
