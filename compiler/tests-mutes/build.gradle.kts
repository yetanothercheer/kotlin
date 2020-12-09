plugins {
    kotlin("jvm")
    id("jps-compatible")
    application
}

dependencies {
    api(kotlinStdlib())
}

sourceSets {
    "main" { projectDefault() }
    "test" {}
}
