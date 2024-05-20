package com.example.campingmaster; // 패키지 이름을 실제 패키지 이름으로 변경

import android.app.Application;
import com.kakao.sdk.common.KakaoSdk;

class GlobalApplication : Application() {
        override fun onCreate() {
        super.onCreate()
        // 다른 초기화 코드들

        // Kakao SDK 초기화
        KakaoSdk.init(this, "${b9bf9d5080cac6e63aa6caabf1c88c63}")
        }
        }