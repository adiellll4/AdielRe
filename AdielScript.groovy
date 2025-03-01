def processUserInput(String name, String dayOfBirth) {
    name = name.trim()
    dayOfBirth = dayOfBirth.trim()

    def outputMessage = ""

    // בדוק אם השם מכיל רק אותיות ורווחים
    if (!(name ==~ /^[A-Za-z\s]+$/)) {
        outputMessage = "<h2 style='color:red;'>Invalid Input: Name must contain only letters and spaces.</h2>"
        echo "Invalid name input!"
    } 
    // בדוק אם יום הלידה הוא מספר בין 1 ל-31
    else if (!(dayOfBirth.isInteger() && dayOfBirth.toInteger() >= 1 && dayOfBirth.toInteger() <= 31)) {
        outputMessage = "<h2 style='color:red;'>Invalid Input: Day of birth must be a number between 1 and 31.</h2>"
        echo "Invalid day of birth input!"
    } 
    else {
        // אם כל הקלטים תקינים, הצג את השם ויום הלידה
        outputMessage = "<h2>Hello ${name}!</h2><p>Your birth day is: <strong>${dayOfBirth}</strong></p>"
        echo "Valid input. Day of birth: ${dayOfBirth}"
    }

    return outputMessage
}

return this  // מאפשר לטעון את הסקריפט ולהשתמש בפונקציה מחוץ לו



