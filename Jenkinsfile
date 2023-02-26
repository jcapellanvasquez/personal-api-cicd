def host = "143.198.136.156"
def user = "jenkins"
def app = "personal-api-cicd-0.0.1.jar"
pipeline {
    agent any
    options {
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '5', daysToKeepStr: '', numToKeepStr: '5')
        disableConcurrentBuilds()
    }
    tools {
        maven "maven-3.6"
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install pmd:pmd checkstyle:checkstyle'
            }
        }
        stage('for the PR') {
            when {
                branch 'PR-*'
            }
            steps {
                echo 'trigger on PR'
            }
        }
    }
    post {
        always {
            junit(
                allowEmptyResults: true,
                testResults: '**/target/surefire-reports/*.xml'
            )
            recordIssues(
                enabledForFailure: true,
                aggregatingResults: true,
                tools: [java(), checkstyle(pattern: '**/target/**/main.xml', reportEncoding: 'UTF-8')]
            )
        }
    }
}