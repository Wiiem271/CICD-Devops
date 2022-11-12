pipeline {

  agent any
  tools {
     jdk 'JAVA_HOME'
     maven 'M2_HOME'
  }
  environment{
    DOCKERHUB_CREDENTIALS = credentials('dockerHub')
    NEXUS_CREDENTIALS = credentials('nexus')
    NEXUS_VERSION = "nexus3"
    NEXUS_PROTOCOL = "http"
    NEXUS_URL = "localhost:8081"
    NEXUS_CREDENTIAL_ID = "nexus"
    NEXUS_REPOSITORY= "https://github.com/Wiiem271/devops1"
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
	  stage("Build") {
steps {
sh " mvn compile"
}}
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
sh ''' mvn sonar:sonar \
                    -Dsonar.host.url=http://localhost:9000 \
                    -Dsonar.login=64cc95cb7f0a69246acea3e81f9ff694ac6b29b4 '''

}}
        
	stage('Deploy to Nexus') {
              steps {
                script {
					nexusArtifactUploader artifacts: [[artifactId: 'tpAchatProject',
                     classifier: '', file: 'target/tpAchatProject-1.0.jar', type: 'jar']],
                      credentialsId: 'nexus', 
                      groupId: 'com.esprit.examen', 
                      nexusUrl: 'http://localhost:8081',
                       nexusVersion: 'nexus3', 
                       protocol: 'http', 
                       repository: 'maven-snapshots',
                        version: '1.0.6-SNAPSHOT'
				}
               
            }
          
	}	
    
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
