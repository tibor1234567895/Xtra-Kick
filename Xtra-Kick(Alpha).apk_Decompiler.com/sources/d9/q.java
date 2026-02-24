package d9;

import c9.n;
import java.util.Map;

public abstract class q implements Map.Entry {
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return n.a(getKey(), entry.getKey()) && n.a(getValue(), entry.getValue());
    }

    public final int hashCode() {
        Object key = getKey();
        Object value = getValue();
        int i10 = 0;
        int hashCode = key == null ? 0 : key.hashCode();
        if (value != null) {
            i10 = value.hashCode();
        }
        return hashCode ^ i10;
    }

    public Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        String valueOf = String.valueOf(getKey());
        String valueOf2 = String.valueOf(getValue());
        StringBuilder sb2 = new StringBuilder(valueOf2.length() + valueOf.length() + 1);
        sb2.append(valueOf);
        sb2.append(Constants.ATTRIBUTE_SEPARATOR);
        sb2.append(valueOf2);
        return sb2.toString();
    }
}
