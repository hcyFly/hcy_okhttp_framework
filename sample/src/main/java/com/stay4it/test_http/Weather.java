package com.stay4it.test_http;

import com.google.gson.stream.JsonReader;
import com.stay4it.http.entities.JsonReaderable;
import com.stay4it.http.error.AppException;

import java.util.List;

/**
 * Created by chengyou.huang on 2017/1/9.
 */

public class Weather implements JsonReaderable{


    private List<HeWeatherUserHH> HeWeather;

    public List<HeWeatherUserHH> getHeWeather() {
        return HeWeather;
    }

    public void setHeWeather(List<HeWeatherUserHH> HeWeather) {
        this.HeWeather = HeWeather;
    }

    @Override
    public void readFromJson(JsonReader reader) throws AppException {

    }

    public static class HeWeatherUserHH {
        /**
         * aqi : {"city":{"aqi":"133","co":"1","no2":"52","o3":"233","pm10":"133","pm25":"87","qlty":"轻度污染","so2":"16"}}
         * basic : {"city":"深圳","cnty":"中国","id":"CN101280601","lat":"22.547","lon":"114.085947","update":{"loc":"2017-05-10 14:52","utc":"2017-05-10 06:52"}}
         * daily_forecast : [{"astro":{"mr":"18:25","ms":"05:25","sr":"05:46","ss":"18:54"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2017-05-10","hum":"76","pcpn":"0.5","pop":"79","pres":"1014","tmp":{"max":"31","min":"25"},"uv":"11","vis":"19","wind":{"deg":"203","dir":"无持续风向","sc":"微风","spd":"8"}},{"astro":{"mr":"19:16","ms":"06:03","sr":"05:45","ss":"18:54"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2017-05-11","hum":"78","pcpn":"0.9","pop":"40","pres":"1014","tmp":{"max":"32","min":"25"},"uv":"12","vis":"20","wind":{"deg":"117","dir":"无持续风向","sc":"微风","spd":"4"}},{"astro":{"mr":"20:06","ms":"06:43","sr":"05:45","ss":"18:55"},"cond":{"code_d":"300","code_n":"300","txt_d":"阵雨","txt_n":"阵雨"},"date":"2017-05-12","hum":"80","pcpn":"0.2","pop":"38","pres":"1011","tmp":{"max":"31","min":"25"},"uv":"10","vis":"18","wind":{"deg":"184","dir":"无持续风向","sc":"微风","spd":"5"}}]
         * hourly_forecast : [{"cond":{"code":"305","txt":"小雨"},"date":"2017-05-10 16:00","hum":"67","pop":"13","pres":"1013","tmp":"29","wind":{"deg":"156","dir":"东南风","sc":"微风","spd":"11"}},{"cond":{"code":"100","txt":"晴"},"date":"2017-05-10 19:00","hum":"76","pop":"0","pres":"1013","tmp":"27","wind":{"deg":"136","dir":"东南风","sc":"微风","spd":"9"}},{"cond":{"code":"100","txt":"晴"},"date":"2017-05-10 22:00","hum":"82","pop":"0","pres":"1015","tmp":"25","wind":{"deg":"121","dir":"东南风","sc":"微风","spd":"9"}}]
         * now : {"cond":{"code":"101","txt":"多云"},"fl":"32","hum":"77","pcpn":"0","pres":"1013","tmp":"29","vis":"6","wind":{"deg":"280","dir":"西北风","sc":"3-4","spd":"12"}}
         * status : ok
         * suggestion : {"air":{"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"},"comf":{"brf":"较不舒适","txt":"白天天气多云，并且空气湿度偏大，在这种天气条件下，您会感到有些闷热，不很舒适。"},"cw":{"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},"drsg":{"brf":"热","txt":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"},"flu":{"brf":"少发","txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"},"sport":{"brf":"较适宜","txt":"天气较好，较适宜进行各种运动，但考虑气温较高且湿度较大，请适当降低运动强度，并及时补充水分。"},"trav":{"brf":"适宜","txt":"天气较好，但丝毫不会影响您的心情。微风，虽天气稍热，却仍适宜旅游，不要错过机会呦！"},"uv":{"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}}
         */

