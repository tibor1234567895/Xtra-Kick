package com.github.andreyasadchy.xtra.model.retrofit.kick.v2;

import xa.j;

public final class Data<T> {
    private final T data;
    private final DataStatus status;

    public Data(DataStatus dataStatus, T t10) {
        j.f("status", dataStatus);
        this.status = dataStatus;
        this.data = t10;
    }

    public static /* synthetic */ Data copy$default(Data data2, DataStatus dataStatus, T t10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dataStatus = data2.status;
        }
        if ((i10 & 2) != 0) {
            t10 = data2.data;
        }
        return data2.copy(dataStatus, t10);
    }

    public final DataStatus component1() {
        return this.status;
    }

    public final T component2() {
        return this.data;
    }

    public final Data<T> copy(DataStatus dataStatus, T t10) {
        j.f("status", dataStatus);
        return new Data<>(dataStatus, t10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Data)) {
            return false;
        }
        Data data2 = (Data) obj;
        return j.a(this.status, data2.status) && j.a(this.data, data2.data);
    }

    public final T getData() {
        return this.data;
    }

    public final DataStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        int hashCode = this.status.hashCode() * 31;
        T t10 = this.data;
        return hashCode + (t10 == null ? 0 : t10.hashCode());
    }

    public String toString() {
        DataStatus dataStatus = this.status;
        T t10 = this.data;
        return "Data(status=" + dataStatus + ", data=" + t10 + ")";
    }
}
