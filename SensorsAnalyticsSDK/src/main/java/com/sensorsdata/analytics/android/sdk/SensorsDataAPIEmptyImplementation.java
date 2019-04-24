/**Created by wangzhuozhou on 2015/08/01.
 * Copyright © 2015－2018 Sensors Data Inc. All rights reserved. */

package com.sensorsdata.analytics.android.sdk;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

public class SensorsDataAPIEmptyImplementation extends SensorsDataAPI {
    public SensorsDataAPIEmptyImplementation() {
    
    }
    
    /**
     * 返回预置属性
     * @return JSONObject 预置属性
     */
    @Override
    public JSONObject getPresetProperties() {
        return new JSONObject();
    }
    
    
    
    @Override
    public boolean isFragmentAutoTrackAppViewScreen(Class<?> fragment) {
        return false;
    }
    
    @Override
    public Set<Integer> getAutoTrackFragments() {
        return new CopyOnWriteArraySet<>();
    }
    
    /**
     * 设置当前 serverUrl
     * @param serverUrl 当前 serverUrl
     */
    @Override
    public void setServerUrl(String serverUrl) {
    
    }
    
    /**
     * 设置是否开启 log
     * @param enable boolean
     */
    @Override
    public void enableLog(boolean enable) {
    
    }
    
    @Override
    public boolean isDebugMode() {
        return false;
    }
    
    @Override
    public long getMaxCacheSize() {
        return 0;
    }
    
    /**
     * 设置本地缓存上限值，单位 byte，默认为 32MB：32 * 1024 * 1024
     * @param maxCacheSize 单位 byte
     */
    @Override
    public void setMaxCacheSize(long maxCacheSize) {
    
    }
    
    /**
     * 设置 flush 时网络发送策略，默认 3G、4G、WI-FI 环境下都会尝试 flush
     * @param networkType int 网络类型
     */
    @Override
    public void setFlushNetworkPolicy(int networkType) {
    
    }
    
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
    @Override
    public int getFlushInterval() {
        return 0;
    }
    
    /**
     * 设置两次数据发送的最小时间间隔
     *
     * @param flushInterval 时间间隔，单位毫秒
     */
    @Override
    public void setFlushInterval(int flushInterval) {
    
    }
    
    @Override
    public int getFlushBulkSize() {
        return 0;
    }
    
    /**
     * 设置本地缓存日志的最大条目数
     *
     * @param flushBulkSize 缓存数目
     */
    @Override
    public void setFlushBulkSize(int flushBulkSize) {
    
    }
    
    /**
     * 获取 App 切换到后台与下次事件的事件间隔，单位，毫秒
     */
    @Override
    public int getSessionIntervalTime() {
        return 30 * 1000;
    }
    
    /**
     * 设置 App 切换到后台与下次事件的事件间隔
     */
    @Override
    public void setSessionIntervalTime(int sessionIntervalTime) {
    }
    
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
    @Override
    public void enableAutoTrack() {
    
    }
    
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
    @Override
    public void enableAutoTrack(List<AutoTrackEventType> eventTypeList) {
    
    }
    
    /**
     * 关闭 AutoTrack 中的部分事件
     * @param eventTypeList AutoTrackEventType 类型 List
     */
    @Override
    public void disableAutoTrack(List<AutoTrackEventType> eventTypeList) {
    
    }
    
    /**
     * 关闭 AutoTrack 中的某个事件
     * @param autoTrackEventType AutoTrackEventType 类型
     */
    @Override
    public void disableAutoTrack(SensorsDataAPI.AutoTrackEventType autoTrackEventType) {
    
    }
    
    /**
     * 自动收集 App Crash 日志，该功能默认是关闭的
     */
    @Override
    public void trackAppCrash() {
    
    }
    
    /**
     * 是否开启 AutoTrack
     * @return true: 开启 AutoTrack; false：没有开启 AutoTrack
     */
    @Override
    public boolean isAutoTrackEnabled() {
        return false;
    }
    
    @Override
    public boolean isButterknifeOnClickEnabled() {
        return false;
    }
    
    /**
     * 是否开启自动追踪 Fragment 的 $AppViewScreen 事件
     * 默认不开启
     */
    @Override
    public void trackFragmentAppViewScreen() {
    
    }
    
    @Override
    public boolean isTrackFragmentAppViewScreenEnabled() {
        return false;
    }
    
    /**
     * 开启 AutoTrack 支持 React Native
     */
    @Override
    public void enableReactNativeAutoTrack() {
    
    }
    
