object Compose {

    private const val activityComposeVersion = "1.5.1" //1.7.1
    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"

    const val compilerVersion = "1.3.2"

    private const val composeBomVersion = "2022.10.00" //mudar para o mais recente
    const val composeBom = "androidx.compose:compose-bom:$composeBomVersion"
    const val ui = "androidx.compose.ui:ui"
    const val uiGraphics = "androidx.compose.ui:ui-graphics"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val material3 = "androidx.compose.material3:material3"

    private const val navigationVersion = "2.4.0-beta02"
    const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"

    private const val hiltNavigationComposeVersion = "1.0.0-beta01"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"

    private const val lifecycleVersion = "2.4.0"
    const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"
}