package a5;

import android.graphics.Bitmap;
import android.util.LruCache;
import e5.c;

public final class i extends LruCache {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f153a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(j jVar, int i10) {
        super(i10);
        this.f153a = jVar;
    }

    public final void entryRemoved(boolean z10, Object obj, Object obj2, Object obj3) {
        Integer num = (Integer) obj;
        Bitmap bitmap = (Bitmap) obj2;
        Bitmap bitmap2 = (Bitmap) obj3;
        if (bitmap != null) {
            ((c) this.f153a.f156c.f9124i).c(bitmap);
        }
    }
}
