# MyWeather
Тестовое приложение для отслеживания погоды
# API:
https://api.openweathermap.org/data/2.5/
# Основные функции:
1. Возможность получение данных о погоде
2. Возможность ввода города для получения данных
# Screenshot:
![Screenshot_20221201_182734](https://user-images.githubusercontent.com/103441009/205093957-71975e9c-d7f4-4a37-82f6-e3bbd346cf53.png)
![Screenshot_20221201_182802](https://user-images.githubusercontent.com/103441009/205093961-be5d07f5-a8fa-4f00-9e3b-73dffc52cd29.png)
# Stack:
    def lifecycle_version = "2.5.0-rc01"
    def retrofit_version = "2.9.0"
    def coroutines_version = "1.6.2"
    def gson_version = "2.9.0"
    def koin_version = "3.2.0"
    def nav_version = "2.5.3"

    // ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    // LiveData
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
    // Retrofit
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    // Coroutines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"
    // Gson
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    // Gson_Converter
    implementation "com.google.code.gson:gson:$gson_version"
    // Koin
    implementation "io.insert-koin:koin-android:$koin_version"
    // JetpackNavigation
    implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
    implementation "androidx.navigation:navigation-ui-ktx:$nav_version"
