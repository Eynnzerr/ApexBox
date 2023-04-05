pluginManagement {
    repositories {
        maven { setUrl("https://maven.aliyun.com/repository/public/") }
        maven { setUrl("https://maven.aliyun.com/repository/google/") }
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { setUrl("https://maven.aliyun.com/repository/central/") }

        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven { setUrl("https://maven.aliyun.com/repository/public/") }
        maven { setUrl("https://maven.aliyun.com/repository/google/") }
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { setUrl("https://maven.aliyun.com/repository/central/") }
        
        google()
        mavenCentral()
        // maven ("https://jitpack.io")
    }
}
rootProject.name = "ApexBox"
include (":app")
