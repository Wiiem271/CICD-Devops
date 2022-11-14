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
                git branch : 'chebbichaima',
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
    stage('Mvn compile stage') {
                steps {
                sh 'mvn compile'
                    
                }
                
            }
        stage('Mvn package stage'){
                steps{
                sh 'mvn package -DskipTests'
                    
                }
                
            } 
     stage('SonarQube stage') {
          
            steps {
            sh'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=chichi1918'
               
            }
        } 
    stage('Nexus stage') {
          
            steps {
           sh 'mvn deploy -e -DskipTests'
               
            }
        }
    /*
  stage('Docker build') {
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
  } 
  */
    stage('Junit Testing') {
      steps {
         sh 'echo "Junit Test is processing ...."'
        sh 'mvn  test'

      }
    }
  
  
  
   stage('Docker compose stage') {
          
            steps {
            sh 'docker-compose up -d'
               
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
