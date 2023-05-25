pipeline {
    agent any
    triggers {
        githubPush()
    }
    stages {
        stage('checkout GIT') {
            steps {
                echo 'Pulling ...'
                git branch: 'main',
                    url: 'https://github.com/Npcscan/DevOpsKhelifi.git'
            }
        }
        stage('Affichage de la date système') {
            steps {
                echo "${env.DATE}"
            }
        }
        stage('maven version') {
            steps {
                bat 'mvn -version'
            }
        }
        stage('Maven Clean') {
            steps {
                bat 'mvn clean -U'
            }
        }

        stage('Maven Compile') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Construction du livrable') {
            steps {
                bat 'mvn compiler:compile'
            }
        }
        stage('Maven test') {
            steps {
                bat 'mvn test'
            }
        }
    }
}