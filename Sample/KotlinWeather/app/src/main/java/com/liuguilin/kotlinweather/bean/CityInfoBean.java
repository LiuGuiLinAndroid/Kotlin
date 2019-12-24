package com.liuguilin.kotlinweather.bean;

import java.util.List;

/**
 * FileName: CityInfoBean
 * Founder: LiuGuiLin
 * Profile:
 */
public class CityInfoBean {


    /**
     * reason : 查询成功
     * result : {"city":"南汇","realtime":{"temperature":"10","humidity":"98","info":"小雨","wid":"07","direct":"东北风","power":"2级","aqi":"50"},"future":[{"date":"2019-12-23","temperature":"9/14℃","weather":"多云转中雨","wid":{"day":"01","night":"08"},"direct":"东北风"},{"date":"2019-12-24","temperature":"9/11℃","weather":"小雨","wid":{"day":"07","night":"07"},"direct":"东北风转东风"},{"date":"2019-12-25","temperature":"11/13℃","weather":"小雨","wid":{"day":"07","night":"07"},"direct":"东风转西风"},{"date":"2019-12-26","temperature":"4/12℃","weather":"阴转多云","wid":{"day":"02","night":"01"},"direct":"北风转西北风"},{"date":"2019-12-27","temperature":"3/10℃","weather":"多云转晴","wid":{"day":"01","night":"00"},"direct":"北风转东南风"}]}
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
         * city : 南汇
         * realtime : {"temperature":"10","humidity":"98","info":"小雨","wid":"07","direct":"东北风","power":"2级","aqi":"50"}
         * future : [{"date":"2019-12-23","temperature":"9/14℃","weather":"多云转中雨","wid":{"day":"01","night":"08"},"direct":"东北风"},{"date":"2019-12-24","temperature":"9/11℃","weather":"小雨","wid":{"day":"07","night":"07"},"direct":"东北风转东风"},{"date":"2019-12-25","temperature":"11/13℃","weather":"小雨","wid":{"day":"07","night":"07"},"direct":"东风转西风"},{"date":"2019-12-26","temperature":"4/12℃","weather":"阴转多云","wid":{"day":"02","night":"01"},"direct":"北风转西北风"},{"date":"2019-12-27","temperature":"3/10℃","weather":"多云转晴","wid":{"day":"01","night":"00"},"direct":"北风转东南风"}]
         */

        private String city;
        private RealtimeBean realtime;
        private List<FutureBean> future;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public RealtimeBean getRealtime() {
            return realtime;
        }

        public void setRealtime(RealtimeBean realtime) {
            this.realtime = realtime;
        }

        public List<FutureBean> getFuture() {
            return future;
        }

        public void setFuture(List<FutureBean> future) {
            this.future = future;
        }

        public static class RealtimeBean {
            /**
             * temperature : 10
             * humidity : 98
             * info : 小雨
             * wid : 07
             * direct : 东北风
             * power : 2级
             * aqi : 50
             */

            private String temperature;
            private String humidity;
            private String info;
            private String wid;
            private String direct;
            private String power;
            private String aqi;

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public String getWid() {
                return wid;
            }

            public void setWid(String wid) {
                this.wid = wid;
            }

            public String getDirect() {
                return direct;
            }

            public void setDirect(String direct) {
                this.direct = direct;
            }

            public String getPower() {
                return power;
            }

            public void setPower(String power) {
                this.power = power;
            }

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }
        }

        public static class FutureBean {
            /**
             * date : 2019-12-23
             * temperature : 9/14℃
             * weather : 多云转中雨
             * wid : {"day":"01","night":"08"}
             * direct : 东北风
             */

            private String date;
            private String temperature;
            private String weather;
            private WidBean wid;
            private String direct;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public WidBean getWid() {
                return wid;
            }

            public void setWid(WidBean wid) {
                this.wid = wid;
            }

            public String getDirect() {
                return direct;
            }

            public void setDirect(String direct) {
                this.direct = direct;
            }

            public static class WidBean {
                /**
                 * day : 01
                 * night : 08
                 */

                private String day;
                private String night;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public String getNight() {
                    return night;
                }

                public void setNight(String night) {
                    this.night = night;
                }
            }
        }
    }
}
