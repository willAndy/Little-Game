package util;

import android.content.Context;
import android.content.pm.PackageInfo;

/**
 * Created by Administrator on 2016/9/7 0007.
 */
public class VersionUtils {

    private String versionName;
    private String packageName;
    private int versionCode=0;

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public VersionUtils(Context mContext){
        PackageInfo info;
        try{
            info=mContext.getPackageManager().getPackageInfo(mContext.getPackageName(),0);
            this.versionName=info.versionName;
            this.packageName=info.packageName;
            this.versionCode=info.versionCode;

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getName(){
        return versionName;
    }

    public int getCode(){return versionCode;}

    public String getPackage(){return packageName;}

}
