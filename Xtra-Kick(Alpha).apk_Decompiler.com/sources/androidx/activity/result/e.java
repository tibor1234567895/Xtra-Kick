package androidx.activity.result;

import android.content.Intent;
import e.b;
import java.util.HashMap;

public final class e extends d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f504a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f505b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f506c;

    public e(g gVar, String str, b bVar) {
        this.f506c = gVar;
        this.f504a = str;
        this.f505b = bVar;
    }

    public final void a(Intent intent) {
        g gVar = this.f506c;
        HashMap hashMap = gVar.f511c;
        String str = this.f504a;
        Integer num = (Integer) hashMap.get(str);
        b bVar = this.f505b;
        if (num != null) {
            gVar.f513e.add(str);
            try {
                gVar.b(num.intValue(), bVar, intent);
            } catch (Exception e10) {
                gVar.f513e.remove(str);
                throw e10;
            }
        } else {
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + bVar + " and input " + intent + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }
    }
}
