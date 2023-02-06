pipeline {
    agent any

    stages {
        stage('docker build') {
            steps {
                script {
                    sh "echo ${BUILD_ID}"
                }
            }
        }
    }
}