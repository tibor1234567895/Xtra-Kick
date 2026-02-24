package com.github.andreyasadchy.xtra.model.retrofit.kick;

import java.util.List;
import xa.j;

public final class SearchResult {
    private final int found;
    private final List<SearchHit> hits;
    private final int page;

    public SearchResult(int i10, int i11, List<SearchHit> list) {
        j.f("hits", list);
        this.found = i10;
        this.page = i11;
        this.hits = list;
    }

    public static /* synthetic */ SearchResult copy$default(SearchResult searchResult, int i10, int i11, List<SearchHit> list, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = searchResult.found;
        }
        if ((i12 & 2) != 0) {
            i11 = searchResult.page;
        }
        if ((i12 & 4) != 0) {
            list = searchResult.hits;
        }
        return searchResult.copy(i10, i11, list);
    }

    public final int component1() {
        return this.found;
    }

    public final int component2() {
        return this.page;
    }

    public final List<SearchHit> component3() {
        return this.hits;
    }

    public final SearchResult copy(int i10, int i11, List<SearchHit> list) {
        j.f("hits", list);
        return new SearchResult(i10, i11, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchResult)) {
            return false;
        }
        SearchResult searchResult = (SearchResult) obj;
        return this.found == searchResult.found && this.page == searchResult.page && j.a(this.hits, searchResult.hits);
    }

    public final int getFound() {
        return this.found;
    }

    public final List<SearchHit> getHits() {
        return this.hits;
    }

    public final int getPage() {
        return this.page;
    }

    public int hashCode() {
        return this.hits.hashCode() + (((this.found * 31) + this.page) * 31);
    }

    public String toString() {
        int i10 = this.found;
        int i11 = this.page;
        List<SearchHit> list = this.hits;
        return "SearchResult(found=" + i10 + ", page=" + i11 + ", hits=" + list + ")";
    }
}
