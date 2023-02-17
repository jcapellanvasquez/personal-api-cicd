//pipeline {
//    agent any
//    environment {
//        DOCKERHUB_CREDENTIALS = credentials('dockerhub')
//    }
//    stages {
//        stage('docker build') {
//            steps {
//                script {
//                    sh "docker build -t jcapellan/personal-api-cicd:0.0.1-${BUILD_ID} ."
//                }
//            }
//        }
//        // insecure way to handle this login, just for test only
//        stage('login dockerhub') {
//            steps {
//                script {
//                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
//                }
//            }
//        }
//        stage('docker push') {
//            steps {
//                script {
//                    sh "docker push jcapellan/personal-api-cicd:0.0.1-${BUILD_ID}"
//                }
//            }
//        }
//    }
//}