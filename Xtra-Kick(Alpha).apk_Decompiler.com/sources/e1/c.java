package e1;

import android.media.AudioAttributes;
import androidx.media.AudioAttributesImpl;
import androidx.media.AudioAttributesImplApi21;

public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final AudioAttributes.Builder f4894a = new AudioAttributes.Builder();

    public AudioAttributesImpl a() {
        return new AudioAttributesImplApi21(this.f4894a.build());
    }

    /* renamed from: c */
    public c b(int i10) {
        if (i10 == 16) {
            i10 = 12;
        }
        this.f4894a.setUsage(i10);
        return this;
    }
}
