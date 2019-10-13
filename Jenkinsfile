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
        stage('Install') {
            steps {
                sh 'rm ./piros-core-1.0.1.jar || true'
                sh 'wget https://github.com/Binarysearch/piros-core/releases/download/1.0.1/piros-core-1.0.1.jar'
                sh 'mvn install:install-file -Dfile=./piros-core-1.0.1.jar -DgroupId=org.piros -DartifactId=core -Dversion=1.0.1 -Dpackaging=jar'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test and verify') {
            steps {
                sh 'mvn verify'
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