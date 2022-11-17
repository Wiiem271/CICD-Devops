pipeline {

  agent any
  tools {
     jdk 'JAVA_HOME'
     maven 'M2_HOME'
  }
  environment{
    DOCKERHUB_CREDENTIALS = credentials('dockerHub')
    NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "192.168.43.64:8081"
        NEXUS_REPOSITORY = "maven-nexus-repo"
        NEXUS_CREDENTIAL_ID = "nexus-user-credentials"
  }
  
  stages {
      stage('Checkout Git'){
            steps{
                echo 'Pulling...';
                git branch : 'taoufik',
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
       
    stage("Sonarqube Check") {
        steps {
          sh " mvn compile"
          sh ''' mvn sonar:sonar \
                    -Dsonar.host.url=http://localhost:9000 \
                    -Dsonar.login=4dcec4a3da03491f3866476018fc27d64995a7e0 '''

         }}
    stage('MVN PACKAGE') {
            steps {
                sh 'mvn -DskipTests clean package' 
            }
        }
    stage("Publish to Nexus Repository Manager") {
            steps {
                script {
                    pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    artifactPath = filesByGlob[0].path;
                    artifactExists = fileExists artifactPath;
                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        nexusArtifactUploader(
                            nexusVersion: NEXUS_VERSION,
                            protocol: NEXUS_PROTOCOL,
                            nexusUrl: NEXUS_URL,
                            groupId: pom.groupId,
                            version: pom.version,
                            repository: NEXUS_REPOSITORY,
                            credentialsId: NEXUS_CREDENTIAL_ID,
                            artifacts: [
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );
                    } else {
                        error "*** File: ${artifactPath}, could not be found";
                    }
                }
            }
        }
      stage('docker-compose up') {
      steps {
         sh 'echo "docker compose up -d ...."'
        sh 'docker ps'
        
      }
         }
    
  }
  
  
   post {
        success {
             mail to: "devops.a7laness@gmail.com",
                    subject: "Build sucess",
                    body: "sucess"
            echo 'successful'
        }
        failure {
             mail to: "devops.a7laness@gmail.com",
                    subject: "Build failed",
                    body: "failed"
            echo 'failed'
        }
      }
    
}    
