pipeline {
   agent any
  stages {
    stage('Checkout') {
       steps {
               git 'https://github.com/SubhashiniPenumatsa/fooproject/'
          }
     }
	  stage ('Code Analysis') {
              steps {
                     sh "mvn pmd:pmd"
					 sh "mvn checkstyle:checkstyle"
					 sh "mvn findbugs:findbugs"
                }
            }
      stage ('Build') {
              steps {
                     sh "mvn compile"
                }
            }
			stage ('Code Coverage') {
              steps {
                     jacoco changeBuildStatus: true, runAlways: true, skipCopyOfSrcFiles: true
                }
			}
			
		
      stage('Test') {
                steps {
                        sh "mvn test"
                     }
         post {
		 
			success{ gerritReview score:1}
			failure{ gerritReview score:-1}
            always {
                  junit '**/target/surefire-reports/TEST*.xml'
              }
           }
        }
		
		stage('newman') {
            steps {
                sh 'newman run Restful_Booker.postman_collection.json --environment Restful_Booker.postman_environment.json --reporters junit'
            }
            post {
                always {
                        junit '**/*xml'
                    }
                }
        }
		
		 stage('Robot') {
            steps {
                sh 'robot --variable BROWSER:headlesschrome -d Results Tests'
            }
            post {
                always {
                    script {
                        step(
                            [
                                $class                  :   'RobotPublisher',
                                outputPath              :   'Results',
                                outputFileName          :   '**/output.xml',
                                reportFileName          :   '**/report.html',
                                logFileName             :   '**/log.html',
                                disableArchiveOutput    :   false,
                                passThreshold           :   50,
                                unstableThreshold       :   40,
                                otherFiles              :   "**/*.png,**/*.jpg",
                            ]
                        )
                    }
                }
            }
                 
        }
		
      }
    }