pipeline {
    agent any

    tools {
        maven 'Maven-3.9.0'
        jdk 'JDK-17'
    }

    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Run Automated Tests') {
            steps {
                // Σε περιβάλλον Windows χρησιμοποιούμε bat αντί για sh
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