pipeline {

  agent any
  tools {
     jdk 'JAVA_HOME'
     maven 'M2_HOME'
  }
  environment{
    DOCKERHUB_CREDENTIALS = credentials('dockerHub')
  }
  stages {
      stage('Checkout Git'){
            steps{
                echo 'Pulling...';
                git branch : 'main',
                url : 'https://github.com/Wiiem271/devops1.git'
            }
        }
    stage ('Check Tools Initializing') {
            steps {
                sh 'java --version'
                sh 'mvn --version'
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage('Cleaning the Project') {
         steps {
          sh 'echo "Clean the Project is processing ...."'
          sh 'mvn clean'
           }
    }
 /*stage('Docker build') {
    agent any
      steps {
        sh 'echo "building docker...."'
      sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/tpachat1 .'
      }
  }
    stage('Login'){
      agent any
      steps{
        sh 'docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW '
      }
    }
    
   stage('Docker push') {
    agent any
      steps {
        sh 'echo "Docker is pushing ...."'
      sh 'docker push $DOCKERHUB_CREDENTIALS_USR/tpachat1'
      }
  } */
   
  stage("Sonar") {
steps {
sh " mvn  -f Spring/pom.xml clean install sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=64cc95cb7f0a69246acea3e81f9ff694ac6b29b4"


}}
        
		
    
    stage('Junit Testing') {
      steps {
         sh 'echo "Junit Test is processing ...."'
        sh 'mvn  test'

      }
    }
  
  }
   post {
        success {
             mail to: "devops.2223@gmail.com",
                    subject: "Build sucess",
                    body: "sucess"
            echo 'successful'
        }
        failure {
             mail to: "devops.2223@gmail.com",
                    subject: "Build failed",
                    body: "failed"
            echo 'failed'
        }
      }
    
}    
