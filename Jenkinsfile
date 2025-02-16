pipeline {
    agent any

    parameters {
        string(name: 'NAME', defaultValue: 'Enter name', description: 'Enter your name')
        string(name: 'DAY_OF_BIRTH', defaultValue: '15', description: 'Enter your birth day (1-31)')
    }

    environment {
        OUTPUT_FILE ='output.html'
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
            // שימוש ב-plugin HTML Publisher כדי להציג את הפלט
            publishHTML(target: [
                reportName: 'User Data Output', // שם הדוח שיתקבל ב-Jenkins
                reportFiles: 'output.html', // הקובץ שהפקנו
                reportDir: '.', // ספריית העבודה הנוכחית שבה נוצר הקובץ
                keepAll: true, // שימור כל הדוחות הקודמים
                allowMissing: false // לא לאפשר דוח חסר
            ])
        }
    }
}


