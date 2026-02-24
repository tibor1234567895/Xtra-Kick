package com.github.andreyasadchy.xtra.model;

import xa.f;
import xa.j;

public final class LoggedIn extends Account {
    public LoggedIn(int i10, String str) {
        super(i10, str, (f) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LoggedIn(NotValidated notValidated) {
        this(notValidated.getId(), notValidated.getLogin());
        j.f("account", notValidated);
    }
}
