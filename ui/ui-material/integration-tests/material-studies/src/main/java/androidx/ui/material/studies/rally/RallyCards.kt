/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.ui.material.studies.rally

import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.composer
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.ColoredRect
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.CrossAxisAlignment
import androidx.ui.layout.EdgeInsets
import androidx.ui.layout.FixedSpacer
import androidx.ui.layout.FlexRow
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.MainAxisAlignment
import androidx.ui.layout.Padding
import androidx.ui.layout.Row
import androidx.ui.layout.WidthSpacer
import androidx.ui.material.Button
import androidx.ui.material.Colors
import androidx.ui.material.Divider
import androidx.ui.material.TextButtonStyle
import androidx.ui.material.surface.Card
import androidx.ui.material.themeTextStyle

// TODO: This is not integrated with the theme
internal val cardInternalColor = Color(0xFF33333D)

/**
 * The Alerts card within the Rally Overview screen.
 */
@Composable
fun RallyAlertCard() {
    Card(color = cardInternalColor) {
        Padding(padding = 12.dp) {
            Column(mainAxisSize = LayoutSize.Expand) {
                Row(
                    mainAxisSize = LayoutSize.Expand,
                    mainAxisAlignment = MainAxisAlignment.SpaceBetween
                ) {
                    Text(text = "Alerts", style = +themeTextStyle { subtitle2 })
                    Button(text = "See All", onClick = { }, style = TextButtonStyle())
                }
                Padding(padding = EdgeInsets(0.dp, 12.dp, 0.dp, 12.dp)) {
                    val colors = +ambient(Colors)
                    Divider(color = colors.surface, height = 2.dp)
                }
                FlexRow {
                    expanded(flex = 1.0f) {
                        val text = "Heads up, you've used up 90% of your " +
                                "Shopping budget for this month."
                        Text(
                            style = +themeTextStyle { body1 },
                            text = text
                        )
                    }
                    inflexible {
                        // TODO: icons still don't work
//                        <vectorResource res=context.resources
//                            resId=androidx.ui.material.studies.R.drawable.sort_icon/>
                        Button(text = "Sort", onClick = { }, style = TextButtonStyle())
                    }
                }
            }
        }
    }
}

/**
 * The Accounts card within the Rally Overview screen.
 */
@Composable
fun RallyAccountsCard() {
    Card(color = cardInternalColor) {
        Column(mainAxisSize = LayoutSize.Expand) {
            Padding(padding = 12.dp) {
                Column(mainAxisSize = LayoutSize.Expand) {
                    Text(text = "Accounts", style = +themeTextStyle { body1 })
                    Text(text = "$12,132.49", style = +themeTextStyle { h3 })
                }
            }
            Divider(color = rallyGreen, height = 1.dp)
            Padding(padding = 12.dp) {
                Column(mainAxisSize = LayoutSize.Expand) {
                    val colors = +ambient(Colors)
                    RallyAccountRow(
                        name = "Checking",
                        number = "1234",
                        amount = "2,215.13",
                        color = Color(0xFF005D57)
                    )
                    Divider(color = colors.surface, height = 2.dp)
                    RallyAccountRow(
                        name = "Home Savings",
                        number = "5678",
                        amount = "8,676.88",
                        color = Color(0xFF04B97F)
                    )
                    Divider(color = colors.surface, height = 2.dp)
                    RallyAccountRow(
                        name = "Car Savings",
                        number = "9012",
                        amount = "987.48",
                        color = Color(0xFF37EFBA)
                    )
                    Divider(color = colors.surface, height = 2.dp)
                    Button(text = "See All", style = TextButtonStyle())
                }
            }
        }
    }
}

/**
 * A row within the Accounts card in the Rally Overview screen.
 */
@Composable
fun RallyAccountRow(name: String, number: String, amount: String, color: Color) {
    Padding(padding = EdgeInsets(0.dp, 12.dp, 0.dp, 12.dp)) {
        FlexRow {
            inflexible {
                AccountIndicator(color = color)
                WidthSpacer(width = 8.dp)
                Column(
                    mainAxisSize = LayoutSize.Expand,
                    crossAxisAlignment = CrossAxisAlignment.Start
                ) {
                    Text(text = name, style = +themeTextStyle { body1 })
                    Text(text = "•••••$number", style = +themeTextStyle { subtitle1 })
                }
            }
            expanded(flex = 1.0f) {
                FixedSpacer(width = 0.dp, height = 0.dp)
            }
            inflexible {
                Text(text = "$ $amount", style = +themeTextStyle { h6 })
            }
        }
    }
}

/**
 * A vertical colored line that is used in a [RallyAccountRow] to differentiate accounts.
 */
@Composable
fun AccountIndicator(color: Color) {
    ColoredRect(color = color, width = 4.dp, height = 36.dp)
}

/**
 * The Bills card within the Rally Overview screen.
 */
@Composable
fun RallyBillsCard() {
    Card(color = cardInternalColor) {
        Column(mainAxisSize = LayoutSize.Expand) {
            Padding(padding = 12.dp) {
                Column(mainAxisSize = LayoutSize.Expand) {
                    Text(text = "Bills", style = +themeTextStyle { subtitle2 })
                    Text(text = "$1,810.00", style = +themeTextStyle { h1 })
                }
            }
        }
    }
}