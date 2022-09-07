pipeline{
    agent { label 'master'}
    stages{
        stages('test'){
            steps{
                 sh "mvn clean compile test"
            }
           
        }

        stages('Build application'){
            steps{
                echo "Running application"
            }
        }
    }
}