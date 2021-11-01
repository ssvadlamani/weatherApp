node {
    def app
    def jenkinsBuildId = "${env.BUILD_ID}"
    sh "echo ${jenkinsBuildId}"

    stage('Clone GitHub repository') {
        checkout scm
    }
    stage('Build Docker image') {
        app = docker.build('sivasankarvadlamani/weatherapp')
    }
    stage('Check Docker image') {   
        app.withRun('') { c ->
            sh "docker port ${c.id}"
        }
    }
    stage('Push image to Container Registry') {
        docker.withRegistry('https://registry.hub.docker.com', 'weather') {
            app.push()
            app.push("${jenkinsBuildId}")
        }
    }
   
}
