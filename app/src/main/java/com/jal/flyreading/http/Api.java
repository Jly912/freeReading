package com.jal.flyreading.http;

/**
 * Created by SEELE on 2017/4/6.
 * 主要API接口
 */

public interface Api {

    // 获取界面启动图像
    // start_image后面为图像分辨率
    //String START_IMAGE = "http://news-at.zhihu.com/api/4/start-image/1080*1776";

    //最新消息
    String ZHIHU_LATEST = "http://news-at.zhihu.com/api/4/news/latest";

    //使用在 最新消息 中获得的 id，拼接在 http://news-at.zhihu.com/api/4/news/ 后，得到对应消息 JSON 格式的内容
    String ZHIHU_NEWS = "http://news-at.zhihu.com/api/4/news/";

    //若果需要查询 11 月 18 日的消息，before 后的数字应为 20131119
    //知乎日报的生日为 2013 年 5 月 19 日，若 before 后数字小于 20130520 ，只会接收到空消息
    String ZHIHU_HISTORY = "http://news-at.zhihu.com/api/4/news/before/";

    // 新闻额外消息
    // 输入新闻的ID，获取对应新闻的额外信息，如评论数量，所获的『赞』的数量。
    // example:http://news-at.zhihu.com/api/4/story-extra/#{id}
    // String STORY_EXTRA = "http://news-at.zhihu.com/api/4/story-extra/";

    // 新闻对应长评论查看， 使用在 最新消息 中获得的 id
    // 在 http://news-at.zhihu.com/api/4/story/#{id}/long-comments 中将 id 替换为对应的 id
    // 得到长评论 JSON 格式的内容，新闻对应短评论查看
    // http://news-at.zhihu.com/api/4/story/4232852/short-comments


    // 使用在 最新消息 中获得的 id
    // 在 http://news-at.zhihu.com/api/4/story/#{id}/short-comments 中将 id 替换为对应的 id
    // 得到短评论 JSON 格式的内容
    // String COMMENTS = "http://news-at.zhihu.com/api/4/story/";

    // 主题日报列表查看
    // String THEMES = "http://news-at.zhihu.com/api/4/themes";

    // 主题日报内容查看
    // http://news-at.zhihu.com/api/4/theme/11
    // 使用在 主题日报列表查看 中获得需要查看的主题日报的 id
    // 拼接在 http://news-at.zhihu.com/api/4/theme/ 后
    // 得到对应主题日报 JSON 格式的内容
    // String THEME = "http://news-at.zhihu.com/api/4/theme/";

    // 热门消息
    // 请注意！ 此 API 仍可访问，但是其内容未出现在最新的『知乎日报』 App 中。
    // String HOT = "http://news-at.zhihu.com/api/3/news/hot";

    // 查看新闻的推荐者
    // "http://news-at.zhihu.com/api/4/story/#{id}/recommenders"
    // 将新闻id填入到#{id}的位置

    // 获取某个专栏之前的新闻
    // http://news-at.zhihu.com/api/4/theme/#{theme id}/before/#{id}
    // 将专栏id填入到 #{theme id}, 将新闻id填入到#{id}
    // 如 http://news-at.zhihu.com/api/4/theme/11/before/7119483
    // 注：新闻id要是属于该专栏，否则，返回结果为空

    // 查看editor的主页
    // http://news-at.zhihu.com/api/4/editor/#{id}/profile-page/android

    // Guokr base url
    // public static final String GUOKR_ARTICLE_BASE_URL = "http://apis.guokr.com/handpick/article.json";
    // 获取果壳文章的具体信息 V2
    //String GUOKR_ARTICLE_LINK_V2 = "http://jingxuan.guokr.com/pick/v2/";

    // 获取果壳精选的轮播文章列表
    // String GUOKR_HANDPICK_CAROUSEL = "http://apis.guokr.com/flowingboard/item/handpick_carousel.json";

    // 获取果壳精选的文章列表,通过组合相应的参数成为完整的url
    String GUOKR_ARTICLES = "http://apis.guokr.com/handpick/article.json?retrieve_type=by_since&category=all&limit=25&ad=1";

    // 获取果壳文章的具体信息 V1
    String GUOKR_ARTICLES_DETAIL = "http://jingxuan.guokr.com/pick/";

    // 豆瓣一刻
    // 根据日期查询消息列表
    // eg:https://moment.douban.com/api/stream/date/2016-08-11
    String DOUBAN_MOMENT = "https://moment.douban.com/api/stream/date/";

    // 获取文章具体内容
    // eg:https://moment.douban.com/api/post/100484
    String DOUBAN_ARTICLE_DETAIL = "https://moment.douban.com/api/post/";

}
