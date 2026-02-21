package com.github.andreyasadchy.xtra.model.retrofit.kick;

import xa.j;

public final class SearchHit {
    private final SearchDocument document;

    public SearchHit(SearchDocument searchDocument) {
        j.f("document", searchDocument);
        this.document = searchDocument;
    }

    public static /* synthetic */ SearchHit copy$default(SearchHit searchHit, SearchDocument searchDocument, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            searchDocument = searchHit.document;
        }
        return searchHit.copy(searchDocument);
    }

    public final SearchDocument component1() {
        return this.document;
    }

    public final SearchHit copy(SearchDocument searchDocument) {
        j.f("document", searchDocument);
        return new SearchHit(searchDocument);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SearchHit) && j.a(this.document, ((SearchHit) obj).document);
    }

    public final SearchDocument getDocument() {
        return this.document;
    }

    public int hashCode() {
        return this.document.hashCode();
    }

    public String toString() {
        SearchDocument searchDocument = this.document;
        return "SearchHit(document=" + searchDocument + ")";
    }
}
