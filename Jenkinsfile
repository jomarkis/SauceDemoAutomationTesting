pipeline {
    agent any

    tools {
        maven 'Maven 3.8'
        jdk 'JDK-25'
    }

    stages {
            stage('Run Automated Tests') {
                steps {
                    script {
                        def cmd = "mvn clean test -Dheadless=true -Dbrowser=%BROWSER%"

                        def selectedTag = env.CUCUMBER_TAGS
                        if (selectedTag != null && !selectedTag.contains("All tests") && selectedTag.trim() != "") {
                            cmd += " -Dcucumber.filter.tags=\"${selectedTag}\""
                        }

                        bat cmd
                    }
                }
            }
        }

    post {
        always {
            publishHTML(target: [
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/cucumber-reports',
                reportFiles: 'cucumber.html',
                reportName: 'Cucumber Test Report'
            ])
        }
        success {
            echo 'All test scenarios passed successfully!'
        }
        failure {
            echo 'Test execution completed with failures. Inspect reports for root causes.'
        }
    }
}