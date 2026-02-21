package j9;

import java.math.BigInteger;
import l9.a;
import l9.i;

public final class x extends s {

    /* renamed from: i  reason: collision with root package name */
    public static final Class[] f8879i = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: h  reason: collision with root package name */
    public Object f8880h;

    public x(Boolean bool) {
        i(bool);
    }

    public static boolean h(x xVar) {
        Object obj = xVar.f8880h;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public final int a() {
        if (this.f8880h instanceof Number) {
            return g().intValue();
        }
        return Integer.parseInt(e());
    }

    public final String e() {
        Object obj = this.f8880h;
        if (obj instanceof Number) {
            return g().toString();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        }
        return (String) obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x.class != obj.getClass()) {
            return false;
        }
        x xVar = (x) obj;
        if (this.f8880h == null) {
            return xVar.f8880h == null;
        }
        if (h(this) && h(xVar)) {
            return g().longValue() == xVar.g().longValue();
        }
        Object obj2 = this.f8880h;
        if (!(obj2 instanceof Number) || !(xVar.f8880h instanceof Number)) {
            return obj2.equals(xVar.f8880h);
        }
        double doubleValue = g().doubleValue();
        double doubleValue2 = xVar.g().doubleValue();
        if (doubleValue != doubleValue2) {
            return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
        }
        return true;
    }

    public final boolean f() {
        Object obj = this.f8880h;
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return Boolean.parseBoolean(e());
    }

    public final Number g() {
        Object obj = this.f8880h;
        return obj instanceof String ? new i((String) obj) : (Number) obj;
    }

    public final int hashCode() {
        long doubleToLongBits;
        if (this.f8880h == null) {
            return 31;
        }
        if (h(this)) {
            doubleToLongBits = g().longValue();
        } else {
            Object obj = this.f8880h;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(g().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public final void i(Object obj) {
        boolean z10;
        if (obj instanceof Character) {
            obj = String.valueOf(((Character) obj).charValue());
        } else {
            boolean z11 = true;
            if (!(obj instanceof Number)) {
                if (!(obj instanceof String)) {
                    Class<?> cls = obj.getClass();
                    Class[] clsArr = f8879i;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= 16) {
                            z10 = false;
                            break;
                        } else if (clsArr[i10].isAssignableFrom(cls)) {
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                z10 = true;
                if (!z10) {
                    z11 = false;
                }
            }
            a.a(z11);
        }
        this.f8880h = obj;
    }

    public x(Number number) {
        i(number);
    }

    public x(Object obj) {
        i(obj);
    }

    public x(String str) {
        i(str);
    }
}
