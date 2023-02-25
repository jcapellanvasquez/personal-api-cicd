pipeline {
    agent any
    options {
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '5', daysToKeepStr: '', numToKeepStr: '5')
        disabledConcurrentBuilds()
    }
    stages {
        stage('Hello') {
            steps {
                script {
                    echo 'Hello'
                }
            }
        }
    }
}