package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import android.support.v4.media.h;
import xa.j;

public final class DataStatus {
    private final int code;
    private final boolean error;
    private final String message;

    public DataStatus(boolean z10, int i10, String str) {
        j.f("message", str);
        this.error = z10;
        this.code = i10;
        this.message = str;
    }

    public static /* synthetic */ DataStatus copy$default(DataStatus dataStatus, boolean z10, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = dataStatus.error;
        }
        if ((i11 & 2) != 0) {
            i10 = dataStatus.code;
        }
        if ((i11 & 4) != 0) {
            str = dataStatus.message;
        }
        return dataStatus.copy(z10, i10, str);
    }

    public final boolean component1() {
        return this.error;
    }

    public final int component2() {
        return this.code;
    }

    public final String component3() {
        return this.message;
    }

    public final DataStatus copy(boolean z10, int i10, String str) {
        j.f("message", str);
        return new DataStatus(z10, i10, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataStatus)) {
            return false;
        }
        DataStatus dataStatus = (DataStatus) obj;
        return this.error == dataStatus.error && this.code == dataStatus.code && j.a(this.message, dataStatus.message);
    }

    public final int getCode() {
        return this.code;
    }

    public final boolean getError() {
        return this.error;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        boolean z10 = this.error;
        if (z10) {
            z10 = true;
        }
        return this.message.hashCode() + ((((z10 ? 1 : 0) * true) + this.code) * 31);
    }

    public String toString() {
        boolean z10 = this.error;
        int i10 = this.code;
        String str = this.message;
        StringBuilder sb2 = new StringBuilder("DataStatus(error=");
        sb2.append(z10);
        sb2.append(", code=");
        sb2.append(i10);
        sb2.append(", message=");
        return h.p(sb2, str, ")");
    }
}
