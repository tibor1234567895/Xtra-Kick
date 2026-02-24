package j9;

import java.lang.reflect.Field;

/* 'enum' modifier removed */
public final class d extends h {
    public d() {
        super("UPPER_CAMEL_CASE_WITH_SPACES", 2);
    }

    public final String a(Field field) {
        return h.c(h.b(field.getName(), " "));
    }
}
