package com.github.andreyasadchy.xtra.api;

import com.github.andreyasadchy.xtra.model.retrofit.kick.MultiSearch;
import com.github.andreyasadchy.xtra.model.retrofit.kick.post.SearchRequest;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Response;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Stream;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Subcategories;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Video;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Channel;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.ClipResponse;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Data;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Livestream;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.MessagesResponse;
import java.util.List;
import pa.e;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface KickApi {
    @GET("/api/v2/channels/{channel_slug}")
    Object getChannel(@Path("channel_slug") String str, e<? super Channel> eVar);

    @GET("/api/v1/channels/{channel_slug}")
    Object getChannelLegacy(@Path("channel_slug") String str, e<? super com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Channel> eVar);

    @GET("/api/v2/categories/{subcategory}/clips")
    Object getClips(@Path("subcategory") String str, @Query("cursor") int i10, @Query("limit") int i11, @Query("sort") String str2, @Query("time") String str3, e<? super ClipResponse> eVar);

    @GET("/api/v2/channels/{channel}/clips")
    Object getClipsForChannel(@Path("channel") String str, @Query("cursor") int i10, @Query("limit") int i11, @Query("sort") String str2, @Query("time") String str3, e<? super ClipResponse> eVar);

    @GET("/api/v2/channels/{channel_slug}/livestream")
    Object getLivestream(@Path("channel_slug") String str, e<? super Data<Livestream>> eVar);

    @GET("/api/v2/channels/{channel_id}/messages")
    Object getRecentMessages(@Path("channel_id") int i10, e<? super Data<MessagesResponse>> eVar);

    @GET("/api/v1/subcategories")
    Object getSubcategories(@Query("page") int i10, @Query("limit") int i11, e<? super Response<List<Subcategories>>> eVar);

    @GET("/stream/livestreams/en")
    Object getSubcategoryStreams(@Query("page") int i10, @Query("subcategory") String str, @Query("limit") int i11, @Query("sort") String str2, e<? super Response<List<Stream>>> eVar);

    @GET("/api/v1/video/{uuid}")
    Object getVideo(@Path("uuid") String str, e<? super Video> eVar);

    @POST("https://search.kick.com/multi_search")
    @Headers({"X-Typesense-Api-Key: nXIMW0iEN6sMujFYjFuhdrSwVow3pDQu"})
    Object loadSearchResult(@Body SearchRequest searchRequest, e<? super MultiSearch> eVar);
}
