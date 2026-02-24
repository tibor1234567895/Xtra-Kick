package com.github.andreyasadchy.xtra.model;

import android.content.Context;
import android.content.SharedPreferences;
import hb.h0;
import xa.f;
import xa.j;

public abstract class Account {
    public static final Companion Companion = new Companion((f) null);
    /* access modifiers changed from: private */
    public static Account account;
    private final int id;
    private final String login;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final Account get(Context context) {
            j.f("context", context);
            return new NotLoggedIn();
        }

        public final void set(Context context, Account account) {
            String str;
            j.f("context", context);
            Account.account = account;
            SharedPreferences.Editor edit = h0.l1(context).edit();
            j.e("editor", edit);
            if (account != null) {
                edit.putInt("user_id", account.getId());
                str = account.getLogin();
            } else {
                edit.putInt("user_id", 0);
                str = null;
            }
            edit.putString("username", str);
            edit.apply();
        }

        public final void validated() {
            Account access$getAccount$cp = Account.account;
            j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.model.NotValidated", access$getAccount$cp);
            Account.account = new LoggedIn((NotValidated) access$getAccount$cp);
        }
    }

    private Account(int i10, String str) {
        this.id = i10;
        this.login = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!j.a(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.model.Account", obj);
        Account account2 = (Account) obj;
        return this.id == account2.id && j.a(this.login, account2.login);
    }

    public final int getId() {
        return this.id;
    }

    public final String getLogin() {
        return this.login;
    }

    public int hashCode() {
        int i10 = this.id * 31;
        String str = this.login;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    public /* synthetic */ Account(int i10, String str, f fVar) {
        this(i10, str);
    }
}
