package com.github.andreyasadchy.xtra.model.retrofit.kick.v1;

import k9.b;
import q0.f;
import xa.j;

public final class Response<T> {
    @b("current_page")
    private final int currentPage;
    private final T data;
    @b("first_page_url")
    private final String firstPageUrl;
    @b("next_page_url")
    private final String nextPageUrl;
    @b("per_page")
    private final int perPage;
    @b("prev_page_url")
    private final String prevPageUrl;

    public Response(int i10, String str, String str2, String str3, int i11, T t10) {
        this.currentPage = i10;
        this.firstPageUrl = str;
        this.nextPageUrl = str2;
        this.prevPageUrl = str3;
        this.perPage = i11;
        this.data = t10;
    }

    public static /* synthetic */ Response copy$default(Response response, int i10, String str, String str2, String str3, int i11, T t10, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = response.currentPage;
        }
        if ((i12 & 2) != 0) {
            str = response.firstPageUrl;
        }
        String str4 = str;
        if ((i12 & 4) != 0) {
            str2 = response.nextPageUrl;
        }
        String str5 = str2;
        if ((i12 & 8) != 0) {
            str3 = response.prevPageUrl;
        }
        String str6 = str3;
        if ((i12 & 16) != 0) {
            i11 = response.perPage;
        }
        int i13 = i11;
        if ((i12 & 32) != 0) {
            t10 = response.data;
        }
        return response.copy(i10, str4, str5, str6, i13, t10);
    }

    public final int component1() {
        return this.currentPage;
    }

    public final String component2() {
        return this.firstPageUrl;
    }

    public final String component3() {
        return this.nextPageUrl;
    }

    public final String component4() {
        return this.prevPageUrl;
    }

    public final int component5() {
        return this.perPage;
    }

    public final T component6() {
        return this.data;
    }

    public final Response<T> copy(int i10, String str, String str2, String str3, int i11, T t10) {
        return new Response(i10, str, str2, str3, i11, t10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Response)) {
            return false;
        }
        Response response = (Response) obj;
        return this.currentPage == response.currentPage && j.a(this.firstPageUrl, response.firstPageUrl) && j.a(this.nextPageUrl, response.nextPageUrl) && j.a(this.prevPageUrl, response.prevPageUrl) && this.perPage == response.perPage && j.a(this.data, response.data);
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    public final T getData() {
        return this.data;
    }

    public final String getFirstPageUrl() {
        return this.firstPageUrl;
    }

    public final String getNextPageUrl() {
        return this.nextPageUrl;
    }

    public final int getPerPage() {
        return this.perPage;
    }

    public final String getPrevPageUrl() {
        return this.prevPageUrl;
    }

    public int hashCode() {
        int i10 = this.currentPage * 31;
        String str = this.firstPageUrl;
        int i11 = 0;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.nextPageUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.prevPageUrl;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.perPage) * 31;
        T t10 = this.data;
        if (t10 != null) {
            i11 = t10.hashCode();
        }
        return hashCode3 + i11;
    }

    public String toString() {
        int i10 = this.currentPage;
        String str = this.firstPageUrl;
        String str2 = this.nextPageUrl;
        String str3 = this.prevPageUrl;
        int i11 = this.perPage;
        T t10 = this.data;
        StringBuilder sb2 = new StringBuilder("Response(currentPage=");
        sb2.append(i10);
        sb2.append(", firstPageUrl=");
        sb2.append(str);
        sb2.append(", nextPageUrl=");
        f.k(sb2, str2, ", prevPageUrl=", str3, ", perPage=");
        sb2.append(i11);
        sb2.append(", data=");
        sb2.append(t10);
        sb2.append(")");
        return sb2.toString();
    }
}
