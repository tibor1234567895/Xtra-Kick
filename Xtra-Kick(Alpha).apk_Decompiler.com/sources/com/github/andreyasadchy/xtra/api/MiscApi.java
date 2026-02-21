package com.github.andreyasadchy.xtra.api;

import com.github.andreyasadchy.xtra.model.chat.StvGlobalResponse;
import com.github.andreyasadchy.xtra.model.retrofit.stv.KickUser;
import pa.e;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MiscApi {
    @GET("https://7tv.io/v3/emote-sets/global")
    Object getGlobalStvEmotes(e<? super Response<StvGlobalResponse>> eVar);

    @GET("https://7tv.io/v3/users/kick/{userId}")
    Object getKickUser(@Path("userId") int i10, e<? super KickUser> eVar);
}
