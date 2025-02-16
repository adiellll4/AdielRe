pipeline {
    agent any

    parameters {
        string(name: 'NAME', defaultValue: 'John Doe', description: 'Enter your name')
        string(name: 'DAY_OF_BIRTH', defaultValue: '15', description: 'Enter your birth day (1-31)')
    }

    environment {
        OUTPUT_FILE = 'output.html'
    }

    stages {
        stage('Process User Input') {
            steps {
                script {
                    // טעינת סקריפט Groovy והפעלת הפונקציה עם המשתנים
                    def scriptPath = 'AdielScript.groovy'  // שים לב למיקום הסקריפט שלך
                    def outputMessage = load(scriptPath).processUserInput(params.NAME, params.DAY_OF_BIRTH)

                    // כתיבת פלט ל-HTML
                    writeFile file: OUTPUT_FILE, text: """
                        <html>
                        <head><title>Jenkins Output</title></head>
                        <body>
                        ${outputMessage}
                        </body>
                        </html>
                    """
                }
            }
        }

        stage('Display Parameter') {
            steps {
                script {
                    currentBuild.description = "User's Name: ${params.NAME}, Birth Day: ${params.DAY_OF_BIRTH}"
                }
            }
        }

        stage('Verify Parameter on Web Page') {
            steps {
                script {
                    def description = currentBuild.description
                    if (description.contains("${params.NAME}") && description.contains("${params.DAY_OF_BIRTH}")) {
                        echo "Parameters are correctly displayed on the web page."
                    } else {
                        error "Parameters are not displayed correctly on the web page."
                    }
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: OUTPUT_FILE, fingerprint: true
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: '.',
                reportFiles: OUTPUT_FILE,
                reportName: 'User Input and Birth Day Output'
            ])
        }
    }
}
