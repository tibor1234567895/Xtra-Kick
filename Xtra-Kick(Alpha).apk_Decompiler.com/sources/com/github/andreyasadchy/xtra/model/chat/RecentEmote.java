package com.github.andreyasadchy.xtra.model.chat;

import xa.f;
import xa.j;

public final class RecentEmote {
    public static final Companion Companion = new Companion((f) null);
    public static final int MAX_SIZE = 50;
    private final String name;
    private final long usedAt;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public RecentEmote(String str, long j10) {
        j.f("name", str);
        this.name = str;
        this.usedAt = j10;
    }

    public final String getName() {
        return this.name;
    }

    public final long getUsedAt() {
        return this.usedAt;
    }
}
