import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class QuizApplication {
    private static Timer timer;
    private static int timeLimit = 30;
    private static boolean timesUp = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Question ask
        String[] questions = {
                "What is the capital of France?",
                "What is 2 + 2?",
                "What is the largest planet in our solar system?"
        };
         // Your Answer
        String[] answers = {
                "Paris",
                "4",
                "Jupiter"
        };

        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            timesUp = false;
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            startTimer();

            String userAnswer = scanner.nextLine();

            // Check the timer ran out
            if (timesUp) {
                System.out.println("Time's up! You didn't answer this question.");
            } else if (userAnswer.equalsIgnoreCase(answers[i])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong answer.");
            }

            System.out.println("Your current score: " + score);
        }

        System.out.println("Quiz ended. Your final score: " + score);
        stopTimer();
    }

    private static void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                timesUp = true;
                stopTimer();
            }
        }, timeLimit * 1000);
    }

    private static void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
    }
}
