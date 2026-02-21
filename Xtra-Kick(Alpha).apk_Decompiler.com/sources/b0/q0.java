package b0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import c0.a;
import c0.g;
import java.util.ArrayList;
import java.util.Iterator;

public final class q0 implements Iterable {

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f2407h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final Context f2408i;

    public q0(Context context) {
        this.f2408i = context;
    }

    public final void a(ComponentName componentName) {
        Context context = this.f2408i;
        ArrayList arrayList = this.f2407h;
        int size = arrayList.size();
        while (true) {
            try {
                Intent b10 = n.b(context, componentName);
                if (b10 != null) {
                    arrayList.add(size, b10);
                    componentName = b10.getComponent();
                } else {
                    return;
                }
            } catch (PackageManager.NameNotFoundException e10) {
                Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e10);
            }
        }
    }

    public final void b() {
        ArrayList arrayList = this.f2407h;
        if (!arrayList.isEmpty()) {
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            Object obj = g.f2717a;
            a.a(this.f2408i, intentArr, (Bundle) null);
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }

    public final Iterator iterator() {
        return this.f2407h.iterator();
    }
}
