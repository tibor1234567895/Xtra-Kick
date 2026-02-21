package e1;

import androidx.media.AudioAttributesImpl;
import androidx.media.AudioAttributesImplApi26;

public final class d extends c {
    public final AudioAttributesImpl a() {
        return new AudioAttributesImplApi26(this.f4894a.build());
    }

    public final b b(int i10) {
        this.f4894a.setUsage(i10);
        return this;
    }

    public final c c(int i10) {
        this.f4894a.setUsage(i10);
        return this;
    }
}