        private AqiUserHH aqi;
        private BasicUserHH basic;
        private NowUserHH now;
        private String status;
        private SuggestionUserHH suggestion;
        private List<DailyForecastUserHH> daily_forecast;
        private List<HourlyForecastUserHH> hourly_forecast;

        public AqiUserHH getAqi() {
            return aqi;
        }

        public void setAqi(AqiUserHH aqi) {
            this.aqi = aqi;
        }

        public BasicUserHH getBasic() {
            return basic;
        }

        public void setBasic(BasicUserHH basic) {
            this.basic = basic;
        }

        public NowUserHH getNow() {
            return now;
        }

        public void setNow(NowUserHH now) {
            this.now = now;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public SuggestionUserHH getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(SuggestionUserHH suggestion) {
            this.suggestion = suggestion;
        }

        public List<DailyForecastUserHH> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastUserHH> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public List<HourlyForecastUserHH> getHourly_forecast() {
            return hourly_forecast;
        }

        public void setHourly_forecast(List<HourlyForecastUserHH> hourly_forecast) {
            this.hourly_forecast = hourly_forecast;
        }



        public static class AqiUserHH {
            /**
             * city : {"aqi":"133","co":"1","no2":"52","o3":"233","pm10":"133","pm25":"87","qlty":"轻度污染","so2":"16"}
             */

            private CityUserHH city;

            public CityUserHH getCity() {
                return city;
            }

            public void setCity(CityUserHH city) {
                this.city = city;
            }

            public static class CityUserHH {
                /**
                 * aqi : 133
                 * co : 1
                 * no2 : 52
                 * o3 : 233
                 * pm10 : 133
                 * pm25 : 87
                 * qlty : 轻度污染
                 * so2 : 16
                 */

                private String aqi;
                private String co;
                private String no2;
                private String o3;
                private String pm10;
                private String pm25;
                private String qlty;
                private String so2;

                public String getAqi() {
                    return aqi;
                }

                public void setAqi(String aqi) {
                    this.aqi = aqi;
                }

                public String getCo() {
                    return co;
                }

                public void setCo(String co) {
                    this.co = co;
                }

                public String getNo2() {
                    return no2;
                }

                public void setNo2(String no2) {
                    this.no2 = no2;
                }

                public String getO3() {
                    return o3;
                }

                public void setO3(String o3) {
                    this.o3 = o3;
                }

                public String getPm10() {
                    return pm10;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getQlty() {
                    return qlty;
                }

                public void setQlty(String qlty) {
                    this.qlty = qlty;
                }

                public String getSo2() {
                    return so2;
                }

                public void setSo2(String so2) {
                    this.so2 = so2;
                }
            }
        }

        public static class BasicUserHH {
            /**
             * city : 深圳
             * cnty : 中国
             * id : CN101280601
             * lat : 22.547
             * lon : 114.085947
             * update : {"loc":"2017-05-10 14:52","utc":"2017-05-10 06:52"}
             */

            private String city;
            private String cnty;
            private String id;
            private String lat;
            private String lon;
            private UpdateUserHH update;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public UpdateUserHH getUpdate() {
                return update;
            }

            public void setUpdate(UpdateUserHH update) {
                this.update = update;
            }

            public static class UpdateUserHH {
                /**
                 * loc : 2017-05-10 14:52
                 * utc : 2017-05-10 06:52
                 */

                private String loc;
                private String utc;

                public String getLoc() {
                    return loc;
                }

                public void setLoc(String loc) {
                    this.loc = loc;
                }

                public String getUtc() {
                    return utc;
                }

                public void setUtc(String utc) {
                    this.utc = utc;
                }
            }
        }

        public static class NowUserHH {
            /**
             * cond : {"code":"101","txt":"多云"}
             * fl : 32
             * hum : 77
             * pcpn : 0
             * pres : 1013
             * tmp : 29
             * vis : 6
             * wind : {"deg":"280","dir":"西北风","sc":"3-4","spd":"12"}
             */

            private CondUserHH cond;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            private WindUserHH wind;

            public CondUserHH getCond() {
                return cond;
            }

            public void setCond(CondUserHH cond) {
                this.cond = cond;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindUserHH getWind() {
                return wind;
            }

            public void setWind(WindUserHH wind) {
                this.wind = wind;
            }

            public static class CondUserHH {
                /**
                 * code : 101
                 * txt : 多云
                 */

                private String code;
                private String txt;

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class WindUserHH {
                /**
                 * deg : 280
                 * dir : 西北风
                 * sc : 3-4
                 * spd : 12
                 */

                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }

        public static class SuggestionUserHH {
            /**
             * air : {"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"}
             * comf : {"brf":"较不舒适","txt":"白天天气多云，并且空气湿度偏大，在这种天气条件下，您会感到有些闷热，不很舒适。"}
             * cw : {"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
             * drsg : {"brf":"热","txt":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"}
             * flu : {"brf":"少发","txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"}
             * sport : {"brf":"较适宜","txt":"天气较好，较适宜进行各种运动，但考虑气温较高且湿度较大，请适当降低运动强度，并及时补充水分。"}
             * trav : {"brf":"适宜","txt":"天气较好，但丝毫不会影响您的心情。微风，虽天气稍热，却仍适宜旅游，不要错过机会呦！"}
             * uv : {"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}
             */

            private AirUserHH air;
            private AirUserHH comf;
            private AirUserHH cw;
            private AirUserHH drsg;
            private AirUserHH flu;
            private AirUserHH sport;
            private AirUserHH trav;
            private AirUserHH uv;

            public AirUserHH getAir() {
                return air;
            }

            public void setAir(AirUserHH air) {
                this.air = air;
            }

            public AirUserHH getComf() {
                return comf;
            }

            public void setComf(AirUserHH comf) {
                this.comf = comf;
            }

            public AirUserHH getCw() {
                return cw;
            }

            public void setCw(AirUserHH cw) {
                this.cw = cw;
            }

            public AirUserHH getDrsg() {
                return drsg;
            }

            public void setDrsg(AirUserHH drsg) {
                this.drsg = drsg;
            }

            public AirUserHH getFlu() {
                return flu;
            }

            public void setFlu(AirUserHH flu) {
                this.flu = flu;
            }

            public AirUserHH getSport() {
                return sport;
            }

            public void setSport(AirUserHH sport) {
                this.sport = sport;
            }

            public AirUserHH getTrav() {
                return trav;
            }

            public void setTrav(AirUserHH trav) {
                this.trav = trav;
            }

            public AirUserHH getUv() {
                return uv;
            }

            public void setUv(AirUserHH uv) {
                this.uv = uv;
            }

            public static class AirUserHH {
                /**
                 * brf : 中
                 * txt : 气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。
                 */

                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }
        }

        public static class DailyForecastUserHH {
            /**
             * astro : {"mr":"18:25","ms":"05:25","sr":"05:46","ss":"18:54"}
             * cond : {"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"}
             * date : 2017-05-10
             * hum : 76
             * pcpn : 0.5
             * pop : 79
             * pres : 1014
             * tmp : {"max":"31","min":"25"}
             * uv : 11
             * vis : 19
             * wind : {"deg":"203","dir":"无持续风向","sc":"微风","spd":"8"}
             */

            private AstroUserHH astro;
            private CondUserHHX cond;
            private String date;
            private String hum;
            private String pcpn;
            private String pop;
            private String pres;
            private TmpUserHH tmp;
            private String uv;
            private String vis;
            private WindUserHH wind;

            public AstroUserHH getAstro() {
                return astro;
            }

            public void setAstro(AstroUserHH astro) {
                this.astro = astro;
            }

            public CondUserHHX getCond() {
                return cond;
            }

            public void setCond(CondUserHHX cond) {
                this.cond = cond;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public TmpUserHH getTmp() {
                return tmp;
            }

            public void setTmp(TmpUserHH tmp) {
                this.tmp = tmp;
            }

            public String getUv() {
                return uv;
            }

            public void setUv(String uv) {
                this.uv = uv;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindUserHH getWind() {
                return wind;
            }

            public void setWind(WindUserHH wind) {
                this.wind = wind;
            }

            public static class AstroUserHH {
                /**
                 * mr : 18:25
                 * ms : 05:25
                 * sr : 05:46
                 * ss : 18:54
                 */

                private String mr;
                private String ms;
                private String sr;
                private String ss;

                public String getMr() {
                    return mr;
                }

                public void setMr(String mr) {
                    this.mr = mr;
                }

                public String getMs() {
                    return ms;
                }

                public void setMs(String ms) {
                    this.ms = ms;
                }

                public String getSr() {
                    return sr;
                }

                public void setSr(String sr) {
                    this.sr = sr;
                }

                public String getSs() {
                    return ss;
                }

                public void setSs(String ss) {
                    this.ss = ss;
                }
            }

            public static class CondUserHHX {
                /**
                 * code_d : 101
                 * code_n : 101
                 * txt_d : 多云
                 * txt_n : 多云
                 */

                private String code_d;
                private String code_n;
                private String txt_d;
                private String txt_n;

                public String getCode_d() {
                    return code_d;
                }

                public void setCode_d(String code_d) {
                    this.code_d = code_d;
                }

                public String getCode_n() {
                    return code_n;
                }

                public void setCode_n(String code_n) {
                    this.code_n = code_n;
                }

                public String getTxt_d() {
                    return txt_d;
                }

                public void setTxt_d(String txt_d) {
                    this.txt_d = txt_d;
                }

                public String getTxt_n() {
                    return txt_n;
                }

                public void setTxt_n(String txt_n) {
                    this.txt_n = txt_n;
                }
            }

            public static class TmpUserHH {
                /**
                 * max : 31
                 * min : 25
                 */

                private String max;
                private String min;

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }
            }
        }

        public static class HourlyForecastUserHH {
            /**
             * cond : {"code":"305","txt":"小雨"}
             * date : 2017-05-10 16:00
             * hum : 67
             * pop : 13
             * pres : 1013
             * tmp : 29
             * wind : {"deg":"156","dir":"东南风","sc":"微风","spd":"11"}
             */

            private CondUserHH cond;
            private String date;
            private String hum;
            private String pop;
            private String pres;
            private String tmp;
            private WindUserHH wind;

            public CondUserHH getCond() {
                return cond;
            }

            public void setCond(CondUserHH cond) {
                this.cond = cond;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public WindUserHH getWind() {
                return wind;
            }

            public void setWind(WindUserHH wind) {
                this.wind = wind;
            }
        }
    }
    /**
     * {"deg":"156","dir":"东南风","sc":"微风","spd":"11"}
     */
    public static class  WindUserHH{

        /**
         * deg : 156
         * dir : 东南风
         * sc : 微风
         * spd : 11
         */

        private String deg;
        private String dir;
        private String sc;
        private String spd;

        public String getDeg() {
            return deg;
        }

        public void setDeg(String deg) {
            this.deg = deg;
        }

        public String getDir() {
            return dir;
        }

        public void setDir(String dir) {
            this.dir = dir;
        }

        public String getSc() {
            return sc;
        }

        public void setSc(String sc) {
            this.sc = sc;
        }

        public String getSpd() {
            return spd;
        }

        public void setSpd(String spd) {
            this.spd = spd;
        }
    }

    /**
     * {"code":"305","txt":"小雨"}
     */
    public static  class CondUserHH{

        /**
         * code : 305
         * txt : 小雨
         */

        private String code;
        private String txt;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }
    }
}
