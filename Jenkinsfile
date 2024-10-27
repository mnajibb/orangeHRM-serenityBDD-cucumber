pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'serenity-bdd-image'
    }

    stages {
        stage('Checkout Code') {
            steps {
                // Replace this with your repository URL
                git url: 'https://github.com/your-repo/your-serenity-project.git', branch: 'main'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image for the project
                    docker.build("${DOCKER_IMAGE}", '.')
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    // Run Docker container with the test command
                    docker.image("${DOCKER_IMAGE}").inside {
                        sh 'mvn clean verify -Dcucumber.options="--tags @yourTag"'
                    }
                }
            }
        }
    }

    post {
        always {
            // Archive Serenity test results and screenshots
            archiveArtifacts artifacts: 'target/site/serenity/*'
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/site/serenity',
                reportFiles: 'index.html',
                reportName: 'Serenity Test Report'
            ])
        }
    }
}
