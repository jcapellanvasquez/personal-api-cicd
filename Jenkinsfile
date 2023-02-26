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
        stage('Build and Test') {
            steps {
                sh 'mvn clean install pmd:pmd checkstyle:checkstyle'
            }
        }
        stage('Deploy') {
            when {
                branch 'master'
            }
            steps {
                sshagent(credentials: ['app-credentials']) {
                    sh """
                        ssh ${user}@${host} 'kill -9 \$(ps -aux | ${app} | awk '{print \$2}')'"
                    """
                    sh "scp target/${app} ${user}@${host}:/home/jenkins/${app}"
                    sh "ssh ${user}@${host} 'java -jar ${app} > ${app}.log 2>&1 &'"
                }
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
                tools: [
                    java(), checkStyle(pattern: '**/checkstyle-result.xml', reportEncoding: 'UTF-8'),
                    java(), pmdParser(pattern: '**/pmd.xml', reportEncoding: 'UTF-8'),
                    java(), spotBugs(pattern: '**/spotbugsXml.xml', reportEncoding: 'UTF-8'),
                ]
            )
        }
    }
}
