package io.github.mucute.qwq.wakeupadblocker

import io.github.libxposed.api.XposedModule
import io.github.libxposed.api.XposedModuleInterface

class ModuleMain : XposedModule() {

    override fun onPackageReady(param: XposedModuleInterface.PackageReadyParam) {
        if (!param.isFirstPackage) return

        val classLoader = param.classLoader
        val userInfoClass = classLoader.loadClass("com.suda.yzune.wakeupschedule.aaa.v1.UserInfo")
        val vipStatusField = userInfoClass.getDeclaredField("vipStatus")
        val vipEndTimeField = userInfoClass.getDeclaredField("vipEndTime")
        val vipTypeField = userInfoClass.getDeclaredField("vipType")
        val utilClass = classLoader.loadClass("com.suda.yzune.wakeupschedule.aaa.utils.o00O0000")
        val getUserInfoMethod = utilClass.getDeclaredMethod("OooO0oO")
        hook(getUserInfoMethod)
            .intercept {
                val userInfo = it.proceed()
                vipStatusField.set(userInfo, 1)
                vipEndTimeField.set(userInfo, 0xF2A4B301)
                vipTypeField.set(userInfo, 1)
                userInfo
            }
    }

}