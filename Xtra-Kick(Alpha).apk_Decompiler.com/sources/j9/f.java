package j9;

import java.lang.reflect.Field;
import java.util.Locale;

/* 'enum' modifier removed */
public final class f extends h {
    public f() {
        super("LOWER_CASE_WITH_DASHES", 4);
    }

    public final String a(Field field) {
        return h.b(field.getName(), "-").toLowerCase(Locale.ENGLISH);
    }
}
