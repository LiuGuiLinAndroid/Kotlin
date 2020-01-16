package com.liuguilin.kotlintools.bean;

/**
 * FileName: MovieBean
 * Founder: LiuGuiLin
 * Profile:
 */
public class MovieBean {


    /**
     * reason : 请求成功
     * result : {"h5url":"http://v.juhe.cn/wepiao/go?key=1b761c8592429978d8d9ea1245bc83aa","h5weixin":"http://v.juhe.cn/wepiao/go?key=1b761c8592429978d8d9ea1245bc83aa&s=weixin"}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * h5url : http://v.juhe.cn/wepiao/go?key=1b761c8592429978d8d9ea1245bc83aa
         * h5weixin : http://v.juhe.cn/wepiao/go?key=1b761c8592429978d8d9ea1245bc83aa&s=weixin
         */

        private String h5url;
        private String h5weixin;

        public String getH5url() {
            return h5url;
        }

        public void setH5url(String h5url) {
            this.h5url = h5url;
        }

        public String getH5weixin() {
            return h5weixin;
        }

        public void setH5weixin(String h5weixin) {
            this.h5weixin = h5weixin;
        }
    }
}
