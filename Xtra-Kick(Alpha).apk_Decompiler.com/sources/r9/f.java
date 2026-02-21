package r9;

import v3.d;

public final class f extends a {
    public f() {
        super(3, 4);
    }

    public final void a(d dVar) {
        dVar.p("ALTER TABLE 'requests' ADD COLUMN '_identifier' INTEGER NOT NULL DEFAULT 0");
    }
}
