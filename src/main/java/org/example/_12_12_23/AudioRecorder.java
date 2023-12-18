package org.example._12_12_23;

public class AudioRecorder extends AudioPlayer implements Recordable, Playable {
    @Override
    public void record() {
      System.out.println("recording started");
    }

    public void stopRecording() {
      System.out.println("recording stopped");
    }

}
