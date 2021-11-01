node {    
      def app     
      stage('Clone repository') { 
            withCredentials([string(credentialsId: 'dockerpws', variable: 'TOKEN')]) 
            {
                  bat '''docker login -u 'sivasankarvadlamani' -p '<$TOKEN>' '''
            }
           
            checkout scm    
      }  
      stage('Compile and build application') {
                bat 'mvn clean install -Dmaven.test.skip=true'
    }
      stage('Build image') {  
            bat 'docker build -t weatherapp .'
            bat 'docker tag weatherapp sivasankarvadlamani/weatherapp'   
       } 
           
       stage('Push image') {
             
       bat 'Get-Content password.txt  | docker login --username sivasankarvadlamani --password-stdin https://registry.hub.docker.com' 
       bat 'docker push sivasankarvadlamani/weatherapp:build'
   }
}       
