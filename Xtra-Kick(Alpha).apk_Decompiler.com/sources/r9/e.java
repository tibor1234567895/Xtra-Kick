package r9;

import v3.d;

public final class e extends a {
    public e() {
        super(6, 7);
    }

    public final void a(d dVar) {
        dVar.p("ALTER TABLE 'requests' ADD COLUMN '_auto_retry_max_attempts' INTEGER NOT NULL DEFAULT '0'");
        dVar.p("ALTER TABLE 'requests' ADD COLUMN '_auto_retry_attempts' INTEGER NOT NULL DEFAULT '0'");
    }
}
