package com.example.test_app

import android.app.Application

class TalsecApplication : Application(), ThreatListener.ThreatDetected {
    override fun onCreate() {
        val config = TalsecConfig(
            /*expectedPackageName,
            expectedSigningCertificateHashBase64,
            watcherMail,
            supportedAlternativeStores,
            isProd
            */
            //Uncomment it and write your data
        )
        ThreatListener(this).registerListener(this)
        Talsec.start(this, config)
        super.onCreate()
    }
    override fun onUntrustedInstallationSourceDetected() {
        TODO("Not yet implemented")
    }
}
companion object {
    private const val expectedPackageName = "com.aheaditec.talsec.demoapp" // Don't use Context.getPackageName!
    private val expectedSigningCertificateHashBase64 = arrayOf(
        "mVr/qQLO8DKTwqlL+B1qigl9NoBnbiUs8b4c2Ewcz0k=",
        "cVr/qQLO8DKTwqlL+B1qigl9NoBnbiUs8b4c2Ewcz0m="
    ) // I used an example,


    private val isProd = true
}