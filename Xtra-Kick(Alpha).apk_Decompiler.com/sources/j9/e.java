package j9;

import java.lang.reflect.Field;
import java.util.Locale;

/* 'enum' modifier removed */
public final class e extends h {
    public e() {
        super("LOWER_CASE_WITH_UNDERSCORES", 3);
    }

    public final String a(Field field) {
        return h.b(field.getName(), "_").toLowerCase(Locale.ENGLISH);
    }
}
