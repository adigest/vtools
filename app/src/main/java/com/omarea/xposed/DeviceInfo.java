package com.omarea.xposed;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by helloklf on 2017/11/30.
 */

public class DeviceInfo {
    public void simulationR11 (final XC_LoadPackage.LoadPackageParam loadPackageParam) {
        XposedHelpers.findAndHookMethod(
                "android.os.SystemProperties", loadPackageParam.classLoader, "get", String.class, String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        XposedHelpers.setStaticObjectField(android.os.Build.class, "PRODUCT", "R11 Plus");
                        XposedHelpers.setStaticObjectField(android.os.Build.class, "DEVICE", "R11 Plus");
                        XposedHelpers.setStaticObjectField(android.os.Build.class, "MODEL", "OPPO R11 Plus");
                        XposedHelpers.setStaticObjectField(android.os.Build.class, "BRAND", "OPPO");
                        XposedHelpers.setStaticObjectField(android.os.Build.class, "MANUFACTURER", "OPPO");
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        String prop = (String) param.args[0];
                        switch (prop) {
                            case "ro.product.model": {
                                param.setResult("OPPO R11 Plus");
                                break;
                            }
                            case "ro.product.brand": {
                                param.setResult("OPPO");
                                break;
                            }
                            case "ro.product.manufacturer": {
                                param.setResult("OPPO");
                                break;
                            }
                            case "ro.product.device": {
                                param.setResult("R11 Plus");
                                break;
                            }
                            case "ro.product.name": {
                                param.setResult("R11 Plus");
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                    }
                });
    }
}
