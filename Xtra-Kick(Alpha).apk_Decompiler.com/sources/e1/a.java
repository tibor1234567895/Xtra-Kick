package e1;

import android.os.Build;
import androidx.media.AudioAttributesCompat;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final c f4885a;

    public a() {
        int i10 = AudioAttributesCompat.f1806b;
        this.f4885a = Build.VERSION.SDK_INT >= 26 ? new d() : new c();
    }
}
