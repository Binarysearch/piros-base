pipeline {
    agent {
        docker {
            image 'binarysearch/maven-with-docker-alpine:0.0.1'
        }
    }
    environment {
        DOCKER_USER = 'binarysearch'
        DOCKER_REPOSITORY = 'piros-base'
        DOCKER_NETWORK_NAME = 'dev_enviroment_default'

        DOCKER_CONTAINER_NAME_DEV = 'piros-base-dev'
        DOCKER_NETWORK_ALIAS_DEV = 'piros-base-dev'

        DOCKER_CONTAINER_NAME = 'piros-base'
        DOCKER_NETWORK_ALIAS = 'piros-base'
    }
    stages {
        stage('Build') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'maven-password', variable: 'MAVEN_PASSWORD')]) {
                        sh 'mvn clean compile -s settings.xml -Dpassword=${MAVEN_PASSWORD}'
                    }
                }
            }
        }
        stage('Test and verify') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'maven-password', variable: 'MAVEN_PASSWORD')]) {
                        sh 'mvn verify -s settings.xml -Dpassword=${MAVEN_PASSWORD}'
                    }
                }
            }
        }
        stage('Deliver dev') {
            when {
                expression {
                    return env.BRANCH_NAME == 'develop'
                }
            }
            steps {
                script {
                    withCredentials([string(credentialsId: 'docker-password', variable: 'DOCKER_PASS')]) {
                        sh 'docker login --username=${DOCKER_USER} --password=${DOCKER_PASS}'
                    }
                    sh 'docker build --build-arg api_version_arg=dev --rm -f Dockerfile -t ${DOCKER_USER}/${DOCKER_REPOSITORY}:dev .'
                    sh 'docker push ${DOCKER_USER}/${DOCKER_REPOSITORY}:dev'
                    sh 'docker container rm ${DOCKER_CONTAINER_NAME_DEV} -f || true'
                    sh 'docker run -d --network=${DOCKER_NETWORK_NAME} --network-alias=${DOCKER_NETWORK_ALIAS_DEV} --name=${DOCKER_CONTAINER_NAME_DEV} ${DOCKER_USER}/${DOCKER_REPOSITORY}:dev'
                }
            }
        }
        stage('Deliver') {
            when {
                expression {
                    return env.BRANCH_NAME == env.TAG_NAME
                }
            }
            steps {
                script {
                    withCredentials([string(credentialsId: 'docker-password', variable: 'DOCKER_PASS')]) {
                        sh 'docker login --username=${DOCKER_USER} --password=${DOCKER_PASS}'
                    }
                    sh 'docker build --build-arg api_version_arg=${TAG_NAME} --rm -f Dockerfile -t ${DOCKER_USER}/${DOCKER_REPOSITORY}:${TAG_NAME} .'
                    sh 'docker push ${DOCKER_USER}/${DOCKER_REPOSITORY}:${TAG_NAME}'
                    sh 'docker container rm ${DOCKER_CONTAINER_NAME} -f || true'
                    sh 'docker run -d --network=${DOCKER_NETWORK_NAME} --network-alias=${DOCKER_NETWORK_ALIAS} --name=${DOCKER_CONTAINER_NAME} ${DOCKER_USER}/${DOCKER_REPOSITORY}:${TAG_NAME}'
                }
            }
        }
    }
}