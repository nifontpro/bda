@file:OptIn(ExperimentalMaterial3Api::class)

package ru.nb.bds.run.presenter

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import ru.nb.bds.core.presenter.design.AnalyticsIcon
import ru.nb.bds.core.presenter.design.BirthdaysTheme
import ru.nb.bds.core.presenter.design.LogoIcon
import ru.nb.bds.core.presenter.design.LogoutIcon
import ru.nb.bds.core.presenter.design.RunIcon
import ru.nb.bds.core.presenter.design.component.RuniqueFloatingActionButton
import ru.nb.bds.core.presenter.design.component.RuniqueScaffold
import ru.nb.bds.core.presenter.design.component.RuniqueToolbar
import ru.nb.bds.core.presenter.design.component.util.DropDownItem

@Composable
fun RunOverviewScreenRoot(
    viewModel: RunOverviewViewModel = koinViewModel(),
) {
    RunOverviewScreen(
        onAction = viewModel::onAction
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RunOverviewScreen(
    onAction: (RunOverviewAction) -> Unit
) {
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    )
    RuniqueScaffold(
        topAppBar = {
            RuniqueToolbar(
                showBackButton = false,
                title = stringResource(id = R.string.runique),
                scrollBehavior = scrollBehavior,
                menuItems = listOf(
                    DropDownItem(
                        icon = AnalyticsIcon,
                        title = stringResource(id = R.string.analytics)
                    ),
                    DropDownItem(
                        icon = LogoutIcon,
                        title = stringResource(id = R.string.logout)
                    ),
                ),
                onMenuItemClick = { index ->
                    when (index) {
                        0 -> onAction(RunOverviewAction.OnAnalyticsClick)
                        1 -> onAction(RunOverviewAction.OnLogoutClick)
                    }
                },
                startContent = {
                    Icon(
                        imageVector = LogoIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(30.dp)
                    )
                }
            )
        },
        floatingActionButton = {
            RuniqueFloatingActionButton(
                icon = RunIcon,
                onClick = {
                    onAction(RunOverviewAction.OnStartClick)
                }
            )
        }
    ) { padding ->

    }
}

@Preview
@Composable
private fun RunOverviewScreenPreview() {
    BirthdaysTheme {
        RunOverviewScreen(
            onAction = {}
        )
    }
}