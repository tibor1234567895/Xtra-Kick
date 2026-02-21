package com.github.andreyasadchy.xtra.model.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.h;
import xa.f;
import xa.j;

public final class Tag implements Parcelable {
    public static final Parcelable.Creator<Tag> CREATOR = new Creator();
    private final String id;
    private final String name;
    private final String scope;

    public static final class Creator implements Parcelable.Creator<Tag> {
        public final Tag createFromParcel(Parcel parcel) {
            j.f("parcel", parcel);
            return new Tag(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Tag[] newArray(int i10) {
            return new Tag[i10];
        }
    }

    public Tag() {
        this((String) null, (String) null, (String) null, 7, (f) null);
    }

    public static /* synthetic */ Tag copy$default(Tag tag, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = tag.id;
        }
        if ((i10 & 2) != 0) {
            str2 = tag.name;
        }
        if ((i10 & 4) != 0) {
            str3 = tag.scope;
        }
        return tag.copy(str, str2, str3);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.scope;
    }

    public final Tag copy(String str, String str2, String str3) {
        return new Tag(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        return j.a(this.id, tag.id) && j.a(this.name, tag.name) && j.a(this.scope, tag.scope);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getScope() {
        return this.scope;
    }

    public int hashCode() {
        String str = this.id;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.scope;
        if (str3 != null) {
            i10 = str3.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        String str = this.id;
        String str2 = this.name;
        String str3 = this.scope;
        StringBuilder sb2 = new StringBuilder("Tag(id=");
        sb2.append(str);
        sb2.append(", name=");
        sb2.append(str2);
        sb2.append(", scope=");
        return h.p(sb2, str3, ")");
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.f("out", parcel);
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.scope);
    }

    public Tag(String str, String str2, String str3) {
        this.id = str;
        this.name = str2;
        this.scope = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Tag(String str, String str2, String str3, int i10, f fVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
    }
}
