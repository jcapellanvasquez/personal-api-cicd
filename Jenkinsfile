pipeline {
    agent any

    stages {
        stage('docker build') {
            steps {
                script {
                    sh "docker build -t jcapellan/personal-api-cicd:0.0.1-${BUILD_ID} ."
                }
            }
        }
    }
}