    @Override
    public boolean isReactNativeAutoTrackEnabled() {
        return false;
    }
    
    
    
    /**
     * 指定哪些 activity 不被AutoTrack
     *
     * 指定activity的格式为：activity.getClass().getCanonicalName()
     *
     * @param activitiesList  activity列表
     */
    @Override
    public void ignoreAutoTrackActivities(List<Class<?>> activitiesList) {
    
    }
    
    /**
     * 恢复不被 AutoTrack 的 activity
     * @param activitiesList List
     */
    @Override
    public void resumeAutoTrackActivities(List<Class<?>> activitiesList) {
    
    }
    
    /**
     * 指定某个 activity 不被 AutoTrack
     * @param activity Activity
     */
    @Override
    public void ignoreAutoTrackActivity(Class<?> activity) {
    
    }
    
    /**
     * 恢复不被 AutoTrack 的 activity
     * @param activity Class
     */
    @Override
    public void resumeAutoTrackActivity(Class<?> activity) {
    
    }
    
    /**
     * 判断 AutoTrack 时，某个 Activity 的 $AppViewScreen 是否被过滤
     * 如果过滤的话，会过滤掉 Activity 的 $AppViewScreen 事件
     * @param activity Activity
     * @return Activity 是否被过滤
     */
    @Override
    public boolean isActivityAutoTrackAppViewScreenIgnored(Class<?> activity) {
        return true;
    }
    
    /**
     * 判断 AutoTrack 时，某个 Activity 的 $AppClick 是否被过滤
     * 如果过滤的话，会过滤掉 Activity 的 $AppClick 事件
     * @param activity Activity
     * @return Activity 是否被过滤
     */
    @Override
    public boolean isActivityAutoTrackAppClickIgnored(Class<?> activity) {
        return true;
    }
    
    /**
     * 过滤掉 AutoTrack 的某个事件类型
     * @param autoTrackEventType AutoTrackEventType
     */
    @Deprecated
    @Override
    public void ignoreAutoTrackEventType(SensorsDataAPI.AutoTrackEventType autoTrackEventType) {
    
    }
    
    /**
     * 过滤掉 AutoTrack 的某些事件类型
     * @param eventTypeList AutoTrackEventType List
     */
    @Deprecated
    @Override
    public void ignoreAutoTrackEventType(List<AutoTrackEventType> eventTypeList) {
    
    }
    
