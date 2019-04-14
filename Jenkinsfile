node () {
    stage ('Git Checkout') {
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/pennh/HelloWorld.git']]])
    }

    stage ('Build and test') {
        docker.image('maven:3-alpine').inside('') {
            sh """mvn -B package
                mkdir -p pkg
                cp target/HelloWorld.war pkg/"""
        }
    }

    stage('Build image & Run') {
        sh "docker build . -t hello-world"

        // Get results with: http://localhost:8081/HelloWorld/index.jsp
        try {
            timeout(time: 3, unit: 'MINUTES') {
                sh "docker run --rm -p 8081:8080 -t hello-world"
            }
        } catch (Exception exc) {
            echo "Got exception: " + exc
            if (exc.toString().indexOf("exit code 143") >= 0) {
               // failed on timeout
               currentBuild.result = "SUCCESS"
            }
            try {
                sh "docker rm \$(docker stop \$(docker ps -q --filter ancestor=hello-world))"
            } catch (Exception exc2) {
                // ignore docker stop or rm failures
                currentBuild.result = "SUCCESS"
            }
        }
    }
}       
