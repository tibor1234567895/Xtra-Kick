package l9;

import java.math.BigDecimal;

public final class i extends Number {

    /* renamed from: h  reason: collision with root package name */
    public final String f9769h;

    public i(String str) {
        this.f9769h = str;
    }

    public final double doubleValue() {
        return Double.parseDouble(this.f9769h);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        String str = ((i) obj).f9769h;
        String str2 = this.f9769h;
        return str2 == str || str2.equals(str);
    }

    public final float floatValue() {
        return Float.parseFloat(this.f9769h);
    }

    public final int hashCode() {
        return this.f9769h.hashCode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return new java.math.BigDecimal(r0).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000c, code lost:
        return (int) java.lang.Long.parseLong(r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int intValue() {
        /*
            r2 = this;
            java.lang.String r0 = r2.f9769h
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0007 }
            return r0
        L_0x0007:
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x000d }
            int r1 = (int) r0
            return r1
        L_0x000d:
            java.math.BigDecimal r1 = new java.math.BigDecimal
            r1.<init>(r0)
            int r0 = r1.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.i.intValue():int");
    }

    public final long longValue() {
        String str = this.f9769h;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return new BigDecimal(str).longValue();
        }
    }

    public final String toString() {
        return this.f9769h;
    }
}
