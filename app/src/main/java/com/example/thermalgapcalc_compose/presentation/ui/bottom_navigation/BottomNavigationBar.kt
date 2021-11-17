package com.example.thermalgapcalc_compose.presentation.ui.bottom_navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {
    val itemSList = listOf(
        NavigationItem.History,
        NavigationItem.Add,
        NavigationItem.Settings
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentParentRoot = navBackStackEntry?.destination?.parent?.route
    
    BottomNavigation {
        itemSList.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentParentRoot == item.route,
                onClick = {
                    if (currentParentRoot != item.route) {
                        navController.navigate(item.route) {
                            navController.graph.findStartDestination().id.let {
                                popUpTo(it) {
                                    this.saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    } else {
                        navController.navigate(item.route) {
                            popUpTo(item.route)
                        }
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {

}