package com.github.andreyasadchy.xtra.model.retrofit.kick.post;

import xa.j;

public final class SearchData {
    private final PresetType preset;

    /* renamed from: q  reason: collision with root package name */
    private final String f3333q;

    public SearchData(PresetType presetType, String str) {
        j.f("preset", presetType);
        j.f("q", str);
        this.preset = presetType;
        this.f3333q = str;
    }

    public static /* synthetic */ SearchData copy$default(SearchData searchData, PresetType presetType, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            presetType = searchData.preset;
        }
        if ((i10 & 2) != 0) {
            str = searchData.f3333q;
        }
        return searchData.copy(presetType, str);
    }

    public final PresetType component1() {
        return this.preset;
    }

    public final String component2() {
        return this.f3333q;
    }

    public final SearchData copy(PresetType presetType, String str) {
        j.f("preset", presetType);
        j.f("q", str);
        return new SearchData(presetType, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchData)) {
            return false;
        }
        SearchData searchData = (SearchData) obj;
        return this.preset == searchData.preset && j.a(this.f3333q, searchData.f3333q);
    }

    public final PresetType getPreset() {
        return this.preset;
    }

    public final String getQ() {
        return this.f3333q;
    }

    public int hashCode() {
        return this.f3333q.hashCode() + (this.preset.hashCode() * 31);
    }

    public String toString() {
        PresetType presetType = this.preset;
        String str = this.f3333q;
        return "SearchData(preset=" + presetType + ", q=" + str + ")";
    }
}
