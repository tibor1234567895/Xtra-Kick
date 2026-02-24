package j9;

import java.lang.reflect.Field;
import java.util.Locale;

/* 'enum' modifier removed */
public final class g extends h {
    public g() {
        super("LOWER_CASE_WITH_DOTS", 5);
    }

    public final String a(Field field) {
        return h.b(field.getName(), ".").toLowerCase(Locale.ENGLISH);
    }
}
