package com.liuguilin.kotlintools.bean;

import java.util.List;

/**
 * FileName: JokeBean
 * Founder: LiuGuiLin
 * Profile:
 */
public class JokeBean {


    /**
     * reason : success
     * result : [{"content":"\u200d\u200d\u200d\u200d记者：\u201c许仙先生，你和妻子这么多年保持爱情新鲜的秘诀是什么？\u201d 许仙：\u201c每天我下班回家，她都迎上来给我一个蛇吻。\u201d\u200d\u200d\u200d\u200d","hashId":"671124C4196663E8122C4FDC4B60CAC5","unixtime":1437575665},{"content":"\u200d\u200d\u200d\u200d今天逗比了，一客户给我打招呼，很热情的样子。 手里拿着一袋瓜子，朝我方向走过来，然后倒出点瓜子在手心。 有瓜子的那只手伸向我说：\u201c把那资料给我看看！\u201d 我居然说：\u201c不吃。\u201d 我真想多了。\u200d\u200d\u200d\u200d","hashId":"D67AE38C3441749BB005511702342A5B","unixtime":1437576211},{"content":"有一同事住我家隔壁。昨天十万火急给我来电话，说：\u201c兄弟我家断网了，现在急需用网想去你家上半个小时解决了先。很急！\u201d我：\u201c都这么久兄弟了，还需要打我电话问么，我老婆在家。你急，直接去上就是了。随便上。\u201d他TM竟然说：上你老婆？那怎么好意思呢！","hashId":"3098c221e68d492ced214c82664efc7c","unixtime":1437576232},{"content":"同事辞职，昨晚请他去喝酒！酒至半酣，他一把拉住我\u201c哥，只有你对我好，我得报答你\u201d\u201c嗯？\u201d\u201c公司第三厂房女厕所知道吧？\u201d\u201c嗯\u201d\u201c女厕所后面有一排树，靠近第四厂房正数第三颗往那一蹲，嗯，有wifi、三格！\u201d","hashId":"5afdd13ba93ca2c05cc661e5153e5125","unixtime":1437576232},{"content":"老婆回家对老公大怒：你是不是和我秘书有一腿？老公：是啊！我不是经过你同意了吗？老婆：你放屁，我什么时候同意过的？老公：我问你秘书小美能不能干，你说能干。","hashId":"dbd44c22b5a127ec21ac987e16525553","unixtime":1437576232},{"content":"女上司责骂我的工作状态，我一直低头不语。这样的反应可能激怒了她，她一改平静的语气，咆哮道：\u201c你为什么不说话，你不服吗！\u201d我解释说：\u201c不是，我女朋友不让我跟漂亮女人说话！","hashId":"0da7ff4bea8f046f2abc4850d1351eee","unixtime":1437576232},{"content":"闺蜜应聘上了一公司老板秘书，一上班老板娘就训话：\u201c做女秘书要懂规矩，不要像前任那样！！\u201d\u201c老板娘，前任秘书怎么了？\u201d\u201c我就是前任！\u201d。。。","hashId":"a92f8e3402d117c36fadf35a960a4c01","unixtime":1437576232},{"content":"女朋友拿着手机对我说：\u201c我觉得这拖把不错，我们买一个吧？\u201d\u201c不错什么！\u201d我站起来指着她说：\u201c啥时候我用的东西轮到你做决定了！\u201d","hashId":"6a01d519ff36b2a09458a9d93047102f","unixtime":1437576232},{"content":"小朋友，你要知道：在对不起前面加个阿姨，这样的道歉基本上是没用的。","hashId":"f1afcece74351768b338cb2320166c2d","unixtime":1437576232},{"content":"果然和人聊天不能太敷衍。。。刚刚室友讲到女朋友爱说梦话，我随口接了一句我知道，现在气氛变得十分微妙。","hashId":"cde62d88a9f689d536716f34e3dcd088","unixtime":1437576232}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<ResultBean> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * content : ‍‍‍‍记者：“许仙先生，你和妻子这么多年保持爱情新鲜的秘诀是什么？” 许仙：“每天我下班回家，她都迎上来给我一个蛇吻。”‍‍‍‍
         * hashId : 671124C4196663E8122C4FDC4B60CAC5
         * unixtime : 1437575665
         */

        private String content;
        private String hashId;
        private int unixtime;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHashId() {
            return hashId;
        }

        public void setHashId(String hashId) {
            this.hashId = hashId;
        }

        public int getUnixtime() {
            return unixtime;
        }

        public void setUnixtime(int unixtime) {
            this.unixtime = unixtime;
        }
    }
}
