package c6;

import com.github.andreyasadchy.xtra.model.chat.KickEmote;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v1.CategoriesItem;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v1.LivestreamVideo;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Video;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Category;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Channel;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Clip;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.ClipChannel;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Livestream;
import com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Thumbnail;
import com.github.andreyasadchy.xtra.model.ui.Stream;
import com.github.andreyasadchy.xtra.model.ui.User;
import fb.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import ma.s;
import ma.z;
import s7.h;
import xa.f;
import xa.j;

public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final a f2971b = new a(0);

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f2972c = Pattern.compile("\\[emote:(\\d+):([^]]*)]");

    /* renamed from: a  reason: collision with root package name */
    public final h f2973a;

    @Inject
    public b(h hVar) {
        j.f("twitchApiHelper", hVar);
        this.f2973a = hVar;
    }

    public static ArrayList a(String str) {
        Matcher matcher = f2972c.matcher(str);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            MatchResult matchResult = matcher.toMatchResult();
            int start = matchResult.start();
            int end = matchResult.end();
            String group = matchResult.group(1);
            j.e("match.group(1)", group);
            Integer d10 = v.d(group);
            int intValue = d10 != null ? d10.intValue() : 0;
            String group2 = matchResult.group(2);
            matchResult.group();
            String valueOf = String.valueOf(intValue);
            j.e("emoteName", group2);
            arrayList.add(new KickEmote(valueOf, group2, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, false, start, end - 1, (String) null, 0, 6652, (f) null));
        }
        return arrayList;
    }

    public static Stream b(Channel channel) {
        String str;
        Thumbnail thumbnail;
        String url;
        j.f("channel", channel);
        Livestream livestream = channel.getLivestream();
        String str2 = null;
        Category category = livestream != null ? livestream.getCategory() : null;
        int id = livestream != null ? livestream.getId() : 0;
        int id2 = channel.getId();
        String slug = channel.getSlug();
        String username = channel.getUser().getUsername();
        int id3 = category != null ? category.getId() : 0;
        String name = category != null ? category.getName() : null;
        if (livestream == null || (str = livestream.getTitle()) == null) {
            str = "";
        }
        String str3 = str;
        Integer valueOf = livestream != null ? Integer.valueOf(livestream.getViewers()) : null;
        String createdAt = livestream != null ? livestream.getCreatedAt() : null;
        a aVar = f2971b;
        String a10 = (livestream == null || (thumbnail = livestream.getThumbnail()) == null || (url = thumbnail.getUrl()) == null) ? null : a.a(aVar, url);
        String profilePicture = channel.getUser().getProfilePicture();
        if (profilePicture != null) {
            str2 = a.a(aVar, profilePicture);
        }
        return new Stream(id, id2, slug, username, id3, name, (String) null, (String) null, str3, valueOf, createdAt, a10, str2, (String) null, (List) null, (User) null, 57408, (f) null);
    }

    public static ArrayList c(List list) {
        j.f("clips", list);
        ArrayList arrayList = new ArrayList(s.i(list));
        for (Iterator it = list.iterator(); it.hasNext(); it = it) {
            Clip clip = (Clip) it.next();
            ClipChannel channel = clip.getChannel();
            Category category = clip.getCategory();
            String valueOf = String.valueOf(clip.getId());
            int id = channel.getId();
            String username = channel.getUsername();
            String valueOf2 = String.valueOf(clip.getId());
            int id2 = category.getId();
            String title = clip.getTitle();
            int viewCount = clip.getViewCount();
            String createdAt = clip.getCreatedAt();
            String thumbnailUrl = clip.getThumbnailUrl();
            a aVar = f2971b;
            String a10 = a.a(aVar, thumbnailUrl);
            String name = category.getName();
            String slug = clip.getCategory().getSlug();
            String username2 = channel.getUsername();
            String a11 = a.a(aVar, channel.getProfilePicture());
            arrayList = arrayList;
            arrayList.add(new com.github.andreyasadchy.xtra.model.ui.Clip(valueOf, id, username, valueOf2, id2, slug, title, Integer.valueOf(viewCount), createdAt, a10, Double.valueOf((double) clip.getDuration()), (Integer) null, clip.getVideoUrl(), name, username2, (String) null, a11, (String) null, 32768, (f) null));
        }
        return arrayList;
    }

    public static ArrayList d(List list) {
        CategoriesItem categoriesItem;
        com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Channel channel;
        com.github.andreyasadchy.xtra.model.retrofit.kick.v1.User user;
        int i10;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Integer num;
        Integer num2;
        String str6;
        int i11;
        String str7;
        String str8;
        String str9;
        String profilepic;
        String thumbnail;
        List<CategoriesItem> categories;
        j.f("videos", list);
        ArrayList arrayList = new ArrayList(s.i(list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Video video = (Video) it.next();
            j.f("video", video);
            LivestreamVideo livestream = video.getLivestream();
            if (livestream == null || (categories = livestream.getCategories()) == null) {
                categoriesItem = null;
            } else {
                categoriesItem = (CategoriesItem) z.u(categories);
            }
            if (livestream != null) {
                channel = livestream.getChannel();
            } else {
                channel = null;
            }
            if (channel != null) {
                user = channel.getUser();
            } else {
                user = null;
            }
            String uuid = video.getUuid();
            if (livestream != null) {
                i10 = livestream.getChannelId();
            } else {
                i10 = 0;
            }
            if (channel != null) {
                str = channel.getSlug();
            } else {
                str = null;
            }
            if (user != null) {
                str2 = user.getUsername();
            } else {
                str2 = null;
            }
            if (livestream != null) {
                str3 = livestream.getTitle();
            } else {
                str3 = null;
            }
            if (livestream != null) {
                str4 = livestream.getCreatedAt();
            } else {
                str4 = null;
            }
            a aVar = f2971b;
            if (livestream == null || (thumbnail = livestream.getThumbnail()) == null) {
                str5 = null;
            } else {
                str5 = a.a(aVar, thumbnail);
            }
            if (livestream != null) {
                num = Integer.valueOf(livestream.getViewerCount());
            } else {
                num = null;
            }
            if (livestream != null) {
                num2 = Integer.valueOf(livestream.getDuration() / 1000);
            } else {
                num2 = null;
            }
            String valueOf = String.valueOf(num2);
            String source = video.getSource();
            if (source != null) {
                str6 = a.a(aVar, source);
            } else {
                str6 = null;
            }
            if (categoriesItem != null) {
                i11 = categoriesItem.getCategoryId();
            } else {
                i11 = 0;
            }
            if (categoriesItem != null) {
                str7 = categoriesItem.getName();
            } else {
                str7 = null;
            }
            if (categoriesItem != null) {
                str8 = categoriesItem.getSlug();
            } else {
                str8 = null;
            }
            if (user == null || (profilepic = user.getProfilepic()) == null) {
                str9 = null;
            } else {
                str9 = a.a(aVar, profilepic);
            }
            com.github.andreyasadchy.xtra.model.ui.Video video2 = r8;
            com.github.andreyasadchy.xtra.model.ui.Video video3 = new com.github.andreyasadchy.xtra.model.ui.Video(uuid, i10, str, str2, str3, str4, str5, num, (String) null, valueOf, str6, i11, str7, str8, (String) null, str9, (List) null, (String) null, 212992, (f) null);
            arrayList.add(video2);
        }
        return arrayList;
    }
}
