/**Created by wangzhuozhou on 2015/08/01.
 * Copyright © 2015－2018 Sensors Data Inc. All rights reserved. */

package com.sensorsdata.analytics.android.sdk;

import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public interface ISensorsDataAPI {
    /**
     * 返回预置属性
     * @return JSONObject 预置属性
     */
    JSONObject getPresetProperties();
    
    /**
     * 设置当前 serverUrl
     * @param serverUrl 当前 serverUrl
     */
    void setServerUrl(String serverUrl);
    
    /**
     * 设置是否开启 log
     * @param enable boolean
     */
    void enableLog(boolean enable);
    
    /**
     * 获取本地缓存上限制
     * @return 字节
     */
    long getMaxCacheSize();
    
    /**
     * 返回档期是否是开启 debug 模式
     * @return true：是，false：不是
     */
    boolean isDebugMode();
    
    /**
     * 返回是否允许后台上传数据，默认是true
     * @return 是否允许后台上传数据
     */
    boolean isFlushInBackground();
    
    /**
     * 设置是否允许后台上传数据，默认是 true
     * @param isFlush boolean
     */
    void setFlushInBackground(boolean isFlush);
    
    /**
     * 设置本地缓存上限值，单位 byte，默认为 32MB：32 * 1024 * 1024
     * @param maxCacheSize 单位 byte
     */
    void setMaxCacheSize(long maxCacheSize);
    
    /**
     * 设置 flush 时网络发送策略，默认 3G、4G、WI-FI 环境下都会尝试 flush
     * @param networkType int 网络类型
     */
    void setFlushNetworkPolicy(int networkType);
    
    /**
     * 两次数据发送的最小时间间隔，单位毫秒
     *
     * 默认值为15 * 1000毫秒
     * 在每次调用track、signUp以及profileSet等接口的时候，都会检查如下条件，以判断是否向服务器上传数据:
     *
     * 1. 是否是WIFI/3G/4G网络条件
     * 2. 是否满足发送条件之一:
     * 1) 与上次发送的时间间隔是否大于 flushInterval
     * 2) 本地缓存日志数目是否大于 flushBulkSize
     *
     * 如果满足这两个条件，则向服务器发送一次数据；如果不满足，则把数据加入到队列中，等待下次检查时把整个队列的内
     * 容一并发送。需要注意的是，为了避免占用过多存储，队列最多只缓存20MB数据。
     *
     * @return 返回时间间隔，单位毫秒
     */
    int getFlushInterval();
    
    /**
     * 设置两次数据发送的最小时间间隔
     * @param flushInterval 时间间隔，单位毫秒
     */
    void setFlushInterval(int flushInterval);
    
    /**
     * 返回本地缓存日志的最大条目数
     * @return 条数
     */
    int getFlushBulkSize();
    
    /**
     * 设置本地缓存日志的最大条目数
     *
     * @param flushBulkSize 缓存数目
     */
    void setFlushBulkSize(int flushBulkSize);
    
    /**
     * 设置 App 切换到后台与下次事件的事件间隔
     *
     * 默认值为 30*1000 毫秒
     *
     * 若 App 在后台超过设定事件，则认为当前 Session 结束，发送 $AppEnd 事件
     * @param sessionIntervalTime int
     */
    void setSessionIntervalTime(int sessionIntervalTime);
    
    /**
     * 设置 App 切换到后台与下次事件的事件间隔
     *
     * 默认值为 30*1000 毫秒
     *
     * 若 App 在后台超过设定事件，则认为当前 Session 结束，发送 $AppEnd 事件
     *
     * @return 返回设置的 SessionIntervalTime ，默认是 30s
     */
    int getSessionIntervalTime();
    
    /**
     * 打开 SDK 自动追踪
     *
     * 该功能自动追踪 App 的一些行为，例如 SDK 初始化、App 启动（$AppStart） / 关闭（$AppEnd）、
     * 进入页面（$AppViewScreen）等等，具体信息请参考文档:
     * https://sensorsdata.cn/manual/android_sdk.html
     *
     * 该功能仅在 API 14 及以上版本中生效，默认关闭
     */
    @Deprecated
    void enableAutoTrack();
    
    /**
     * 打开 SDK 自动追踪
     *
     * 该功能自动追踪 App 的一些行为，指定哪些 AutoTrack 事件被追踪，具体信息请参考文档:
     * https://sensorsdata.cn/manual/android_sdk.html
     *
     * 该功能仅在 API 14 及以上版本中生效，默认关闭
     *
     * @param eventTypeList 开启 AutoTrack 的事件列表
     */
    void enableAutoTrack(List<SensorsDataAPI.AutoTrackEventType> eventTypeList);
    
    /**
     * 关闭 AutoTrack 中的部分事件
     * @param eventTypeList AutoTrackEventType 类型 List
     */
    void disableAutoTrack(List<SensorsDataAPI.AutoTrackEventType> eventTypeList);
    
    /**
     * 关闭 AutoTrack 中的某个事件
     * @param autoTrackEventType AutoTrackEventType 类型
     */
    void disableAutoTrack(SensorsDataAPI.AutoTrackEventType autoTrackEventType);
    
    /**
     * 自动收集 App Crash 日志，该功能默认是关闭的
     */
    void trackAppCrash();
    
    /**
     * 是否开启 AutoTrack
     * @return true: 开启 AutoTrack; false：没有开启 AutoTrack
     */
    boolean isAutoTrackEnabled();
    
    /**
     * 是否开启了支持 Butterknife
     * @return true：支持，false：不支持
     */
    boolean isButterknifeOnClickEnabled();
    
    /**
     * 是否开启自动追踪 Fragment 的 $AppViewScreen 事件
     * 默认不开启
     */
    void trackFragmentAppViewScreen();
    
    boolean isTrackFragmentAppViewScreenEnabled();
    
    /**
     * 开启 AutoTrack 支持 React Native
     */
    void enableReactNativeAutoTrack();
    
    boolean isReactNativeAutoTrackEnabled();
    
    
    /**
     * 指定哪些 activity 不被AutoTrack
     *
     * 指定activity的格式为：activity.getClass().getCanonicalName()
     *
     * @param activitiesList  activity列表
     */
    void ignoreAutoTrackActivities(List<Class<?>> activitiesList);
    
    /**
     * 恢复不被 AutoTrack 的 activity
     * @param activitiesList List
     */
    void resumeAutoTrackActivities(List<Class<?>> activitiesList);
    
    /**
     * 指定某个 activity 不被 AutoTrack
     * @param activity Activity
     */
    void ignoreAutoTrackActivity(Class<?> activity);
    
    /**
     * 恢复不被 AutoTrack 的 activity
     * @param activity Class
     */
    void resumeAutoTrackActivity(Class<?> activity);
    
    
    
    
    
    /**
     * 判断 AutoTrack 时，某个 Activity 的 $AppViewScreen 是否被过滤
     * 如果过滤的话，会过滤掉 Activity 的 $AppViewScreen 事件
     * @param activity Activity
     * @return Activity 是否被采集
     */
    boolean isActivityAutoTrackAppViewScreenIgnored(Class<?> activity);
    
    /**
     * 判断 AutoTrack 时，某个 Fragment 的 $AppViewScreen 是否被采集
     * @param fragment Fragment
     * @return Fragment 是否被采集
     */
    boolean isFragmentAutoTrackAppViewScreen(Class<?> fragment);
    
    /**
     * 判断 AutoTrack 时，某个 Activity 的 $AppClick 是否被过滤
     * 如果过滤的话，会过滤掉 Activity 的 $AppClick 事件
     * @param activity Activity
     * @return Activity 是否被过滤
     */
    boolean isActivityAutoTrackAppClickIgnored(Class<?> activity);
    
    /**
     * 过滤掉 AutoTrack 的某个事件类型
     * @param autoTrackEventType AutoTrackEventType
     */
    @Deprecated
    void ignoreAutoTrackEventType(SensorsDataAPI.AutoTrackEventType autoTrackEventType);
    
    /**
     * 过滤掉 AutoTrack 的某些事件类型
     * @param eventTypeList AutoTrackEventType List
     */
    @Deprecated
    void ignoreAutoTrackEventType(List<SensorsDataAPI.AutoTrackEventType> eventTypeList);
    
    
    
    
    
    
    List<Class> getIgnoredViewTypeList();
    
    /**
     * 获取需要采集的 Fragment 集合
     * @return Set
     */
    Set<Integer> getAutoTrackFragments();
    
    /**
     * 忽略某一类型的 View
     *
     * @param viewType Class
     */
    void ignoreViewType(Class viewType);
    
    boolean isHeatMapActivity(Class<?> activity);
    
    void addHeatMapActivity(Class<?> activity);
    
    void addHeatMapActivities(List<Class<?>> activitiesList);
    
    boolean isHeatMapEnabled();
    
    void enableAppHeatMapConfirmDialog(boolean enable);
    
    
    
    
    /**
     * 获取当前用户的匿名id
     *
     * 若调用前未调用 {@link #identify(String)} 设置用户的匿名id，SDK 会调用 {@link java.util.UUID} 随机生成
     * UUID，作为用户的匿名id
     *
     * @return 当前用户的匿名id
     */
    String getAnonymousId();
    
    /**
     * 重置默认匿名id
     */
    void resetAnonymousId();
    
    /**
     * 判断 某个 AutoTrackEventType 是否被忽略
     * @param eventType AutoTrackEventType
     * @return true 被忽略; false 没有被忽略
     */
    boolean isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType eventType);
    /**
     * 获取当前用户的 loginId
     *
     * 若调用前未调用 {@link #login(String)} 设置用户的 loginId，会返回null
     *
     * @return 当前用户的 loginId
     */
    String getLoginId();
    
    /**
     * 设置当前用户的distinctId。一般情况下，如果是一个注册用户，则应该使用注册系统内
     * 的user_id，如果是个未注册用户，则可以选择一个不会重复的匿名ID，如设备ID等，如果
     * 客户没有调用identify，则使用SDK自动生成的匿名ID
     *
     * @param distinctId 当前用户的distinctId，仅接受数字、下划线和大小写字母
     */
    void identify(String distinctId);
    
    /**
     * 登录，设置当前用户的 loginId
     *
     * @param loginId 当前用户的 loginId，不能为空，且长度不能大于255
     */
    void login(String loginId);
    
    /**
     * 登录，设置当前用户的 loginId
     *
     * @param loginId 当前用户的 loginId，不能为空，且长度不能大于255
     * @param properties 用户登录属性
     */
    void login(final String loginId , final JSONObject properties);
    
    /**
     * 注销，清空当前用户的 loginId
     */
    void logout();
    
    
    /**
     * 调用track接口，追踪一个带有属性的事件
     *
     * @param eventName  事件的名称
     * @param properties 事件的属性
     */
    void track(String eventName, JSONObject properties);
    
    
    /**
     * 与 {@link #track(String, JSONObject)} 类似，无事件属性
     *
     * @param eventName 事件的名称
     */
    void track(String eventName);
    
    
    /**
     * 删除事件的计时器
     *
     * @param eventName 事件名称
     */
    void removeTimer(final String eventName);
    
    
    
    /**
     * 停止事件计时器
     * @param eventName 事件的名称
     * @param properties 事件的属性
     */
    void trackTimerEnd(final String eventName, JSONObject properties);
    
    /**
     * 停止事件计时器
     * @param eventName 事件的名称
     */
    void trackTimerEnd(final String eventName);
    
    /**
     * 清除所有事件计时器
     */
    void clearTrackTimer();
    
    /**
     * 获取LastScreenUrl
     * @return String
     */
    String getLastScreenUrl();
    
    /**
     * App 退出或进到后台时清空 referrer，默认情况下不清空
     */
    void clearReferrerWhenAppEnd();
    
    void clearLastScreenUrl();
    
    String getMainProcessName();
    
    /**
     * 获取LastScreenTrackProperties
     * @return JSONObject
     */
    JSONObject getLastScreenTrackProperties();
    
    
    /**
     * 将所有本地缓存的日志发送到 Sensors Analytics.
     */
    void flush();
    
    /**
     * 以阻塞形式将所有本地缓存的日志发送到 Sensors Analytics，该方法不能在 UI 线程调用。
     */
    void flushSync();
    
    /**
     * 注册事件动态公共属性
     *
     * @param dynamicSuperProperties 事件动态公共属性回调接口
     */
    void registerDynamicSuperProperties(SensorsDataDynamicSuperProperties dynamicSuperProperties);
    
    /**
     * 设置 track 事件回调
     * @param trackEventCallBack track 事件回调接口
     */
    void setTrackEventCallBack(SensorsDataTrackEventCallBack trackEventCallBack);
    
    
    
    /**
     * 更新 GPS 位置信息
     * @param latitude 纬度
     * @param longitude 经度
     */
    void setGPSLocation(double latitude, double longitude);
    
    /**
     * 清楚 GPS 位置信息
     */
    void clearGPSLocation();
    
    /**
     * 开启/关闭采集屏幕方向
     * @param enable true：开启 false：关闭
     */
    void enableTrackScreenOrientation(boolean enable);
    
    /**
     * 恢复采集屏幕方向
     */
    void resumeTrackScreenOrientation();
    
    /**
     * 暂停采集屏幕方向
     */
    void stopTrackScreenOrientation();
    
    /**
     * 获取当前屏幕方向
     * @return portrait:竖屏 landscape:横屏
     */
    String getScreenOrientation();
    
    
    
    /**
     * 设置 Cookie，flush 的时候会设置 HTTP 的 cookie
     * 内部会 URLEncoder.encode(cookie, "UTF-8")
     * @param cookie String cookie
     * @param encode boolean 是否 encode
     */
    void setCookie(final String cookie, boolean encode);
    
    /**
     * 获取已设置的 Cookie
     * URLDecoder.decode(Cookie, "UTF-8")
     * @param decode String
     * @return String cookie
     */
    String getCookie(boolean decode);
    
    /**
     * 删除本地缓存的全部事件
     */
    void deleteAll();
    
    
}
