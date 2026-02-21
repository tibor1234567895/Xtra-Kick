package com.github.andreyasadchy.xtra.model.retrofit.kick.post;

import java.util.List;
import xa.j;

public final class SearchRequest {
    private final List<SearchData> searches;

    public SearchRequest(List<SearchData> list) {
        j.f("searches", list);
        this.searches = list;
    }

    public static /* synthetic */ SearchRequest copy$default(SearchRequest searchRequest, List<SearchData> list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = searchRequest.searches;
        }
        return searchRequest.copy(list);
    }

    public final List<SearchData> component1() {
        return this.searches;
    }

    public final SearchRequest copy(List<SearchData> list) {
        j.f("searches", list);
        return new SearchRequest(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SearchRequest) && j.a(this.searches, ((SearchRequest) obj).searches);
    }

    public final List<SearchData> getSearches() {
        return this.searches;
    }

    public int hashCode() {
        return this.searches.hashCode();
    }

    public String toString() {
        List<SearchData> list = this.searches;
        return "SearchRequest(searches=" + list + ")";
    }
}
