@FunctionalInterface
interface LightAction {
    void activate();
}

public class SmartHomeLighting {
    public static void main(String[] args) {
        LightAction motionTrigger = () -> System.out.println("Motion detected! Turning ON hallway lights.");
        LightAction eveningTrigger = () -> System.out.println("Evening mode: Setting warm white lights in living room.");
        LightAction voiceCommand = () -> System.out.println("Voice command received: Activating party lights pattern.");
        activateLight(motionTrigger);
        activateLight(eveningTrigger);
        activateLight(voiceCommand);
        activateLight(() -> System.out.println("Morning mode: Opening blinds and turning ON kitchen lights."));
    }

    public static void activateLight(LightAction action) {
        action.activate();
    }
}
