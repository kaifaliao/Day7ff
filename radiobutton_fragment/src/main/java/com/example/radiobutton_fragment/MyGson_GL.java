package com.example.radiobutton_fragment;

import java.util.List;

/**
 * Created by John on 2018/4/18 0018.
 */

public class MyGson_GL {
    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-01-07 19:29","title":"沙画版2018新年贺词：习主席说了这么多\u201c知心话\u201d","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20180107/Img527450435_ss.jpeg","url":"http://news.sohu.com/20180107/n527450434.shtml"},{"ctime":"2017-12-26 11:15","title":"赵克志在北京调研时强调 牢记人民公安为人民的初心使命 着力加强和改进新时代公安基层基础工作","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20171226/Img526348973_ss.jpeg","url":"http://news.sohu.com/20171226/n526348972.shtml"},{"ctime":"2017-12-26 00:48","title":"贵州遵义连续4年进入中国最安全城市排行榜","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20171120/Img522928933_ss.gif","url":"http://news.sohu.com/20171226/n526315453.shtml"},{"ctime":"2017-12-07 20:01","title":"习近平举行仪式欢迎马尔代夫总统访华","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20171120/Img522928933_ss.gif","url":"http://news.sohu.com/20171207/n524619786.shtml"},{"ctime":"2017-11-20 20:11","title":"习近平：全面贯彻党的十九大精神 坚定不移将改革推向深入","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20171120/Img522928933_ss.gif","url":"http://news.sohu.com/20171120/n522957522.shtml"},{"ctime":"2017-11-20 16:22","title":"习总书记一再邀请他坐到自己身边，这位广东老人到底是谁？","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20171120/Img522928933_ss.gif","url":"http://news.sohu.com/20171120/n522928932.shtml"},{"ctime":"2017-11-14 21:25","title":"今天，习近平在老挝见了一些很特别的朋友","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20171114/Img522403934_ss.jpeg","url":"http://news.sohu.com/20171114/n522403931.shtml"},{"ctime":"2017-11-11 12:42","title":"十九大后习近平首次国外演讲 这些话真给力","description":"搜狐国内","picUrl":"","url":"http://news.sohu.com/20171111/n522107004.shtml"},{"ctime":"2017-11-11 22:36","title":"赵乐际出席全国推开国家监察体制改革试点工作动员部署电视电话会议并在山西调研","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20171110/Img522074832_ss.jpeg","url":"http://news.sohu.com/20171111/n522140862.shtml"},{"ctime":"2017-11-11 22:49","title":"习近平会见安倍晋三：以建设性方式妥善管控两国分歧","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20171111/Img522141483_ss.jpg","url":"http://news.sohu.com/20171111/n522141275.shtml"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2018-01-07 19:29
         * title : 沙画版2018新年贺词：习主席说了这么多“知心话”
         * description : 搜狐国内
         * picUrl : http://photocdn.sohu.com/20180107/Img527450435_ss.jpeg
         * url : http://news.sohu.com/20180107/n527450434.shtml
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
