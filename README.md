# AdielRe
# Jenkins User Input Processing Pipeline

## תיאור
פרויקט זה כולל צינור עבודה (pipeline) ב-Jenkins שמבצע עיבוד של קלט מהמשתמש. המשתמש מתבקש להזין את שמו ואת יום הלידה שלו, והצינור מחזיר את המידע בצורה של HTML, כולל חישוב של שנת הלידה הצפויה.

## דרישות מערכת
לפני שתוכל להפעיל את הצינור הזה, עליך לוודא שיש לך את התנאים הבאים:
- **Jenkins** מותקן ומוגדר.
- **Jenkins Groovy Plugin** מותקן ומופעל.
- **NodeJS** מותקן אם אתה משתמש ב-NPM ליצירת HTML.
  
## הגדרת הפרויקט
הפרויקט כולל שני קבצים עיקריים:
1. **Jenkinsfile** - קובץ הצינור (Pipeline) של Jenkins שמבצע את כל הפעולות.
2. **AdielScript.groovy** - סקריפט Groovy שמבצע את עיבוד הקלט ומחזיר את הפלט המתאים.

### Jenkinsfile
ה-Jenkinsfile מכיל את כל השלבים של הצינור:
- הוא מקבל את שם המשתמש ויום הלידה כפרמטרים.
- מפעיל את הסקריפט `AdielScript.groovy` שמבצע את העיבוד.
- יוצר קובץ HTML עם הפלט שמוצג למשתמש.

### AdielScript.groovy
הסקריפט `AdielScript.groovy` מקבל את השם ויום הלידה, מבצע בדיקות תקינות (רק אותיות בשם ויום לידה בין 1 ל-31), ומחזיר את התוצאה בצורה HTML.

## התקנה ושימוש
### 1. הגדרת פרמטרים ב-Jenkins
בעת יצירת הצינור ב-Jenkins, ודא שאתה מגדיר את הפרמטרים הבאים:
- **NAME** - השם של המשתמש (נדרש להזין רק אותיות).
- **DAY_OF_BIRTH** - יום הלידה (נדרש להזין מספר בין 1 ל-31).

### 2. הוראות לביצוע Pipeline
- כאשר אתה מריץ את הצינור, הוא יבקש מהמשתמש להזין את שמו ויום הלידה.
- הפלט המתקבל ייצא כקובץ HTML עם הודעה מותאמת אישית.
  
הקוד ב-Jenkinsfile משתמש בסקריפט Groovy כדי לבצע את הבדיקות ולהחזיר את הפלט המתאים. את הקובץ `output.html` המתקבל תוכל לראות ב-**Post-build Actions** של Jenkins.

## דוגמת פלט
אם המשתמש מזין את השם "עדיאל" ואת יום הלידה "15", הפלט המתקבל יהיה:
```html
<html>
<head><title>Jenkins Output</title></head>
<body>
<h2>Hello עדיאל!</h2>
<p>Your estimated birth year is: <strong>2009</strong></p>
</body>
</html>
