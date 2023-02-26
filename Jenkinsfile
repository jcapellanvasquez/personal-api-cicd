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
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven-3.6"
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests pmd:pmd checkstyle:checkstyle'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
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
}