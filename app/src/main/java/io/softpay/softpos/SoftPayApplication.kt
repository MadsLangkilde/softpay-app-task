package io.softpay.softpos

import android.app.Application
import io.softpay.softpos.di.koinModuleList
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class SoftPayApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@SoftPayApplication)
            modules(koinModuleList)
        }
    }
}