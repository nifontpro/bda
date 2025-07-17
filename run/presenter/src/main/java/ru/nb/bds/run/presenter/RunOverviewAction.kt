package ru.nb.bds.run.presenter

sealed interface RunOverviewAction {
    data object OnStartClick: RunOverviewAction
    data object OnLogoutClick: RunOverviewAction
    data object OnAnalyticsClick: RunOverviewAction
}