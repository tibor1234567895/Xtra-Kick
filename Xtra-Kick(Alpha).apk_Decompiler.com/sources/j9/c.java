package j9;

import java.lang.reflect.Field;

/* 'enum' modifier removed */
public final class c extends h {
    public c() {
        super("UPPER_CAMEL_CASE", 1);
    }

    public final String a(Field field) {
        return h.c(field.getName());
    }
}
