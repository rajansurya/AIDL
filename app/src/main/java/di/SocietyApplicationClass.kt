package di

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.society.societygate.di.DaggerGIFComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class SocietyApplicationClass :Application(),HasActivityInjector,HasSupportFragmentInjector{
    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var dispatchingFragmentInjector:DispatchingAndroidInjector<Fragment>
    override fun onCreate() {
        super.onCreate()
        DaggerGIFComponent.builder().societyapplicationBind(this).context(this).builderApplication().injectApp(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector
    override fun supportFragmentInjector(): AndroidInjector<Fragment> =dispatchingFragmentInjector

}