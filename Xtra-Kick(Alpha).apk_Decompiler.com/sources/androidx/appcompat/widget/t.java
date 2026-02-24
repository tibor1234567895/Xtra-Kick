package androidx.appcompat.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public final ComponentName f1059a;

    /* renamed from: b  reason: collision with root package name */
    public final long f1060b;

    /* renamed from: c  reason: collision with root package name */
    public final float f1061c;

    public t(ComponentName componentName, long j10, float f10) {
        this.f1059a = componentName;
        this.f1060b = j10;
        this.f1061c = f10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t.class != obj.getClass()) {
            return false;
        }
        t tVar = (t) obj;
        ComponentName componentName = tVar.f1059a;
        ComponentName componentName2 = this.f1059a;
        if (componentName2 == null) {
            if (componentName != null) {
                return false;
            }
        } else if (!componentName2.equals(componentName)) {
            return false;
        }
        return this.f1060b == tVar.f1060b && Float.floatToIntBits(this.f1061c) == Float.floatToIntBits(tVar.f1061c);
    }

    public final int hashCode() {
        ComponentName componentName = this.f1059a;
        int hashCode = componentName == null ? 0 : componentName.hashCode();
        long j10 = this.f1060b;
        return Float.floatToIntBits(this.f1061c) + ((((hashCode + 31) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31);
    }

    public final String toString() {
        return "[; activity:" + this.f1059a + "; time:" + this.f1060b + "; weight:" + new BigDecimal((double) this.f1061c) + "]";
    }
}
