package org.example.lottogame.message;

public class MessageProvider {
    public static final String WELCOME_MSG = "Welcome in Lotto Game.";
    public static final String PROVIDE_NUMBERS = "Please provide %d numbers from %d to %d.";
    public static final String READ_NUMER = "%d NUMBER: ";
    public static final String INVALID_NUMBER = "Please, give number from %d to %d.";
    public static final String RESULT_INFO = "You get %d hits. Winning numbers: %s vs Your numbers: %S .";
    public static final String EXCEPITON_INFO = "Please, give NUMBER.";
    private MessageProvider() {
        throw new IllegalStateException("Utility class");
    }
}