    /**
     * 判断 某个 AutoTrackEventType 是否被忽略
     * @param eventType AutoTrackEventType
     * @return true 被忽略; false 没有被忽略
     */
    @Override
    public boolean isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType eventType) {
        return true;
    }
    
    
    
    @Override
    public List<Class> getIgnoredViewTypeList() {
        return new ArrayList<>();
    }
    
    /**
     * 忽略某一类型的 View
     *
     * @param viewType Class
     */
    @Override
    public void ignoreViewType(Class viewType) {
    
    }
    
    @Override
    public boolean isHeatMapActivity(Class<?> activity) {
        return false;
    }
    
    @Override
    public void addHeatMapActivity(Class<?> activity) {
    
    }
    
    @Override
    public void addHeatMapActivities(List<Class<?>> activitiesList) {
    
    }
    
    @Override
    public boolean isHeatMapEnabled() {
        return false;
    }
    
    @Override
    public boolean isAppHeatMapConfirmDialogEnabled() {
        return true;
    }
    
    @Override
    public void enableAppHeatMapConfirmDialog(boolean enable) {
    
    }
    
    
    
    /**
     * 获取当前用户的匿名id
     *
     * 若调用前未调用 {@link #identify(String)} 设置用户的匿名id，SDK 会调用 {@link java.util.UUID} 随机生成
     * UUID，作为用户的匿名id
     *
     * @return 当前用户的匿名id
     */
    @Override
    public String getAnonymousId() {
        return null;
    }
    
    /**
     * 重置默认匿名id
     */
    @Override
    public void resetAnonymousId() {
    
    }
    
    /**
     * 获取当前用户的 loginId
     *
     * 若调用前未调用 {@link #login(String)} 设置用户的 loginId，会返回null
     *
     * @return 当前用户的 loginId
     */
    @Override
    public String getLoginId() {
        return null;
    }
    
    /**
     * 设置当前用户的distinctId。一般情况下，如果是一个注册用户，则应该使用注册系统内
     * 的user_id，如果是个未注册用户，则可以选择一个不会重复的匿名ID，如设备ID等，如果
     * 客户没有调用identify，则使用SDK自动生成的匿名ID
     *
     * @param distinctId 当前用户的distinctId，仅接受数字、下划线和大小写字母
     */
    @Override
    public void identify(String distinctId) {
    
    }
    
    /**
     * 登录，设置当前用户的 loginId
     *
     * @param loginId 当前用户的 loginId，不能为空，且长度不能大于255
     */
    @Override
    public void login(String loginId) {
    
    }
    
    /**
     * 登录，设置当前用户的 loginId
     *
     * @param loginId 当前用户的 loginId，不能为空，且长度不能大于255
     * @param properties 用户登录属性
     */
    @Override
    public void login(String loginId, JSONObject properties) {
    
    }
    
    /**
     * 注销，清空当前用户的 loginId
     */
    @Override
    public void logout() {
    
    }
    
    /**
     * 调用track接口，追踪一个带有属性的事件
     *
     * @param eventName  事件的名称
     * @param properties 事件的属性
     */
    @Override
    public void track(String eventName, JSONObject properties) {
    
    }
    
    
    
    /**
     * 删除指定时间的计时器
     *
     * @param eventName 事件名称
     */
    @Override
    public void removeTimer(String eventName) {
        super.removeTimer(eventName);
    }
    
    /**
     * 停止事件计时器
     * @param eventName 事件的名称
     * @param properties 事件的属性
     */
    @Override
    public void trackTimerEnd(final String eventName, JSONObject properties) {
    
    }
    
    /**
     * 停止事件计时器
     * @param eventName 事件的名称
     */
    @Override
    public void trackTimerEnd(final String eventName) {
    
    }
    
    /**
     * 清除所有事件计时器
     */
    @Override
    public void clearTrackTimer() {
    
    }
    
    /**
     * 获取LastScreenUrl
     * @return String
     */
    @Override
    public String getLastScreenUrl() {
        return null;
    }
    
    /**
     * App 退出或进到后台时清空 referrer，默认情况下不清空
     */
    @Override
    public void clearReferrerWhenAppEnd() {
    
    }
    
    @Override
    public void clearLastScreenUrl() {
    
    }
    
    @Override
    public String getMainProcessName() {
        return "";
    }
    
    /**
     * 获取LastScreenTrackProperties
     * @return JSONObject
     */
    @Override
    public JSONObject getLastScreenTrackProperties() {
        return new JSONObject();
    }
    
    
    
    /**
     * 将所有本地缓存的日志发送到 Sensors Analytics.
     */
    @Override
    public void flush() {
    
    }
    
    /**
     * 以阻塞形式将所有本地缓存的日志发送到 Sensors Analytics，该方法不能在 UI 线程调用。
     */
    @Override
    public void flushSync() {
    
    }
    
    /**
     * 注册事件动态公共属性
     *
     * @param dynamicSuperProperties 事件动态公共属性回调接口
     */
    @Override
    public void registerDynamicSuperProperties(SensorsDataDynamicSuperProperties dynamicSuperProperties) {
    
    }
    
    /**
     * 设置 track 事件回调
     * @param trackEventCallBack track 事件回调接口
     */
    @Override
    public void setTrackEventCallBack(SensorsDataTrackEventCallBack trackEventCallBack) {
    
    }
    
    /**
     * 删除本地缓存的全部事件
     */
    @Override
    public void deleteAll() {
    
    }
    
    
    
    
    @Override
    public void setGPSLocation(double latitude, double longitude) {
    
    }
    
    @Override
    public void clearGPSLocation() {
    
    }
    
    @Override
    public void enableTrackScreenOrientation(boolean enable) {
    
    }
    
    @Override
    public void resumeTrackScreenOrientation() {
    
    }
    
    @Override
    public void stopTrackScreenOrientation() {
    
    }
    
    @Override
    public boolean isFlushInBackground() {
        return true;
    }
    
    @Override
    public void setFlushInBackground(boolean isUploadData) {
    
    }
    
    @Override
    public void setCookie(String cookie, boolean encode) {
    
    }
    
    @Override
    public String getCookie(boolean decode) {
        return null;
    }
    
    /**
     * 保存用户推送 ID 到用户表
     * @param propertyKey 属性名称（例如 jgId）
     * @param pushId  推送 ID
     *                使用 profilePushId("jgId",JPushInterface.getRegistrationID(this))
     */
    
}
