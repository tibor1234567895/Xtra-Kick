package com.github.andreyasadchy.xtra.model.retrofit.kick;

import java.util.List;
import xa.j;

public final class MultiSearch {
    private final List<SearchResult> results;

    public MultiSearch(List<SearchResult> list) {
        j.f("results", list);
        this.results = list;
    }

    public static /* synthetic */ MultiSearch copy$default(MultiSearch multiSearch, List<SearchResult> list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = multiSearch.results;
        }
        return multiSearch.copy(list);
    }

    public final List<SearchResult> component1() {
        return this.results;
    }

    public final MultiSearch copy(List<SearchResult> list) {
        j.f("results", list);
        return new MultiSearch(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiSearch) && j.a(this.results, ((MultiSearch) obj).results);
    }

    public final List<SearchResult> getResults() {
        return this.results;
    }

    public int hashCode() {
        return this.results.hashCode();
    }

    public String toString() {
        List<SearchResult> list = this.results;
        return "MultiSearch(results=" + list + ")";
    }
}
