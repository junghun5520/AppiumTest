pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Program Files\\Android\\Android Studio\\jbr' 
        ANDROID_HOME = 'C:\\Users\\WW\\AppData\\Local\\Android\\Sdk'
        // 메이븐(Maven) 경로가 PATH에 없다면 아래에 메이븐 bin 경로도 추가하세요.
        PATH = "${JAVA_HOME}\\bin;${ANDROID_HOME}\\platform-tools;${env.PATH}"
    }

    stages {
        stage('Step 1: 기기 연결 확인') {
            steps {
                bat 'adb devices'
            }
        }

        stage('Step 2: 빌드') {
            steps {
                // 루트에 pom.xml이 있으므로 바로 실행
                bat 'mvn clean compile'
            }
        }

        stage('Step 3: 테스트 실행') {
            steps {
                // Appium 서버는 별도 터미널에서 켜져 있어야 합니다.
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            junit(allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml')
        }
    }
}

