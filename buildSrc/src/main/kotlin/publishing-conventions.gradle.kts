import java.lang.System.getenv
import java.util.Base64

plugins {
    `maven-publish`
    signing
}

fun MavenPublication.registerDokkaJar() = tasks.register<Jar>("${name}dokkaJar") {
    archiveClassifier.set("javadoc")
    destinationDirectory = destinationDirectory.get().dir(name)
    from(tasks.named("dokkaHtml"))
}

publishing {
    publications {
        withType<MavenPublication>().configureEach {
            artifact(registerDokkaJar())
            groupId = Project.GROUP
            artifactId = artifactId
            version = Project.VERSION

            pom {
                name = Project.NAME
                description = Project.DESCRIPTION
                url = URLs.GITHUB_URL

                developers {
                    developer {
                        name = "kiNgchev"
                    }
                }

                issueManagement {
                    system = "GitHub"
                    url = URLs.ISSUES_URL
                }

                licenses {
                    license {
                        name = "MIT"
                        url = URLs.LICENSE_URL
                    }
                }

                scm {
                    connection = URLs.SCM_URL
                    developerConnection = URLs.SCM_URL
                    url = URLs.GITHUB_URL
                }
            }
        }

        repositories {
            maven {
                name = "OSSRH"
                url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
                credentials {
                    username = getenv("NEXUS_USER")
                    password = getenv("NEXUS_PASSWORD")
                }
            }

            maven {
                name = "GitHubPackages"
                url = uri("")
                credentials {
                    username = getenv("GITHUB_ACTOR")
                    password = getenv("GITHUB_TOKEN")
                }
            }
        }
    }
}

signing {
    val secretKey = getenv("SIGNING_KEY")?.let { String(Base64.getDecoder().decode(it)) }
    val password = getenv("SIGNING_PASSWORD")
    useInMemoryPgpKeys(secretKey, password)
    sign(publishing.publications)
}