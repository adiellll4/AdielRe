pipeline {
    agent any

    parameters {
        string(name: 'NAME', defaultValue: 'Enter name', description: 'Enter your name')
        string(name: 'DAY_OF_BIRTH', defaultValue: '15', description: 'Enter your birth day (1-31)')
    }

    stages {
        stage('Process User Input') {
            steps {
                script {
                    // כאן יש לטעון את הסקריפט שבו הגדרת את הפונקציה
                    def scriptPath = 'AdielScript.groovy'
                    def outputMessage = load(scriptPath).processUserInput(params.NAME, params.DAY_OF_BIRTH)

                    // יצירת קובץ HTML להדפסת התוצאה
                    writeFile file: 'output.html', text: """
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
    }

    post {
        always {
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: '',
                reportFiles: 'output.html',
                reportName: 'User Data Output'
            ])
        }
    }
}



// pipeline {
//     agent any

//     parameters {
//         string(name: 'NAME', defaultValue: 'John Doe', description: 'Enter your name')
//         string(name: 'AGE', defaultValue: '30', description: 'Enter your age')
//     }

//     stages {
//         stage('Process User Input') {
//             steps {
//                 script {
//                     def scriptPath = 'AdielScript.groovy'
//                     def outputMessage = load(scriptPath).processUserInput(params.NAME, params.AGE)

//                     writeFile file: 'output.html', text: """
//                         <html>
//                         <head><title>Jenkins Output</title></head>
//                         <body>
//                         ${outputMessage}
//                         </body>
//                         </html>
//                     """
//                 }
//             }
//         }
//     }

//     post {
//         always {
//             publishHTML(target: [
//                 allowMissing: false,
//                 alwaysLinkToLastBuild: true,
//                 keepAll: true,
//                 reportDir: '',
//                 reportFiles: 'output.html',
//                 reportName: 'User Data Output'
//             ])
//         }
//     }
// }
