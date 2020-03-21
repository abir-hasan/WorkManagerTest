# WorkManagerTest

Links:
1. https://developer.android.com/topic/libraries/architecture/workmanager
2. https://developer.android.com/topic/performance/power/power-details
3. https://developer.android.com/topic/performance/appstandby
4. https://developer.android.com/guide/background/
5. https://medium.com/androiddevelopers/workmanager-periodicity-ff35185ff006
6. https://medium.com/mindorks/work-manager-in-android-9cdb66c9a1df
7. https://developer.android.com/training/monitoring-device-state/doze-standby [***]

### Notes:
**In order to maximize battery and enforce good app behavior, Android restricts background work when the app (or a foreground service notification) is not visible to the user.**

+ Android 6.0 (API level 23) introduced Doze mode and app standby. Doze mode restricts app behavior when the screen is off and the device is stationary. App standby puts unused applications into a special state that restricts their network access, jobs, and syncs.
+ Android 7.0 (API level 24) limited implicit broadcasts and introduced Doze-on-the-Go.
+ Android 8.0 (API level 26) further limited background behavior, such as getting location in the background and releasing cached wake-locks.
- Android 9 (API level 28) introduced App Standby Buckets, in which app requests for resources are dynamically prioritized based on app usage patterns.
