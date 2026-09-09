pipeline {
    agent any

    tools {
        maven 'Maven 3.8'
        jdk 'JDK-25'
    }

    stages {
        stage('Run Automated Tests') {
            steps {
                bat 'mvn clean test -Dheadless=true'
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