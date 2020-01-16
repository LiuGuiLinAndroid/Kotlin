package com.liuguilin.kotlintools.utils

import com.liuguilin.kotlintools.R
import com.liuguilin.okhelper.utils.L


/**
 * FileName: WeatherIconUtils
 * Founder: LiuGuiLin
 * Profile:
 */
object WeatherIconUtils {

    /**
     * {
    "reason":"查询成功",
    "result":[
    {
    "wid":"00",
    "weather":"晴"
    },
    {
    "wid":"01",
    "weather":"多云"
    },
    {
    "wid":"02",
    "weather":"阴"
    },
    {
    "wid":"03",
    "weather":"阵雨"
    },
    {
    "wid":"04",
    "weather":"雷阵雨"
    },
    {
    "wid":"05",
    "weather":"雷阵雨伴有冰雹"
    },
    {
    "wid":"06",
    "weather":"雨夹雪"
    },
    {
    "wid":"07",
    "weather":"小雨"
    },
    {
    "wid":"08",
    "weather":"中雨"
    },
    {
    "wid":"09",
    "weather":"大雨"
    },
    {
    "wid":"10",
    "weather":"暴雨"
    },
    {
    "wid":"11",
    "weather":"大暴雨"
    },
    {
    "wid":"12",
    "weather":"特大暴雨"
    },
    {
    "wid":"13",
    "weather":"阵雪"
    },
    {
    "wid":"14",
    "weather":"小雪"
    },
    {
    "wid":"15",
    "weather":"中雪"
    },
    {
    "wid":"16",
    "weather":"大雪"
    },
    {
    "wid":"17",
    "weather":"暴雪"
    },
    {
    "wid":"18",
    "weather":"雾"
    },
    {
    "wid":"19",
    "weather":"冻雨"
    },
    {
    "wid":"20",
    "weather":"沙尘暴"
    },
    {
    "wid":"21",
    "weather":"小到中雨"
    },
    {
    "wid":"22",
    "weather":"中到大雨"
    },
    {
    "wid":"23",
    "weather":"大到暴雨"
    },
    {
    "wid":"24",
    "weather":"暴雨到大暴雨"
    },
    {
    "wid":"25",
    "weather":"大暴雨到特大暴雨"
    },
    {
    "wid":"26",
    "weather":"小到中雪"
    },
    {
    "wid":"27",
    "weather":"中到大雪"
    },
    {
    "wid":"28",
    "weather":"大到暴雪"
    },
    {
    "wid":"29",
    "weather":"浮尘"
    },
    {
    "wid":"30",
    "weather":"扬沙"
    },
    {
    "wid":"31",
    "weather":"强沙尘暴"
    },
    {
    "wid":"53",
    "weather":"霾"
    }
    ],
    "error_code":0
    }
     */

    fun getIcon(wid: String): Int {
        when (wid) {
            "00" -> return R.drawable.img_00
            "01" -> return R.drawable.img_01
            "02" -> return R.drawable.img_02
            "03" -> return R.drawable.img_03
            "04" -> return R.drawable.img_04
            "05" -> return R.drawable.img_05
            "06" -> return R.drawable.img_06
            "07" -> return R.drawable.img_07
            "08" -> return R.drawable.img_08
            "09" -> return R.drawable.img_09
            "10" -> return R.drawable.img_10
            "11" -> return R.drawable.img_11
            "12" -> return R.drawable.img_12
            "13" -> return R.drawable.img_13
            "14" -> return R.drawable.img_14
            "15" -> return R.drawable.img_15
            "16" -> return R.drawable.img_16
            "17" -> return R.drawable.img_17
            "18" -> return R.drawable.img_18
            "19" -> return R.drawable.img_19
            "20" -> return R.drawable.img_20
            "21" -> return R.drawable.img_21
            "22" -> return R.drawable.img_22
            "23" -> return R.drawable.img_23
            "24" -> return R.drawable.img_24
            "25" -> return R.drawable.img_25
            "26" -> return R.drawable.img_26
            "27" -> return R.drawable.img_27
            "28" -> return R.drawable.img_28
            "29" -> return R.drawable.img_29
            "30" -> return R.drawable.img_30
            "31" -> return R.drawable.img_31
            "53" -> return R.drawable.img_53
            else -> return R.drawable.img_00
        }
    }

    fun getWeatherIcon(weather: String): Int {
        when (weather) {
            "晴" -> return R.drawable.img_00
            "多云" -> return R.drawable.img_01
            "阴" -> return R.drawable.img_02
            "阵雨" -> return R.drawable.img_03
            "雷阵雨" -> return R.drawable.img_04
            "雷阵雨伴有冰雹" -> return R.drawable.img_05
            "雨夹雪" -> return R.drawable.img_06
            "小雨" -> return R.drawable.img_07
            "中雨" -> return R.drawable.img_08
            "大雨" -> return R.drawable.img_09
            "暴雨" -> return R.drawable.img_10
            "大暴雨" -> return R.drawable.img_11
            "特大暴雨" -> return R.drawable.img_12
            "阵雪" -> return R.drawable.img_13
            "小雪" -> return R.drawable.img_14
            "中雪" -> return R.drawable.img_15
            "大雪" -> return R.drawable.img_16
            "暴雪" -> return R.drawable.img_17
            "雾" -> return R.drawable.img_18
            "冻雨" -> return R.drawable.img_19
            "沙尘暴" -> return R.drawable.img_20
            "小到中雨" -> return R.drawable.img_21
            "中到大雨" -> return R.drawable.img_22
            "大到暴雨" -> return R.drawable.img_23
            "暴雨到大暴雨" -> return R.drawable.img_24
            "大暴雨到特大暴雨" -> return R.drawable.img_25
            "小到中雪" -> return R.drawable.img_26
            "中到大雪" -> return R.drawable.img_27
            "大到暴雪" -> return R.drawable.img_28
            "浮尘" -> return R.drawable.img_29
            "扬沙" -> return R.drawable.img_30
            "强沙尘暴" -> return R.drawable.img_31
            "霾" -> return R.drawable.img_53
            else -> {
                //进行裁剪
                val list = weather.split("转")
                L.i("list$list")
                if (list.size >= 2) {
                    return getWeatherIcon(list[1])
                }
                //查不到类型
                return R.drawable.img_00
            }
        }
    }
}