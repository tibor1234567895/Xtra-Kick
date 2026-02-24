package com.github.andreyasadchy.xtra.model.offline;

import android.os.Parcel;
import android.os.Parcelable;
import q0.f;
import xa.j;

public final class SortGame implements Parcelable {
    public static final Parcelable.Creator<SortGame> CREATOR = new Creator();
    private Integer clipLanguageIndex;
    private String clipPeriod;
    private final String id;
    private Boolean saveSort;
    private Integer videoLanguageIndex;
    private String videoPeriod;
    private String videoSort;
    private String videoType;

    public static final class Creator implements Parcelable.Creator<SortGame> {
        public final SortGame createFromParcel(Parcel parcel) {
            Boolean bool;
            j.f("parcel", parcel);
            String readString = parcel.readString();
            if (parcel.readInt() == 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new SortGame(readString, bool, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        public final SortGame[] newArray(int i10) {
            return new SortGame[i10];
        }
    }

    public SortGame(String str, Boolean bool, String str2, String str3, String str4, Integer num, String str5, Integer num2) {
        j.f("id", str);
        this.id = str;
        this.saveSort = bool;
        this.videoSort = str2;
        this.videoPeriod = str3;
        this.videoType = str4;
        this.videoLanguageIndex = num;
        this.clipPeriod = str5;
        this.clipLanguageIndex = num2;
    }

    public static /* synthetic */ SortGame copy$default(SortGame sortGame, String str, Boolean bool, String str2, String str3, String str4, Integer num, String str5, Integer num2, int i10, Object obj) {
        SortGame sortGame2 = sortGame;
        int i11 = i10;
        return sortGame.copy((i11 & 1) != 0 ? sortGame2.id : str, (i11 & 2) != 0 ? sortGame2.saveSort : bool, (i11 & 4) != 0 ? sortGame2.videoSort : str2, (i11 & 8) != 0 ? sortGame2.videoPeriod : str3, (i11 & 16) != 0 ? sortGame2.videoType : str4, (i11 & 32) != 0 ? sortGame2.videoLanguageIndex : num, (i11 & 64) != 0 ? sortGame2.clipPeriod : str5, (i11 & 128) != 0 ? sortGame2.clipLanguageIndex : num2);
    }

    public final String component1() {
        return this.id;
    }

    public final Boolean component2() {
        return this.saveSort;
    }

    public final String component3() {
        return this.videoSort;
    }

    public final String component4() {
        return this.videoPeriod;
    }

    public final String component5() {
        return this.videoType;
    }

    public final Integer component6() {
        return this.videoLanguageIndex;
    }

    public final String component7() {
        return this.clipPeriod;
    }

    public final Integer component8() {
        return this.clipLanguageIndex;
    }

    public final SortGame copy(String str, Boolean bool, String str2, String str3, String str4, Integer num, String str5, Integer num2) {
        j.f("id", str);
        return new SortGame(str, bool, str2, str3, str4, num, str5, num2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SortGame)) {
            return false;
        }
        SortGame sortGame = (SortGame) obj;
        return j.a(this.id, sortGame.id) && j.a(this.saveSort, sortGame.saveSort) && j.a(this.videoSort, sortGame.videoSort) && j.a(this.videoPeriod, sortGame.videoPeriod) && j.a(this.videoType, sortGame.videoType) && j.a(this.videoLanguageIndex, sortGame.videoLanguageIndex) && j.a(this.clipPeriod, sortGame.clipPeriod) && j.a(this.clipLanguageIndex, sortGame.clipLanguageIndex);
    }

    public final Integer getClipLanguageIndex() {
        return this.clipLanguageIndex;
    }

    public final String getClipPeriod() {
        return this.clipPeriod;
    }

    public final String getId() {
        return this.id;
    }

    public final Boolean getSaveSort() {
        return this.saveSort;
    }

    public final Integer getVideoLanguageIndex() {
        return this.videoLanguageIndex;
    }

    public final String getVideoPeriod() {
        return this.videoPeriod;
    }

    public final String getVideoSort() {
        return this.videoSort;
    }

    public final String getVideoType() {
        return this.videoType;
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() * 31;
        Boolean bool = this.saveSort;
        int i10 = 0;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.videoSort;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.videoPeriod;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.videoType;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.videoLanguageIndex;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.clipPeriod;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num2 = this.clipLanguageIndex;
        if (num2 != null) {
            i10 = num2.hashCode();
        }
        return hashCode7 + i10;
    }

    public final void setClipLanguageIndex(Integer num) {
        this.clipLanguageIndex = num;
    }

    public final void setClipPeriod(String str) {
        this.clipPeriod = str;
    }

    public final void setSaveSort(Boolean bool) {
        this.saveSort = bool;
    }

    public final void setVideoLanguageIndex(Integer num) {
        this.videoLanguageIndex = num;
    }

    public final void setVideoPeriod(String str) {
        this.videoPeriod = str;
    }

    public final void setVideoSort(String str) {
        this.videoSort = str;
    }

    public final void setVideoType(String str) {
        this.videoType = str;
    }

    public String toString() {
        String str = this.id;
        Boolean bool = this.saveSort;
        String str2 = this.videoSort;
        String str3 = this.videoPeriod;
        String str4 = this.videoType;
        Integer num = this.videoLanguageIndex;
        String str5 = this.clipPeriod;
        Integer num2 = this.clipLanguageIndex;
        StringBuilder sb2 = new StringBuilder("SortGame(id=");
        sb2.append(str);
        sb2.append(", saveSort=");
        sb2.append(bool);
        sb2.append(", videoSort=");
        f.k(sb2, str2, ", videoPeriod=", str3, ", videoType=");
        sb2.append(str4);
        sb2.append(", videoLanguageIndex=");
        sb2.append(num);
        sb2.append(", clipPeriod=");
        sb2.append(str5);
        sb2.append(", clipLanguageIndex=");
        sb2.append(num2);
        sb2.append(")");
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.f("out", parcel);
        parcel.writeString(this.id);
        Boolean bool = this.saveSort;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.videoSort);
        parcel.writeString(this.videoPeriod);
        parcel.writeString(this.videoType);
        Integer num = this.videoLanguageIndex;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.clipPeriod);
        Integer num2 = this.clipLanguageIndex;
        if (num2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(num2.intValue());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SortGame(java.lang.String r9, java.lang.Boolean r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.Integer r14, java.lang.String r15, java.lang.Integer r16, int r17, xa.f r18) {
        /*
            r8 = this;
            r0 = r17
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r2 = r16
        L_0x0034:
            r10 = r8
            r11 = r9
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.model.offline.SortGame.<init>(java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, int, xa.f):void");
    }
}
