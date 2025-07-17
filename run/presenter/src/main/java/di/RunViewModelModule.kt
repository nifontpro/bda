package di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.nb.bds.run.presenter.RunOverviewViewModel

val runViewModelModule = module {
    viewModelOf(::RunOverviewViewModel)
}