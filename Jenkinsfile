
node {    
      def app     
      stage('Clone repository') {               
             
            checkout scm    
      }  
      stage('Compile and build application') {
        withMaven(maven : 'apache-maven-3.6.1') {
                bat'mvn clean install'
            }

    }
      stage('Build image') {         
       
            app = docker.build("sivasankarvadlamani/weatherapp")    
       } 
           
       stage('Push image') {
       docker.withRegistry('https://registry.hub.docker.com', 'weather') {            
       app.push("${env.BUILD_NUMBER}")            
       app.push("latest")        
              }    
           }
        }
