package d1;

import android.content.Context;
import android.content.Intent;
import android.support.v4.media.h;
import android.support.v4.media.session.w;
import java.util.ArrayList;
import java.util.HashMap;

public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final Object f4129e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public static a f4130f;

    /* renamed from: a  reason: collision with root package name */
    public final Context f4131a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f4132b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f4133c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f4134d = new ArrayList();

    public a(Context context) {
        this.f4131a = context;
        new w(this, context.getMainLooper(), 3);
    }

    public final void a(Intent intent) {
        synchronized (this.f4132b) {
            intent.getAction();
            intent.resolveTypeIfNeeded(this.f4131a.getContentResolver());
            intent.getData();
            intent.getScheme();
            intent.getCategories();
            boolean z10 = (intent.getFlags() & 8) != 0;
            if (z10) {
                intent.toString();
            }
            ArrayList arrayList = (ArrayList) this.f4133c.get(intent.getAction());
            if (arrayList != null) {
                if (z10) {
                    arrayList.toString();
                }
                if (arrayList.size() > 0) {
                    h.y(arrayList.get(0));
                    if (z10) {
                        throw null;
                    }
                    throw null;
                }
            }
        }
    }
}
