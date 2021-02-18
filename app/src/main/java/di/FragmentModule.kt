package di

import com.papaer.gifview.HistoryFragment
import com.papaer.gifview.SinglePage
import dagger.Module
import dagger.android.ContributesAndroidInjector




@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun bindHistoryFragment(): HistoryFragment
    @ContributesAndroidInjector
    abstract fun bindSingleFragment(): SinglePage
}